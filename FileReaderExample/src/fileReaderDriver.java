import java.util.NoSuchElementException;

public class fileReaderDriver {
	
	public static void printWithNewLine(int numTimes, String phrase) {
		for(int i = 0; i < numTimes; i++) {
			System.out.println("\t" + phrase);
		}
	}
	
	public static void printWithNoNewLine(int numTimes, String phrase) {
		System.out.println("\t");
		for(int i = 0; i < numTimes; i++) {
			System.out.print(phrase + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		FileReader reader = new FileReader();
		String[] array;
		String lineType;
		int numLines;
		String phrase;
		
		while(reader.fileHasNextLine()) {
			String curLine = reader.getNextLineOfFile();
			array = curLine.split(",");
			
			lineType = array[0];
			numLines = Integer.parseInt(array[1]);
			phrase = array[2];
			
			
		    if(lineType.equals("nl")) {
		    	printWithNewLine(numLines, phrase);
			}
			else {
				printWithNoNewLine(numLines, phrase);
			}
			
		}
		
		try {
			String curLine = reader.getNextLineOfFile();
		}catch(NoSuchElementException ex) {
			System.out.println("No More lines");
		}

	}

}
