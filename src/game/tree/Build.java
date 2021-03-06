package game.tree;

import data.Datasheet;

/**
 * The Build command and status of a unit.
 */
public class Build {
	String nameOfUnit;
	double time;
	double buildTime;
	boolean isChronoboosted;
	double chronoboostTime;
	
	public Build(String nameOfUnit){
		this.nameOfUnit = nameOfUnit;
		this.time = 0.0;
		this.buildTime = Datasheet.getBuildTime(nameOfUnit);
		this.isChronoboosted = false;
		this.chronoboostTime = 0;
	}
	
	public void increment() {
		if (isChronoboosted){
			this.time+= 1.5;
			this.chronoboostTime++;
			if (this.chronoboostTime >= Datasheet.CHRONOBOOST_DURATION){
				this.isChronoboosted = false;
				chronoboostTime = 0;
			}
		} else {
			this.time+= 1;			
		}
	}

	public boolean hasProducedUnit(){
		return isFinished();
	}
	
	public boolean isFinished(){
		return (this.time >= this.buildTime);
	}
	
	public double getTime() {
		return time;
	}
	
	public double getBuildTime() {
		return buildTime;
	}

	public void chronoboost(){
		this.isChronoboosted = true;
	}
}
