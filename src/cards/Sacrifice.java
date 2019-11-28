package cards;

import extraData.Card;
import game.Player;

public class Sacrifice extends Card {

	public Sacrifice() {
		this.name = "Sacrifice";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= self.grave.size() / 2;
		self.movePile(self.getHand(), self.grave);
	}

}
