package cards;

import extraData.Card;
import game.Player;

public class EternalFlame extends Card {

	
	public EternalFlame() {
		this.name = "Eternal Flame";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		opponent.lifeTotal--;
		if (self.grave.remove(this)) {
			self.getHand().add(this);
		}
	}
}
