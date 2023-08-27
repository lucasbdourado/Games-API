package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.dao.jdbc.ConnectionFactory;
import br.com.lucasbdourado.games.gamesapi.domain.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDAO implements ITableDAO {

    @Override
    public Table create(Table table) throws Exception {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "INSERT INTO games_tables (name, max_players) VALUES (?, ?)";

            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, table.getName());
            preparedStatement.setInt(2, table.getPlayersLimit());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A criação do jogo falhou, tente novamente mais tarde.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int tableId = generatedKeys.getInt(1);
                    table.setId(tableId);
                } else {
                    throw new SQLException("Erro: A criação falhou, não foi possível obter o ID gerado.");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }

        return table;
    }

    @Override
    public Table read(Long id) throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        Table table = null;

        ResultSet resultSet;

        try{

            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM games_tables WHERE Id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                table = new Table();

                table.setId(resultSet.getLong("id"));
                table.setPlayersLimit(resultSet.getInt("max_players"));
                table.setName(resultSet.getString("name"));
            }

            return table;

        } catch (Exception e){

            throw e;

        }finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Table update(Table table) throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try{
            connection = ConnectionFactory.getConnection();

            String query = "UPDATE games_tables SET name = ?, max_players = ? WHERE id = ?";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, table.getName());
            preparedStatement.setInt(2, table.getPlayersLimit());
            preparedStatement.setLong(3, table.getId());

            Integer rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException("Erro: Não foi possivel atualizar o registro, tente novamente mais tarde");
            }

            return table;
        } catch (Exception e){
            throw e;
        }finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Table delete(Table table) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConnectionFactory.getConnection();
            String query = "DELETE FROM games_tables WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, table.getId());
            Integer rowsAffected = preparedStatement.executeUpdate();

            if(rowsAffected == 0){
                throw new SQLException("Erro: Não foi possivel deletar o jogo, tente novamente mais tarde.");
            }

            return table;
        } catch (Exception e){
            throw e;
        }finally {
            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public List<Table> list() throws Exception {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        List<Table> tables = new ArrayList<>();

        ResultSet resultSet;

        try{

            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM games_tables";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Table table = new Table();

                table.setId(resultSet.getLong("id"));
                table.setPlayersLimit(resultSet.getInt("max_players"));
                table.setName(resultSet.getString("name"));
                tables.add(table);
            }

            return tables;

        } catch (Exception e){

            throw e;

        }finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }

    @Override
    public Integer count() throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        Integer quantity = 0;

        ResultSet resultSet;

        try{
            connection = ConnectionFactory.getConnection();

            String query = "SELECT COUNT(*) FROM games_tables";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                quantity = resultSet.getInt(1);
            }

            return quantity;

        } catch (Exception e){

            throw e;

        }finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
    }
}
