package cards;

import extraData.Card;
import game.Player;

public class Spite extends Card {

	public Spite() {
		this.name = "Spite";
		this.setColor("Black");
		this.setType("Spell");
		this.setPriority(9);
	}

	@Override
	public void onentry(Player self, Player opponent) {

		if (opponent.lifeTotal <= self.lifeTotal) {
			opponent.lifeTotal -= 2;
		} else {
			opponent.lifeTotal -= 4;
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
