package co.com.testapi.model.gateways;

import java.util.List;

import co.com.testapi.model.Task;

/**
 * interfaces for repository of the task
 * @author milciades.vargas
 *
 */
public interface TaskRepository {
	/**
	 * Method for add or update a task
	 * @param task
	 * @return
	 */
	Task save(Task task);
	
	/**
	 * Method for get all tasks
	 * @return List<Task>
	 */
	List<Task> findAll();
	
	/**
	 * Method for get all tasks that status is active
	 * @param task
	 * return List<Task>
	 */
	List<Task> findByExample(Task task);
	
	/**
	 * Method for find task active
	 * @return List<TaskeData>
	 */
	List<Task> getTasksActives();
	
	/**
	 * Method for find task with id
	 * @param id
	 * @return
	 */
	Task findById(Long id);
	
    /**
     * Method for delete task
     * @param id
     */
    void deleteById(Long id);
}
