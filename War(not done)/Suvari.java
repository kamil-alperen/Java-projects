
public class Suvari extends Asker{
	public Suvari() {
		health = 50;
		piyadeye = 50;
		suvariye = 50;
		okcuya = 25;
		binaya = 40;
		name = "Suvari";
		
	}

	public boolean Produce_soldier() {
		if(Check()) {
			odun -= 5;
			demir -= 20;
			altin -= 30;
			return true;
		}
		return false;
	}
	private boolean Check() {
		if(odun >= 5 & demir >= 20 & altin >= 30) {
			return true;
		}
		return false;
	}

	@Override
	public int Maximum() {
		int limit_odun = odun / 5;
		int limit_demir = demir / 20;
		int limit_altin = altin / 30;
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
