package game;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;

public class Player {

	Deck deck = new Deck();
	ArrayList<Card> hand = new ArrayList<Card>();
	public ArrayList<Card> grave = new ArrayList<Card>();
	public ArrayList<Card> rfg = new ArrayList<Card>();
	String name;
	public int maxLifeTotal = 30;
	public int lifeTotal;
	public int playsPerTurn = 2;
	public int fatigue = 1;

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
			Card c = deck.remove(0);
			c.whenDrawn(this);
			hand.add(c);
		} else {
			if (fatigue == -1) {
				this.lifeTotal = 0;
			} else {
				this.lifeTotal = lifeTotal - fatigue;
				fatigue++;
			}
		}
	}

	public void shuffle(ArrayList<Card> pile) {
		Collections.shuffle(pile);
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

	public void makePlay(Player opponent, Boolean debug) {
		if (hand.size() > 0) {
			Collections.shuffle(hand);
			Card c = hand.remove(0);
			grave.add(c);
			c.onentry(this, opponent);
			c.afterResolving(this, opponent);
			if (debug) {
				debug(this.name + " casts " + c.getName() + ". (" + lifeTotal + ")-(" + opponent.getLife() + ")");
			}
		}
	}

	private static void debug(String string) {
		System.out.println(string);
	}

	public void cleanup() {
		this.deck.addAll(this.grave);
		this.grave.clear();
		this.deck.addAll(this.rfg);
		this.rfg.clear();
		this.deck.addAll(this.hand);
		this.hand.clear();
		this.deck.remove("Corrupted Blood");
		this.deck.remove("Holy Grail");
		this.deck.remove("Cable");
		this.deck.remove("Pigeon");
		removeAll(this.deck.cards, "Copied ");
		this.fatigue = 1;
		for (Card c : this.getDeck()) {
			c.setCounters(0);
		}
		this.lifeTotal = 30;

	}

	private void removeAll(ArrayList<Card> cards, String string) {
		ArrayList<Card> removeList = new ArrayList<>();
		for (Card c : cards) {
			if (c.getName().contains(string)) {
				removeList.add(c);
			}
		}
		cards.removeAll(removeList);
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

	public Card rfgTop() {
		if (getDeck().size() > 0) {
			Card c = getDeck().remove(0);
			rfg.add(c);
			return c;
		}
		return null;
	}

	public String showDecklist() {
		ArrayList<String> cards = new ArrayList<String>();
		for (Card c : getDeck()) {
			cards.add(c.getName());
		}
		Collections.sort(cards);
		return cards.toString();
	}
}
