package cards;

import extraData.Card;
import game.Player;

public class TempoDrain extends Card {

	public TempoDrain() {
		this.name = "Tempo Drain";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		opponent.randomDiscard();
	}

}
