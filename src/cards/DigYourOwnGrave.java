package cards;

import extraData.Card;
import game.Player;

public class DigYourOwnGrave extends Card {

	
	public DigYourOwnGrave() {
		this.name = "Dig Your Own Grave";
		this.setType("Spell");
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.millX(1);
		self.lifeTotal--;
	}	
}
