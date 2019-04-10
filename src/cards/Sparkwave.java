package cards;

import game.Player;

public class Sparkwave extends Card {

	public Sparkwave() {
		this.name = "Sparkwave";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getDeck().cards.size() > 0) {
			if (self.getDeck().cards.get(0).getName().contains("Zap")) {
				opponent.lifeTotal -= 7;
			} else {
				opponent.lifeTotal -= 1;
			}
		}
	}

}
