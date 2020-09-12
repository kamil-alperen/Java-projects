
public class DemirMadeni extends Bina{
	public DemirMadeni() {
		name = "DemirMadeni";
	}
	public boolean Build_structure() {
		if(check()) {
			odun = odun - 10;
			demir = demir - 30;
			return true;
		}
		return false;
	}
	public boolean check() {
		if(demir >= 30) {
			if(odun >= 10) {
				return true;
			}
			return false;
		}
		return false;
	}
	public void Get_material() {
		demir = demir + 20;
	}
	
}
