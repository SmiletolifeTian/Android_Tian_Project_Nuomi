package com.tianxinwei.project.nuomi.entity.tuan_like;

import java.io.Serializable;

public class TuanLike implements Serializable {
	private static final long serialVersionUID = -9196463091139718351L;
	private int errno;
	private String errmsg;
	private TuanLikeData data;
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

	public TuanLikeData getData() {
		return data;
	}

	public void setData(TuanLikeData data) {
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
