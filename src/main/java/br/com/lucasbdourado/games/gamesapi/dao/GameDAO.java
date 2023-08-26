package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.dao.jdbc.ConnectionFactory;
import br.com.lucasbdourado.games.gamesapi.domain.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements IGameDAO{

    @Override
    public Game create(Game game) throws Exception {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "INSERT INTO games (name) VALUES (?)";

            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, game.getName());

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A criação do jogo falhou, tente novamente mais tarde.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int gameId = generatedKeys.getInt(1);
                    game.setId(gameId);
                } else {
                    throw new SQLException("Erro: A criação falhou, não foi possível obter o ID gerado.");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return game;
    }

    @Override
    public Game read(Long id) throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        Game game = null;

        ResultSet resultSet;

        try{

            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM games WHERE Id = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                game = new Game();

                game.setId(resultSet.getLong("id"));
                game.setName(resultSet.getString("name"));
            }

            return game;

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
    public List<Game> list() throws Exception {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        List<Game> games = new ArrayList<>();

        ResultSet resultSet;

        try{

            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM games";

            preparedStatement = connection.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Game game = new Game();
                game.setId(resultSet.getLong("id"));
                game.setName(resultSet.getString("name"));
                games.add(game);
            }

            return games;

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

            String query = "SELECT COUNT(*) FROM games";

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
