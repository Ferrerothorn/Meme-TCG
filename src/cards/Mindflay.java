package cards;

import extraData.Card;
import game.Player;

public class Mindflay extends Card {

	public Mindflay() {
		this.name = "Mindflay";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(11);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
		if (self.grave.size() >= 4) {
			opponent.lifeTotal -= 1;
		}
		if (self.grave.size() >= 6) {
			opponent.lifeTotal -= 1;
		}
		if (self.grave.size() >= 8) {
			opponent.lifeTotal -= 1;
		}
	}
}
