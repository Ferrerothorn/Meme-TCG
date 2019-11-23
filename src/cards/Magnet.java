package cards;

import extraData.Card;
import game.Player;

public class Magnet extends Card {

	
	public Magnet() {
		this.name = "Magnet";
		this.setType("Mech");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		for (Card c : self.getDeck()) {
			if (c.getType().equals("Mech")) {
				self.getHand().add(c);
				self.getDeck().remove(c);
				break;
			}
		}
		self.draw();
	}
}
