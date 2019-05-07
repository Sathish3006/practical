package com.lm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lm.dao.LeaveDAO;
import com.lm.model.LeavePage;
import com.lm.model.Register;

@Controller
public class Leavecontroller {
	@Autowired
	LeaveDAO ldao;
	@Autowired
	HttpSession sess;
	@RequestMapping(value="/")
	public String login(){
		return "login";
	}
	@RequestMapping(value="/loginchk",method=RequestMethod.GET)
	public String home(@ModelAttribute Register reg){
		if(ldao.lchk(reg)==1){
			sess.setAttribute("user",reg.getRollno());
			return "admin";
		}
		else if(ldao.lchk(reg)==2){
			sess.setAttribute("user",reg.getRollno());
			return "staff";
		}
		else if(ldao.lchk(reg)==3){
			sess.setAttribute("user",reg.getRollno());
			return "student";
		}
		else{
			return "login";
		}
	}
	@RequestMapping(value="/deleteuser",method=RequestMethod.GET)
	public String delete(){
		return "admindelete";
	}
	@RequestMapping(value="/adduser",method=RequestMethod.GET)
	public String add(){
		return "adminadd";
	}
	@RequestMapping(value="/adminadd",method=RequestMethod.GET)
	public String adminadd(@ModelAttribute Register reg){
		ldao.add(reg);
		return "admin";
	}
	@RequestMapping(value="/admindelete",method=RequestMethod.GET)
	public String admindel(@ModelAttribute Register reg){
		ldao.remove(reg.getRollno());
		return "admin";
	}
	@RequestMapping(value="/leavetaken",method=RequestMethod.GET)
	public String leave(@ModelAttribute LeavePage lp){
		ldao.leave(lp,sess.getAttribute("user").toString());
		sess.invalidate();
		return "student";
	}
}
