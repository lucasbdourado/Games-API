package br.com.lucasbdourado.games.gamesapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players;
    private Deck deck;

    public Game(CardGame cardGame){
        this.players = new ArrayList<>();
        this.deck = new Deck(Rule.setupGame(cardGame));
        deck.shuffle();
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    @Override
    public String toString() {
        return "Game{" +
                "deck=" + deck +
                '}';
    }
}
