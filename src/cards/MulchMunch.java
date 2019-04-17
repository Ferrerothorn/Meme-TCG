package cards;

import extraData.Card;
import game.Player;

public class MulchMunch extends Card {

	
	public MulchMunch() {
		this.name = "Mulch Munch";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal+=self.grave.size();
	}
}
