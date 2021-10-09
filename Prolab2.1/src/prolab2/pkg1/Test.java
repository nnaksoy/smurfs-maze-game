package prolab2.pkg1;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Test extends JFrame implements KeyListener {

    int[][] matris = new int[11][13];
    static int kapi1x, kapi1y, kapi2x, kapi2y;
    static int gargamelUzaklik = 0;
    static int azmanUzaklik = 0;
    String okunan;
    Dusman dusman1 = new Dusman();
    Dusman dusman2 = new Dusman();
    String kapi1 = null, kapi2 = null;
    String x = null;

    static int[][] koordinatlar = {{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 6}, {1, 7}, {1, 8}, {1, 9}, {1, 10}, {1, 11}, {2, 1}, {2, 3}, {2, 4}, {2, 5}, {2, 6}, {2, 7}, {2, 8}, {2, 11}, {3, 1},
    {3, 2}, {3, 3}, {3, 4}, {3, 6}, {3, 8}, {3, 9}, {3, 11}, {4, 1}, {4, 3}, {4, 6}, {4, 8}, {4, 11}, {5, 1}, {5, 3}, {5, 4}, {5, 5}, {5, 6}, {5, 8}, {5, 10}, {5, 11}, {6, 1}, {6, 4}, {6, 5}, {6, 6},
    {6, 8}, {6, 9}, {6, 10}, {6, 11}, {7, 1}, {7, 3}, {7, 4}, {7, 5}, {7, 6}, {7, 7}, {7, 8}, {7, 9}, {7, 10}, {7, 11}, {8, 1}, {8, 3}, {8, 9}, {8, 10}, {8, 11}, {9, 1}, {9, 2}, {9, 3}, {9, 4},
    {9, 5}, {9, 6}, {9, 7}, {9, 8}, {9, 9}, {9, 10}, {9, 11}};
    static ArrayList<Integer> xkoordinati = new ArrayList<Integer>();
    static ArrayList<Integer> ykoordinati = new ArrayList<Integer>();

    public static void arraylist() {
        for (int i = 0; i < 73; i++) {
            xkoordinati.add(koordinatlar[i][0]);
            ykoordinati.add(koordinatlar[i][1]);
        }

    }

    Dusman dusman = new Dusman();
    int[][] kisayol = new int[dusman.apsis1.size()][2];
    Puan puanSinifi = new Puan();
    Oyuncu gozlukluSirin = new GozlukluSirin();
    Oyuncu tembelSirin = new TembelSirin();
    Dusman azman = new Azman();
    Dusman gargamel = new Gargamel();
    Obje altin = new Altin();
    Obje mantar = new Mantar();
    static String hangiSirin;
    JLabel puan = new JLabel();
    JLabel gargamelYaz = new JLabel();
    JLabel azmanYaz = new JLabel();
    int sayac1 = 0, sayac2 = 0;
    int mantarx, mantary, altinx1, altinx2, altinx3, altinx4, altinx5, 
            altiny1, altiny2, altiny3, altiny4, altiny5;

    public Test(String hangiSirin, String oyuncuAdi) {
        setTitle("ŞİRİNLER");
        setSize(1920, 1080);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        GozlukluSirin();
        TembelSirin();
        Gargamel();
        Azman();
        arraylist();

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.DARK_GRAY);
        Font font = new Font("Tahoma", Font.BOLD, 30);
        Font font2 = new Font("Tahoma", Font.BOLD, 50);
        Font font3 = new Font("Tahoma", Font.BOLD, 45);
        JLabel baslik = new JLabel("SKOR TABLOSU");
        baslik.setBounds(1400, 0, 500, 300);
        baslik.setFont(font3);
        baslik.setForeground(Color.pink);
        contentPane.add(baslik);
        baslik.setLayout(null);

        JLabel oyuncu = new JLabel(oyuncuAdi);
        oyuncu.setBounds(1300, 0, 500, 600);
        oyuncu.setFont(font2);
        oyuncu.setForeground(Color.magenta);
        contentPane.add(oyuncu);
        oyuncu.setLayout(null);

        puan.setBounds(1800, 0, 300, 600);
        puan.setFont(font2);
        puan.setForeground(Color.magenta);
        contentPane.add(puan);
        puan.setLayout(null);

        gargamelYaz.setBounds(1250, 0, 700, 1600);
        gargamelYaz.setFont(font);
        gargamelYaz.setForeground(Color.MAGENTA);
        contentPane.add(gargamelYaz);
        gargamelYaz.setLayout(null);

        azmanYaz.setBounds(1250, 0, 700, 1700);
        azmanYaz.setFont(font);
        azmanYaz.setForeground(Color.MAGENTA);
        contentPane.add(azmanYaz);
        azmanYaz.setLayout(null);

        JLabel uzaklikTablosu = new JLabel("UZAKLIK TABLOSU");
        uzaklikTablosu.setBounds(1350, 0, 500, 1300);
        uzaklikTablosu.setFont(font3);
        uzaklikTablosu.setForeground(Color.pink);
        contentPane.add(uzaklikTablosu);
        uzaklikTablosu.setLayout(null);

        if (hangiSirin.contains("Gozluklu")) {
            Test.hangiSirin = gozlukluSirin.getResimBilgisi();
            gozlukluSirin.getLokasyon().setX(5);
            gozlukluSirin.getLokasyon().setY(6);
        } else if (hangiSirin.contains("Tembel")) {
            Test.hangiSirin = tembelSirin.getResimBilgisi();
            tembelSirin.getLokasyon().setX(5);
            tembelSirin.getLokasyon().setY(6);
        }

        Runnable mantargoster = new Runnable() {
            public void run() {
                try {
                    while (true) {

                        int xrandom, yrandom;
                        Random rx= new Random();
                        Random ry = new Random();

                        xrandom = rx.nextInt(12);
                        yrandom = ry.nextInt(10);
                        while (matris[yrandom][xrandom] != 1) {
                            xrandom = rx.nextInt(12);
                            yrandom = ry.nextInt(10);
                        }
                        mantarx = xrandom;
                        mantary = yrandom;
                        Thread.sleep(6000);
                        sayac1 = 1;
                        repaint();
                        Thread.sleep(12000);
                        sayac1 = 0;
                        repaint();

                    }
                } catch (InterruptedException e) {

                }
            }

        };
        new Thread(mantargoster).start();

        Runnable altingoster = new Runnable() {
            public void run() {

                try {
                    while (true) {
                        int i1 = (int) (Math.random() * 72), i2 = (int) (Math.random() * 72), i3 = (int) (Math.random() * 72), i4 = (int) (Math.random() * 72), i5 = (int) (Math.random() * 72);
                        while (i2 == i1) {
                            i2 = (int) (Math.random() * 72);
                        }
                        while (i3 == i1 || i3 == i2) {
                            i3 = (int) (Math.random() * 72);
                        }
                        while (i4 == i1 || i4 == i2 || i4 == i3) {
                            i4 = (int) (Math.random() * 72);
                        }
                        while (i5 == i1 || i5 == i2 || i5 == i3 || i5 == i4) {
                            i5 = (int) (Math.random() * 72);
                        }
                        altiny1 = xkoordinati.get(i1);
                        altinx1 = ykoordinati.get(i1);
                       altiny2 = xkoordinati.get(i2);
                        altinx2 = ykoordinati.get(i2);
                        altiny3 = xkoordinati.get(i3);
                        altinx3 = ykoordinati.get(i3);
                        altiny4 = xkoordinati.get(i4);
                        altinx4 = ykoordinati.get(i4);
                        altiny5 = xkoordinati.get(i5);
                        altinx5 = ykoordinati.get(i5);

                        Thread.sleep(4000);
                        sayac2 = 1;
                        repaint();
                        Thread.sleep(7000);
                        sayac2 = 0;
                        repaint();

                    }
                } catch (InterruptedException e) {

                }
            }

        };
        new Thread(altingoster).start();

        try {
            FileReader dosyaOkuyucu = new FileReader(getClass().getResource("/prolab2/pkg1/harita.txt").getFile());
            BufferedReader okuyucu = new BufferedReader(dosyaOkuyucu);
            String satir;
            okunan = okuyucu.readLine();

            for (String dusmanx : okunan.split(",")) {

                x = dusmanx;
                break;
            }

            for (String hangiDusman : x.split(":")) {

                if (hangiDusman.contains("Gargamel") || hangiDusman.contains("gargamel") || hangiDusman.contains("Azman") || hangiDusman.contains("azman")) {
                    dusman1.setDusmanTur(hangiDusman);
                }

            }
            for (String dusmanx : okunan.split(" ")) {

                x = dusmanx;
                break;
            }
            for (String hangiKapi : x.split(":")) {

                if (hangiKapi.contains("A") || hangiKapi.contains("B") || hangiKapi.contains("C") || hangiKapi.contains("D")) {
                    kapi1 = hangiKapi;
                }

            }
            okunan = okuyucu.readLine();
            for (String dusmanx : okunan.split(",")) {

                x = dusmanx;
                break;
            }

            for (String hangiDusman : x.split(":")) {

                if (hangiDusman.contains("Gargamel") || hangiDusman.contains("gargamel") || hangiDusman.contains("Azman") || hangiDusman.contains("azman")) {
                    dusman2.setDusmanTur(hangiDusman);
                }

            }
            for (String dusmanx : okunan.split(" ")) {

                x = dusmanx;
                break;
            }
            for (String hangiKapi : x.split(":")) {

                if (hangiKapi.contains("A") || hangiKapi.contains("B") || hangiKapi.contains("C") || hangiKapi.contains("D")) {
                    kapi2 = hangiKapi;
                }

            }
            if (kapi2 != null && dusman2 != null) {
                okunan = okuyucu.readLine();
            }

            System.out.println(dusman1.getDusmanTur());
            System.out.println(kapi1);
            System.out.println(dusman2.getDusmanTur());
            System.out.println(kapi2);
            int k = 0, j = 0, i = 0;
            String[][] sayilar = new String[11][13];

            while (okunan != null) {

                for (String sayi : okunan.split("	")) {
                    if (sayi.contains("0") || sayi.contains("1")) {

                        sayilar[k][j] = sayi;

                        j++;
                    }
                }
                okunan = okuyucu.readLine();
                k = 1 + k;
                j = 0;

            }
            for (i = 0; i < 11; i++) {
                for (j = 0; j < 13; j++) {
                    if (sayilar[i][j].contains("0")) {
                        matris[i][j] = 0;
                    } else if (sayilar[i][j].contains("1")) {
                        matris[i][j] = 1;
                    }
                }
             
            }
            for (i = 0; i < 11; i++) {
                for (j = 0; j < 13; j++) {
                    System.out.print(matris[i][j] + " ");
                }
                System.out.println("");

            }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (kapi1.contains("A")) {
            kapi1x = 0;
            kapi1y = 3;
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    gargamel.getLokasyon().setX(0);
                    gargamel.getLokasyon().setY(3);
                    break;
                case "Azman":
                    azman.getLokasyon().setX(0);
                    azman.getLokasyon().setY(3);
            }
        } else if (kapi1.contains("B")) {
            kapi1x = 0;
            kapi1y = 10;
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    gargamel.getLokasyon().setX(0);
                    gargamel.getLokasyon().setY(10);
                    break;
                case "Azman":
                    azman.getLokasyon().setX(0);
                    azman.getLokasyon().setY(10);
            }
        } else if (kapi1.contains("C")) {
            kapi1x = 5;
            kapi1y = 0;
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    gargamel.getLokasyon().setX(5);
                    gargamel.getLokasyon().setY(0);
                    break;
                case "Azman":
                    azman.getLokasyon().setX(5);
                    azman.getLokasyon().setY(0);
            }
        } else if (kapi1.contains("D")) {
            kapi1x = 10;
            kapi1y = 3;
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    gargamel.getLokasyon().setX(10);
                    gargamel.getLokasyon().setY(3);
                    break;
                case "Azman":
                    azman.getLokasyon().setX(10);
                    azman.getLokasyon().setY(3);
            }
        }

        if (kapi2 != null) {
            if (kapi2.contains("A")) {
                kapi2x = 0;
                kapi2y = 3;
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        gargamel.getLokasyon().setX(0);
                        gargamel.getLokasyon().setY(3);
                        break;
                    case "Azman":
                        azman.getLokasyon().setX(0);
                        azman.getLokasyon().setY(3);
                }
            } else if (kapi2.contains("B")) {
                kapi2x = 0;
                kapi2y = 10;
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        gargamel.getLokasyon().setX(0);
                        gargamel.getLokasyon().setY(10);
                        break;
                    case "Azman":
                        azman.getLokasyon().setX(0);
                        azman.getLokasyon().setY(10);
                }
            } else if (kapi2.contains("C")) {
                kapi2x = 5;
                kapi2y = 0;
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        gargamel.getLokasyon().setX(5);
                        gargamel.getLokasyon().setY(0);
                        break;
                    case "Azman":
                        azman.getLokasyon().setX(5);
                        azman.getLokasyon().setY(0);
                }
            } else if (kapi2.contains("D")) {
                kapi2x = 10;
                kapi2y = 3;
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        gargamel.getLokasyon().setX(10);
                        gargamel.getLokasyon().setY(3);
                        break;
                    case "Azman":
                        azman.getLokasyon().setX(10);
                        azman.getLokasyon().setY(3);
                }
            }
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test("null", "null");
                test.setVisible(true);
            }
        });

    }

    public void Altin() {
        altin.setResimBilgisi(getClass().getResource("/img/Altin.jpg").getFile());
        altin.ObjePuani = 5;

    }

    public void Mantar() {
        mantar.setResimBilgisi(getClass().getResource("/img/Mantar.jpg").getFile());
        mantar.ObjePuani = 50;

    }

    public void GozlukluSirin() {
        gozlukluSirin.setResimBilgisi(getClass().getResource("/img/Gozluklu.jpg").getFile());
        gozlukluSirin.setKarakterTuru("Oyuncu");

    }

    public void TembelSirin() {
        tembelSirin.setResimBilgisi(getClass().getResource("/img/Tembel.jpg").getFile());
        tembelSirin.setKarakterTuru("Oyuncu");

    }

    public void Gargamel() {
        gargamel.setResimBilgisi(getClass().getResource("/img/Gargamel.jpg").getFile());
        gargamel.setKarakterTuru("Dusman");

    }

    public void Azman() {
        azman.setResimBilgisi(getClass().getResource("/img/Azman.jpg").getFile());
        azman.setKarakterTuru("Dusman");
    }

    @Override
    public void paint(Graphics g) {
        if (hangiSirin.contains("Gozluklu")) {
            puan.setText(String.valueOf(puanSinifi.gozlukluSirin.getSkor()));
        } else if (hangiSirin.contains("Tembel")) {
            puan.setText(String.valueOf(puanSinifi.tembelSirin.getSkor()));

        }
        if(dusman2.getDusmanTur()!="null"){
        azmanYaz.setText("Azmanın şirine en kısa yol uzaklığı: " + azmanUzaklik);
        gargamelYaz.setText("Gargamelin şirine en kısa  yol uzaklığı: " + gargamelUzaklik);}
        else if(dusman2.getDusmanTur()=="null" && dusman1.getDusmanTur().contains("Gargamel"))
        {
             gargamelYaz.setText("Gargamelin şirine en kısa  yol uzaklığı: " + gargamelUzaklik);}
        
    else if(dusman2.getDusmanTur()=="null" && dusman1.getDusmanTur().contains("Azman"))
    {
               azmanYaz.setText("Azmanın şirine en kısa yol uzaklığı: " + azmanUzaklik); 
    }
    
        Azman();
        Gargamel();
        Altin();
        Mantar();
        ImageIcon sirin = new ImageIcon(Test.hangiSirin);
        ImageIcon sirine = new ImageIcon(getClass().getResource("/img/sirine.jpg").getFile());
        ImageIcon azmanImg = new ImageIcon(azman.getResimBilgisi());
        ImageIcon gargamelImg = new ImageIcon(gargamel.getResimBilgisi());
        ImageIcon altinImg1 = new ImageIcon(altin.getResimBilgisi());
        ImageIcon altinImg2 = new ImageIcon(altin.getResimBilgisi());
        ImageIcon altinImg3 = new ImageIcon(altin.getResimBilgisi());
        ImageIcon altinImg4 = new ImageIcon(altin.getResimBilgisi());
        ImageIcon altinImg5 = new ImageIcon(altin.getResimBilgisi());
        ImageIcon mantarImg = new ImageIcon(mantar.getResimBilgisi());

        super.paint(g);

        g.translate(30, 50);
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[0].length; j++) {
                Color color;

                switch (matris[i][j]) {
                    case 1:
                        color = Color.WHITE;
                        break;
                    case 0:
                        color = Color.GRAY;
                        break;

                    default:
                        color = Color.BLUE;
                }
                if (i == 5 && j == 6) {
                    color = Color.BLUE;
                }
                if (i == 0 && j == 3) {
                    color = Color.ORANGE;
                }
                if (i == 0 && j == 10) {
                    color = Color.ORANGE;
                }
                if (i == 5 && j == 0) {
                    color = Color.ORANGE;
                }
                if (i == 10 && j == 3) {
                    color = Color.ORANGE;
                }
                g.setColor(color);
                g.fillRect(90 * j, 90 * i, 90, 90);
                g.setColor(Color.BLACK);
                g.drawRect(90 * j, 90 * i, 90, 90);
            }
          }

        for (int i = 0; i < dusman.apsis1.size(); i++) {
            Color color;
            color = Color.PINK;
            g.setColor(color);
            g.fillRect(90 * dusman.ordinat1.get(i), 90 * dusman.apsis1.get(i), 90, 90);
            g.setColor(Color.BLACK);
            g.drawRect(90 * dusman.ordinat1.get(i), 90 * dusman.apsis1.get(i), 90, 90);
         }
        dusman.apsis1.clear();
        dusman.ordinat1.clear();
        
        if (kapi1.contains("A")) {
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                    break;
                case "Azman":
                    g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
            }
        } else if (kapi1.contains("B")) {
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                    break;
                case "Azman":
                    g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
            }
        } else if (kapi1.contains("C")) {
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                    break;
                case "Azman":
                    g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
            }
        } else if (kapi1.contains("D")) {
            switch (dusman1.getDusmanTur()) {
                case "Gargamel":
                    g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                    break;
                case "Azman":
                    g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
            }
        }

        if (kapi2 != null) {
            if (kapi2.contains("A")) {
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                        break;
                    case "Azman":
                        g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
                }
            } else if (kapi2.contains("B")) {
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                        break;
                    case "Azman":
                        g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
                }
            } else if (kapi2.contains("C")) {
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                        break;
                    case "Azman":
                        g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
                }
            } else if (kapi2.contains("D")) {
                switch (dusman2.getDusmanTur()) {
                    case "Gargamel":
                        g.drawImage(gargamelImg.getImage(), gargamel.getLokasyon().getY() * 90, gargamel.getLokasyon().getX() * 90, 90, 90, null);
                        break;
                    case "Azman":
                        g.drawImage(azmanImg.getImage(), azman.getLokasyon().getY() * 90, azman.getLokasyon().getX() * 90, 90, 90, null);
                }
            }
        }

        g.drawImage(sirine.getImage(), 1170, 630, 90, 90, null);
        if (hangiSirin.contains("Tembel")) {
            g.drawImage(sirin.getImage(), tembelSirin.getLokasyon().getY() * 90, tembelSirin.getLokasyon().getX() * 90, 90, 90, null);
            
            if (dusman1.getDusmanTur().contains("Gargamel")) {
                dusman.EnKisaYol(matris, gargamel.getLokasyon().getX(), gargamel.getLokasyon().getY(), tembelSirin.getLokasyon().getX(), tembelSirin.getLokasyon().getY());
            } else if (dusman1.getDusmanTur().contains("Azman")) {
                dusman.EnKisaYol(matris, azman.getLokasyon().getX(), azman.getLokasyon().getY(), tembelSirin.getLokasyon().getX(), tembelSirin.getLokasyon().getY());
            }
            if (dusman2.getDusmanTur().contains("Gargamel") || dusman2.getDusmanTur().contains("Azman")) {
                if (dusman2.getDusmanTur().contains("Gargamel")) {
                    dusman.EnKisaYol(matris, gargamel.getLokasyon().getX(), gargamel.getLokasyon().getY(), tembelSirin.getLokasyon().getX(), tembelSirin.getLokasyon().getY());
                } else if (dusman2.getDusmanTur().contains("Azman")) {
                    dusman.EnKisaYol(matris, azman.getLokasyon().getX(), azman.getLokasyon().getY(), tembelSirin.getLokasyon().getX(), tembelSirin.getLokasyon().getY());
                }

            }

        } else if (hangiSirin.contains("Gozluklu")) {

            g.drawImage(sirin.getImage(), gozlukluSirin.getLokasyon().getY() * 90, gozlukluSirin.getLokasyon().getX() * 90, 90, 90, null);
            if (dusman1.getDusmanTur().contains("Gargamel")) {
                dusman.EnKisaYol(matris, gargamel.getLokasyon().getX(), gargamel.getLokasyon().getY(), gozlukluSirin.getLokasyon().getX(), gozlukluSirin.getLokasyon().getY());
            } else if (dusman1.getDusmanTur().contains("Azman")) {
                dusman.EnKisaYol(matris, azman.getLokasyon().getX(), azman.getLokasyon().getY(), gozlukluSirin.getLokasyon().getX(), gozlukluSirin.getLokasyon().getY());
            }
            if (dusman2.getDusmanTur().contains("Gargamel") || dusman2.getDusmanTur().contains("Azman")) {
                if (dusman2.getDusmanTur().contains("Gargamel")) {
                    dusman.EnKisaYol(matris, gargamel.getLokasyon().getX(), gargamel.getLokasyon().getY(), gozlukluSirin.getLokasyon().getX(), gozlukluSirin.getLokasyon().getY());
                } else if (dusman2.getDusmanTur().contains("Azman")) {
                    dusman.EnKisaYol(matris, azman.getLokasyon().getX(), azman.getLokasyon().getY(), gozlukluSirin.getLokasyon().getX(), gozlukluSirin.getLokasyon().getY());
                }

            }
            
        }

        if (sayac1 == 0) {
            if (hangiSirin.contains("Tembel")) {
                g.drawImage(mantarImg.getImage(), mantarx * 90, mantary * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == mantarx && tembelSirin.getLokasyon().getX() == mantary) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + mantar.ObjePuani);
                    mantarx = 13;
                    mantary = 0;
                }
            }
           if (hangiSirin.contains("Gozluklu")) {
                g.drawImage(mantarImg.getImage(), mantarx * 90,  mantary * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == mantarx && gozlukluSirin.getLokasyon().getX() ==  mantary ) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                    mantarx = 12;
                     mantary = 0;
                }
            }
        }

        if (sayac2 == 0) {
            if (hangiSirin.contains("Tembel")) {

                g.drawImage(altinImg1.getImage(), altinx1 * 90, altiny1 * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == altinx1 && tembelSirin.getLokasyon().getX() == altiny1) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + altin.ObjePuani);

                    altinx1 = 13;
                   altiny1 = 0;
                }
                g.drawImage(altinImg2.getImage(), altinx2 * 90, altiny2 * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == altinx2 && tembelSirin.getLokasyon().getX() == altiny2) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + altin.ObjePuani);
                    altinx2 = 13;
                    altiny2 = 0;
                }
                g.drawImage(altinImg3.getImage(), altinx3 * 90, altiny3 * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == altinx3 && tembelSirin.getLokasyon().getX() == altiny3) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + altin.ObjePuani);
                    altinx3 = 13;
                    altiny3 = 0;
                }
                g.drawImage(altinImg4.getImage(), altinx4 * 90, altiny4 * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == altinx4 && tembelSirin.getLokasyon().getX() == altiny4) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + altin.ObjePuani);
                    altinx4 = 13;
                    altiny4 = 0;
                }
                g.drawImage(altinImg5.getImage(), altinx5 * 90, altiny5 * 90, 60, 60, null);
                if (tembelSirin.getLokasyon().getY() == altinx5 && tembelSirin.getLokasyon().getX() == altiny5) {
                    puanSinifi.tembelSirin.setSkor(puanSinifi.tembelSirin.getSkor() + altin.ObjePuani);
                    altinx5 = 13;
                    altiny5 = 0;
                }

            }
           if (hangiSirin.contains("Gozluklu")) {

                g.drawImage(altinImg1.getImage(), altinx1 * 90, altiny1 * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == altinx1 && gozlukluSirin.getLokasyon().getX() == altiny1 ) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + altin.ObjePuani);
                    altinx1 = 12;
                    altiny1 = 0;

                }
                g.drawImage(altinImg2.getImage(), altinx2 * 90, altiny2 * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == altinx2 && gozlukluSirin.getLokasyon().getX() == altiny2 ) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + altin.ObjePuani);
                    altinx2 = 12;
                    altiny2 = 0;

                }
                g.drawImage(altinImg3.getImage(), altinx3 * 90, altiny3 * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == altinx3 && gozlukluSirin.getLokasyon().getX() == altiny3 ) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + altin.ObjePuani);
                    altinx3 = 12;
                    altiny3 = 0;

                }
                g.drawImage(altinImg4.getImage(), altinx4 * 90, altiny4 * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == altinx4 && gozlukluSirin.getLokasyon().getX() == altiny4) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + altin.ObjePuani);
                    altinx4 = 12;
                    altiny4 = 0;

                }
                g.drawImage(altinImg5.getImage(), altinx5 * 90, altiny5 * 90, 60, 60, null);
                if (gozlukluSirin.getLokasyon().getY() == altinx5 && gozlukluSirin.getLokasyon().getX() == altiny5) {
                    puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + altin.ObjePuani);
                     altinx5 = 12;
                    altiny5 = 0;

                }
            }

        }
        if (hangiSirin.contains("Tembel")) {
            if (puanSinifi.tembelSirin.getSkor() <= 0) {
                Kaybettiniz kaybettiniz = new Kaybettiniz(puanSinifi.tembelSirin.getSkor());

                kaybettiniz.setVisible(true);
                this.setVisible(false);
                puanSinifi.tembelSirin.setSkor(20);

            }
        } else if (hangiSirin.contains("Gozluklu")) {
            if (puanSinifi.gozlukluSirin.getSkor() <= 0) {
                Kaybettiniz kaybettiniz = new Kaybettiniz(puanSinifi.gozlukluSirin.getSkor());

                kaybettiniz.setVisible(true);
                this.setVisible(false);
                puanSinifi.gozlukluSirin.setSkor(20);

            }
        }
        if (hangiSirin.contains("Tembel")) {
            if (tembelSirin.getLokasyon().getY() == 12 && tembelSirin.getLokasyon().getX() == 7 && puanSinifi.tembelSirin.getSkor() > 0) {
                Kazandiniz kazandiniz = new Kazandiniz(puanSinifi.tembelSirin.getSkor());
                kazandiniz.setVisible(true);
                this.setVisible(false);
                puanSinifi.tembelSirin.setSkor(20);

            }
        } else if (hangiSirin.contains("Gozluklu")) {
            if (this.gozlukluSirin.getLokasyon().getY() == 12 && this.gozlukluSirin.getLokasyon().getX() == 7 && puanSinifi.gozlukluSirin.getSkor() > 0) {
                Kazandiniz kazandiniz = new Kazandiniz(puanSinifi.gozlukluSirin.getSkor());
                kazandiniz.setVisible(true);
                this.setVisible(false);
                puanSinifi.gozlukluSirin.setSkor(20);

            }
        }
       if(dusman1.getDusmanTur().contains("Gargamel") && dusman2.getDusmanTur().contains("Azman")){
      gargamelUzaklik = dusman.apsis1.size() - dusman.minMesafe - 2; 
      azmanUzaklik = dusman.minMesafe ;
       }
       else if(dusman1.getDusmanTur().contains("Azman") && dusman2.getDusmanTur().contains("Gargamel"))
       {  azmanUzaklik = dusman.apsis1.size() - dusman.minMesafe  - 2;  
         gargamelUzaklik = dusman.minMesafe ;
   
       }else if(dusman2.getDusmanTur()=="null" && dusman1.getDusmanTur().contains("Gargamel"))
       {
           gargamelUzaklik = dusman.minMesafe ;
       }else if(dusman2.getDusmanTur()=="null" && dusman1.getDusmanTur().contains("Azman"))
       {
         azmanUzaklik = dusman.minMesafe ; 
       }
        
      
    }
  public void processKeyEvent(KeyEvent e) {

      if (hangiSirin.contains("Tembel")) {
			if ((e.getID() != KeyEvent.KEY_PRESSED)) {
				return;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                           
                           
				if (matris[tembelSirin.getLokasyon().getX()][tembelSirin.getLokasyon().getY() + 1] == 1) {
					 if(dusman2.getDusmanTur()!="null"){
				  if(dusman1.getDusmanTur().contains("Gargamel")) {	
                                    if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()+1) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));
						
					}
                                  }
                                  else if(dusman2.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 3) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  3) == tembelSirin.getLokasyon().getY()+1) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} 
                                        else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()+1) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} 
                                        else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                  
                                  
					tembelSirin.getLokasyon().setY(tembelSirin.getLokasyon().getY() + 1);
					if(dusman2.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                        else if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
					
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)));
						
					}
                                        }
					
                                        if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                        else if(dusman2.getDusmanTur().contains("Gargamel"))
                                        {
                                          if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        }
                                        
				}
                             else{
                                             if(dusman1.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()+1) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                 tembelSirin.getLokasyon().setY(tembelSirin.getLokasyon().getY() + 1);
                                 if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                 if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                      
                            }
                            
                                
                            }
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (matris[tembelSirin.getLokasyon().getX()][tembelSirin.getLokasyon().getY() - 1] == 1) {
					if(dusman2.getDusmanTur()!="null"){
				  if(dusman1.getDusmanTur().contains("Gargamel")) {	
                                    if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()-1) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					
					} else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));
						
					}
                                  }
                                  else if(dusman2.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 3) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  3) == tembelSirin.getLokasyon().getY()-1) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()-1) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                  
                                  
					tembelSirin.getLokasyon().setY(tembelSirin.getLokasyon().getY() - 1);
					if(dusman2.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                        else if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)));
						
					}
                                        }
					
                                        if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                        else if(dusman2.getDusmanTur().contains("Gargamel"))
                                        {
                                          if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        }
                                        } 
                                        else{
                                            if(dusman1.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()-1) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                 tembelSirin.getLokasyon().setY(tembelSirin.getLokasyon().getY() - 1);
                                 if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                 if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                        }
				}
				
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                            
				if (matris[tembelSirin.getLokasyon().getX() + 1][tembelSirin.getLokasyon().getY() ] == 1) {
					if(dusman2.getDusmanTur()!="null"){
				  if(dusman1.getDusmanTur().contains("Gargamel") && dusman2!=null) {	
                                    if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == tembelSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 4)));
						
					}
                                  }
                                  else if(dusman2.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 3) == tembelSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() -  3) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                  
                                  
					tembelSirin.getLokasyon().setX(tembelSirin.getLokasyon().getX() + 1);
					if(dusman2.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                        else if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
					
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)));
						
					}
                                        }
					
                                        if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					
					}
                                        }
                                        else if(dusman2.getDusmanTur().contains("Gargamel"))
                                        {
                                          if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        }
                                        
				}
                            
                            else {
                                 if(dusman1.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                 tembelSirin.getLokasyon().setX(tembelSirin.getLokasyon().getX() + 1);
                                 if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                 if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
						  puanSinifi.PuaniGoster("Tembel", "Gargamel");
					}
                                        }
                                 
                                 
                                
                            }
                                }
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (matris[tembelSirin.getLokasyon().getX()-1][tembelSirin.getLokasyon().getY() ] == 1) {
					if(dusman2.getDusmanTur()!="null")
                                        {
				  if(dusman1.getDusmanTur().contains("Gargamel")) {	
                                    if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));
						
					}
                                  }
                                  else if(dusman2.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 3) == tembelSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() -  3) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} 
                                        else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                  
                                  
					tembelSirin.getLokasyon().setX(tembelSirin.getLokasyon().getX() - 1);
					if(dusman2.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi2x);
						azman.getLokasyon().setY(kapi2y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                        else if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size()  - (dusman.minMesafe  + 3)) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)));
						
					}
                                        }
					
                                        if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                        else if(dusman2.getDusmanTur().contains("Gargamel"))
                                        {
                                          if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi2x);
						gargamel.getLokasyon().setY(kapi2y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}  
                                        }
                                        
				}
                                        else{
                                            if(dusman1.getDusmanTur().contains("Gargamel"))
                                  {
                                           if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() -  2) == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					} else {
						gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
						gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));
						
					}
                                  }
                                 tembelSirin.getLokasyon().setX(tembelSirin.getLokasyon().getX() - 1);
                                 if(dusman1.getDusmanTur().contains("Azman")){
                                        if (dusman.apsis1.get(dusman.apsis1.size() - 2) == tembelSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
                                                
						
					} else if (azman.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && azman.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						azman.getLokasyon().setX(kapi1x);
						azman.getLokasyon().setY(kapi1y);
                                                 puanSinifi.PuaniGoster("Tembel", "Azman");
						
					} else {
						azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
						azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
						
					}
                                        }
                                 if(dusman1.getDusmanTur().contains("Gargamel")){
					if (gargamel.getLokasyon().getX() == tembelSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == tembelSirin.getLokasyon().getY()) {
						gargamel.getLokasyon().setX(kapi1x);
						gargamel.getLokasyon().setY(kapi1y);
                                                  puanSinifi.PuaniGoster("Tembel", "Gargamel");
						
					}
                                        }
                                        }
                                }
				
			}
                        
                        
			repaint();
		}
       else if (hangiSirin.contains("Gozluklu")) {
            if ((e.getID() != KeyEvent.KEY_PRESSED)) {
                return;
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (matris[gozlukluSirin.getLokasyon().getX()][gozlukluSirin.getLokasyon().getY() + 1] == 1 && matris[gozlukluSirin.getLokasyon().getX()][gozlukluSirin.getLokasyon().getY() + 2] == 1) {
                   if(dusman2.getDusmanTur()!="null"){
                    if(dusman1.getDusmanTur().contains("Gargamel") ){
                       if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 2)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 2)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getY() + 2) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() + 1) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
                        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));

                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel") )
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() + 2) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() + 1) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
		        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
              gozlukluSirin.getLokasyon().setY(gozlukluSirin.getLokasyon().getY() + 2);
              if (gozlukluSirin.getLokasyon().getY()-1 == altinx1 && gozlukluSirin.getLokasyon().getX() == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx2 && gozlukluSirin.getLokasyon().getX() == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY()-1 == altinx3 && gozlukluSirin.getLokasyon().getX() == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx4 && gozlukluSirin.getLokasyon().getX() == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx5 && gozlukluSirin.getLokasyon().getX() == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                             
                              if (gozlukluSirin.getLokasyon().getY()-1 == mantarx && gozlukluSirin.getLokasyon().getX() ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
              if(dusman2.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() - 1) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              }  
              if(dusman1.getDusmanTur().contains("Azman"))
              {
                  if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY()+1 == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
		        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
                    }
              }
             
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                    
                   }
                   else{
                          if(dusman1.getDusmanTur().contains("Gargamel") )
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() + 2) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() + 1) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
		        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
                       gozlukluSirin.getLokasyon().setY(gozlukluSirin.getLokasyon().getY() + 2);
                       if (gozlukluSirin.getLokasyon().getY()-1 == altinx1 && gozlukluSirin.getLokasyon().getX() == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx2 && gozlukluSirin.getLokasyon().getX() == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY()-1 == altinx3 && gozlukluSirin.getLokasyon().getX() == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx4 && gozlukluSirin.getLokasyon().getX() == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()-1 == altinx5 && gozlukluSirin.getLokasyon().getX() == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                if (gozlukluSirin.getLokasyon().getY()-1 == mantarx && gozlukluSirin.getLokasyon().getX() ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
                                       if(dusman1.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                        
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() - 1) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              } 
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                          
                   }
                }

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (matris[gozlukluSirin.getLokasyon().getX()][gozlukluSirin.getLokasyon().getY() - 1] == 1 && matris[gozlukluSirin.getLokasyon().getX()][gozlukluSirin.getLokasyon().getY() - 2] == 1) {
                   if(dusman2.getDusmanTur()!="null"){
                   if(dusman1.getDusmanTur().contains("Gargamel")){
                       if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 2)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 2)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() - 2) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() - 1) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
                        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));

                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() - 2) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() - 1) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    }else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
			gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
              gozlukluSirin.getLokasyon().setY(gozlukluSirin.getLokasyon().getY() - 2);
              if (gozlukluSirin.getLokasyon().getY()+1 == altinx1 && gozlukluSirin.getLokasyon().getX() == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx2 && gozlukluSirin.getLokasyon().getX() == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY()+1 == altinx3 && gozlukluSirin.getLokasyon().getX() == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx4 && gozlukluSirin.getLokasyon().getX() == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx5 && gozlukluSirin.getLokasyon().getX() == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                if (gozlukluSirin.getLokasyon().getY()+1 == mantarx && gozlukluSirin.getLokasyon().getX() ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
              if(dusman2.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() + 1) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              }  
              if(dusman1.getDusmanTur().contains("Azman"))
              {
                  if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY()-1 == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Azman");
                    } else {
                       azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
		       azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
                    }
              }
             
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   }
                   else{
                               if(dusman1.getDusmanTur().contains("Gargamel") )
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() - 2) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() - 1) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
		        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
                       gozlukluSirin.getLokasyon().setY(gozlukluSirin.getLokasyon().getY() - 2);
                       if (gozlukluSirin.getLokasyon().getY()+1 == altinx1 && gozlukluSirin.getLokasyon().getX() == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx2 && gozlukluSirin.getLokasyon().getX() == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY()+1 == altinx3 && gozlukluSirin.getLokasyon().getX() == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx4 && gozlukluSirin.getLokasyon().getX() == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY()+1 == altinx5 && gozlukluSirin.getLokasyon().getX() == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                 if (gozlukluSirin.getLokasyon().getY()+1 == mantarx && gozlukluSirin.getLokasyon().getX() ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
                                       if(dusman1.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() + 1) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              } 
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   }
                }

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (matris[gozlukluSirin.getLokasyon().getX() + 1][gozlukluSirin.getLokasyon().getY()] == 1 && matris[gozlukluSirin.getLokasyon().getX() + 2][gozlukluSirin.getLokasyon().getY()] == 1) {
                   if(dusman2.getDusmanTur()!="null"){
                    if(dusman1.getDusmanTur().contains("Gargamel")){
                       if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 2)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 2)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX()+2 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
                        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));

                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()+2 &&dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
                        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
              gozlukluSirin.getLokasyon().setX(gozlukluSirin.getLokasyon().getX() + 2);
              if (gozlukluSirin.getLokasyon().getY() == altinx1 && gozlukluSirin.getLokasyon().getX()-1 == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx2 && gozlukluSirin.getLokasyon().getX()-1 == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY() == altinx3 && gozlukluSirin.getLokasyon().getX()-1 == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx4 && gozlukluSirin.getLokasyon().getX()-1 == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx5 && gozlukluSirin.getLokasyon().getX()-1 == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                 if (gozlukluSirin.getLokasyon().getY() == mantarx && gozlukluSirin.getLokasyon().getX()-1 ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
              if(dusman2.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX()-1 && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              }  
              if(dusman1.getDusmanTur().contains("Azman"))
              {
                  if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX()+1 == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
			azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
                    }
              }
             
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   }
                   else{
                               if(dusman1.getDusmanTur().contains("Gargamel") )
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()+2 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()+1 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
		        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
                       gozlukluSirin.getLokasyon().setX(gozlukluSirin.getLokasyon().getX() + 2);
                         if (gozlukluSirin.getLokasyon().getY() == altinx1 && gozlukluSirin.getLokasyon().getX()-1 == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx2 && gozlukluSirin.getLokasyon().getX()-1 == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY() == altinx3 && gozlukluSirin.getLokasyon().getX()-1 == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx4 && gozlukluSirin.getLokasyon().getX()-1 == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx5 && gozlukluSirin.getLokasyon().getX()-1 == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                if (gozlukluSirin.getLokasyon().getY() == mantarx && gozlukluSirin.getLokasyon().getX()-1 ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
                                       if(dusman1.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX()-1 && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              } 
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   } 
                }

            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (matris[gozlukluSirin.getLokasyon().getX() - 1][gozlukluSirin.getLokasyon().getY()] == 1 && matris[gozlukluSirin.getLokasyon().getX() - 2][gozlukluSirin.getLokasyon().getY()] == 1) {
                  if(dusman2.getDusmanTur()!="null"){
                  if(dusman1.getDusmanTur().contains("Gargamel")){
                       if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 2)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 2)) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX()-2 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe + 3)) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 4)));
                        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - (dusman.minMesafe  + 4)));

                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2)== gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                     puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2)== gozlukluSirin.getLokasyon().getX()-2 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                       
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
			gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
              gozlukluSirin.getLokasyon().setX(gozlukluSirin.getLokasyon().getX() - 2);
                if (gozlukluSirin.getLokasyon().getY() == altinx1 && gozlukluSirin.getLokasyon().getX()+1 == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx2 && gozlukluSirin.getLokasyon().getX()+1 == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY() == altinx3 && gozlukluSirin.getLokasyon().getX()+1 == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx4 && gozlukluSirin.getLokasyon().getX()+1 == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx5 && gozlukluSirin.getLokasyon().getX()+1 == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                if (gozlukluSirin.getLokasyon().getY() == mantarx && gozlukluSirin.getLokasyon().getX()+1 ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
              if(dusman2.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX()+1 && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi2x);
                        azman.getLokasyon().setY(kapi2y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              }  
              if(dusman1.getDusmanTur().contains("Azman"))
              {
                  if (dusman.apsis1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.apsis1.size() - (dusman.minMesafe  + 3)) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX()-1 == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size()  - (dusman.minMesafe  + 3)));
			azman.getLokasyon().setY(dusman.ordinat1.get(dusman.apsis1.size()  - (dusman.minMesafe + 3)));
                    }
              }
             
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                   if(dusman2.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi2x);
                        gargamel.getLokasyon().setY(kapi2y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    
                    }
                   }
                  }
                  else{
                                 if(dusman1.getDusmanTur().contains("Gargamel") )
                   {
                      if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        

                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 1) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 1) == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                     
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()-2 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                       puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    } else if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX()-1 && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY() ) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                        puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                        
                    } else {
                        gargamel.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 3));
		        gargamel.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 3));

                    } 
                   }
                       gozlukluSirin.getLokasyon().setX(gozlukluSirin.getLokasyon().getX() - 2);
                        if (gozlukluSirin.getLokasyon().getY() == altinx1 && gozlukluSirin.getLokasyon().getX()+1 == altiny1) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx1 = 12;
					altiny1 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx2 && gozlukluSirin.getLokasyon().getX()+1 == altiny2) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx2 = 12;
					altiny2 = 0;
					
				}

				if (gozlukluSirin.getLokasyon().getY() == altinx3 && gozlukluSirin.getLokasyon().getX()+1 == altiny3 ) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx3 = 12;
					altiny3 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx4 && gozlukluSirin.getLokasyon().getX()+1 == altiny4) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
					altinx4 = 12;
					altiny4 = 0;
					
				}
				
				if (gozlukluSirin.getLokasyon().getY() == altinx5 && gozlukluSirin.getLokasyon().getX()+1 == altiny5) {
					puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor()+altin.ObjePuani);
                                      
					altinx5 = 12;
					altiny5 = 0;
					
				}
                                if (gozlukluSirin.getLokasyon().getY() == mantarx && gozlukluSirin.getLokasyon().getX()+1 ==  mantary ) {
                               puanSinifi.gozlukluSirin.setSkor(puanSinifi.gozlukluSirin.getSkor() + mantar.ObjePuani);
                                       mantarx = 12;
                                        mantary = 0;
                                           }
                                       if(dusman1.getDusmanTur().contains("Azman")){
                   if (dusman.apsis1.get(dusman.apsis1.size() - 2) == gozlukluSirin.getLokasyon().getX() && dusman.ordinat1.get(dusman.ordinat1.size() - 2) == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX()+1 && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY() ) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                      
                    } else if (azman.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && azman.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        azman.getLokasyon().setX(kapi1x);
                        azman.getLokasyon().setY(kapi1y);
                         puanSinifi.PuaniGoster("Gozluklu", "Azman");
                       
                    } else {
                        azman.getLokasyon().setX(dusman.apsis1.get(dusman.apsis1.size() - 2));
                        azman.getLokasyon().setY(dusman.ordinat1.get(dusman.ordinat1.size() - 2));
                    }
              } 
                   if(dusman1.getDusmanTur().contains("Gargamel"))
                   {
                       if (gargamel.getLokasyon().getX() == gozlukluSirin.getLokasyon().getX() && gargamel.getLokasyon().getY() == gozlukluSirin.getLokasyon().getY()) {
                        gargamel.getLokasyon().setX(kapi1x);
                        gargamel.getLokasyon().setY(kapi1y);
                    puanSinifi.PuaniGoster("Gozluklu", "Gargamel");
                    }
                   } 
                  }
                }

            }
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose Tools | Templates.
    }

}
