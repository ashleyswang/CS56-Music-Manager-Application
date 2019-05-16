// DigitalTrack.java

public abstract class DigitalTrack extends MusicTrack{

	private String formatType = "Digital"; 
	private String bitRate;

	// Constructors
	public DigitalTrack(){ /* do nothing */ };
	public DigitalTrack(String title, String length, String artist, 
		String album, int year, String bitRate){

		super(title, length, artist, album, year);
		this.bitRate = bitRate;

	}

	// Setters
	public void setBitRate(String bitRate){ this.bitRate = bitRate; }

	// Getters
	public String getAdditionalInfo(){ return (formatType+" "+bitRate); }

}