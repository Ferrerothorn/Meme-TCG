package cards;

import extraData.Card;
import game.Player;

public class Checkmate extends Card {

	public Checkmate() {
		this.name = "Checkmate";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if(opponent.getHand().size()==0) {
			opponent.movePile(opponent.rfg, opponent.grave);
			if(self.playsPerTurn<2) {
			self.playsPerTurn = 2;
			}
		}
		opponent.lifeTotal -= 2;
	}
}
