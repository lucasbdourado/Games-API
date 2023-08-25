package br.com.lucasbdourado.games.gamesapi.resources;

import br.com.lucasbdourado.games.gamesapi.domain.Game;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/games")
public class GameResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Game> getGames(){
        List<Game> games = new ArrayList<>();

        games.add(new Game("Jogo de Pôker 1"));
        games.add(new Game("Jogo de Pôker 2"));
        games.add(new Game("Jogo de Pôker 3"));
        games.add(new Game("Jogo de Pôker 4"));

        return games;
    }
}
