package cards;

import extraData.Card;
import game.Player;

public class BodySwap extends Card {

	public BodySwap() {
		this.name = "Body Swap";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.lifeTotal < opponent.lifeTotal) {
			int temp = self.lifeTotal;
			self.lifeTotal = opponent.lifeTotal;
			opponent.lifeTotal = temp;
		}
		self.draw();
	}
}
