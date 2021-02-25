package cards;

import extraData.Card;
import game.Player;

public class FeistySorceress extends Card {

	public FeistySorceress() {
		this.name = "Feisty Sorceress";
		this.setColor("Black");
		this.setType("Creature");
		this.setPriority(7);
	}

	@Override
	public void onentry(Player self, Player opponent) {
	this.setCounters(0);
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		this.addCounter();
		switch (this.getCounters()) {
		case 1:
		case 2:
		case 3:
			self.randomDiscard();
			opponent.randomDiscard();
			break;
		case 4:
		case 5:
			opponent.millX(1);
			opponent.randomDiscard();
		case 6:
			opponent.discardAll();
			opponent.movePile(opponent.rfg, opponent.grave);
			rfgThis(self);
			break;
		}
	}

}
