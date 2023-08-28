package br.com.lucasbdourado.games.gamesapi.dao.generic;

import br.com.lucasbdourado.games.gamesapi.domain.Persistent;

import java.util.Map;

public interface IGenericDAO<T extends Persistent>{
    public void add(int id, T item);

    public T get(int id);

    public Map<Integer, T> getAll();
}
