package prolab2.pkg1;
public abstract class Karakter {
	
	private int ID;
	private String ad;
	private String karakterTuru;
	
	private String ResimBilgisi;
	
	private Lokasyon lokasyon = new Lokasyon();
	
	public Karakter() {
		ID = 0;
		ad = "Ad bilgisi yok";
		karakterTuru = "Tür belirtilmemiş";
	}
	
	public Karakter(int ID, String ad, String karakterTuru) {
		this.ID = ID;
		this.ad = ad;
		this.karakterTuru = karakterTuru;
	}
	
	public void EnKisaYol(int mat[][], int i, int j, int x, int y) {
		
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getKarakterTuru() {
		return karakterTuru;
	}
	
	public void setKarakterTuru(String karakterTuru) {
		this.karakterTuru = karakterTuru;
	}
	
	public String getResimBilgisi() {
		return ResimBilgisi;
	}
	
	public void setResimBilgisi(String ResimBilgisi) {
		this.ResimBilgisi = ResimBilgisi;
	}

	public Lokasyon getLokasyon() {
		return lokasyon;
	}

	public void setLokasyon(Lokasyon lokasyon) {
		this.lokasyon = lokasyon;
	}
	
}