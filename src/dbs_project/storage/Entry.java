package dbs_project.storage;

/*Interface for a key-value pair */
public interface Entry<K, V> {
	K getKey();
	V getValue();
	void setKey(K key);
	V setValue(V value);
}
