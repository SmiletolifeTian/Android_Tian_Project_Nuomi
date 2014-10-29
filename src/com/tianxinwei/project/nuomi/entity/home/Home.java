package com.tianxinwei.project.nuomi.entity.home;

import java.io.Serializable;

public class Home implements Serializable{
	private static final long serialVersionUID = -8540704629104071543L;
	private int errno;
	private String errmsg;
	private HomeData data;
	private long timestamp;
	private int cached;
	private int serverstatus;
	private String msg;
	private long serverlogid;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public HomeData getData() {
		return data;
	}

	public void setData(HomeData data) {
		this.data = data;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getCached() {
		return cached;
	}

	public void setCached(int cached) {
		this.cached = cached;
	}

	public int getServerstatus() {
		return serverstatus;
	}

	public void setServerstatus(int serverstatus) {
		this.serverstatus = serverstatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getServerlogid() {
		return serverlogid;
	}

	public void setServerlogid(long serverlogid) {
		this.serverlogid = serverlogid;
	}

}
