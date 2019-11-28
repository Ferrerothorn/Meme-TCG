package extraData;

import java.util.Collections;

import game.Player;

public class HolyGrail extends Card {

	public HolyGrail() {
		this.name = "Holy Grail";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 999;
		self.movePile(self.getDeck(), self.grave);
		Collections.shuffle(self.getDeck());
		self.draw(5);
	}

	@Override
	public void graveAbility(Player self, Player opponent) {
	}
}
