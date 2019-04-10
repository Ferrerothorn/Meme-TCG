package cards;

import game.Player;

public abstract class Card {

	String name;

	public void onentry(Player self, Player opponent) {

	}

	public void graveAbility(Player self, Player opponent) {

	}

	public String getName() {
		return name;
	}

}
