package cards;

import java.util.ArrayList;
import extraData.Card;
import game.Player;

public class Recover extends Card {

	public Recover() {
		this.name = "Recover";
		this.setColor("White");
		this.setType("Spell");
		this.setPriority(9);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Card g : self.grave) {
			if (handContainsName(g.getName(), self)) {
				cards.add(g);
			}
		}
		self.getDeck().addAll(cards);
		self.grave.removeAll(cards);
		self.shuffle();
	}

	private boolean handContainsName(String name, Player self) {
		for (Card c : self.getHand()) {
			if (c.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
