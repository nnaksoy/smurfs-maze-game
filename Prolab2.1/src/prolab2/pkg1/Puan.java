package prolab2.pkg1;
public class Puan extends Oyuncu {
	static String hangiSirin;
        Oyuncu tembelSirin=new TembelSirin();
         Oyuncu gozlukluSirin=new GozlukluSirin();
        public Puan()
        {
        tembelSirin.setSkor(20);
        gozlukluSirin.setSkor(20);
        }
        @Override
        public   void PuaniGoster(String hangiSirin,String hangiTur) {
             if(hangiSirin.contains("Tembel")){
                 if(hangiTur.contains("Gargamel"))
                     this.tembelSirin.setSkor(tembelSirin.getSkor()-15);
                 else if(hangiTur.contains("Azman"))
                     this.tembelSirin.setSkor(tembelSirin.getSkor()-5);
             }
             else  if(hangiSirin.contains("Gozluklu")){
                 if(hangiTur.contains("Gargamel"))
                    this.gozlukluSirin.setSkor(gozlukluSirin.getSkor()-15);
                 else if(hangiTur.contains("Azman"))
                   this.gozlukluSirin.setSkor(gozlukluSirin.getSkor()-5);
             }
             
         
		
	}
}
