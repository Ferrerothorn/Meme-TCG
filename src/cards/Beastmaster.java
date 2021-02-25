package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Beastmaster extends Card {

	public Beastmaster() {
		this.name = "Beastmaster";
		this.setColor("Green");
		this.setType("Hero");
		this.setPriority(12);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		ArrayList<Card> temp = new ArrayList<Card>();
		for (Card c: self.grave) {
			if (c.getType().equals("Creature")) {
				temp.add(c);
			}
		}
		for (Card c : temp) {
			c.graveAbility(self, opponent);
		}

		
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if (self.typeCount(self.grave, "Hero") >3) {
			if(self.grave.remove(this)) {
				self.getHand().add(this);
			}
		}
	}
}
