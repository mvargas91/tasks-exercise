package co.com.testapi.jpa.mapper;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import co.com.testapi.jpa.task.TaskData;
import co.com.testapi.model.Task;

/**
 * class for test task mapper
 * @author milciades.vargas
 *
 */
public class TaskMapperTest {
	
	private static final long NUMBER_ONE = 1;
	
	@InjectMocks
	TaskMapper taskMapper = Mappers.getMapper(TaskMapper.class);
	
	@InjectMocks
	Task model;
	
	@InjectMocks
	TaskData entity;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = Task.builder().id(TaskMapperTest.NUMBER_ONE)
        		.description("description").dateCreation(new Date()).vigente(true)
				.build();
        entity = new TaskData();
        entity.setId(TaskMapperTest.NUMBER_ONE);
        entity.setDescription("description");
        entity.setDateCreation(new Date());
        entity.setVigente(true);
    }
    
    /**
     * Method test for converte model to entity with subModules
     */
    @Test
    public void testMapDtoToEntityWithSubModules() {
    	TaskData taskData = taskMapper.toData(model);
    	Assert.assertEquals(entity.getId(), taskData.getId());
    	Assert.assertEquals(entity.getDescription(), taskData.getDescription());
    	Assert.assertNotNull(model.toString());
    }
    
    /**
     * Method test for converte entity to model with subModules
     */
    @Test
    public void testEntityDtoToDtoWithSubModules() {    	
    	Task task = taskMapper.toEntity(entity);
    	Assert.assertEquals(entity.getId(), task.getId());
    	Assert.assertEquals(entity.getDescription(), task.getDescription());
    	Assert.assertNotNull(entity.toString());
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void entityNull(){
    	Task task = taskMapper.toEntity(null);
    	Assert.assertNull(task);
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void modelNull(){
    	TaskData taskData = taskMapper.toData(null);
    	Assert.assertNull(taskData);
    }
}
