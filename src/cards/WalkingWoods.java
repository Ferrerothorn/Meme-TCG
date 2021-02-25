package cards;

import extraData.Card;
import game.Player;

public class WalkingWoods extends Card {

	
	public WalkingWoods() {
		this.name = "Walking Woods";
		this.setColor("Green");
		this.setType("Creature");
		this.setPriority(7);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal++;
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.lifeTotal++;
	}
}
