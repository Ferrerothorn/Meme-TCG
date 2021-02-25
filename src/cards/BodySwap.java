package cards;

import extraData.Card;
import game.Player;

public class BodySwap extends Card {

	public BodySwap() {
		this.name = "Body Swap";
		this.setType("Spell");
		this.setColor("Blue");
		this.setPriority(8);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.lifeTotal < opponent.lifeTotal) {
			int temp = self.lifeTotal;
			self.lifeTotal = opponent.lifeTotal;
			opponent.lifeTotal = temp;
		} 
	}
}
