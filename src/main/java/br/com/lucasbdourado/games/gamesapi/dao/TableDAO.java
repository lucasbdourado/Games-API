package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.dao.generic.GenericDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Table;

import java.util.ArrayList;
import java.util.List;

public class TableDAO implements ITableDAO {

    GenericDAO<Table> database;

    public TableDAO(){
        database = GenericDAO.getInstance();
    }

    @Override
    public Table create(Table table) throws Exception {
        database.add(table.getId(), table);

        return table;
    }

    @Override
    public Table read(Long id) throws Exception {
        try{
            Table table = database.get(id);

            if(table == null) throw new Exception("Erro: A mesa não foi encotrada");

            return table;
        } catch (Exception e){
            throw new Exception("Erro ao realizar a busca");
        }
    }

    @Override
    public Table update(Table updateTable, Table table) throws Exception {
        try {
            updateTable.setName(table.getName());
            updateTable.setCardGame(table.getCardGame());

            if(table.getGame() != null) {
                updateTable.setGame(table.getGame());
            }

            return updateTable;
        } catch (Exception e){
            throw new Exception("Erro ao atualizar a Mesa");
        }
    }

    @Override
    public Table delete(Table table) throws Exception {

        if(database.remove(table.getId())) return table;

        return null;
    }

    @Override
    public List<Table> list() {
        List<Table> tables = new ArrayList<>();

        for (Table table: database.getAll().values()) {
            tables.add(table);
        }

        return tables;
    }

    @Override
    public Integer count() {
        return database.getAll().size();
    }
}
