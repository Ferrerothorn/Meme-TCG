package cards;

import extraData.Card;
import game.Player;

public class InsurancePlan extends Card {

	
	public InsurancePlan() {
		this.name = "Insurance Plan";
		this.setType("Spell");
	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		if(self.getHand().size() == 0) {
			self.draw(3);
			rfgThis(self);
		}
	}
}
