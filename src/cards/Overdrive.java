package cards;

import java.util.ArrayList;

import extraData.Card;
import game.Player;

public class Overdrive extends Card {

	public Overdrive() {
		this.name = "Overdrive";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= self.getHand().size();
		ArrayList<Card> cs = new ArrayList<>();
		for(Card c : self.getHand()) {
			cs.add(c);
		}
		for(Card c : cs) {
			c.onentry(self, opponent);
		}
	}
}
