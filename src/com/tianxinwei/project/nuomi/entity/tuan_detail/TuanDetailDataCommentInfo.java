package com.tianxinwei.project.nuomi.entity.tuan_detail;

import java.io.Serializable;
import java.util.List;

import android.R.integer;

public class TuanDetailDataCommentInfo implements Serializable{
	private static final long serialVersionUID = 4163529397548534779L;
	private double average_score;
	private int user_num;
	private int pic_comment_num;
	private List<String> user_comment;
	private List<CommentInfoExpressionLabel> expression_label;
	private String average_score_display;
	private List<CommentInfoLabelDetailComment> label_detail_comment;
	private int comment;

	public double getAverage_score() {
		return average_score;
	}

	public void setAverage_score(double average_score) {
		this.average_score = average_score;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public int getPic_comment_num() {
		return pic_comment_num;
	}

	public void setPic_comment_num(int pic_comment_num) {
		this.pic_comment_num = pic_comment_num;
	}

	public List<String> getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(List<String> user_comment) {
		this.user_comment = user_comment;
	}

	public List<CommentInfoExpressionLabel> getExpression_label() {
		return expression_label;
	}

	public void setExpression_label(
			List<CommentInfoExpressionLabel> expression_label) {
		this.expression_label = expression_label;
	}

	public String getAverage_score_display() {
		return average_score_display;
	}

	public void setAverage_score_display(String average_score_display) {
		this.average_score_display = average_score_display;
	}

	public List<CommentInfoLabelDetailComment> getLabel_detail_comment() {
		return label_detail_comment;
	}

	public void setLabel_detail_comment(
			List<CommentInfoLabelDetailComment> label_detail_comment) {
		this.label_detail_comment = label_detail_comment;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

}
