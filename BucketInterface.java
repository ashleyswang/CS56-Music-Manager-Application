// BucketInterface.java
import java.util.ArrayList;

public interface BucketInterface{

	public abstract void addItem(MusicTrack itemToAdd);
	// adds MusicTrack to appropriate bucket

	public abstract ArrayList<ArrayList<MusicTrack>> getBuckets();
	// getter method returns the ArrayList of ArrayList structure

}