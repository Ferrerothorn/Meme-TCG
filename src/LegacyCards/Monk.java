package LegacyCards;

import extraData.Card;
import game.Player;

public class Monk extends Card {

	public Monk() {
		this.name = "Monk";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int damageAndHeal = 0;
		for (Card c : self.grave) {
			if ((c.getName().contains("Monk") || c.getName().contains("Monastery"))) {
				damageAndHeal += 1;
			}
		}
		self.lifeTotal += damageAndHeal;
		opponent.lifeTotal -= damageAndHeal;
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
