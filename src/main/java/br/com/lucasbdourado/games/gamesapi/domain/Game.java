package br.com.lucasbdourado.games.gamesapi.domain;

import java.util.List;

public class Game {

    private Deck deck;

    public Game(CardGame cardGame){

        this.deck = new Deck(Rule.setupGame(cardGame));
    }

    public Deck getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        return "Game{" +
                "deck=" + deck +
                '}';
    }
}
