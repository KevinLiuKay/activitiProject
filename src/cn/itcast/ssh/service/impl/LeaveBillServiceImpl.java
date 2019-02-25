package cn.itcast.ssh.service.impl;

import java.util.List;

import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.Employee;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.SessionContext;

public class LeaveBillServiceImpl implements ILeaveBillService {

	private ILeaveBillDao leaveBillDao;

	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}

	@Override
	public List<LeaveBill> findLeaveBillList(Long userId) {
		List<LeaveBill> list = leaveBillDao.findLeaveBillList(userId);
		return list;
	}

	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		//获取请假单Id
		Long id = leaveBill.getId();
		//从Session中获取当前用户对象
		Employee employee = SessionContext.get();
		if(employee != null) {
			leaveBill.setUser(employee);
		}
		/**新增*/
		if(id == null) {
			leaveBillDao.saveLeaveBill(leaveBill);
		}else {/**更新*/
			leaveBillDao.updateLeaveBill(leaveBill);
		}
		
	}

	@Override
	public LeaveBill findLeaveBillById(Long id) {
		LeaveBill bill = leaveBillDao.findLeaveBillById(id);
		return bill;
	}

	@Override
	public void deleteLeaveBillById(Long id) {
		LeaveBill leaveBill = findLeaveBillById(id);
		leaveBillDao.deleteLeaveBillById(leaveBill);
	}

}
