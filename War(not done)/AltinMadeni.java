
public class AltinMadeni extends Bina{
	public AltinMadeni() {
		name = "AltinMadeni";
	}
	public boolean Build_structure() {
		if(check()) {
			odun = odun - 20;
			demir = demir - 20;
			return true;
		}
		return false;
	}
	public boolean check() {
		if(demir >= 20) {
			if(odun >= 20) {
				return true;
			}
			return false;
		}
		return false;
	}
	public void Get_material() {
		altin = altin + 10;
	
	}
}
