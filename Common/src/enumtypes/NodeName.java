/**
 * @author burcakotlu
 * @date May 6, 2014 
 * @time 11:02:13 AM
 */
package enumtypes;

import common.Commons;

/**
 * 
 */
public enum NodeName {

	SENTINEL( 1),
	NOT_SENTINEL( 2);

	private final int nodeName;

	// Constructor
	private NodeName( int nodeName) {

		this.nodeName = nodeName;
	}

	public int getNodeName() {

		return nodeName;
	}

	public String convertEnumtoString() {

		if( this.equals( NodeName.SENTINEL))
			return Commons.SENTINEL;
		else if( this.equals( NodeName.NOT_SENTINEL))
			return Commons.NOT_SENTINEL;
		else
			return null;
	}

	@Override
	public String toString() {

		/*
		 * Either name() or super.toString() may be called here.
		 * name() is final, and always returns the exact name as specified in
		 * declaration; toString() is not final, and is intended for presentation
		 * to the user. It seems best to call name() here.
		 */

		if( this.isSentinel())
			return "Node Name: " + Commons.SENTINEL;
		else
			return "Node Name: " + Commons.NOT_SENTINEL;
	}

	/** An added method.  */
	public boolean isSentinel() {

		// only SENTINEL is 'sentinel'
		return this == SENTINEL;
	}

	/** An added method.  */
	public boolean isNotSentinel() {

		// only NOT_SENTINEL is 'not sentinel'
		return this == NOT_SENTINEL;
	}
}
