package LegacyCards;

import extraData.Card;
import game.Player;

public class Mend extends Card {

	public Mend() {
		this.name = "Mend";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 7;
		self.millX(2);
	}
}
