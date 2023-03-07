package decorator;

import java.io.File;
import java.io.Reader;
import java.io.Writer;

/**
 * Main Encoder
 */
public class MRMain implements MREncoding {
	
	@Override
	public Reader getMorseReader(File file2read) {
		return MorseTranslator.getInstance().getReader(file2read);
	}

	@Override
	public Writer getROT13Writer(File file2Write) {
		return ROT13Translator.getInstance().getWriter(file2Write);
	}

	@Override
	public Reader getMorseReader(String string2read) {
		return MorseTranslator.getInstance().getReader(string2read);
	}

	@Override
	public Writer getROT13Writer() {
		return ROT13Translator.getInstance().getWriter();
	}
}
