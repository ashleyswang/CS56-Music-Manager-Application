// ArtistBucket.java
import java.util.ArrayList;

public class ArtistBucket implements BucketInterface{

	private ArrayList<ArrayList<MusicTrack>> artistBucket;

	public ArtistBucket(){
		artistBucket = new ArrayList<ArrayList<MusicTrack>>(26);
	}

	public void addItem(MusicTrack itemToAdd){
		// adds MusicTrack to appropriate bucket

		// nagivate to correct arrayList corresponding to first letter of artist
		String artistName = (itemToAdd.getArtist()).toLowerCase();
		char firstCharacter = artistName.charAt(0);
		int outerBucketIndex = (int) firstCharacter - 97;
		ArrayList<MusicTrack> innerBucket = artistBucket.get(outerBucketIndex);

		// compare elements within that arraylist and add into that arraylist in order
		int innerBucketIndex = 0;
		// while lexicographically name to be added is greater than the checked index
		while (artistName.compareTo(innerBucket.get(innerBucketIndex).getArtist()) > 0 ){
			innerBucketIndex++;
		}
		// add at the index itemToAdd, will shift all subsequent elements one element down
		innerBucket.add(innerBucketIndex, itemToAdd);
	}

	public ArrayList<ArrayList<MusicTrack>> getBuckets(){
		return artistBucket;
	}

}