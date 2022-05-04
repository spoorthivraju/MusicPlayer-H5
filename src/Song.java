/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spoorthi v
 */
public class Song {
    
    private String songType;
    private String artist;
    private String songName;
    private String path;

    
      public Song(String songType, String artist, String songName, String path) {
        this.songType = songType;
        this.artist = artist;
        this.songName = songName;
        this.path = path;
    }
    
      public Song(String artist, String songName) {
       
        this.artist = artist;
        this.songName = songName;
       
    }
    
    
    
    
    
    
    
    
    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

  
    
    
    
}
