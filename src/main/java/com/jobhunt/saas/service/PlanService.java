package com.jobhunt.saas.service;

import com.jobhunt.saas.dto.PlanRequest;
import com.jobhunt.saas.entity.Plan;
import com.jobhunt.saas.repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PlanService {

     private final PlanRepo planRepo;

    @Autowired
    public PlanService(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    public void createPlan(PlanRequest planRequest) {

        Plan plan = new Plan();
        plan.setName(planRequest.getName());
        plan.setPrice(planRequest.getPrice());
        plan.setDurationInDays(planRequest.getDurationInDays());
        plan.setActive(true);
        plan.setCreatedAt(LocalDateTime.now());
        plan.setUpdatedAt(LocalDateTime.now());

        planRepo.save(plan);
    }

    public List<Plan> findAll() {
        return planRepo.findAll();
    }

    public void activePlan(Long id) {
        Plan plan = planRepo.findById(id)
                .orElseThrow(() ->
                        new IllegalStateException("Plan with ID " + id + " not found"));

        plan.setActive(true);
        plan.setUpdatedAt(LocalDateTime.now());
        planRepo.save(plan);
    }

    public void inactivePlan(Long id) {
        Plan plan=planRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Plan with ID " + id + " not found"));

        plan.setActive(false);
        plan.setUpdatedAt(LocalDateTime.now());
        planRepo.save(plan);
    }

}
