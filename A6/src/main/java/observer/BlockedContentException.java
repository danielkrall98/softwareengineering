//package observer.exception;
package observer;

public class BlockedContentException extends NewsSpreaderException {
	public BlockedContentException(String source) {
		super("Blocked content: " + source);
	}
}
