/**
 * 
 * THIS CLASS REPRESENTS A PLANE IN EUCLIDEAN 3-SPACE
 *
 */
public class Plane {
	/**
	 * A Vector normal to the plane; if it has coordinates a, b, c, then the equation of the plane is 
	 * ax + by + cz = summedValue
	 */
	public Vector normalVector;
	
	public double summedValue;
	
	public Plane(Vector v, double summedValue){
		this.normalVector = v;
		this.summedValue = summedValue;
	}
	
	public Plane(double a, double b, double c, double summedValue){
		normalVector = new Vector(a, b, c);
		this.summedValue = summedValue;
	}
	
	/**
	 * Determines if this plane is parallel to a given plane p
	 * @param p
	 * @return true if this plane is parallel to a given plane p, where true will be returned for planes with normalVector 0, 0, 0
	 */
	public boolean isParallel(Plane p){
		return this.normalVector.isParallel(p.normalVector);
	}

}
