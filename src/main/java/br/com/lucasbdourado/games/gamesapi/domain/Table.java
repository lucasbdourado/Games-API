package br.com.lucasbdourado.games.gamesapi.domain;


import br.com.lucasbdourado.games.gamesapi.annotation.PrimaryKey;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Table implements Persistent{

    private static Integer index = 1;

    @PrimaryKey("getId")
    private long id;

    private String name;

    private Integer playersLimit;

    private Game game;

    private String cardGame;

    private Player player;

    public Table(){}

    public Table(String name, Integer playersLimit, String cardGame){
        this.id = index++;
        this.name = name;
        this.playersLimit = playersLimit;
        this.cardGame = cardGame;
        this.game = new Game(CardGame.valueOf(this.cardGame));
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

    public Game getGame() {
        return game;
    }

    public String getCardGame() {
        return cardGame;
    }

    public void setCardGame(String cardGame) {
        this.cardGame = cardGame;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void createGame(CardGame cardGame) {
        if(game == null){
            game = new Game(cardGame);
        }
    }
}
