package bg.softuni.armory.model.entity.wmd;

import bg.softuni.armory.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "nuclear_rocket")
public class NuclearRocketEntity extends BaseEntity {
    @Column(name = "name", nullable = true, unique = true)
    private String name;
    @Column(name = "used_by", nullable = false)
    private String usedBy;
    @Column(name = "mass")
    private Integer mass;
    @Column(name = "length")
    private Double length;
    @Column(name = "blast_yield")
    private Double blastYield;
    @Column(name = "warhead")
    private String warhead;
    @Column(name = "max_speed")
    private Integer maxSpeed;
    @Column(name = "operational_range")
    private Integer operationalRange;
    @Column(name = "launch_platform")
    private String launchPlatform;
    @Column(name = "image_url")
    private String imageURL;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public NuclearRocketEntity() {
    }

    public String getName() {
        return name;
    }

    public NuclearRocketEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsedBy() {
        return usedBy;
    }

    public NuclearRocketEntity setUsedBy(String usedBy) {
        this.usedBy = usedBy;
        return this;
    }

    public Integer getMass() {
        return mass;
    }

    public NuclearRocketEntity setMass(Integer mass) {
        this.mass = mass;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public NuclearRocketEntity setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBlastYield() {
        return blastYield;
    }

    public NuclearRocketEntity setBlastYield(Double blastYield) {
        this.blastYield = blastYield;
        return this;
    }

    public String getWarhead() {
        return warhead;
    }

    public NuclearRocketEntity setWarhead(String warhead) {
        this.warhead = warhead;
        return this;
    }

    public Integer getOperationalRange() {
        return operationalRange;
    }

    public NuclearRocketEntity setOperationalRange(Integer operationalRange) {
        this.operationalRange = operationalRange;
        return this;
    }

    public String getLaunchPlatform() {
        return launchPlatform;
    }

    public NuclearRocketEntity setLaunchPlatform(String launchPlatform) {
        this.launchPlatform = launchPlatform;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public NuclearRocketEntity setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public NuclearRocketEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NuclearRocketEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
