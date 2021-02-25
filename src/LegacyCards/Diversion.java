package LegacyCards;

import extraData.Card;
import extraData.RoadCone;
import game.Player;

public class Diversion extends Card {

	public Diversion() {
		this.name = "Diversion";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.getDeck().add(0, new RoadCone());
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
