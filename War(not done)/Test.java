import java.util.*;
public class Test {
	
	/*	BU PROJEDE SAVAS YAPILAMIYOR.
	 *  oyuncu sinifinin help metodu yani ipucu ile oynama metodu da dogal olarak yok
	 *  ama geri kalan seyler calisiyor
	 */

	public static void main(String[] args) {
		int count = 1;
		Bilgisayar bilgisayar = new Bilgisayar();
		Oyuncu oyuncu = new Oyuncu();
		System.out.println("Oyuna Hosgeldiniz ");
		System.out.println("TUR : "+ count);
		oyuncu.Show_informations();
		bilgisayar.Show_informations();
		
		while(oyuncu.anabina.health != 0 & bilgisayar.anabina.health != 0) {
			
			oyuncu.Play();
			System.out.println();
			oyuncu.Show_informations();
			bilgisayar.Show_informations();
			
			count++;
			System.out.println("TUR : "+ count);
			
			bilgisayar.Play();
			System.out.println();
			oyuncu.Show_informations();
			bilgisayar.Show_informations();
			
			count++;
			System.out.println("TUR : "+ count);
			
		}
		if(oyuncu.anabina.health == 0) {
			System.out.println(" Oyun bitti Kazanan : bilgisayar");
		}
		else if(bilgisayar.anabina.health == 0) {
			System.out.println(" Oyun bitti Kazanan : oyuncu");
		}
		
	
	
	
	
	
	}
}
