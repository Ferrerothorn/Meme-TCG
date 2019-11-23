package game;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;

public class Deck {

	public ArrayList<Card> cards = new ArrayList<>();

	public void add(Card c) {
		cards.add(c);
	}

	public int cardCount(String string) {
		int i = 0;
		for (Card cs : cards) {
			if (cs.getName().equals(string)) {
				i++;
			}
		}
		return i;
	}

	public int size() {
		return cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card remove(int i) {
		return cards.remove(0);
	}

	public void remove(String string) {
		ArrayList<Card> filter = new ArrayList<>();
		for (Card c : cards) {
			if (c.getName().equals(string)) {
				filter.add(c);
			}
		}
		cards.removeAll(filter);
	}

	public void addAll(ArrayList<Card> newCards) {
		cards.addAll(newCards);
	}

	public void addCard(Card c) {
		cards.add(c);
	}

	public void removeIfContains(String string) {
		ArrayList<Card> filter = new ArrayList<>();
		for (Card c : cards) {
			if (c.getName().contains(string)) {
				filter.add(c);
			}
		}
		cards.removeAll(filter);
	}

	public void clear() {
		cards.clear();
	}

	public Card get(int i) {
		return (cards.get(i));
	}

	public void remove(Card c) {
		cards.remove(c);
	}

	public void removeAll(ArrayList<Card> junk) {
		cards.removeAll(junk);
	}

}
