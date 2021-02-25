package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Collector extends Card {

	public Collector() {
		this.name = "Collector";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> collection = new ArrayList<Card>();
		int i = 0;
		while (i<self.getDeck().size() && collection.size()<3) {
			Card c = self.getDeck().get(i);
			if(!c.getType().equals("Spell")) {
				collection.add(c);
			}
			i++;
		}
		self.getHand().addAll(collection);
		self.getDeck().removeAll(collection);
		self.shuffle();
	}
}
