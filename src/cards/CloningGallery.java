package cards;

import java.util.ArrayList;
import java.util.Collections;

import extraData.Card;
import game.Game;
import game.Player;

public class CloningGallery extends Card {

	public CloningGallery() {
		this.name = "Cloning Gallery";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		boolean clash = false;
		ArrayList<Card> cloningGallery = new ArrayList<Card>();

		while (!clash && self.getDeck().size() > 0) {
			Collections.shuffle(self.getDeck());
			Card c = self.getDeck().get(0);
			if (!c.getName().contains("Copied ") && self.cardCount(cloningGallery, c.getName()) < 1) {
				cloningGallery.add(Game.newCardByName(c.getName()));
			} else {
				clash = true;
			}
		}
		for (Card c : cloningGallery) {
			c.setName("Copied " + c.getName());
		}
		self.getHand().addAll(cloningGallery);
	}
}
