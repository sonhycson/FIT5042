/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jerry
 */
@Entity
@Table(name = "ANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a")
    , @NamedQuery(name = "Animal.findByAnimalid", query = "SELECT a FROM Animal a WHERE a.animalid = :animalid")
    , @NamedQuery(name = "Animal.findByName", query = "SELECT a FROM Animal a WHERE a.name = :name")
    , @NamedQuery(name = "Animal.findBySpecies", query = "SELECT a FROM Animal a WHERE a.species = :species")
    , @NamedQuery(name = "Animal.findByLifespan", query = "SELECT a FROM Animal a WHERE a.lifespan = :lifespan")})
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIMALID")
    private Long animalid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "SPECIES")
    private String species;
    @Column(name = "LIFESPAN")
    private Integer lifespan;
    @OneToMany(mappedBy = "animalid")
    private Collection<Favouriteanimal> favouriteanimalCollection;

    public Animal() {
    }

    public Animal(Long animalid) {
        this.animalid = animalid;
    }

    public Long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(Long animalid) {
        this.animalid = animalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getLifespan() {
        return lifespan;
    }

    public void setLifespan(Integer lifespan) {
        this.lifespan = lifespan;
    }

    @XmlTransient
    public Collection<Favouriteanimal> getFavouriteanimalCollection() {
        return favouriteanimalCollection;
    }

    public void setFavouriteanimalCollection(Collection<Favouriteanimal> favouriteanimalCollection) {
        this.favouriteanimalCollection = favouriteanimalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (animalid != null ? animalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.animalid == null && other.animalid != null) || (this.animalid != null && !this.animalid.equals(other.animalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.entities.Animal[ animalid=" + animalid + " ]";
    }
    
}
