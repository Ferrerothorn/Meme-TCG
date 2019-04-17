package cards;

import extraData.Card;
import game.Player;

public class Zap extends Card {

	
	public Zap() {
		this.name = "Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-3;
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
