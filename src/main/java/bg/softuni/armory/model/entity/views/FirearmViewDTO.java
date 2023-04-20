package bg.softuni.armory.model.entity.views;

import java.math.BigDecimal;

public class FirearmViewDTO {
    private Long id;
    private String name;
    private String countryOfOrigin;
    private Integer enteredService;
    private Double caliber;
    private Double weight;
    private Double length;
    private Double barrelLength;
    private Double muzzleVelocity;
    private Integer cyclicRateOfFire;
    private Integer practicalRateOfFire;
    private Integer magazineCapacity;
    private Integer sightingRange;
    private Integer effectiveFire;
    private BigDecimal price;
    private String imageUrl;
    private String description;

    public FirearmViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public FirearmViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FirearmViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public FirearmViewDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public FirearmViewDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Double getCaliber() {
        return caliber;
    }

    public FirearmViewDTO setCaliber(Double caliber) {
        this.caliber = caliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public FirearmViewDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public FirearmViewDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBarrelLength() {
        return barrelLength;
    }

    public FirearmViewDTO setBarrelLength(Double barrelLength) {
        this.barrelLength = barrelLength;
        return this;
    }

    public Double getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public FirearmViewDTO setMuzzleVelocity(Double muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
        return this;
    }

    public Integer getCyclicRateOfFire() {
        return cyclicRateOfFire;
    }

    public FirearmViewDTO setCyclicRateOfFire(Integer cyclicRateOfFire) {
        this.cyclicRateOfFire = cyclicRateOfFire;
        return this;
    }

    public Integer getPracticalRateOfFire() {
        return practicalRateOfFire;
    }

    public FirearmViewDTO setPracticalRateOfFire(Integer practicalRateOfFire) {
        this.practicalRateOfFire = practicalRateOfFire;
        return this;
    }

    public Integer getMagazineCapacity() {
        return magazineCapacity;
    }

    public FirearmViewDTO setMagazineCapacity(Integer magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
        return this;
    }

    public Integer getSightingRange() {
        return sightingRange;
    }

    public FirearmViewDTO setSightingRange(Integer sightingRange) {
        this.sightingRange = sightingRange;
        return this;
    }

    public Integer getEffectiveFire() {
        return effectiveFire;
    }

    public FirearmViewDTO setEffectiveFire(Integer effectiveFire) {
        this.effectiveFire = effectiveFire;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FirearmViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public FirearmViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FirearmViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
