package cards;

import extraData.Card;
import game.Player;

public class TaxMan extends Card {

	public TaxMan() {
		this.name = "Tax Man";
		this.setColor("White");
		this.setType("Creature");
		this.setPriority(10);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.getHand().size() == 0) {
			opponent.millX(1);
		}

	}
}
