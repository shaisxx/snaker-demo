package org.snaker.framework.cache;

import java.util.Map;

/**
 * 缓存管理器
 * @author yuqs
 */
public class CacheManager {
	/**
	 * 向缓存中添加对象
	 * @param key
	 * @param content
	 */
	public static void put(String key, Object content) {
		Cache.getCache().put(key, content);
	}
	
	/**
	 * 根据key获取缓存value
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return Cache.getCache().get(key);
	}
	
	/**
	 * 根据key获取配置缓存value(约定配置value为Map)
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getConfig(String key, String code) {
		Object config = Cache.getCache().get(key);
		if(config != null && config instanceof Map) {
			return (String)((Map)config).get(code);
		}
		return "";
	}
}
