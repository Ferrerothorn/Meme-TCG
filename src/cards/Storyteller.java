package cards;

import extraData.Card;
import game.Player;

public class Storyteller extends Card {

	public Storyteller() {
		this.name = "Storyteller";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(8);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.drawX(2);
		opponent.drawX(2);
		self.lifeTotal += 2;
		opponent.lifeTotal += 2;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
