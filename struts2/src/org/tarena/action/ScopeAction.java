package org.tarena.action;


//ʹ�ü̳и���BaseAction������API��������
public class ScopeAction extends BaseAction{
	
	public String execute(){
		//��request ,session, application��ֵ
		request.put("msg","request��Ϣ");
		session.put("msg","session��Ϣ");
		application.put("msg","application��Ϣ");
		return "success";//scope.jsp
		
	}

	
}
