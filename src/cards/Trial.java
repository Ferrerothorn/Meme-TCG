package cards;

import java.util.Collections;

import extraData.Card;
import extraData.HolyGrail;
import game.Player;

public class Trial extends Card {

	public Trial() {
		this.name = "Trial";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -=3;
		opponent.draw();
		self.getDeck().add(new HolyGrail());
		Collections.shuffle(self.getDeck());
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
