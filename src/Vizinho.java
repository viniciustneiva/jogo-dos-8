import java.util.*;

public class Vizinho {
    Map<Integer, String[]> v;

    Vizinho(){
        this.v = new HashMap<Integer, String[]>();
        this.v.put(0, new String[] {"0", "1", "0", "1", "0", "0", "0", "0", "0"});
		this.v.put(1, new String[] {"1", "0", "1", "0", "1", "0", "0", "0", "0"});
		this.v.put(2, new String[] {"0", "1", "0", "0", "0", "1", "0", "0", "0"});
		this.v.put(3, new String[] {"1", "0", "0", "0", "1", "0", "1", "0", "0"});
		this.v.put(4, new String[] {"0", "1", "0", "1", "0", "1", "0", "1", "0"});
		this.v.put(5, new String[] {"0", "0", "1", "0", "1", "0", "0", "0", "1"});
		this.v.put(6, new String[] {"0", "0", "0", "1", "0", "0", "0", "1", "0"});
		this.v.put(7, new String[] {"0", "0", "0", "0", "1", "0", "1", "0", "1"});
		this.v.put(8, new String[] {"0", "0", "0", "0", "0", "1", "0", "1", "0"});
    }

    public Map<Integer, String[]> getVizinhos(){
        return this.v;
    }

}
