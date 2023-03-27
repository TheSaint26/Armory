package bg.softuni.armory.model.entity.artillery;


import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.enums.TrunkArtilleryType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "trunk_artillery")
public class TrunkArtilleryEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TrunkArtilleryType type;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "entered_service", nullable = false)
    private Integer enteredService;
    @Column(name = "crew", unique = true)
    private Integer crew;
    @Column(name = "main_gun_caliber", nullable = false)
    private Integer mainGunCaliber;
    @Column(name = "projectile_weight", nullable = false)
    private Double projectileWeight;
    @Column(name = "max_firing_range", nullable = false)
    private Integer maxFiringRange;
    @Column(name = "max_rate_of_fire", nullable = false)
    private Integer maxRateOfFire;
    @Column(name = "has_machine_gun")
    private boolean hasMachineGun;
    @Column(name = "machine_gun_caliber", nullable = true)
    private Double machineGunCaliber;
    @Column(name = "weight", nullable = false)
    private Double weight;
    @Column(name = "full_length")
    private Double fullLength;
    @Column(name = "hull_length")
    private Double hullLength;
    @Column(name = "engine")
    private String engine;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    public TrunkArtilleryEntity() {
    }

    public String getName() {
        return name;
    }

    public TrunkArtilleryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public TrunkArtilleryType getType() {
        return type;
    }

    public TrunkArtilleryEntity setType(TrunkArtilleryType type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TrunkArtilleryEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TrunkArtilleryEntity setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TrunkArtilleryEntity setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TrunkArtilleryEntity setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public Double getProjectileWeight() {
        return projectileWeight;
    }

    public TrunkArtilleryEntity setProjectileWeight(Double projectileWeight) {
        this.projectileWeight = projectileWeight;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public TrunkArtilleryEntity setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public Integer getMaxRateOfFire() {
        return maxRateOfFire;
    }

    public TrunkArtilleryEntity setMaxRateOfFire(Integer maxRateOfFire) {
        this.maxRateOfFire = maxRateOfFire;
        return this;
    }

    public boolean isHasMachineGun() {
        return hasMachineGun;
    }

    public TrunkArtilleryEntity setHasMachineGun(boolean hasMachineGun) {
        this.hasMachineGun = hasMachineGun;
        return this;
    }

    public Double getMachineGunCaliber() {
        return machineGunCaliber;
    }

    public TrunkArtilleryEntity setMachineGunCaliber(Double machineGunCaliber) {
        this.machineGunCaliber = machineGunCaliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TrunkArtilleryEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TrunkArtilleryEntity setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TrunkArtilleryEntity setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public TrunkArtilleryEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TrunkArtilleryEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TrunkArtilleryEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TrunkArtilleryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
