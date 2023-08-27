package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.dao.ITableDAO;
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
    public Integer getCount() throws Exception {
        return this.tableDAO.count();
    }

    @Override
    public Table update(Long id, Table table) throws Exception {
        try{
            Table oldTable = this.findById(id);

            if(oldTable != null){
                table.setId(oldTable.getId());

                return this.tableDAO.update(table);
            }
        }  catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Table delete(Long id) throws Exception {
        try{
            Table table = this.findById(id);

            return this.tableDAO.delete(table);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
