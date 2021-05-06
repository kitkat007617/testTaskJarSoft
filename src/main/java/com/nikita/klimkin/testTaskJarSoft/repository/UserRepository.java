package com.nikita.klimkin.testTaskJarSoft.repository;

import com.nikita.klimkin.testTaskJarSoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.deleted = false WHERE u.id=:id")
    int delete(@Param("id") int id);
}
