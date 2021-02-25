package cards;

import extraData.Card;
import game.Player;

public class Salve extends Card {

	public Salve() {
		this.name = "Salve";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(3);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 4;
		self.draw();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
