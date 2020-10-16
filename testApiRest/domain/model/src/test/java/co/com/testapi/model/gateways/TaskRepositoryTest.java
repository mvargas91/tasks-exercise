package co.com.testapi.model.gateways;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import co.com.testapi.model.Task;

/**
 * class for test task respository
 * @author milciades.vargas
 *
 */
public class TaskRepositoryTest {

	private static final int NUMBER_ZERO = 0;
	private static final long NUMBER_ONE = 1;
	
	@InjectMocks
	Task task;

	@InjectMocks
	TaskRepository repository;
	
	/**
	 * Method init
	 */
	@Before
	public void setUp() {
		repository = Mockito.mock(TaskRepository.class);
		task = Task.builder().id(TaskRepositoryTest.NUMBER_ONE).description("description").vigente(true)
				.build();
	}
	
	/**
	 * Method for add or update a task
	 */
	@Test
	public void saveTest(){
		Mockito.when(repository.save(task)).thenReturn(task);
		Task taskTest = repository.save(task);

		Assert.assertSame(taskTest, task);
		Assert.assertNotNull(taskTest);
	}
	
	/**
	 * Method for get all tasks
	 */
	@Test
	public void findAllTest(){
		List<Task> listModule = new ArrayList<>();
		listModule.add(task);
		listModule.add(task);

		Mockito.when(repository.findAll()).thenReturn(listModule);
		List<Task> listModuleTest = repository.findAll();

		Assert.assertSame(listModuleTest, listModule);
		Assert.assertNotNull(listModuleTest);
	}
	
	/**
	 * Method for get all tasks that status is active
	 */
	@Test
	public void findByExampleTest(){
		List<Task> listModule = new ArrayList<>();
		listModule.add(task);
		listModule.add(task);

		Mockito.when(repository.findByExample(task)).thenReturn(listModule);
		List<Task> listModuleTest = repository.findByExample(task);

		Assert.assertSame(listModuleTest, listModule);
		Assert.assertNotNull(listModuleTest);
		Assert.assertTrue(listModuleTest.get(TaskRepositoryTest.NUMBER_ZERO).getVigente());
	}
	
	/**
	 * Method for find task active and parent Null
	 */
	@Test
	public void getTasksActivesTest(){
		List<Task> listModule = new ArrayList<>();
		listModule.add(task);
		listModule.add(task);

		Mockito.when(repository.getTasksActives()).thenReturn(listModule);
		List<Task> listModuleTest = repository.getTasksActives();

		Assert.assertSame(listModuleTest, listModule);
		Assert.assertNotNull(listModuleTest);
		Assert.assertTrue(listModuleTest.get(TaskRepositoryTest.NUMBER_ZERO).getVigente());
	}
	
	/**
	 * Method for find task with id
	 */
	@Test
	public void findByIdTest(){
		Mockito.when(repository.findById(TaskRepositoryTest.NUMBER_ONE)).thenReturn(task);
		Task taskTest = repository.findById(TaskRepositoryTest.NUMBER_ONE);

		Assert.assertSame(taskTest, task);
		Assert.assertNotNull(taskTest);
	}
}