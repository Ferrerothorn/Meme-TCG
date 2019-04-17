package cards;

import extraData.Card;
import game.Player;

public class ThoughtScour extends Card {

	
	public ThoughtScour() {
		this.name = "Thought Scour";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.millX(2);
		self.draw();
	}	
}
