package LegacyAHeroes;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class Bishop extends Card {

	public Bishop() {
		this.name = "Bishop";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int heal = 1;
		if (self.grave.size() > 0) {
			for (Card c : self.grave) {
				if (c.getType().equals("Hero")) {
					heal++;
				}
			}
		}
		self.lifeTotal += heal;

		if (self.grave.size() > 0) {
			Collections.shuffle(self.grave);
			if (self.grave.get(0).getType().equals("Hero")) {
				self.getHand().add(self.grave.remove(0));
			}
		}
	}
}
