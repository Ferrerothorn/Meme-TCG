package cards;

import extraData.Card;
import game.Player;

public class Hero extends Card {

	public Hero() {
		this.name = "Hero";
		this.setType("Hero");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 1;
		if(self.containsClass(self.grave, "Hero")) {
			opponent.lifeTotal -= 3;
		}
		self.movePile(self.grave, self.getDeck());
		self.shuffle();
	}
}
