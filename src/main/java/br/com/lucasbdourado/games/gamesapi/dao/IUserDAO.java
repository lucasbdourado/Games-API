package br.com.lucasbdourado.games.gamesapi.dao;

import br.com.lucasbdourado.games.gamesapi.domain.User;

public interface IUserDAO {

    User auth(String email, String password) throws Exception;

    User register(User user) throws Exception;
}
