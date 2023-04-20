package com.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PRICELISTVERSION")
public class PriceListVersion implements Serializable {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
	private String priceVersionId;
	
	@JsonSerialize
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "priceListCode", referencedColumnName = "code", nullable = false)
	private PriceList priceList;
	
	private Integer version;
	private LocalDate activeFrom;
	private LocalDate activeTo;
	private Boolean isActive;
	
	public PriceListVersion() {
		super();
	}
	
	public PriceListVersion(String id, PriceList priceList, Integer version, LocalDate activeFrom, LocalDate activeTo, Boolean isActive) {
		super();
		this.priceVersionId = id;
		this.priceList = priceList;
		this.version = version;
		this.activeFrom = activeFrom;
		this.activeTo = activeTo;
	    this.isActive = isActive;
	}
	
	@Basic
    @Column(name = "ID")
    public String getId() {
        return priceVersionId;
    }

    @Basic
    @Column(name = "VERSION")
    public Integer getVersion() {
        return version;
    }
    public void setCode(Integer version) {
        this.version = version;
    }
    
    @Basic
    @Column(name = "ACTIVE_FROM")
    public LocalDate getActiveFrom() {
        return activeFrom;
    }
    public void setActiveFrom(LocalDate activeFrom) {
        this.activeFrom = activeFrom;
    }
    
    @Basic
    @Column(name = "ACTIVE_TO")
    public LocalDate getActiveTo() {
        return activeTo;
    }
    public void setActiveTo(LocalDate activeTo) {
        this.activeTo = activeTo;
    }

    @Basic
    @Column(name = "IS_ACTIVE")
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    public PriceList getPriceList() {
        return priceList;
    }
    public void setPriceList(PriceList priceList) {
        this.priceList = priceList;
    }
    
    
    
}
