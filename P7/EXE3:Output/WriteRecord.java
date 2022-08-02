/**
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */


package EXE3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteRecord {

	ObjectOutputStream objectOut = null;
	MusicRecord record = null;
	Scanner stdin = null;
	Scanner textFileIn = null;
	FileInputStream inFile = null;

	/**
	 * Creates an blank MusicRecord object
	 */
	public WriteRecord() {
		record = new MusicRecord();
	}

	/**
	 * Initializes the data fields of a record object
	 * @param year - year that song was purchased
	 * @param songName - name of the song
	 * @param singerName - singer's name
	 * @param price - CD price
	 */
	public void setRecord(int year, String songName, String singerName,
                                                                 double price) {
		record.setSongName(songName);
		record.setSingerName(singerName);
		record.setYear(year);
		record.setPrice(price);
	}
    
	/**
	 * Opens a file input stream, using the data field textFileIn
	 * @param textFileName name of text file to open
	 */
	public void openFileInputStream(String textFileName) {
		try {
			inFile = new FileInputStream(textFileName);
			System.out.println("The input file is open");
		}catch(IOException e){
			e.printStackTrace();
		}
     // TO BE COMPLETED BY THE STUDENTS
	}

	/**
	 * Opens an ObjectOutputStream using objectOut data field
	 * @param objectFileName name of the object file to be created
	 */
	public void openObjectOutputStream(String objectFileName) throws FileNotFoundException {
		try {
			objectOut = new ObjectOutputStream(new FileOutputStream(objectFileName));
			System.out.println("The output object file is open");
			System.out.println("------------------------------");
		}catch(IOException e){
			e.printStackTrace();
		}

    // TO BE COMPLETED BY THE STUDENTS
        
	}
	
	/**
	 * Reads records from given text file, fills the blank MusicRecord
	 * created by the constructor with the existing data in the text
	 * file and serializes each record object into a binary file
	 */
	public void createObjectFile() throws IOException {

		textFileIn = new Scanner(inFile);

		while (textFileIn.hasNext()) // loop until end of text file is reached
		{
			int year = Integer.parseInt(textFileIn.nextLine());
			System.out.print(year + "  ");       // echo data read from text file
            
			String songName = textFileIn.nextLine();
			System.out.print(songName + "  ");  // echo data read from text file
            
			String singerName = textFileIn.nextLine();
			System.out.print(singerName + "  "); // echo data read from text file
            
			double price = Double.parseDouble(textFileIn.nextLine());
			System.out.println(price + "  ");    // echo data read from text file
            
			record = new MusicRecord(year, songName, singerName, price);
			textFileIn.nextLine();   // read the dashed lines and do nothing

			objectOut.writeObject(record);

		}

		try {
			objectOut.close();
			inFile.close();
			System.out.println("The input and output files are now closed");
		}catch(IOException e){
			e.printStackTrace();
		}

		// YOUR CODE GOES HERE
	}

	/**
	 *
	 * recieves the io filenames and reads the textfile, and produces an object file
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
        
		WriteRecord d = new WriteRecord();
        
		String textFileName = System.getProperty("user.dir") + "/src/EXE3/" + "someSongs.txt"; // Name of a text file that contains
                                               // song records
        
		String objectFileName = System.getProperty("user.dir") + "/src/EXE3/" + "mySongs.ser"; // Name of the binary file to
                                               // serialize record objects
        
		d.openFileInputStream(textFileName);   // open the text file to read from
        
		d.openObjectOutputStream(objectFileName); // open the object file to
                                                  // write music records into it
        
		d.createObjectFile();   // read records from opened text file, and write
                                // them into the object file.
	}
}
