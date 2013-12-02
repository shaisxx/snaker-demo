package org.snaker.framework.cache;

/**
 * 缓存异常类
 * @author yuqs
 */
public class CacheException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7781168239046507965L;

	public CacheException(Throwable root) {
		super(root);
	}

	public CacheException(String string, Throwable root) {
		super(string, root);
	}

	public CacheException(String s) {
		super(s);
	}
}
