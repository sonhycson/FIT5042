/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jerry
 */
@Entity
@Table(name = "FAVOURITEANIMAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favouriteanimal.findAll", query = "SELECT f FROM Favouriteanimal f")
    , @NamedQuery(name = "Favouriteanimal.findById", query = "SELECT f FROM Favouriteanimal f WHERE f.id = :id")
    , @NamedQuery(name = "Favouriteanimal.findByAddingdate", query = "SELECT f FROM Favouriteanimal f WHERE f.addingdate = :addingdate")})
public class Favouriteanimal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Column(name = "ADDINGDATE")
    @Temporal(TemporalType.DATE)
    private Date addingdate;
    @JoinColumn(name = "ANIMALID", referencedColumnName = "ANIMALID")
    @ManyToOne
    private Animal animalid;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Users userid;

    public Favouriteanimal() {
    }

    public Favouriteanimal(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddingdate() {
        return addingdate;
    }

    public void setAddingdate(Date addingdate) {
        this.addingdate = addingdate;
    }

    public Animal getAnimalid() {
        return animalid;
    }

    public void setAnimalid(Animal animalid) {
        this.animalid = animalid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
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
        if (!(object instanceof Favouriteanimal)) {
            return false;
        }
        Favouriteanimal other = (Favouriteanimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fit5042.entities.Favouriteanimal[ id=" + id + " ]";
    }
    
}
