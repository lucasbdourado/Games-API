package br.com.lucasbdourado.games.gamesapi.resources;

import br.com.lucasbdourado.games.gamesapi.dao.GameDAO;
import br.com.lucasbdourado.games.gamesapi.dao.IGameDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Game;
import br.com.lucasbdourado.games.gamesapi.services.GameService;
import br.com.lucasbdourado.games.gamesapi.services.IGameService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getGames() throws Exception {
        try {
            List<Game> games = gameService.getAll();

            return Response.ok(games).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCount() throws Exception {
        try {
            Integer gamesCount = gameService.getCount();

            return Response.ok(gamesCount).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Game game) throws Exception {
        try {
            Game createdGame = gameService.create(game);

            if (createdGame != null) {
                return Response.status(Response.Status.CREATED).entity(createdGame).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) throws Exception {
        try {
            Game deletedGame = gameService.delete(id);

            if (deletedGame != null) {
                return Response.ok(deletedGame).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id) throws Exception {
        try {
            Game game = gameService.findById(id);

            if (game != null) {
                return Response.ok(game).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, Game game) throws Exception {
        try {
            Game updatedGame = gameService.update(id, game);

            if (updatedGame != null) {
                return Response.ok(updatedGame).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
