import java.util.TimerTask;
public class SimTask extends TimerTask{
	private SimEngine SimEngine1;
	private SpringApplet SpringApplet1;
	private double t;
	public SimTask(SimEngine SimEngine1, SpringApplet SpringApplet1, double t){
		this.SimEngine1=SimEngine1;
		this.SpringApplet1=SpringApplet1;
		this.t=t;
	}
	public void run(){
		SimEngine1.sim(t);
		SpringApplet1.repaint();
	}
}
