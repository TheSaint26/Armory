package bg.softuni.armory.model.entity.firearms;

import bg.softuni.armory.model.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class BaseFireArm extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "entered_service", nullable = false)
    private Integer enteredService;
    @Column(name = "caliber", nullable = false)
    private Double caliber;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "length")
    private Double length;
    @Column(name = "barrel_length")
    private Double barrelLength;
    @Column(name = "muzzle_velocity")
    private Integer muzzleVelocity;
    @Column(name = "cyclic_rate_of_fire")
    private Integer cyclicRateOfFire;
    @Column(name = "practical_rate_of_fire")
    private Integer practicalRateOfFire;
    @Column(name = "magazine_capacity")
    private Integer magazineCapacity;
    @Column(name = "sighting_range")
    private Integer sightingRange;
    @Column(name = "effective_fire")
    private Integer effectiveFire;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public String getName() {
        return name;
    }

    public BaseFireArm setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public BaseFireArm setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public BaseFireArm setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Double getCaliber() {
        return caliber;
    }

    public BaseFireArm setCaliber(Double caliber) {
        this.caliber = caliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public BaseFireArm setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public BaseFireArm setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBarrelLength() {
        return barrelLength;
    }

    public BaseFireArm setBarrelLength(Double barrelLength) {
        this.barrelLength = barrelLength;
        return this;
    }

    public Integer getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public BaseFireArm setMuzzleVelocity(Integer muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
        return this;
    }

    public Integer getCyclicRateOfFire() {
        return cyclicRateOfFire;
    }

    public BaseFireArm setCyclicRateOfFire(Integer cyclicRateOfFire) {
        this.cyclicRateOfFire = cyclicRateOfFire;
        return this;
    }

    public Integer getPracticalRateOfFire() {
        return practicalRateOfFire;
    }

    public BaseFireArm setPracticalRateOfFire(Integer practicalRateOfFire) {
        this.practicalRateOfFire = practicalRateOfFire;
        return this;
    }

    public Integer getMagazineCapacity() {
        return magazineCapacity;
    }

    public BaseFireArm setMagazineCapacity(Integer magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
        return this;
    }

    public Integer getSightingRange() {
        return sightingRange;
    }

    public BaseFireArm setSightingRange(Integer sightingRange) {
        this.sightingRange = sightingRange;
        return this;
    }

    public Integer getEffectiveFire() {
        return effectiveFire;
    }

    public BaseFireArm setEffectiveFire(Integer effectiveFire) {
        this.effectiveFire = effectiveFire;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BaseFireArm setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BaseFireArm setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BaseFireArm setDescription(String description) {
        this.description = description;
        return this;
    }
}
