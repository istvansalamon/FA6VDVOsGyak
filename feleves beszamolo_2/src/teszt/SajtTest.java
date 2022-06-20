package teszt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import etel.Sajt;
import etel.Sajt.Tipus;

public class SajtTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 3;
		Sajt[] finomSajtok= new Sajt[size];
		
		for (int i = 0 ; i < 3 ; i++) {
			finomSajtok[i] = SajtTest.beOlvas();
		}
		
		SajtTest.kiIr(finomSajtok);
		
		int temp = SajtTest.szamol(finomSajtok, 4);
		System.out.println("Aprilisban "+temp+" sajt jar le");
		
		/*List<Date> lista = new ArrayList<Date>();
		Date date = new Date;
		Collections.sort(lista);
	    System.out.println("Lista rendez�ssel: " + lista);
		*/
	}
	
	public static void kiIr(Sajt[] sajt) {
		for (int i = 0 ; i < sajt.length ; i++) {
			System.out.println(sajt[i]);
		}
	}
	
	public static int szamol(Sajt[] sajtok, int honap) {
		int db = 0;
		for (int i = 0 ; i < sajtok.length ; i++) {
			if (sajtok[i].getLejaratiIdo().getMonthValue() == honap) {
				db++;
			}
		}
		return db;
	}
		
	
	public static Sajt beOlvas() {
		Scanner in = new Scanner(System.in);
		int egysegAr = 0;
		do {
			System.out.println("K�rem az egys�g�rat! \n");
			egysegAr = in.nextInt();
			if (egysegAr < 400 || egysegAr > 1000) {
				System.out.println("Hib�s egys�g�r,az egysegar 400 �s 1000 k�z�tt lehet!");
			}
		} while (egysegAr < 400 || egysegAr > 1000);
		in.nextLine();
		
		System.out.println("K�rem a m�rk�t!");
		String marka = in.nextLine();
		
		System.out.println("K�rem a gy�rt�si id�t!");
		String gyartasIdo = in.nextLine();
		LocalDate gyartasi = LocalDate.parse(gyartasIdo, DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("K�rem a lej�rati id�t!");
		String lejaratIdo = in.nextLine();
		LocalDate lejarati = LocalDate.parse(lejaratIdo, DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("K�rem a zs�rtartalmat!");
		double zsir = in.nextDouble();
		
		double tomeg = 0;
		do {
			System.out.println("K�rem a t�meget!");
			tomeg = in.nextDouble();
			if (tomeg < 10 || tomeg > 100) {
				System.out.println("Hib�s t�meg,a t�meg 10 �s 10 k�z�tt lehet");
			}
		} while (tomeg < 10 || tomeg > 100);
		in.nextLine();
		
		System.out.println("Adja meg a t�pust (DARABOLT, SZELETELT, OMLESZTETT)");
		String t = in.nextLine().toUpperCase();
		Tipus tipusa = Tipus.valueOf(t);
		System.out.println("Kovetkezo term�k:");
		
		Sajt sajtok = new Sajt(egysegAr,marka,gyartasi.atStartOfDay(),lejarati.atStartOfDay(),tomeg,tipusa,zsir);
		
		return sajtok;
	}

}
