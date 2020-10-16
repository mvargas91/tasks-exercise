package co.com.testapi.usecase;

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

import co.com.testapi.model.Task;
import co.com.testapi.model.gateways.TaskRepository;

/**
 * class for test task services controller
 * @author milciades.vargas
 *
 */
public class TaskUseCaseTest {
	
	private static final int NUMBER_ZERO = 0;
	private static final long NUMBER_ONE = 1;
    
    @Mock
    TaskRepository repository;
    
	@InjectMocks
	TaskUseCase taskUseCase;
	
	@InjectMocks
	Task model;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        taskUseCase = new TaskUseCase(repository);
        model = Task.builder().id(TaskUseCaseTest.NUMBER_ONE).description("description").vigente(true)
				.build();
    }
    
    /**
	 * Method for add a task
	 */
    @Test
    public void addTaskTest() {
    	Mockito.when(taskUseCase.addTask(model)).thenReturn(model);
        Task objRespuesta = taskUseCase.addTask(model);
        Assert.assertNotNull(objRespuesta.getDescription());
        Assert.assertEquals(model, objRespuesta);
    }
    
    /**
	 * Method for update a task
	 */
    @Test
    public void updateTaskTest() {
    	Mockito.when(taskUseCase.updateTask(model)).thenReturn(model);
        Task objRespuesta = taskUseCase.updateTask(model);
        Assert.assertNotNull(objRespuesta.getDescription());
        Assert.assertEquals(model, objRespuesta);
    }
    
	/**
	 * Method for get all tasks
	 */
    @Test
    public void getTasksTest() {
    	List<Task> list = new ArrayList<>();
    	list.add(model);
    	list.add(model);
		
    	Mockito.when(taskUseCase.getTasks()).thenReturn(list);
        List<Task> objRespuesta = taskUseCase.getTasks();
        Assert.assertNotNull(objRespuesta.get(TaskUseCaseTest.NUMBER_ZERO));
        Assert.assertEquals(list, objRespuesta);
    }
    
	/**
	 * Method for get all tasks that status is active
	 */
    @Test
    public void getTasksActivesTest() {
    	List<Task> list = new ArrayList<>();
    	list.add(model);
    	list.add(model);
		
    	Mockito.when(taskUseCase.getTasksActives()).thenReturn(list);
        List<Task> objRespuesta = taskUseCase.getTasksActives();
        Assert.assertNotNull(objRespuesta.get(TaskUseCaseTest.NUMBER_ZERO));
        Assert.assertEquals(list, objRespuesta);
    }
    
    /**
	 * Method for delete a task
	 */
    @Test
    public void deleteTaskTest() {
    	taskUseCase.deleteTask(NUMBER_ONE);
        verify(repository, times(1)).deleteById(NUMBER_ONE);
    }
}
