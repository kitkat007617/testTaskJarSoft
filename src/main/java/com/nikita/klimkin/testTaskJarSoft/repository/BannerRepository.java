package com.nikita.klimkin.testTaskJarSoft.repository;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Banner b SET b.deleted = false WHERE b.id=:id")
    int delete(@Param("id") int id);
}
