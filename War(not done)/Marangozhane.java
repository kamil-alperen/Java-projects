
public class Marangozhane extends Bina{
	public Marangozhane() {
		name = "Marangozhane";
	}
	public boolean Build_structure() {
		if(check()) {
			odun = odun - 20;
			demir = demir - 5;
			return true;
		}
		return false;
	}
	public boolean check() {
		if(demir >= 5) {
			if(odun >= 20) {
				return true;
			}
			return false;
		}
		return false;
	}
	public void Get_material() {
		odun = odun + 40;
	}
}
