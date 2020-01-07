package Animacja;

public class Ball 
{
	private double radius;
	private double x,y;
	private double xVelocity;
	private double yVelocity;
	
	//tworze konstruktor domyslny
	public Ball()
	{
		radius = 0;
		x = 0;
		y = 0;
		xVelocity = 0;
		yVelocity = 0; 
	}
	
	//tworze konstruktor wlasciowy
	public Ball(double Radius,double X,double Y,double XVelocity,double YVelocity)
	{
		radius = Radius;
		x = X;
		y = Y;
		xVelocity = XVelocity;
		yVelocity = YVelocity;
		
	}
	
	//funkcja zwracajaca radius
	public double getRadius()
	{
		return radius;
	}
	
	//pobierajaca radius
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	//funkcja zwracajaca x
	public double getX()
	{
		return x;
	}
		
	//pobierajaca x
	public void setX(double x)
	{
		this.x = x;
	}
	
	//funkcja zwracajaca y
	public double getY()
	{
		return y;
	}
			
	//pobierajaca y
	public void setY(double y)
	{
		this.y = y;
	}
	
	//funkcja zwracajaca xVelocity
	public double getXVelocity()
	{
		return xVelocity;
	}
				
	//pobierajaca xVelocity
	public void setXVelocity(double xVelocity)
	{
		this.xVelocity = xVelocity;
	}

	//funkcja zwracajaca yVelocity
	public double getYVelocity()
	{
		return yVelocity;
	}
				
	//pobierajaca yVelocity
	public void setYVelocity(double yVelocity)
	{
		this.yVelocity = yVelocity;
	}
}
