package co.com.testapi.util;

/**
 * Constant
 * @author milciades.vargas
 */
public final class Constant {
	
	public static final String URL_BASE_SERVICE = "/api";
	public static final String SERVICE_TASK_TAG = "Services to manage tasks";
	
	public static final String URL_GET_TASKS = "/getTasks";
	public static final String GET_TASKS_VALUE = "get all tasks";
	public static final String GET_TASKS_NOTE = "Service for get all tasks";
	
	public static final String URL_ADD_MODULE = "/addTask";
	public static final String ADD_TASK_VALUE = "add a task";
	public static final String ADD_TASK_NOTE = "Service for add a task";
	
	public static final String URL_UPDATE_MODULE = "/updateTask";
	public static final String UPDATE_TASK_VALUE = "update a task";
	public static final String UPDATE_TASK_NOTE = "Service for update a task";
	
	public static final String URL_DELETE_MODULE = "/deleteTask/{id}";
	public static final String DELETE_TASK_VALUE = "delete a task";
	public static final String DELETE_TASK_NOTE = "Service for delete a task";
	
	public static final String MENSAJE_EXITO = "successful operation";
	public static final String MENSAJE_ID_INVALIDO = "ID invalided";
	public static final String PETICION_INVALIDA = "Request invalided";
	
	/**
	 * constructor
	 */
	private Constant() { 
		//ignore constructor
	}
}