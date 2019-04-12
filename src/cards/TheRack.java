package cards;

import game.Player;

public class TheRack extends Card {

	public TheRack() {
		this.name = "The Rack";
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.getHand().size() <= 2) {
			opponent.lifeTotal -= (2 - opponent.getHand().size());
		}
	}
}
