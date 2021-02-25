package cards;

import extraData.Card;
import game.Player;

public class HandyRobot extends Card {

	public HandyRobot() {
		this.name = "Handy Robot";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(1);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.playsPerTurn++;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}
}
