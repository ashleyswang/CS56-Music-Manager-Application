// DigitalTrack.java

public class DigitalTrack extends MusicTrack{

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
	public void printTrack(){
		System.out.print(title  + " ");
		System.out.print(length + " "); 
		System.out.print(artist + " ");
		System.out.print(album  + " ");
		System.out.print(year   + " "); 
		System.out.println("D " + bitRate);
	}

}