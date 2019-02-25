package cn.itcast.ssh.dao;

import java.util.List;

import cn.itcast.ssh.domain.LeaveBill;

public interface ILeaveBillDao {

	/**   
	 * 查询当前用户所有的请假信息 
	 */
	List<LeaveBill> findLeaveBillList(Long userId);
	
	/**
	 * 新增请假申请
	 */
	void saveLeaveBill(LeaveBill leaveBill);
	
	/**
	 * 使用请假单ID，查询请假单的对象
	 */
	LeaveBill findLeaveBillById(Long id);

	/**
	 * 更新请假申请
	 */
	void updateLeaveBill(LeaveBill leaveBill);
	
	/**
	 * 使用请假单对象，删除请假单
	 */
	void deleteLeaveBillById(LeaveBill leaveBill);


}
