# Makefile

buckets:
	javac ArtistBucket.java TitleBucket.java

manager: 
	javac MusicManager.java MusicLibraryUI.java

output: 
	javac OutputFile.java

tracks: MusicTrack.class MusicTrackInterface.class DigitalTrack.class VinylTrack.class
	javac DigitalTrack.java VinylTrack.java

all: buckets manager output tracks
	javac Lab04.java

run: all
	java Lab04

clean: 
	rm -f *.class *.java~


