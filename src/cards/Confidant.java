package cards;

import extraData.Card;
import game.Player;

public class Confidant extends Card {

	public Confidant() {
		this.name = "Confidant";
		this.setColor("Black");
		this.setType("Creature");
		this.setPriority(7);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		self.draw();
		self.lifeTotal--;
	}
}