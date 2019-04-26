package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Recycle extends Card {

	public Recycle() {
		this.name = "Recycle";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.addCounter();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters() > 0 && self.getDeck().size() == 0) {
			if (self.grave.remove(this)) {
				self.rfg.add(this);
			}
			self.movePile(self.getDeck(), self.grave);
			Collections.shuffle(self.getDeck());
		}
	}
}
