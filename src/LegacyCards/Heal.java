package LegacyCards;

import extraData.Card;
import game.Player;

public class Heal extends Card {

	public Heal() {
		this.name = "Heal";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 4;
	}
}
