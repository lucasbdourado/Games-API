package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.domain.Table;

import java.util.List;

public interface ITableService {

    Table create(Table table) throws Exception;

    Table findById(Long id) throws Exception;

    List<Table> getAll() throws Exception;

    Integer getCount() throws Exception;

    Table update(Long id, Table table) throws Exception;

    Table delete(Long id) throws Exception;
}
