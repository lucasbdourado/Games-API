package br.com.lucasbdourado.games.gamesapi.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User {

    private Long id;

    private String email;

    private String password;

    private String username;

    private Role role = Role.USER;

    public User(){}

    public User(String email, String password, String username){
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
