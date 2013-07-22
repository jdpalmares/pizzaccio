package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
@Action(value="index")
@Results({
	@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp"),
})
public class IndexAction extends BaseActionSupport {

	/** Display String: display */
	private String displayString;

	/**
	 * Initial Entry point of the action class.
	 * @return struts2 success string
	 */
	public String execute() {
		super.log(this.getClass().getName(), "execute", "invoke");
		// TODO : ADD IMPLEMENTATION HERE
		System.out.println("custom IndexAction");
		super.log(this.getClass().getName(), "execute", "end");
		return ActionSupport.SUCCESS;
	}

	/**
	 * @return the displayString
	 */
	public String getDisplayString() {
		return displayString;
	}

	/**
	 * @param displayString the displayString to set
	 */
	public void setDisplayString(String displayString) {
		this.displayString = displayString;
	}
}
