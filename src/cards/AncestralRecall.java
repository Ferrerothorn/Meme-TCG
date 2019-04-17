package cards;

import extraData.Card;
import game.Player;

public class AncestralRecall extends Card {

	
	public AncestralRecall() {
		this.name = "Ancestral Recall";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.drawX(3);
	}
	
	
}
