package com.boh.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class T4 {

	   @Test
	    public void queryTask(){

		   	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	        System.out.println("通过ProcessEngines 来获取流程引擎");
	        
	        TaskService taskService = processEngine.getTaskService();
	        TaskQuery query = taskService.createTaskQuery();
	        List<Task> list = query.list();
	        if(list!=null&&list.size()>0){
	            for(Task task:list){
	            	System.out.println("需要结束任务的ID："+task.getId());
	                taskService.complete(task.getId());
	            }
	        }
	        
	    }

}
