package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	private boolean graveAbilitiesOn = true;
	public int losses = 0;
	static boolean debug = false;

	public boolean getGraveAbilities() {
		return graveAbilitiesOn;
	}

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
			this.lifeTotal = 0;
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
				debug("Milled " + deck.get(0).getName());
				grave.add(deck.remove(0));
			}
		}
	}

	public void add(Card c) {
		deck.add(c);
	}

	public void draw(int x) {
		for (int i = 0; i < x; i++) {
			draw();
		}
	}

	public boolean isAlive() {
		return lifeTotal > 0 && getDeck().size() < 200;
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
		if (debug) {
			System.out.println(string);
		}
	}

	public void cleanup() {
		this.deck.addAll(this.grave);
		this.grave.clear();
		this.deck.addAll(this.rfg);
		this.rfg.clear();
		this.deck.addAll(this.hand);
		this.hand.clear();

		ArrayList<Card> junk = new ArrayList<Card>();
		for (Card c : deck.cards) {
			if (c.getType().equals("Junk")) {
				junk.add(c);
			}
		}
		this.deck.removeAll(junk);
		removeAll(this.getDeck(), "Copied ");
		for (Card c : this.getDeck()) {
			c.setCounters(0);
		}
		this.lifeTotal = 30;
		Collections.shuffle(this.getDeck());
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
		String decklist = "";
		if (this != null) {
			HashMap<String, Integer> topCut = new HashMap<>();
			for (Card c : this.getDeck()) {
				topCut.put(c.getName(), topCut.getOrDefault(c.getName(), 0) + 1);
			}
			decklist = "";
			Iterator it = topCut.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				decklist += pair.getKey() + "-" + pair.getValue() + ",";
			}
		}
		return decklist;
	}

	public void toggleGraveAbilities(boolean b) {
		graveAbilitiesOn = b;
	}

	public void setDeck(ArrayList<Card> parseDeckFromLine) {
		deck.clear();
		deck.addAll(parseDeckFromLine);
	}

	public void shuffle() {
		Collections.shuffle(this.getDeck());
	}

	public boolean containsClass(ArrayList<Card> pile, String string) {
		for (Card c : pile) {
			if (c.getType().equals(string)) {
				return true;
			}
		}
		return false;
	}

	public int containsXCardsFromClass(ArrayList<Card> pile, String string) {
		int i = 0;
		for (Card c : pile) {
			if (c.getType().equals(string)) {
				i++;
			}
		}
		return i;
	}
}
