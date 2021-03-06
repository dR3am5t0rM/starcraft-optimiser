package data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains all the information of the game, including
 * all the unit data and various constants.
 */
public class Datasheet {

	public static final int MAX_SUPPLY = 200;
	public static final int NEXUS_SUPPLY = 10;
	public static final int PYLON_SUPPLY = 8;
	public static final double MINS_PER_NEXUS = 9000, GAS_PER_NEXUS = 5000;
	public static final double MAX_ENERGY_IN_NEXUS = 100;
	
	public static final int MAX_PROBES_ON_MINS = 24;
	public static final int MAX_PROBES_PER_GAS = 3;
	public static final int GEYSERS_PER_NEXUS = 2;
	public static final int MAX_PROBES_PER_NEXUS = MAX_PROBES_ON_MINS + MAX_PROBES_PER_GAS*GEYSERS_PER_NEXUS;
	
	public static final int EFFICIENT_PROBES = 16;
	
	public static final double MINS_PER_MINUTE = 41, THIRD_MINS_PER_MINUTE = 20;
	public static final double MINS_PER_SECOND = MINS_PER_MINUTE/60.0;
	public static final double THIRD_MINS_PER_SECOND = THIRD_MINS_PER_MINUTE/60.0;
	
	public static final double GAS_PER_MINUTE = 38;
	public static final double GAS_PER_SECOND = GAS_PER_MINUTE/60.0;
	
	public static final double CHRONOBOOST_DURATION = 20;
	public static final double CHRONOBOST_MIN_TIME = 15.0;
	public static final double CHRONOBOOST_COST = 25.0;
	
	public static final double WARPGATE_TRANFORMATION_TIME = 10;
	public static final double WARPIN_TIME = 5;
	
	//cannot expand to more than 15 bases as there are not that many bases on the map
	public static final int MAX_NUMBER_OF_NEXI = 15;
	
	public static ArrayList<UnitData> unitData;
	
	public static HashMap<String, Double> warpgateCooldown;
	
