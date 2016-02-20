package collectionhelpers;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.*;

import collectionhelpers.teststuff.ClassWithMap;
import collectionhelpers.teststuff.ComplexClass;

@Test(groups={"unit"})
public class MapTest {
	
	private static final String NAME = "name";
	private static final Long VALUE = 1000000000L;
	private static final Date DATE = new Date();
	
	private static Map<String,Object> myMap(){
		return new HashMap<String,Object>(){{
			put("key1",NAME);
			put("key2",VALUE);
			put("key1",DATE);
		}};
	}

	@Test
	public void small_equals_lists_are_equals(){
		List<ClassWithMap> collectionA = new ArrayList<ClassWithMap>();
		List<ClassWithMap> collectionB = new ArrayList<ClassWithMap>();
		
		collectionA.add(new ClassWithMap(NAME, VALUE, DATE, myMap()));
		collectionB.add(new ClassWithMap(NAME, VALUE, DATE, myMap()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void small_equals_setss_are_equals(){
		Set<ClassWithMap> collectionA = new HashSet<ClassWithMap>();
		Set<ClassWithMap> collectionB = new HashSet<ClassWithMap>();
		
		collectionA.add(new ClassWithMap(NAME, VALUE, DATE,myMap()));
		collectionB.add(new ClassWithMap(NAME, VALUE, DATE,myMap()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_equals_sets_are_equals(){
		String name = "a string named ";
		
		Set<ClassWithMap> collectionA = new HashSet<ClassWithMap>();
		Set<ClassWithMap> collectionB = new HashSet<ClassWithMap>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithMap(name+1,(long) i, date,myMap()));
			collectionB.add(new ClassWithMap(name+1,(long) i, date,myMap()));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent(){
		String name = "a string named ";
		
		Set<ClassWithMap> collectionA = new HashSet<ClassWithMap>();
		Set<ClassWithMap> collectionB = new HashSet<ClassWithMap>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithMap(name+1,(long) i, date,myMap()));
			collectionB.add(new ClassWithMap(name+2,(long) i+1, date,myMap()));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent_for_lenght(){
		String name = "a string named ";
		
		Set<ClassWithMap> collectionA = new HashSet<ClassWithMap>();
		Set<ClassWithMap> collectionB = new HashSet<ClassWithMap>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithMap(name+2,(long) i, date,myMap()));
			collectionB.add(new ClassWithMap(name+2,(long) i, date,myMap()));
		}
		
		collectionB.add(new ClassWithMap(name+2,(long) 10000, DATE,myMap()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}

}

