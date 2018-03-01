package org.tarena.action;


//使用继承父类BaseAction，降低API的侵入性
public class ScopeAction extends BaseAction{
	
	public String execute(){
		//向request ,session, application存值
		request.put("msg","request信息");
		session.put("msg","session信息");
		application.put("msg","application信息");
		return "success";//scope.jsp
		
	}

	
}
