package cards;

import extraData.Card;
import game.Player;

public class JunkHunter extends Card {

	
	public JunkHunter() {
		this.name = "Junk Hunter";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		for (Card c : self.getDeck()) {
			if (c.getName().contains("Junk")) {
				self.getHand().add(c);
				self.getDeck().remove(c);
				break;
			}
		}
		self.draw();
	}
}
