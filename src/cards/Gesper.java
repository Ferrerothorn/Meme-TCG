package cards;

import extraData.Card;
import game.Player;

public class Gesper extends Card {

	
	public Gesper() {
		this.name = "Gesper";
		this.setType("Creature");
		this.setColor("Blue");
		this.setPriority(1);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.randomDiscard();
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.randomDiscard();
	}
}
