package co.com.testapi.jpa;

public interface SimpleMapper<E, D> {
	
	D toData(E entity);
	
	E toEntity(D data);
}