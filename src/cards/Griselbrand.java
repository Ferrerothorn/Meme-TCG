package cards;

import extraData.Card;
import game.Player;

public class Griselbrand extends Card {

	public Griselbrand() {
		this.name = "Griselbrand";
		this.setType("Monster");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int counter = 0;
		while (self.lifeTotal > 1 && self.getDeck().size() > 0 && counter < 7) {
			self.lifeTotal--;
			self.draw();
			counter++;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
