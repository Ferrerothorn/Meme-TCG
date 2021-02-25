package cards;

import extraData.Card;
import game.Player;

public class Harass extends Card {

	public Harass() {
		this.name = "Harass";
		this.setColor("Black");
		this.setType("Spell");
		this.setPriority(4);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		opponent.randomDiscard();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
