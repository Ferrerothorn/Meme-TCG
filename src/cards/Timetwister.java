package cards;

import java.util.Collections;

import game.Player;

public class Timetwister extends Card {

	
	public Timetwister() {
		this.name = "Timetwister";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.movePile(self.getDeck(), self.grave);
		self.movePile(self.getDeck(), self.getHand());
		Collections.shuffle(self.getDeck());
		opponent.movePile(opponent.getDeck(), opponent.grave);
		opponent.movePile(opponent.getDeck(), opponent.getHand());
		Collections.shuffle(opponent.getDeck());
		self.drawX(3);
		opponent.drawX(3);
	}	
}
