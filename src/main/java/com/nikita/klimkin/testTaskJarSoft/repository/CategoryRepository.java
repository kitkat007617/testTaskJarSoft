package com.nikita.klimkin.testTaskJarSoft.repository;

import com.nikita.klimkin.testTaskJarSoft.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Category c SET c.deleted = false WHERE c.id=:id")
    int delete(@Param("id") int id);
}
