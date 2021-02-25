package LegacyCards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Hoover extends Card {

	public Hoover() {
		this.name = "Hoover";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> junk = new ArrayList<Card>();
		for (Card c : self.getDeck()) {
			if (c.getType().equals("Junk")) {
				junk.add(c);
			}
		}
		for (Card c : self.grave) {
			if (c.getType().equals("Junk")) {
				junk.add(c);
			}
		}
		self.getDeck().removeAll(junk);
		self.grave.removeAll(junk);
		self.draw();
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
