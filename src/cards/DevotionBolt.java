package cards;

import extraData.Card;
import game.Player;

public class DevotionBolt extends Card {

	public DevotionBolt() {
		this.name = "Devotion Bolt";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 2;
		if (self.getDeck().size()>0) {
		if (self.getDeck().get(0).getColor().equals("Red")) {
			opponent.lifeTotal -= 2;
		}
		}
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
