package cards;

import extraData.Card;
import game.Player;

public class WorkerAnt extends Card {

	public WorkerAnt() {
		this.name = "Worker Ant";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(6);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
	}
}
