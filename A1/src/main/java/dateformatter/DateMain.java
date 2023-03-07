package dateformatter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateMain {
	public static void main(String[] args) {
        
        //Test "formatDate"
        System.out.println("Format: \"A.4\", \"00.00.0000\", \"C-2b\": " +
			formatDate("A.4", "00.00.0000", "C-2b"));

		//Test "isDateCorrect"
        System.out.println("IsDateCorrect: \"A.4\", \"02.29.2000\": " +
			isDateCorrect("A.4", "02.29.2000"));

		//Test FileIO
		System.out.println("transformDates: " +
			transformDates("C:/GitHub/a1-res-sew22-s1086240_s1054335/input.txt", 
			"C:/GitHub/a1-res-sew22-s1086240_s1054335/output.txt"));
    }

	/**
	 * Reformats a date representation
	 * 
	 * @param sourceFormat  : format code of the date parameter		
	 * @param date			: date to be reformatted
	 * @param destFormat	: target format
	 * @return				: date string according to destFormat
	 * 						: null if format is invalid or date does not correspond to sourceFormat
	 */
	public static String formatDate(String sourceFormat, String date, String destFormat) {		
		Date dateF = new Date(date, sourceFormat);

		return dateF.toString(destFormat);
	}
	
	/**
	 * Checks correctness of full date 
	 * 
	 * @param formatCode	: format code, must have the full year (4 digits)
	 * @param date			: the date to be checked
	 * @return				: true if date is correct (page 2 in pdf file) and valid according to the formatCode, false otherwise
	 * 
	 * Examples: 
	 * 
	 * isDateCorrect("A/4","02/29/1900") returns false
	 * isDateCorrect("A/4","02/29/1904") returns true
	 * isDateCorrect("A.4","02/29/1904") returns false
	 * 
	 */
	public static boolean isDateCorrect(String formatCode, String date) {
		Date dateF = new Date(date, formatCode);

		if(dateF.isValid() == false){
			//invalid or wrong input
			return false;
		}

		int day = Integer.parseInt(dateF.getDay().replace(" ", ""));	//blank leads to parsing error
		int month = Integer.parseInt(dateF.getMonth().replace(" ", ""));
		int year = Integer.parseInt(dateF.getYear());


		//check specific year range
		if(!(1900 <= year && year <= 2099)){
			return false;
		}

		//check if date exists
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);	//check for date outside range
		try {
			format.parse(String.format("%d-%d-%d", year, month, day));
		} catch (ParseException e) {
			// Date invalid
			return false;
		}

		//passed all citeria
		return true;
	}

	/**
	 * Reformats multiple dates from file. Creates new file with the results.
	 * 
	 * @param inputFile : name of existing file with three strings per line: source format,date,target format
	 * @param outputFile: name of new file with the transformed dates
	 * 		- for a valid input, the corresponding line has the format: target format,date
	 * 		- for an invalid input, the corresponding output line should consist of the word INVALID
	 * 		- a valid input is defined exactly as the one for the method formatDate
	 * @return true if operation successful, false if output file already exists or if file access operations did not succeed 
	 * 
	 * Examples of input lines:
	 * 
	 * A/4,10/03/2022,B-4b
	 * C-4,17/12/2000,A/2
	 * B-2b,22- 8- 5,B-2
	 * A/4b, 2/29/2099,C/2
	 * C.4,03.10.2022,A/4b
	 *
	 * 
	 * The corresponding output lines:
	 * 
	 * B-4b,2022-10- 3
	 * INVALID
	 * B-2,22-08-05
	 * 29/02/99
	 * A/4b,10/ 3/2022
	 * 
	 */
	public static boolean transformDates(String inputFile, String outputFile) {
		BufferedReader br = null;
		BufferedWriter bw = null;
		String line, formatOutput;
		String[] args;

		try {
			File f = new File(inputFile);
			if(f.exists() == false){
				//input missing
				return false;
			}

			f = new File(outputFile);
			if(f.exists()){
				//output already exists
				return false;
			}

			br = new BufferedReader(new FileReader(inputFile));
			bw = new BufferedWriter(new FileWriter(outputFile));
			
			while ((line = br.readLine()) != null) {
				args = line.split(",");
				
				if(args.length != 3){
					//inputfile contains invalid line
					return false;
				}

				formatOutput = formatDate(args[0], args[1], args[2]);

				if(formatOutput == null)
					bw.write("INVALID");
				else
					bw.write(args[2] + "," + formatOutput);

				bw.newLine();
			}


		}catch(Exception ex){
			//error while opening file
			return false;
		}
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		
		return true;
	}
}
