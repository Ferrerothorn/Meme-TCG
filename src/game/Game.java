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
	public static Boolean debug = true;
	public static Scanner input = new Scanner(System.in);
	public static int deathsByMill = 0;
	public static int games = 0;
	public static int deckSize = 30;

	public static void main(String[] args) {
		instantiateCardpool();
		while (true) {
			System.out.println();
			System.out.println("===Choose a command===");
			System.out.println("0: Generate a blind meta deck.");
			System.out.println("8: Generate endless meta decks.");
			System.out.println("1: Generate a deck with a list of must-include cards.");
			System.out.println("2: Analyse the Top X meta.");
			System.out.println("22: Play until X decks remain.");
			System.out.println("3: Run a single game.");
			System.out.println("444: Debug generation: Top Cut is entire tourney.");
			System.out.println("5: Compare two decks.");
			System.out.println("6: Compare one deck against a multitude of other decks.");
			System.out.println("7: Generate a 'solution' to a deck.");
			System.out.println("77: Generate a 'solution' to a multitude of decks.");
			System.out.println("999: Quit.");
			System.out.println();
			// int choice = 5;
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {

			case 0:
				runTournament(1, "", "", "");
				break;
			case 8:
				while(true) {
					generateDecklists(500000, "", "");
					Collections.shuffle(players);
					while (players.size() > 1) {
						Player p1 = players.remove(0);
						Player p2 = players.remove(0);
						debug();
						debug(p1.showDecklist());
						debug(p2.showDecklist());
						int p1winrate = grindGames(p1, p2, 8);
						games += 8;
						if (p1winrate > 50) {
							players.add(p1);
							p2 = null;
						} else if (p1winrate < 50) {
							players.add(p2);
							p1 = null;
						} else {
							players.add(p1);
							players.add(p2);
						}
					}
					System.out.println("Winner:" + analyseTopCut());
					System.out.println(analyseColors());
					System.out.println(((100 * deathsByMill) / games) + "% of games are won by mill.");
				}
			case 1:
				players.clear();
				System.out.println("Enter archetype name.");
				String deckArchetypeName = input.nextLine();
				System.out.println("Please enter your list of required cards.");
				String mandatoryCards = input.nextLine();
				System.out.println("Please enter your list of banned cards.");
				String bannedCards = input.nextLine();
				runTournament(1, mandatoryCards, bannedCards, deckArchetypeName);
				break;
			case 2:
				System.out.println("How many players should the sample size be?");
				int topCutSize = input.nextInt();
				runTournament(topCutSize, "", "", "");
				break;
			case 22:
				deathsByMill = 0;
				games = 0;
				System.out.println("How many players should the sample size be?");
				topCutSize = input.nextInt();
				if (players.size() < topCutSize) {
					runTournament(topCutSize, "", "", "");
				} else {
					while (players.size() > topCutSize) {
						Player p1 = players.remove(0);
						Player p2 = players.remove(0);
						debug();
						debug(p1.showDecklist());
						debug(p2.showDecklist());
						int p1winrate = grindGames(p1, p2, 8);
						games += 8;
						if (p1winrate > 50) {
							players.add(p1);
							p2 = null;
						} else if (p1winrate < 50) {
							players.add(p2);
							p1 = null;
						} else {
							players.add(p1);
							players.add(p2);
						}
						debug("======" + players.size() + "======");
					}
					System.out.println("Top Cut: " + analyseTopCut());
					System.out.println(analyseColors());
					System.out.println(((100 * deathsByMill) / games) + "% of games are won by mill.");
				}
				break;

			case 444:
				runTournament(300000, "", "", "");
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
				boss.setDeck(parseDeckFromLine(parseBossName[1]));

				System.out.println("Enter any number of other decklists in the same format, separated by '/'.");
				String gauntletInfo = input.nextLine();
				System.out.println();
				String[] gauntlet = gauntletInfo.split("/");

				for (String s : gauntlet) {
					String[] parsedNames = s.split(":");
					Player opp = new Player(parsedNames[0]);
					opp.setDeck(parseDeckFromLine(parsedNames[1]));

					if (boss.getDeck().size() + opp.getDeck().size() != 60) {
						debug("One or more decks isn't correct (@" + deckSize + " cards).");
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
						"Enter the desired enemy deck's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
				String p1input = input.nextLine();
				String[] p1info = p1input.split(":");
				Player p1 = new Player(p1info[0]);
				p1.setDeck(parseDeckFromLine(p1info[1]));

				System.out.println("Please enter your list of required cards.");
				mandatoryCards = input.nextLine();

				System.out.println("What percent winrate is intriguing enough to want to see it?");
				int curiosityThreshold = Integer.parseInt(input.nextLine());

				System.out.println("What percent winrate is intriguing enough to call it a 'counter' and stop?");
				int counterThreshold = Integer.parseInt(input.nextLine());

				counterThisDeck(p1, mandatoryCards, curiosityThreshold, counterThreshold);
				break;

			case 77:
				System.out.println(
						"Enter the desired enemy decks names and decklists; format should be 'Name:Cards-Quantity/Name:Cards-Quantity'");
				String mobInput = input.nextLine();
				String[] opponents = mobInput.split("/");

				System.out.println("Please enter your list of required cards.");
				mandatoryCards = input.nextLine();

				System.out.println(
						"What average percent winrate against this mob is intriguing enough to want to see it?");
				curiosityThreshold = Integer.parseInt(input.nextLine());

				System.out.println(
						"What average percent winrate against this mob is intriguing enough to call it a 'counter' and stop?");
				counterThreshold = Integer.parseInt(input.nextLine());

				counterTheseDecks(opponents, mandatoryCards, curiosityThreshold, counterThreshold);
				break;

			case 999:
				input.close();
				System.exit(0);
				break;
			default:
			//	runBestOf25k();
				break;
			}
		}
	}

	private static void counterTheseDecks(String[] opponents, String mandatoryCards, int curiosityThreshold,
			int counterThreshold) {
		// TODO Auto-generated method stub

	}

	private static void counterThisDeck(Player p1, String mandatoryCards, int curiosityThreshold,
			int completeThreshold) {
		int wins = 0;

		while (((wins * 100) / 5000) < completeThreshold) {
			wins = 0;
			players.clear();
			generateDecklists(1, mandatoryCards, "");
			Player p = players.remove(0);
			for (int i = 0; i < 2500; i++) {
				if (play(p, p1).equals(p)) {
					wins++;
				}
				if (play(p1, p).equals(p)) {
					wins++;
				}
			}
			if (((wins * 100) / 5000) > curiosityThreshold) {
				System.out.println("" + ((wins * 100) / 5000) + ":" + p.showDecklist());
			}
		}
	}

	public static int grindGames(Player p1, Player p2, int bestOf) {
		int wins = 0;
		int gamesPlayed = 0;
		while (bestOf > 0) {
			if (play(p1, p2).equals(p1)) {
				wins++;
			}
			gamesPlayed++;
			bestOf--;
			if (play(p2, p1).equals(p1)) {
				wins++;
			}
			gamesPlayed++;
			bestOf--;
		}
		return ((100 * wins) / gamesPlayed);
	}

	private static void runBestOf25k() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1input = input.nextLine();
		String[] p1info = p1input.split(":");
		Player p1 = new Player(p1info[0]);
		p1.setDeck(parseDeckFromLine(p1info[1]));

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2input = input.nextLine();
		String[] p2info = p2input.split(":");
		Player p2 = new Player(p2info[0]);
		p2.setDeck(parseDeckFromLine(p2info[1]));

		if (p1.getDeck().size() + p2.getDeck().size() != 60) {
			debug("One or more decks isn't correct (@40 cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		System.out.println(
				p1.getName() + " wins " + grindGames(p1, p2, 25000) + "% of games against " + p2.getName() + ".");
		players.clear();
	}

	private static void runSingleGame() {
		System.out.println("Enter player 1's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p1inf = input.nextLine();
		String[] parse = p1inf.split(":");
		Player p1 = new Player(parse[0]);
		p1.setDeck(parseDeckFromLine(parse[1]));

		System.out.println("Enter player 2's name and decklist. (Format should be 'Name:Zap-4,Life Zap-3,...')");
		String p2info = input.nextLine();
		String[] parsename2 = p2info.split(":");
		Player p2 = new Player(parsename2[0]);
		p2.setDeck(parseDeckFromLine(parsename2[1]));

		if (p2.getDeck().size() + p1.getDeck().size() != 60) {
			debug("One or more decks isn't correct (@" + deckSize + " cards).");
			debug(p1.name + ": " + p1.getDeck().size());
			debug(p1.name + ": " + p1.showDecklist());
			debug(p2.name + ": " + p2.getDeck().size());
			debug(p2.name + ": " + p2.showDecklist());
			System.exit(0);
		}
		debug = true;
		System.out.println(play(p1, p2).getName() + " wins!");
	}

	private static void runTournament(int cullToThisNumber, String mandatoryCards, String bannedCards,
			String deckArchetypeName) {
		System.out.println("Generating decklists.");
		generateDecklists(500000, mandatoryCards, bannedCards);
		Collections.shuffle(players);
		System.out.println("Running tournament.");
		while (players.size() > cullToThisNumber) {
			Player p1 = players.remove(0);
			Player p2 = players.remove(0);
			debug();
			debug(p1.showDecklist());
			debug(p2.showDecklist());
			int p1winrate = grindGames(p1, p2, 8);
			games += 8;
			if (p1winrate > 50) {
				players.add(p1);
				p2 = null;
			} else if (p1winrate < 50) {
				players.add(p2);
				p1 = null;
			} else {
				players.add(p1);
				players.add(p2);
			}
			debug("======" + players.size() + "======");
		}
		System.out.println(deckArchetypeName + ":" + analyseTopCut());
		System.out.println(analyseColors());
		System.out.println(((100 * deathsByMill) / games) + "% of games are won by mill.");
	}

	public static ArrayList<Card> parseDeckFromLine(String p1deck) {
		ArrayList<Card> deck = new ArrayList<Card>();
		if (p1deck.length() > 0) {
			String[] cards = p1deck.split(",");
			for (String s : cards) {
				String[] cardQty = s.split("-");
				for (int i = Integer.parseInt(cardQty[1]); i > 0; i--) {
					Card c = findCardByName(cardQty[0]);
					deck.add(c);
				}
			}
			Collections.shuffle(deck);
		}
		return deck;
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

	private static String analyseColors() {
		int redCount = 0;
		int blueCount = 0;
		int greenCount = 0;
		int whiteCount = 0;
		int blackCount = 0;

		for (Player p : players) {
			for (Card c : p.getDeck()) {
				if (!c.getType().equals("Creature") && !c.getType().equals("Spell") && !c.getType().equals("Hero")) {
					System.out.println("" + c.getName() + " has an illegal type.");
				}
				if (!c.getColor().equals("Red") && !c.getColor().equals("Blue") && !c.getColor().equals("Green")
						&& !c.getColor().equals("White") && !c.getColor().equals("Black")) {
					System.out.println("" + c.getName() + " has an illegal color.");
				}

				switch (c.getColor()) {
				case "Red":
					redCount++;
					break;
				case "Blue":
					blueCount++;
					break;
				case "Green":
					greenCount++;
					break;
				case "White":
					whiteCount++;
					break;
				case "Black":
					blackCount++;
					break;
				default:
					break;
				}
			}
		}

		return "Red: " + redCount + " Blue: " + blueCount + " Green: " + greenCount + " White: " + whiteCount
				+ " Black: " + blackCount;
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

	public static Player play(Player p1, Player p2) {
		int turn = 1;
		p1.lifeTotal = 20;
		p2.lifeTotal = 20;
		p1.toggleGraveAbilities(true);
		p2.toggleGraveAbilities(true);
		p1.playsPerTurn = 2;
		p2.playsPerTurn = 2;

		if (p1.deck.cards.size() != deckSize || p2.deck.cards.size() != deckSize) {
			System.out.println("Definitely a problem.");
			System.out.println("P1 deck: " + p1.deck.cards.size());
			System.out.println("P1 deck: " + p1.showDecklist());
			System.out.println("P2 deck: " + p2.deck.cards.size());
			System.out.println("P2 deck: " + p2.showDecklist());
			System.exit(0);
		}
		p1.shuffle();
		p2.shuffle();
		p1.draw(4);
		p2.draw(4);
		while (p1.isAlive() && p2.isAlive() && turn <= 4000) {

			debug("Start of turn.");
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

			if (!p1.isAlive() || !p2.isAlive()) {
				debug("P1's graveyard triggers.");
				ArrayList<Card> triggers = new ArrayList<>();
				if (p1.getGraveAbilities()) {
					triggers.addAll(p1.grave);
					Collections.shuffle(triggers);
					for (Card c : triggers) {
				//		System.out.println("" + c.getName() + "'s grave ability.");
						c.graveAbility(p1, p2);
						if (!p2.isAlive() || !p1.isAlive()) {
							break;
						}
					}
					triggers.clear();
					debug(p1.name + "'s grave triggers. (" + p1.getLife() + ")-(" + p2.getLife() + ")");
				}
			}
			debug("End of " + p1.getName() + "'s turn.");

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

			if (!p1.isAlive() || !p2.isAlive()) {
				ArrayList<Card> triggers = new ArrayList<>();
				if (p2.getGraveAbilities()) {
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
				}
			}

			if (!p1.isAlive() || !p2.isAlive()) {
				break;
			}
			turn++;
		}

		if (p1.isAlive() && p2.isAlive()) {
			if (p1.lifeTotal > p2.lifeTotal) {
				if (p2.getDeck().size() == 0) {
					deathsByMill++;
				}
				p1.cleanup();
				p2.cleanup();
				return p1;
			}
			if (p1.getDeck().size() == 0) {
				deathsByMill++;
			}
			p1.cleanup();
			p2.cleanup();
			return p2;
		}

		if (p1.isAlive()) {
			if (p2.getDeck().size() == 0) {
				deathsByMill++;
			}
			p1.cleanup();
			p2.cleanup();
			return p1;
		}
		if (p1.getDeck().size() == 0) {
			deathsByMill++;
		}
		p1.cleanup();
		p2.cleanup();
		return p2;
	}

	public static void generateDecklists(int i, String mandatoryCards, String bannedCards) {
		for (int ps = 0; ps < i; ps++) {
			Player p = new Player("P" + (ps + 1));
			ArrayList<Card> mandatory = parseDeckFromLine(mandatoryCards);
			p.getDeck().addAll(mandatory);

			while (p.getDeck().size() < 0.8 * deckSize) {
				String card = fetchCardFactoringBans(bannedCards);
				debug("Finding card: " + card);
				while (cardCount(p.getDeck(), card) < 3) {
					Card c = findCardByName(card);
					p.getDeck().add(c);
				}
			}

			while (p.getDeck().size() < deckSize) {
				String card = fetchCardFactoringBans(bannedCards);
				debug("Finding card: " + card);
				while (cardCount(p.getDeck(), card) < 1) {
					Card c = findCardByName(card);
					p.getDeck().add(c);
				}
			}
			players.add(p);
		}
	}

	private static String fetchCardFactoringBans(String bannedCards) {
		Collections.shuffle(cardPool);
		if (bannedCards.contains(cardPool.get(0))) {
			return fetchCardFactoringBans(bannedCards);
		}
		return cardPool.get(0);
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

	public static void instantiateCardpool() {
		cardPool.add("Accumulated Knowledge");
		cardPool.add("Alchemy");
		cardPool.add("Beast");
		cardPool.add("Charged Laser");
		cardPool.add("Dark Contract");
		cardPool.add("Dark Pact");
		cardPool.add("Doctor");
		cardPool.add("Drain Life");
		cardPool.add("Eternal Flame");
		cardPool.add("Fairy");
		cardPool.add("Flame Rift");
		cardPool.add("Frenzy");
		cardPool.add("Fry");
		cardPool.add("Ghost");
		cardPool.add("Giant Clam");
		cardPool.add("Handy Robot");
		cardPool.add("Harass");
		cardPool.add("Herdcaller");
		cardPool.add("Spite");
		cardPool.add("Lab Assistant");
		cardPool.add("Lightning Bolt");
		cardPool.add("Mindflay");
		cardPool.add("Mushrooms");
		cardPool.add("Recover");
		cardPool.add("Salve");
		cardPool.add("Zombie");
		cardPool.add("Sanctify");
		cardPool.add("Ancestral Recall");
		cardPool.add("Tax");
		cardPool.add("Torrent");
		cardPool.add("Walking Woods");
		cardPool.add("Worker Ant");
		cardPool.add("Sage of Resurgence");
		cardPool.add("Confidant");
		cardPool.add("Hive");
		cardPool.add("Body Swap");
		cardPool.add("Royal Robot");
		cardPool.add("Tax Man");
		cardPool.add("Devotion Bolt");
		cardPool.add("Gesper");
		cardPool.add("Mass Grave");
		cardPool.add("Doomsday Device");
		cardPool.add("Fire Wizard");
		cardPool.add("Ice Wizard");
		cardPool.add("Pirate");
		cardPool.add("Feisty Sorceress");
		cardPool.add("Storyteller");
		cardPool.add("Blue Bolt");
		cardPool.add("Excise");
		cardPool.add("Forest Shrine");
		cardPool.add("Woodcutter");
		cardPool.add("Dark Zap");
		cardPool.add("Time Mage");
		cardPool.add("Crusader");
		cardPool.add("Ignite");
		cardPool.add("Leech");
		cardPool.add("Sycamore");
		cardPool.add("Tasty Bread");
		cardPool.add("Tarmogoyf");
		cardPool.add("Spire of Industry");
		cardPool.add("Beastmaster");
		cardPool.add("Colossal Junk Chucker");
		cardPool.add("Corporate Shredder");
		cardPool.add("Dark Transfusion");
		cardPool.add("White Bolt");
		cardPool.add("Greater Demon");
	}

	public static Card newCardByName(String string) {
		debug("newCardByName called on name: " + string + ".");
		if (!string.contains("Copied ")) {
			switch (string) {
			case "Greater Demon":
				return new GreaterDemon();
			case "White Bolt":
				return new WhiteBolt();
			case "Dark Transfusion":
				return new DarkTransfusion();
			
			case "Beastmaster":
				return new Beastmaster();
			case "Colossal Junk Chucker":
				return new ColossalJunkChucker();
			case "Corporate Shredder":
				return new CorporateShredder();
			case "Sycamore":
				return new Sycamore();
			case "Spire of Industry":
				return new SpireOfIndustry();
			case "Tasty Bread":
				return new TastyBread();
			case "Tarmogoyf":
				return new Tarmogoyf();
			case "Blue Bolt":
				return new BlueBolt();
			case "Leech":
				return new Leech();
			case "Ignite":
				return new Ignite();
			case "Crusader":
				return new Crusader();
			case "Time Mage":
				return new TimeMage();
			case "Dark Zap":
				return new DarkZap();
			case "Woodcutter":
				return new Woodcutter();
			case "Forest Shrine":
				return new ForestShrine();
			case "Zombie":
				return new Zombie();
			case "Excise":
				return new Excise();
			case "Ice Wizard":
				return new IceWizard();
			case "Fire Wizard":
				return new FireWizard();
			case "Pirate":
				return new Pirate();
			case "Feisty Sorceress":
				return new FeistySorceress();
			case "Devotion Bolt":
				return new DevotionBolt();
			case "Doomsday Device":
				return new DoomsdayDevice();
			case "Tax Man":
				return new TaxMan();
			case "Royal Robot":
				return new RoyalRobot();
			case "Body Swap":
				return new BodySwap();
			case "Hive":
				return new Hive();
			case "Worker Bee":
				return new WorkerBee();
			case "Killer Bee":
				return new KillerBee();
			case "Sage of Resurgence":
				return new SageOfResurgence();
			case "Accumulated Knowledge":
				return new AccumulatedKnowledge();
			case "Lab Assistant":
				return new LabAssistant();
			case "Beast":
				return new Beast();
			case "Charged Laser":
				return new ChargedLaser();
			case "Doctor":
				return new Doctor();
			case "Dark Contract":
				return new DarkContract();
			case "Dark Pact":
				return new DarkPact();
			case "Handy Robot":
				return new HandyRobot();
			case "Mindflay":
				return new Mindflay();
			case "Eternal Flame":
				return new EternalFlame();
			case "Walking Woods":
				return new WalkingWoods();
			case "Alchemy":
				return new Alchemy();
			case "Ghost":
				return new Ghost();
			case "Drain Life":
				return new DrainLife();
			case "Fairy":
				return new Fairy();
			case "Flame Rift":
				return new FlameRift();
			case "Frenzy":
				return new Frenzy();
			case "Fry":
				return new Fry();
			case "Harass":
				return new Harass();
			case "Herdcaller":
				return new Herdcaller();
			case "Spite":
				return new Spite();
			case "Lightning Bolt":
				return new LightningBolt();
			case "Mushrooms":
				return new Mushrooms();
			case "Recover":
				return new Recover();
			case "Worker Ant":
				return new WorkerAnt();
			case "Salve":
				return new Salve();
			case "Sanctify":
				return new Sanctify();
			case "Ancestral Recall":
				return new AncestralRecall();
			case "Tax":
				return new Tax();
			case "Giant Clam":
				return new GiantClam();
			case "Torrent":
				return new Torrent();
			case "Confidant":
				return new Confidant();
			case "Gesper":
				return new Gesper();
			case "Mass Grave":
				return new MassGrave();
			case "Storyteller":
				return new Storyteller();

			case "Ice":
				return new Ice();
			default:
				System.out.println(string);
				System.exit(0);
				return new ErrorMessage(string);
			}
		}
		return new ErrorMessage(string);
	}
}
