package cards;

import extraData.Card;
import game.Player;

public class DrainLife extends Card {

	public DrainLife() {
		this.name = "Drain Life";
		this.setColor("Black");
		this.setType("Spell");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 2;
		self.lifeTotal += 1;
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
