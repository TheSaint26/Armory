package bg.softuni.armory.model.entity.user;

import bg.softuni.armory.model.entity.BaseEntity;
import bg.softuni.armory.model.entity.IFV.InfantryFightingVehicleEntity;
import bg.softuni.armory.model.entity.aircraft.AircraftEntity;
import bg.softuni.armory.model.entity.artillery.RocketArtilleryEntity;
import bg.softuni.armory.model.entity.artillery.TrunkArtilleryEntity;
import bg.softuni.armory.model.entity.firearms.*;
import bg.softuni.armory.model.entity.tank.TankEntity;
import bg.softuni.armory.model.enums.UserType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @ManyToMany(targetEntity = RoleEntity.class, fetch = FetchType.EAGER)
    private List<RoleEntity> roles;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "deposit")
    private BigDecimal deposit;
    @ManyToMany(targetEntity = PistolEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<PistolEntity> boughtPistols;
    @ManyToMany(targetEntity = AssaultRifleEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<AssaultRifleEntity> boughtAssaultRifles;
    @ManyToMany(targetEntity = MachineGunEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<MachineGunEntity> boughtMachineGuns;
    @ManyToMany(targetEntity = SniperEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<SniperEntity> boughtSnipers;
    @ManyToMany(targetEntity = GrenadeLauncherEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<GrenadeLauncherEntity> boughtGrenadeLaunchers;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<InfantryFightingVehicleEntity> boughtIfvs;
    @ManyToMany(targetEntity = TankEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<TankEntity> boughtTanks;
    @ManyToMany(targetEntity = TrunkArtilleryEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<TrunkArtilleryEntity> boughtTrunkArtillery;
    @ManyToMany(targetEntity = RocketArtilleryEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<RocketArtilleryEntity> boughtRocketArtillery;
    @ManyToMany(targetEntity = AircraftEntity.class, mappedBy = "users", fetch = FetchType.EAGER)
    private Set<AircraftEntity> boughtAircraft;

    public UserEntity() {
        this.isActive = false;
        this.roles = new ArrayList<>();
        this.boughtPistols = new HashSet<>();
        this.boughtAssaultRifles = new HashSet<>();
        this.boughtMachineGuns = new HashSet<>();
        this.boughtSnipers = new HashSet<>();
        this.boughtGrenadeLaunchers = new HashSet<>();
        this.boughtIfvs = new HashSet<>();
        this.boughtTanks = new HashSet<>();
        this.boughtTrunkArtillery = new HashSet<>();
        this.boughtRocketArtillery = new HashSet<>();
        this.boughtAircraft = new HashSet<>();
        this.deposit = BigDecimal.ZERO;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public UserEntity setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public UserEntity setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
        return this;
    }

    public void addRole(RoleEntity role) {
        this.roles.add(role);
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public Set<PistolEntity> getBoughtPistols() {
        return boughtPistols;
    }

    public UserEntity setBoughtPistols(Set<PistolEntity> boughtPistols) {
        this.boughtPistols = boughtPistols;
        return this;
    }

    public Set<AssaultRifleEntity> getBoughtAssaultRifles() {
        return boughtAssaultRifles;
    }

    public UserEntity setBoughtAssaultRifles(Set<AssaultRifleEntity> boughtAssaultRifles) {
        this.boughtAssaultRifles = boughtAssaultRifles;
        return this;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public UserEntity setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
        return this;
    }

    public Set<MachineGunEntity> getBoughtMachineGuns() {
        return boughtMachineGuns;
    }

    public UserEntity setBoughtMachineGuns(Set<MachineGunEntity> boughtMachineGuns) {
        this.boughtMachineGuns = boughtMachineGuns;
        return this;
    }

    public Set<SniperEntity> getBoughtSnipers() {
        return boughtSnipers;
    }

    public UserEntity setBoughtSnipers(Set<SniperEntity> boughtSnipers) {
        this.boughtSnipers = boughtSnipers;
        return this;
    }

    public Set<GrenadeLauncherEntity> getBoughtGrenadeLaunchers() {
        return boughtGrenadeLaunchers;
    }

    public UserEntity setBoughtGrenadeLaunchers(Set<GrenadeLauncherEntity> boughtGrenadeLaunchers) {
        this.boughtGrenadeLaunchers = boughtGrenadeLaunchers;
        return this;
    }

    public Set<InfantryFightingVehicleEntity> getBoughtIfvs() {
        return boughtIfvs;
    }

    public UserEntity setBoughtIfvs(Set<InfantryFightingVehicleEntity> boughtIfvs) {
        this.boughtIfvs = boughtIfvs;
        return this;
    }

    public Set<TankEntity> getBoughtTanks() {
        return boughtTanks;
    }

    public UserEntity setBoughtTanks(Set<TankEntity> boughtTanks) {
        this.boughtTanks = boughtTanks;
        return this;
    }

    public Set<TrunkArtilleryEntity> getBoughtTrunkArtillery() {
        return boughtTrunkArtillery;
    }

    public UserEntity setBoughtTrunkArtillery(Set<TrunkArtilleryEntity> boughtTrunkArtillery) {
        this.boughtTrunkArtillery = boughtTrunkArtillery;
        return this;
    }

    public Set<RocketArtilleryEntity> getBoughtRocketArtillery() {
        return boughtRocketArtillery;
    }

    public UserEntity setBoughtRocketArtillery(Set<RocketArtilleryEntity> boughtRocketArtillery) {
        this.boughtRocketArtillery = boughtRocketArtillery;
        return this;
    }

    public Set<AircraftEntity> getBoughtAircraft() {
        return boughtAircraft;
    }

    public UserEntity setBoughtAircraft(Set<AircraftEntity> boughtAircraft) {
        this.boughtAircraft = boughtAircraft;
        return this;
    }

    public void addDeposit(BigDecimal toAdd) {
        this.deposit = this.deposit.add(toAdd);
    }
}
