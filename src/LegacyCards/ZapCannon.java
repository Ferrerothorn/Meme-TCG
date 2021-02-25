package LegacyCards;

import java.util.Random;

import extraData.Card;
import game.Player;

public class ZapCannon extends Card {

	
	public ZapCannon() {
		this.name = "Zap Cannon";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		Random r = new Random();
		if (r.nextInt(2) == 0) {
			opponent.lifeTotal -=6;
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
