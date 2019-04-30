package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class DarkContract extends Card {

	public DarkContract() {
		this.name = "Dark Contract";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= self.grave.size();
		self.movePile(self.getHand(), self.grave);
		Collections.shuffle(self.getHand());
	}
}
