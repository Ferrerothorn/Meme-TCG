package cards;

import extraData.Card;
import game.Player;

public class Exorcise extends Card {

	public Exorcise() {
		this.name = "Exorcise";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.toggleGraveAbilities();
		opponent.toggleGraveAbilities();
	}
}
