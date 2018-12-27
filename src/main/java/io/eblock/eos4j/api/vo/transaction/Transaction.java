package io.eblock.eos4j.api.vo.transaction;


import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class Transaction{

	@SerializedName("transaction_id")
	private String transactionId;

	@SerializedName("processed")
	private Processed processed;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Processed getProcessed() {
		return processed;
	}

	public void setProcessed(Processed processed) {
		this.processed = processed;
	}

}
