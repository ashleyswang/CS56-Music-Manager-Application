import java.util.Scanner;

public class MusicLibraryUI{

	public static void printFirst(){
		System.out.print("Enter `D` to read the music file from your local disk or `W` to read the music file from the web: ");
	}

	public static void printSecond(){
		System.out.print("Enter `A` to output tracks by Artists or `T` to output tracks by Title. Enter `Q` to quit: ");
	}

	public static String getFirstCommand() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Command");
		while(true) {
			String command = s.nextLine();
			if(command.equalsIgnoreCase("w") || command.equalsIgnoreCase("d")){
				s.close();
				return command;
			}
			System.out.println("Invalid Input.");
			printFirst();
		}
	}

	public static String getSecondCommand() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Command");
		while(true) {
			String command = s.nextLine();
			if(command.equalsIgnoreCase("a") || command.equalsIgnoreCase("t") || command.equalsIgnoreCase("q")){
				s.close();
				return command;
			}
			System.out.println("Invalid Input.");
			printSecond();
		}
	}
}