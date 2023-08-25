package br.com.lucasbdourado.games.gamesapi.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Game {

    private long id = 0;

    private String name;

    private static long index = 0;

    public Game(String name){
        this.id = index;
        this.name = name;
        index++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                '}';
    }
}
