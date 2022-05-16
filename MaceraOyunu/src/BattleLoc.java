
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
		System.out.println("Þuan Buradasýnýz : " + this.getName());
		System.out.println("Dikkatli Ol Burada " + obsCount+ "Tane" + obstacle.getName()+"Var.");
		System.out.println("<S>avaþ veya <K>aç");
		String selCase=scan.next();
		selCase= selCase.toUpperCase();
		if (selCase.equals("S")) {
			if(combat(obsCount)) {
				System.out.println(this.getName() + "Tüm Düþmanlarý Temizlediniz Tebrikler !");
				if (this.award.equals("Food") && player.getInv().isFood()== false) {
					System.out.println("Tebrikler " + this.award + " Kazandýnýz .");
					player.getInv().setFood(true);
				}
				else if (this.award.equals("Firewood") && player.getInv().isFireWood()== false) {
					System.out.println("Tebrikler " + this.award + " Kazandýnýz .");
					player.getInv().setFireWood(true);
				}
				else if (this.award.equals("Water") && player.getInv().isWater()== false) {
					System.out.println("Tebrikler " + this.award + " Kazandýnýz .");
					player.getInv().setWater(true);
				}
			return true;
			}
			else {
				
			}
			if(player.getHealth() <= 0) {
				System.out.println("Öldünüz.");
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
			System.out.println("<V>ur ya da <K>aç");
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
			System.out.println("Düþmaný Yendiniz  ! Tebrikler !!");
			player.setMoney(player.getMoney()+obstacle.getAward());
			System.out.println("Toplam Paranýz : " + player.getMoney());
			obstacle.setHealth(defObsHealth);
		}else {
			
			return false;
		}
		System.out.println("-----------------------------");
		}
		return true;
	}
	public void playerStats() {
		System.out.println("Oyuncu Deðerleri \n-----------");
		System.out.println("Can : " + player.getHealth());
		System.out.println("Hasar : " + player.getTotalDamage());
		System.out.println("Para : " + player.getMoney());
		if(player.getInv().getDamage() > 0) {
			System.out.println("Silah : " + player.getInv().getwName());
		}
		if(player.getInv().getArmor() > 0) {
			System.out.println("Zýrh : " + player.getInv().getaName());
		}
		
	}
	public void enemyStats() {
		System.out.println(obstacle.getName() + " Deðerleri \n-----------");
		System.out.println("Can : " + obstacle.getHealth());
		System.out.println("Hasar : " + obstacle.getDamage());
		System.out.println("ödül : " + obstacle.getAward());
	}
	public void afterHit() {
		System.out.println("Oyuncunu Caný : " + player.getHealth());
		System.out.println(obstacle.getName() + "Caný : " + obstacle.getHealth());
		System.out.println("-------------------------");
	}
}
