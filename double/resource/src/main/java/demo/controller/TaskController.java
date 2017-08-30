package demo.controller;

import demo.domain.Task;
import demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * Created by William Campoli on 2017-08-22.
 */
@RestController
public class TaskController {

    private String messageDefault = "Hello World";
    private String assignedToDefault = "Generic User";

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Task home() {
        return new Task(messageDefault, assignedToDefault);
    }

    @RequestMapping(value = "/changes", method = RequestMethod.GET)
    public List<Task> changes()  {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "my-tasks", method = RequestMethod.GET)
    public List<Task> myTasks(Principal principal){ return taskRepository.findByAssignedTo(principal.getName()); }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Task update(@RequestBody Task map, Principal principal) {
        String assignedTo = "";
        String message = "";
        if (map.getContent() != null) {
            message = map.getContent();
            assignedTo = map.getAssignedTo();
            taskRepository.save(new Task(principal.getName(), message, assignedTo));
        }
        return new Task(message, assignedTo);
    }
}
