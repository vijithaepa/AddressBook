package com.genix.addressbook.manager;

/**
 * 
 * @author Vijitha Epa.
 * @since 26-09-12.
 * @param <T> generic Type.
 * 
 * Generic entity manager which gives generic CRUD operations.
 */
public interface EntityManager<T> {
    T create(T entity);

    T update(T entity);

    T delete(T entity);

    T get(Long entityId);
}
