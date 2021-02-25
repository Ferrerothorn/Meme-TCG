package cards;

import extraData.Card;
import game.Player;

public class Woodcutter extends Card {

	public Woodcutter() {
		this.name = "Woodcutter";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(5);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(self.lifeTotal);
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if (this.getCounters() <= self.lifeTotal) {
			opponent.lifeTotal--;
			self.drawX(2);
			this.setCounters(self.lifeTotal);
		}
		else {
			rfgThis(self);
		}
	}
}
