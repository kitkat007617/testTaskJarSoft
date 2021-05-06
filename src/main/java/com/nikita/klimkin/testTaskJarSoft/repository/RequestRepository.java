package com.nikita.klimkin.testTaskJarSoft.repository;

import com.nikita.klimkin.testTaskJarSoft.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

}
