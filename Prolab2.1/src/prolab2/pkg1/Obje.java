package prolab2.pkg1;
public class Obje {
	int ObjePuani;
	private String ResimBilgisi;
	public Obje()
        {
            ObjePuani=0;
            ResimBilgisi="Belirtilmemiş";
        }
       public Obje(int ObjePuani,String ResimBilgisi)
       {
           this.ObjePuani=ObjePuani;
           this.ResimBilgisi=ResimBilgisi;
       }
	public String getResimBilgisi() {
		return ResimBilgisi;
	}
	
	public void setResimBilgisi(String ResimBilgisi) {
		this.ResimBilgisi = ResimBilgisi;
	}
}
