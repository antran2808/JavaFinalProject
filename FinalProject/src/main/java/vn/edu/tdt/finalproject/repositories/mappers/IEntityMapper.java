package vn.edu.tdt.finalproject.repositories.mappers;

public interface IEntityMapper<V, K> {

    V convertEntity(K entity) throws Exception;

    K convertEntityDTO(V entity) throws Exception;
}
