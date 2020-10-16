package co.com.testapi.model;


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
 * class for test task
 * @author milciades.vargas
 *
 */
public class TaskTest {
	
	public static final String STRING_TEST = "test";
	public static final String STRING_TEST1 = "test1";
	private static final long NUMBER_ONE = 1;
	
	@InjectMocks
    Task model;
	
	/**
	 * Method init
	 */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        model = new Task();
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModelBuild(){
    	model = Task.builder().description(STRING_TEST).build();
    	Task modelTest = model;    	
    	Assert.assertEquals(model, modelTest);
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModelEqualsObject(){
    	Task modelTest = Mockito.mock(Task.class);
    	Assert.assertFalse(model.equals(modelTest));    	
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
    	
    	Task modelTest = new Task();
    	modelTest.setId(NUMBER_ONE);
    	modelTest.setDescription(STRING_TEST);
    	modelTest.setDateCreation(new Date());
    	modelTest.setVigente(true);
    	
    	Assert.assertEquals(model, modelTest);
    }
    
    /**
     * Method for test object not null
     */
    @Test
    public void setModelEquals(){
    	Task modelTest = new Task();
    	
		modelTest.setId(NUMBER_ONE);
		Assert.assertFalse(model.equals(modelTest));
		Assert.assertNotSame(model.hashCode(), modelTest.hashCode());
		
		modelTest.setId(null);
		modelTest.setDescription(STRING_TEST);
		Assert.assertFalse(model.equals(modelTest));
		Assert.assertNotSame(model.hashCode(), modelTest.hashCode());
		
		modelTest.setDescription(null);
		modelTest.setDateCreation(new Date());
		Assert.assertFalse(model.equals(modelTest));
		Assert.assertNotSame(model.hashCode(), modelTest.hashCode());
		
		modelTest.setDateCreation(null);
		modelTest.setVigente(true);
		Assert.assertFalse(model.equals(modelTest));
		Assert.assertNotSame(model.hashCode(), modelTest.hashCode());
    }
    
    /**
     * Method for test object not null
     * @throws ParseException 
     */
    @Test
    public void setModelEqualsWithDifferentValue() throws ParseException{
    	Task modelTest = new Task();
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "31-08-1982 10:20:56";
    	Date date = sdf.parse(dateInString);
    	
    	model.setId(NUMBER_ONE+1);
		modelTest.setId(NUMBER_ONE);
		Assert.assertFalse(model.equals(modelTest));
		
		model.setId(NUMBER_ONE);
		model.setDescription(STRING_TEST1);
		modelTest.setDescription(STRING_TEST);
		Assert.assertFalse(model.equals(modelTest));
		
		model.setDescription(STRING_TEST);
		model.setDateCreation(new Date());
		modelTest.setDateCreation(date);
		Assert.assertFalse(model.equals(modelTest));
		
		model.setDateCreation(new Date());
		model.setVigente(false);
		modelTest.setVigente(true);
		Assert.assertFalse(model.equals(modelTest));
    }
}