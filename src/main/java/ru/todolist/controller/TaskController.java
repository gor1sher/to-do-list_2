package ru.todolist.controller;

import org.apache.catalina.User;
import ru.todolist.exception.ConditionsNotMetException;
import ru.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.todolist.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getListTask(){
        return taskService.getListTask();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public void create(@RequestBody Task task){
        validateObjectCriteria(task);
        taskService.create(task);
    }

    @PutMapping
    public void update(@RequestBody Task newTask){
        checkUpdatedData(newTask);
        validateObjectCriteria(newTask);
        taskService.update(newTask);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        taskService.deleteById(id);
    }

    private void checkUpdatedData(Task task){
        Task oldTask = taskService.getTaskById(task.getId());
        if (oldTask == null) {
            throw new ConditionsNotMetException("Такой задачи нет в базе.");
        }
    }

    private void validateObjectCriteria(Task task) {
        if ((task.getDescription().length() > 200) && task.getName().length() > 100) {

            throw new ConditionsNotMetException("Не выполнены условия для регистрации задачи в приложении");
        }
    }
}
