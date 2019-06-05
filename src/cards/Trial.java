package cards;

import java.util.Random;

import extraData.Card;
import game.Player;

public class Trial extends Card {

	public Trial() {
		this.name = "Trial";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -=3;
		opponent.draw();
		self.getDeck().add(new HolyGrail());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
