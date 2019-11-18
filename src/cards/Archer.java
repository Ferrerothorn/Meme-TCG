package cards;

import extraData.Card;
import game.Player;

public class Archer extends Card {

	public Archer() {
		this.name = "Archer";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int heroes = 0;
		for(Card c: self.getDeck()) {
			if (c.getType().equals("Hero")) {
				heroes++;
			}
		}
		heroes /=2;
		opponent.lifeTotal -= heroes;
	}
}
