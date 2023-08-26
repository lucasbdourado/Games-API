package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.domain.Game;

import java.util.List;

public interface IGameService {

    Game create(Game game) throws Exception;

    Game findById(Long id) throws Exception;

    List<Game> getAll() throws Exception;

    Integer getCount() throws Exception;

}
