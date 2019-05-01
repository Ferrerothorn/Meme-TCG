package cards;

import java.util.Random;
import extraData.Card;
import game.Player;

public class EventualZap extends Card {

	public EventualZap() {
		this.name = "Eventual Zap";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		Random r = new Random();
		if (r.nextInt(2) == 0) {
			opponent.lifeTotal -= 4;
			if(self.grave.remove(this)) {
				self.rfg.add(this);
			}
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

	@Override
	public void graveAbility(Player self, Player opponent) {
		if(self.grave.remove(this)) {
			self.getDeck().add(this);
		}
	}
}
