package cards;

import extraData.Card;
import game.Player;

public class SpireOfIndustry extends Card {

	public SpireOfIndustry() {
		this.name = "Spire of Industry";
		this.setType("Spell");
		this.setColor("Red");
		this.setPriority(4);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.getHand().size() >= 7) {
			self.lifeTotal += 4;
			opponent.lifeTotal -= 4;
		} else if (self.getHand().size() >= 4) {
			self.lifeTotal += 2;
			opponent.lifeTotal -= 2;
		} else {
			self.lifeTotal += 1;
		}
	}
}
