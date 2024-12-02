package ru.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.todolist.dal.repository.TaskRepository;
import ru.todolist.dal.repository.TaskRepsitory;
import ru.todolist.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> getListTask(){
        return taskRepository.getListTasks();
    }

    public Task getTaskById(Long id){
        return taskRepository.getTaskById(id);
    }

    public void create(Task task){
        taskRepository.save(task);
    }

    public void update(Task task){
        taskRepository.update(task);
    }

    public void deleteById(Long id){
        taskRepository.delete(id);
    }
}
