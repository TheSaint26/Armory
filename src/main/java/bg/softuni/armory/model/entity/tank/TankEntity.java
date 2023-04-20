package bg.softuni.armory.model.entity.tank;

import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.entity.user.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "tanks")
public class TankEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "entered_sevice", nullable = false)
    private Integer enteredService;
    @Column(name = "crew")
    private Integer crew;
    @Column(name = "main_gun")
    private String mainGun;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "full_length")
    private Double fullLength;
    @Column(name = "hull_length")
    private Double hullLength;
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @Column(name = "main_gun_caliber")
    private Integer mainGunCaliber;
    @Column(name = "secondary_armament")
    private String secondaryArmament;
    @Column(name = "machine_gun")
    private String machineGun;
    @Column(name = "main_gun_ammo_load")
    private Integer mainGunAmmoLoad;
    @Column(name = "machine_gun_ammo_load")
    private Integer machineGunAmmoLoad;
    @Column(name = "engine")
    private String engine;
    @Column(name = "max_road_speed")
    private Integer maxRoadSpeed;
    @Column(name = "max_range")
    private Integer maxRange;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "image_url", nullable = false, columnDefinition = "TEXT")
    private String imageUrl;
    @ManyToMany
    private Set<UserEntity> users;


    public TankEntity() {
    }

    public String getName() {
        return name;
    }

    public TankEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public TankEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public TankEntity setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public TankEntity setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public String getMainGun() {
        return mainGun;
    }

    public TankEntity setMainGun(String mainGun) {
        this.mainGun = mainGun;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public TankEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public TankEntity setFullLength(Double fullLength) {
        this.fullLength = fullLength;
        return this;
    }

    public Double getHullLength() {
        return hullLength;
    }

    public TankEntity setHullLength(Double hullLength) {
        this.hullLength = hullLength;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public TankEntity setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public TankEntity setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public TankEntity setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public String getSecondaryArmament() {
        return secondaryArmament;
    }

    public TankEntity setSecondaryArmament(String secondaryArmament) {
        this.secondaryArmament = secondaryArmament;
        return this;
    }

    public String getMachineGun() {
        return machineGun;
    }

    public TankEntity setMachineGun(String machineGun) {
        this.machineGun = machineGun;
        return this;
    }

    public Integer getMainGunAmmoLoad() {
        return mainGunAmmoLoad;
    }

    public TankEntity setMainGunAmmoLoad(Integer mainGunAmmoLoad) {
        this.mainGunAmmoLoad = mainGunAmmoLoad;
        return this;
    }

    public Integer getMachineGunAmmoLoad() {
        return machineGunAmmoLoad;
    }

    public TankEntity setMachineGunAmmoLoad(Integer machineGunAmmoLoad) {
        this.machineGunAmmoLoad = machineGunAmmoLoad;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public TankEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxRoadSpeed() {
        return maxRoadSpeed;
    }

    public TankEntity setMaxRoadSpeed(Integer maxRoadSpeed) {
        this.maxRoadSpeed = maxRoadSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public TankEntity setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TankEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TankEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TankEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public TankEntity setUsers(Set<UserEntity> users) {
        this.users = users;
        return this;
    }
}
