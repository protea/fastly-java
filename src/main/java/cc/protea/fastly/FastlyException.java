package cc.protea.fastly;


import cc.protea.util.http.Response;

public class FastlyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public Response response = null;
	public String errorMessage;
	public String errorCode;

	public FastlyException() {
		super();
	}

	public FastlyException(final Exception e) {
		super(e);
	}

	public FastlyException(final String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public FastlyException(final String errorMessage, Response response) {
		this(errorMessage);
		this.response = response;
	}

	public FastlyException(final Exception e, final Response response) {
		super(e);
		this.response = response;
	}

	public FastlyException(final Exception e, final String errorCode, final String errorMessage) {
		super(e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
