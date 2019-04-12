package game;

import java.util.ArrayList;
import java.util.Collections;

import cards.Card;

public class Player {

	Deck deck = new Deck();
	ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> grave = new ArrayList<Card>();
	public ArrayList<Card> rfg = new ArrayList<Card>();
	String name;
	public int maxLifeTotal = 30;
	public int lifeTotal;
	public int playsPerTurn = 2;

	public Player(String newName) {
		name = newName;
		lifeTotal = maxLifeTotal;
	}

	public ArrayList<Card> getDeck() {
		return deck.cards;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	public ArrayList<Card> getGrave() {
		return grave;
	}

	public void setGrave(ArrayList<Card> grave) {
		this.grave = grave;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void draw() {
		if (deck.size() > 0) {
			hand.add(deck.remove(0));
		} else {
			this.lifeTotal = lifeTotal - 5;
		}
	}

	public void shuffle() {
		deck.shuffle();
	}

	public void randomDiscard() {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			grave.add(hand.remove(0));
		}
	}

	public void millX(int x) {
		for (int i = 0; i < x; i++) {
			if (deck.size() > 0) {
				grave.add(deck.remove(0));
			}
		}
	}

	public void add(Card c) {
		deck.add(c);
	}

	public void drawX(int x) {
		for (int i = 0; i < x; i++) {
			draw();
		}
	}

	public boolean isAlive() {
		return lifeTotal > 0;
	}

	public void makePlay(Player opponent) {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			Card c = hand.remove(0);
			grave.add(c);
			c.onentry(this, opponent);
			// System.out.println(this.name + " casts " + c.getName() + ". (" + lifeTotal +
			// ")-(" + opponent.getLife() + ")");
		}
	}

	public int getLife() {
		return lifeTotal;
	}

	public int cardCount(ArrayList<Card> grave2, String string) {
		int i = 0;
		for (Card cs : grave2) {
			if (cs.getName().equals(string)) {
				i++;
			}
		}
		return i;
	}

	public void cleanup() {
		this.deck.addAll(this.grave);
		this.grave.clear();
		this.deck.addAll(this.rfg);
		this.rfg.clear();
		this.deck.addAll(this.hand);
		this.hand.clear();
		this.lifeTotal = 30;
	}

	public void movePile(ArrayList<Card> targetPile, ArrayList<Card> sourcePile) {
		targetPile.addAll(sourcePile);
		sourcePile.clear();
	}

	public void rfgFromDeck(int x) {
		for (int i = 0; i < x; i++) {
			if (getDeck().size() > 0) {
				rfg.add(getDeck().remove(0));
			}
		}
	}
}
