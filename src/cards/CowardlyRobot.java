package cards;

import game.Player;

public class CowardlyRobot extends Card {

	public CowardlyRobot() {
		this.name = "Cowardly Robot";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if(self.cardCount(self.grave, "Accumulated Knowledge") >=2) {
			opponent.lifeTotal-=2;
		}
	}
}
