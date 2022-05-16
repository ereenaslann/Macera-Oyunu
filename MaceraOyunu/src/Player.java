 import java.util.Scanner;

public class Player {
	
	private int Health,Damage,Money,rHealth,Armor;
	private String name,cName;
	Inventory Inv;
	Scanner scan= new Scanner(System.in);
	public Player(String name) {
		this.name = name;
		this.Inv= new Inventory();
	}
		public void selectCha() {
			switch (chaMenu()) {
			case 1:
				initPlayer("Samuray",5 ,21,15);
				break;
			case 2:
				initPlayer("Ok�u",7 ,18,20);
				break;
			case 3:
				initPlayer("�ovalye",8 ,24,5);
				break;
			default:
				initPlayer("Samuray",5 ,21,15);
				break;
			}
		System.out.println("Karakter T�r� : "+getcName()+"\t Hasar: "+getDamage()+"\t Sa�l�k: "+getHealth()+"\t Para: "+getMoney());
			
		}
		public void initPlayer(String cName,int dmg,int hlty,int mny) {
			setcName(cName);
			setDamage(dmg);
			setHealth(hlty);
			setMoney(mny);
			setrHealth(hlty);
		}
		public int chaMenu() {
			System.out.println("L�tfen Bir Karakter Se�iniz : ");
			System.out.println("1-Samuray \t Hasar: 5 \t Sa�l�k: 21 \t Para: 15");
			System.out.println("2-Ok�u    \t Hasar: 7 \t Sa�l�k: 18 \t Para: 20");
			System.out.println("3-�ovalye \t Hasar: 8 \t Sa�l�k: 24 \t Para: 5");
			System.out.println("Karakter Se�iminiz : ");
			int chaID= scan.nextInt();
			while(chaID < 1 || chaID > 3) {
				System.out.println("L�tfen ge�erli bir de�er giriniz !");
				chaID=scan.nextInt();
			}
			return chaID;
		
		}
		public int getTotalDamage() {
			return this.getDamage()+this.getInv().getDamage();
		}
		public int getTotalArmor() {
			return this.getArmor()+this.getInv().getArmor();
		}
	public int getHealth() {
		return Health;
	}
	public void setHealth(int health) {
		Health = health;
	}
	public int getDamage() {
		return Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Inventory getInv() {
		return Inv;
	}
	public void setInv(Inventory inv) {
		Inv = inv;
	}
	public int getrHealth() {
		return rHealth;
	}
	public void setrHealth(int rHealth) {
		this.rHealth = rHealth;
	}
	public int getArmor() {
		return Armor;
	}
	public void setArmor(int armor) {
		Armor = armor;
	}
	
}
