package cards;

import extraData.Card;
import game.Player;

public class DarkContract extends Card {

	public DarkContract() {
		this.name = "Dark Contract";
		this.setColor("Black");
		this.setType("Spell");
		this.setPriority(6);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getHand().size() > 0) {
			self.shuffleBackIn();
			opponent.lifeTotal -= 5;
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
