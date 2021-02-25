package cards;

import extraData.Card;
import game.Player;

public class WhiteBolt extends Card {

	public WhiteBolt() {
		this.name = "White Bolt";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(70);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 5;
		self.draw();
		opponent.playsPerTurn++;
	}

	@Override
	public void afterResolving(Player self, Player opponent) {
		for (Card c : self.grave) {
			if (c.getName().equals("Zap Magnifier") && c.getCounters() > 0) {
				opponent.lifeTotal -= c.getCounters();
				c.takeCounter();
			}
		}
	}
}
