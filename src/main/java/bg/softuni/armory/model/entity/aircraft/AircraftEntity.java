package bg.softuni.armory.model.entity.aircraft;

import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.enums.AircraftType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "aircraft")
public class AircraftEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    AircraftType type;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "crew")
    private Integer crew;
    @Column(name = "length")
    private Double length;
    @Column(name = "wing_span")
    private Double wingSpan;
    @Column(name = "weight_empty")
    private Double weightEmpty;
    @Column(name = "weight_full")
    private Double weightFull;
    @Column(name = "engine")
    private String engine;
    @Column(name = "max_speed")
    private Integer maxSpeed;
    @Column(name = "max_range")
    private Integer maxRange;
    @Column(name = "combat_radius")
    private Integer combatRadius;
    @Column(name = "cannon")
    private String cannon;
    @Column(name = "missiles")
    private String missiles;
    @Column(name = "bombs", nullable = true)
    private String bombs;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "image_url", nullable = false, columnDefinition = "TEXT")
    private String imageUrl;

    public AircraftEntity() {
    }

    public String getName() {
        return name;
    }

    public AircraftEntity setName(String name) {
        this.name = name;
        return this;
    }

    public AircraftType getType() {
        return type;
    }

    public AircraftEntity setType(AircraftType type) {
        this.type = type;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public AircraftEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public AircraftEntity setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public AircraftEntity setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getWingSpan() {
        return wingSpan;
    }

    public AircraftEntity setWingSpan(Double wingSpan) {
        this.wingSpan = wingSpan;
        return this;
    }

    public Double getWeightEmpty() {
        return weightEmpty;
    }

    public AircraftEntity setWeightEmpty(Double weightEmpty) {
        this.weightEmpty = weightEmpty;
        return this;
    }

    public Double getWeightFull() {
        return weightFull;
    }

    public AircraftEntity setWeightFull(Double weightFull) {
        this.weightFull = weightFull;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public AircraftEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public AircraftEntity setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public AircraftEntity setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public Integer getCombatRadius() {
        return combatRadius;
    }

    public AircraftEntity setCombatRadius(Integer combatRadius) {
        this.combatRadius = combatRadius;
        return this;
    }

    public String getCannon() {
        return cannon;
    }

    public AircraftEntity setCannon(String cannon) {
        this.cannon = cannon;
        return this;
    }

    public String getMissiles() {
        return missiles;
    }

    public AircraftEntity setMissiles(String missiles) {
        this.missiles = missiles;
        return this;
    }

    public String getBombs() {
        return bombs;
    }

    public AircraftEntity setBombs(String bombs) {
        this.bombs = bombs;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AircraftEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AircraftEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AircraftEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
