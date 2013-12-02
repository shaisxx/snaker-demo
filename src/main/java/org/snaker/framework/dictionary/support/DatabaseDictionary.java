package org.snaker.framework.dictionary.support;

import java.util.Map;

import org.snaker.framework.dictionary.AbstractDictionary;
import org.snaker.framework.dictionary.service.DictionaryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据库配置管理支持类，从数据库获取配置数据，提供给需要配置数据的对象
 * @author yuqs
 */
@Component
public class DatabaseDictionary extends AbstractDictionary {
	@Autowired
	private DictionaryManager dictionaryManager;
	@Override
	public Map<String, String> getByName(String name) {
		return dictionaryManager.getItemsByName(name);
	}

}
