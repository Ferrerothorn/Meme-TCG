package cards;

import extraData.Card;
import game.Player;

public class DarkZap extends Card {

	public DarkZap() {
		this.name = "Dark Zap";
		this.setType("Spell");
		this.setColor("Black");
		this.setPriority(7);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getDeck().size() > 0) {
			self.rfgTop();
			opponent.lifeTotal -= 3;
			self.lifeTotal += 3;
		}
		this.rfgThis(self);
	}
	
	@Override
	public void afterResolving(Player self, Player opponent) {
	}
}
