package br.com.lucasbdourado.games.gamesapi.dao.generic;

import br.com.lucasbdourado.games.gamesapi.domain.Persistent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SingletonMap<K, V extends Persistent> {
    private Map<K, V> map;

    private static SingletonMap<?, ?> instance;

    private SingletonMap() {
        map = new HashMap<>();
    }

    public static synchronized <K, V extends Persistent> SingletonMap<K, V> getInstance() {
        if (instance == null) {
            instance = new SingletonMap<>();
        }
        return (SingletonMap<K, V>) instance;
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public Boolean remove(K key) throws Exception {
        try{
            map.remove(key);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Map<K, V> getAll() {
        return Collections.unmodifiableMap(map);
    }
}
