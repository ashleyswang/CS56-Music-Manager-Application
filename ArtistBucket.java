// ArtistBucket.java
import java.util.ArrayList;

public class ArtistBucket implements BucketInterface{

	private ArrayList<ArrayList<MusicTrack>> artistBucket;

	public ArtistBucket(){
		artistBucket = new ArrayList<ArrayList<MusicTrack>>();
		for (int i=0; i<26; i++){
			artistBucket.add(new ArrayList<MusicTrack>());
		}
		//System.out.println(artistBucket.size());
	}
	public void printArtistBucket(){
		for (int i = 0; i<artistBucket.size(); i++){
			System.out.print(i+": ");
			for (int j = 0; j < artistBucket.get(i).size(); j++){
				System.out.print(artistBucket.get(i).get(j).getArtist()+" ");
			}
			System.out.println();
		}
	}

	public void addItem(MusicTrack itemToAdd){
		// adds MusicTrack to appropriate bucket

		// nagivate to correct arrayList corresponding to first letter of artist
		String artistName = (itemToAdd.getArtist()).toLowerCase();
		char firstCharacter = artistName.charAt(0);
		int outerBucketIndex = (int) firstCharacter - 97;
		//System.out.println(outerBucketIndex);
		

		ArrayList<MusicTrack> innerBucket = artistBucket.get(outerBucketIndex);
		//ArrayList<MusicTrack> innerBucket = artistBucket.get(0);
		// compare elements within that arraylist and add into that arraylist in order
		int innerBucketIndex = 0;
		if(innerBucket.size() != 0){
			// while lexicographically name to be added is greater than the checked index
			while (artistName.compareTo(innerBucket.get(innerBucketIndex).getArtist().toLowerCase()) > 0){
				if (innerBucket.size()-1 == innerBucketIndex){
					innerBucket.add(itemToAdd);
					break;
				}
				innerBucketIndex++;
			}
			
			String addedTrackName = (itemToAdd.getTitle()).toLowerCase();
			while (artistName.compareTo(innerBucket.get(innerBucketIndex).getArtist().toLowerCase()) == 0){

				if (addedTrackName.compareTo(innerBucket.get(innerBucketIndex).getTitle().toLowerCase()) < 0){
					if(innerBucketIndex == innerBucket.size()-1){
						innerBucket.add(itemToAdd);
					}else{
						innerBucket.add(innerBucketIndex, itemToAdd);
					}
					break;
				} else {
					// this is definitely not right bc i didn't actually think about anything and am just trying it for the lolz
					if (innerBucketIndex == innerBucket.size()-1){
						break;
					} else {
						innerBucketIndex++;
					}
				}
			}

			if (artistName.compareTo(innerBucket.get(innerBucketIndex).getArtist().toLowerCase()) < 0){
				// if names are not the same
				// add at the index itemToAdd, will shift all subsequent elements one element down
				if(innerBucketIndex == innerBucket.size()-1){
					innerBucket.add(itemToAdd);
				}else{
					innerBucket.add(innerBucketIndex, itemToAdd);
				}
			}
		} else {
			innerBucket.add(itemToAdd);
		}

	}


	public ArrayList<ArrayList<MusicTrack>> getBuckets(){
		return artistBucket;
	}

	

} 