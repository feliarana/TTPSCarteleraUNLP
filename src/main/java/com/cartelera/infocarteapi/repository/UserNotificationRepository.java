package com.cartelera.infocarteapi.repository;

import com.cartelera.infocarteapi.model.Notification;
import com.cartelera.infocarteapi.model.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
  @Query("SELECT un.notification.id, n.post.id, n.text " +
    "FROM UserNotification un INNER JOIN Notification n on un.notification = n.id")
  List<UserNotification> findAllByUserId(@Param("id")Long id);
}
