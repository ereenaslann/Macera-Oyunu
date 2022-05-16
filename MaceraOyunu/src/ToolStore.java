
public class ToolStore extends NormalLoc{

	public ToolStore(Player player) {
		super(player,"Ma�aza");
		
	}	
	public boolean getLocation(){
		System.out.println("Para : " + getPlayer().getMoney());
		System.out.println("1-Silahlar");
		System.out.println("2-Z�rhlar");
		System.out.println("3-��k��");
		System.out.println("Se�iminiz : ");
		int selTool=scan.nextInt();
		int selItemID;
		switch(selTool) {
		case 1:
			selItemID=weaponMenu();
			buyWeapon(selItemID);
			break;
		case 2:
			selItemID=armorMenu();
			buyArmor(selItemID);
			break;
		default:
			break;
		}
		return true;
	}
	public int weaponMenu() {
		System.out.println("1- Tabanca\t <Para :25 - Hasar : 2>");
		System.out.println("2- K�l��\t <Para :35 - Hasar : 3>");
		System.out.println("3- T�fek\t <Para :45 - Hasar : 7>");
		System.out.println("4-��k��");
		System.out.println("Silah Se�iminiz : ");
		int selWeaponID= scan.nextInt();
		return selWeaponID;
		
	}
	public void buyWeapon(int itemID) {
		int damage=0,price=0;
		String wName=null;
		switch(itemID) {
		case 1:
			damage=2;
			wName="Tabanca";
			price=25;
		break;
		case 2:
			damage=3;
			wName="K�l��";
			price=35;
		break;
		case 3:
			damage=7;
			wName="T�fek";
			price=45;
		break;
		case 4:
			System.out.println("��k�� Yap�l�yor.");
			break;
		default:
			System.out.println("Ge�ersiz i�lem");
			break;
		}
		if (price > 0) {
			if(player.getMoney()>= price) {
				player.getInv().setDamage(damage);
				player.getInv().setwName(wName);
				player.setMoney(player.getMoney()-price);
				System.out.println(wName + "Silah� Sat�n Ald�n�z. �nceki Hasar : "+player.getDamage()+"�uan ki Hasar : "+(player.getTotalDamage()));
				System.out.println("Kalan para : "+player.getMoney());
			}else {
				System.out.println("Yetersiz Bakiye");
			}
		}
		}
		public int armorMenu() {
		System.out.println("1-Hafif\t <Para: 15 - Engelleme: 1");
		System.out.println("2-Orta\t  <Para: 25 - Engelleme: 3");
		System.out.println("3-A��r\t  <Para: 40 - Engelleme: 5");
		System.out.println("4- �IKI�.");
		System.out.println("Z�rh Se�iminiz : ");
		int selArmorID= scan.nextInt();
		return selArmorID;
	}
		public void buyArmor(int itemID) {
			int armor=0,price=0;
			String aName=null;
			switch(itemID) {
			case 1:
				armor=1;
				aName="Hafif Z�rh";
				price=15;
			break;
			case 2:
				armor=3;
				aName="Orta Z�rh";
				price=25;
			break;
			case 3:
				armor=5;
				aName="A��r Z�rh";
				price=40;
			break;
			case 4:
				System.out.println("Ge�ersiz ��lem !");
			break;
			default:
				System.out.println("Ge�ersiz i�lem");
				break;
				
			}
			if(price > 0) {
				if(player.getMoney()>= price) {
					player.getInv().setArmor(armor);
					player.getInv().setaName(aName);
					player.setMoney(player.getMoney()-price);
					System.out.println(aName + "Z�rh� Sat�n Ald�n�z. �nceki Z�rh : "+player.getArmor()+"�uan ki Z�rh : "+(player.getTotalArmor()));
					System.out.println("Kalan para : "+player.getMoney());
				}else {
					System.out.println("Yetersiz Bakiye");
				
			}
			}
		}
}
