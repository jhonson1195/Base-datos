package dbs_project.structures;

import dbs_project.structures.LinearDataStructure;

/**
 * This interface represents the Queue data structure (as seen in class).
 * 
 * @author Isaac Alpzar Chacn
 *
 * @param <T>
 */
public interface Queue<T> extends LinearDataStructure<T> {
	
	void enqueue(T element);
	
	T dequeue();
	
	T first();
	
	int size();
	
	void clear();
	
	String toString();
	
}
