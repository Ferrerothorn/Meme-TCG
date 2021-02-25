package LegacyCards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Regrow extends Card {

	public Regrow() {
		this.name = "Regrow";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Collections.shuffle(self.grave);
		if (self.grave.size() >= 2) {
			Collections.shuffle(self.grave);
			self.getDeck().add(self.grave.remove(0));
			self.getDeck().add(self.grave.remove(0));
			Collections.shuffle(self.getDeck());
		}
		else {
			self.draw();
		}
	}
}