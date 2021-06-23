package io.artcreativity.emarket.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class BaseEntity implements Serializable {

	@CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
	
	public Instant getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	public Instant getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
