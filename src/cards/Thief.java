package cards;

import extraData.Card;
import game.Player;

public class Thief extends Card {

	public Thief() {
		this.name = "Thief";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(opponent.getLife());
		if (self.cardCount(self.grave, "Thief") > 2) {
			opponent.randomDiscard();
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.getLife() < this.getCounters()) {
			opponent.randomDiscard();
		}
		this.setCounters(opponent.getLife());
	}
}
