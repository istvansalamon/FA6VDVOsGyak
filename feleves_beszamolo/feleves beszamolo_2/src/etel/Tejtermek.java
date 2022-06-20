package etel;

import java.time.LocalDateTime;

public class Tejtermek {
	private int egysegar;
	private String marka;
	private LocalDateTime gyartasiIdo;
	private LocalDateTime lejaratiIdo;
	
	public Tejtermek(int egysegar, String marka, LocalDateTime gyartasiIdo, LocalDateTime lejaratiIdo) {
		super();
		this.egysegar = egysegar;
		this.marka = marka;
		this.gyartasiIdo = gyartasiIdo;
		this.lejaratiIdo = lejaratiIdo;
		
		if(lejaratiIdo.isAfter(gyartasiIdo.plusDays(5)) &&
				lejaratiIdo.isBefore(gyartasiIdo.plusDays(90)))  {
			this.lejaratiIdo = lejaratiIdo;
		}else {
			this.lejaratiIdo = gyartasiIdo.plusDays(5);
		}
	}
	
	public final boolean ehetoE() {
		if (LocalDateTime.now().isBefore(lejaratiIdo)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return "Tejtermek [egysegar=" + egysegar + ", marka=" + marka + ", gyartasiIdo=" + gyartasiIdo
				+ ", lejaratiIdo=" + lejaratiIdo + "]";
	}

	public int getEgysegar() {
		return egysegar;
	}

	public void setEgysegar(int egysegar) {
		this.egysegar = egysegar;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public LocalDateTime getGyartasiIdo() {
		return gyartasiIdo;
	}

	public void setGyartasiIdo(LocalDateTime gyartasiIdo) {
		this.gyartasiIdo = gyartasiIdo;
	}

	public LocalDateTime getLejaratiIdo() {
		return lejaratiIdo;
	}

	public void setLejaratiIdo(LocalDateTime lejaratiIdo) {
		this.lejaratiIdo = lejaratiIdo;
	}
	
	
	
	
	

}
