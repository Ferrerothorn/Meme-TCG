package cards;

import extraData.Card;
import game.Player;

public class DarkZap extends Card {

	public DarkZap() {
		this.name = "Dark Zap";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 3;
		self.lifeTotal += 3;
		if (self.getDeck().size() > 0) {
			self.rfg.add(self.getDeck().remove(0));
		}
	}
	
	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>0) {
				opponent.lifeTotal--;
				self.lifeTotal++;
				c.takeCounter();
			}
		}
	}	
}
