package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.aws.global.classes.User;
import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@Action(value="nextPage")
@Results({
	@Result(name=ActionSupport.SUCCESS, location="pages/nextPage.jsp")
})
public class NextPageAction extends BaseActionSupport {
	
	/** Display String: display */
	private String nextPageString;
	
	@Autowired
	@Qualifier("user")
	private User user;

	/**
	 * Initial Entry point of the action class.
	 * @return struts2 success string
	 */
	public String execute() {
		super.log(this.getClass().getName(), "execute", "invoke");
		// TODO : ADD IMPLEMENTATION HERE
		nextPageString = "page 1";
		user.setFirst_name("Juan");
		super.log(this.getClass().getName(), "execute", "end");
		return ActionSupport.SUCCESS;
	}

	public String getNextPageString() {
		return nextPageString;
	}

	public void setNextPageString(String nextPageString) {
		this.nextPageString = nextPageString;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
