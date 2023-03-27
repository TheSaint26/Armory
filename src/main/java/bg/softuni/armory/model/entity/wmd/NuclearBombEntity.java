package bg.softuni.armory.model.entity.wmd;

import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.entity.aircraft.AircraftEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "nuclear_bombs")
public class NuclearBombEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "used_by", nullable = false)
    private String usedBy;
    @Column(name = "mass")
    private Integer mass;
    @Column(name = "length")
    private Double length;
    @Column(name = "blast_yield")
    private Double blastYield;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public NuclearBombEntity() {
    }

    public String getName() {
        return name;
    }

    public NuclearBombEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearBombEntity setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearBombEntity setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearBombEntity setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearBombEntity setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public NuclearBombEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearBombEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
