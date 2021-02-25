package LegacyCards;

import extraData.Card;
import game.Player;

public class MulchMunch extends Card {

	public MulchMunch() {
		this.name = "Mulch Munch";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += self.grave.size();
	}
}
