package Auto;

public class Hasznaltauto extends Auto {
public enum Allapota {UJSZERU,SZERVIZELT,GARANCIALIS}
	private Allapota allapota;
	private String szin;
	private int km;
	private double eladasiar;
	
	public Hasznaltauto(String marka, String tipus, int kor, Allapota allapota, String szin, int km) {
		super(marka, tipus, kor);
		this.allapota = allapota;
		this.szin = szin;
		this.km = km;
		
		double temp =(getAlapar()*kor);
		
		if(allapota==Allapota.UJSZERU) {
		temp=temp *0.05;	
		}else {
			temp = temp * 0.01;
		}
		
		eladasiar =getAlapar() - (int)Math.round(temp);
		this.eladasiar = eladasiar;
	}

	public Hasznaltauto(String marka, String tipus, int km) {
		this(marka,tipus,1,Allapota.GARANCIALIS,"feher",km);
		
	}
	
	public static boolean olcsobbE(Hasznaltauto a1,Hasznaltauto a2) {
		if(a1.getEladasiar()<a2.getEladasiar()) {
			return true;
		}else {
			return false;
		}
	}

	public Allapota getAllapota() {
		return allapota;
	}

	public void setAllapota(Allapota allapota) {
		this.allapota = allapota;
	}

	public String getSzin() {
		return szin;
	}

	public void setSzin(String szin) {
		this.szin = szin;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public double getEladasiar() {
		return eladasiar;
	}

	public void setEladasiar(double eladasiar) {
		this.eladasiar = eladasiar;
	}

	@Override
	public String toString() {
		return "Hasznaltauto [allapota=" + allapota + ", szin=" + szin + ", km=" + km + ", eladasiar=" + eladasiar
				+super.toString()+ "]";
	}
	
	
	
	
}