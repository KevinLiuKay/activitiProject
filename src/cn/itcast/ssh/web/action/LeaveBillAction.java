package cn.itcast.ssh.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.ssh.domain.Employee;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.SessionContext;
import cn.itcast.ssh.utils.ValueContext;

/**    
 * @Description:跳转到请假单管理的Action
 * @author: liuzk 
 * @date: 2019年2月20日 上午10:35:07     
 */
@SuppressWarnings("serial")
public class LeaveBillAction extends ActionSupport implements ModelDriven<LeaveBill> {

	private LeaveBill leaveBill = new LeaveBill();
	
	@Override
	public LeaveBill getModel() {
		return leaveBill;
	}
	
	private ILeaveBillService leaveBillService;

	public void setLeaveBillService(ILeaveBillService leaveBillService) {
		this.leaveBillService = leaveBillService;
	}

	/**
	 * 请假管理首页显示
	 * @return
	 */
	public String home(){
		//从Session中获取当前用户对象
		Employee employee = SessionContext.get();
		if(employee != null) {
			Long userId = employee.getId();
			//查询当前用户所有的请假信息对应（a_leavebill）表
			List<LeaveBill> leaveBillList = leaveBillService.findLeaveBillList(userId);
			ValueContext.putValueContext("leaveBillList", leaveBillList);
		}else {
			return "login";
		}
		return "home";
	}
	
	/**
	 * 添加请假申请
	 * @return
	 */
	public String input(){
		//1：获取请假单ID
		Long id = leaveBill.getId();
		//修改
		if(id!=null){
			//2：使用请假单ID，查询请假单信息，
			LeaveBill bill = leaveBillService.findLeaveBillById(id);
			//3：将请假单信息放置到栈顶，页面使用struts2的标签，支持表单回显
			ValueContext.putValueStack(bill);
		}
		//新增
		return "input";
	}
	
	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	public String saveLeaveBill() {
		//执行保存
		leaveBillService.saveLeaveBill(leaveBill);
		return "save";
	}
	
	/**
	 * 删除，请假申请
	 * 
	 * */
	public String delete(){
		//1：获取请假单ID
		Long id = leaveBill.getId();
		//执行删除
		leaveBillService.deleteLeaveBillById(id);
		return "save";
	}
	
}
