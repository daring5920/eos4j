package io.eblock.eos4j.api.vo;

import java.util.Date;


import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */

public class ChainInfo {

	public ChainInfo() {

	}

	@SerializedName("server_version")
	private String serverVersion;

	@SerializedName("chain_id")
	private String chainId;

	@SerializedName("head_block_num")
	private String headBlockNum;

	@SerializedName("last_irreversible_block_num")
	private Long lastIrreversibleBlockNum;

	@SerializedName("last_irreversible_block_id")
	private String lastIrreversibleBlockId;

	@SerializedName("head_block_id")
	private String headBlockId;

	@SerializedName("head_block_time")
	private Date headBlockTime;

	@SerializedName("head_block_producer")
	private String headBlockProducer;

	@SerializedName("virtual_block_cpu_limit")
	private String virtualBlockCpuLimit;

	@SerializedName("virtual_block_net_limit")
	private String virtualBlockNetLimit;

	@SerializedName("block_cpu_limit")
	private String blockCpuLimit;

	@SerializedName("block_net_limit")
	private String blockNetLimit;

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getChainId() {
		return chainId;
	}

	public void setChainId(String chainId) {
		this.chainId = chainId;
	}

	public String getHeadBlockNum() {
		return headBlockNum;
	}

	public void setHeadBlockNum(String headBlockNum) {
		this.headBlockNum = headBlockNum;
	}

	public Long getLastIrreversibleBlockNum() {
		return lastIrreversibleBlockNum;
	}

	public void setLastIrreversibleBlockNum(Long lastIrreversibleBlockNum) {
		this.lastIrreversibleBlockNum = lastIrreversibleBlockNum;
	}

	public String getLastIrreversibleBlockId() {
		return lastIrreversibleBlockId;
	}

	public void setLastIrreversibleBlockId(String lastIrreversibleBlockId) {
		this.lastIrreversibleBlockId = lastIrreversibleBlockId;
	}

	public Date getHeadBlockTime() {
		return headBlockTime;
	}

	public void setHeadBlockTime(Date headBlockTime) {
		this.headBlockTime = headBlockTime;
	}

	public String getHeadBlockProducer() {
		return headBlockProducer;
	}

	public void setHeadBlockProducer(String headBlockProducer) {
		this.headBlockProducer = headBlockProducer;
	}

	public String getVirtualBlockCpuLimit() {
		return virtualBlockCpuLimit;
	}

	public void setVirtualBlockCpuLimit(String virtualBlockCpuLimit) {
		this.virtualBlockCpuLimit = virtualBlockCpuLimit;
	}

	public String getVirtualBlockNetLimit() {
		return virtualBlockNetLimit;
	}

	public void setVirtualBlockNetLimit(String virtualBlockNetLimit) {
		this.virtualBlockNetLimit = virtualBlockNetLimit;
	}

	public String getBlockCpuLimit() {
		return blockCpuLimit;
	}

	public void setBlockCpuLimit(String blockCpuLimit) {
		this.blockCpuLimit = blockCpuLimit;
	}

	public String getBlockNetLimit() {
		return blockNetLimit;
	}

	public void setBlockNetLimit(String blockNetLimit) {
		this.blockNetLimit = blockNetLimit;
	}

	public String getHeadBlockId() {
		return headBlockId;
	}

	public void setHeadBlockId(String headBlockId) {
		this.headBlockId = headBlockId;
	}
}
