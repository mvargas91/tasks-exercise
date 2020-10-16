package co.com.testapi.jpa.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.testapi.jpa.AdapterOperations;
import co.com.testapi.jpa.mapper.TaskMapper;
import co.com.testapi.model.Task;
import co.com.testapi.model.gateways.TaskRepository;

/**
 * class adapter repository 
 * @author milciades.vargas
 *
 */
@Repository
public class TaskDataRepositoryAdapter 
extends AdapterOperations<Task, TaskData, Long, TaskMapper, TaskDataRepository>
implements TaskRepository {
	
	/**
	 * Constructor
	 * @param repository
	 * @param mapper
	 */
	@Autowired
	public TaskDataRepositoryAdapter(TaskDataRepository repository, TaskMapper mapper) {
		super(repository, mapper);
	}
	
	/**
	 * Method for get all tasks that status is active
	 * @return List<Task>
	 */
	@Override
	public List<Task> getTasksActives() {
		List<TaskData> list = repository.getTasksActives();
		return super.toList(list);
	}
	
	/**
	 * Method for delete by id
	 * @param id
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);		
	}
}