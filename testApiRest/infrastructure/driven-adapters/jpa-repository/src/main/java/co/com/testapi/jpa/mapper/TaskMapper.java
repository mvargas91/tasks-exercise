package co.com.testapi.jpa.mapper;

import org.mapstruct.Mapper;

import co.com.testapi.jpa.SimpleMapper;
import co.com.testapi.jpa.task.TaskData;
import co.com.testapi.model.Task;

/**
 * class for mapper task
 * @author milciades.vargas
 *
 */
@Mapper(componentModel="spring")
public interface TaskMapper extends SimpleMapper<Task, TaskData>{}
