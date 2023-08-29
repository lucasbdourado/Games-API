package br.com.lucasbdourado.games.gamesapi.resources;

import br.com.lucasbdourado.games.gamesapi.domain.Auth;
import br.com.lucasbdourado.games.gamesapi.domain.Player;
import br.com.lucasbdourado.games.gamesapi.domain.User;
import br.com.lucasbdourado.games.gamesapi.exception.JsonException;
import br.com.lucasbdourado.games.gamesapi.services.IUserService;
import br.com.lucasbdourado.games.gamesapi.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class UserResource {

    private IUserService userService;
    public UserResource(){
        this.userService = new UserService();
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User user){
        try{
            User createdUser = this.userService.register(user);
            if(user != null){
                return Response.status(Response.Status.CREATED).entity(user).build();
            }else {
                JsonException jsonException = new JsonException("As credenciais fornecidas não correspondem com nossos registros");

                return Response.status(Response.Status.UNAUTHORIZED).entity(jsonException).build();
            }
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Auth auth){
        try{
            User user = userService.login(auth);

            if(user != null){
                return Response.status(Response.Status.CREATED).entity(user).build();
            }else {
                JsonException jsonException = new JsonException("As credenciais fornecidas não correspondem com nossos registros");

                return Response.status(Response.Status.UNAUTHORIZED).entity(jsonException).build();
            }
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
