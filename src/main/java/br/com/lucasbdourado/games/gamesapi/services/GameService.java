package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.dao.IGameDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Game;

import java.sql.SQLException;
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

    @Override
    public Game update(Long id, Game game) throws Exception {
        try{
            Game oldGame = this.findById(id);

            if(oldGame != null){
                game.setId(oldGame.getId());

                return this.gameDAO.update(game);
            }
        }  catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Game delete(Long id) throws Exception {
        try{
            Game game = this.findById(id);

            return this.gameDAO.delete(game);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
