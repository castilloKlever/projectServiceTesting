package com.grafrio.GraficasRiobamba.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grafrio.GraficasRiobamba.entities.Blog;
@Repository
public interface BlogServiceRepo extends JpaRepository<Blog,Long> {

}
