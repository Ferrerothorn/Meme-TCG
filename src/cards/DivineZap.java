package cards;

import extraData.Card;
import game.Player;

public class DivineZap extends Card {

	public DivineZap() {
		this.name = "Divine Zap";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 5;
		self.draw();
		opponent.playsPerTurn++;
	}

	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c : self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters() > 0) {
				opponent.lifeTotal -= c.getCounters();
				c.takeCounter();
			}
		}
	}
}
