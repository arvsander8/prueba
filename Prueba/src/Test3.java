import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test3 {
	
	
	List<ArrayList<Double>> lista = new ArrayList<>();
	

	@Test
	public void probarData() {
		//for()		
	}
	
	
	public void agregarData() {
		ArrayList<Double> nv1 = new ArrayList<>();
		nv1.add(12.5);
		nv1.add(16.8);
		nv1.add(0.0012);
		nv1.add(122235.2);
		
		ArrayList<Double> nv2 = new ArrayList<>();
		nv2.add(14.19);
		nv2.add(135.2);
		nv2.add(400.6);
		nv2.add(11.11);
		
		lista.add(nv1);
		lista.add(nv2);
		
	}
	
		
	
}
