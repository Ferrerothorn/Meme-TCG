package cards;

import extraData.Card;
import game.Player;

public class VitalityArtifact extends Card {

	public VitalityArtifact() {
		this.name = "Vitality Artifact";
	}

	@Override
	public void onentry(Player self, Player opponent) {
	}
	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.lifeTotal += self.getHand().size();
	}
}
