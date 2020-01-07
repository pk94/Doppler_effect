package Animacja;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Animation 
{   
    public static void main(String[] args) throws InterruptedException, LineUnavailableException 
    {
    	JFrame frame = new JFrame("Rysowanie");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        animationPanel panel = new animationPanel ();
        SoundThread a=new SoundThread(1,panel);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        a.start();
        panel.run();
    }
}

 class animationPanel extends JPanel 
{
	XYChartTest wykres =new XYChartTest(this);
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	ArrayList<Integer> xtable = new ArrayList<Integer>();
	ArrayList<Integer> ytable = new ArrayList<Integer>();
	ArrayList<Integer> timetable = new ArrayList<Integer>();
	Sound sound=new Sound ();
	//w dwoch linijkach ponizej mozna sterowac parametrami animacji
	int initialx=100, initialy=500,time=0, period=10, initialListenerX=800,initialListenerY=600;
	double wavevelocity=2, sourceXVelocity=1, sourceYVelocity=0;
	double frequency, initialFrequency=0.1;
	double angle;		
	Ball ball= new Ball (2, initialx, initialy, sourceXVelocity, sourceYVelocity);
	private static final long serialVersionUID = 1L;
	public animationPanel ()
	{
		for (int i=0; i<500; i++)
		{
			timetable.add(0);
			for (int k=1; k<500; k++)
			{
				timetable.add(timetable.get(k-1).intValue()+period);
			}
		}
	}
	
    public Dimension getPreferredSize() 
    {
        return new Dimension(2000,2000);
    }
    
 	public void run() throws InterruptedException, LineUnavailableException 
 	{
 		while(true)
 		{
 			time++;
 			for(int i=0; i<500; i++)
 			{
 				if (time==(timetable.get(i)).intValue())
 				{
 					xtable.add((int) Math.round(ball.getXVelocity()*(timetable.get(i)).intValue()+initialx));
 					ytable.add((int) Math.round(ball.getYVelocity()*(timetable.get(i)).intValue()+initialy));
 					angle=(calculateAngle(initialListenerX,initialListenerY,(int) sourceXVelocity,(int)sourceYVelocity,i-1));
 					System.out.println(angle);
 					frequency=Math.abs(initialFrequency*wavevelocity/(wavevelocity-angle*Math.sqrt(Math.pow(sourceXVelocity,2)+Math.pow(sourceYVelocity,2))));
 					//System.out.println(frequency);
 					//System.out.println(Math.sqrt(Math.pow(sourceXVelocity,2)+Math.pow(sourceYVelocity,2)));
 					//System.out.println(wavevelocity);
 					wykres.dataSet.add(time,frequency);
 				}
 			}
 			if (time%period==0)
	            {
	            	Shape r = new Ellipse2D.Float();
	            	shapes.add(r);
	            }
 			try 
 			{
 				Thread.sleep(30);
 			} catch (InterruptedException e) 
 			{
 				e.printStackTrace();
 			}			
 			SwingUtilities.invokeLater(new Runnable() 
 			{
 				
				@Override
 				public void run() 
 				{
 					repaint();
 				}
 			});			
 		}		
 		}

    protected void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
        g2.setColor(Color.YELLOW);
        fillCircle(g2,(int) Math.round(ball.getXVelocity()*time+initialx),(int) Math.round(ball.getYVelocity()*time+initialy),10);
        g2.setColor(Color.RED);
        fillCircle(g2,initialListenerX, initialListenerY,10);
        g2.setColor(Color.BLACK);
        drawCircle(g2,(int) Math.round(ball.getXVelocity()*time+initialx),(int) Math.round(ball.getYVelocity()*time+initialy),10);
        drawCircle(g2,initialListenerX, initialListenerY,10);
		for (int k = 0; k< shapes.size(); k++) {
			double a=wavevelocity*(time-period-(timetable.get(k)).intValue())*2;
			((Ellipse2D.Float)shapes.get(k)).setFrame((int) Math.round((xtable.get(k)).intValue()-a/2),(int) Math.round((ytable.get(k)).intValue()-a/2),(int) Math.round(a),(int) Math.round(a));
			g2.setPaint(Color.BLACK);
			g2.draw(shapes.get(k));
		}
    }
    
    void drawCircle(Graphics2D cg, int xCenter, int yCenter, int r) {
		cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
		}
    void fillCircle(Graphics2D cg, int xCenter, int yCenter, int r) {
		cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
		}
    double calculateAngle(int xListener, int yListener, int xFirstVector, int yFirstVector, int a) {
			int xSecondVector=xListener-xtable.get(a);
			int ySecondVector=yListener-ytable.get(a);
			double dotProduct=xFirstVector*xSecondVector+yFirstVector*ySecondVector;
			double firstVectorLength=Math.sqrt(Math.pow(xFirstVector,2)+Math.pow(yFirstVector,2));
			double secondVectorLength=Math.sqrt(Math.pow(xSecondVector,2)+Math.pow(ySecondVector,2));
			return dotProduct/(firstVectorLength+secondVectorLength);
		}
}
 


