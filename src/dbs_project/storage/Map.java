package dbs_project.storage;

public interface Map<K, V> {
	V put(K key, V value);
	V get(K key);
	V remove(K key);
	Iterable<K> keySet();
	Iterable<V> values();
	int size();
	boolean isEmpty();
	void clear();
	Iterable<Entry<K,V>> entrySet();
}
