package br.com.lucasbdourado.games.gamesapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.mindrot.jbcrypt.BCrypt;

import java.security.MessageDigest;

public class Auth {

    private String email;

    private String password;

    public Auth(){}

    public Auth(String email, String password){
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static String bcrypt(String password) {

        String salt = BCrypt.gensalt();

        String cryptedPassword = BCrypt.hashpw(password, salt);

        return cryptedPassword;
    }

    public static boolean checkPassword(String password, String cryptedPassword) {
        return BCrypt.checkpw(password, cryptedPassword);
    }
}
