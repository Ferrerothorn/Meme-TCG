package cards;

import game.Player;

public class Donate extends Card {

	
	public Donate() {
		this.name = "Donate";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal+=opponent.grave.size();
		opponent.movePile(opponent.getHand(), opponent.getGrave());
	}
}
