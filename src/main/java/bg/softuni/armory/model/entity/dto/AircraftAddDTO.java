package bg.softuni.armory.model.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AircraftAddDTO {
    @NotBlank(message = "Please, enter aircraft name!")
    @Size(min = 2, message = "Name must contain at least 2 characters!")
    private String name;
    @NotBlank(message = "Please, choose aircraft type!")
    private String type;
    @NotBlank(message = "Please, enter country of origin!")
    @Size(min = 2, message = "Country of origin must contain at least 2 characters!")
    private String countryOfOrigin;
    private Integer crew;
    private Double wingSpan;
    private Double weightEmpty;
    private Double weightFull;
    private String engine;
    private String maxSpeed;
    private Integer maxRange;
    private Integer combatRadius;
    private String cannon;
    private String missiles;
    private String bombs;
    @NotNull(message = "Please, enter price!")
    @Positive(message = "Price must be positive!")
    private BigDecimal price;
    @NotBlank(message = "Please enter image URL!")
    @Size(min = 5, message = "Image URL must contain at least 5 characters!")
    private String imageUrl;
    private String description;

    public AircraftAddDTO() {
    }

    public String getName() {
        return name;
    }

    public AircraftAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public AircraftAddDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public AircraftAddDTO setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public AircraftAddDTO setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Double getWingSpan() {
        return wingSpan;
    }

    public AircraftAddDTO setWingSpan(Double wingSpan) {
        this.wingSpan = wingSpan;
        return this;
    }

    public Double getWeightEmpty() {
        return weightEmpty;
    }

    public AircraftAddDTO setWeightEmpty(Double weightEmpty) {
        this.weightEmpty = weightEmpty;
        return this;
    }

    public Double getWeightFull() {
        return weightFull;
    }

    public AircraftAddDTO setWeightFull(Double weightFull) {
        this.weightFull = weightFull;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public AircraftAddDTO setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public AircraftAddDTO setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public AircraftAddDTO setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public Integer getCombatRadius() {
        return combatRadius;
    }

    public AircraftAddDTO setCombatRadius(Integer combatRadius) {
        this.combatRadius = combatRadius;
        return this;
    }

    public String getCannon() {
        return cannon;
    }

    public AircraftAddDTO setCannon(String cannon) {
        this.cannon = cannon;
        return this;
    }

    public String getMissiles() {
        return missiles;
    }

    public AircraftAddDTO setMissiles(String missiles) {
        this.missiles = missiles;
        return this;
    }

    public String getBombs() {
        return bombs;
    }

    public AircraftAddDTO setBombs(String bombs) {
        this.bombs = bombs;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AircraftAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AircraftAddDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AircraftAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
