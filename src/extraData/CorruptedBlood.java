package extraData;

import java.util.Collections;

import game.Player;

public class CorruptedBlood extends Card {

	
	public CorruptedBlood() {
		this.name = "Corrupted Blood";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {

		self.getDeck().add(new CorruptedBlood());
		self.getDeck().add(new CorruptedBlood());
		self.lifeTotal -= (self.cardCount(self.getDeck(), "Corrupted Blood")+1);
		
		self.draw();
		Collections.shuffle(self.getDeck());
	}	
}
