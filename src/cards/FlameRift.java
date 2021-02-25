package cards;

import extraData.Card;
import game.Player;

public class FlameRift extends Card {

	public FlameRift() {
		this.name = "Flame Rift";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 4;
		self.lifeTotal -= 4;
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
