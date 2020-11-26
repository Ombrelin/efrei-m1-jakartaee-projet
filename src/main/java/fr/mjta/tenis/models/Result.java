package fr.mjta.tenis.models;

public class Result<T> {
	private boolean successfull;
	private String message;
	private T data;

	public Result(T data) {
		this(true, "", data);
	}

	public Result(boolean successfull, String message) {
		this(successfull, message, null);
	}

	public Result(boolean successfull, String message, T data) {
		this.successfull = successfull;
		this.message = message;
		this.data = data;
	}

	public boolean getSuccessfull() {
		return successfull;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
