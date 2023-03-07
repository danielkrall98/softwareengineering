package decorator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Translator with ROT13
 */
public class ROT13Translator implements Translator {
	private static final int LOWERCASEA = (int)'a';
	private static final int LOWERCASEZ = (int)'z';
	private static final int UPPERCASEA = (int)'A';
	private static final int UPPERCASEZ = (int)'Z';

	private static ROT13Translator instance = null;

	private ROT13Translator(){
		
	}

	@Override
	public Character translate(char[] cs, int fromIndex, int untilIndex) {
		char[] ROT13s = new char[cs.length];
		for(int i = fromIndex; i < untilIndex; i++){
			if(LOWERCASEA <= cs[i] && cs[i] <= LOWERCASEZ){
				ROT13s[i] = (char)(LOWERCASEA + ((((int)cs[i] - LOWERCASEA) + 13) % 26));
			}
			else if(UPPERCASEA <= cs[i] && cs[i] <= UPPERCASEZ){
				ROT13s[i] = (char)(UPPERCASEA + ((((int)cs[i] - UPPERCASEA) + 13) % 26));
			}
			else{
				ROT13s[i] = cs[i];
			}
		}

		return ROT13s[fromIndex];	//why give implementation for translation whole array, if there can only be one charater returned?
	}

	/**
	 * Gets the instance of the ROT13Translator
	 * @return	instance of ROT13Translator
	 */
	public static ROT13Translator getInstance(){
		if(instance == null){
			instance = new ROT13Translator();
		}
		return instance;
	}

	/**
	 * Gets a writer writing to a given file
	 * @param file2write file to write to
	 * @return	writer or null if there is a problem
	 */
	public Writer getWriter(File file2write){ 
		try {
			return new MorseWriter(this, file2write);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets a writer writing to the an internal string, being used in Object.tostring()
	 * @return	writer
	 */
	public Writer getWriter(){ return new MorseWriter(this, new StringBuilder()); }
	




	
	/**Class for handeling write operations */
	private class MorseWriter extends OutputStreamWriter{
		private Translator translator;
		private StringBuilder outputString;

		public MorseWriter(Translator translator, File file2Write) throws FileNotFoundException{
			super(new FileOutputStream(file2Write));

			this.translator = translator;
		}

		public MorseWriter(Translator translator, StringBuilder sb){
			super(new StringOutputStream(sb));
			outputString = sb;

			this.translator = translator;
		}

		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			if(off < 0 || len < 0 || len > cbuf.length - off)
				throw new IndexOutOfBoundsException();

			for(int i = off; i < off + len; i++){
				super.write(translator.translate(cbuf, i, i + 1));
			}
			super.flush();	//empties the buffer and writes to destination
		}

		@Override
		public void write(int c) throws IOException {
			this.write(new char[]{(char)c}, 0, 1);
		}

		@Override
		public void write(String str, int off, int len) throws IOException {
			this.write(str.toCharArray(), off, len);
		}

		@Override
		public void write(String str) throws IOException {
			this.write(str.toCharArray(), 0, str.length());
		}

		@Override
		public void write(char[] cbuf) throws IOException {
			this.write(cbuf, 0, cbuf.length);
		}

		@Override
		public String toString(){
			return outputString.toString();
		}
	}



	/**Outputstream with underlying StringBuilder */
	private class StringOutputStream extends OutputStream{
		private StringBuilder sb;

		public StringOutputStream(StringBuilder sb){
			this.sb = sb;
		}

		@Override
		public void write(int b) throws IOException {
			sb.append((char)b);
		}
	}
}
