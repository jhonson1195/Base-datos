/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Map;
import dbs_project.structures.LinearList;


/**
 *
 * @author jhonson
 */
public class Maps <K,V>implements Map<K,V>{
    
    private LinearList<Entrys<K,V>> table = new DoublyLinkedList<>();
    
    public int findIndex(K key){
        int n = table.size();
        for (int j=0; j<n; j++){
            table.goToPos(j);
            if (table.getElement().getKey().equals(key)){
                return j;
            }
        }
        return -1;
    }

    @Override
    public V put(K key, V value) {
        int j=findIndex(key);
        if (j==-1){
            table.append(new Entrys<>(key, value));
            return null;
        }
        else{
            table.goToPos(j);
            return table.getElement().setValue(value);
        }
    }

    @Override
    public V get(K key) {
        int j=findIndex(key);
        if(j==-1){
            return null;
        }
        table.goToPos(j);
        return table.getElement().getValue();
        
    }

    @Override
    public V remove(K key) {
        int j=findIndex(key);
        if(j==-1){
            return null;
        }
        table.goToPos(j);
        V temp =table.getElement().getValue();
        table.remove();
        return temp;
    }

    @Override
    public Iterable keySet() {
        return null;
    }

    @Override
    public Iterable values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return table.size() == 0;
    }

    @Override
    public void clear() {
        table.clear();
    }

    @Override
    public Iterable entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
