package com.lm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lm.model.LeavePage;
import com.lm.model.Register;

@Repository
public class LeaveDAO {
	@Autowired
	SessionFactory sf;
	@Transactional
	public int lchk(Register reg){
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("select s.type from Register s where s.rollno='"+reg.getRollno()+"' and s.pwd='"+reg.getPwd()+"'");
		List<String> type = q.list();
		String val = type.get(0);
		System.out.println(val.toString());
		if(val.isEmpty()){
			return 0;
		}
		else if(val.toString().equals("admin")){
			return 1;
		}
		else if(val.toString().equals("staff")){
			return 2;
		}
		else if(val.toString().equals("student")){
			return 3;
		}
		return 0;
	}
	@Transactional
	public void add(Register reg){
		Session s = sf.getCurrentSession();
		s.save(reg);
	}
	@Transactional
	public void remove(String name){
		Session s = sf.getCurrentSession();
		Query q = s.createQuery("delete from Register r where r.rollno='"+name+"'");
		q.executeUpdate();
	}
	@Transactional
	public void leave(LeavePage lp,String rollno){
		lp.setRollno(rollno);
		Session s = sf.getCurrentSession();
		s.save(lp);
	}
}
