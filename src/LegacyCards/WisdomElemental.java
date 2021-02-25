package LegacyCards;

import extraData.Card;
import game.Player;

public class WisdomElemental extends Card {

	public WisdomElemental() {
		this.name = "Wisdom Elemental";
		this.setType("Monster");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		this.setCounters(0);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		this.addCounter();
		switch (this.getCounters()) {
		case 1:
		case 2:
		case 3:
			self.draw();
			break;
		case 4:
			opponent.lifeTotal -= 3 * self.getHand().size();
			rfgThis(self);
			break;
		}
	}

}
