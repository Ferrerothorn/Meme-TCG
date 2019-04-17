package cards;

import game.Player;

public class Lifezap extends Card {

	
	public Lifezap() {
		this.name = "Life Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-2;
		self.lifeTotal++;
	}
	
	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>=2) {
				opponent.lifeTotal--;
				self.lifeTotal++;
			}
		}
	}	
}
