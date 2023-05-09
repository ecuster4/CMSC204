public class Road 
{
	private Town source, destination;
	private int i;
	private String roadName;

	public Road(Town source,Town destination,int degrees,java.lang.String name) {
		this.source = source;
		this.destination = destination;
		this.i = degrees;
		this.roadName=name;
	}
	
	public Road(Town source,Town destination,java.lang.String name) {
		this.source = source;
		this.destination=destination;
		i = 1;
		this.roadName=name;
		
	}
	public boolean contains(Town town) {
		if ( source.equals(town)|| destination.equals(town)) {
			return true;
		}
		else
			return false;
	}
	public java.lang.String toString(){
		return roadName;
	}
	public java.lang.String getName(){
		return roadName;
	}
	public Town getDestination() {
		return destination;
	
	}
	public Town getSource() {
		return source;
	}
	public int compareTo(Road o) {
		int r = roadName.compareTo(o.getName());
		return r;
	}
	public int getWeight() {
		return i;
	}
	public boolean equals(java.lang.Object r) {
		Road c = (Road) r;
		if(c.getSource().equals(new Town(source)) && c.getDestination().equals(new Town(destination)) || c.getSource().equals(new Town(destination)) && c.getDestination().equals(new Town(source))) {
			return true;
		}
		return false;
	}
}
