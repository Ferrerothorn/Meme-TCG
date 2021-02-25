package LegacyCards;

import extraData.Card;
import game.Player;

public class ZapAndTap extends Card {

	public ZapAndTap() {
		this.name = "Zap and Tap";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal - 1;
		if (self.handContainsCardsWithType("Spell")) {
			self.draw(2);
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>0) {
				opponent.lifeTotal-= c.getCounters();
				c.takeCounter();
			}
		}
	}

}
