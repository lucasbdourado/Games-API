package br.com.lucasbdourado.games.gamesapi.domain;

import br.com.lucasbdourado.games.gamesapi.domain.Card;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    private Integer index = 0;

    public Deck(List<Card> cards){
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle(){

        for(int i=0; i<cards.size(); i++){
            int random = (int) ((Math.random() * 52));

            Card oldCard = cards.get(i);
            Card newCard = cards.get(random);

            cards.set(i, newCard);
            cards.set(random, oldCard);
        }
    }

    public Card getCard() {
        Card card = cards.get(index);

        index++;

        return card;
    }
}
