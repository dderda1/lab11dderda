package edu.luc.cs271.myhashmap;

import java.util.*;

/**
 * A generic HashMap custom implementation using chaining. Concretely, the table is an ArrayList of
 * chains represented as LinkedLists.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class MyHashMap<K, V> implements Map<K, V> {

  private static final int tableSize = 11; // a prime

  private List<List<Entry<K, V>>> table;

  public MyHashMap() {
    this(tableSize);
  }

  public MyHashMap(final int tableSize) {
    // allocate a table of the given size
    table = new ArrayList<>(tableSize);
    // then create an empty chain at each position
    for (int i = 0; i < tableSize; i += 1) {
      table.add(new LinkedList<>());
    }
  }

  @Override
  public int size() {
    // TODO add the sizes of all the chains DONE
    int result = 0;
    for (i=0; i<tableSize; i++){
      int chain = table.get(i).size(); //refer to hashmap?
      result = chain + result;
    }

    return result;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean containsKey(final Object key) {
    // TODO follow basic approach of remove below (though this will be much simpler) DONE
    final int index = calculateIndex(key);
    System.out.println(table.get(index).toString());
    System.out.println(key.toString());
    for (Entry<K, V> entry : table.get(index)){
      if (entry.getKey().equals(key)){
        return true;
      }
    } return false;
  }

  @Override
  public boolean containsValue(final Object value) {
    // TODO follow basic approach of remove below (though this will be much simpler)DONE
    for (List<Entry<K, V>> index : table){
      for( Entry<K, V> entry : index){
        if(entry.getValue().equals(value)){
          return true;
        }
      }
    }

    return false;
  }

  @Override
  public V get(final Object key) {
    // TODO follow basic approach of remove below (though this will be simpler) DONE
    final int index = calculateIndex(key);
    final Iterator <Entry<K, V>> suffer = table.get(index).iterator();
    while (suffer.hasNext()){
      final Entry<K, V> entry = suffer.next();
      if (entry.getKey().equals(key)){
        return entry.getValue();
      }
      else {
        return null;
      }
    }
    return null;
  }

  @Override
  public V put(final K key, final V value) {
    // TODO follow basic approach of remove below (this will be similar) DONE?
    final int index = calculateIndex(key);
    for (Entry<K, V> entry : table.get(index)){
      if (entry.getKey().equals(key)){
        V crying = entry.getValue();
        entry.setValue(value);
        return crying;
      }
    }
    table.get(index).add(0, new AbstractMap.SimpleEntry<K, V>(key, value));
    return null;
  }

  @Override
  public V remove(final Object key) {
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        final V oldValue = entry.getValue();
        iter.remove();
        return oldValue;
      }
    }
    return null;
  }

  @Override
  public void putAll(final Map<? extends K, ? extends V> m) {
    // TODO add each entry in m's entrySet DONE?
    for (final Entry<? extends K, ? extends V> entry : m.entrySet()) {
      put(entry.getKey(), entry.getValue());
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < tableSize; i++) {
      table.set(i, new LinkedList<>());
    }
  }

  /** The resulting keySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<K> keySet() {
    final Set<K> result = new HashSet<>();
    // TODO populate the set DONE
    for (int i = 0; i < tableSize; i++) {
      final Iterator<Entry<K, V>> emo = table.get(i).iterator();
      while(emo.hasNext()){
        Entry<K, V> janek = emo.next();
        result.add(janek.getKey());
      }
    }
    return Collections.unmodifiableSet(result);
  }

  /** The resulting values collection is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Collection<V> values() {
    final List<V> result = new LinkedList<>();
    // TODO populate the list DONE
    for (int i = 0; i < tableSize; i++) {
      final Iterator<Entry<K, V>> emo = table.get(i).iterator();
      while(emo.hasNext()){
        Entry<K, V> iamtheone = emo.next();
        result.add(iamtheone.getValue());
      }
    }
    return Collections.unmodifiableCollection(result);
  }

  /** The resulting entrySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<Entry<K, V>> entrySet() {
    final Set<Entry<K, V>> result = new HashSet<>();
    // TODO populate the set
    for (int i = 0; i < tableSize; i++) {
      final Iterator<Entry<K, V>> emo = table.get(i).iterator();
      while(emo.hasNext()){
        Entry<K, V> beemovie = emo.next();
        result.add(beemovie);
      }
    }
    return Collections.unmodifiableSet(result);
  }

  @Override
  public String toString() {
    // TODO return the string representation of the underlying table DONE
    for (int i = 0, i <tableSize; i++){
      final Iterator<Entry<K, V>> mariahcarey = table.get(i).iterator();
      while(mariahcarey.hasNext()){
        Entry<K, V> allIwantForChristmasIsYou = mariahcarey.next();
        System.out.println(allIwantForChristmasIsYou.getKey() + " - " + allIwantForChristmasIsYou.getValue());
      }
    }
    return "";
  }

  public boolean equals(final Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof Map)) {
      return false;
    } else {
      // TODO simply compare the entry sets
    //  return false;
      return this.entrySet().equals(((Map) that).entrySet());
    }
  }

  private int calculateIndex(final Object key) {
    // positive remainder (as opposed to %)
    // required in case hashCode is negative!
    return Math.floorMod(key.hashCode(), table.size());
  }
}
