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
		self.lifeTotal -= bloodCount * (bloodCount - 1);
		Collections.shuffle(self.getDeck());
		self.draw();
	}

	public static int fibonacci(int n) {
		double phi = (1 + Math.sqrt(5)) / 2;
		return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
	}
}
