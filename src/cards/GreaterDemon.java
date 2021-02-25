package cards;

import extraData.Card;
import game.Player;

public class GreaterDemon extends Card {

	public GreaterDemon() {
		this.name = "Greater Demon";
		this.setType("Creature");
		this.setColor("Red");
		this.setPriority(3);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.addCounter();
		self.lifeTotal -=3;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if(this.getCounters()>0) {
			opponent.lifeTotal -= 3;
		}
		else {
			this.shuffleBackIntoDeck(self);
		}
	}
}
