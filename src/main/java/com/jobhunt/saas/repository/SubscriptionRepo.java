package com.jobhunt.saas.repository;

import com.jobhunt.saas.entity.Subscription;
import com.jobhunt.saas.entity.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepo extends JpaRepository<Subscription, Long> {

    Optional<Subscription> getSubscriptionByUserId(Long userid);

    // Used to check if an ACTIVE subscription exists
    boolean existsByUserIdAndStatus(Long userId, SubscriptionStatus status);

    // Used to find the specific ACTIVE subscription for cancellation
    Optional<Subscription> findByUserIdAndStatus(Long userId, SubscriptionStatus status);

    //Find All user Where Status Is Active and End Time Before currentTime
    List<Subscription>findAllByStatusAndEndDateBefore(SubscriptionStatus status, LocalDateTime dateTime);
}