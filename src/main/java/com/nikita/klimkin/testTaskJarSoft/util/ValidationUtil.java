package com.nikita.klimkin.testTaskJarSoft.util;

import com.nikita.klimkin.testTaskJarSoft.util.exception.NotFoundException;
import org.springframework.data.jpa.domain.AbstractPersistable;

public class ValidationUtil {

    public static <T extends AbstractPersistable> void isNew(T entity) {
        if (!entity.isNew())
            throw new NotFoundException("entity must be new!");
    }

    public static <T extends AbstractPersistable> void isUpdated(T entity) {
        if (entity.isNew())
            throw new NotFoundException("entity must be not new!");
    }

    public static <T extends AbstractPersistable> void assureIdConsistent(T entity, Integer id) {
        if (entity.getId() != id)
            throw new IllegalArgumentException("entity id must be the same with argument id");
    }
}
