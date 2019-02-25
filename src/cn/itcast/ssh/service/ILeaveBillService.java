package cn.itcast.ssh.service;

import java.util.List;
import cn.itcast.ssh.domain.LeaveBill;


public interface ILeaveBillService {

	/**    
	 * 查询所有的请假信息
	 */
	List<LeaveBill> findLeaveBillList(Long userId);

	/**
	 * 保存请假申请
	 */
	void saveLeaveBill(LeaveBill leaveBill);
	
	/**
	 * 使用请假单ID，查询请假单的对象
	 */
	LeaveBill findLeaveBillById(Long id);
	
	/**
	 * 使用请假单ID，删除请假单
	 */
	void deleteLeaveBillById(Long id);

}
