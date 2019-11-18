package cards;

import extraData.Card;
import game.Player;

public class ShuttleZap extends Card {

	public ShuttleZap() {
		this.name = "Shuttle Zap";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal-=2;
		if(self.cardCount(self.grave, "Shuttle Zap")>0 && self.cardCount(self.getDeck(), "Shuttle Zap")>0) {
			self.getDeck().add(this);
			self.grave.remove(this);
			self.shuffle();
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