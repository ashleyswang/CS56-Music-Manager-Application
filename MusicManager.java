// MusicManager.java
import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class MusicManager{

	private ArtistBucket artistList;
	private TitleBucket tracksList;

	// Constructor
	public MusicManager(){
		artistList = new ArtistBucket();
		tracksList = new TitleBucket();
	}

	/* Once all of the music track data is imported and organized in your 
	application, the application will prompt the user to write the 
	information in a specific format. The user may enter A or a to write 
	the Music Library to a file sorted by Artist, T or t to write the 
	Music Library to a file sorted by Track title, or Q or q to quit the 
	application.

	Your program will continue to prompt the user for the correct input 
	if the valued entered is incorrect or until the user enters Q or q.

	The program will write to a file named artistOutput.txt if the user 
	wants to sort the music library based on the Artist name.

	The program will write to a file named titleOutput.txt if the user 
	wants to sort the music library based on the Track name.

	*/ 
	private MusicTrack createTrack(String s){
		// making the track object
		Scanner trackAttributes = new Scanner(s);
		trackAttributes.useDelimiter(";");
		
		int attributeCounter = 1;
		String attribute;

		String tempTitle = "";
		String tempLength = "";
		String tempArtist = "";
		String tempAlbum = "";
		int tempYear = 0;
		String tempType = "";
		String tempAdditionalInfo = "";

		while(trackAttributes.hasNext()){
			attribute = trackAttributes.next();
			
			switch (attributeCounter){
				case 1: // set title
						tempTitle = attribute;
						attributeCounter++;
						break;
				case 2: // set length
						tempLength = attribute;
						attributeCounter++;
						break;
				case 3: // set artist name
						tempArtist = attribute;
						attributeCounter++;
						break;
				case 4: // set album
						tempAlbum = attribute;
						attributeCounter++;
						break;
				case 5: // set year
						tempYear = Integer.parseInt(attribute);
						attributeCounter++;
						break;
				case 6: // set type
						tempType = attribute;
						attributeCounter++;
						break;
				case 7: // set additional information
						tempAdditionalInfo = attribute;
						break;
			}
		}

		if (tempType.equals("D")){
			DigitalTrack newTrack = new DigitalTrack(tempTitle, tempLength, tempArtist,
										tempAlbum, tempYear, tempAdditionalInfo);
			//newTrack.printTrack();
			return newTrack;
		} else {
			VinylTrack newTrack = new VinylTrack(	tempTitle, tempLength, tempArtist,
										tempAlbum, tempYear, tempAdditionalInfo);
			//newTrack.printTrack();
			return newTrack;
		}
	}

	// taking the file and reading the input
	private void inputFromInfile(String choice){
		try{
			Scanner infile;
			if (choice.toLowerCase().equals("d"))
				infile = new Scanner(new File("MusicList.txt"));
			else{
				URL remoteFileLocation =
        			new URL("https://sites.cs.ucsb.edu/~richert/cs56/misc/lab04/MusicList.txt");

       			URLConnection connection = remoteFileLocation.openConnection();
				infile = new Scanner(connection.getInputStream());
			}

			String trackInfo;
			while(infile.hasNextLine()){
				trackInfo = infile.nextLine();
				MusicTrack newTrack = createTrack(trackInfo);

				artistList.addItem(newTrack);
				tracksList.addItem(newTrack);
				newTrack.printTrack();

			}
		} catch (IOException e) {
			e.toString();
		}
	}

	private void outputToFile(String choice){
		// if choice A output artistOutput.txt
		OutputFile outputFile = new OutputFile();
		ArrayList<ArrayList<MusicTrack>> outputBucket;
		if(choice.equalsIgnoreCase("a")){
			outputFile.open("artistOutput.txt");
			outputBucket = artistList.getBuckets();
		}
		else{
			outputFile.open("titleOutput.txt");
			outputBucket = tracksList.getBuckets();
		}
		for(int i = 0; i < outputBucket.size(); i++){
			ArrayList<MusicTrack> tracks = outputBucket.get(i);
			for(int j = 0; j < tracks.size(); j++){
				outputFile.writeItem(tracks.get(j));
			}
		}
		outputFile.close();
	}

	public void start(){
		/* the part that gets the file from the user */
		System.out.println("Welcome to the Music Library Application!");
		MusicLibraryUI.printFirst();

		String choice1 = MusicLibraryUI.getFirstCommand();
		this.inputFromInfile(choice1);

		MusicLibraryUI.printSecond();
		String choice2 = MusicLibraryUI.getSecondCommand();
		while(!(choice2.equalsIgnoreCase("q"))){
			this.outputToFile(choice2);
		}	

	}

	


}