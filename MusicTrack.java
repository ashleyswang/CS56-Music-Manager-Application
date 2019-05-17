// MusicTrack.java

public abstract class MusicTrack implements MusicTrackInterface{
	
	protected String title;
	protected String length;
	protected String artist;
	protected String album;
	protected int year;

	// Constructors
	public MusicTrack() { /* do nothing */ };
	public MusicTrack(String title, String length, String artist, String album, int year){
			this.title = title;
			this.length = length;
			this.artist = artist;
			this.album = album;
			this.year = year;
	}

	// Setters 
	public void setTitle(String title){ this.title = title; }
	public void setLength(String length){ this.length = length; }
	public void setArtist(String artist){ this.artist = artist; }
	public void setAlbum(String album){ this.album = album; }
	public void setYear(int year){ this.year = year; }

	// Getters
	public String getTitle(){ return title; }
	// Returns the Music Track title.
	public String getLength(){ return length; }
	// Returns the Music Track length.
	public String getArtist(){ return artist; }
	// Returns the Music Track Artist name.
	public String getAlbum(){ return album; }
	// Returns the Music Track Album name.
	public int getYear(){ return year; }
	// Returns the Music Track year.
	public abstract String getAdditionalInfo();
	// Returns a String containing additional information based on the type (Digital or Vinyl) of the Music Tracks.
	public abstract void printTrack();

}