package LegacyCards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Remembrance extends Card {

	public Remembrance() {
		this.name = "Remembrance";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.grave.size() > 5) {
			ArrayList<Card> triggers = new ArrayList<>();
			triggers.addAll(self.grave);
			for (Card c : triggers) {
				if (!self.isAlive() || !opponent.isAlive()) {
					break;
				}
				c.graveAbility(self, opponent);
			}
			triggers.clear();
		}
	}
}
