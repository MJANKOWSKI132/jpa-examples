package com.jpa.examples.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.ZonedDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Auditable {
    @Column(updatable = false)
    private String createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(updatable = false)
    private ZonedDateTime createdDate;
    private String lastModifiedBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime lastModifiedDate;
}
