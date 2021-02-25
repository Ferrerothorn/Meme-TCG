package cards;

import extraData.Card;
import extraData.KillerBee;
import extraData.WorkerBee;
import game.Player;

public class Hive extends Card {

	public Hive() {
		this.name = "Hive";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(4);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(self.grave.size());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.grave.size() > this.getCounters()) {
			self.getDeck().add(new WorkerBee());
			self.shuffle();
			opponent.getDeck().add(new KillerBee());
			opponent.shuffle();
			
		}
		this.setCounters(self.grave.size());
	}
}
