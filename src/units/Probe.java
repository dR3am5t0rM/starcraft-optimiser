package units;

import units.nexus.ExpansionNexus;
import logger.SCLogger;
import game.Game;
import gameobjects.Bulider;
import gameobjects.Entity;

public class Probe extends Bulider{

	public Probe(Game game) {
		super(game);
	}

	private int mineralCost = 50;
	private int gasCost = 50;
	private MineralPatch miningPatch = null;
	private VespeneGeyser miningGeyser = null;
	private boolean isBuilding;
	
	public void assignToPatch(MineralPatch patch){
		this.miningPatch = patch;
		patch.addProbe(this);
	}
	
	public void removeFromPatch(){
		miningPatch.removeProbe(this);
		this.miningPatch = null;
	}
	
	public boolean isMining(){
		return (miningPatch != null || miningGeyser != null);
	}
	
	public void mine(){
		if (miningPatch != null){
			SCLogger.log("Probe Mining", SCLogger.LOG_CALLS);
			miningPatch.deplete();
			getGame().addMinerals(MineralPatch.DEPLETION_RATE);
		} else if (miningGeyser != null){
			SCLogger.log("Probe Mining Gas", SCLogger.LOG_CALLS);			
		}
	}
	
	@Override
	public void passTime() {
		if (!isMining() && !isBuilding){
			for (ExpansionNexus nexus : getGame().getBases()){
				for (MineralPatch patch : nexus.getMinerals()){
					if (patch.getProbes().isEmpty()){
						assignToPatch(patch);
						return;
					}
				}
			}
		} else {
			if (isMining()){
				mine();
			} else if (isBuilding){
				//
			}
		}
	}

}