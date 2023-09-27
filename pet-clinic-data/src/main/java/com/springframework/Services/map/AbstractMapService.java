package com.springframework.Services.map;


import com.springframework.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    protected Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    protected T findById(ID id){
        return map.get(id);
    }

    protected T save( T object){
        if (object != null) {
            if (object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
            return object;
        } else {
            throw new RuntimeException("Object can not be null");
        }
    }

    private Long getNextId() {
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            return 1L;
        }
    }

    protected void deleteById(ID id){
        map.remove(id);
    }

    protected void delete(T object){
        map.entrySet().removeIf( idtEntry -> idtEntry.getValue().equals(object));
    }
}
