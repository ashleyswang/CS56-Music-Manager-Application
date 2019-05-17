// VinylTrack.java

public class VinylTrack extends MusicTrack{

	private String formatType = "Vinyl"; 
	private String diskRPM;

	// Constructors
	public VinylTrack(){ /* do nothing */ };
	public VinylTrack(String title, String length, String artist, 
		String album, int year, String diskRPM){

		super(title, length, artist, album, year);
		this.diskRPM = diskRPM;

	}

	// Setters
	public void setRPM(String diskRPM){ this.diskRPM = diskRPM; }

	// Getters
	public String getAdditionalInfo(){ return (formatType+" "+diskRPM); }
	
	public void printTrack(){
		System.out.print(title  + " ");
		System.out.print(length + " "); 
		System.out.print(artist + " ");
		System.out.print(album  + " ");
		System.out.print(year   + " "); 
		System.out.println("V " + diskRPM);
	}

}