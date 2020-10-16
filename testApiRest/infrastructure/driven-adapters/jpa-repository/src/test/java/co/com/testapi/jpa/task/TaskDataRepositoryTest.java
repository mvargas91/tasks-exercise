package co.com.testapi.jpa.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

/**
 * class for test task data respository
 * @author milciades.vargas
 *
 */
public class TaskDataRepositoryTest {
	
	private static final int NUMBER_ZERO = 0;
	private static final long NUMBER_ONE = 1;
	
	@InjectMocks
	TaskData taskData;
	
	@InjectMocks
	TaskDataRepository taskDataRepository;
	
	/**
	 * Method init
	 */
	@Before
	public void setUp() {
		taskDataRepository = Mockito.mock(TaskDataRepository.class);
		taskData = new TaskData();
		taskData.setId(TaskDataRepositoryTest.NUMBER_ONE);
    	taskData.setDescription("description");
    	taskData.setDateCreation(new Date());
    	taskData.setVigente(true);
	}
	
	/**
	 * Method for find task active
	 */
	@Test
	public void getTasksActives(){
		List<TaskData> listTasks = new ArrayList<>();
		listTasks.add(taskData);
		listTasks.add(taskData);

		Mockito.when(taskDataRepository.getTasksActives()).thenReturn(listTasks);
		List<TaskData> listTasksTest = taskDataRepository.getTasksActives();

		Assert.assertSame(listTasksTest, listTasks);
		Assert.assertNotNull(listTasksTest);
		Assert.assertTrue(listTasksTest.get(TaskDataRepositoryTest.NUMBER_ZERO).getVigente());
	}
}
