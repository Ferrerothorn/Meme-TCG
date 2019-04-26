package cards;

import java.util.Collections;

import extraData.Card;
import extraData.Pigeon;
import game.Player;

public class TastyBread extends Card {

	public TastyBread() {
		this.name = "Tasty Bread";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 3;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters() <= 10) {
			this.addCounter();
			self.getDeck().add(new Pigeon());
			Collections.shuffle(self.getDeck());
		}
		this.addCounter();
		if(this.getCounters()>=10) {
			if(self.grave.remove(this)) {
				self.rfg.add(this);
			}
		}
	}
}
