package cards;

import game.Player;

public class Parry extends Card {

	public Parry() {
		this.name = "Parry";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal += 2;
		self.draw();
	}
}
