package cards;

import java.util.ArrayList;

import game.Player;

public class Zapstarter extends Card {

	
	public Zapstarter() {
		this.name = "Zapstarter";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().addAll(self.getHand());
		self.getHand().clear();
		ArrayList<Card> zaps = new ArrayList<>();
		for (Card c : self.getDeck()) {
			if (c.name.contains("Zap")) {
				zaps.add(c);
			}
		}
		self.getHand().addAll(zaps);
		self.getDeck().removeAll(zaps);
		if (self.getHand().size() == 0) {
			self.draw();
		}
	}	
}
