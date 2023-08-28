package br.com.lucasbdourado.games.gamesapi.dao.generic;

import br.com.lucasbdourado.games.gamesapi.domain.Persistent;

import java.util.Map;

public class GenericDAO<T extends Persistent>{
    private SingletonMap<Long, T> singletonMap;

    private GenericDAO() {
        singletonMap = SingletonMap.getInstance();
    }

    public static <T extends Persistent> GenericDAO<T> getInstance() {
        return new GenericDAO<>();
    }

    public void add(long id, T item) {
        singletonMap.put(id, item);
    }

    public T get(long id) {
        return singletonMap.get(id);
    }

    public Boolean remove(long id) {
        try{
            if(singletonMap.remove(id)){
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public Map<Long, T> getAll() {
        return singletonMap.getAll();
    }
}
