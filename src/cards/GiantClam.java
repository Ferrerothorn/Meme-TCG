package cards;

import extraData.Card;
import game.Player;

public class GiantClam extends Card {

	public GiantClam() {
		this.name = "Giant Clam";
		this.setColor("Blue");
		this.setType("Creature");
		this.setPriority(3);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.millX(1);
	}
}
