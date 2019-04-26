package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Repair extends Card {

	public Repair() {
		this.name = "Repair";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if(self.grave.remove(this)) {
			self.rfg.add(this);
		}
		if (self.getDeck().size() <= 3) {
			self.movePile(self.getDeck(), self.grave);
		}
		ArrayList<Card> corruption = new ArrayList<Card>();
		for (Card c : self.getDeck()) {
			if (c.getName().equals("Corrupted Blood")) {
				corruption.add(c);
			}
		}
		self.getDeck().removeAll(corruption);
		if (self.lifeTotal < opponent.lifeTotal) {
			self.lifeTotal = opponent.lifeTotal;
		}
	}
}
