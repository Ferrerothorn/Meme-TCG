package cards;

import java.util.ArrayList;

import game.Player;

public class SearchTheDarkness extends Card {

	public SearchTheDarkness() {
		this.name = "Search the Darkness";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().addAll(self.getHand());
		self.getHand().clear();
		ArrayList<Card> darkCards = new ArrayList<>();
		for (Card c : self.getDeck()) {
			if (c.name.contains("Dark")) {
				darkCards.add(c);
			}
		}
		self.getHand().addAll(darkCards);
		self.getDeck().removeAll(darkCards);
		if (self.getHand().size() == 0) {
			self.draw();
		}
	}
}
