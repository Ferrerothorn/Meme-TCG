package cards;

import game.Player;

public class Damnation extends Card {

	public Damnation() {
		this.name = "Damnation";
	}

	@Override
	public void onentry(Player self, Player opponent) {
		opponent.movePile(opponent.grave, opponent.rfg);
		self.movePile(self.grave, self.rfg);
		self.draw();
	}
}
