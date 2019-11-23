package cards;

import extraData.Card;
import game.Player;

public class AncestralRecall extends Card {

	
	public AncestralRecall() {
		this.name = "Ancestral Recall";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.draw(3);
	}
	
	
}
