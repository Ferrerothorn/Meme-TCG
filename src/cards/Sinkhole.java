package cards;

import game.Player;

public class Sinkhole extends Card {

	
	public Sinkhole() {
		this.name = "Sinkhole";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		if(self.getDeck().size() == 0) {
			opponent.lifeTotal = 0;
		}
		else {
			self.draw();
		}
	}

}
