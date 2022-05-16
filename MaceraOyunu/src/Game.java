import java.util.Scanner;

public class Game {
	Scanner scan= new Scanner(System.in);
	Player player;
	Location location;
	Game game;
	
	public void Login() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Merhaba, Macera Oyununa Hoþ geldiniz ! ");
		System.out.println("Oyuna Baþlamadan önce Ýsminizi Giriniz :");
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
				System.out.println("Lütfen Gitmek Ýstediðiniz yeri Seçiniz : ");
				System.out.println("1-Güvenli Ev --> Burada Düþman Yok ve Canýnýz Yenilenir.");
				System.out.println("2-Maðara --> Burada Karþýnýza Zombi Çýkabilir.");
				System.out.println("3-Nehir --> Burada Karþýnýza Vampir Çýkabilir.");
				System.out.println("4-Orman --> Burada Karþýnýza Ayý Çýkabilir.");
				System.out.println("5-Maðaza --> Buradan Yeni Ekipmanlar Temin Edebilirsiniz.");
				System.out.print("Gitmek Ýstediðiniz Yer : ");
				int selLoc= scan.nextInt();
				while (selLoc < 1 || selLoc > 6) {
					System.out.print("Geçersiz Bir Yer Numarasý Girdiniz Tekrar Deneyiniz !");
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
						System.out.println("Tebrikler Oyunu Kazandýnýz :) ");
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


