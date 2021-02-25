package cards;

import extraData.Card;
import game.Player;

public class AncestralRecall extends Card {

	public AncestralRecall() {
		this.name = "Ancestral Recall";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(2);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		self.draw();
		self.draw();
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
