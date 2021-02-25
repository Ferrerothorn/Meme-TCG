package LegacyCards;

import extraData.Card;
import game.Player;

public class Crossbowman extends Card {

	public Crossbowman() {
		this.name = "Crossbowman";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int fallenHeroes = 0;
		for (Card c : self.grave) {
			if (c.getType().equals("Hero")) {
				fallenHeroes++;
			}
		}

		if (fallenHeroes > 2) {
			opponent.lifeTotal -= 2;
		}
		if (fallenHeroes > 5) {
			opponent.lifeTotal -= 2;
		}
		if (fallenHeroes > 9) {
			opponent.lifeTotal -= 2;
		}

	}
}
