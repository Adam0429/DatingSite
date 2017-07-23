package info;

import java.sql.Time;

public class bbs {
	private String bbs_id;
	private String bbs_content;
	private String bbs_title;
	private String bbs_time;
	private String login_account;
	public String getBbs_id() {
		return bbs_id;
	}
	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}
	public String getBbs_content() {
		return bbs_content;
	}
	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getBbs_time() {
		return bbs_time;
	}
	public void setBbs_time(String bbs_time) {
		this.bbs_time = bbs_time;
	}
	public String getLogin_account() {
		return login_account;
	}
	public void setLogin_account(String login_account) {
		this.login_account = login_account;
	}
	
}
