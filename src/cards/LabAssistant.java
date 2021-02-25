package cards;

import extraData.Card;
import game.Player;

public class LabAssistant extends Card {

	public LabAssistant() {
		this.name = "Lab Assistant";
		this.setColor("Blue");
		this.setType("Creature");
		this.setPriority(2);
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {

	}
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		opponent.lifeTotal -= self.getHand().size();
	}
}
