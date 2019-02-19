package com.boh.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BohA6ApplicationTests {

	  @Test
	    public void deploy() {

		  	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	        System.out.println("通过ProcessEngines 来获取流程引擎");
	        //获取仓库服务 ：管理流程定义
	        RepositoryService repositoryService = processEngine.getRepositoryService();
	        Deployment deploy = repositoryService.createDeployment()//创建一个部署的构建器
	                .addClasspathResource("processes/MyProcess.bpmn")//从类路径中添加资源,一次只能添加一个资源
	                .name("请求单流程")//设置部署的名称
	                .category("办公类别")//设置部署的类别
	                .deploy();
	        System.out.println("部署的id"+deploy.getId());
	        System.out.println("部署的名称"+deploy.getName());
	    }

}
