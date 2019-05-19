import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class MusicLibraryTests {
	
	private MusicTrack firstTrack = new DigitalTrack("Antichrist Television Blues", "5:10", "Arcade Fire", "Neon Fire", 2017, "1411");
	private MusicTrack secondTrack = new DigitalTrack("Born To Be A Dancer", "3:31", "Kaiser Chiefs", "Employment", 2005, "1411");
	private MusicTrack thirdTrack = new DigitalTrack("Demon Days", "4:29", "Gorillaz", "Demon Days", 2005, "1411");
	private MusicTrack fourthTrack = new DigitalTrack("El Manana", "3:50", "Gorillaz", "Demon Days", 2005, "1411");
	private MusicTrack fifthTrack = new DigitalTrack("Apple Bottom", "2:13", "The White Stripes", "De Stijl", 2010, "320");
	private MusicTrack sixthTrack = new VinylTrack("My Girl", "3:10", "Aerosmith", "Pump", 1989, "33");
	private MusicTrack seventhTrack = new VinylTrack("Monkey On My Back", "3:58", "Aerosmith", "Pump", 1989, "33");
	private MusicTrack eighthTrack = new VinylTrack("Last Nite", "3:17", "The Strokes", "Is This It", 2001, "33" );
	private MusicTrack ninthTrack = new VinylTrack("This Is A Call", "3:53", "Foo Fighters", "Foo Fighters", 1995, "33");
	private MusicTrack tenthTrack = new VinylTrack("Hey Johnny Park!", "4:08", "Foo Fighters", "The Colour and the Shape", 1997, "45");
	
	
	@Before // Executed before each test in this class
    public void executeBeforeEachTest() {
        System.out.println("@Before: see before every test");
    }
	
	@After
	public void executeAfterTest() {
        System.out.println("@After: See this after every test");
    }
	
	@Test
	public void DigitalTitleTest() {
		TitleBucket titles = new TitleBucket();
		titles.addItem(firstTrack);
		titles.addItem(secondTrack);
		titles.addItem(thirdTrack);
		titles.addItem(fourthTrack);
		titles.addItem(fifthTrack);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(0).add(firstTrack);
		expected.get(0).add(fifthTrack);
		expected.get(1).add(secondTrack);
		expected.get(3).add(thirdTrack);
		expected.get(4).add(fourthTrack);
		assertEquals(expected, titles.getBuckets());
	}
	
	@Test
	public void DigitalArtistTest() {
		ArtistBucket artists = new ArtistBucket();
		artists.addItem(firstTrack);
		artists.addItem(secondTrack);
		artists.addItem(thirdTrack);
		artists.addItem(fourthTrack);
		artists.addItem(fifthTrack);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(0).add(firstTrack);
		expected.get(10).add(secondTrack);
		expected.get(6).add(thirdTrack);
		expected.get(6).add(fourthTrack);
		expected.get(19).add(fifthTrack);
		assertEquals(expected, artists.getBuckets());		
	}
	
	@Test
	public void DuplicateDigitalTest() {
		ArtistBucket artists = new ArtistBucket();
		TitleBucket titles = new TitleBucket();
		artists.addItem(firstTrack);
		artists.addItem(firstTrack);
		titles.addItem(firstTrack);
		titles.addItem(firstTrack);
		ArrayList<ArrayList<MusicTrack>> artistExpected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			artistExpected.add(new ArrayList<MusicTrack>());
		}
		ArrayList<ArrayList<MusicTrack>> titleExpected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			titleExpected.add(new ArrayList<MusicTrack>());
		}
		artistExpected.get(0).add(firstTrack);
		titleExpected.get(0).add(firstTrack);
		assertEquals(artistExpected, artists.getBuckets());
		assertEquals(titleExpected, titles.getBuckets());
	}
	
	@Test
	public void VinylTitleTest() {
		TitleBucket titles = new TitleBucket();
		titles.addItem(sixthTrack);
		titles.addItem(seventhTrack);
		titles.addItem(eighthTrack);
		titles.addItem(ninthTrack);
		titles.addItem(tenthTrack);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(12).add(seventhTrack);
		expected.get(12).add(sixthTrack);
		expected.get(11).add(eighthTrack);
		expected.get(19).add(ninthTrack);
		expected.get(7).add(tenthTrack);
		assertEquals(expected, titles.getBuckets());
	}
	
	@Test
	public void VinylArtistTest() {
		ArtistBucket artists = new ArtistBucket();
		artists.addItem(sixthTrack);
		artists.addItem(seventhTrack);
		artists.addItem(eighthTrack);
		artists.addItem(ninthTrack);
		artists.addItem(tenthTrack);
		ArrayList<ArrayList<MusicTrack>> expected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			expected.add(new ArrayList<MusicTrack>());
		}
		expected.get(0).add(sixthTrack);
		expected.get(0).add(seventhTrack);
		expected.get(19).add(eighthTrack);
		expected.get(5).add(ninthTrack);
		expected.get(5).add(tenthTrack);
		assertEquals(expected, artists.getBuckets());		
	}
	
	@Test
	public void DuplicateVinylTest() {
		ArtistBucket artists = new ArtistBucket();
		TitleBucket titles = new TitleBucket();
		artists.addItem(sixthTrack);
		artists.addItem(sixthTrack);
		titles.addItem(sixthTrack);
		titles.addItem(sixthTrack);
		ArrayList<ArrayList<MusicTrack>> artistExpected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			artistExpected.add(new ArrayList<MusicTrack>());
		}
		ArrayList<ArrayList<MusicTrack>> titleExpected = new ArrayList<ArrayList<MusicTrack>>();
		for(int i = 0; i < 26; i++) {
			titleExpected.add(new ArrayList<MusicTrack>());
		}
		artistExpected.get(0).add(sixthTrack);
		titleExpected.get(0).add(sixthTrack);
		assertEquals(artistExpected, artists.getBuckets());
		assertEquals(titleExpected, titles.getBuckets());
	}
	

}
