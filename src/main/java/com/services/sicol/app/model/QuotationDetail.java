package com.services.sicol.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QuotationDetail")
public class QuotationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quotationDetailID", nullable = false)
    private Long quotationDetailID;

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "quotationID", referencedColumnName = "quotationID")
    private Quotation quotation;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;

    @CreationTimestamp
    @Column(name = "createdAt", updatable = false, nullable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private ZonedDateTime updatedAt;

}
