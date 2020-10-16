DROP TABLE IF EXISTS TAREA;
 
CREATE TABLE TAREA (
  TA_ID INT AUTO_INCREMENT  PRIMARY KEY,
  TA_DESCRIPCION VARCHAR(250) NOT NULL,
  TA_DATE_CREATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  TA_VIGENTE BOOLEAN NOT NULL DEFAULT FALSE
);

insert into TAREA (TA_ID,TA_DESCRIPCION)values(1, 'Tarea 1');
insert into TAREA (TA_ID,TA_DESCRIPCION)values(2, 'Tarea 2');