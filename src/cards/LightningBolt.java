package cards;

import extraData.Card;
import game.Player;

public class LightningBolt extends Card {

	public LightningBolt() {
		this.name = "Lightning Bolt";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-3;
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
