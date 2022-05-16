
public  class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player,"Güvenli Ev");
		
	}
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("Ýyileþtiniz...");
		System.out.println("Güvenli Bölgedesiniz.");
		return true;
	}
	
}
