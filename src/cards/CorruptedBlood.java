package cards;

import java.util.Collections;

import game.Player;

public class CorruptedBlood extends Card {

	
	public CorruptedBlood() {
		this.name = "Corrupted Blood";
	}
	
	@Override
	public void onentry(Player self, Player opponent) {
		self.lifeTotal -= 2;
		self.draw();
		self.getDeck().add(new CorruptedBlood());
		self.getDeck().add(new CorruptedBlood());
		Collections.shuffle(self.getDeck());
	}	
}
