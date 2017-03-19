
public class Main {
	public static void main(String[] args){
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(2, 3, 4);
		Plane p = new Plane(4, 5, 6, 0);
		System.out.println(v1.project(v2));
		System.out.println(v1.project(p));
	}
}
