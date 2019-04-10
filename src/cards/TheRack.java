package cards;

import game.Player;

public class TheRack extends Card {

	public TheRack() {
		this.name = "The Rack";
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.lifeTotal -= (3 - opponent.getHand().size());
	}
}
