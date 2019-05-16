// OutputFileInterface.java

public interface OutputFileInterface{

	public abstract void open(String outputFileName);
	// use a PrintWriter object to write info to a outputFileName

	public abstract void writeItem(MusicTrack trackToWrite);
	// Writes the information for a single item to the file

	public abstract void close();
	// closes the scanner object used

}