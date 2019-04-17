package cards;

import extraData.Card;
import game.Player;

public class ZapAndTap extends Card {

	public ZapAndTap() {
		this.name = "Zap and Tap";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal - 1;
		self.draw();
		if (self.getHand().size() == 1) {
			self.draw();
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>0) {
				opponent.lifeTotal--;
				c.takeCounter();
			}
		}
	}

}
