package cards;

import extraData.Card;
import game.Player;

public class BlueBolt extends Card {

	public BlueBolt() {
		this.name = "Blue Bolt";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(4);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= self.handSize();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
