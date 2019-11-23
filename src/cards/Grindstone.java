package cards;

import extraData.Card;
import game.Player;

public class Grindstone extends Card {

	public Grindstone() {
		this.name = "Grindstone";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.millX(1);
	}
}
