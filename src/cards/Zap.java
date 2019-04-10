package cards;

import game.Player;

public class Zap extends Card {

	
	public Zap() {
		this.name = "Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-3;
	//	System.out.println(self.getName() + " casts Zap on " + opponent.getName() + " for 3 damage! (" + self.getLife() + ")-(" + opponent.getLife() + ")");
	}
	
	
}
