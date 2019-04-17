package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Apparition extends Card {

	public Apparition() {
		this.name = "Apparition";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.grave.size() > 0) {
			Collections.shuffle(self.grave);
			if (!self.grave.get(0).getName().equals("Apparition")) {
				self.grave.get(0).onentry(self, opponent);
			}
			else{
				self.draw();
			}
		}
		else{
			self.draw();
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
