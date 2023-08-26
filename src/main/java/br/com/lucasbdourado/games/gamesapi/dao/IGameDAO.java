package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.domain.Game;

import java.util.List;

public interface IGameDAO {

    Game create(Game game) throws Exception;

    Game read(Long id) throws Exception;

    //Game update(Game game) throws Exception;

    //Game delete(Long id) throws Exception;

    List<Game> list() throws Exception;

    Integer count() throws Exception;
}
