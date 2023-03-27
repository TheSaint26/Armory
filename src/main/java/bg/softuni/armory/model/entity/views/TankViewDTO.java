package bg.softuni.armory.model.entity.views;

import java.math.BigDecimal;

public class TankViewDTO {
    private Long id;
    private String name;
    private String countryOfOrigin;
    private Integer enteredService;
    private Integer crew;
    private String mainGun;
    private Integer mainGunCaliber;
    private Integer mainGunAmmoLoad;
    private Double weight;
    private Double fullLength;
    private Double hullLength;
    private Double width;
    private Double height;
    private String secondaryArmament;
    private String machineGun;
    private Integer machineGunAmmoLoad;
    private String engine;
    private Integer maxRoadSpeed;
    private Integer maxRange;
    private BigDecimal price;
    private String imageUrl;
    private String description;

    public TankViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public TankViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TankViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TankViewDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TankViewDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TankViewDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public String getMainGun() {
        return mainGun;
    }

    public TankViewDTO setMainGun(String mainGun) {
        this.mainGun = mainGun;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TankViewDTO setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public Integer getMainGunAmmoLoad() {
        return mainGunAmmoLoad;
    }

    public TankViewDTO setMainGunAmmoLoad(Integer mainGunAmmoLoad) {
        this.mainGunAmmoLoad = mainGunAmmoLoad;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TankViewDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TankViewDTO setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TankViewDTO setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public TankViewDTO setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public TankViewDTO setHeight(Double height) {
        this.height = height;
        return this;
    }

    public String getSecondaryArmament() {
        return secondaryArmament;
    }

    public TankViewDTO setSecondaryArmament(String secondaryArmament) {
        this.secondaryArmament = secondaryArmament;
        return this;
    }

    public String getMachineGun() {
        return machineGun;
    }

    public TankViewDTO setMachineGun(String machineGun) {
        this.machineGun = machineGun;
        return this;
    }

    public Integer getMachineGunAmmoLoad() {
        return machineGunAmmoLoad;
    }

    public TankViewDTO setMachineGunAmmoLoad(Integer machineGunAmmoLoad) {
        this.machineGunAmmoLoad = machineGunAmmoLoad;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public TankViewDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxRoadSpeed() {
        return maxRoadSpeed;
    }

    public TankViewDTO setMaxRoadSpeed(Integer maxRoadSpeed) {
        this.maxRoadSpeed = maxRoadSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public TankViewDTO setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TankViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TankViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TankViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
