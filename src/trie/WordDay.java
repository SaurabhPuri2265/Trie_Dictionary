/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;
import java.io.*;
import java.util.*;

import javax.net.ssl.SSLContext;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;



public class WordDay extends javax.swing.JFrame {

    /**
     * Creates new form WordDay
     */
    public WordDay() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Word of the Day");

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\forward1 (2).jpg")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Desktop\\backward.png")); // NOI18N
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      /*
		objective:To find word of the day using random function
		inputs: none
		output: none
		return value: none 
		*/
      Trie tree=new Trie();
      try
      {
        FileReader file=new FileReader("Files/storedWords.txt");
        BufferedReader bf=new BufferedReader(file);
        Path path 
            = Paths.get("Files/storedWords.txt");
        long sizeFile=Files.size(path);
       // System.out.println(sizeFile/wordSize);
		int i=0;
		Random r=new Random();
		int totalWords=(int)sizeFile/tree.wordSize+1;
		//System.out.println(sizeFile);
		int random=r.nextInt(totalWords);

		while(random==0 || tree.set.contains(random) )
			random=r.nextInt(totalWords);

		tree.set.add(random);
		//System.out.println(random);

		if(tree.set.contains(random+1) && (random+1)<=totalWords)
			tree.set.remove(random+1);
		else
			tree.set.remove(random-1);	
			

        while(i<random)
        {
            bf.readLine();
            i++;
        }
		
		String reqWord=bf.readLine();
		int whiteIdx=reqWord.indexOf(" ");
		String word=reqWord.substring(0,whiteIdx );
		String mean=reqWord.substring(whiteIdx+1,reqWord.indexOf(" ",whiteIdx+1));
		jLabel4.setText("Word of the day is: "+word+"\n"+"  Its meaning is: "+mean+"\n");
      }
      catch(IOException e)
      {
          System.out.println(e);
      }
        
		
		        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        /*Trie tree=new Trie();
        try
       {     
        FileReader file=new FileReader("Files/storedWords.txt");
        BufferedReader bf=new BufferedReader(file);
        Path path 
            = Paths.get("Files/storedWords.txt");
        long sizeFile=Files.size(path);
       // System.out.println(sizeFile/wordSize);
		int i=0;
		Random r=new Random();
		int totalWords=(int)sizeFile/tree.wordSize+1;
		//System.out.println(sizeFile);
		int random=r.nextInt(totalWords);

		while(random==0 || tree.set.contains(random) )
			random=r.nextInt(totalWords);

		tree.set.add(random);
		//System.out.println(random);

		if(tree.set.contains(random+1) && (random+1)<=totalWords)
			tree.set.remove(random+1);
		else
			tree.set.remove(random-1);	
			

        while(i<random)
        {
            bf.readLine();
            i++;
        }
		
		String reqWord=bf.readLine();
		int whiteIdx=reqWord.indexOf(" ");
		String word=reqWord.substring(0,whiteIdx );
		String mean=reqWord.substring(whiteIdx+1,reqWord.indexOf(" ",whiteIdx+1));
		System.out.println("Word of the day is: "+word+"\nIts meaning is: "+mean+"\n");
       }
       catch(IOException e)
       {
           System.out.println(e);
       }  */
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
              Menu m=new Menu();
              m.setVisible(true);
              this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WordDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WordDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WordDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WordDay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WordDay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
