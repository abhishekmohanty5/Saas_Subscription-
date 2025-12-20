package com.jobhunt.saas.repository;

import com.jobhunt.saas.entity.Project;
import com.jobhunt.saas.entity.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project,Long> {
    Long countByOwnerUserIdAndStatus(Long userId, ProjectStatus status);
    List<Project> findByOwnerUserId(Long userId);
}
