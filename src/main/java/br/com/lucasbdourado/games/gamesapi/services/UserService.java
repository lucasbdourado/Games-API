package br.com.lucasbdourado.games.gamesapi.services;

import br.com.lucasbdourado.games.gamesapi.dao.IUserDAO;
import br.com.lucasbdourado.games.gamesapi.dao.UserDAO;
import br.com.lucasbdourado.games.gamesapi.domain.Auth;
import br.com.lucasbdourado.games.gamesapi.domain.User;

public class UserService implements IUserService{

    private IUserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDAO();
    }
    @Override
    public User login(Auth auth) throws Exception {
        return userDAO.auth(auth.getEmail(), auth.getPassword());
    }

    @Override
    public User register(User user) throws Exception {
        return userDAO.register(user);
    }
}
