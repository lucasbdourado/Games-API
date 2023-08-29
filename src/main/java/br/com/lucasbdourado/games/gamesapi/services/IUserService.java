package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.domain.Auth;
import br.com.lucasbdourado.games.gamesapi.domain.User;

public interface IUserService {

    User login(Auth auth) throws Exception;

    User register(User user) throws Exception;
}
