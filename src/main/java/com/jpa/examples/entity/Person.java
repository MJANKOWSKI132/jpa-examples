package com.jpa.examples.entity;

import com.jpa.examples.listener.AuditListener;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditListener.class)
@SQLDelete(sql = "UPDATE person SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Person extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NaturalId
    private String username;
    private String firstName;
    private String lastName;
    private Long age;
    private boolean deleted;
}
