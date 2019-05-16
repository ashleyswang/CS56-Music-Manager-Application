// OuputFile.java
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;

public class OutputFile implements OutputFileInterface{

	PrintWriter out;

	public void open(String outputFileName){
	// use a PrintWriter object to write info to a outputFileName
	File file = new File(outputFileName);
	try{
		out = new PrintWriter(outputFileName);
		out.format("%-40s %-40s %-40s %-7s %-5s %-40s", 
		 			"TITLE", "ARTIST","ALBUM", "LENGTH",
		 			"YEAR", "ADDITIONAL_INFO");
	}
	catch(Exception e){
		System.out.println("Exception thrown: " + e);
	}
	}

	// Writes the information for a single item to the file
	public void writeItem(MusicTrack trackToWrite){
		out.format("%-40s %-40s %-40s %-7s %-5s %-40s \n", trackToWrite.getTitle(), trackToWrite.getArtist(), trackToWrite.getAlbum(), trackToWrite.getLength(), trackToWrite.getYear(), trackToWrite.getAdditionalInfo());
	}


	public void close(){
		out.close();
	}
	// closes the scanner object used

}