// MusicTrackInterface.java

public interface MusicTrackInterface{
	
	public abstract String getTitle();
	// Returns the Music Track title.
	public abstract String getLength();
	// Returns the Music Track length.
	public abstract String getArtist();
	// Returns the Music Track Artist name.
	public abstract String getAlbum();
	// Returns the Music Track Album name.
	public abstract int getYear();
	// Returns the Music Track year.
	public abstract String getAdditionalInfo();
	// Returns a String containing additional information based on the type (Digital or Vinyl) of the Music Tracks.


}