package vn.edu.tdt.finalproject.repositories;

import java.util.List;

public interface IRepository<T> {

    List<T> get() throws Exception;

    T post(T item) throws Exception;

    T put(T item) throws Exception;

    T delete(T item) throws Exception;
}
