package cards;

import extraData.Card;
import game.Player;

public class ArcaneZap extends Card {

	public ArcaneZap() {
		this.name = "Arcane Zap";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.rfg.size() > 0) {
			opponent.lifeTotal -= self.rfg.size();
		} else {
			self.draw();
		}
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
