package io.eblock.eos4j.api.vo.account;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */

public class Permission {

	public Permission() {

	}

	@SerializedName("perm_name")
	private String permName;

	@SerializedName("parent")
	private String parent;

	@SerializedName("required_auth")
	private RequiredAuth requiredAuth;

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public RequiredAuth getRequiredAuth() {
		return requiredAuth;
	}

	public void setRequiredAuth(RequiredAuth requiredAuth) {
		this.requiredAuth = requiredAuth;
	}
}
