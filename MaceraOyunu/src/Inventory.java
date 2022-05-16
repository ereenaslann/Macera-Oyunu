
public class Inventory  {

	private String wName,aName;
	private boolean water,food,fireWood;
	private int damage,armor;
	
	Inventory(){
		this.water= false;
		this.food= false;
		this.fireWood=false;
		this.wName=null;
		this.aName=null;
		this.damage=0;
		this.armor=0;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isFireWood() {
		return fireWood;
	}

	public void setFireWood(boolean fireWood) {
		this.fireWood = fireWood;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
	
}
