package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class DoublingZap extends Card {

	
	public DoublingZap() {
		this.name = "Doubling Zap";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-2;
		Zap newZap = new Zap();
		newZap.setName("Copied " + newZap.getName());
		self.getHand().add(newZap);
		Collections.shuffle(self.getHand());
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
