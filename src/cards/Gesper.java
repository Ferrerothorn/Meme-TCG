package cards;

import game.Player;

public class Gesper extends Card {

	
	public Gesper() {
		this.name = "Gesper";
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
