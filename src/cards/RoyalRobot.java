package cards;

import extraData.Card;
import game.Player;

public class RoyalRobot extends Card {

	public RoyalRobot() {
		this.name = "Royal Robot";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(2);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters() > 0) {
			this.takeCounter();
			self.makePlay(opponent, false);
		}
	}
}
