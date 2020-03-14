package com.company.compcomp.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "COMPCOMP_FOO")
@Entity(name = "compcomp_Foo")
public class Foo extends StandardEntity {
    private static final long serialVersionUID = 5714708273601018070L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "LIMIT_")
    protected Integer limit;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}