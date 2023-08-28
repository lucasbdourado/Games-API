package br.com.lucasbdourado.games.gamesapi.resources;

import br.com.lucasbdourado.games.gamesapi.dao.TableDAO;
import br.com.lucasbdourado.games.gamesapi.dao.ITableDAO;
import br.com.lucasbdourado.games.gamesapi.domain.CardGame;
import br.com.lucasbdourado.games.gamesapi.domain.Player;
import br.com.lucasbdourado.games.gamesapi.domain.Table;
import br.com.lucasbdourado.games.gamesapi.services.ITableService;
import br.com.lucasbdourado.games.gamesapi.services.TableService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tables")
public class TableResource {
    private final ITableService tableService;

    public TableResource(){
          ITableDAO tableDAO = new TableDAO();
          this.tableService = new TableService(tableDAO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTables(){
        try {
            List<Table> tables = tableService.getAll();

            return Response.ok(tables).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCount(){
        try {
            Integer tablesCount = tableService.getCount();

            return Response.ok(tablesCount).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Table table){
        try {
            Table requestTable = new Table(table.getName(), table.getPlayersLimit(), table.getCardGame());

            Table createdTable = tableService.create(requestTable);

            if (createdTable != null) {
                return Response.status(Response.Status.CREATED).entity(createdTable).build();
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
    public Response delete(@PathParam("id") Long id){
        try {
            Table deletedTable = tableService.delete(id);

            if (deletedTable != null) {
                return Response.ok(deletedTable).build();
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
    public Response show(@PathParam("id") Long id){
        try {
            Table table = tableService.findById(id);

            if (table != null) {
                return Response.ok(table).build();
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
    public Response update(@PathParam("id") Long id, Table table){
        try {
            Table updatedTable = tableService.update(id, table);

            if (updatedTable != null) {
                return Response.ok(updatedTable).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Path("/{id}/join")
    @Produces(MediaType.APPLICATION_JSON)
    public Response joinTable(@PathParam("id") Long id, Player player){

        try {
            Table table = tableService.joinTable(id, player);

            return Response.ok(table).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
