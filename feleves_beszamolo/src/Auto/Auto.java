package Auto;

public class Auto {
	private static final long alapar = 5000000;
	private String marka;
	private String tipus;
	private int kor;
	
	public Auto(String marka, String tipus, int kor) {
		super();
		this.marka = marka;
		this.tipus = tipus;
		this.kor = kor;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public static long getAlapar() {
		return alapar;
	}

	@Override
	public String toString() {
		return "Auto [marka=" + marka + ", tipus=" + tipus + ", kor=" + kor + "]";
	}
	
	
	
	
}
