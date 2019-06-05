package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;
import game.Utils;

public class Photocopier extends Card {

	public Photocopier() {
		this.name = "Photocopier";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		for(Card c : opponent.getHand()) {
			Card card = Utils.newCardByName(c.getName());
			card.setName("Copycard");
			self.getDeck().add(card);
		}
		Collections.shuffle(self.getDeck());
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
