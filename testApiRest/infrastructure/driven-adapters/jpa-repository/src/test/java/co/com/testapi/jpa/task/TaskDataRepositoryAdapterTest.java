package co.com.testapi.jpa.task;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import co.com.testapi.jpa.mapper.TaskMapper;
import co.com.testapi.model.Task;

/**
 * class for test task data repository adapter
 * @author milciades.vargas
 *
 */
public class TaskDataRepositoryAdapterTest {
	
	private static final long NUMBER_ONE = 1;
	
	@Mock
	TaskDataRepository repository;
	
	@Mock
	TaskMapper taskMapper;
	
	@InjectMocks
	TaskDataRepositoryAdapter taskDataRepositoryAdapter;
	
	/**
	 * Method init
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		taskDataRepositoryAdapter = new TaskDataRepositoryAdapter(repository, taskMapper);
	}
	
    /**
     * Method for test constructor
     */
    @Test
    public void constructorTest(){  	
        Assert.assertNotNull(taskDataRepositoryAdapter);
    }
    
	/**
	 * Method for get all tasks that status is active
	 */
    @Test
	public void getModuleActiveAndParentNull() {
		List<TaskData> list = new ArrayList<>();
		List<Task> listModule = new ArrayList<>();
		Mockito.when(repository.getTasksActives()).thenReturn(list);		
		List<Task> listTest = taskDataRepositoryAdapter.getTasksActives();		
		Assert.assertNotNull(listTest);
		Assert.assertEquals(listTest, listModule);
	}
    
    
    /**
	 * Method for delete a task
	 */
    @Test
    public void deleteTaskTest() {
    	repository.deleteById(NUMBER_ONE);
        verify(repository, times(1)).deleteById(NUMBER_ONE);
    }
}
