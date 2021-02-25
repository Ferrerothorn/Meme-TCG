package cards;

import extraData.Card;
import game.Player;

public class Beast extends Card {

	public Beast() {
		this.name = "Beast";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(11);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (opponent.getHand().size() == 0) {
			opponent.movePile(opponent.rfg, opponent.grave);
			this.addCounter();
		} else {
			opponent.lifeTotal -= 2;
		}
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if(this.getCounters()>0) {
			opponent.lifeTotal -= 2;
		}
	}
}
