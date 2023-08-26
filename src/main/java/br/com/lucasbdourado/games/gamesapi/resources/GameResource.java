package br.com.lucasbdourado.games.gamesapi.resources;

import br.com.lucasbdourado.games.gamesapi.dao.GameDAO;
import br.com.lucasbdourado.games.gamesapi.dao.IGameDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Game;
import br.com.lucasbdourado.games.gamesapi.services.GameService;
import br.com.lucasbdourado.games.gamesapi.services.IGameService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/games")
public class GameResource {
    private final IGameService gameService;

    public GameResource(){
          IGameDAO gameDAO = new GameDAO();
          this.gameService = new GameService(gameDAO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Game> getGames() throws Exception {
        return gameService.getAll();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer getCount() throws Exception {
        return gameService.getCount();
    }

    @GET
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Game create() throws Exception {
        Game game = new Game();
        game.setName("Mesa de Poker 014");

        return gameService.create(game);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Game show(@PathParam("id") Long id) throws Exception {
        return gameService.findById(id);
    }

}
