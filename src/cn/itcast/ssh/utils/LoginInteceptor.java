package cn.itcast.ssh.utils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import cn.itcast.ssh.domain.Employee;


/**
 * 登录验证拦截器
 *
 */
@SuppressWarnings("serial")
public class LoginInteceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**   
	 * <p>Description: 每次访问Action类之前，先执行Interceptor</p>   
	 * @param invocation
	 * @return
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//获取当前访问Action的URL
		String actionName = invocation.getProxy().getActionName();
		//如果当前访问的Action的URL是loginAction_login表示此时还没有session，需要放行
		if(!"loginAction_login".equals(actionName)) {
			//从Session中获取当前用户对象
			Employee employee = SessionContext.get();
			//如果Session不存在，直接跳转到登录页面
			if(employee == null) {
				return "login";
			}	
		}
		//放行，可以访问Action类
		return invocation.invoke();
		
	}

}
