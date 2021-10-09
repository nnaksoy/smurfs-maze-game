
package prolab2.pkg1;

public class AnaMenu extends javax.swing.JFrame {
	
	public AnaMenu() {
		initComponents();
		setTitle("ANA MENÜ");
		setSize(1920, 1080);
		
	}
	
	Oyuncu oyuncu = new Oyuncu();
	
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enter = new javax.swing.JLabel();
        adGirme = new javax.swing.JLabel();
        oyuncuAdi = new javax.swing.JTextField();
        Baslik = new javax.swing.JTextField();
        Aciklama = new javax.swing.JTextField();
        TembelSirin = new javax.swing.JButton();
        GozlukluSirin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        enter.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        enter.setForeground(new java.awt.Color(0, 51, 255));
        enter.setText("enter");
        getContentPane().add(enter);
        enter.setBounds(1050, 470, 100, 40);

        adGirme.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")), "ADINIZI GIRINIZ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 24), new java.awt.Color(51, 51, 255))); // NOI18N
        getContentPane().add(adGirme);
        adGirme.setBounds(720, 420, 450, 130);

        oyuncuAdi.setBackground(new java.awt.Color(255, 255, 255));
        oyuncuAdi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        oyuncuAdi.setForeground(new java.awt.Color(0, 51, 255));
        oyuncuAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oyuncuAdiActionPerformed(evt);
            }
        });
        getContentPane().add(oyuncuAdi);
        oyuncuAdi.setBounds(760, 470, 270, 50);

        Baslik.setEditable(false);
        Baslik.setBackground(new java.awt.Color(102, 153, 255));
        Baslik.setFont(new java.awt.Font("Stencil", 0, 100)); // NOI18N
        Baslik.setForeground(new java.awt.Color(255, 255, 255));
        Baslik.setText("SIRINLER");
        getContentPane().add(Baslik);
        Baslik.setBounds(710, 20, 490, 100);

        Aciklama.setBackground(new java.awt.Color(102, 153, 255));
        Aciklama.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        Aciklama.setForeground(new java.awt.Color(255, 255, 255));
        Aciklama.setText("OYUNU BASLATMAK ICIN SECINIZ");
        getContentPane().add(Aciklama);
        Aciklama.setBounds(750, 610, 400, 50);

        TembelSirin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TembelButon.jpg"))); // NOI18N
        TembelSirin.setText("TembelSirin");
        TembelSirin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TembelSirinActionPerformed(evt);
            }
        });
        getContentPane().add(TembelSirin);
        TembelSirin.setBounds(560, 700, 110, 160);

        GozlukluSirin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GozlukluButon.jpg"))); // NOI18N
        GozlukluSirin.setText("GozlukluSirin");
        GozlukluSirin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GozlukluSirinActionPerformed(evt);
            }
        });
        getContentPane().add(GozlukluSirin);
        GozlukluSirin.setBounds(1240, 700, 110, 160);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ArkaPlanSirinler.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -30, 1930, 1100);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1930, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1120, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1930, 1120);

        pack();
    }// </editor-fold>//GEN-END:initComponents
	
	private void TembelSirinActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TembelSirinActionPerformed
		this.setVisible(false);
		oyuncu.setOyuncuTur("Tembel");
		Test test = new Test(oyuncu.getOyuncuTur(), oyuncu.getOyuncuAdi());
		test.setVisible(true);
	}// GEN-LAST:event_TembelSirinActionPerformed
	
	private void GozlukluSirinActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
		oyuncu.setOyuncuTur("Gozluklu");
		Test test = new Test(oyuncu.getOyuncuTur(), oyuncu.getOyuncuAdi());
		test.setVisible(true);
		
	}
	
	private void oyuncuAdiActionPerformed(java.awt.event.ActionEvent evt) {
		oyuncu.setOyuncuAdi(oyuncuAdi.getText());
		System.out.println(oyuncu.getOyuncuAdi());
		
	}
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel. For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AnaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AnaMenu().setVisible(true);
			}
		});
		
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Aciklama;
    private javax.swing.JTextField Baslik;
    private javax.swing.JButton GozlukluSirin;
    private javax.swing.JButton TembelSirin;
    private javax.swing.JLabel adGirme;
    private javax.swing.JLabel enter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField oyuncuAdi;
    // End of variables declaration//GEN-END:variables
}
