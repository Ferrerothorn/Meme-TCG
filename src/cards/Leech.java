package cards;

import extraData.Card;
import game.Player;

public class Leech extends Card {

	public Leech() {
		this.name = "Leech";
		this.setType("Creature");
		this.setColor("Green");
		this.setPriority(11);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.grave.size() >= 7) {
			opponent.lifeTotal -= 2;
			self.lifeTotal++;
		}
	}
}
