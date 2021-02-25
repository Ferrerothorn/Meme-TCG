package LegacyCards;

import extraData.Card;
import game.Player;

public class CowardlyRobot extends Card {

	public CowardlyRobot() {
		this.name = "Cowardly Robot";
		this.setType("Mech");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if(self.cardCount(self.grave, "Cowardly Robot") >=2) {
			opponent.lifeTotal-=2;
		}
	}
}
