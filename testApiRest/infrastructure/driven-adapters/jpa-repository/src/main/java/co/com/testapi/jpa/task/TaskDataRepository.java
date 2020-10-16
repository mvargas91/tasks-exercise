package co.com.testapi.jpa.task;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * class for task data repository
 * @author milciades.vargas
 *
 */
public interface TaskDataRepository extends CrudRepository<TaskData, Long>, QueryByExampleExecutor<TaskData> {
	
	/**
	 * Method for find tasks active
	 * @return List<TaskData>
	 */
	@Query(value = "SELECT * FROM TAREA t WHERE t.TA_VIGENTE is true",
			nativeQuery = true)
	List<TaskData> getTasksActives();
}