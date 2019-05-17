import java.util.Scanner;
import java.util.ArrayList;

public class MusicLibraryUI{

	private static Scanner s = new Scanner(System.in);

	public static void printFirst(){
		System.out.print("Enter `D` to read the music file from your local disk or `W` to read the music file from the web: ");
	}

	public static void printSecond(){
		System.out.print("Enter `A` to output tracks by Artists or `T` to output tracks by Title. Enter `Q` to quit: ");
	}

	public static String getFirstCommand() {
		while(true) {
			String command = s.nextLine();
			if(command.equalsIgnoreCase("w") || command.equalsIgnoreCase("d")){
				return command;
			}
			System.out.println("Invalid Input.");
			printFirst();
		}
	}

	private static void outputToFile(String choice, ArtistBucket artistList, TitleBucket tracksList){
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

	public static void getSecondCommand(ArtistBucket artistList, TitleBucket tracksList) {
		while(true) {
			String command = s.nextLine();
			if(command.equalsIgnoreCase("a") || command.equalsIgnoreCase("t")){
				outputToFile(command, artistList, tracksList);
				printSecond();
			}
			else if(command.equalsIgnoreCase("q")){
				break;
			}
			else{	
				System.out.println("Invalid Input.");
				printSecond();
			}
		}
	}

	public static void closeScanner(){
		s.close();
	}
}