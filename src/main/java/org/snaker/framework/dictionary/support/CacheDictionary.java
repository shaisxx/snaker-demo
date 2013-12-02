package org.snaker.framework.dictionary.support;

import java.util.Map;

import org.snaker.framework.cache.CacheManager;
import org.snaker.framework.dictionary.AbstractDictionary;
import org.snaker.framework.dictionary.DictionaryException;
import org.springframework.stereotype.Component;

/**
 * 缓存配置字典管理支持类，从缓存中获取字典数据，提供给实际需要的类
 * @author yuqs
 */
@Component
public class CacheDictionary extends AbstractDictionary {
	/**
	 * 根据字典名称，直接从缓存中获取key为name的字典对象。一般为Map<Long, String>类型
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getByName(String name) {
		Object value = CacheManager.get(name);
		if(value != null && !(value instanceof Map)) {
			throw new DictionaryException("Type conversion failure");
		}
		return (Map<String, String>)value;
	}
}
