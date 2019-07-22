package extraData;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.Player;

public class JUnit {

	Game game;
	Player p1;

	@Before
	public void setup() {
		game = new Game();
		Game.instantiateCardpool();
	}

	@Test
	public void testParseLineIntoDeck() {
		String bossInput = "Burial Mill:Corporate Shredder-4,Tasty Bread-4,Burial-4,Tent-4,Pylon-4,Wicked Robot-3,Grindstone-1,Sparkwave-1,Zapstarter-1,Arcane Zap-1,Miller-1,Bargaining-1,Export-1"; // input.nextLine();
		String[] bossInfo = bossInput.split(":");
		Player boss = new Player(bossInfo[0]);
		boss.setDeck(Game.parseDeckFromLine(bossInfo[1]));
		assertEquals(30, boss.getDeck().size());
		assertEquals(4, boss.cardCount(boss.getDeck(), "Corporate Shredder"));
	}

	@Test
	public void testMillerBeatsZapper() {
		String miller = "Miller:Mill-30";
		String[] millerInfo = miller.split(":");
		Player millDeck = new Player(millerInfo[0]);
		millDeck.setDeck(Game.parseDeckFromLine(millerInfo[1]));

		String zapper = "Zapper:Zap-30";
		String[] zapperInfo = zapper.split(":");
		Player zapDeck = new Player(zapperInfo[0]);
		zapDeck.setDeck(Game.parseDeckFromLine(zapperInfo[1]));

		int winrate = Game.grindGames(millDeck, zapDeck, 25000);
		assertEquals(100, winrate);
		winrate = Game.grindGames(zapDeck, millDeck, 25000);
		assertEquals(0, winrate);
	}

	@Test
	public void testBossDeckGetsOpponent() {
		String bossInput = "Burial Mill:Corporate Shredder-4,Tasty Bread-4,Burial-4,Tent-4,Pylon-4,Wicked Robot-3,Grindstone-1,Sparkwave-1,Zapstarter-1,Arcane Zap-1,Miller-1,Bargaining-1,Export-1"; // input.nextLine();
		String[] bossInfo = bossInput.split(":");
		Player boss = new Player(bossInfo[0]);
		boss.setDeck(Game.parseDeckFromLine(bossInfo[1]));
		Game.generateDecklists(1, "Pylon-4", "");
		assertEquals(true, Game.players.get(0).showDecklist().contains("Pylon-4"));
		assertEquals(30, Game.players.get(0).getDeck().size());
	}

	@Test
	public void testGeneratedDeckBeatsBurialMill() {
		String generated = "This:Slow Flare-4,Checkmate-4,Lesser Demon-1,Waifu-4,Export-4,Sinkhole-1,Body Swap-1,Ignite-1,Colossal Junk Chucker-4,Doubling Zap-1,Pylon-4,Time Stop-1";
		String[] generatedInfo = generated.split(":");
		Player generatedDeck = new Player(generatedInfo[0]);
		generatedDeck.setDeck(Game.parseDeckFromLine(generatedInfo[1]));

		String burialMill = "Burial Mill:Corporate Shredder-4,Tasty Bread-4,Burial-4,Tent-4,Pylon-4,Wicked Robot-3,Grindstone-1,Sparkwave-1,Zapstarter-1,Arcane Zap-1,Miller-1,Bargaining-1,Export-1";
		String[] burialMillInfo = burialMill.split(":");
		Player burialMillDeck = new Player(burialMillInfo[0]);
		burialMillDeck.setDeck(Game.parseDeckFromLine(burialMillInfo[1]));

		int winrate = Game.grindGames(generatedDeck, burialMillDeck, 25000);
		assertEquals(true, winrate > 50);
	}

	@Test
	public void checkCleanupFunctionsCorrectly() {

		String generated = "This:Huge Plant-4,Pylon-4,Trial-2,Waifu-4,Export-4,Sinkhole-1,Body Swap-1,Cloning Gallery-4,Doubling Zap-1,Pylon-4,Time Stop-1";
		String[] generatedInfo = generated.split(":");
		Player generatedDeck = new Player(generatedInfo[0]);
		generatedDeck.setDeck(Game.parseDeckFromLine(generatedInfo[1]));

		String burialMill = "Burial Mill:Dark Transfusion-4,Tasty Bread-4,Burial-4,Tent-4,Pylon-4,Wicked Robot-3,Grindstone-1,Sparkwave-1,Zapstarter-1,Arcane Zap-1,Miller-1,Bargaining-1,Export-1";
		String[] burialMillInfo = burialMill.split(":");
		Player burialMillDeck = new Player(burialMillInfo[0]);
		burialMillDeck.setDeck(Game.parseDeckFromLine(burialMillInfo[1]));

		Game.play(generatedDeck, burialMillDeck);

		assertEquals(30, generatedDeck.getDeck().size());
		assertEquals(0, generatedDeck.getHand().size());
		assertEquals(0, generatedDeck.rfg.size());
		assertEquals(0, generatedDeck.grave.size());
		assertEquals(30, burialMillDeck.getDeck().size());
		assertEquals(0, burialMillDeck.getHand().size());
		assertEquals(0, burialMillDeck.rfg.size());
		assertEquals(0, burialMillDeck.grave.size());
		Game.play(burialMillDeck, generatedDeck);
		assertEquals(30, generatedDeck.getDeck().size());
		assertEquals(0, generatedDeck.getHand().size());
		assertEquals(0, generatedDeck.rfg.size());
		assertEquals(0, generatedDeck.grave.size());
		assertEquals(30, burialMillDeck.getDeck().size());
		assertEquals(0, burialMillDeck.getHand().size());
		assertEquals(0, burialMillDeck.rfg.size());
		assertEquals(0, burialMillDeck.grave.size());

	}

	@Test
	public void testMultipleTest() {
		testEnsureBossDeckGetsBetterOpponent();
		System.out.println();
		testEnsureBossDeckGetsBetterOpponent();
		System.out.println();
		testEnsureBossDeckGetsBetterOpponent();
		System.out.println();
		testEnsureBossDeckGetsBetterOpponent();
		System.out.println();
		testEnsureBossDeckGetsBetterOpponent();
		System.out.println();
	}

	@Test
	public void testEnsureBossDeckGetsBetterOpponent() {
		// Game.debug = true;
		String bossInput = "Burial Mill:Corporate Shredder-4,Tasty Bread-4,Burial-4,Tent-4,Pylon-4,Wicked Robot-3,Grindstone-1,Sparkwave-1,Zapstarter-1,Arcane Zap-1,Miller-1,Bargaining-1,Export-1"; // input.nextLine();
		String[] bossInfo = bossInput.split(":");
		Player boss = new Player(bossInfo[0]);
		boss.setDeck(Game.parseDeckFromLine(bossInfo[1]));

		int winrate = 0;
		while (winrate < 55) {
			winrate = 0;
			Game.players.clear();
			Game.generateDecklists(1, "", "");
			winrate = Game.grindGames(Game.players.get(0), boss, 5000);
		}

		System.out.println(winrate + ":" + Game.players.get(0).showDecklist());
		int recheckWinrate = Game.grindGames(Game.players.get(0), boss, 10000);
		assertEquals(true, recheckWinrate > 50);
	}

}
