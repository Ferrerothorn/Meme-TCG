package cards;

import extraData.Card;
import game.Player;

public class EternalHerb extends Card {

	
	public EternalHerb() {
		this.name = "Eternal Herb";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal++;
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.lifeTotal++;
	}
}
