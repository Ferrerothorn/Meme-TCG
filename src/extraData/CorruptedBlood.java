package extraData;

import java.util.Collections;

import game.Player;

public class CorruptedBlood extends Card {

	public CorruptedBlood() {
		this.name = "Corrupted Blood";
		this.setType("Junk");
	}

	@Override
	public void onentry(Player self, Player opponent) {
		self.getDeck().add(new CorruptedBlood());
		self.getDeck().add(new CorruptedBlood());
		int bloodCount = self.cardCount(self.getDeck(), "Corrupted Blood");
		bloodCount += self.cardCount(self.getHand(), "Corrupted Blood");
		self.lifeTotal -= (bloodCount - 1) * (bloodCount - 1);
		Collections.shuffle(self.getDeck());
		self.draw();
	}
}
