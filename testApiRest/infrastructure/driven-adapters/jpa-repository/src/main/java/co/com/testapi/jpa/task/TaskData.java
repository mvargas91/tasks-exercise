package co.com.testapi.jpa.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * class for entity
 * @author milciades.vargas
 *
 */
@Data
@Entity
@Table(name = "TAREA")
@NoArgsConstructor
public class TaskData {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TA_ID", nullable = false)
    private Long id;
    
    @Column(name = "TA_DESCRIPCION", nullable = false)
    private String description;
    
    @UpdateTimestamp
    @Column(name = "TA_DATE_CREATE", nullable = false)
    private Date dateCreation;
    
    @Column(name = "TA_VIGENTE", columnDefinition="tinyint(1) default 1")
    private Boolean vigente;

}
