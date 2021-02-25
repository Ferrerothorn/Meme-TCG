package cards;

import extraData.Card;
import game.Player;

public class Alchemy extends Card {

	public Alchemy() {
		this.name = "Alchemy";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(12);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damage = 0;
		if (self.colorCount(self.grave, "Red") > 0) {
			damage++;
		}

		if (self.colorCount(self.grave, "Blue") > 0) {
			damage++;
		}

		if (self.colorCount(self.grave, "Green") > 0) {
			damage++;
		}

		if (self.colorCount(self.grave, "White") > 0) {
			damage++;
		}

		if (self.colorCount(self.grave, "Black") > 0) {
			damage++;
		}

		opponent.lifeTotal -= damage;
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
