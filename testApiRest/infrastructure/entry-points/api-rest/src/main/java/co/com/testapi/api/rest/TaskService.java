package co.com.testapi.api.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.testapi.model.Task;
import co.com.testapi.usecase.TaskUseCase;
import co.com.testapi.util.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

/**
 * controller containing the main methods of a task
 * @author milciades.vargas
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = Constant.URL_BASE_SERVICE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Api(tags = Constant.SERVICE_TASK_TAG)
public class TaskService {
	
	private final TaskUseCase taskUseCase;
	
	/**
	 * Method for get all tasks
	 * @return List<task>
	 */
	@ApiOperation(value = Constant.GET_TASKS_VALUE, notes = Constant.GET_TASKS_NOTE)
	@ApiResponses({ 
		@ApiResponse(code = 200, message = Constant.MENSAJE_EXITO, response = List.class),
		@ApiResponse(code = 400, message = Constant.MENSAJE_ID_INVALIDO, response = ResponseEntity.class) })
	@GetMapping(Constant.URL_GET_TASKS)
	public ResponseEntity<List<Task>> getTasks() {
		return new ResponseEntity<>(taskUseCase.getTasks(), HttpStatus.OK);
	}
	
	
	/**
	 * Method for add a task
	 * @param taskRequest
	 * @return task
	 */
	@ApiOperation(value = Constant.ADD_TASK_VALUE, notes = Constant.ADD_TASK_NOTE,
		response = Task.class, responseContainer = "tasks")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = Constant.MENSAJE_EXITO, response = Task.class),
		@ApiResponse(code = 400, message = Constant.MENSAJE_ID_INVALIDO) })
	@PostMapping(value = Constant.URL_ADD_MODULE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> addTask(@RequestBody Task taskRequest) {
		return new ResponseEntity<>(taskUseCase.addTask(taskRequest), HttpStatus.CREATED);
	}
	
	/**
	 * Method for update a task
	 * @param taskRequest
	 * @return task
	 */
	@ApiOperation(value = Constant.UPDATE_TASK_VALUE, notes = Constant.UPDATE_TASK_NOTE,
		response = Task.class, responseContainer = "tasks")
	@ApiResponses({ 
		@ApiResponse(code = 201, message = Constant.MENSAJE_EXITO, response = Task.class),
		@ApiResponse(code = 400, message = Constant.MENSAJE_ID_INVALIDO) })
	@PutMapping(value = Constant.URL_UPDATE_MODULE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> updateTask(@RequestBody Task taskRequest) {
		return new ResponseEntity<>(taskUseCase.updateTask(taskRequest), HttpStatus.OK);
	}
	
	/**
	 * Method for delete a task
	 * @param id
	 */
	@ApiOperation(value = Constant.DELETE_TASK_VALUE, notes = Constant.DELETE_TASK_NOTE)
	@ApiResponses({ @ApiResponse(code = 200, message = Constant.MENSAJE_EXITO, response = ResponseEntity.class),
			@ApiResponse(code = 400, message = Constant.MENSAJE_ID_INVALIDO) })
	@DeleteMapping(Constant.URL_DELETE_MODULE)
	public void deleteTask(@PathVariable Long id) {
		taskUseCase.deleteTask(id);
	}
}