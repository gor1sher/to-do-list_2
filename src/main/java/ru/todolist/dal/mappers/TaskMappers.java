package ru.todolist.dal.mappers;

import ru.todolist.model.Status;
import ru.todolist.model.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskMappers implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();

        task.setId(rs.getLong("id"));
        task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
        task.setLocalDateBegin(rs.getTimestamp("localDateBegin").toLocalDateTime());
        task.setLocalDateEnd(rs.getTimestamp("localDateEnd").toLocalDateTime());
        task.setStatus(Status.valueOf(rs.getString("status")));

        return task;
    }
}
