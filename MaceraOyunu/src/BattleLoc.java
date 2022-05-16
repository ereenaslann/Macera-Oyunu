
public abstract class BattleLoc extends Location{
	
	protected Obstacle obstacle;
	protected String award;
	public BattleLoc(Player player,String name,Obstacle obstacle,String award) {
		super(player);
		this.name=name;
		this.obstacle=obstacle;
		this.award=award;
		
	}
	public boolean getLocation() {
		int obsCount=obstacle.count();
		System.out.println("�uan Buradas�n�z : " + this.getName());
		System.out.println("Dikkatli Ol Burada " + obsCount+ "Tane" + obstacle.getName()+"Var.");
		System.out.println("<S>ava� veya <K>a�");
		String selCase=scan.next();
		selCase= selCase.toUpperCase();
		if (selCase.equals("S")) {
			if(combat(obsCount)) {
				System.out.println(this.getName() + "T�m D��manlar� Temizlediniz Tebrikler !");
				if (this.award.equals("Food") && player.getInv().isFood()== false) {
					System.out.println("Tebrikler " + this.award + " Kazand�n�z .");
					player.getInv().setFood(true);
				}
				else if (this.award.equals("Firewood") && player.getInv().isFireWood()== false) {
					System.out.println("Tebrikler " + this.award + " Kazand�n�z .");
					player.getInv().setFireWood(true);
				}
				else if (this.award.equals("Water") && player.getInv().isWater()== false) {
					System.out.println("Tebrikler " + this.award + " Kazand�n�z .");
					player.getInv().setWater(true);
				}
			return true;
			}
			else {
				
			}
			if(player.getHealth() <= 0) {
				System.out.println("�ld�n�z.");
				return false;
			}
		}
		return true;
	}
	public boolean combat(int obsCount) {
		for (int i =0 ;i < obsCount;i++) {
			int defObsHealth= obstacle.getHealth();
			playerStats();
			enemyStats();
		while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
			System.out.println("<V>ur ya da <K>a�");
			String selCase= scan.next();
			selCase=selCase.toUpperCase();
			if(selCase.equals("V")){
				System.out.println("Siz Vurdunuz !");
				obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
				afterHit();
				if(obstacle.getHealth() > 0) {
					System.out.println("Canavar Size Vurdu !");
					player.setHealth(player.getHealth()-(obstacle.getDamage()-player.getInv().getArmor()));
					afterHit();
				}
			}else {
				return false;
			}
		} if (obstacle.getHealth() < player.getHealth()) {
			System.out.println("D��man� Yendiniz  ! Tebrikler !!");
			player.setMoney(player.getMoney()+obstacle.getAward());
			System.out.println("Toplam Paran�z : " + player.getMoney());
			obstacle.setHealth(defObsHealth);
		}else {
			
			return false;
		}
		System.out.println("-----------------------------");
		}
		return true;
	}
	public void playerStats() {
		System.out.println("Oyuncu De�erleri \n-----------");
		System.out.println("Can : " + player.getHealth());
		System.out.println("Hasar : " + player.getTotalDamage());
		System.out.println("Para : " + player.getMoney());
		if(player.getInv().getDamage() > 0) {
			System.out.println("Silah : " + player.getInv().getwName());
		}
		if(player.getInv().getArmor() > 0) {
			System.out.println("Z�rh : " + player.getInv().getaName());
		}
		
	}
	public void enemyStats() {
		System.out.println(obstacle.getName() + " De�erleri \n-----------");
		System.out.println("Can : " + obstacle.getHealth());
		System.out.println("Hasar : " + obstacle.getDamage());
		System.out.println("�d�l : " + obstacle.getAward());
	}
	public void afterHit() {
		System.out.println("Oyuncunu Can� : " + player.getHealth());
		System.out.println(obstacle.getName() + "Can� : " + obstacle.getHealth());
		System.out.println("-------------------------");
	}
}
