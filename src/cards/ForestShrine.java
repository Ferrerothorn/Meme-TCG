package cards;

import extraData.Card;
import game.Player;

public class ForestShrine extends Card {

	public ForestShrine() {
		this.name = "Forest Shrine";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(2);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(0);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		this.addCounter();
		self.lifeTotal += this.getCounters()/2;
		if (self.lifeTotal >= 30) {
			opponent.lifeTotal = 0;
		}
	}
}
