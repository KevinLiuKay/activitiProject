package cn.itcast.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.LeaveBill;

public class LeaveBillDaoImpl extends HibernateDaoSupport implements ILeaveBillDao {

	@Override
	public List<LeaveBill> findLeaveBillList(Long userId) {
		String hql = "from LeaveBill o where o.user.id = ?";
		List<LeaveBill> list = this.getHibernateTemplate().find(hql, userId);
		return list;
	}

	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		this.getHibernateTemplate().save(leaveBill);
	}

	@Override
	public LeaveBill findLeaveBillById(Long id) {
		return this.getHibernateTemplate().get(LeaveBill.class, id);
	}

	@Override
	public void updateLeaveBill(LeaveBill leaveBill) {
		this.getHibernateTemplate().update(leaveBill);
	}

	@Override
	public void deleteLeaveBillById(LeaveBill leaveBill) {
		this.getHibernateTemplate().delete(leaveBill);
	}

}
