package org.snaker.framework.cache;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 简单缓存类：适合于单server缓存
 * 暂时不支持集群同步
 * @author yuqs
 */
public class Cache
{
    private final static Log log = LogFactory.getLog(Cache.class);
    
    /**
     * 缓存容器
     */
    protected Map<String, CacheObject> data = new HashMap<String, CacheObject>();

    /**
     * 默认最大失效时间
     */
    protected long maxLifetime;

    /**
     * 单态实例控制
     */
    private static Cache defaultCache = new Cache();

    /**
     * 缓存对象
     * @author yuqs
     */
    private static class CacheObject implements Serializable
    {
        /**
	 * 
	 */
	private static final long serialVersionUID = 1769054393780598536L;
	//缓存对象
	public Object object;
		//缓存对象产生时间
        public long timeCreated;
        //缓存对象超时时间
        public long timeout;

        public CacheObject(Object object, long timeout)
        {
            this.object = object;
            timeCreated = System.currentTimeMillis();
            this.timeout = timeout;
        }
    }

    private Cache()
    {
        maxLifetime = 1000 * 60 * 5; //5 minitus   
    }

    public long getMaxLifeTime()
    {
        return maxLifetime;
    }

    public Cache setMaxLifeTime(long value)
    {
        maxLifetime = value;
        return this;
    }

    public static Cache getCache()
    {
        return defaultCache;
    }

    /**
     * 向缓存中保存指定的key、value键值对。永久有效
     * @param key
     * @param value
     * @return
     */
    public synchronized Cache put(String key, Object value)
    {
        log.debug("Cache: add object(" + key + ":" + value + ")");
        return put(key, value, -1);
    }

    /**
     * 向缓存中保存指定的key、value键值对，并且在timeout时限后，刷出缓存
     * @param key
     * @param value
     * @param timeout
     * @return
     */
    public synchronized Cache put(String key, Object value, long timeout)
    {
        CacheObject obj = new CacheObject(value, timeout);
        data.put(key, obj);
        log.debug("Cache: add object(" + key + ":" + value + ")");
        return this;
    }

    /**
     * 根据键获取匹配的值，如果超过时限，则删除数据，并且返回null
     * @param key
     * @return
     */
    public synchronized Object get(String key)
    {
        CacheObject obj = (CacheObject) data.get(key);

        if(obj == null)
        {
            return null;
        }

        long t = System.currentTimeMillis();
        if(obj.timeout <= 0 || t - obj.timeCreated <= obj.timeout)
        {
            return obj.object;
        }

        //timeout   
        data.remove(key);
        obj.object = null;
        obj = null;

        return null;
    }
}
