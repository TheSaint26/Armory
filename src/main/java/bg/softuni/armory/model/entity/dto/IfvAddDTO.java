package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class IfvAddDTO {
    @NotBlank(message = "Please, fill Infantry Fighting Vehicle name!")
    @Size(min = 2, message = "Infantry Fighting Vehicle name must be at least 2 characters!")
    private String name;
    @NotBlank(message = "Please, fill Country of Origin!")
    @Size(min = 2, message = "Country of Origin name must be at least 2 characters!")
    private String countryOfOrigin;
    @Positive(message = "Please enter positive value!")
    private Integer enteredService;
    @Positive(message = "Please enter positive value!")
    private Integer crew;
    @Positive(message = "Please enter positive value!")
    private Integer personnel;
    private String mainGun;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private Integer mainGunCaliber;
    private String ATGW;
    private String machineGun;
    private Integer machineGinAmmoLoad;
    private Integer mainGunAmmoLoad;
    private Integer atgwAmmoLoad;
    private String engine;
    private Integer maxSpeed;
    private Integer maxRange;
    @NotNull(message = "Please, enter price!")
    @Min(value = 1800, message = "Please, enter a reasonable year!")
    private BigDecimal price;
    @NotBlank(message = "Please, fill image URL!")
    @Size(min = 5, message = "Image URL must be at least 5 characters!")
    private String imageUrl;
    private String description;

    public IfvAddDTO() {
    }

    public String getName() {
        return name;
    }

    public IfvAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public IfvAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public IfvAddDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public IfvAddDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Integer getPersonnel() {
        return personnel;
    }

    public IfvAddDTO setPersonnel(Integer personnel) {
        this.personnel = personnel;
        return this;
    }

    public String getMainGun() {
        return mainGun;
    }

    public IfvAddDTO setMainGun(String mainGun) {
        this.mainGun = mainGun;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public IfvAddDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public IfvAddDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public IfvAddDTO setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public IfvAddDTO setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public IfvAddDTO setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public String getATGW() {
        return ATGW;
    }

    public IfvAddDTO setATGW(String ATGW) {
        this.ATGW = ATGW;
        return this;
    }

    public String getMachineGun() {
        return machineGun;
    }

    public IfvAddDTO setMachineGun(String machineGun) {
        this.machineGun = machineGun;
        return this;
    }

    public Integer getMachineGinAmmoLoad() {
        return machineGinAmmoLoad;
    }

    public IfvAddDTO setMachineGinAmmoLoad(Integer machineGinAmmoLoad) {
        this.machineGinAmmoLoad = machineGinAmmoLoad;
        return this;
    }

    public Integer getMainGunAmmoLoad() {
        return mainGunAmmoLoad;
    }

    public IfvAddDTO setMainGunAmmoLoad(Integer mainGunAmmoLoad) {
        this.mainGunAmmoLoad = mainGunAmmoLoad;
        return this;
    }

    public Integer getAtgwAmmoLoad() {
        return atgwAmmoLoad;
    }

    public IfvAddDTO setAtgwAmmoLoad(Integer atgwAmmoLoad) {
        this.atgwAmmoLoad = atgwAmmoLoad;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public IfvAddDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public IfvAddDTO setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public IfvAddDTO setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public IfvAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public IfvAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public IfvAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
