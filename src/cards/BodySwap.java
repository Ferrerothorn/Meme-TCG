package cards;

import extraData.Card;
import game.Player;

public class BodySwap extends Card {

	
	public BodySwap() {
		this.name = "Body Swap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		int temp = self.lifeTotal;
		self.lifeTotal = opponent.lifeTotal;
		opponent.lifeTotal = temp;		
		self.draw();
	}
	
	
}
