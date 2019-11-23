package cards;

import extraData.Card;
import game.Player;

public class DarkPact extends Card {

	public DarkPact() {
		this.name = "Dark Pact";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal--;
		self.rfgFromDeck(1);
		self.draw(2);
		opponent.randomDiscard();
	}
}
