package cards;

import extraData.Card;
import game.Player;

public class Sycamore extends Card {

	
	public Sycamore() {
		this.name = "Sycamore";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		while(self.getHand().size()>0) {
		self.randomDiscard();
		}
		self.drawX(7);
	}	
}
