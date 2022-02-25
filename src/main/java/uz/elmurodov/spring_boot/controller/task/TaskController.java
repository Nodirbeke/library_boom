package uz.elmurodov.spring_boot.controller.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.elmurodov.spring_boot.controller.base.AbstractController;
import uz.elmurodov.spring_boot.criteria.GenericCriteria;
import uz.elmurodov.spring_boot.dto.task.TaskCreateDto;
import uz.elmurodov.spring_boot.entity.base.AuditAwareImpl;
import uz.elmurodov.spring_boot.services.task.TaskService;
import uz.elmurodov.spring_boot.services.task.TaskServiceImpl;
import uz.elmurodov.spring_boot.utils.checks.BaseCheck;

/**
 * @author Axmadjonov Eliboy, Thu 3:36 PM,2/24/2022
 */
@Controller
@RequestMapping("/task/*")
public class TaskController extends AbstractController<TaskServiceImpl> {

    private final BaseCheck check;

    @Autowired
    public TaskController(TaskServiceImpl taskService, BaseCheck check) {
        super(taskService);
        this.check = check;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String taskList(@PathVariable(name = "column_id") Long id) {
        service.getAll(id);
        return "index/index3";
    }

    @RequestMapping(value = "create/{project_id}/", method = RequestMethod.GET)
    public String createPage() {
        if (!check.hasPermission("TASK_CREATE")) {
            return "error";
        }
        return "task/create";
    }

    @RequestMapping(value = "create/{project_id}/", method = RequestMethod.POST)
    public String create(@ModelAttribute TaskCreateDto dto, @PathVariable(name = "project_id") Long id) {
        dto.setProjectId(id);
        service.create(dto);
        return "redirect:task/list";
    }

    @RequestMapping(value = "delete/{task_id}/", method = RequestMethod.GET)
    public String deletePage(){
        return "task/delete";
    }

    @RequestMapping(value = "delete/{task_id}/", method = RequestMethod.POST)
    public String delete(@PathVariable(name = "task_id") Long id){
        service.delete(id);
        return "redirect:task/list";
    }

    @RequestMapping(value = "changePriority/{task_id}/", method = RequestMethod.POST)
    public String changePriority(String priority, @PathVariable(name = "task_id") Long id){
        service.changePriority(id, priority);
        return "redirect:task/list";
    }









}
