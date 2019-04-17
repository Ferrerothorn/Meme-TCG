package cards;

import game.Player;

public class ZapMagnifier extends Card {

	public ZapMagnifier() {
		this.name = "Zap Magnifier";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		addCounter();
	}
}
