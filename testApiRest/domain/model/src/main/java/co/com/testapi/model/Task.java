package co.com.testapi.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class for recived data of entity
 * @author milciades.vargas
 *
 */
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Task {
	private Long id;
    private String description;
    private Date dateCreation;
    private Boolean vigente;
}
