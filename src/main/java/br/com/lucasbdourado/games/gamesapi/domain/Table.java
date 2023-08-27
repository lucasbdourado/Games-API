package br.com.lucasbdourado.games.gamesapi.domain;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Table {

    private long id;

    private String name;

    private Integer playersLimit;

    public Table(){}

    public Table(String name, Integer playersLimit){
        this.name = name;
        this.playersLimit = playersLimit;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlayersLimit() {
        return playersLimit;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPlayersLimit(Integer playersLimit) {
        this.playersLimit = playersLimit;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max_players=" + playersLimit +
                '}';
    }
}
