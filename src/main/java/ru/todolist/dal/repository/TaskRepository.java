package ru.todolist.dal.repository;

import ru.todolist.dal.mappers.TaskMappers;
import lombok.RequiredArgsConstructor;
import ru.todolist.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository implements TaskRepsitory {

    private final JdbcTemplate jdbc;
    private TaskMappers taskMappers;

    private static final String TASK_BY_ID = "SELECT * FROM tasks WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM tasks";
    private static final String INSERT = "INSERT INTO tasks(name, description, localDateBegin, localDateEnd, status) " +
            "VALUES(?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE tasks SET name = ?, description = ?, localDateBegin = ?, " +
            "localDateEnd = ?, status = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM tasks WHERE id = ?";


    @Override
    public Task getTaskById(Long id) {
        return jdbc.queryForObject(TASK_BY_ID, taskMappers, id);
    }

    @Override
    public List<Task> getListTasks() {
        return jdbc.query(FIND_ALL, taskMappers);
    }

    @Override
    public void save(Task task) {
        jdbc.update(INSERT, task.getName(), task.getDescription(), task.getLocalDateBegin(),
                task.getLocalDateEnd(), task.getStatus().toString());
    }

    @Override
    public void update(Task task) {
        jdbc.update(UPDATE, task.getName(), task.getDescription(), task.getLocalDateBegin(), task.getLocalDateEnd(),
                task.getStatus().toString(), task.getId());
    }

    @Override
    public void delete(Long id) {
        jdbc.update(DELETE, id);
    }
}
