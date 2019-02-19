package com.boh.demo;

import static org.junit.Assert.*;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class T1 {

	   @Test
	    public void startProcess(){

		   	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	        System.out.println("通过ProcessEngines 来获取流程引擎");
	        //指定执行我们刚才部署的工作流程
	        String processDefiKey="simpleTest";
	        //取运行时服务
	        RuntimeService runtimeService = processEngine.getRuntimeService();
	        //取得流程实例
	        ProcessInstance pi = runtimeService.startProcessInstanceByKey(processDefiKey);//通过流程定义的key 来执行流程
	        System.out.println("流程实例id:"+pi.getId());//流程实例id
	        System.out.println("流程定义id:"+pi.getProcessDefinitionId());//输出流程定义的id
	    }

}
