
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author spoorthi v
 */
public class MyDB {

 static String url = "jdbc:mysql://localhost:3306/music_player?zeroDateTimeBehavior=CONVERT_TO_NULL";
    static String user = "root";
    
    static String password = "A1ohomor@";
    PreparedStatement ps;
    ResultSet rs;

    public Connection connect() {

        Connection connection;

        try {
            
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            connection = null;

        }

        return connection;
    }

//        public class MyDB{
//   
// // add to mysql jar file    
//    
// public static Connection mydb(){
// 
//     try {
//         
//         Class.forName("com.mysql.jdbc.Driver");
//         Connection connection = DriverManager.getConnection("jdbc:mysql://"
//                 + "localhost:3306/mydb","root","");
//         
//         return connection ;
//         
//     } catch (ClassNotFoundException | SQLException e) {
//     }
//     return null;
 
    public void registerUser(JTextField emailTextField, JPasswordField passwordTextField) {

        if (emailTextField.getText().trim().isEmpty() && passwordTextField.getPassword().equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Email and Password can not be empty.");
        } else {
            boolean userExists = false;
            Connection connection = connect();
            String userEmail = emailTextField.getText();
            String userPassword = String.valueOf(passwordTextField.getPassword());
            String registerQ = "INSERT INTO users (email,password) VALUES(?,?);";
            String checkQ = "SELECT * FROM users where email=? ";

            try {
                ps = connection.prepareStatement(checkQ);
                ps.setString(1, userEmail);
                rs = ps.executeQuery();

                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, "User already exsist.");
                    userExists = true;
                }

            } catch (Exception e) {
                System.out.println("ERROR : " + e.getMessage() + " CAUSE : " + e.getCause());
            }

            if (userExists == false) {

                try {

                    ps = connection.prepareStatement(registerQ);
                    ps.setString(1, userEmail);
                    ps.setString(2, userPassword);
                    if (ps.executeUpdate() > 0) {
                        ps.close();

                        JOptionPane.showMessageDialog(null, "Account created succesfully.");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "An error ocured.");
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }
            }
        }

    }

    public void loginUser(JTextField emailTextField, JPasswordField passwordTextField) {

        Connection connection = connect();
        String userEmail = emailTextField.getText();
        String userPassword = String.valueOf(passwordTextField.getPassword());
        String loginQ = "SELECT * FROM users WHERE email=? AND password=?";

        try {
            ps = connection.prepareStatement(loginQ);
            ps.setString(1, userEmail);
            ps.setString(2, userPassword);
            rs = ps.executeQuery();

            if (rs.next()) {

                MusicPlayer musicPlayer = new MusicPlayer();
                musicPlayer.setVisible(true);
                System.out.println("Logged in");
            }

        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage() + " CAUSE : " + e.getCause());
        }
    }

    public void addMusic(JComboBox<String> musicTypeComboBox, JTextField artistTextField, JTextField songNameTextField, JTextField pathTextField) {

        String musicType = musicTypeComboBox.getSelectedItem().toString();
        String artist = artistTextField.getText();
        String songName = songNameTextField.getText();
        String path = pathTextField.getText();

        String addMusicQ = "INSERT INTO song VALUES (?,?,?,?)";

        Connection connection = connect();

        try {

            ps = connection.prepareStatement(addMusicQ);
            ps.setString(1, musicType);
            ps.setString(2, artist);
            ps.setString(3, songName);
            ps.setString(4, path);

            if (ps.executeUpdate() > 0) {
                ps.close();

                JOptionPane.showMessageDialog(null, "Song added successfully "
                        + "\n Type: " + musicType
                        + "\n Artist: " + artist
                        + "\n Song Name: " + songName
                        + "\n Path: " + path);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error ocured.");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }

    public void getArtist(String musicType, JComboBox jComboBox) {

        Connection connection = connect();
        String getArtistQ = "select distinct artist from song where musicType=?;";
        Object[] object = new Object[10];
        ArrayList<Object> artist = new ArrayList<>();

        try {
            ps = connection.prepareStatement(getArtistQ);
            ps.setString(1, musicType);
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                artist.add(i, rs.getString("artist"));
                i++;

            }
            rs.close();
            DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(artist.toArray());
            jComboBox.setModel(defaultComboBoxModel);

        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getSongs(String musicType, String artist, JList list) {

        Connection connection = connect();
        String getSongsQ = "SELECT * FROM song WHERE musicType=? AND artist=?;";
        DefaultListModel defaultListModel = new DefaultListModel();
        ArrayList<Object> songs = new ArrayList<>();

        try {
            ps = connection.prepareStatement(getSongsQ);
            ps.setString(1, musicType);
            ps.setString(2, artist);
            rs = ps.executeQuery();

            while (rs.next()) {

                defaultListModel.addElement(rs.getString("songname"));
                System.out.println(rs.getString("songname"));

            }
            list.setModel(defaultListModel);

            if (!rs.next()) {
                System.out.println(rs.getStatement());
            }

        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList getSongs(String musicType, String artist, String songName) {

        ArrayList<Song> songs = new ArrayList<>();
        Connection connection = connect();
        String getSongsQ = "SELECT songname, path from song where (musictype=? and artist=? ) and songname =? ;";

        try {
            ps = connection.prepareStatement(getSongsQ);
            ps.setString(1, musicType);
            ps.setString(2, artist);
            ps.setString(3, songName);
            rs = ps.executeQuery();

            while (rs.next()) {
                songs.add(new Song(songName, artist, songName, rs.getString("path")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs;
    }

    public void getAllSongs(JTable jTable) {

        ArrayList<Song> songs = new ArrayList<>();
        Connection connection = connect();
        String getSongsQ = "Select * From song";
        String songname, musicType, artist, path;
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable.getModel();

        try {
            ps = connection.prepareStatement(getSongsQ);
            rs = ps.executeQuery();

            while (rs.next()) {
                musicType = rs.getString("musicType");
                artist = rs.getString("artist");
                songname = rs.getString("songname");
                path = rs.getString("path");

                defaultTableModel.addRow(new Object[]{musicType, artist, songname, path});

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
