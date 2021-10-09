package prolab2.pkg1;
public class Oyuncu extends Karakter {
	private int oyuncuID;
	private String oyuncuAdi;
	private String oyuncuTur;
	private int Skor;
	
	public Oyuncu() {
		oyuncuID = 0;
		oyuncuAdi = "Ad bilgisi yok";
		oyuncuTur = "Tür belirtilmemiş";
		
	}
	
	public Oyuncu(int oyuncuID, String oyuncuAdi, String oyuncuTur) {
		super();
		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
		this.oyuncuTur = oyuncuTur;
	}
	
	public void PuaniGoster(String hangiSirin,String hangiTur) {
		
	}
	
	public int getOyuncuID() {
		return oyuncuID;
	}
	
	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}
	
	public String getOyuncuAdi() {
		return oyuncuAdi;
	}
	
	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}
	
	public String getOyuncuTur() {
		return oyuncuTur;
	}
	
	public void setOyuncuTur(String oyuncuTur) {
		this.oyuncuTur = oyuncuTur;
	}
	
	public int getSkor() {
		return Skor;
	}
	
	public void setSkor(int Skor) {
		this.Skor = Skor;
	}
	
}
