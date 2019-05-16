// MusicManager.java
import java.util.Scanner;
import java.util.ArrayList;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class MusicManager{

	private ArtistBucket artistList;
	private TitleBucket tracksList;

	// Constructor
	public MusicManager(){
		artistList = new ArtistBucket();
		tracksList = new TitleBucket();

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

	public void start(){
		/* the part that gets the file from the user */
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Music Library Application!");
		MusicLibraryUI.printFirst();
		String choice = MusicLibraryUI.getFirstCommand();
		if(choice == "D" || choice == "d"){
			try{

			}
		}
		else{

		}
		MusicLibraryUI.printSecond();
		choice = MusicLibraryUI.getSecondCommand();
		if(choice == "A" || choice == "a"){

		}
		else{

		}

	}

	}


}