import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 * This class will open a file chooser window and provide methods to get the contents of the file.
 * @author Jason Sawin
 *
 */
public class FileReader {
	
	/**
	 * The scanner object used to get the input
	 */
	private Scanner fileScanner;
	
	/**
	 * The constructor will open a JFileChoose that is a gui which will allow a user to select a file from their machine
	 * THe constructor will catch a FIleNotFoundException and a Generic exception
	 */
	public FileReader(){
		JFileChooser chooser = new JFileChooser();
        
        try {   
            if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
                throw new Error("Input file not selected");
            }
            File questionFile = chooser.getSelectedFile();
            fileScanner = new Scanner(questionFile);
          
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found.");
        } catch (Exception e) {
            System.err.println("A mysterious error occurred.");
            e.printStackTrace(System.err);
        }
	}
	
	/**
	 * This method will check if the file has a next line
	 * @return true, if there is another line
	 */
	public boolean fileHasNextLine(){
		return this.fileScanner.hasNextLine();
	}
	
	/**
	 * This method will return the full current line as a string
	 * @return a String representation of the current line
	 */
	public String getNextLineOfFile(){
		return this.fileScanner.nextLine();
	}
	
	
	/**
	 * Used to close the scanner.
	 * Throws an Exception if there is something unexpected that comes up
	 */
	public void finalize(){
		try{
			this.fileScanner.close();
		}catch(Exception ex){
			 System.err.println("A mysterious error occurred on closing Scanner.");
	         ex.printStackTrace(System.err);
		}
	}
}
