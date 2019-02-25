package cn.itcast.ssh.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.web.form.WorkflowBean;

public interface IWorkflowService {
	
	/**
	 * 部署流程定义   
	 */
	void saveNewDeploy(File file, String fileName);
	
	/**
	 * 查询部署对象信息，对应表（act_re_deployment)   
	 */
	List<Deployment> findDeploymentList();
	
	/**
	 * 查询流程定义的信息，对应表（act_re_procdef）
	 */
	List<ProcessDefinition> findProcessDefinitionList();

	/**
	 * 使用部署对象Id和资源图片名称，获取图片输入流
	 */
	InputStream findImageInputStream(String deploymentId, String imageName);

	/**
	 * 使用部署对象ID，删除流程定义
	 */
	void deleteProcessDefinitionByDeploymentId(String deploymentId);
	
	/**
	 * 更新请假状态，启动流程实例，让启动的流程实例关联业务
	 */
	void saveStartProcess(WorkflowBean workflowBean);
	
	/**
	 * 使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
	 */
	List<Task> findTaskListByName(String name);
	
	/**
	 * 使用任务ID，获取当前任务节点中对应的Form key中的连接的值
	 */
	String findTaskFormKeyByTaskId(String taskId);
	/**
	 * 使用任务ID，查找请假单ID，从而获取请假单信息
	 */
	LeaveBill findLeaveBillByTaskId(String taskId);
	
	/**
	 * 使用任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中
	 */
	List<String> findOutComeListByTaskId(String taskId);

	/**
	 * 获取批注信息，传递的是当前任务ID，获取历史任务ID对应的批注
	 */
	List<Comment> findCommentByTaskId(String taskId);

	/**
	 * 指定连线的名称完成任务
	 */
	void saveSubmitTask(WorkflowBean workflowBean);
	
	/**
	 * 使用请假单ID，查询历史批注信息
	 */
	List<Comment> findCommentByLeaveBillId(Long id);
	
	/**
	 * 获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
	 */
	ProcessDefinition findProcessDefinitionByTaskId(String taskId);
	
	/**
	 * 查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中
		 map集合的key：表示坐标x,y,width,height
		 map集合的value：表示坐标对应的值
	 */
	Map<String, Object> findCoordingByTask(String taskId);


}
