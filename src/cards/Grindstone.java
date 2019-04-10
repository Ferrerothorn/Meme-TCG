package cards;

import game.Player;

public class Grindstone extends Card {

	public Grindstone() {
		this.name = "Grindstone";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.millX(1);
	}
}
