package org.snaker.framework.dictionary;

import java.util.Iterator;
import java.util.Map;

public class DictionaryService {
	public static String find(String value, String config) {
		String findValue = "";
		IDictionary dict = null;
		Map<String, String> items = dict.getByName(config);
		Iterator<String> it = items.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			String val = items.get(key);
			if(value.contains(key)) {
				findValue = val;
				break;
			}
		}
		return findValue;
	}
}
