import java.util.Scanner;

public class Bilgisayar {
	Bina[] binalar;
	Asker[] askerler;
	Bina bina_kur;
	Asker asker_uret;
	Kaynaklar kaynaklar;
	int piyadeler = 0;
	int suvariler = 0;
	int okcular = 0;
	int altin;
	int demir;
	int odun;
	int choice;
	AnaBina anabina;
	public Bilgisayar() {
		binalar = new Bina[0];
		askerler = new Asker[0];
		altin = 100;
		demir = 100;
		odun = 100;
		anabina = new AnaBina();
		choice = 1;
	}
	public void Play() {
		if(choice % 9 == 0)choice = 1;
		
		kaynaklar.altin = altin;
		kaynaklar.demir = demir;
		kaynaklar.odun = odun;
		Get_materials();
		Select_option(choice);
		
		altin = kaynaklar.altin;
		demir = kaynaklar.demir;
		odun = kaynaklar.odun;
		choice++;
	}
	private void Get_materials() {
		if(binalar.length > 0) {
			for(int i = 0;i < binalar.length;i++) {
				binalar[i].Get_material();
			}
		}
	}
	private void Select_option(int choice) {
		switch(choice) {
		case 1:{
			Build_carpenter();
			break;
		}	
		case 2:{
			Build_gold_mine();
			break;
		}
		case 3:{
			Build_iron_mine();
			break;
		}
		case 4:{
			Produce_infantry();
			break;
		}	
		case 5:{
			Produce_cavalry();
			break;
		}
		case 6:{
			Produce_archer();
			break;
		}
		case 7:{
			Attack();
			break;
		}
		case 8:{
			Pass_tour();
			break;
		}
		default:{
			break;
		}
		}
	}
	private void Build_carpenter() {
		int length = binalar.length;
		bina_kur = new Marangozhane();
		if(bina_kur.Build_structure()) {
				if(length == 0) {
					binalar = new Bina[1];
					binalar[0] = new Marangozhane();
				}
				else {
					Bina[] fake = new Bina[length+1];
					for(int i = 0;i < length;i++) {
						fake[i] = binalar[i];
					}
					fake[length] = new Marangozhane();
					binalar = new Bina[length+1];
					for(int i = 0;i < length+1;i++) {
						binalar[i] = fake[i];
					}
				}
				System.out.println("Bilgisayar : Marangozhane kuruldu. Yeni durum soyledir :");
		}
		else {
			choice++;
			Select_option(choice);
			
		}
	}
	private void Build_gold_mine() {
		int length = binalar.length;
		bina_kur = new AltinMadeni();
		if(bina_kur.Build_structure()) {
				if(length == 0) {
					binalar = new Bina[1];
					binalar[0] = new AltinMadeni();
				}
				else {
					Bina[] fake = new Bina[length+1];
					for(int i = 0;i < length;i++) {
						fake[i] = binalar[i];
					}
					fake[length] = new AltinMadeni();
					binalar = new Bina[length+1];
					for(int i = 0;i < length+1;i++) {
						binalar[i] = fake[i];
					}
				}
				System.out.println("Bilgisayar : AltinMadeni kuruldu. Yeni durum soyledir :");
		}
		else {
			choice++;
			Select_option(choice);
			
		}
	}
	private void Build_iron_mine() {
		int length = binalar.length;
		bina_kur = new DemirMadeni();
		if(bina_kur.Build_structure()) {
				if(length == 0) {
					binalar = new Bina[1];
					binalar[0] = new DemirMadeni();
				}
				else {
					Bina[] fake = new Bina[length+1];
					for(int i = 0;i < length;i++) {
						fake[i] = binalar[i];
					}
					fake[length] = new DemirMadeni();
					binalar = new Bina[length+1];
					for(int i = 0;i < length+1;i++) {
						binalar[i] = fake[i];
					}
				}
				System.out.println("Bilgisayar : Demirmadeni kuruldu. Yeni durum soyledir :");
		}
		else {
			choice++;
			Select_option(choice);
			
		}
	}
	
