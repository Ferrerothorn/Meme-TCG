package cards;

import game.Player;

public class Lifezap extends Card {

	
	public Lifezap() {
		this.name = "Life Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-2;
		self.lifeTotal++;
	}
}
