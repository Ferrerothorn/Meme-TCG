package cards;

import extraData.Card;
import game.Player;

public class Monastery extends Card {

	public Monastery() {
		this.name = "Monastery";
		this.setType("Spell");
	}

	public void onEntry(Player self, Player opponent) {
		self.lifeTotal += 2;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.lifeTotal > 100) {
			opponent.lifeTotal = 0;
		}
	}
}
