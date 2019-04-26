package cards;

import extraData.Card;
import game.Player;

public class Locke extends Card {

	public Locke() {
		this.name = "Locke";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(opponent.getLife());
		if (self.cardCount(self.grave, "Locke") > 2) {
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
