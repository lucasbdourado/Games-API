package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.domain.Table;

import java.util.List;

public interface ITableDAO {

    Table create(Table table) throws Exception;

    Table read(Long id) throws Exception;

    Table update(Table table) throws Exception;

    Table delete(Table table) throws Exception;

    List<Table> list() throws Exception;

    Integer count() throws Exception;
}
