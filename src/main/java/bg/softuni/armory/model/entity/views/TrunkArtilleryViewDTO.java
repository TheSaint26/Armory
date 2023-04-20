package bg.softuni.armory.model.entity.views;

import java.math.BigDecimal;

public class TrunkArtilleryViewDTO {
    private Long id;
    private String name;
    private String type;
    private String countryOfOrigin;
    private Integer enteredService;
    private Integer crew;
    private Integer mainGunCaliber;
    private Double projectileWeight;
    private Integer maxFiringRange;
    private Integer maxRateOfFire;
    private boolean hasMachineGun;
    private Double machineGunCaliber;
    private Double weight;
    private Double fullLength;
    private Double hullLength;
    private BigDecimal price;
    private String imageUrl;
    private String description;

    public TrunkArtilleryViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public TrunkArtilleryViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrunkArtilleryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public TrunkArtilleryViewDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TrunkArtilleryViewDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TrunkArtilleryViewDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TrunkArtilleryViewDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TrunkArtilleryViewDTO setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public Double getProjectileWeight() {
        return projectileWeight;
    }

    public TrunkArtilleryViewDTO setProjectileWeight(Double projectileWeight) {
        this.projectileWeight = projectileWeight;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public TrunkArtilleryViewDTO setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public Integer getMaxRateOfFire() {
        return maxRateOfFire;
    }

    public TrunkArtilleryViewDTO setMaxRateOfFire(Integer maxRateOfFire) {
        this.maxRateOfFire = maxRateOfFire;
        return this;
    }

    public boolean isHasMachineGun() {
        return hasMachineGun;
    }

    public TrunkArtilleryViewDTO setHasMachineGun(boolean hasMachineGun) {
        this.hasMachineGun = hasMachineGun;
        return this;
    }

    public Double getMachineGunCaliber() {
        return machineGunCaliber;
    }

    public TrunkArtilleryViewDTO setMachineGunCaliber(Double machineGunCaliber) {
        this.machineGunCaliber = machineGunCaliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TrunkArtilleryViewDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TrunkArtilleryViewDTO setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TrunkArtilleryViewDTO setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TrunkArtilleryViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TrunkArtilleryViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TrunkArtilleryViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
