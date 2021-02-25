package cards;

import extraData.Card;
import game.Player;

public class AccumulatedKnowledge extends Card {

	public AccumulatedKnowledge() {
		this.name = "Accumulated Knowledge";
		this.setColor("Blue");
		this.setType("Spell");
		this.setPriority(7);
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int i = self.cardCount(self.grave, "Accumulated Knowledge");
		switch (i) {
		case 1:
			self.draw();
			break;
		case 2:
			opponent.randomDiscard();
			break;
		case 3:
			self.draw();
			opponent.randomDiscard();
			opponent.millX(1);
			break;
		default:
			break;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {

	}
}
