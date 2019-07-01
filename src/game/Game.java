package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import cards.*;
import extraData.*;

public class Game {

	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<String> cardPool = new ArrayList<>();
	public static Boolean debug = false;
	public static Scanner input = new Scanner(System.in);
	public static int deathsByMill = 0;

	public static void main(String[] args) {
		instantiateCardpool();

		while (true) {
			System.out.println();
			System.out.println("===Choose a command===");
			System.out.println("0: Run randomised tournament.");
			System.out.println("2: Analyse the top 8 meta.");
			System.out.println("22: Debug: Top Cut is entire tourney.");
			System.out.println("3: Run a single game.");
			System.out.println("5: Compare two decks.");
			System.out.println("6: Compare one deck against a multitude of other decks.");
			System.out.println("7: Generate a 'solution' to a deck.");
			System.out.println("999: Quit.");
			System.out.println();
//			int choice = input.nextInt();
//			input.nextLine();

			switch (5) {

			case 0:
				runTournament(1);
				break;
			case 2:
				runTournament(8);
				break;
			case 22:
				runTournament(300000);
				break;
			case 3:
				runSingleGame();
				break;
			case 5:
				runBestOf25k();
				break;
			case 6:
				System.out
						.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String bossInfo = input.nextLine();
				String[] parseBossName = bossInfo.split(":");
				Player boss = new Player(parseBossName[0]);
				parseDeckFromLine(boss, parseBossName[1]);

				System.out.println("Enter any number of other decklists in the same format, separated by '/'.");
				String gauntletInfo = input.nextLine();
				System.out.println();
				String[] gauntlet = gauntletInfo.split("/");

				for (String s : gauntlet) {
					String[] parsedNames = s.split(":");
					Player opp = new Player(parsedNames[0]);
					parseDeckFromLine(opp, parsedNames[1]);

					if (boss.getDeck().size() + opp.getDeck().size() != 60) {
						debug("One or more decks isn't correct (@30 cards).");
						debug(boss.name + ": " + boss.getDeck().size());
						debug(opp.name + ": " + opp.getDeck().size());
						break;
					}

					System.out.println(boss.getName() + " wins " + grindGames(boss, opp, 25000) + "% of games against "
							+ opp.getName() + ".");
				}
				break;

			case 7:
				System.out.println(
						"Enter the player+deck intended to beat. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String bossDeckInfo = input.nextLine();
				String[] parsebossname = bossDeckInfo.split(":");
				Player counterThisDeck = new Player(parsebossname[0]);
				parseDeckFromLine(counterThisDeck, parsebossname[1]);

				generateDecklists(1);
				int winrate = 0;
				while (winrate < 75) {
					players.clear();
					generateDecklists(1);
					winrate = grindGames(players.get(0), counterThisDeck, 1500);
					System.gc();
					if (winrate > 55) {
						System.out.println(winrate + ":" + analyseTopCut());
					}
				}
				System.out.println();
				break;
			case 999:
				input.close();
				System.exit(0);
				break;
			}
		}
	}
	//
	// private static void runTournamentRound() {
	// System.out.println("Enter any number of decklists, separated by '/'.");
	// String gauntletInfo = input.nextLine();
	// System.out.println();
	// String[] gauntlet = gauntletInfo.split("/");
	// if (gauntlet.length % 2 != 0) {
	// System.out.println("Incorrect number of decks - not a complete round.");
	// } else {
	// int index = 0;
	// while ((index + 1) < gauntlet.length) {
	// String[] p1Data = gauntlet[index].split(":");
	// String[] p2Data = gauntlet[index + 1].split(":");
	// Player p1 = new Player(p1Data[0]);
	// parseDeckFromLine(p1, p1Data[1]);
	// Player p2 = new Player(p2Data[0]);
	// parseDeckFromLine(p2, p2Data[1]);
	//
	// if (p1.getDeck().size() + p2.getDeck().size() != 60) {
	// debug("One or more decks isn't correct (@30 cards).");
	// debug(p1.name + ": " + p1.getDeck().size());
	// debug(p2.name + ": " + p2.getDeck().size());
	// break;
	// }
	// System.out.println(p1.getName() + " wins " + grindGames(p1, p2, 25000) + "%
	// of games against "
	// + p2.getName() + ".");
	// index += 2;
	// }
	// }
	// }

	private static void runBestOf25k() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1info = input.nextLine();
		String[] parsename = p1info.split(":");
		Player p1 = new Player(parsename[0]);
		parseDeckFromLine(p1, parsename[1]);

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2info = input.nextLine();
		String[] parsename2 = p2info.split(":");
		Player p2 = new Player(parsename2[0]);
		parseDeckFromLine(p2, parsename2[1]);

		if (p2.getDeck().size() + p1.getDeck().size() != 60) {
			debug("One or more decks isn't correct (@30 cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		System.out.println(
				p1.getName() + " wins " + grindGames(p1, p2, 25000) + "% of games against " + p2.getName() + ".");

	}

	private static void runSingleGame() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1inf = input.nextLine();
		String[] parse = p1inf.split(":");
		Player p1 = new Player(parse[0]);
		parseDeckFromLine(p1, parse[1]);

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2info = input.nextLine();
		String[] parsename2 = p2info.split(":");
		Player p2 = new Player(parsename2[0]);
		parseDeckFromLine(p2, parsename2[1]);

		if (p2.getDeck().size() + p1.getDeck().size() != 60) {
			debug("One or more decks isn't correct (@30 cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		debug = true;
		System.out.println(play(p1, p2).getName() + " wins!");
	}

	private static void runTournament(int cullToThisNumber) {
		System.out.println("Generating 300k decklists.");
		generateDecklists(300000);
		Collections.shuffle(players);
		System.out.println("Running tournament.");
		while (players.size() > cullToThisNumber) {
			Player p1 = players.remove(0);
			Player p2 = players.remove(0);
			debug();
			debug(p1.showDecklist());
			debug(p2.showDecklist());
			Player winner = play(p1, p2);
			players.add(winner);
			debug("======" + players.size() + "======");
		}
		System.out.println(analyseTopCut());
	}

	private static int grindGames(Player p1, Player p2, int bestOf) {
		int p1winrate = 0;
		for (int i = 0; i < (bestOf / 2); i++) {
			if (play(p1, p2).equals(p1)) {
				p1winrate++;
			}
			p1.cleanup();
			p2.cleanup();
			if (play(p2, p1).equals(p1)) {
				p1winrate++;
			}
			p1.cleanup();
			p2.cleanup();
		}
		return (100 * p1winrate) / bestOf;
	}

	public static void parseDeckFromLine(Player p1, String p1deck) {
		String[] cards = p1deck.split(",");
		for (String s : cards) {
			String[] cardQty = s.split("-");
			for (int i = Integer.parseInt(cardQty[1]); i > 0; i--) {
				Card c = findCardByName(cardQty[0]);
				p1.getDeck().add(c);
			}
		}
		p1.shuffle(p1.getDeck());
	}

	private static Card findCardByName(String string) {
		for (String c : cardPool) {
			if (c.equals(string)) {
				return newCardByName(string);
			}
		}
		debug("Can't find a card called: " + string);
		System.exit(0);
		return null;
	}

	private static void debug(String string) {
		if (debug && !string.contains("Still able to add") && !string.contains("Finding card")) {
			System.out.println(string);
		} else {
			if (string.contains("====")) {
				System.out.println(string);
			}
		}
	}

	private static void debug() {
		if (debug) {
			debug("");
		}
	}

	private static String analyseTopCut() {
		System.out.println();
		System.out.println();
		HashMap<String, Integer> topCut = new HashMap<>();
		for (Player p : players) {
			for (Card c : p.getDeck()) {
				topCut.put(c.getName(), topCut.getOrDefault(c.getName(), 0) + 1);
			}
		}
		topCut = sortByValues(topCut);
		String decklist = "";
		Iterator it = topCut.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			decklist += pair.getKey() + "-" + pair.getValue() + ",";
		}
		return decklist;
	}

	private static HashMap sortByValues(HashMap map) {
		LinkedList list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
			}
		});
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	private static Player play(Player p1, Player p2) {
		p1.lifeTotal = 30;
		p2.lifeTotal = 30;
		p1.playsPerTurn = 2;
		p2.playsPerTurn = 2;
		String p1start = p1.showDecklist();
		String p2start = p2.showDecklist();
		if (p1.deck.cards.size() != 30 || p2.deck.cards.size() != 30) {
			System.out.println("Definitely a problem.");
			System.out.println("P1 deck: " + p1.deck.cards.size());
			System.out.println("P1 deck: " + p1.showDecklist());
			System.out.println("P2 deck: " + p2.deck.cards.size());
			System.out.println("P2 deck: " + p2.showDecklist());
			System.exit(0);
		}
		p1.drawX(5);
		p2.drawX(5);
		while (p1.isAlive() && p2.isAlive()) {
			// if (p1.lifeTotal > 100000 || p2.lifeTotal > 100000) {
			// printGameState(p1, p2);
			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// }
			int p1playsPerTurn = p1.playsPerTurn;
			int p2playsPerTurn = p2.playsPerTurn;
			p1.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			while (p1playsPerTurn > 0 && p1.getHand().size() > 0) {
				p1.makePlay(p2, debug);
				p1playsPerTurn--;
				if (!p1.isAlive() || !p2.isAlive()) {
					break;
				}
			}

			ArrayList<Card> triggers = new ArrayList<>();
			triggers.addAll(p1.grave);
			Collections.shuffle(triggers);
			for (Card c : triggers) {
				c.graveAbility(p1, p2);
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
			}
			triggers.clear();
			debug(p1.name + "'s grave triggers. (" + p1.getLife() + ")-(" + p2.getLife() + ")");

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}

			p2.draw();
			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			while (p2playsPerTurn > 0 && p2.getHand().size() > 0) {
				p2.makePlay(p1, debug);
				p2playsPerTurn--;
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
			}
			if (!p2.isAlive() || !p1.isAlive()) {
				break;
			}
			triggers.addAll(p2.grave);
			Collections.shuffle(triggers);
			for (Card c : triggers) {
				c.graveAbility(p2, p1);
				if (!p2.isAlive() || !p1.isAlive()) {
					break;
				}
			}
			triggers.clear();
			debug(p2.name + "'s grave triggers. (" + p2.getLife() + ")-(" + p1.getLife() + ")");

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
		}
		if (p1.isAlive()) {
			p1.cleanup();
			p2.cleanup();

			String p1end = p1.showDecklist();
			String p2end = p2.showDecklist();
			if (!(p1start.equals(p1end)) && !(p2start.equals(p2end))) {
				debug("P1 start: " + p1start);
				debug("P1 end: " + p1end);
				debug("P2 start: " + p2start);
				debug("P2 end: " + p2end);
			}
			debug("P1 deck: " + p1.deck.cards.size());
			debug("P1 deck: " + p1.showDecklist());
			debug("P2 deck: " + p2.deck.cards.size());
			debug("P2 deck: " + p2.showDecklist());
			return p1;
		}
		p1.cleanup();
		p2.cleanup();
		debug("P1 deck: " + p1.deck.cards.size());
		debug("P1 deck: " + p1.showDecklist());
		debug("P2 deck: " + p2.deck.cards.size());
		debug("P2 deck: " + p2.showDecklist());
		return p2;
	}

	private static void printGameState(Player p1, Player p2) {
		System.out.println("P1's life: " + p1.lifeTotal);
		System.out.println("P1's hand: " + toString(p1.getHand()));
		System.out.println("P1's deck: " + toString(p1.getDeck()));
		System.out.println("P1's grave: " + toString(p1.getGrave()));
		System.out.println("P1's RFG: " + toString(p1.rfg));
		System.out.println("");
		System.out.println("P2's life: " + p2.lifeTotal);
		System.out.println("P2's hand: " + toString(p2.getHand()));
		System.out.println("P2's deck: " + toString(p2.getDeck()));
		System.out.println("P2's grave: " + toString(p2.getGrave()));
		System.out.println("P2's RFG: " + toString(p2.rfg));
	}

	private static String toString(ArrayList<Card> hand) {
		String output = "[";
		for (Card c : hand) {
			output += c.getName();
			output += ", ";
		}
		if (output.length() > 2) {
			output = output.substring(0, output.length() - 2);
		}
		output += "]";
		return output;
	}

	private static void generateDecklists(int i) {
		for (int ps = 0; ps < i; ps++) {
			Player p = new Player("P" + (ps + 1));

			Collections.shuffle(cardPool);
			String first = cardPool.get(0);
			debug("Finding card: " + first);
			while (cardCount(p.getDeck(), first) < 4) {
				Card c = findCardByName(first);
				p.getDeck().add(c);
			}

			Collections.shuffle(cardPool);
			String second = cardPool.get(0);
			debug("Finding card: " + second);
			while (cardCount(p.getDeck(), second) < 4) {
				Card c = findCardByName(second);
				p.getDeck().add(c);
			}

			Collections.shuffle(cardPool);
			String third = cardPool.get(0);
			debug("Finding card: " + third);
			while (cardCount(p.getDeck(), third) < 4) {
				Card c = findCardByName(third);
				p.getDeck().add(c);
			}

			Collections.shuffle(cardPool);
			String fourth = cardPool.get(0);
			debug("Finding card: " + fourth);
			while (cardCount(p.getDeck(), fourth) < 3) {
				Card c = findCardByName(fourth);
				p.getDeck().add(c);
			}

			Collections.shuffle(cardPool);
			String fifth = cardPool.get(0);
			debug("Finding card: " + fifth);
			while (cardCount(p.getDeck(), fifth) < 3) {
				Card c = findCardByName(fifth);
				p.getDeck().add(c);
			}

			while (p.getDeck().size() < 30) {
				Collections.shuffle(cardPool);
				String s = cardPool.get(0);
				debug("Finding card: " + s);
				Card c = findCardByName(s);
				if (cardCount(p.getDeck(), c.getName()) < 4) {
					debug("Still able to add: " + first);
					p.getDeck().add(c);
				} else {
					debug("Got enough: " + first);
				}
			}
			players.add(p);
		}
	}

	private static int cardCount(ArrayList<Card> deck, String name) {
		int i = 0;
		for (Card cs : deck) {
			if (cs.getName().equals(name)) {
				i++;
			}
		}
		return i;
	}

	private static void instantiateCardpool() {
		cardPool.add("Accumulated Knowledge");
		cardPool.add("Amnesia");
		cardPool.add("Ancestral Recall");
		cardPool.add("Apparition");
		cardPool.add("Body Swap");
		cardPool.add("Burial");
		cardPool.add("Burst Heal");
		cardPool.add("Channel the Depths");
		cardPool.add("Charged Laser");
		cardPool.add("Checkmate");
		cardPool.add("Colossal Junk Chucker");
		cardPool.add("Comeback Zap");
		cardPool.add("Corporate Shredder");
		cardPool.add("Cowardly Robot");
		cardPool.add("Damnation");
		cardPool.add("Dark Contract");
		cardPool.add("Dark Pact");
		cardPool.add("Dark Transfusion");
		cardPool.add("Dark Zap");
		cardPool.add("Divine Zap");
		cardPool.add("Donate");
		cardPool.add("Doomsday Device");
		cardPool.add("Eternal Flame");
		cardPool.add("Eternal Herb");
		cardPool.add("Eventual Zap");
		cardPool.add("Export");
		cardPool.add("Genome");
		cardPool.add("Gesper");
		cardPool.add("Giga Zap");
		cardPool.add("Greater Demon");
		cardPool.add("Grindstone");
		cardPool.add("Griselbrand");
		cardPool.add("Handy Robot");
		cardPool.add("Heal");
		cardPool.add("Ignite");
		cardPool.add("Increasing Heal");
		cardPool.add("Insurance Plan");
		cardPool.add("Junk Chucker");
		cardPool.add("Junk Hunter");
		cardPool.add("Lesser Demon");
		cardPool.add("Life Zap");
		cardPool.add("Mass Grave");
		cardPool.add("Mend");
		cardPool.add("Mighty Wrench");
		cardPool.add("Mill");
		cardPool.add("Miller");
		cardPool.add("Monastery");
		cardPool.add("Mulch Munch");
		cardPool.add("Parry");
		cardPool.add("Peace Treaty");
		cardPool.add("Poison Frog");
		cardPool.add("Pylon");
		cardPool.add("Recycle");
		cardPool.add("Regrow");
		cardPool.add("Remembrance");
		cardPool.add("Repair");
		cardPool.add("Robot Assassin");
		cardPool.add("Rotato Potato");
		cardPool.add("Royal Robot");
		cardPool.add("Sacrifice");
		cardPool.add("Search the Darkness");
		cardPool.add("Sinkhole");
		cardPool.add("Slow Flare");
		cardPool.add("Sparkwave");
		cardPool.add("Sycamore");
		cardPool.add("Tasty Bread");
		cardPool.add("Tempo Drain");
		cardPool.add("Tent");
		cardPool.add("The Rack");
		cardPool.add("Thought Scour");
		cardPool.add("Time Stop");
		cardPool.add("Timetwister");
		cardPool.add("Upper Hand");
		cardPool.add("Vitality Artifact");
		cardPool.add("Waifu");
		cardPool.add("Wheel of Fate");
		cardPool.add("Wicked Robot");
		cardPool.add("Zap Cannon");
		cardPool.add("Zap Machine");
		cardPool.add("Zap Magnifier");
		cardPool.add("Zap and Tap");
		cardPool.add("Zap");
		cardPool.add("Zapstarter");
		cardPool.add("Doubling Zap");
		cardPool.add("Trial");
		cardPool.add("Cloning Gallery");
		cardPool.add("Bargaining");
		cardPool.add("Arcane Zap");
		cardPool.add("Exorcise");
		cardPool.add("Titan");
		cardPool.add("Thief");
	}

	public static Card newCardByName(String string) {
		switch (string) {
		case "Exorcise":
			return new Exorcise();
		case "Titan":
			return new Titan();
		case "Arcane Zap":
			return new ArcaneZap();
		case "Bargaining":
			return new Bargaining();
		case "Upper Hand":
			return new UpperHand();
		case "Cloning Gallery":
			return new CloningGallery();
		case "Trial":
			return new Trial();
		case "Doubling Zap":
			return new DoublingZap();
		case "Griselbrand":
			return new Griselbrand();
		case "Divine Zap":
			return new DivineZap();
		case "Monastery":
			return new Monastery();
		case "Sacrifice":
			return new Sacrifice();
		case "Miller":
			return new Miller();
		case "Wheel of Fate":
			return new WheelOfFate();
		case "Genome":
			return new Genome();
		case "Insurance Plan":
			return new InsurancePlan();
		case "Rotato Potato":
			return new RotatoPotato();
		case "Dark Contract":
			return new DarkContract();
		case "Lesser Demon":
			return new LesserDemon();
		case "Increasing Heal":
			return new IncreasingHeal();
		case "Tent":
			return new Tent();
		case "Zap Machine":
			return new ZapMachine();
		case "Eternal Flame":
			return new EternalFlame();
		case "Repair":
			return new Repair();
		case "Thief":
			return new Thief();
		case "Monk":
			return new Monk();
		case "Checkmate":
			return new Checkmate();
		case "Mighty Wrench":
			return new MightyWrench();
		case "Recycle":
			return new Recycle();
		case "Export":
			return new Export();
		case "Tasty Bread":
			return new TastyBread();
		case "Greater Demon":
			return new GreaterDemon();
		case "Remembrance":
			return new Remembrance();
		case "Vitality Artifact":
			return new VitalityArtifact();
		case "Time Stop":
			return new TimeStop();
		case "Slow Flare":
			return new SlowFlare();
		case "Royal Robot":
			return new RoyalRobot();
		case "Burst Heal":
			return new BurstHeal();
		case "Eventual Zap":
			return new EventualZap();
		case "Mass Grave":
			return new MassGrave();
		case "Zap Cannon":
			return new ZapCannon();
		case "Accumulated Knowledge":
			return new AccumulatedKnowledge();
		case "Doomsday Device":
			return new DoomsdayDevice();
		case "Pylon":
			return new Pylon();
		case "Amnesia":
			return new Amnesia();
		case "Ancestral Recall":
			return new AncestralRecall();
		case "Apparition":
			return new Apparition();
		case "Body Swap":
			return new BodySwap();
		case "Burial":
			return new Burial();
		case "Charged Laser":
			return new ChargedLaser();
		case "Colossal Junk Chucker":
			return new ColossalJunkChucker();
		case "Comeback Zap":
			return new ComebackZap();
		case "Corporate Shredder":
			return new CorporateShredder();
		case "Cowardly Robot":
			return new CowardlyRobot();
		case "Damnation":
			return new Damnation();
		case "Dark Pact":
			return new DarkPact();
		case "Dark Transfusion":
			return new DarkTransfusion();
		case "Dark Zap":
			return new DarkZap();
		case "Donate":
			return new Donate();
		case "Eternal Herb":
			return new EternalHerb();
		case "Gesper":
			return new Gesper();
		case "Giga Zap":
			return new GigaZap();
		case "Grindstone":
			return new Grindstone();
		case "Handy Robot":
			return new HandyRobot();
		case "Heal":
			return new Heal();
		case "Ignite":
			return new Ignite();
		case "Junk Chucker":
			return new JunkChucker();
		case "Junk Hunter":
			return new JunkHunter();
		case "Life Zap":
			return new Lifezap();
		case "Mend":
			return new Mend();
		case "Mill":
			return new Mill();
		case "Mulch Munch":
			return new MulchMunch();
		case "Parry":
			return new Parry();
		case "Peace Treaty":
			return new PeaceTreaty();
		case "Poison Frog":
			return new PoisonFrog();
		case "Regrow":
			return new Regrow();
		case "Robot Assassin":
			return new RobotAssassin();
		case "Search the Darkness":
			return new SearchTheDarkness();
		case "Sinkhole":
			return new Sinkhole();
		case "Channel the Depths":
			return new ChannelTheDepths();
		case "Sparkwave":
			return new Sparkwave();
		case "Sycamore":
			return new Sycamore();
		case "Tempo Drain":
			return new TempoDrain();
		case "The Rack":
			return new TheRack();
		case "Thought Scour":
			return new ThoughtScour();
		case "Timetwister":
			return new Timetwister();
		case "Waifu":
			return new Waifu();
		case "Wicked Robot":
			return new WickedRobot();
		case "Zap":
			return new Zap();
		case "Zap and Tap":
			return new ZapAndTap();
		case "Zapstarter":
			return new Zapstarter();
		case "Zap Magnifier":
			return new ZapMagnifier();
		case "Corrupted Blood":
			return new CorruptedBlood();
		case "Pigeon":
			return new Pigeon();
		case "Holy Grail":
			return new HolyGrail();
		case "Cable":
			return new Cable();

		default:
			return new ErrorMessage(string);
		}
	}
}
