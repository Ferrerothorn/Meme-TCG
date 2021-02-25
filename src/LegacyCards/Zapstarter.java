package LegacyCards;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;
import game.Player;

public class Zapstarter extends Card {

	
	public Zapstarter() {
		this.name = "Zapstarter";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().addAll(self.getHand());
		self.getHand().clear();
		Collections.shuffle(self.getDeck());
		ArrayList<Card> zaps = new ArrayList<>();
		for (Card c : self.getDeck()) {
			if (c.getName().contains("Zap")) {
				zaps.add(c);
			}
		}
		self.getHand().addAll(zaps);
		self.getDeck().removeAll(zaps);
		if (self.getHand().size() == 0) {
			self.draw();
		}
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c: self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters()>0) {
				opponent.randomDiscard();
				opponent.randomDiscard();
				c.takeCounter();
			}
		}
	}	
}
