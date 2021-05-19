package com.nikita.klimkin.testTaskJarSoft.repository;

import com.nikita.klimkin.testTaskJarSoft.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface BannerRepository extends JpaRepository<Banner, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Banner b SET b.deleted = false WHERE b.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT b FROM Banner b WHERE b.category.requestName=:requestName AND b.deleted = false ORDER BY b.price DESC")
    List<Banner> findBannersByCategoryOrderByPrice(@Param("requestName") String requestName);

    List<Banner> findAllByDeleted(boolean deleted);
}
