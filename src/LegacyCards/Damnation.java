package LegacyCards;

import extraData.Card;
import game.Player;

public class Damnation extends Card {

	public Damnation() {
		this.name = "Damnation";
		this.setType("Spell");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.movePile(self.rfg, self.grave);
		opponent.movePile(opponent.rfg, opponent.grave);
		self.playsPerTurn = 2;
		opponent.playsPerTurn = 2;
		self.draw();
	}
}
