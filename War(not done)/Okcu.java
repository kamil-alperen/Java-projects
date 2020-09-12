
public class Okcu extends Asker{

	public Okcu() {
		health = 5;
		piyadeye = 25;
		suvariye = 20;
		okcuya = 5;
		binaya = 1;
		name = "Okcu";
	}

	public boolean Produce_soldier() {
		if(Check()) {
			odun -= 15;
			demir -= 5;
			altin -= 5;
			return true;
		}
		return false;
	}
	private boolean Check() {
		if(odun >= 15 & demir >= 5 & altin >= 5) {
			return true;
		}
		return false;
	}

	@Override
	public int Maximum() {
		int limit_odun = odun / 15;
		int limit_demir = demir / 5;
		int limit_altin = altin / 5;
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
