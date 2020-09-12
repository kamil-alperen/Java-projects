import java.util.*;
public class Oyuncu {
	Bina[] binalar;
	Asker[] askerler;
	Bina bina_kur;
	Asker asker_uret;
	Kaynaklar kaynaklar;
	Bilgisayar bilgisayar;
	int piyadeler = 0;
	int okcular = 0;
	int suvariler = 0;
	int altin;
	int demir;
	int odun;
	AnaBina anabina;
	public Oyuncu() {
		binalar = new Bina[0];
		bilgisayar = new Bilgisayar();
		askerler = new Asker[0];
		altin = 100;
		demir = 100;
		odun = 100;
		anabina = new AnaBina();
	}
	private void Show_options() {
		System.out.println(
				"1 - Bir marangozhane kur 	\n" +
				"2 - Bir altin madeni kur 	\n" +
				"3 - Bir demir madeni kur 	\n" +
				"4 - N tane piyade uret   	\n" +
				"5 - N tane suvari uret   	\n" +
				"6 - N tane okcu uret     	\n" +
				"7 - Saldir \n"               	+
				"8 - Ipucu ile otomatik oyna\n" +
				"9 - Sirayi pas gecme       \n");
		System.out.println("Bir secenek sec : ");
		Scanner keyboard = new Scanner(System.in);
		int choice = keyboard.nextInt();
		Select_option(choice);
	}
	public void Play() {
		
		
		kaynaklar.altin = altin;
		kaynaklar.demir = demir;
		kaynaklar.odun = odun;
		Get_materials();
		Show_options();
	
		altin = kaynaklar.altin;
		demir = kaynaklar.demir;
		odun = kaynaklar.odun;
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
				Help();
				break;
			}	
			case 9:{
				Pass_tour();
				break;
			}
			default:{
				System.out.println("Hatali rakam ,Tekrar seciniz");
				Show_options();
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
				System.out.println("Oyuncu : Marangozhane kuruldu. Yeni durum soyledir : ");
		}
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
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
				System.out.println("Oyuncu : AltinMadeni kuruldu. Yeni durum soyledir : ");
		}
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
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
				System.out.println("Oyuncu : DemirMadeni kuruldu. Yeni durum soyledir : ");
		}
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
		}
	}
	private void Produce_infantry() {
		System.out.println("Kac tane PÝYADE uretmek istiyorsun");
		Scanner key = new Scanner(System.in);
		int number = key.nextInt();
		asker_uret = new Piyade();
		boolean durum = false;
		if(number <= asker_uret.Maximum()) {
			durum = true;
		}
		if(durum) {
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
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
		}
		
	}
	private void Produce_cavalry() {
		System.out.println("Kac tane SUVARÝ uretmek istiyorsun");
		Scanner key = new Scanner(System.in);
		int number = key.nextInt();
		asker_uret = new Suvari();
		boolean durum = false;
		if(number <= asker_uret.Maximum()) {
			durum = true;
		}
		if(durum) {
			for(int i = 0;i < number;i++) {
				asker_uret = new Piyade();
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
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
		}
	}
	private void Produce_archer() {
		System.out.println("Kac tane OKCU uretmek istiyorsun");
		Scanner key = new Scanner(System.in);
		int number = key.nextInt();
		asker_uret = new Okcu();
		boolean durum = false;
		if(number <= asker_uret.Maximum()) {
			durum = true;
		}
		if(durum) {
			for(int i = 0;i < number;i++) {
				asker_uret = new Piyade();
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
		else {
			System.out.println("Yetersiz kaynak,tekrar bir secim yap");
			Show_options();
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
	private void Help() {
		System.out.println("Yeni durum soyledir : ");
	}
	private void Pass_tour() {
		
		
		kaynaklar.altin = altin;
		kaynaklar.demir = demir;
		kaynaklar.odun = odun;
		Get_materials();
		
		altin = kaynaklar.altin;
		demir = kaynaklar.demir;
		odun = kaynaklar.odun;
		System.out.println("Oyuncu : Bu turu hicbir sey yapmadan gecti. Yeni durum soyledir : ");
	
	}
	public void Show_informations() {
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
		
		System.out.println("Oyuncu A: Odun: "+odun+" Demir: "+demir+" Altin: "+altin);
		System.out.println("Marangozhane: "+marangozhane+" Demir Madeni: "+demir_madeni+" Altin Madeni: "+altin_madeni);
		System.out.println("Piyade: "+piyadeler+" Suvari: "+suvariler+" Okcu: "+okcular);
		System.out.println();
	}
}
