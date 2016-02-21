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

import collectionhelpers.teststuff.ClassWithSet;
import collectionhelpers.teststuff.ComplexClass;

@Test(groups={"unit"})
public class SetTest {
	
	private static final String NAME = "name";
	private static final Long VALUE = 1000000000L;
	private static final Date DATE = new Date();
	
	private static Set<ComplexClass> mySet(){
		return new HashSet<ComplexClass>(){{
			new ComplexClass(NAME+1, VALUE+1, DATE);
			new ComplexClass(NAME+2, VALUE+2, DATE);
			new ComplexClass(NAME+3, VALUE+3, DATE);
			new ComplexClass(NAME+4, VALUE+4, DATE);
		}};
	}

	@Test
	public void small_equals_lists_are_equals(){
		List<ClassWithSet> collectionA = new ArrayList<ClassWithSet>();
		List<ClassWithSet> collectionB = new ArrayList<ClassWithSet>();
		
		collectionA.add(new ClassWithSet(NAME, VALUE, DATE, mySet()));
		collectionB.add(new ClassWithSet(NAME, VALUE, DATE, mySet()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void small_equals_setss_are_equals(){
		Set<ClassWithSet> collectionA = new HashSet<ClassWithSet>();
		Set<ClassWithSet> collectionB = new HashSet<ClassWithSet>();
		
		collectionA.add(new ClassWithSet(NAME, VALUE, DATE,mySet()));
		collectionB.add(new ClassWithSet(NAME, VALUE, DATE,mySet()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_equals_sets_are_equals(){
		String name = "a string named ";
		
		Set<ClassWithSet> collectionA = new HashSet<ClassWithSet>();
		Set<ClassWithSet> collectionB = new HashSet<ClassWithSet>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithSet(name+1,(long) i, date,mySet()));
			collectionB.add(new ClassWithSet(name+1,(long) i, date,mySet()));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertTrue(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent(){
		String name = "a string named ";
		
		Set<ClassWithSet> collectionA = new HashSet<ClassWithSet>();
		Set<ClassWithSet> collectionB = new HashSet<ClassWithSet>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithSet(name+1,(long) i, date,mySet()));
			collectionB.add(new ClassWithSet(name+2,(long) i+1, date,mySet()));
		}
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}
	
	@Test
	public void big_different_sets_are_diferent_for_lenght(){
		String name = "a string named ";
		
		Set<ClassWithSet> collectionA = new HashSet<ClassWithSet>();
		Set<ClassWithSet> collectionB = new HashSet<ClassWithSet>();
		
		for(int i =0;i<1000;i++){
			Date date = new Date();
			collectionA.add(new ClassWithSet(name+2,(long) i, date,mySet()));
			collectionB.add(new ClassWithSet(name+2,(long) i, date,mySet()));
		}
		
		collectionB.add(new ClassWithSet(name+2,(long) 10000, DATE,mySet()));
		
		System.out.println(collectionA);
		System.out.println(collectionB);
		
		Assert.assertFalse(Iterations.isEqual(collectionA, collectionB), "Collections should be equals");
	}

}

