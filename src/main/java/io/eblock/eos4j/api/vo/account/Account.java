package io.eblock.eos4j.api.vo.account;

import java.util.Date;
import java.util.List;


import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */

public class Account {

	@SerializedName("account_name")
	private String accountName;

	@SerializedName("privileged")
	private String privileged;

	@SerializedName("last_code_update")
	private Date lastCodeUpdate;

	@SerializedName("created")
	private Date created;

	@SerializedName("ram_quota")
	private Long ramQuota;

	@SerializedName("net_weight")
	private Long netWeight;

	@SerializedName("cpu_weight")
	private Long cpuWeight;

	@SerializedName("net_limit")
	private NetLimit netLimit;

	@SerializedName("cpu_limit")
	private CpuLimit cpuLimit;

	@SerializedName("ram_usage")
	private Long ramUsage;

	@SerializedName("permissions")
	private List<Permission> permissions;

	public Account() {

	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPrivileged() {
		return privileged;
	}

	public void setPrivileged(String privileged) {
		this.privileged = privileged;
	}

	public Date getLastCodeUpdate() {
		return lastCodeUpdate;
	}

	public void setLastCodeUpdate(Date lastCodeUpdate) {
		this.lastCodeUpdate = lastCodeUpdate;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Long getRamQuota() {
		return ramQuota;
	}

	public void setRamQuota(Long ramQuota) {
		this.ramQuota = ramQuota;
	}

	public Long getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(Long netWeight) {
		this.netWeight = netWeight;
	}

	public Long getCpuWeight() {
		return cpuWeight;
	}

	public void setCpuWeight(Long cpuWeight) {
		this.cpuWeight = cpuWeight;
	}

	public NetLimit getNetLimit() {
		return netLimit;
	}

	public void setNetLimit(NetLimit netLimit) {
		this.netLimit = netLimit;
	}

	public CpuLimit getCpuLimit() {
		return cpuLimit;
	}

	public void setCpuLimit(CpuLimit cpuLimit) {
		this.cpuLimit = cpuLimit;
	}

	public Long getRamUsage() {
		return ramUsage;
	}

	public void setRamUsage(Long ramUsage) {
		this.ramUsage = ramUsage;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
