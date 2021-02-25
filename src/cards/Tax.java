package cards;

import extraData.Card;
import game.Player;

public class Tax extends Card {

	public Tax() {
		this.name = "Tax";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(4);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.randomDiscard();
		opponent.randomDiscard();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
