package bg.softuni.armory.model.entity.IFV;

import bg.softuni.armory.model.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "infantry_fighting_vehicles")
public class InfantryFightingVehicleEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "country_of_origin", nullable = false)
    private String countryOfOrigin;
    @Column(name = "entered_service")
    private Integer enteredService;
    @Column(name = "crew")
    private Integer crew;
    @Column(name = "personnel")
    private Integer personnel;
    @Column(name = "main_gun")
    private String mainGun;
    @Column(name = "weight")
    private Double weight;
    @Column(name = "length")
    private Double length;
    @Column(name = "width")
    private Double width;
    @Column(name = "height")
    private Double height;
    @Column(name = "main_gun_caliber")
    private Integer mainGunCaliber;
    @Column(name = "ATGW")
    private String ATGW;

    @Column(name = "machine_gun")
    private String machineGun;
    @Column(name = "main_gun_ammo_load")
    private Integer mainGunAmmoLoad;
    @Column(name = "atgw_ammo_load")
    private Integer atgwAmmoLoad;
    @Column(name = "machine_gun_ammo_load")
    private Integer machineGunAmmoLoad;
    @Column(name = "engine")
    private String engine;
    @Column(name = "max_speed")
    private Integer maxSpeed;
    @Column(name = "max_range")
    private Integer maxRange;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "descriprion", columnDefinition = "TEXT")
    private String description;

    public InfantryFightingVehicleEntity() {
    }

    public String getName() {
        return name;
    }

    public InfantryFightingVehicleEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public InfantryFightingVehicleEntity setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public Integer getEnteredService() {
        return enteredService;
    }

    public InfantryFightingVehicleEntity setEnteredService(Integer enteredService) {
        this.enteredService = enteredService;
        return this;
    }

    public Integer getCrew() {
        return crew;
    }

    public InfantryFightingVehicleEntity setCrew(Integer crew) {
        this.crew = crew;
        return this;
    }

    public Integer getPersonnel() {
        return personnel;
    }

    public InfantryFightingVehicleEntity setPersonnel(Integer personnel) {
        this.personnel = personnel;
        return this;
    }

    public String getMainGun() {
        return mainGun;
    }

    public InfantryFightingVehicleEntity setMainGun(String mainGun) {
        this.mainGun = mainGun;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public InfantryFightingVehicleEntity setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    public Double getLength() {
        return length;
    }

    public InfantryFightingVehicleEntity setLength(Double length) {
        this.length = length;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public InfantryFightingVehicleEntity setWidth(Double width) {
        this.width = width;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public InfantryFightingVehicleEntity setHeight(Double height) {
        this.height = height;
        return this;
    }

    public Integer getMainGunCaliber() {
        return mainGunCaliber;
    }

    public InfantryFightingVehicleEntity setMainGunCaliber(Integer mainGunCaliber) {
        this.mainGunCaliber = mainGunCaliber;
        return this;
    }

    public String getMachineGun() {
        return machineGun;
    }

    public InfantryFightingVehicleEntity setMachineGun(String machineGun) {
        this.machineGun = machineGun;
        return this;
    }

    public String getATGW() {
        return ATGW;
    }

    public InfantryFightingVehicleEntity setATGW(String ATGW) {
        this.ATGW = ATGW;
        return this;
    }

    public Integer getMainGunAmmoLoad() {
        return mainGunAmmoLoad;
    }

    public InfantryFightingVehicleEntity setMainGunAmmoLoad(Integer mainGunAmmoLoad) {
        this.mainGunAmmoLoad = mainGunAmmoLoad;
        return this;
    }

    public Integer getAtgwAmmoLoad() {
        return atgwAmmoLoad;
    }

    public InfantryFightingVehicleEntity setAtgwAmmoLoad(Integer atgwAmmoLoad) {
        this.atgwAmmoLoad = atgwAmmoLoad;
        return this;
    }

    public Integer getMachineGunAmmoLoad() {
        return machineGunAmmoLoad;
    }

    public InfantryFightingVehicleEntity setMachineGunAmmoLoad(Integer machineGunAmmoLoad) {
        this.machineGunAmmoLoad = machineGunAmmoLoad;
        return this;
    }

    public String getEngine() {
        return engine;
    }

    public InfantryFightingVehicleEntity setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public InfantryFightingVehicleEntity setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public InfantryFightingVehicleEntity setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public InfantryFightingVehicleEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public InfantryFightingVehicleEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InfantryFightingVehicleEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
