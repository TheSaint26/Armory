package bg.softuni.armory.model.entity.artillery;


import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.enums.RocketArtilleryType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "rocket_artillery")
public class RocketArtilleryEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private RocketArtilleryType type;
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @Column(name = "entered_service")
    private Integer enteredService;
    @Column(name = "caliber", nullable = false)
    private Integer caliber;
    @Column(name = "number_of_tubes", nullable = false)
    private Integer numberOfTubes;
    @Column(name = "rocket_weight")
    private Double rocketWeight;
    @Column(name = "warhead_weight")
    private Double warheadWeight;
    @Column(name = "firing_range")
    private Integer maxFiringRange;
    @Column(name = "full_salvo_duration")
    private Integer fullSalvoDuration;
    @Column(name = "reloading_time")
    private Double reloadingTime;
    @Column(name = "engine")
    public String engine;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "image_url", nullable = false, columnDefinition = "TEXT")
    private String imageURL;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @ManyToMany
    private Set<UserEntity> users;

    public RocketArtilleryEntity() {
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public RocketArtilleryEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public RocketArtilleryEntity setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCaliber() {
        return caliber;
    }

    public RocketArtilleryEntity setCaliber(Integer caliber) {
        this.caliber = caliber;
        return this;
    }

    public Integer getNumberOfTubes() {
        return numberOfTubes;
    }

    public RocketArtilleryEntity setNumberOfTubes(Integer numberOfTubes) {
        this.numberOfTubes = numberOfTubes;
        return this;
    }

    public Double getRocketWeight() {
        return rocketWeight;
    }

    public RocketArtilleryEntity setRocketWeight(Double rocketWeight) {
        this.rocketWeight = rocketWeight;
        return this;
    }

    public Double getWarheadWeight() {
        return warheadWeight;
    }

    public RocketArtilleryEntity setWarheadWeight(Double warheadWeight) {
        this.warheadWeight = warheadWeight;
        return this;
    }

    public Integer getFiringRange() {
        return maxFiringRange;
    }

    public RocketArtilleryEntity setFiringRange(Integer firingRange) {
        this.maxFiringRange = firingRange;
        return this;
    }

    public Integer getFullSalvoDuration() {
        return fullSalvoDuration;
    }

    public RocketArtilleryEntity setFullSalvoDuration(Integer fullSalvoDuration) {
        this.fullSalvoDuration = fullSalvoDuration;
        return this;
    }

    public Double getReloadingTime() {
        return reloadingTime;
    }

    public RocketArtilleryEntity setReloadingTime(Double reloadingTime) {
        this.reloadingTime = reloadingTime;
        return this;
    }

    public Integer getMaxFiringRange() {
        return maxFiringRange;
    }

    public RocketArtilleryEntity setMaxFiringRange(Integer maxFiringRange) {
        this.maxFiringRange = maxFiringRange;
        return this;
    }

    public String getName() {
        return name;
    }

    public RocketArtilleryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public RocketArtilleryType getType() {
        return type;
    }

    public RocketArtilleryEntity setType(RocketArtilleryType type) {
        this.type = type;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public RocketArtilleryEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public RocketArtilleryEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public RocketArtilleryEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RocketArtilleryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public RocketArtilleryEntity setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }
}
