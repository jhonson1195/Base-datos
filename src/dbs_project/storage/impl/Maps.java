/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project.storage.impl;

import dbs_project.storage.Map;
import dbs_project.structures.LinearList;
import java.util.Iterator;


/**
 *
 * Los Maps es una lista DoublyLinkedList, que va a tener como elementos
 * keys y dentro de los key van a haber values
 * @author jhonson
 */
public class Maps <K,V>implements Map<K,V>{
    
    private LinearList<Entrys<K,V>> table = new DoublyLinkedList<>();

    //Retorna la posicion de la lista en donde se encuentra una keys en especifico
    public LinearList getList(){
        return table;
    }
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
    //Va a introducir nuevas keys
    public V put(K key, V value) {
        //Primero busca que la key no se encuentre creada
        int j=findIndex(key);
        if (j==-1){
            table.append(new Entrys<>(key, value));
            return null;
        }
        //Si se encuentra creada va a cambiar solo el valor
        else{
            table.goToPos(j);
            return table.getElement().setValue(value);
        }
    }

    //Retornar valor
    @Override
    public V get(K key) {
        //Primero busca que la key se encuentre creada
        int j=findIndex(key);
        if(j==-1){
            return null;
        }
        table.goToPos(j);
        return table.getElement().getValue();
        
    }
    
    //Remover valor, debe 
    @Override
    public V remove(K key) {
        //Primero busca que la key se encuentre creada
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
        ConjuntoMap Nuevo= new ConjuntoMap((Maps) table);
        return Nuevo;
    }

    @Override
    public Iterable values() {
        ConjuntoMap Nuevo = new ConjuntoMap ((Maps) table);
        Iterator<Maps> it1 = Nuevo.iterator();
        DoublyLinkedList tempp = new DoublyLinkedList();
        while (it1.hasNext()){
            Maps temp = it1.next();
            tempp.insert(temp.table.getElement());
        }
        Iterator<DoublyLinkedList> temp = tempp.;
        return temp;
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
    
    
    
    
    //**************************************************************************************
    //Prueba de Iterador
    //http://www.aprenderaprogramar.com/index.php?option=com_content&view=article&id=589:interface-iterable-y-metodo-iterator-api-java-recorrer-colecciones-ejercicio-y-ejemplo-resuelto-cu00912c&catid=58:curso-lenguaje-programacion-java-nivel-avanzado-i&Itemid=180
    //http://codereview.stackexchange.com/questions/48109/simple-example-of-an-iterable-and-an-iterator-in-java
    //http://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
    //http://migranitodejava.blogspot.com/2011/06/iterator.html
    
    
        public class ConjuntoMap implements Iterable<Maps>{      //Se usa IntIterable o Iterable
        public Maps conjuntoMap; 
        public ConjuntoMap (Maps map) { 
    	// Constructor de la clase
	    conjuntoMap = map;   
	}
 
        public Iterator<Maps> iterator() {    
            Iterator it = new MiIteratorMap();
            return it;         
        }
 
        protected class MiIteratorMap implements Iterator<Maps>   {
            protected int posicion;
            public MiIteratorMap()   { 
                    posicion = 0; 
            }
            public boolean hasNext() {
                boolean result;
                if (posicion < conjuntoMap.size()) { 
                    result = true; 
                }
                else { 
                    result = false; 
                }
                return result;
            }

            @Override
            public Maps next() {
                posicion++;
                return conjuntoMap;
            }

            public void remove(){
                throw new UnsupportedOperationException("No soportado.");
            }
        }
    }
    
    public class ConjuntoColumn implements Iterable<Columns>{      //Se usa IntIterable o Iterable
        public Columns conjuntoColumn; 
        public ConjuntoColumn (Columns column) { 
    	// Constructor de la clase
	    conjuntoColumn = column;   
	}
 
        public Iterator<Columns> iterator() {    
            Iterator it = new MiIteratorColumn();
            return it;         
        }
 
        protected class MiIteratorColumn implements Iterator<Columns>   {
            protected int posicion;
            public MiIteratorColumn()   { 
                    posicion = 0; 
            }
            public boolean hasNext() {
                boolean result;
                if (posicion < conjuntoColumn.getSize()) { 
                    result = true; 
                }
                else { 
                    result = false; 
                }
                return result;
            }

            @Override
            public Columns next() {
                posicion++;
                return conjuntoColumn;
            }

            public void remove(){
                throw new UnsupportedOperationException("No soportado.");
            }
        }
    }
    
    public class ConjuntoRow implements Iterable<Rows>{
        public Rows conjuntoRow; 
        public ConjuntoRow(Rows row) { 
    	// Constructor de la clase
	    conjuntoRow = row;   
	}
 
        public Iterator<Rows> iterator() {    
            Iterator it = new MiIteratorRow();
            return it;         
        }
 
        protected class MiIteratorRow implements Iterator<Rows>   {
            protected int posicion;
            public MiIteratorRow()   { 
                    posicion = 0; 
            }
            public boolean hasNext() {
                boolean result;
                if (posicion < conjuntoRow.getSize()) { 
                    result = true; 
                }
                else { 
                    result = false; 
                }
                return result;
            }

            @Override
            public Rows next() {
                posicion++;
                return conjuntoRow;
            }

            public void remove(){
                throw new UnsupportedOperationException("No soportado.");
            }
        }
    }
        
    //**************************************************************************************
    //Investigacion de IntIterador
    //http://commons.apache.org/proper/commons-primitives/apidocs/org/apache/commons/collections/primitives/class-use/IntIterator.html
    //http://www.javadocexamples.com/org/apache/commons/collections/primitives/IntIterator/hasNext().html
    //http://www.javadocexamples.com/org/apache/commons/collections/primitives/IntIterator/next().html
    //http://commons.apache.org/proper/commons-primitives/apidocs/org/apache/commons/collections/primitives/adapters/package-tree.html
    //http://commons.apache.org/proper/commons-primitives/apidocs/org/apache/commons/collections/primitives/IntIterator.html
    //
    
}
