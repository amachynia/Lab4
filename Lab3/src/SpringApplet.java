import javax.swing.JApplet;
import java.util.Timer;
import java.awt.*;
public class SpringApplet extends JApplet {
	private SimEngine SimEngine1;
	private SimTask SimTask1;
	private Timer Timer1;
	private int height=900;
	private int width=1200;
	public int scale=20;
	
	public void init()
	{	
		Vector2D z1 = new Vector2D(600,200);
		Vector2D pm1 = new Vector2D(0,0);
		Vector2D g1 = new Vector2D(0,-9.81);
		Vector2D v1 = new Vector2D(0,0);
		SimEngine1= new SimEngine(2, 3, 0.1, z1, pm1, g1, 1, v1);
		SimTask1 = new SimTask(SimEngine1, this, 0.2);
		Timer1 = new Timer();
		Timer1.scheduleAtFixedRate(SimTask1, 0, 200);
		setBackground(Color.white);
		setSize(width, height);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.black); //ustawienie koloru
		g.clearRect(0, 0, width, height);
		g.drawLine(SimEngine1.getZ().xInt()-3*scale, SimEngine1.getZ().yInt(), SimEngine1.getZ().xInt()+3*scale, SimEngine1.getZ().yInt());
		g.drawLine(SimEngine1.getZ().xInt(), SimEngine1.getZ().yInt(), SimEngine1.getZ().xInt()+SimEngine1.getPM().xInt()*scale, SimEngine1.getZ().yInt()-SimEngine1.getPM().yInt()*scale);
		g.fillOval(SimEngine1.getZ().xInt()+SimEngine1.getPM().xInt()*scale-scale, SimEngine1.getZ().yInt()-SimEngine1.getPM().yInt()*scale-scale, 2*scale, 2*scale);
	}
}
