package cards;

import extraData.Card;
import game.Player;

public class ComebackZap extends Card {

	public ComebackZap() {
		this.name = "Comeback Zap";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.lifeTotal < opponent.lifeTotal) {
			opponent.lifeTotal -= 2;
		}
		opponent.lifeTotal -= 2;
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
