package com.jpa.examples.listener;

import com.jpa.examples.entity.Auditable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.ZonedDateTime;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class AuditListener {
    @PrePersist
    public void onPrePersist(Object entity) {
        if (entity instanceof Auditable auditable) {
            String currentUsername = getCurrentUsername(); //userSecurityUtil.getUsername()
            ZonedDateTime now = ZonedDateTime.now();

            auditable.setCreatedBy(currentUsername);
            auditable.setCreatedDate(now);
            auditable.setLastModifiedBy(currentUsername);
            auditable.setLastModifiedDate(now);
        }
    }

    @PreUpdate
    public void onPreUpdate(Object entity) {
        if (entity instanceof Auditable auditable) {
            auditable.setLastModifiedBy(getCurrentUsername());
            auditable.setLastModifiedDate(ZonedDateTime.now());
        }
    }

    private String getCurrentUsername() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUsername();
    }
}
