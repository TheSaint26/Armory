package bg.softuni.armory.model.entity.views;

import java.math.BigDecimal;

public class AircraftViewDTO {
    private Long id;
    private String name;
    private String type;
    private String countryOfOrigin;
    private Integer crew;
    private Double length;
    private Double wingSpan;
    private Double weightEmpty;
    private Double weightFull;
    private String engine;
    private Integer maxSpeed;
    private Integer maxRange;
    private Integer combatRadius;
    private String cannon;
    private String missiles;
    private String bombs;
    private BigDecimal price;
    private String imageUrl;
    private String description;

    public AircraftViewDTO() {
    }

    public Long getId() {
        return id;
    }

    public AircraftViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AircraftViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public AircraftViewDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public AircraftViewDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public AircraftViewDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public AircraftViewDTO setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getWingSpan() {
        return wingSpan;
    }

    public AircraftViewDTO setWingSpan(Double wingSpan) {
        this.wingSpan = wingSpan;
        return this;
    }

    public Double getWeightEmpty() {
        return weightEmpty;
    }

    public AircraftViewDTO setWeightEmpty(Double weightEmpty) {
        this.weightEmpty = weightEmpty;
        return this;
    }

    public Double getWeightFull() {
        return weightFull;
    }

    public AircraftViewDTO setWeightFull(Double weightFull) {
        this.weightFull = weightFull;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public AircraftViewDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public AircraftViewDTO setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public AircraftViewDTO setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public Integer getCombatRadius() {
        return combatRadius;
    }

    public AircraftViewDTO setCombatRadius(Integer combatRadius) {
        this.combatRadius = combatRadius;
        return this;
    }

    public String getCannon() {
        return cannon;
    }

    public AircraftViewDTO setCannon(String cannon) {
        this.cannon = cannon;
        return this;
    }

    public String getMissiles() {
        return missiles;
    }

    public AircraftViewDTO setMissiles(String missiles) {
        this.missiles = missiles;
        return this;
    }

    public String getBombs() {
        return bombs;
    }

    public AircraftViewDTO setBombs(String bombs) {
        this.bombs = bombs;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AircraftViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AircraftViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AircraftViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
