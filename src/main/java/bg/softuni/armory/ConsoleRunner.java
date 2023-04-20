package bg.softuni.armory;

import bg.softuni.armory.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
   private final RoleService roleService;
   private final PistolService pistolService;
   private final AssaultRifleService assaultRifleService;
   private final MachineGunService machineGunService;
   private final SniperService sniperService;
   private final GrenadeLauncherService grenadeLauncherService;
   private final InfantryFightingVehicleService infantryFightingVehicleService;
   private final TankService tankService;
   private final RocketArtilleryService rocketArtilleryService;
   private final TrunkArtilleryService trunkArtilleryService;
   private final AircraftService aircraftService;
   private final NuclearBombService nuclearBombService;
   private final NuclearRocketService nuclearRocketService;

    public ConsoleRunner(RoleService roleService, PistolService pistolService, AssaultRifleService assaultRifleService, MachineGunService machineGunService, SniperService sniperService, GrenadeLauncherService grenadeLauncherService, InfantryFightingVehicleService infantryFightingVehicleService, TankService tankService, RocketArtilleryService rocketArtilleryService, TrunkArtilleryService trunkArtilleryService, AircraftService aircraftService, NuclearBombService nuclearBombService, NuclearRocketService nuclearRocketService) {
        this.roleService = roleService;
        this.pistolService = pistolService;
        this.assaultRifleService = assaultRifleService;
        this.machineGunService = machineGunService;
        this.sniperService = sniperService;
        this.grenadeLauncherService = grenadeLauncherService;
        this.infantryFightingVehicleService = infantryFightingVehicleService;
        this.tankService = tankService;
        this.rocketArtilleryService = rocketArtilleryService;
        this.trunkArtilleryService = trunkArtilleryService;
        this.aircraftService = aircraftService;
        this.nuclearBombService = nuclearBombService;
        this.nuclearRocketService = nuclearRocketService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.seedRoles();
        pistolService.seedPistols();
        assaultRifleService.seedAssaultRifles();
        machineGunService.seedMachineGuns();
        sniperService.seedSnipers();
        grenadeLauncherService.seedGrenadeLaunchers();
        infantryFightingVehicleService.seedIFV();
        tankService.seedTanks();
        rocketArtilleryService.seedRocketArtillery();
        trunkArtilleryService.seedTrunkArtillery();
        aircraftService.seedAircraft();
        nuclearBombService.seedNuclearBombs();
        nuclearRocketService.seedNuclearRockets();
    }
}
