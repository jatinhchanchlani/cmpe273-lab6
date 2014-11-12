package edu.sjsu.cmpe.cache.client;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {

 
 private final int numberOfReplicas;
 private final SortedMap<String, T> circle = new TreeMap<String, T>();

 public ConsistentHash(int numberOfReplicas,
     Collection<T> nodes) throws Exception {
  
   this.numberOfReplicas = numberOfReplicas;

   for (T node : nodes) {
     add(node);
   }
 }

 public void add(T node) throws Exception {
   for (int i = 0; i < numberOfReplicas; i++) {
     circle.put(HashFunction.hash(node.toString() + i), node);
   }
 }


 public void remove(T node) throws Exception {
   for (int i = 0; i < numberOfReplicas; i++) {
     circle.remove(HashFunction.hash(node.toString() + i));
   }
 }

 public T get(String key) throws Exception {
   if (circle.isEmpty()) {
     return null;
   }
   String hash = HashFunction.hash(key);
   if (!circle.containsKey(hash)) {
     SortedMap<String, T> tailMap = circle.tailMap(hash);
     hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
   }
   return circle.get(hash);
 }

}