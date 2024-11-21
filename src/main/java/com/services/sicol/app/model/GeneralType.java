package com.services.sicol.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "GeneralType")
public class GeneralType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subtype", nullable = false)
    private Integer subtype;

    @Column(name = "subclass", nullable = false)
    private String subclass;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "class", nullable = false)
    private String category;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false, nullable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private ZonedDateTime updatedAt;

    @Override
    public String toString() {
        return "GeneralType{" +
                "subtype=" + subtype +
                ", subclass='" + subclass + '\'' +
                ", type=" + type +
                ", category='" + category + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
