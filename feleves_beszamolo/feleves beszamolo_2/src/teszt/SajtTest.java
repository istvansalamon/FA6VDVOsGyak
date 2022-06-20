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
	    System.out.println("Lista rendezéssel: " + lista);
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
			System.out.println("Kérem az egységárat! \n");
			egysegAr = in.nextInt();
			if (egysegAr < 400 || egysegAr > 1000) {
				System.out.println("Hibás egységár,az egysegar 400 és 1000 között lehet!");
			}
		} while (egysegAr < 400 || egysegAr > 1000);
		in.nextLine();
		
		System.out.println("Kérem a márkát!");
		String marka = in.nextLine();
		
		System.out.println("Kérem a gyártási idõt!");
		String gyartasIdo = in.nextLine();
		LocalDate gyartasi = LocalDate.parse(gyartasIdo, DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("Kérem a lejárati idõt!");
		String lejaratIdo = in.nextLine();
		LocalDate lejarati = LocalDate.parse(lejaratIdo, DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.println("Kérem a zsírtartalmat!");
		double zsir = in.nextDouble();
		
		double tomeg = 0;
		do {
			System.out.println("Kérem a tömeget!");
			tomeg = in.nextDouble();
			if (tomeg < 10 || tomeg > 100) {
				System.out.println("Hibás tömeg,a tömeg 10 és 10 között lehet");
			}
		} while (tomeg < 10 || tomeg > 100);
		in.nextLine();
		
		System.out.println("Adja meg a típust (DARABOLT, SZELETELT, OMLESZTETT)");
		String t = in.nextLine().toUpperCase();
		Tipus tipusa = Tipus.valueOf(t);
		System.out.println("Kovetkezo termék:");
		
		Sajt sajtok = new Sajt(egysegAr,marka,gyartasi.atStartOfDay(),lejarati.atStartOfDay(),tomeg,tipusa,zsir);
		
		return sajtok;
	}

}
