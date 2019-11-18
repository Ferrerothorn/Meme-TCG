package cards;

import extraData.Card;
import game.Player;

public class Pirate extends Card {

	public Pirate() {
		this.name = "Pirate";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 2;

		if (self.getHand().size() > 0) {
			if (self.containsClass(self.getHand(), "Hero")) {
				opponent.randomDiscard();
				opponent.randomDiscard();
			}
		}
	}
}
