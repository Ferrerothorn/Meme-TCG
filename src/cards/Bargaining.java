package cards;

import extraData.Card;
import game.Player;

public class Bargaining extends Card {

	public Bargaining() {
		this.name = "Bargaining";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getHand().size() >= 1) {
			self.randomDiscard();
			self.playsPerTurn++;
		}
		if (self.playsPerTurn > 2) {
			self.playsPerTurn++;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
