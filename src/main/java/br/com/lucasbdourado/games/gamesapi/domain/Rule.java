package br.com.lucasbdourado.games.gamesapi.domain;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    public static List<Card> setupGame(CardGame cardGame) {
        List<Card> cards = new ArrayList<>();

        switch (cardGame){
            case POKER:
                cards.add(new Card("2", "♣", 2));
                cards.add(new Card("3", "♣", 3));
                cards.add(new Card("4", "♣", 4));
                cards.add(new Card("5", "♣", 5));
                cards.add(new Card("6", "♣", 6));
                cards.add(new Card("7", "♣", 7));
                cards.add(new Card("8", "♣", 8));
                cards.add(new Card("9", "♣", 9));
                cards.add(new Card("10", "♣", 10));
                cards.add(new Card("J", "♣", 11));
                cards.add(new Card("Q", "♣", 12));
                cards.add(new Card("K", "♣", 13));
                cards.add(new Card("A", "♣", 14));

                // Espadas
                cards.add(new Card("2", "♠", 2));
                cards.add(new Card("3", "♠", 3));
                cards.add(new Card("4", "♠", 4));
                cards.add(new Card("5", "♠", 5));
                cards.add(new Card("6", "♠", 6));
                cards.add(new Card("7", "♠", 7));
                cards.add(new Card("8", "♠", 8));
                cards.add(new Card("9", "♠", 9));
                cards.add(new Card("10", "♠", 10));
                cards.add(new Card("J", "♠", 11));
                cards.add(new Card("Q", "♠", 12));
                cards.add(new Card("K", "♠", 13));
                cards.add(new Card("A", "♠", 14));

                // Copas
                cards.add(new Card("2", "♥", 2));
                cards.add(new Card("3", "♥", 3));
                cards.add(new Card("4", "♥", 4));
                cards.add(new Card("5", "♥", 5));
                cards.add(new Card("6", "♥", 6));
                cards.add(new Card("7", "♥", 7));
                cards.add(new Card("8", "♥", 8));
                cards.add(new Card("9", "♥", 9));
                cards.add(new Card("10", "♥", 10));
                cards.add(new Card("J", "♥", 11));
                cards.add(new Card("Q", "♥", 12));
                cards.add(new Card("K", "♥", 13));
                cards.add(new Card("A", "♥", 14));

                // Ouros
                cards.add(new Card("2", "♦", 2));
                cards.add(new Card("3", "♦", 3));
                cards.add(new Card("4", "♦", 4));
                cards.add(new Card("5", "♦", 5));
                cards.add(new Card("6", "♦", 6));
                cards.add(new Card("7", "♦", 7));
                cards.add(new Card("8", "♦", 8));
                cards.add(new Card("9", "♦", 9));
                cards.add(new Card("10", "♦", 10));
                cards.add(new Card("J", "♦", 11));
                cards.add(new Card("Q", "♦", 12));
                cards.add(new Card("K", "♦", 13));
                cards.add(new Card("A", "♦", 14));
                break;
            case TRUCO:

                cards.add(new Card("4", "♣", 4));
                cards.add(new Card("5", "♣", 5));
                cards.add(new Card("6", "♣", 6));
                cards.add(new Card("7", "♣", 7));
                cards.add(new Card("J", "♣", 10));
                cards.add(new Card("Q", "♣", 11));
                cards.add(new Card("K", "♣", 12));
                cards.add(new Card("A", "♣", 13));
                cards.add(new Card("2", "♣", 14));
                cards.add(new Card("3", "♣", 15));

                // Espadas

                cards.add(new Card("4", "♠", 4));
                cards.add(new Card("5", "♠", 5));
                cards.add(new Card("6", "♠", 6));
                cards.add(new Card("7", "♠", 7));
                cards.add(new Card("J", "♠", 10));
                cards.add(new Card("Q", "♠", 11));
                cards.add(new Card("K", "♠", 12));
                cards.add(new Card("A", "♠", 13));
                cards.add(new Card("2", "♠", 14));
                cards.add(new Card("3", "♠", 15));

                // Copas

                cards.add(new Card("4", "♥", 4));
                cards.add(new Card("5", "♥", 5));
                cards.add(new Card("6", "♥", 6));
                cards.add(new Card("7", "♥", 7));
                cards.add(new Card("J", "♥", 10));
                cards.add(new Card("Q", "♥", 11));
                cards.add(new Card("K", "♥", 12));
                cards.add(new Card("A", "♥", 13));
                cards.add(new Card("2", "♥", 14));
                cards.add(new Card("3", "♥", 15));

                // Ouros

                cards.add(new Card("4", "♦", 4));
                cards.add(new Card("5", "♦", 5));
                cards.add(new Card("6", "♦", 6));
                cards.add(new Card("7", "♦", 7));
                cards.add(new Card("J", "♦", 10));
                cards.add(new Card("Q", "♦", 11));
                cards.add(new Card("K", "♦", 12));
                cards.add(new Card("A", "♦", 13));
                cards.add(new Card("2", "♦", 14));
                cards.add(new Card("3", "♦", 15));
                break;
            case BLACKJACK:
                cards.add(new Card("2", "♣", 2));
                cards.add(new Card("3", "♣", 3));
                cards.add(new Card("4", "♣", 4));
                cards.add(new Card("5", "♣", 5));
                cards.add(new Card("6", "♣", 6));
                cards.add(new Card("7", "♣", 7));
                cards.add(new Card("8", "♣", 8));
                cards.add(new Card("9", "♣", 9));
                cards.add(new Card("10", "♣", 10));
                cards.add(new Card("J", "♣", 10));
                cards.add(new Card("Q", "♣", 10));
                cards.add(new Card("K", "♣", 10));
                cards.add(new Card("A", "♣", 11));

                // Espadas
                cards.add(new Card("2", "♠", 2));
                cards.add(new Card("3", "♠", 3));
                cards.add(new Card("4", "♠", 4));
                cards.add(new Card("5", "♠", 5));
                cards.add(new Card("6", "♠", 6));
                cards.add(new Card("7", "♠", 7));
                cards.add(new Card("8", "♠", 8));
                cards.add(new Card("9", "♠", 9));
                cards.add(new Card("10", "♠", 10));
                cards.add(new Card("J", "♠", 10));
                cards.add(new Card("Q", "♠", 10));
                cards.add(new Card("K", "♠", 10));
                cards.add(new Card("A", "♠", 11));

                // Copas
                cards.add(new Card("2", "♥", 2));
                cards.add(new Card("3", "♥", 3));
                cards.add(new Card("4", "♥", 4));
                cards.add(new Card("5", "♥", 5));
                cards.add(new Card("6", "♥", 6));
                cards.add(new Card("7", "♥", 7));
                cards.add(new Card("8", "♥", 8));
                cards.add(new Card("9", "♥", 9));
                cards.add(new Card("10", "♥", 10));
                cards.add(new Card("J", "♥", 10));
                cards.add(new Card("Q", "♥", 10));
                cards.add(new Card("K", "♥", 10));
                cards.add(new Card("A", "♥", 11));

                // Ouros
                cards.add(new Card("2", "♦", 2));
                cards.add(new Card("3", "♦", 3));
                cards.add(new Card("4", "♦", 4));
                cards.add(new Card("5", "♦", 5));
                cards.add(new Card("6", "♦", 6));
                cards.add(new Card("7", "♦", 7));
                cards.add(new Card("8", "♦", 8));
                cards.add(new Card("9", "♦", 9));
                cards.add(new Card("10", "♦", 10));
                cards.add(new Card("J", "♦", 10));
                cards.add(new Card("Q", "♦", 10));
                cards.add(new Card("K", "♦", 10));
                cards.add(new Card("A", "♦", 11));
                break;
        }
        return cards;
    }
}
