package LegacyCards;

import extraData.Card;
import game.Player;

public class TradeDeal extends Card {

	public TradeDeal() {
		this.name = "Trade Deal";
		this.setColor("White");
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		if (self.getHand().size() >= 1) {
			self.randomRFG();
			self.playsPerTurn++;
		}
		if (self.playsPerTurn > 2) {
			self.playsPerTurn++;
		}
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
