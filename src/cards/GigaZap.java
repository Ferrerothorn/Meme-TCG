package cards;

import extraData.Card;
import game.Player;

public class GigaZap extends Card {

	
	public GigaZap() {
		this.name = "Giga Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 5;
		self.lifeTotal -=2;
	}
	
	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>=2) {
				opponent.lifeTotal--;
			}
		}
	}	
}
