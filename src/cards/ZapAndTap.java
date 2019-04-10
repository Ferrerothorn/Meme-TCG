package cards;

import game.Player;

public class ZapAndTap extends Card {

	
	public ZapAndTap() {
		this.name = "Zap and Tap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal = opponent.lifeTotal-1;
		self.draw();
	}
	
	
}
