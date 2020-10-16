package co.com.testapi.usecase;

import java.util.List;

import co.com.testapi.model.Task;
import co.com.testapi.model.gateways.TaskRepository;
import lombok.RequiredArgsConstructor;

/**
 * class with different methods for the services
 * @author milciades.vargas
 *
 */
@RequiredArgsConstructor
public class TaskUseCase {
	
	private final TaskRepository repository;
	
	
	/**
	 * Method for get all tasks
	 * @return List<Task>
	 */
	public List<Task> getTasks() {
		return repository.findAll();
	}
	
	/**
	 * Method for add a task
	 * @param taskRequest
	 * @return
	 */
	public Task addTask(Task taskRequest) {
		return repository.save(taskRequest);
	}
	
	/**
	 * Method for update a task
	 * @param taskRequest
	 * @return
	 */
	public Task updateTask(Task taskRequest) {
		return repository.save(taskRequest);
	}
	
	/**
	 * Method for delete a task
	 * @param id
	 */
	public void deleteTask(Long id) {
		repository.deleteById(id);
	}
	
	/**
	 * Method for get all tasks that status is active
	 * @return List<Task>
	 */
	public List<Task> getTasksActives() {
		return repository.getTasksActives();
	}
}
