package cards;

import extraData.Card;
import game.Player;

public class Checkmate extends Card {

	public Checkmate() {
		this.name = "Checkmate";
		this.setType("Spell");
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
