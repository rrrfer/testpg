package com.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRICELIST")
public class PriceList {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
	private String priceId;
	private String code;
	private String description;
	private Boolean isActive;
	
	@OneToMany(mappedBy = "priceList", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<PriceListVersion> listAuthorities = new ArrayList<>();
	
	public PriceList() {
		super();
	}
	
	public PriceList(String priceId) {
		super();
	}
	
	public PriceList(String priceId, String code, String description, Boolean isActive) {
		super();
		this.code = code;
		this.description = description;
	    this.isActive = isActive;
	}
	
	@Basic
    @Column(name = "ID")
    public String getId() {
        return priceId;
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
}
