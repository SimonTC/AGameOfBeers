package dk.itu.KF13.TheSim.Game.World;

public class LocPoliceStation extends MasterLocation {

	public LocPoliceStation(int xInput, int yInput) {
		super(xInput, yInput);
	}

	@Override
	public String getDescription() {
		return "This is the police station. You see a criminal being beaten by five big police officers.";
	}

	@Override
	public void locationSpecificAction() {
		// TODO Auto-generated method stub
		
	}

}
