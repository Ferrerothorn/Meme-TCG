package cards;

import java.util.Collections;

import extraData.Card;
import extraData.Pigeon;
import game.Player;

public class TastyBread extends Card {

	
	public TastyBread() {
		this.name = "Tasty Bread";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal+=3;
	}	
	
	@Override
	public void graveAbility(Player self, Player opponent) {
		self.getDeck().add(new Pigeon());
		Collections.shuffle(self.getDeck());
	}
}
