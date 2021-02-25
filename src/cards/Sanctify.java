package cards;

import extraData.Card;
import game.Player;

public class Sanctify extends Card {

	public Sanctify() {
		this.name = "Sanctify";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(11);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.rfg.addAll(opponent.grave);
		opponent.grave.clear();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
