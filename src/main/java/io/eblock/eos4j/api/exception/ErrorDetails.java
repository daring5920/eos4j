package io.eblock.eos4j.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class ErrorDetails {

	private String message;

	private String file;

	private Integer lineNumber;

	private String method;

	private ErrorDetails() {

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Integer getLineNumber() {
		return lineNumber;
	}

	@SerializedName("line_number")
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "ErrorDetails{" +
				"message='" + message + '\'' +
				", file='" + file + '\'' +
				", lineNumber=" + lineNumber +
				", method='" + method + '\'' +
				'}';
	}
}
