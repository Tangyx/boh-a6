package com.boh.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boh.demo.config.DataSourceconfig;

@RestController
@RequestMapping("/first")
public class FirstControl {

	@Autowired
	private DataSourceconfig conf;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private IdentityService identityService;
	
	@RequestMapping("/")
	public String ShowMessage() {
		System.out.println(conf.getDataSource());
		return "Boh is OK";
	}
	
	@RequestMapping("/a6user")
	public UserEntityImpl showUser(HttpServletRequest request) {
		UserEntityImpl user = new UserEntityImpl();
		user.setId(request.getParameter("id"));
		user.setRevision(0);
		identityService.saveUser(user);
		return user;
	}
}
