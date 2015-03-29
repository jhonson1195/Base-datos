/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Entry;

/**
 *
 * @author jhonson
 * @param <K>
 * @param <V>
 */
public class Entrys<K,V> implements Entry<K,V>{
    
    private K key;
    private V value;
    
    public Entrys(K key, V value){
        this.key=key;
        this.value=value;
        
    }
    

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setKey(K key) {
        this.key=key;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value=value;
        return old;
    }
    
}
