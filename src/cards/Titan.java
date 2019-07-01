package cards;

import extraData.Card;
import game.Player;

public class Titan extends Card {

	public Titan() {
		this.name = "Titan";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if(self.rfg.size()>0) {
			opponent.lifeTotal--;
		}
		if(self.getDeck().size()>0) {
			opponent.lifeTotal--;			
		}
		if(self.getHand().size()>0) {
			opponent.lifeTotal--;
		}
		if(opponent.rfg.size()>0) {
			opponent.lifeTotal--;
		}
		if(opponent.getDeck().size()>0) {
			opponent.lifeTotal--;
		}
		if(opponent.getHand().size()>0) {
			opponent.lifeTotal--;
		}
	}
}
