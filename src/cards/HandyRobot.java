package cards;

import extraData.Card;
import game.Player;

public class HandyRobot extends Card {

	public HandyRobot() {
		this.name = "Handy Robot";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.playsPerTurn++;
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
