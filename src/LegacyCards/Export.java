package LegacyCards;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;
import game.Player;

public class Export extends Card {

	public Export() {
		this.name = "Export";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getHand().size() > 0) {
			Collections.shuffle(self.getHand());
			Card c = self.getHand().get(0);
			String name = c.getName();
			self.grave.add(c);
			self.getHand().remove(c);

			ArrayList<Card> discard = new ArrayList();
			for (Card card : self.getDeck()) {
				if (card.getName().equals(name)) {
					discard.add(card);
				}
			}
			self.grave.addAll(discard);
			self.getDeck().removeAll(discard);
			self.draw(discard.size());
		}
	}
}