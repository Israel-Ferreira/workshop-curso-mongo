package io.codekaffee.workshopmongo.services;

import io.codekaffee.workshopmongo.exceptions.ObjectNotFoundException;
import org.bson.types.ObjectId;

import java.util.List;

public interface ICrudService<T> {
    List<T>  findAll();
    T findById(ObjectId id);
    T create(T obj);

    T update(ObjectId id, T obj);
    void delete(ObjectId id);


    ObjectNotFoundException objectNotFoundException();
}
