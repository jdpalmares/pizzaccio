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
@Action(value="submitPage")
@Results({
	@Result(name=ActionSupport.SUCCESS, location="pages/nextPage.jsp")
})
public class SubmitAction extends BaseActionSupport {
	
	@Autowired
	@Qualifier("user")
	private User user;
	
	/**s
	 * Initial entry point of action class.
	 * @return SUCCESS result string
	 */
	public String execute() {
		log(this.getClass().getName(), "execute", "invoke");
		System.out.println("custom SubmitAction");
		log(this.getClass().getName(), "execute", "end");
		return ActionSupport.SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
