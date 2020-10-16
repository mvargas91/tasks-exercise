package co.com.testapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.testapi.model.gateways.TaskRepository;
import co.com.testapi.usecase.TaskUseCase;

/**
 * class for configurations usecase
 * @author milciades.vargas
 *
 */
@Configuration
public class UseCaseConfig {
	
	/**
	 * Method that configurate the class TaskUseCase
	 * @param model
	 * @param logger
	 * @return TaskUseCase
	 */
	@Bean
	public TaskUseCase createFuncionalidadUseCase(TaskRepository repository) {
		return new TaskUseCase(repository);
	}
}
