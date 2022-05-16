import java.util.Scanner;

public class Game {
	Scanner scan= new Scanner(System.in);
	Player player;
	Location location;
	Game game;
	
	public void Login() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Merhaba, Macera Oyununa Ho� geldiniz ! ");
		System.out.println("Oyuna Ba�lamadan �nce �sminizi Giriniz :");
		String playerName = scan.nextLine();
		player =new Player(playerName);
		player.selectCha();
		start();
	}
	public void start() {
		
			while (true) {

				System.out.println();
				System.out.println("====================================================");
				System.out.println();
				System.out.println("L�tfen Gitmek �stedi�iniz yeri Se�iniz : ");
				System.out.println("1-G�venli Ev --> Burada D��man Yok ve Can�n�z Yenilenir.");
				System.out.println("2-Ma�ara --> Burada Kar��n�za Zombi ��kabilir.");
				System.out.println("3-Nehir --> Burada Kar��n�za Vampir ��kabilir.");
				System.out.println("4-Orman --> Burada Kar��n�za Ay� ��kabilir.");
				System.out.println("5-Ma�aza --> Buradan Yeni Ekipmanlar Temin Edebilirsiniz.");
				System.out.print("Gitmek �stedi�iniz Yer : ");
				int selLoc= scan.nextInt();
				while (selLoc < 1 || selLoc > 6) {
					System.out.print("Ge�ersiz Bir Yer Numaras� Girdiniz Tekrar Deneyiniz !");
					selLoc=scan.nextInt();
				}
				switch(selLoc) {
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4:
					location = new River(player);
					break;
				case 5:
					location = new ToolStore(player);
				break;
					default:
					location = new SafeHouse(player);
			}
				if (player.getClass().getName().equals("SafeHouse")) {
					if(player.getInv().isFireWood() && player.getInv().isFood() && player.getInv().isWater()) {
						System.out.println("Tebrikler Oyunu Kazand�n�z :) ");
						break;
					}
				}
			if (!location.getLocation()) {
			System.out.println("Oyun Bitti !");
			break;
			}
			}
			}
	
	}


