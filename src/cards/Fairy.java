package cards;

import extraData.Card;
import game.Player;

public class Fairy extends Card {

	public Fairy() {
		this.name = "Fairy";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(12);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.getHand().size() == 0) {
			self.draw();
		}
	}
}
