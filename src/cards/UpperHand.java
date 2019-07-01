package cards;

import extraData.Card;
import game.Player;

public class UpperHand extends Card {

	public UpperHand() {
		this.name = "Upper Hand";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal--;
		self.lifeTotal++;
		self.draw();
		if (self.lifeTotal > opponent.lifeTotal || self.lifeTotal > 30) {
			opponent.randomDiscard();
		}
	}
}
