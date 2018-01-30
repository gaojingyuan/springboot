import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationConfig.xml")
public class ActivitiSpringTest {

    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService historyService;
    @Autowired
    private TaskService managementService;

    @Test
    public void deploy() {
//        Deployment deployment = repositoryService.createDeployment().name("MyProcess")
//                .addClasspathResource("diagrams/MyProcess.bpmn").addClasspathResource("diagrams/MyProcess.png")
//                .deploy();

        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess");
        System.out.println("流程实例" + pi.getId());

        List<Task> list = taskService.createTaskQuery().taskAssignee("张三").list();
        System.out.println("任务个数" + list.size());
        if (list != null && list.size() > 0) {
            for (Task t : list) {
                System.out.print(t.getId() + ",");
                System.out.print(t.getName() + ",");
                System.out.print(t.getAssignee() + ",");
                System.out.println(t.getProcessInstanceId());
            }
        }
    }

}
