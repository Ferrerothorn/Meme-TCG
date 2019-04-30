package cards;

import java.util.Collections;

import extraData.Card;
import game.Player;

public class RotatoPotato extends Card {

	public RotatoPotato() {
		this.name = "Rotato Potato";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		int x = self.grave.size();
		self.movePile(self.getDeck(), self.grave);
		Collections.shuffle(self.getDeck());
		self.millX(x);
		self.draw();

	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
