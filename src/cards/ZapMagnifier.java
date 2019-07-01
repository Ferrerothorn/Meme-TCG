package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class ZapMagnifier extends Card {

	public ZapMagnifier() {
		this.name = "Zap Magnifier";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.draw();
		if (self.grave.size()>0) {
			Collections.shuffle(self.grave);
			if(self.grave.get(0).getName().contains("Zap")) {
				self.draw();
			}
		}
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		addCounter();
	}
}
