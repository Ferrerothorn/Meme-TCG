package cards;

import extraData.Card;
import game.Player;

public class Monk extends Card {

	public Monk() {
		this.name = "Monk";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int heal = 0;
		opponent.lifeTotal -= 2;
		for (Card c : self.grave) {
			if ((c.getName().contains("Monk") || c.getName().contains("Monastery")) || !c.equals(this)) {
				heal += 2;
			}
		}
		self.lifeTotal += heal;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
