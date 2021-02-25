package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Fry extends Card {

	public Fry() {
		this.name = "Fry";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(9);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> fries = new ArrayList<Card>();
		for (Card c : opponent.grave) {
			if (c.getType().equals("Creature")) {
				fries.add(c);
			}
		}
		for (Card fry : fries) {
			opponent.rfg.add(fry);
			opponent.grave.remove(fry);
		}
		opponent.lifeTotal -= 1;
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
