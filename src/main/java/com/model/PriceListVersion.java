package com.model;

import javax.persistence.*;
import java.util.Objects;
import java.time.LocalDate;

@Entity
@Table(name = "PRICELISTVERSION")
public class PriceListVersion {
	
	@Id     
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String priceVersionId;
	
	private Integer version;
	private LocalDate activeFrom;
	private LocalDate activeTo;
	private Boolean isActive;
	
	@ManyToOne
    @JoinColumn(name = "priceId")
	private PriceList priceList;
	
	public PriceListVersion(String id, Integer version, LocalDate activeFrom, LocalDate activeTo, Boolean isActive) {
		super();
		this.priceVersionId = id;
		this.version = version;
		this.activeFrom = activeFrom;
		this.activeTo = activeTo;
	    this.isActive = isActive;
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
}
