package org.snaker.framework.dictionary.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.SQLQuery;
import org.snaker.framework.dictionary.dao.DictionaryDao;
import org.snaker.framework.dictionary.entity.Dictionary;
import org.snaker.framework.dictionary.entity.DictionaryItem;
import org.snaker.framework.orm.Page;
import org.snaker.framework.orm.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 配置字典管理类
 * @author yuqs
 */
@Component
public class DictionaryManager {
	@Autowired
	private DictionaryDao dictionaryDao;
	
	/**
	 * 保存配置字典实体
	 * @param entity
	 */
	public void save(Dictionary entity) {
		dictionaryDao.save(entity);
	}
	
	/**
	 * 保存配置字典实体，更新时先删除配置字典选项列表，再添加选项列表
	 * @param entity
	 */
	public void save(Dictionary entity, List<DictionaryItem> items) {
		if(entity.getId() != null) {
			dictionaryDao.batchExecute("delete DictionaryItem where dictionary=" + entity.getId());
		}
		
		if(items != null && items.size() > 0) {
			entity.setDictionaryItems(items);
		}
		dictionaryDao.save(entity);
	}
	
	/**
	 * 根据主键ID获取配置字典实体
	 * @param id
	 * @return
	 */
	public Dictionary get(Long id) {
		return dictionaryDao.get(id);
	}
	
	/**
	 * 根据主键ID删除对应的配置字典实体
	 * @param id
	 */
	public void delete(Long id) {
		dictionaryDao.delete(id);
	}
	
	/**
	 * 根据分页对象、过滤集合参数，分页查询配置字典列表
	 * @param page
	 * @param filters
	 * @return
	 */
	public Page<Dictionary> findPage(final Page<Dictionary> page, final List<PropertyFilter> filters) {
		return dictionaryDao.findPage(page, filters);
	}
	
	/**
	 * 根据字典名称，获取所有字典项，并以map类型返回
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> getItemsByName(String name) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select ci.id,ci.name,ci.code,ci.orderby,ci.dictionary,ci.description from conf_dictitem ci ");
		sqlBuffer.append(" left outer join conf_dictionary cd on cd.id = ci.dictionary ");
		sqlBuffer.append(" where cd.name = ?");
		SQLQuery query = dictionaryDao.createSQLQuery(sqlBuffer.toString(), name);
		query.addEntity(DictionaryItem.class);
		List<DictionaryItem> items = query.list();
		Map<String, String> dicts = new TreeMap<String, String>();
		for(DictionaryItem item : items) {
			dicts.put(item.getCode(), item.getName());
		}
		return dicts;
	}
}
