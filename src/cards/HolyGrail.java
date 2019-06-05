package cards;

import extraData.Card;
import game.Player;

public class HolyGrail extends Card {

	public HolyGrail() {
		this.name = "Holy Grail";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 10000;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
