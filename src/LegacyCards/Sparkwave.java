package LegacyCards;

import extraData.Card;
import game.Player;

public class Sparkwave extends Card {

	public Sparkwave() {
		this.name = "Sparkwave";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getDeck().size() > 0) {
			if (self.getDeck().get(0).getName().contains("Zap")) {
				opponent.lifeTotal -= 7;
			} else {
				opponent.lifeTotal -= 1;
			}
		}
	}

}
