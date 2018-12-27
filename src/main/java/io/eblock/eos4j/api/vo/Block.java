package io.eblock.eos4j.api.vo;

import java.util.Date;


import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */

public class Block {

	@SerializedName("timestamp")
	private Date timestamp;

	@SerializedName("producer")
	private String producer;

	@SerializedName("confirmed")
	private Long confirmed;

	@SerializedName("previous")
	private String previous;

	@SerializedName("transaction_mroot")
	private String transactionMroot;

	@SerializedName("action_mroot")
	private String actionMroot;

	@SerializedName("schedule_version")
	private String scheduleVersion;

	@SerializedName("id")
	private String id;

	@SerializedName("block_num")
	private Long blockNum;

	@SerializedName("ref_block_prefix")
	private Long refBlockPrefix;

	public Block() {

	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Long getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Long confirmed) {
		this.confirmed = confirmed;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getTransactionMroot() {
		return transactionMroot;
	}

	public void setTransactionMroot(String transactionMroot) {
		this.transactionMroot = transactionMroot;
	}

	public String getActionMroot() {
		return actionMroot;
	}

	public void setActionMroot(String actionMroot) {
		this.actionMroot = actionMroot;
	}

	public String getScheduleVersion() {
		return scheduleVersion;
	}

	public void setScheduleVersion(String scheduleVersion) {
		this.scheduleVersion = scheduleVersion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(Long blockNum) {
		this.blockNum = blockNum;
	}

	public Long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	public void setRefBlockPrefix(Long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

}
