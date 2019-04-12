package cards;

import java.util.Collections;

import game.Player;

public class CorporateShredder extends Card {

	public CorporateShredder() {
		this.name = "Corporate Shredder";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.rfgFromDeck(1);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		if (opponent.grave.size() > 0) {
			Collections.shuffle(opponent.grave);
			opponent.rfg.add(opponent.grave.remove(0));
		}
	}
}
