package cards;

import extraData.Card;
import game.Player;

public class Gesper extends Card {

	
	public Gesper() {
		this.name = "Gesper";
		this.setType("Mech");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.randomDiscard();
		opponent.randomDiscard();
	}
}
