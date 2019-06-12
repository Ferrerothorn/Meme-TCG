package extraData;

import game.Player;

public abstract class Card implements Cloneable {

	protected String name;
	int counters;

	public void onentry(Player self, Player opponent) {

	}

	public void afterResolving(Player self, Player opponent) {

	}

	public void graveAbility(Player self, Player opponent) {

	}

	public void whenDrawn(Player self) {
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public void addCounter() {
		counters++;
	}

	public void addCounters(int x) {
		while (x > 0) {
			counters++;
			x--;
		}
	}

	public void takeCounter() {
		if (counters > 0) {
			counters--;
		}
	}

	public void takeCounters(int x) {
		while (x > 0) {
			counters--;
			x--;
		}
	}

	public void setCounters(int x) {
		counters = x;
	}

	public int getCounters() {
		return counters;
	}

	public Card clone() throws CloneNotSupportedException {
		return (Card) super.clone();
	}
}
