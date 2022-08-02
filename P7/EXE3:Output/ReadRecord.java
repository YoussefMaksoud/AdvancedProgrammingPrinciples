/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */

package EXE3;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {
    
    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     */
    
    private void readObjectsFromFile(String name)
    {
        MusicRecord record;
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
            System.out.println("File opened");
            System.out.println("---------------------");
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several records.
         * Loop should terminate when an EOFException is thrown.
         */
        
       try
        {
            while (true)
            {
                /*if((MusicRecord) input.readObject() == null){
                    break;
                }else {*/
                    record = (MusicRecord) input.readObject();

                    System.out.print(record.getYear_recorded() + "  ");

                    System.out.print(record.getSongName() + "  ");

                    System.out.print(record.getSingerName() + "  ");

                    System.out.println(record.getPurchasePrice() + "  ");
                //}

            }   // END OF WHILE

            //input.close();
            //System.out.println("The end of the file was reached");

        }catch(EOFException e){
           System.out.println("---------------------");
           System.out.println("End of file reached");
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }           // END OF METHOD

    /**
     *
     * creates a new ReadRecord
     * reads the objects from the file by calling the method
     * @param args
     */
    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile(System.getProperty("user.dir") + "/src/EXE3/" + "mySongs.ser");
    }
}