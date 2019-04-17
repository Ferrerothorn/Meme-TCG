package cards;

import extraData.Card;
import game.Player;

public class RobotAssassin extends Card {

	public RobotAssassin() {
		this.name = "Robot Assassin";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.grave.size() >= 7 || opponent.grave.size() >= 7) {
			opponent.lifeTotal -= 2;
		}
	}
}
