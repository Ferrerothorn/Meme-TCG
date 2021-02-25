package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Tarmogoyf extends Card {

	public Tarmogoyf() {
		this.name = "Tarmogoyf";
		this.setType("Creature");
		this.setColor("Green");
		this.setPriority(8);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
		ArrayList<String> differentTypes = new ArrayList<>();
		for (Card c : self.grave) {
			if (c != this && !differentTypes.contains(c.getType())) {
				differentTypes.add(c.getType());
			}
		}
		for (Card c : opponent.grave) {
			if (c != this && !differentTypes.contains(c.getType())) {
				differentTypes.add(c.getType());
			}
		}
		int damage = differentTypes.size();

		if (damage > 0) {
			opponent.lifeTotal -= damage;
		}
	}
}