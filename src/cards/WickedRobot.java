package cards;

import extraData.Card;
import game.Player;

public class WickedRobot extends Card {

	public WickedRobot() {
		this.name = "Wicked Robot";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.playsPerTurn > 1) {
			opponent.playsPerTurn--;
		}
	}
}
