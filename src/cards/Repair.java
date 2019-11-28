package cards;
import java.util.Collections;

import extraData.Card;
import game.Player;

public class Repair extends Card {

	public Repair() {
		this.name = "Repair";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		rfgThis(self);
		if (self.getDeck().size() <= 3) {
			self.movePile(self.getDeck(), self.grave);
			Collections.shuffle(self.getDeck());
		}

		if (self.lifeTotal < opponent.lifeTotal) {
			self.lifeTotal = opponent.lifeTotal;
		}
	}
}
