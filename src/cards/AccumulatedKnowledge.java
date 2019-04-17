package cards;

import extraData.Card;
import game.Player;

public class AccumulatedKnowledge extends Card {

	public AccumulatedKnowledge() {
		this.name = "Accumulated Knowledge";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if(self.cardCount(self.grave, "Accumulated Knowledge") >=2) {
			self.draw();
		}
	}
}
