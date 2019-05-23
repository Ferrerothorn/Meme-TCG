package cards;

import extraData.Card;
import game.Player;

public class Sycamore extends Card {

	
	public Sycamore() {
		this.name = "Sycamore";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.movePile(self.grave, self.getHand());
		self.drawX(7);
	}	
}
