package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class RocketArtilleryAddDTO {
    @NotBlank(message = "Please, enter name!")
    @Size(min = 2, message = "Name must be at least 2 characters")
    private String name;
    @NotBlank(message = "Please, enter country of origin!")
    @Size(min = 2, message = "Country of origin must be at least 2 characters")
    private String countryOfOrigin;
    @NotNull(message = "Please, enter year!")
    @Min(value = 1800, message = "Please enter reasonable year!")
    private Integer enteredService;
    @NotBlank(message = "Please enter type!")
    private String type;
    @NotNull(message = "Please, enter caliber!")
    @Positive(message = "Caliber must be a positive number!")
    private Integer caliber;
    @NotNull(message = "Please, enter number of tubes!")
    @Positive(message = "Number of tubes must be a positive number!")
    private Integer numberOfTubes;
    private Double rocketWeight;
    private Double warheadWeight;
    private Integer maxFiringRange;
    private Integer fullSalvoDuration;
    private Double reloadingTime;
    public String engine;
    @NotNull(message = "Please, enter price!")
    @Positive(message = "Price must be positive!")
    private BigDecimal price;
    @NotNull(message = "Please enter image URL!")
    @Size(min = 5, message = "Image URL must contain at least 5 characters!")
    private String imageURL;
    private String description;

    public RocketArtilleryAddDTO() {
    }

    public String getName() {
        return name;
    }

    public RocketArtilleryAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public RocketArtilleryAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public RocketArtilleryAddDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public String getType() {
        return type;
    }

    public RocketArtilleryAddDTO setType(String type) {
        this.type = type;
        return this;
    }

    public Integer getCaliber() {
        return caliber;
    }

    public RocketArtilleryAddDTO setCaliber(Integer caliber) {
        this.caliber = caliber;
        return this;
    }

    public Integer getNumberOfTubes() {
        return numberOfTubes;
    }

    public RocketArtilleryAddDTO setNumberOfTubes(Integer numberOfTubes) {
        this.numberOfTubes = numberOfTubes;
        return this;
    }

    public Double getRocketWeight() {
        return rocketWeight;
    }

    public RocketArtilleryAddDTO setRocketWeight(Double rocketWeight) {
        this.rocketWeight = rocketWeight;
        return this;
    }

    public Double getWarheadWeight() {
        return warheadWeight;
    }

    public RocketArtilleryAddDTO setWarheadWeight(Double warheadWeight) {
        this.warheadWeight = warheadWeight;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public RocketArtilleryAddDTO setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public Integer getFullSalvoDuration() {
        return fullSalvoDuration;
    }

    public RocketArtilleryAddDTO setFullSalvoDuration(Integer fullSalvoDuration) {
        this.fullSalvoDuration = fullSalvoDuration;
        return this;
    }

    public Double getReloadingTime() {
        return reloadingTime;
    }

    public RocketArtilleryAddDTO setReloadingTime(Double reloadingTime) {
        this.reloadingTime = reloadingTime;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public RocketArtilleryAddDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RocketArtilleryAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public RocketArtilleryAddDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RocketArtilleryAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
