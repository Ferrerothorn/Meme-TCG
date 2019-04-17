package cards;

import game.Player;

public abstract class Card {

	String name;
	int counters;

	public void onentry(Player self, Player opponent) {

	}

	public void afterResolving(Player self, Player opponent) {

	}

	public void graveAbility(Player self, Player opponent) {

	}

	public String getName() {
		return name;
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
		counters--;
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
}