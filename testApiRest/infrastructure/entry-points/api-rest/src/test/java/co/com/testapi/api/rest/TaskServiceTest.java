package co.com.testapi.api.rest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.testapi.model.Task;
import co.com.testapi.model.gateways.TaskRepository;
import co.com.testapi.usecase.TaskUseCase;

/**
 * class for test task services controller
 * @author milciades.vargas
 *
 */
public class TaskServiceTest {

	private static final int NUMBER_ZERO = 0;
	private static final long NUMBER_ONE = 1;
    
    @Mock
    TaskRepository repository;
    
	@InjectMocks
	TaskUseCase taskUseCase;
	
	@InjectMocks
	TaskService service;
	
	@InjectMocks
	Task task;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        taskUseCase = new TaskUseCase(repository);
        service = new TaskService(taskUseCase);
        task = Task.builder().id(TaskServiceTest.NUMBER_ONE).description("description")
        		.dateCreation(new Date()).vigente(true).build();
    }
    
    /**
     * Method for test constructor
     */
    @Test
    public void constructorTest(){  	
        Assert.assertNotNull(service);
    }
    
    /**
	 * Method for add a task
	 * @param taskRequest
	 * @return Module
	 */
    @Test
    public void addTaskTest() {
    	Mockito.when(taskUseCase.addTask(task)).thenReturn(task);
        ResponseEntity<Task> objRespuesta = service.addTask(task);
        Assert.assertNotNull(objRespuesta.getBody().getDescription());
        Assert.assertEquals(HttpStatus.CREATED, objRespuesta.getStatusCode());
    }
    
    /**
	 * Method for update a task
	 * @param taskRequest
	 * @return Module
	 */
    @Test
    public void updateTaskTest() {
    	Mockito.when(taskUseCase.updateTask(task)).thenReturn(task);
        ResponseEntity<Task> objRespuesta = service.updateTask(task);
        Assert.assertNotNull(objRespuesta.getBody().getDescription());
        Assert.assertEquals(HttpStatus.OK, objRespuesta.getStatusCode());
    }
    
	/**
	 * Method for get all tasks
	 * @return List<Task>
	 */
    @Test
    public void getTasksTest() {
    	List<Task> list = new ArrayList<>();
    	list.add(task);
    	list.add(task);
		
    	Mockito.when(taskUseCase.getTasks()).thenReturn(list);
        ResponseEntity<List<Task>> objRespuesta = service.getTasks();
        Assert.assertNotNull(objRespuesta.getBody().get(TaskServiceTest.NUMBER_ZERO));
        Assert.assertEquals(HttpStatus.OK, objRespuesta.getStatusCode());
    }
    
    /**
	 * Method for delete a task
	 */
    @Test
    public void deleteTaskTest() {
    	service.deleteTask(NUMBER_ONE);
        verify(repository, times(1)).deleteById(NUMBER_ONE);
    }
}
