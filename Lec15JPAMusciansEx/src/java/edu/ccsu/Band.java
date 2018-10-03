/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author cw1491
 */
@Entity
public class Band implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "band")
    private Set<Cd> cds;

    @ManyToMany
    @JoinTable(name = "BandMusician",
            joinColumns = @JoinColumn(name = "bandId",
                    referencedColumnName = "id"), 
            inverseJoinColumns = @JoinColumn(name = "musicianId", referencedColumnName = "id"))
    private Set<Musician> musicians;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Band)) {
            return false;
        }
        Band other = (Band) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ccsu.Band[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cds
     */
    public Set<Cd> getCds() {
        return cds;
    }

    /**
     * @param cds the cds to set
     */
    public void setCds(Set<Cd> cds) {
        this.cds = cds;
    }

    /**
     * @return the musicians
     */
    public Set<Musician> getMusicians() {
        return musicians;
    }

    /**
     * @param musicians the musicians to set
     */
    public void setMusicians(Set<Musician> musicians) {
        this.musicians = musicians;
    }

}
