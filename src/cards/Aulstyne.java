package cards;

import extraData.Card;
import game.Player;

public class Aulstyne extends Card {

	public Aulstyne() {
		this.name = "Aulstyne";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if(opponent.getHand().size()==0) {
			opponent.movePile(opponent.rfg, opponent.grave);
			if(self.playsPerTurn<2) {
			self.playsPerTurn = 2;
			}
			opponent.playsPerTurn = 2;
		}
		opponent.lifeTotal -= 2;
	}
}
