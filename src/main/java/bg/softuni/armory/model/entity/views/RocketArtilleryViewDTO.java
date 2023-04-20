package bg.softuni.armory.model.entity.views;

import java.math.BigDecimal;

public class RocketArtilleryViewDTO {
    private Long id;
    private String name;
    private String type;
    private String countryOfOrigin;
    private Integer enteredService;
    private Integer caliber;
    private Integer numberOfTubes;
    private Double rocketWeight;
    private Double warheadWeight;
    private Integer maxFiringRange;
    private Integer fullSalvoDuration;
    private Double reloadingTime;
    private String engine;
    private BigDecimal price;
    private String imageURL;
    private String description;

    public RocketArtilleryViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public RocketArtilleryViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RocketArtilleryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public RocketArtilleryViewDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public RocketArtilleryViewDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public RocketArtilleryViewDTO setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCaliber() {
        return caliber;
    }

    public RocketArtilleryViewDTO setCaliber(Integer caliber) {
        this.caliber = caliber;
        return this;
    }

    public Integer getNumberOfTubes() {
        return numberOfTubes;
    }

    public RocketArtilleryViewDTO setNumberOfTubes(Integer numberOfTubes) {
        this.numberOfTubes = numberOfTubes;
        return this;
    }

    public Double getRocketWeight() {
        return rocketWeight;
    }

    public RocketArtilleryViewDTO setRocketWeight(Double rocketWeight) {
        this.rocketWeight = rocketWeight;
        return this;
    }

    public Double getWarheadWeight() {
        return warheadWeight;
    }

    public RocketArtilleryViewDTO setWarheadWeight(Double warheadWeight) {
        this.warheadWeight = warheadWeight;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public RocketArtilleryViewDTO setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public Integer getFullSalvoDuration() {
        return fullSalvoDuration;
    }

    public RocketArtilleryViewDTO setFullSalvoDuration(Integer fullSalvoDuration) {
        this.fullSalvoDuration = fullSalvoDuration;
        return this;
    }

    public Double getReloadingTime() {
        return reloadingTime;
    }

    public RocketArtilleryViewDTO setReloadingTime(Double reloadingTime) {
        this.reloadingTime = reloadingTime;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public RocketArtilleryViewDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RocketArtilleryViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public RocketArtilleryViewDTO setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RocketArtilleryViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
