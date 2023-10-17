// used to store a pair of word 
public class Pair<P> {
	
	private P first;
	private P second;
	
	public Pair(P first, P second) {
		this.first = first;
		this.second = second;
	}
	
	// returns first element
	public P first() {
		return first;
	}
	
	// returns second element
	public P second() {
		return second;
	}
}