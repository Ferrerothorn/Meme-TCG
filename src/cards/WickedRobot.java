package cards;

import game.Player;

public class WickedRobot extends Card {

	public WickedRobot() {
		this.name = "Wicked Robot";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.playsPerTurn > 1) {
			opponent.playsPerTurn--;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
