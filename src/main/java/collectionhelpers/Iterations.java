package collectionhelpers;

import java.util.Collection;
import java.util.Objects;

/**
 * Helper class for boring stuff on iterations, kept here both as snippet and as
 * personal library
 * 
 * this software is under GPLv3
 * 
 * @author endeios@gmail.com
 *
 */
public class Iterations {

	/**
	 * Returns true if the elements in a are all contained in b and a and b have
	 * the same size. Uses the contained element equals method for equality.
	 * 
	 * @param collectionA
	 *            the first collection
	 * @param collectionB
	 *            the second collection
	 * @return true if all elements of a are also in b, and a and b have same
	 *         size
	 */
	public static <T> boolean isEqual(Collection<T> collectionA, Collection<T> collectionB) {
		Objects.requireNonNull(collectionA, "First argument of function should not be null");
		Objects.requireNonNull(collectionB, "Second argument of function should not be null");
		
		return collectionA.stream().map(elementOfA -> {
			return collectionB.stream().map(elementOfB -> {
				return elementOfA.equals(elementOfB);
			}).reduce(false, Boolean::logicalOr);
		}).reduce(true, Boolean::logicalAnd) && collectionA.size() == collectionB.size();

	}
}

