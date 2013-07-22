package com.aws.global.common.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Index action class.
 * @author bryan.wong
 */
public class IndexAction extends BaseActionSupport {

	/**
	 * Initial entry point of action class.
	 * @return SUCCESS result string
	 */
	public String execute() {
		log(this.getClass().getName(), "execute", "invoke");
		System.out.println("base IndexAction");
		log(this.getClass().getName(), "execute", "end");
		return ActionSupport.SUCCESS;
	}
}
