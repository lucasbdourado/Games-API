package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.dao.ITableDAO;
import br.com.lucasbdourado.games.gamesapi.dao.TableDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Player;
import br.com.lucasbdourado.games.gamesapi.domain.Table;

import java.util.List;

public class TableService implements ITableService {

    private ITableDAO tableDAO;

    public TableService(ITableDAO tableDAO){

        this.tableDAO = tableDAO;
    }

    @Override
    public Table create(Table table) throws Exception {
        return this.tableDAO.create(table);
    }

    @Override
    public Table findById(Long id) throws Exception {
        return this.tableDAO.read(id);
    }

    @Override
    public List<Table> getAll() throws Exception {
        return this.tableDAO.list();
    }

    @Override
    public Integer getCount(){

        return this.tableDAO.count();
    }

    @Override
    public Table update(Long id, Table table) throws Exception {
        try{
            Table updateTable = this.findById(id);

            if(updateTable != null){
                return this.tableDAO.update(updateTable, table);
            }
        }  catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return null;
    }

    @Override
    public Table delete(Long id) throws Exception {
        try{
            //return this.tableDAO.delete(id);
            return new Table();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Table joinTable(Long id, Player player) throws Exception {
        try{
            Table table = this.findById(id);

            if(table == null){
                throw new Exception("Não foi possivel encontrar a mesa informada");
            }

            System.out.println(player);
            System.out.println(table);

            table.getGame().addPlayer(player);

            return table;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
