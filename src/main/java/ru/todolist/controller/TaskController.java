package ru.todolist.controller;

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
        taskService.create(task);
    }

    @PutMapping
    public void update(@RequestBody Task newTask){
        checkUpdatedData(newTask);
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
}
