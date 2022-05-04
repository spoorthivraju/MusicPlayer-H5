
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sowjanya
 */
public class Playlist extends javax.swing.JDialog {

    MusicPlayer musicPlayer = new MusicPlayer();
     MyDB myDB = new MyDB();
     PreparedStatement preparedStatement;
     ResultSet resultSet;
    
    /**
     * Creates new form Playlist
     */
    public Playlist(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        getPlaylist(playlistTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        playlistTable = new javax.swing.JTable();
        playPlaylistButton = new javax.swing.JButton();
        deleteSongButton = new javax.swing.JButton();
        addPlaylistButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        playlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Song Type", "Artist", "Song Name", "Path"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        playlistTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                playlistTableAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(playlistTable);

        playPlaylistButton.setText("Play Playlist");
        playPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playPlaylistButtonActionPerformed(evt);
            }
        });

        deleteSongButton.setText("Delete Song");
        deleteSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSongButtonActionPerformed(evt);
            }
        });

        addPlaylistButton.setText("Add Song");
        addPlaylistButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPlaylistButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(28, 50, 65));

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My  Playlist");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteSongButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addPlaylistButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(playPlaylistButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(playPlaylistButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteSongButton)
                        .addGap(18, 18, 18)
                        .addComponent(addPlaylistButton)
                        .addGap(120, 120, 120))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playPlaylistButtonActionPerformed
       
       musicPlayer.play(playPlaylist(playlistTable), 0);
  
    }//GEN-LAST:event_playPlaylistButtonActionPerformed

    private void addPlaylistButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPlaylistButtonActionPerformed
       
        Library library = new Library(new javax.swing.JFrame(), rootPaneCheckingEnabled);
        library.setVisible(true);
    }//GEN-LAST:event_addPlaylistButtonActionPerformed

    private void playlistTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_playlistTableAncestorAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_playlistTableAncestorAdded

    private void deleteSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSongButtonActionPerformed

        int selectedRow = playlistTable.getSelectedRow();
        
        
        String selectedArtist = playlistTable.getValueAt(selectedRow, 1).toString();
        String selectedSongName = playlistTable.getValueAt(selectedRow, 2).toString();
        
        deleteFromPlaylist(selectedArtist, selectedSongName);
        
    }//GEN-LAST:event_deleteSongButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Playlist dialog = new Playlist(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPlaylistButton;
    private javax.swing.JButton deleteSongButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton playPlaylistButton;
    public javax.swing.JTable playlistTable;
    // End of variables declaration//GEN-END:variables


    private void getPlaylist(JTable jTable) {

        Connection connection = myDB.connect();
        String getPlaylistQ = "SELECT * FROM playlist";
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();
        String songtype, artist, songname, path;

        try {
            preparedStatement = connection.prepareStatement(getPlaylistQ);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                songtype = resultSet.getString("songtype");
                artist = resultSet.getString("artist");
                songname = resultSet.getString("songname");
                path = resultSet.getString("path");

                defaultTableModel.addRow(new Object[]{songtype, artist, songname, path});

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    public void deleteFromPlaylist(String selectedArtist, String selectedSongName) {
        Connection connection = myDB.connect();
        String deleteSongQ = "DELETE FROM playlist WHERE artist=? AND songname=?";

        try {

            preparedStatement = connection.prepareStatement(deleteSongQ);
            preparedStatement.setString(1, selectedArtist);
            preparedStatement.setString(2, selectedSongName);

            if (preparedStatement.executeUpdate() > 0) {

                JOptionPane.showMessageDialog(this, selectedSongName + " Removed successfully.");
                preparedStatement.close();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Song can not deleted !");
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Song> playPlaylist(JTable jTable) {

        int selectedRow = playlistTable.getSelectedRow();
        String songType, artist, songName, path;

        ArrayList<Song> playList = new ArrayList<>();

        for (int i = 0; i < jTable.getRowCount(); i++) {

            songType = jTable.getValueAt(selectedRow, 0).toString();
            artist = jTable.getValueAt(selectedRow, 1).toString();
            songName = jTable.getValueAt(selectedRow, 2).toString();
            path = jTable.getValueAt(selectedRow, 3).toString();

            playList.add(i, new Song(songType, artist, songName, path));

        }

        return playList;
    }

}