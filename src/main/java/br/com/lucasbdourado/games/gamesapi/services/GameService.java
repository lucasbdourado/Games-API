package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.dao.IGameDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Game;

import java.util.List;

public class GameService implements IGameService{

    private IGameDAO gameDAO;

    public GameService(IGameDAO gameDAO){
        this.gameDAO = gameDAO;
    }

    @Override
    public Game create(Game game) throws Exception {
        return this.gameDAO.create(game);
    }

    @Override
    public Game findById(Long id) throws Exception {
        return this.gameDAO.read(id);
    }

    @Override
    public List<Game> getAll() throws Exception {
        return this.gameDAO.list();
    }

    @Override
    public Integer getCount() throws Exception {
        return this.gameDAO.count();
    }
}
