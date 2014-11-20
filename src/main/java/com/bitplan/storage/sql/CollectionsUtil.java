package com.bitplan.storage.sql;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.persistence.indirection.IndirectList;

/**
 * this class works around
 * http://stackoverflow.com/questions/26816650/java8-collections
 * -sort-sometimes-does-not-sort-jpa-returned-lists until the official fix of
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=446236 is out
 * 
 * @FIXME Use Collections.sort directly again
 * @author wf
 *
 */
public class CollectionsUtil {

	/**
	 * works around https://bugs.eclipse.org/bugs/show_bug.cgi?id=446236
	 * 
	 * @param list - the list to be sorted
	 * @param compartor - the comparator to be used
	 */
	public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
		// check whether the list is an EclipseLink IndirectList
		if (list instanceof IndirectList) {
			// get it
			IndirectList iList = (IndirectList) list;
			// find the true list
			Object sortTargetObject = iList.getDelegateObject();
	    // is this a list?
			if (sortTargetObject instanceof List<?>) {
				@SuppressWarnings("unchecked")
				List<T> sortTarget = (List<T>) sortTargetObject;
				Collections.sort(sortTarget, comparator);
			} else {
				throw new IllegalStateException("CollectionUtil.sort called with invalid non List<?> list parameter: "+list.getClass().getName());
			}
		} else {
			Collections.sort(list, comparator);
		}
	}

}
