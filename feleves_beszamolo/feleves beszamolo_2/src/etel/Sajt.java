package etel;

import java.time.LocalDateTime;

public class Sajt extends Tejtermek{
public enum Tipus{DARABOLT,SZELETELT,OMLESZTEETT}
	
	private int eladasiar;
	private double tomeg;
	private Tipus tipus;
	private double zsirtartalom;
	
	public Sajt(int egysegar, String marka, LocalDateTime gyartasiIdo, LocalDateTime lejaratiIdo, double tomeg, Tipus tipus,
			double zsirtartalom) {
		super(egysegar, marka, gyartasiIdo, lejaratiIdo);
		this.tomeg = tomeg;
		this.tipus = tipus;
		this.zsirtartalom = zsirtartalom;
		double temp =egysegar*tomeg*(zsirtartalom/21);
		if(tipus ==Tipus.DARABOLT) {
			temp=temp*1;
		}else if(tipus == Tipus.SZELETELT) {
			temp=temp*1.2;
		}else if(tipus == Tipus.OMLESZTEETT) {
			temp=temp*1.4;
		}
		this.eladasiar = (int)Math.round(temp);
		
		
	}

	public Sajt(int egysegar, String marka, LocalDateTime gyartasiIdo,LocalDateTime lejaratiIdo,  double tomeg,
			Tipus tipus) {
		this(egysegar,marka,gyartasiIdo,gyartasiIdo,tomeg,tipus,21);
		
	}
	
	
	
	public static Sajt olcsobbSajt(Sajt s1,Sajt s2) {
	if(s1.getEladasiar()>s2.getEladasiar()) {
		return s2;
	}else if (s1.getEladasiar()<s2.getEladasiar()) {
		return s1;
	}else {
		return s1;
	}
	}

	public int getEladasiar() {
		return eladasiar;
	}

	public void setEladasiar(int eladasiar) {
		this.eladasiar = eladasiar;
	}

	public double getTomeg() {
		return tomeg;
	}

	public void setTomeg(double tomeg) {
		this.tomeg = tomeg;
	}

	public Tipus getTipus() {
		return tipus;
	}

	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}

	public double getZsirtartalom() {
		return zsirtartalom;
	}

	public void setZsirtartalom(double zsirtartalom) {
		this.zsirtartalom = zsirtartalom;
	}

	@Override
	public String toString() {
		return "Sajt [eladasiar=" + eladasiar + ", tomeg=" + tomeg + ", tipus=" + tipus + ", zsirtartalom="
				+ zsirtartalom +super.toString()+ "]";
	}
	
	
	
	
}
