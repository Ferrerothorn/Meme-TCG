package cards;

import extraData.Card;
import game.Player;

public class FireWizard extends Card {

	public FireWizard() {
		this.name = "Fire Wizard";
		this.setType("Hero");
		this.setColor("Red");
		this.setPriority(6);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 2;
		if (self.getHand().size() > 0) {
			for (Card c : self.getHand()) {
				if (c.getType().equals("Hero")) {
					opponent.lifeTotal -= 1;
				}
			}
		}
	}
}
