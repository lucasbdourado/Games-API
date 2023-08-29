package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.dao.jdbc.ConnectionFactory;
import br.com.lucasbdourado.games.gamesapi.domain.Auth;
import br.com.lucasbdourado.games.gamesapi.domain.Role;
import br.com.lucasbdourado.games.gamesapi.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO{

    @Override
    public User auth(String email, String password) throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        ResultSet resultSet;

        User user = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "SELECT * FROM users WHERE email = ?";

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if(Auth.checkPassword(password, resultSet.getString("password"))) {
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("password"));
                    user.setUsername(resultSet.getString("username"));
                    user.setRole(Role.valueOf(resultSet.getString("role")));


                    return user;
                }
            }

            if(user == null){
                throw new SQLException("As credenciais fornecidas não correspondem com nossos registros");
            }

            return user;
        }catch (Exception e){
            e.printStackTrace();
        } finally {

            if(preparedStatement != null && !preparedStatement.isClosed()){
                preparedStatement.close();
            }

            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }

        return null;
    }

    @Override
    public User register(User user) throws Exception {
        Connection connection = null;

        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();

            String query = "INSERT INTO users (email, password, username, role) VALUES (?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, Auth.bcrypt(user.getPassword()));
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, String.valueOf(user.getRole()));

            int rowsAffected  = preparedStatement.executeUpdate();

            if(rowsAffected == 0) throw new SQLException("Erro: A criação do jogo falhou, tente novamente mais tarde.");

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    Long userId = generatedKeys.getLong(1);

                    user.setId(userId);
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

        return user;
    }
}
