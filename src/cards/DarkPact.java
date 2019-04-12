package cards;

import game.Player;

public class DarkPact extends Card {

	public DarkPact() {
		this.name = "Dark Pact";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal--;
		self.rfgFromDeck(1);
		self.drawX(2);
		opponent.randomDiscard();
	}
}
