
public  class SafeHouse extends NormalLoc {

	public SafeHouse(Player player) {
		super(player,"G�venli Ev");
		
	}
	public boolean getLocation() {
		player.setHealth(player.getrHealth());
		System.out.println("�yile�tiniz...");
		System.out.println("G�venli B�lgedesiniz.");
		return true;
	}
	
}
