package com.aws.global.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.aws.global.common.base.BaseActionSupport;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@ParentPackage("struts-default")
@Namespace("/")
public class LocaleAction extends BaseActionSupport {
	//Actions
	@Action(value="locale", results ={
			@Result(name=ActionSupport.SUCCESS, location="pages/index.jsp"),
	})
	public String execute(){
		return ActionSupport.SUCCESS;
	}
}
