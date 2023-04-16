package com.model;
import java.util.List;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRICELIST")
public class PriceList {
	
	@Id     
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String priceId;
	
	private String code;
	private String description;
	private Boolean isActive;
	
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="priceVersionId")
	@PrimaryKeyJoinColumn
    private List<PriceListVersion> priceListVersions;
	
	public PriceList(String id, String code, String description, Boolean isActive) {
		super();
		this.priceId = id;
		this.code = code;
		this.description = description;
	    this.isActive = isActive;
	}

    @Basic
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "IS_ACTIVE")
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceList employees = (PriceList) o;
        return Objects.equals(priceId, employees.priceId) &&
                Objects.equals(code, employees.code) &&
                Objects.equals(description, employees.description) &&
                Objects.equals(isActive, employees.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceId, code, description, isActive);
    }
}
