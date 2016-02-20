package collectionhelpers;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;

import collectionhelpers.teststuff.ComplexClass;

@Test(groups={"unit"})
public class BaseTest {
	
	private static final String NAME = "name";
	private static final Long VALUE = 1000000000L;
	private static final Date DATE = new Date();

	@Test
	public void small_equals_lists_are_equals(){
		List<ComplexClass> collectionA = new ArrayList<ComplexClass>();
		List<ComplexClass> collectionB = new ArrayList<ComplexClass>();
		
		collectionA.add(new ComplexClass(NAME, VALUE, DATE));
		collectionB.add(new ComplexClass(NAME, VALUE, DATE));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void small_equals_setss_are_equals(){
		Set<ComplexClass> collectionA = new HashSet<ComplexClass>();
		Set<ComplexClass> collectionB = new HashSet<ComplexClass>();
		
		collectionA.add(new ComplexClass(NAME, VALUE, DATE));
		collectionB.add(new ComplexClass(NAME, VALUE, DATE));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_equals_sets_are_equals(){
		String name = "a string named ";
		
		Set<ComplexClass> collectionA = new HashSet<ComplexClass>();
		Set<ComplexClass> collectionB = new HashSet<ComplexClass>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ComplexClass(name+1,(long) i, date));
			collectionB.add(new ComplexClass(name+1,(long) i, date));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent(){
		String name = "a string named ";
		
		Set<ComplexClass> collectionA = new HashSet<ComplexClass>();
		Set<ComplexClass> collectionB = new HashSet<ComplexClass>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ComplexClass(name+1,(long) i, date));
			collectionB.add(new ComplexClass(name+2,(long) i+1, date));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent_for_lenght(){
		String name = "a string named ";
		
		Set<ComplexClass> collectionA = new HashSet<ComplexClass>();
		Set<ComplexClass> collectionB = new HashSet<ComplexClass>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ComplexClass(name+2,(long) i, date));
			collectionB.add(new ComplexClass(name+2,(long) i, date));
		}
		
		collectionB.add(new ComplexClass(name+2,(long) 10000, DATE));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}

}
