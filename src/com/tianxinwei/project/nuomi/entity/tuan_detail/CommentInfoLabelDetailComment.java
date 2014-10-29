package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

import android.R.integer;

public class CommentInfoLabelDetailComment implements Serializable {
	private static final long serialVersionUID = 6855665366073641817L;
	private String nickname;
	private int score;
	private long update_time;
	private int pic_num;
	private int superior;
	private String content;
	private List<LabelDetailCommentPicUrl> pic_url;
	private List<String> reply;
	private int isuser;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	public int getPic_num() {
		return pic_num;
	}

	public void setPic_num(int pic_num) {
		this.pic_num = pic_num;
	}

	public int getSuperior() {
		return superior;
	}

	public void setSuperior(int superior) {
		this.superior = superior;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<LabelDetailCommentPicUrl> getPic_url() {
		return pic_url;
	}

	public void setPic_url(List<LabelDetailCommentPicUrl> pic_url) {
		this.pic_url = pic_url;
	}

	public List<String> getReply() {
		return reply;
	}

	public void setReply(List<String> reply) {
		this.reply = reply;
	}

	public int getIsuser() {
		return isuser;
	}

	public void setIsuser(int isuser) {
		this.isuser = isuser;
	}

}
