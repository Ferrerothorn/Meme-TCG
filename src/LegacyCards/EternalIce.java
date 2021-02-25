package LegacyCards;

import extraData.Card;
import extraData.Ice;
import game.Player;

public class EternalIce extends Card {

	
	public EternalIce() {
		this.name = "Eternal Ice";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.getDeck().add(new Ice());
		opponent.shuffle();
	}
}
