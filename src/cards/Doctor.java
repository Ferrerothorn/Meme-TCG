package cards;

import extraData.Card;
import game.Player;
import game.Utils;

public class Doctor extends Card {

	public Doctor() {
		this.name = "Doctor";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(6);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getHand().size() > 0) {
			self.shuffleBackIn();
			for (int i = 0; i < 3; i++) {
				if (Utils.flipACoin()) {
					self.lifeTotal += 4;
				}
			}
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
