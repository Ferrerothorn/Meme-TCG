package cards;

import extraData.Card;
import game.Player;

public class Crossbowman extends Card {

	public Crossbowman() {
		this.name = "Crossbowman";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damage = 1;
		for (Card c : self.grave) {
			if (c.getType().equals("Hero")) {
				damage++;
			}
		}
		opponent.lifeTotal -= damage;
	}
}
