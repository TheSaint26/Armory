package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class FirearmAddDTO {
    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 2, message = "Name must contain at least 2 symbols!")
    private String name;
    @NotBlank(message = "Country of Origin cannot be blank!")
    @Size(min = 2, message = "Country of Origin must contain at least 2 symbols!")
    private String countryOfOrigin;
    @NotNull(message = "Please, enter year!")
    @Min(value = 1800, message = "Please, enter a reasonable year!")
    private Integer enteredService;
    @NotNull(message = "Please, enter caliber!")
    @Positive(message = "Caliber value must be positive!")
    private Double caliber;
    private Double weight;
    private Double length;
    private Double barrelLength;
    private Integer muzzleVelocity;
    private Integer cyclicRateOfFire;
    private Integer magazineCapacity;
    private Integer sightingRange;
    @NotNull(message = "Please enter price!")
    @Positive(message = "Price must be positive!")

    private BigDecimal price;
    @NotBlank(message = "Please enter image URL!")
    @Size(min = 8, message = "Image url must contain at least 8 symbols!")
    private String imageUrl;
    private String description;

    public FirearmAddDTO() {
    }

    public String getName() {
        return name;
    }

    public FirearmAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public FirearmAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public FirearmAddDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Double getCaliber() {
        return caliber;
    }

    public FirearmAddDTO setCaliber(Double caliber) {
        this.caliber = caliber;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public FirearmAddDTO setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public FirearmAddDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getBarrelLength() {
        return barrelLength;
    }

    public FirearmAddDTO setBarrelLength(Double barrelLength) {
        this.barrelLength = barrelLength;
        return this;
    }

    public Integer getMuzzleVelocity() {
        return muzzleVelocity;
    }

    public FirearmAddDTO setMuzzleVelocity(Integer muzzleVelocity) {
        this.muzzleVelocity = muzzleVelocity;
        return this;
    }

    public Integer getCyclicRateOfFire() {
        return cyclicRateOfFire;
    }

    public FirearmAddDTO setCyclicRateOfFire(Integer cyclicRateOfFire) {
        this.cyclicRateOfFire = cyclicRateOfFire;
        return this;
    }

    public Integer getMagazineCapacity() {
        return magazineCapacity;
    }

    public FirearmAddDTO setMagazineCapacity(Integer magazineCapacity) {
        this.magazineCapacity = magazineCapacity;
        return this;
    }

    public Integer getSightingRange() {
        return sightingRange;
    }

    public FirearmAddDTO setSightingRange(Integer sightingRange) {
        this.sightingRange = sightingRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FirearmAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public FirearmAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FirearmAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
