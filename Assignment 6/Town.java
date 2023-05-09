
public class Town {
	/**
	 * 
	 * @author Andy Nguyen
	 *
	 */
	private String townName;
	public Town(String name) {
		this.townName = name;
		
	}
	public Town(Town templateTown) {
		this.townName = templateTown.getName();
	}
	public java.lang.String getName(){
		return townName;
	}
	public int compareTo(Town o) {
		int t = townName.compareTo(o.getName());
		return t;
	}
	
	public java.lang.String toString(){
		return townName;
	}
	public int hashCode() {
		int t = townName.hashCode();
		return t;
	}
	public boolean equals(java.lang.Object obj) {
		Town tName = (Town)obj;
		boolean n = townName.equals(tName.getName());
		return n;
	}
}
