package cards;

import java.util.Collections;

import extraData.Card;
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
		self.getDeck().remove(this);
		self.rfg.add(this);
		opponent.movePile(opponent.getDeck(), opponent.grave);
		opponent.movePile(opponent.getDeck(), opponent.getHand());
		Collections.shuffle(opponent.getDeck());
		self.draw(3);
		opponent.draw(3);
	}	
	
	@Override
	public void afterResolving(Player self, Player opponent) {
//		System.out.println("====");
//		System.out.println(self.rfg.add(this));
//		System.out.println(self.getDeck().remove(this));
}
}
