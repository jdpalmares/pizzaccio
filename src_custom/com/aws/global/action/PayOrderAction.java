package com.aws.global.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;

import com.aws.global.common.base.BaseActionSupport;

@SuppressWarnings("serial")
@Namespace("/")
public class PayOrderAction extends BaseActionSupport{
	List<Integer> orderId;
}




