package cards;

import extraData.Card;
import game.Player;

public class Sycamore extends Card {

	
	public Sycamore() {
		this.name = "Sycamore";
		this.setType("Spell");
		this.setColor("White");
		this.setPriority(11);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.movePile(self.getDeck(), self.getHand());
		self.shuffle();
		self.draw(6);
	}	
}