	public static void init(){
		unitData = new ArrayList<>();
		warpgateCooldown = new HashMap<>();

		//Buildings
		unitData.add(new UnitData("Nexus", null,"Probe", 400, 0, 0, 100));
		unitData.add(new UnitData("Pylon", null,"Probe", 100, 0, 0, 25));
		unitData.add(new UnitData("Assimilator", null,"Probe", 75, 0, 0, 30));
		unitData.add(new UnitData("Gateway", "Pylon", "Probe", 150, 0, 0, 65));
		unitData.add(new UnitData("Cybernetics Core", "Gateway","Probe", 150, 0, 0, 50));
		unitData.add(new UnitData("Robotics Facility", "Cybernetics Core","Probe", 200, 100, 0, 65));
		unitData.add(new UnitData("Stargate", "Cybernetics Core","Probe", 150, 150, 0, 60));
		unitData.add(new UnitData("Forge", "Pylon","Probe", 150, 0, 0, 45));
		unitData.add(new UnitData("Twilight Council", "Cybernetics Core","Probe", 150, 100, 0, 50));
		unitData.add(new UnitData("Templar Archives", "Twilight Council","Probe", 150, 200, 0, 50));
		unitData.add(new UnitData("Dark Shrine", "Twilight Council","Probe", 100, 250, 0, 100));
		unitData.add(new UnitData("Robotics Bay", "Robotics Facility","Probe", 200, 200, 0, 65));
		unitData.add(new UnitData("Fleet Beacon", "Stargate","Probe", 300, 200, 0, 60));
		
		//Units
		unitData.add(new UnitData("Probe", "Nexus", "Nexus", 50, 0, 1, 17));
		unitData.add(new UnitData("Zealot", "Gateway", "Gateway", 100, 0, 2, 38));
		unitData.add(new UnitData("Stalker", "Cybernetics Core", "Gateway", 125, 50, 2, 42));
		unitData.add(new UnitData("Sentry", "Gateway", "Gateway", 50, 100, 1, 37));
		unitData.add(new UnitData("Observer", "Robotics Facility", "Robotics Facility", 25, 75, 1, 40));
		unitData.add(new UnitData("Immortal", "Robotics Facility", "Robotics Facility", 250, 100, 4, 55));
		unitData.add(new UnitData("Warp Prism", "Robotics Facility", "Robotics Facility", 200, 0, 2, 50));
		unitData.add(new UnitData("Colossus", "Robotics Bay", "Robotics Facility", 300, 200, 6, 75));
		unitData.add(new UnitData("Phoenix", "Stargate", "Stargate", 150, 100, 2, 35));
		unitData.add(new UnitData("Void Ray", "Stargate", "Stargate", 250, 100, 3, 60));
		unitData.add(new UnitData("Oracle", "Stargate", "Stargate", 150, 150, 3, 50));
		unitData.add(new UnitData("Tempest", "Fleet Beacon", "Stargate", 300, 200, 4, 60));
		unitData.add(new UnitData("High Templar", "Templar Archives", "Gateway", 50, 150, 2, 55));
		unitData.add(new UnitData("Dark Templar", "Dark Shrine", "Gateway", 125, 125, 2, 55));
		unitData.add(new UnitData("Carrier", "Fleet Beacon", "Stargate", 350, 250, 6, 120));
		unitData.add(new UnitData("Mothership Core", "Cybernetics Core", "Nexus", 100, 100, 2, 30));
		unitData.add(new UnitData("Mothership", "Fleet Beacon", "Mothership Core", 300, 300, 8, 100));
		unitData.add(new UnitData("Interceptor", "Carrier", "Carrier", 25, 0, 0, 8));
		unitData.add(new UnitData("Photon Cannon", "Forge", "Probe", 150, 0, 0, 40));
		unitData.add(new UnitData("Archon", "High Templar", "Pylon", 0, 0, 0, 12));
		
		//Warpgate cooldowns
		warpgateCooldown.put("Zealot", 28.0);
		warpgateCooldown.put("Stalker", 32.0);
		warpgateCooldown.put("Sentry", 32.0);
		warpgateCooldown.put("High Templar", 45.0);
		warpgateCooldown.put("Dark Templar", 45.0);
		
		//Upgrades
		unitData.add(new UnitData("Warp Gate", "Cybernetics Core", "Cybernetics Core", 50, 50, 0, 160));
		unitData.add(new UnitData("Ground Weapons 1", "Forge", "Forge", 100, 100, 0, 160));
		unitData.add(new UnitData("Ground Weapons 2", "Ground Weapons 1", "Forge", 150, 150, 0, 190));
		unitData.add(new UnitData("Ground Weapons 3", "Ground Weapons 2", "Forge", 200, 200, 0, 220));
		unitData.add(new UnitData("Ground Armor 1", "Forge", "Forge", 100, 100, 0, 160));
		unitData.add(new UnitData("Ground Armor 2", "Ground Armor 1", "Forge", 150, 150, 0, 190));
		unitData.add(new UnitData("Ground Armor 3", "Ground Armor 2", "Forge", 200, 200, 0, 220));
		unitData.add(new UnitData("Shields 1", "Forge", "Forge", 150, 150, 0, 160));
		unitData.add(new UnitData("Shields 2", "Shields 1", "Forge", 225, 225, 0, 190));
		unitData.add(new UnitData("Shields 3","Shields 2", "Forge", 300, 300, 0, 220));
		unitData.add(new UnitData("Air Weapons 1", "Cybernetics Core", "Cybernetics Core", 100, 100, 0, 160));
		unitData.add(new UnitData("Air Weapons 2", "Air Weapons 1", "Cybernetics Core", 175, 175, 0, 190));
		unitData.add(new UnitData("Air Weapons 3", "Air Weapons 2", "Cybernetics Core", 250, 250, 0, 220));
		unitData.add(new UnitData("Air Armor 1", "Cybernetics Core", "Cybernetics Core", 150, 150, 0, 160));
		unitData.add(new UnitData("Air Armor 2", "Air Armor 1", "Cybernetics Core", 225, 225, 0, 190));
		unitData.add(new UnitData("Air Armor 3", "Air Armor 2", "Cybernetics Core", 300, 300, 0, 220));
		unitData.add(new UnitData("Charge", "Twilight Council", "Twilight Council", 200, 200, 0, 140));
		unitData.add(new UnitData("Blink", "Twilight Council","Twilight Council", 150, 150, 0, 170));
		unitData.add(new UnitData("Gravitic Boosters", "Robotics Bay", "Robotics Bay", 100, 100, 0, 80));
		unitData.add(new UnitData("Gravitic Drive", "Robotics Bay","Robotics Bay", 100, 100, 0, 80));
		unitData.add(new UnitData("Extended Thermal Lance", "Robotics Bay", "Robotics Bay", 200, 200, 0, 140));
		unitData.add(new UnitData("Psionic Storm", "Templar Archives", "Templar Archives", 200, 200, 0, 110));
		unitData.add(new UnitData("Graviton Catapult", "Fleet Beacon","Fleet Beacon", 150, 150, 0, 80));
		unitData.add(new UnitData("Anion Pulse-Crystal", "Fleet Beacon","Fleet Beacon", 150, 150, 0, 90));
		
	}
	
	public static double getWarpgateCooldown(String unitName){
		return warpgateCooldown.get(unitName);
	}
	
	public static double getMineralCost(String unitType){
		return findName(unitType).getMineralCost();
	}
	
	public static double getGasCost (String unitType) {
		return findName(unitType).getGasCost();
	}
	
	public static int getSupplyCost(String unitType){
		return findName(unitType).getSupplyCost();
	}

	public static double getBuildTime(String unitType) {
		return findName(unitType).getBuildTime();
	}
	
	public static String getDependancy(String unitType){
		return findName(unitType).getDependancy();
	}
	
	public static String getBuiltFrom(String unitType){
		return findName(unitType).getBuiltFrom();
	}
	
	public static UnitData findName(String name) {
		for (UnitData data : unitData){
			if (data.getName().equals(name)){
				return data;
			}
		}
		return null;
	}

}
