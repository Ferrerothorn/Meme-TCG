package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Frenzy extends Card {

	public Frenzy() {
		this.name = "Frenzy";
		this.setColor("Red");
		this.setType("Spell");
		this.setPriority(12);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> spells = new ArrayList<Card>();
		for (Card c : self.grave) {
			if (c.getType().equals("Spell")) {
				spells.add(c);
			}
		}
		
		for (Card spell : spells) {
			if (!spell.getName().equals("Frenzy")) {
				self.getHand().add(spell);
				self.grave.remove(spell);
			}
		}
		spells.clear();

		for (Card c : opponent.grave) {
			if (c.getType().equals("Spell")) {
				spells.add(c);
			}
		}
		for (Card spell : spells) {
			if (!spell.getName().equals("Frenzy")) {
				opponent.getHand().add(spell);
				opponent.grave.remove(spell);
			}
		}
	}

	@Override
	public void afterResolving(Player self, Player opponent) {

	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
