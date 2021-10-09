package prolab2.pkg1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Dusman extends Karakter {
	private int dusmanID;
	private String dusmanAdi;
	private String dusmanTur;
	static int minMesafe = 0;
         public static ArrayList<Integer> apsis1 = new ArrayList<Integer>();
	public  static ArrayList<Integer> ordinat1 = new ArrayList<Integer>();
	public Dusman() {
		dusmanID = 0;
		dusmanAdi = "Ad bilgisi yok";
		dusmanTur = "null";
		
	}
	
	public Dusman(int dusmanID, String dusmanAdi, String dusmanTur) {
		this.dusmanID = dusmanID;
		this.dusmanAdi = dusmanAdi;
		this.dusmanTur = dusmanTur;
	} 
        private static final int M = 11;
	private static final int N = 13;
	private static final int satir[] = { -1, 0, 0, 1 };
	private static final int sutun[] = { 0, -1, 1, 0 };
        
	private static boolean yolGecerliMi(int matris[][], boolean ziyaret[][], int satir, int sutun) {
		return (satir >= 0) && (satir < M) && (sutun>= 0) && (sutun < N) && matris[satir][sutun] == 1 && !ziyaret[satir][sutun];
	}
       
        @Override
	public void EnKisaYol(int matris[][], int i, int j, int x, int y) {
        
		
		boolean[][] ziyaret = new boolean[M][N];
		ziyaret[i][j] = true;
		
		Queue<Dugum> kuyruk = new ArrayDeque<>();
		kuyruk.add(new Dugum(i, j, 0, null));
		
		minMesafe = Integer.MAX_VALUE;
		Dugum dugum = null;
		
                
		while (!kuyruk.isEmpty()) {
			
                        
			dugum = kuyruk.poll();
			i = dugum.x;
			j = dugum.y;
			int mesafe = dugum.mesafe;
			
			if (i == x && j == y) {
				minMesafe = mesafe;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				
				if (yolGecerliMi(matris, ziyaret, i + satir[k], j + sutun[k])) {
				
					ziyaret[i + satir[k]][j + sutun[k]] = true;
					kuyruk.add(new Dugum(i + satir[k], j + sutun[k],mesafe + 1, dugum));
				}
			}
		}
		
		if (minMesafe != Integer.MAX_VALUE) {
			enKisaYoluYazdir(dugum);
		} 
		
	}
        
	
	private static void enKisaYoluYazdir(Dugum dugum) {
		if (dugum == null) {
			return;
		}
		apsis1.add(dugum.x);
		ordinat1.add(dugum.y);
		enKisaYoluYazdir(dugum.anaDugum);
		
		System.out.println(dugum);
		
		
	}
	public int getDusmanID() {
		return dusmanID;
	}
	
	public void setDusmanID(int dusmanID) {
		this.dusmanID = dusmanID;
	}
	
	public String getDusmanAdi() {
		return dusmanAdi;
	}
	
	public void setDusmanAdi(String dusmanAdi) {
		this.dusmanAdi = dusmanAdi;
	}
	
	public String getDusmanTur() {
		return dusmanTur;
	}
	
	public void setDusmanTur(String dusmanTur) {
		this.dusmanTur = dusmanTur;
	}
	
}
class Dugum {
        Dugum anaDugum;
	int  mesafe, x, y;
	public Dugum() {
		
	}
	public Dugum(int x, int y, int mesafe, Dugum anaDugum) {
		this.x = x;
		this.y = y;
		this.mesafe = mesafe;
		this.anaDugum = anaDugum;
	}
	
	
	@Override
	public String toString() {
		return "{" + x + ", " + y + '}';
	}
};
