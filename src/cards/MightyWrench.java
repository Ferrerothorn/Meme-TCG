package cards;

import extraData.Card;
import game.Player;

public class MightyWrench extends Card {

	public MightyWrench() {
		this.name = "Mighty Wrench";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int wrenches = 0;
		for (Card c : self.grave) {
			if (c.getCounters() > 0) {
				wrenches++;
			}
		}
		while (opponent.getHand().size() > 0 && wrenches > 0) {
			wrenches--;
			opponent.randomDiscard();
		}
		while (wrenches > 0 && self.getDeck().size() > 0) {
			self.draw();
			wrenches--;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
