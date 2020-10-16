package co.com.testapi.jpa;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public abstract class AdapterOperations<E, D, I, M 
extends SimpleMapper<E, D>, R extends CrudRepository<D, I> & QueryByExampleExecutor<D>> {


    protected R repository;
    private M mapper;

    public AdapterOperations(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    
    public E save(E entity) {
        D data = mapper.toData(entity);
        return mapper.toEntity(saveData(data));
    }

    protected List<E> saveAllEntities(List<E> entities) {
        List<D> list = entities.stream().map(mapper::toData).collect(Collectors.toList());
        return toList(saveData(list));
    }

    public List<E> toList(Iterable<D> iterable) {
        return stream(iterable.spliterator(), false).map(mapper::toEntity).collect(Collectors.toList());
    }

    protected D saveData(D data) {
        return repository.save(data);
    }

    protected Iterable<D> saveData(List<D> data) {
        return repository.saveAll(data);
    }

    public E findById(I id) {
        return mapper.toEntity(repository.findById(id).orElse(null));
    }

    public List<E> findByExample(E entity) {
        return toList(repository.findAll( Example.of(mapper.toData(entity))));
    }


    public List<E> findAll(){
        return toList(repository.findAll());
    }
}