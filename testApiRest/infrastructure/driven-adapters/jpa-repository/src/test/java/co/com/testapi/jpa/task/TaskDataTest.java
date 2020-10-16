package co.com.testapi.jpa.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/**
 * class for test task data
 * @author milciades.vargas
 *
 */
public class TaskDataTest {
	
	public static final String STRING_TEST = "test";
	public static final String STRING_TEST1 = "test1";
	private static final long NUMBER_ONE = 1;
	
	@InjectMocks
    TaskData model;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new TaskData();
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModelEqualsObject(){
    	TaskData taskTest = Mockito.mock(TaskData.class);
    	Assert.assertFalse(model.equals(taskTest));    	
    	Assert.assertFalse(model.equals(new Object()));
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModel(){    	
    	model.setId(NUMBER_ONE);
    	model.setDescription(STRING_TEST);
    	model.setDateCreation(new Date());
    	model.setVigente(true);
    	
    	TaskData taskTest = new TaskData();
    	taskTest.setId(NUMBER_ONE);
    	taskTest.setDescription(STRING_TEST);
    	taskTest.setDateCreation(new Date());
    	taskTest.setVigente(true);
    	
    	Assert.assertEquals(model, taskTest);
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModelEquals(){
    	TaskData taskTest = new TaskData();
    	
		taskTest.setId(NUMBER_ONE);
		Assert.assertFalse(model.equals(taskTest));
		Assert.assertNotSame(model.hashCode(), taskTest.hashCode());
		
		taskTest.setId(null);
		taskTest.setDescription(STRING_TEST);
		Assert.assertFalse(model.equals(taskTest));
		Assert.assertNotSame(model.hashCode(), taskTest.hashCode());
		
		taskTest.setDescription(null);
		taskTest.setDateCreation(new Date());
		Assert.assertFalse(model.equals(taskTest));
		Assert.assertNotSame(model.hashCode(), taskTest.hashCode());
		
		taskTest.setDateCreation(null);
		taskTest.setVigente(true);
		Assert.assertFalse(model.equals(taskTest));
		Assert.assertNotSame(model.hashCode(), taskTest.hashCode());
    }
    
    /**
     * Method for test object not null
     * @throws ParseException 
     */
    @Test
    public void setModelEqualsWithDifferentValue() throws ParseException{
    	TaskData taskTest = new TaskData();

    	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "31-08-1982 10:20:56";
    	Date date = sdf.parse(dateInString);
    
    	model.setId(NUMBER_ONE+1);
		taskTest.setId(NUMBER_ONE);
		Assert.assertFalse(model.equals(taskTest));
		
		model.setId(NUMBER_ONE);
		model.setDescription(STRING_TEST1);
		taskTest.setDescription(STRING_TEST);
		Assert.assertFalse(model.equals(taskTest));
		
		model.setDescription(STRING_TEST);
		model.setDateCreation(new Date());
		taskTest.setDateCreation(date);
		Assert.assertFalse(model.equals(taskTest));
		
		model.setDateCreation(new Date());
		model.setVigente(false);
		taskTest.setVigente(true);
		Assert.assertFalse(model.equals(taskTest));
    }
}