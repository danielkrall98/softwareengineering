//package observer.exception;
package observer;

public class AuthenticationException extends NewsSpreaderException {
	public AuthenticationException(String source) {
		super("Authentication failure: " + source);
	}
}