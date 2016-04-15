package ch.hasselba.xpagesservicelocator;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@SuppressWarnings("unchecked")
public class ServerMap implements Map<String, Object>, Serializable {

	private static final long serialVersionUID = -4145696601000922342L;
	private static long lastAccessed = 0;
	private static ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
		
	@Override
	public void clear() {
		setLastAccessed(System.currentTimeMillis());
		map.clear();		
	}

	@Override
	public boolean containsKey(Object obj) {
		setLastAccessed(System.currentTimeMillis());
		return map.contains(obj);
	}

	@Override
	public boolean containsValue(Object obj) {
		setLastAccessed(System.currentTimeMillis());
		return map.containsValue(obj);
	}

	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		setLastAccessed(System.currentTimeMillis());
		return map.entrySet();
	}

	@Override
	public Object get(Object obj) {
		setLastAccessed(System.currentTimeMillis());
		return map.get(obj);
	}

	@Override
	public boolean isEmpty() {
		setLastAccessed(System.currentTimeMillis());
		return map.isEmpty();
	}

	@Override
	public Set keySet() {
		setLastAccessed(System.currentTimeMillis());
		return map.keySet();
	}


	@Override
	public Object remove(Object obj) {
		setLastAccessed(System.currentTimeMillis());
		return map.remove(obj);
	}

	@Override
	public int size() {
		setLastAccessed(System.currentTimeMillis());
		return map.size();
	}

	@Override
	public Collection values() {
		setLastAccessed(System.currentTimeMillis());
		return map.values();
	}


	public static long getLastAccessed() {
		return lastAccessed;
	}

	public static synchronized void setLastAccessed(long lastAccessed) {
		ServerMap.lastAccessed = lastAccessed;
	}

	@Override
	public Object put(String key, Object value) {
		setLastAccessed(System.currentTimeMillis());
		return map.put(key, value);
	}

	@Override
	public void putAll(Map m) {
		setLastAccessed(System.currentTimeMillis());
		map.putAll(m);
	}
	
}
