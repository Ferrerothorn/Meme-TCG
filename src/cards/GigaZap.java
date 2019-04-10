package cards;

import game.Player;

public class GigaZap extends Card {

	
	public GigaZap() {
		this.name = "Giga Zap";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal -= 5;
		self.lifeTotal -=2;
	}
}
