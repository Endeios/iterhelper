package collectionhelpers.teststuff;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import collectionhelpers.Iterations;

/**
 * Complex class containing a set of {@link ComplexClass}
 * 
 * @author endeios@gmail.com
 *
 */
public class ClassWithSet {
	private String name;
	private Long value;
	private Date date;
	private Set<ComplexClass> complexClasses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<ComplexClass> getComplexClasses() {
		return complexClasses;
	}

	public void setComplexClasses(Set<ComplexClass> complexClasses) {
		this.complexClasses = complexClasses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complexClasses == null) ? 0 : complexClasses.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassWithSet other = (ClassWithSet) obj;
		if (complexClasses == null) {
			if (other.complexClasses != null)
				return false;
		//} else if (!complexClasses.equals(other.complexClasses))
		} else if (! Iterations.isEqual(complexClasses,other.complexClasses))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassWithSet [name=" + name + ", value=" + value + ", date=" + date + ", complexClasses="
				+ complexClasses + "]";
	}

	public ClassWithSet(String name, Long value, Date date, Set<ComplexClass> complexClasses) {
		super();
		this.name = name;
		this.value = value;
		this.date = date;
		this.complexClasses = complexClasses;
	}

}
