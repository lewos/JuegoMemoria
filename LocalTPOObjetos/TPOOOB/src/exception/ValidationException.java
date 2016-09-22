package exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -9119579154105548426L;
	private String errMsg;

	public ValidationException(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String getMessage() {
		return this.errMsg;
	}

}
