package cards;

import extraData.Card;
import game.Player;

public class Demon extends Card {

	public Demon() {
		this.name = "Demon";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -=3;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
			opponent.lifeTotal -= 2;
	}
}