	private void Produce_infantry() {
		asker_uret = new Piyade();
		int number = asker_uret.Maximum();
			for(int i = 0;i < number;i++) {
				asker_uret = new Piyade();
				asker_uret.Produce_soldier();
				if(askerler.length == 0) {
					askerler = new Asker[1];
					askerler[0] = new Piyade();
				}
				else {
					Asker[] fake = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						fake[j] = askerler[j];
					}
					fake[askerler.length] = new Piyade();
					askerler = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						askerler[j] = fake[j];
					}
				}
			
			}
		
	}
	private void Produce_cavalry() {
		asker_uret = new Suvari();
		int number = asker_uret.Maximum();
			for(int i = 0;i < number;i++) {
				asker_uret = new Suvari();
				asker_uret.Produce_soldier();
				if(askerler.length == 0) {
					askerler = new Asker[1];
					askerler[0] = new Suvari();
				}
				else {
					Asker[] fake = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						fake[j] = askerler[j];
					}
					fake[askerler.length] = new Suvari();
					askerler = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						askerler[j] = fake[j];
					}
				}
			
			}
		
	}
	private void Produce_archer() {
		asker_uret = new Okcu();
		int number = asker_uret.Maximum();
			for(int i = 0;i < number;i++) {
				asker_uret = new Okcu();
				asker_uret.Produce_soldier();
				if(askerler.length == 0) {
					askerler = new Asker[1];
					askerler[0] = new Okcu();
				}
				else {
					Asker[] fake = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						fake[j] = askerler[j];
					}
					fake[askerler.length] = new Okcu();
					askerler = new Asker[askerler.length + 1];
					for(int j = 0;j < askerler.length;j++) {
						askerler[j] = fake[j];
					}
				}
			
			}
		
	}
	private void Classify_soldiers() {
		piyadeler = 0;
		okcular = 0;
		suvariler = 0;
		for(int i = 0;i < askerler.length;i++) {
			if("Piyade".equals(askerler[i].name)) {
				piyadeler++;
			}
			else if("Suvari".equals(askerler[i].name)) {
				suvariler++;
			}
			else if("Okcu".equals(askerler[i].name)) {
				okcular++;
			}
		
		
		}
	
	}
	
	private void Attack() {
		Classify_soldiers();
		System.out.println("Yeni durum soyledir : ");
	}
	private void Pass_tour() {
		
		choice = 0;
		
		kaynaklar.altin = altin;
		kaynaklar.demir = demir;
		kaynaklar.odun = odun;
		Get_materials();
			
		altin = kaynaklar.altin;
		demir = kaynaklar.demir;
		odun = kaynaklar.odun;
		System.out.println("Bilgisayar : Bu turu hicbir sey yapmadan gecti. Yeni durum soyledir : ");
	}
	public void Show_informations() {
		
		// Bu metodu oyuncu sinifi kendi play metoduna yazdi
		Classify_soldiers();
		int marangozhane = 0;
		int demir_madeni = 0;
		int altin_madeni = 0;
		for(int i = 0;i < binalar.length;i++) {
			if("Marangozhane".equals(binalar[i].name)) {
				marangozhane++;
			}
			else if("DemirMadeni".equals(binalar[i].name)) {
				demir_madeni++;
			}
			else if("AltinMadeni".equals(binalar[i].name)) {
				altin_madeni++;
			}
		}
		System.out.println("Bilgisayar B: Odun: "+odun+" Demir: "+demir+" Altin: "+altin);
		System.out.println("Marangozhane: "+marangozhane+" Demir Madeni: "+demir_madeni+" Altin Madeni: "+altin_madeni);
		System.out.println("Piyade: "+piyadeler+" Suvari: "+suvariler+" Okcu: "+okcular);
		System.out.println();
	}
	
	
}
