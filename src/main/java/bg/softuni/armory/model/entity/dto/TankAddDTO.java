package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TankAddDTO {
    @NotBlank(message = "Please enter a tank name!")
    @Size(min = 2, message = "Tank name should be at least 2 characters!")
    private String name;
    @NotBlank(message = "Please enter country of origin!")
    @Size(min = 2, message = "Country of origin should be at least 2 characters!")
    private String countryOfOrigin;
    @NotNull(message = "Please, enter year!")
    @Min(value = 1800, message = "Please enter a reasonable year!")
    private Integer enteredService;
    private Integer crew;
    private String mainGun;
    private Double weight;
    private Double fullLength;
    private Double hullLength;
    private Double width;
    private Double height;
    private Integer mainGunCaliber;
    private String secondaryArmament;
    private String machineGun;
    private Integer mainGunAmmoLoad;
    private Integer machineGunAmmoLoad;
    private String engine;
    private Integer maxRoadSpeed;
    private Integer maxRange;
    private BigDecimal price;
    @NotBlank(message = "Please enter tank image URL!")
    @Size(min = 5, message = "Tank image URL must be at least 5 characters!")
    private String imageUrl;
    private String description;

    public TankAddDTO() {
    }

    public String getName() {
        return name;
    }

    public TankAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TankAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TankAddDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TankAddDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public String getMainGun() {
        return mainGun;
    }

    public TankAddDTO setMainGun(String mainGun) {
        this.mainGun = mainGun;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TankAddDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TankAddDTO setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TankAddDTO setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public TankAddDTO setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public TankAddDTO setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TankAddDTO setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public String getSecondaryArmament() {
        return secondaryArmament;
    }

    public TankAddDTO setSecondaryArmament(String secondaryArmament) {
        this.secondaryArmament = secondaryArmament;
        return this;
    }

    public String getMachineGun() {
        return machineGun;
    }

    public TankAddDTO setMachineGun(String machineGun) {
        this.machineGun = machineGun;
        return this;
    }

    public Integer getMainGunAmmoLoad() {
        return mainGunAmmoLoad;
    }

    public TankAddDTO setMainGunAmmoLoad(Integer mainGunAmmoLoad) {
        this.mainGunAmmoLoad = mainGunAmmoLoad;
        return this;
    }

    public Integer getMachineGunAmmoLoad() {
        return machineGunAmmoLoad;
    }

    public TankAddDTO setMachineGunAmmoLoad(Integer machineGunAmmoLoad) {
        this.machineGunAmmoLoad = machineGunAmmoLoad;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public TankAddDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxRoadSpeed() {
        return maxRoadSpeed;
    }

    public TankAddDTO setMaxRoadSpeed(Integer maxRoadSpeed) {
        this.maxRoadSpeed = maxRoadSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public TankAddDTO setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TankAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TankAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TankAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
