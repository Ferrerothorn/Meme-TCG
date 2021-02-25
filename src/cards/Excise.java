package cards;

import extraData.Card;
import game.Player;

public class Excise extends Card {

	public Excise() {
		this.name = "Excise";
		this.setType("Spell");
		this.setColor("White");
		this.setPriority(4);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		String excise = "";
		if (opponent.deckSize() > 0) {
			excise = opponent.getDeck().get(0).getName();
		}
		
		if (opponent.deckSize() > 0) {
			excise = opponent.getDeck().get(0).getName();
			self.removeAllCopies("Excise", self.getDeck());
			opponent.removeAllCopies(excise, opponent.getDeck());
		}
		if (opponent.handSize() > 0) {
			opponent.removeAllCopies(excise, opponent.getHand());
		}
		if (opponent.grave.size() > 0) {
			opponent.removeAllCopies(excise, opponent.grave);
		}
	}
}
