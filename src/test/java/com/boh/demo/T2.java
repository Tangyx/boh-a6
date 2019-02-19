package com.boh.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class T2 {

	   @Test
	    public void queryTask(){

		   	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	        System.out.println("通过ProcessEngines 来获取流程引擎");
	        
	        
	        HistoryService historyService = processEngine.getHistoryService();
	        List<HistoricDetail> list = historyService.createHistoricDetailQuery().list();
	        if(list != null) {
	        	for(HistoricDetail his:list)
	        	{
	        		System.out.println(his.getId());
	        		System.out.println(his.getTaskId());
	        		System.out.println(his.getTime());
	        	}
	        }
	        List<HistoricActivityInstance> list2 = historyService.createHistoricActivityInstanceQuery().list();
	        if(list2 != null) {
	        	for(HistoricActivityInstance temp:list2) {
	        		System.out.print("历史流程实例任务id:"+temp.getId()+"----");
	                System.out.print("历史流程定义的id:"+temp.getProcessDefinitionId()+"----");
	                System.out.print("历史流程实例任务名称:"+temp.getActivityName()+"----");
	                System.out.println("历史流程实例任务处理人:"+temp.getAssignee());
	        	}
	        }
	    }

}
