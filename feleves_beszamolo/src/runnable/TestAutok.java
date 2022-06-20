package runnable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import Auto.Auto;
import Auto.Hasznaltauto;
import Auto.Hasznaltauto.Allapota;

public class TestAutok {

	public static void main(String[] args) {
	
		int size = 3;
		Hasznaltauto[] tomb = new Hasznaltauto[size];
		for (int i = 0; i < size; i++) {
			tomb[i]=TestAutok.beOlvas();
		}
		
		TestAutok.kiir(tomb);
		double atlag = TestAutok.atlagEletkor(tomb);
		System.out.println("Az Újszerû autok atlagéletkora: "+atlag);
		
		TestAutok.autoSum(tomb);
		
		Hasznaltauto csere;
		  for ( int k = 0; k < tomb.length - 1; k++ )
		  {
		    for ( int j = k + 1; j < tomb.length; j++ )
		    {
		      if (tomb[k].getMarka().compareTo(tomb[j].getMarka()) >0)
		      {
		        csere = tomb[k];
		        tomb[k] = tomb[j];
		        tomb[j] = csere;
		      }
		    }
		  }
		  for ( Hasznaltauto k: tomb )
		  {
		    System.out.println(k.toString());
		  }
		}

	
	
	
	public static void autoSum(Hasznaltauto[] tomb) {
		String[] markak = new String[tomb.length];
		int markaDb = 0;
		
		for (int i = 0 ; i < tomb.length ; i++) {
			String marka = tomb[i].getMarka();
			boolean voltMar = false;
			for (int j = 0 ; j < markaDb ; j++) {
				if (markak[j].equals(marka)) {
					voltMar = true;
				}
			}
			
			if (!voltMar) {
				markak[markaDb] = marka;
				markaDb++;
			}
		}
		
		for (int j = 0 ; j < markaDb ; j++) {
			double sum = 0;
			for (int i = 0 ; i < tomb.length ; i++) {
				if (tomb[i].getMarka().equals(markak[j])) {
					sum += tomb[i].getEladasiar();
				}
			}
			System.out.println("A " + markak[j] + " tipusu autok ossz eladasi ara: " + sum);
		}
	}
	
	
	
	public static double atlagEletkor(Hasznaltauto[] tomb) {
		int db = 0;
		double sum = 0;
		
		for (int i = 0; i < tomb.length; i++) {
			if (tomb[i].getAllapota() == Allapota.UJSZERU) {
				db++;
				sum += tomb[i].getKor();
			}
		}
		
		if (db == 0) {
			return 0;
		}
		
		return sum / db;
	}
	
	public static void kiir(Auto[] autok) {
	for (int i=0; i < autok.length;i++) {
		System.out.println(autok[i]);
	}
	}
	//marka,tipus,1,Allapota.GARANCIALIS,"feher",km
	public static Hasznaltauto beOlvas() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Adja meg a markat");
		String marka =in.nextLine();
		
		System.out.println("Adja meg a Típusat ");
		String tipus =in.nextLine();
		
		int kora =0;
		do {
			System.out.println("Adja meg a korat!");
			kora =in.nextInt();
			if(kora < 1|| kora  > 20) {
				System.out.println("Hibas ertek a kor 1 es 20 között lehet");
				in.nextLine();
			}
		}while(kora < 1|| kora  > 20);
		in.nextLine();
		
		System.out.println("Adja meg az Állapotát pl garancialis");
		String allapotstr = in.nextLine().toUpperCase();
		Allapota allap = Allapota.valueOf(allapotstr);
		
		
		System.out.println("Adja meg a Szinet ");
		String szine = in.nextLine();
		
		//System.out.println("Adja meg a km ora allasat");
		
		int kmallas = 0;
		do {
			System.out.println("Adja meg a km allast!");
			kmallas =in.nextInt();
			if(kmallas < 0) {
				System.out.println("Hibas ertek a kor 1 es 20 között lehet");
			}
		}while(kmallas < 0);
		in.nextLine();
		Hasznaltauto autok = new Hasznaltauto(marka,tipus,kora,allap,szine,kmallas);
		
		
		
		return autok;
	}

}
