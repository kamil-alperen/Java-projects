
public class Piyade extends Asker{
	public Piyade() {
		health = 10;
		piyadeye = 10;
		suvariye = 5;
		okcuya = 5;
		binaya = 20;
		name = "Piyade";
		
	}
	public boolean Produce_soldier() {
		if(Check()) {
			odun -= 5;
			demir -= 10;
			altin -= 2;
			return true;
		}
		return false;
	}
	private boolean Check() {
		if(odun >= 5 & demir >= 10 & altin >= 2) {
			return true;
		}
		return false;
	}
	public int Maximum() {
		int limit_odun = odun / 5;
		int limit_demir = demir / 10;
		int limit_altin = altin / 2;
		if(limit_odun > limit_demir) {
			if(limit_demir > limit_altin) {
				return limit_altin;
			}
			else {
				return limit_demir;
			}
		}
		else {
			if(limit_odun > limit_altin) {
				return limit_altin;
			}
			else {
				return limit_odun;
			}
		}
	}
	
}
