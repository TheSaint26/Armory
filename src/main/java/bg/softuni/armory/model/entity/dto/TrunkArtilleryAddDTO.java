package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TrunkArtilleryAddDTO {
    @NotBlank(message = "Please, enter name!")
    @Size(min = 2, message = "Name must be at least 2 characters!")
    private String name;
    @NotBlank(message = "Please, enter country of origin!")
    @Size(min = 2, message = "Country of origin must be at least 2 characters!")
    private String countryOfOrigin;
    @NotNull(message = "Please, enter year!")
    @Min(value = 1800, message = "Please, enter reasonable year!")
    private Integer enteredService;
    @NotBlank(message = "Please, enter artillery type!")
    private String type;
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
    private String engine;
    private BigDecimal price;
    @NotBlank(message = "Please, enter image URL!")
    @Size(min = 5, message = "Image URL must be at least 5 characters!")
    private String imageUrl;
    private String description;

    public TrunkArtilleryAddDTO() {
    }

    public String getName() {
        return name;
    }

    public TrunkArtilleryAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TrunkArtilleryAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TrunkArtilleryAddDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public String getType() {
        return type;
    }

    public TrunkArtilleryAddDTO setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TrunkArtilleryAddDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TrunkArtilleryAddDTO setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public Double getProjectileWeight() {
        return projectileWeight;
    }

    public TrunkArtilleryAddDTO setProjectileWeight(Double projectileWeight) {
        this.projectileWeight = projectileWeight;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public TrunkArtilleryAddDTO setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public Integer getMaxRateOfFire() {
        return maxRateOfFire;
    }

    public TrunkArtilleryAddDTO setMaxRateOfFire(Integer maxRateOfFire) {
        this.maxRateOfFire = maxRateOfFire;
        return this;
    }

    public boolean isHasMachineGun() {
        return hasMachineGun;
    }

    public TrunkArtilleryAddDTO setHasMachineGun(boolean hasMachineGun) {
        this.hasMachineGun = hasMachineGun;
        return this;
    }

    public Double getMachineGunCaliber() {
        return machineGunCaliber;
    }

    public TrunkArtilleryAddDTO setMachineGunCaliber(Double machineGunCaliber) {
        this.machineGunCaliber = machineGunCaliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TrunkArtilleryAddDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TrunkArtilleryAddDTO setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TrunkArtilleryAddDTO setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public TrunkArtilleryAddDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TrunkArtilleryAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TrunkArtilleryAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TrunkArtilleryAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
