package decorator;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MorseTranslator
 */
public class MorseTranslator implements Translator {
	private static final int MAXMORSECHARACTERLENGTH = 4;

	private static MorseTranslator instance = null;
	private static Map<String, Character> reverseMorse = new LinkedHashMap<String, Character>();

	private MorseTranslator(){
		reverseMorse = new LinkedHashMap<String, Character>();

		reverseMorse.put(".-",  'a');
        reverseMorse.put("-...",'b');
        reverseMorse.put("-.-.",'c');
        reverseMorse.put("-..", 'd');
        reverseMorse.put(".",   'e');
        reverseMorse.put("..-.",'f');
        reverseMorse.put("--.", 'g');
        reverseMorse.put("....",'h');
        reverseMorse.put("..",  'i');
        reverseMorse.put(".---",'j');
        reverseMorse.put("-.-", 'k');
        reverseMorse.put(".-..",'l');
        reverseMorse.put("--",  'm');
        reverseMorse.put("-.",  'n');
        reverseMorse.put("---", 'o');
        reverseMorse.put(".--.",'p');
        reverseMorse.put("--.-",'q');
        reverseMorse.put(".-.", 'r');
        reverseMorse.put("...", 's');
        reverseMorse.put("-",   't');
        reverseMorse.put("..-", 'u');
        reverseMorse.put("...-",'v');
        reverseMorse.put(".--", 'w');
        reverseMorse.put("-..-",'x');
        reverseMorse.put("-.--",'y');
        reverseMorse.put("--..",'z');
	}

	@Override
	public Character translate(char[] cs, int fromIndex, int untilIndex) {
		String morse = "";
		for(int i = fromIndex; i < untilIndex; i++){
			morse += cs[i];
		}

		return reverseMorse.getOrDefault(morse, null);
	}
	
	/**Returns the singleton instance of MorseTranslator */
	public static MorseTranslator getInstance(){
		if(instance == null){
			instance = new MorseTranslator();
		}
		return instance;
	}

	/**
	 * Gets a Reader reading from a given file
	 * @param file2read	file to be read from
	 * @return	reader or null if there is a problem
	 */
	public Reader getReader(File file2read){ 
		try {
			return new MorseReader(this, file2read);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets a Reader reading from a given string
	 * @param string2read string to be read from
	 * @return	reader
	 */
	public Reader getReader(String string2read){ return new MorseReader(this, string2read); }





	/**Class for handeling read operations */
	private class MorseReader extends InputStreamReader{
		private Translator translator;
		private boolean bufferedEndOfMorseCodeWord; 

		public MorseReader(Translator translator, File file2read) throws FileNotFoundException{
			super(new FileInputStream(file2read));

			this.translator = translator;
			this.bufferedEndOfMorseCodeWord = false;
		}

		public MorseReader(Translator translator, String string2read){
			super(new ByteArrayInputStream(string2read.getBytes()));

			this.translator = translator;
			this.bufferedEndOfMorseCodeWord = false;
		}

		@Override
		public int read(char[] cbuf, int off, int len) throws IOException {
			if(off < 0 || len < 0 || len > cbuf.length - off)
				throw new IndexOutOfBoundsException();

			if(len == 0)
				return 0;
			
			int readChars = 0;		//index for alphanumeric chars
			int c;					//current char from Stream
			int readMorseChars = 0;	//index for morse chars

			char[] morsebuffer = new char[MAXMORSECHARACTERLENGTH];

			while(readChars < len){
				if(bufferedEndOfMorseCodeWord){			//true if '|' was read before
					cbuf[off + readChars++] = ' ';
					bufferedEndOfMorseCodeWord = false;
					continue;
				}

				while((c = super.read()) != -1){
					if((char)c == ' ')		//end of morse char
						break;

					if((char)c == '|'){		//end of morse word
						bufferedEndOfMorseCodeWord = true;
						break;
					}

					morsebuffer[readMorseChars++] = (char)c;
				};

				if(c == -1 && readMorseChars == 0){			//end of stream
					return readChars == 0 ? -1 : readChars;
				}
				else{
					cbuf[off + readChars++] = translator.translate(morsebuffer, 0, readMorseChars);
					readMorseChars = 0;	//reset index from morsebuffer
				}	
			}

			return readChars == 0 ? -1 : readChars;
		}

		@Override
		public int read() throws IOException {
			char[] buffer = new char[1];

			return this.read(buffer, 0, 1) == -1 ? -1 : buffer[0];
		}

		@Override
		public int read(char[] cbuf) throws IOException {
			return this.read(cbuf, 0, cbuf.length);
		}
	}
}
