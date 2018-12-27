package io.eblock.eos4j.api.vo.transaction;


import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */

public class Receipt {

	@SerializedName("status")
	private String status;

	@SerializedName("cpu_usage_us")
	private Long cpuUsageUs;

	@SerializedName("net_usage_words")
	private Long netUsageWords;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCpuUsageUs() {
		return cpuUsageUs;
	}

	public void setCpuUsageUs(Long cpuUsageUs) {
		this.cpuUsageUs = cpuUsageUs;
	}

	public Long getNetUsageWords() {
		return netUsageWords;
	}

	public void setNetUsageWords(Long netUsageWords) {
		this.netUsageWords = netUsageWords;
	}

}
