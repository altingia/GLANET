/**
 * 
 */
package test;

import java.util.Enumeration;

import enumtypes.ChromosomeName;

/**
 * @author Bur�ak
 *
 */
public class EnumerationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (ChromosomeName chrName:ChromosomeName.values() )
		       System.out.println(chrName.convertEnumtoString());

	}

}
