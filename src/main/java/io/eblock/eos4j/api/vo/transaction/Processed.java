package io.eblock.eos4j.api.vo.transaction;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class Processed {

	@SerializedName("id")
	private String id;

	@SerializedName("receipt")
	private Receipt receipt;

	@SerializedName("elapsed")
	private Long elapsed;

	@SerializedName("net_usage")
	private Long netUsage;

	@SerializedName("scheduled")
	private Boolean scheduled;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Long getElapsed() {
		return elapsed;
	}

	public void setElapsed(Long elapsed) {
		this.elapsed = elapsed;
	}

	public Long getNetUsage() {
		return netUsage;
	}

	public void setNetUsage(Long netUsage) {
		this.netUsage = netUsage;
	}

	public Boolean getScheduled() {
		return scheduled;
	}

	public void setScheduled(Boolean scheduled) {
		this.scheduled = scheduled;
	}
}
