package cards;

import extraData.Card;
import game.Player;

public class Pirate extends Card {

	public Pirate() {
		this.name = "Pirate";
		this.setColor("Black");
		this.setType("Hero");
		this.setPriority(5);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
		opponent.randomDiscard();
		
		if (self.getHand().size() > 0) {
			if (self.containsClass(self.getHand(), "Hero")) {
				opponent.lifeTotal -= 1;
				opponent.randomDiscard();
			}
		}
	}
}
