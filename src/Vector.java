/**
 * THIS CLASS REPRESENTS A VECTOR OF EUCLIDEAN 3-SPACE
 */

import java.util.Arrays;
import static java.lang.Math.*;
public class Vector {
	public double[] coordinates;
	
	public Vector(double[] coordinates){
		this.coordinates = coordinates;
	}
	
	public Vector(double x, double y, double z){
		this.coordinates = new double[]{x, y, z};
	}
	
	/**
	 * 
	 * @param v, the vector one desires to take the dot product with
	 * @return the dot product of this vector with vector v
	 */
	public double dot(Vector v){
		double result = 0;
		for(int i = 0; i < coordinates.length; i++){
			result += coordinates[i] * v.coordinates[i];
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param v, the vector one desires to take the cross product with
	 * @return the cross product this * v (in this order)
	 */
	public Vector cross(Vector v){
		double[] result = new double[3];
		result[0] = coordinates[1] * v.coordinates[2] - coordinates[2] * v.coordinates[1];
		result[1] = coordinates[2] * v.coordinates[0] - coordinates[0] * v.coordinates[2];
		result[2] = coordinates[0] * v.coordinates[1] - coordinates[1] * v.coordinates[0];
		
		return new Vector(result);
	}
	
	/**
	 * 
	 * @param d
	 * @result multiplies this Vector object by the scalar d
	 */
	public void multiply(double d){
		for(int i = 0; i < coordinates.length; i++){
			coordinates[i] *= d;
		}
	}

	/**
	 * 
	 * @param v, the vector to be added to this Vector
	 * @result v has been added to this vector
	 */
	public void add(Vector v){
		for(int i = 0; i < coordinates.length; i++){
			coordinates[i] += v.coordinates[i];
		}
	}

	/**
	 * 
	 * @param v, the vector you wish to subtract from this one
	 * @result this vector has been altered, where v is now subtracted from it
	 */
	public void subtract(Vector v){
		for(int i = 0; i < coordinates.length; i++){
			coordinates[i] -= v.coordinates[i];
		}
	}
	
	/**
	 * 
	 * @param v, the Vector object you desire to project onto
	 * @return a Vector object indicating the desired projection
	 */
	public Vector project(Vector v){
		double tempScalar = this.dot(v) / v.dot(v);
		v.multiply(tempScalar);
		return v;
	}
	
	public Vector project(Plane p){
		this.subtract(this.project(p.normalVector));
		return this;
	}
	
	/**
	 * Determines if this Vector is parallel to a given vector v
	 * @param v
	 * @return true if this vector is parallel to v. If one of the vectors is the 0 vector, it will always return true
	 */
	public boolean isParallel(Vector v){
		if(this.dot(v) == this.length() * v.length()) return true;
		return false;
	}
	
	/**
	 * Determines if this Vector is perpendicular to a given vector v
	 * @param v
	 * @return true if this vector is perpendicular to v
	 */
	public boolean isPerpendicular(Vector v){
		if(this.dot(v) == 0) return true;
		return false;
	}
	
	/**
	 * @return a String representation of this Vector Object
	 */
	public String toString(){
		return Arrays.toString(coordinates);
	}

	/**
	 * 
	 * @return the length of this Vector under the Euclidean norm
	 */
	public double length(){
		double lengthSquared = 0;
		for(int i = 0; i < coordinates.length; i++){
			lengthSquared += coordinates[i] * coordinates[i];
		}
		
		return sqrt(lengthSquared);
	}

	
}
