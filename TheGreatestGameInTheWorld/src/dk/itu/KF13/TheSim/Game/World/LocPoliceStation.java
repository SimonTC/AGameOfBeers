package dk.itu.KF13.TheSim.Game.World;

import java.util.List;

public class LocPoliceStation implements Location {
	int xPos, yPos;
	
	public LocPoliceStation (int xInput, int yInput){
		xPos = xInput;
		yPos = yInput;
	}
	
	@Override
	public List<Location> getExits(Direction direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		return "This is the police station. You see a criminal being beaten by five big police officers.";
	}

}
