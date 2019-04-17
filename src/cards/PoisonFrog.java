package cards;

import extraData.Card;
import game.Player;

public class PoisonFrog extends Card {

	
	public PoisonFrog() {
		this.name = "Poison Frog";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.lifeTotal--;
	}
}
