package cards;

import extraData.Card;
import game.Player;

public class TimeStop extends Card {

	public TimeStop() {
		this.name = "Time Stop";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.randomDiscard();
		this.setCounters(3);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters()>0) {
			if (self.lifeTotal < 10) {
				self.lifeTotal = 10;
			}
			this.takeCounter();
			if (getCounters() <= 0) {
				if (self.grave.remove(this)) {
					self.rfg.add(this);
				}
			}
		}
	}
}
