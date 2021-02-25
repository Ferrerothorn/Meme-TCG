package cards;

import extraData.Card;
import game.Player;

public class DarkPact extends Card {

	public DarkPact() {
		this.name = "Dark Pact";
		this.setColor("Black");
		this.setType("Spell");
		this.setPriority(5);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal--;
		self.rfgFromDeck(1);
		self.draw(1);
		opponent.randomDiscard();
		opponent.randomDiscard();
		opponent.millX(1);
	}
}
