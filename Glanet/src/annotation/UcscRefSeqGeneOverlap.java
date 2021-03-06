/**
 * @author Burcak Otlu
 * Jan 16, 2014
 * 10:30:52 AM
 * 2014
 *
 * 
 */
package annotation;

import java.util.List;
import enumtypes.IntervalName;

public class UcscRefSeqGeneOverlap {

	// example
	// refSeqGeneName NM_002979
	// intervalName INTRON
	// intervalNumber 15
	// geneHugoSymbol SCP2
	// geneEntrezId 6342

	String refSeqGeneName;
	String geneHugoSymbol;
	List<String> keggPathwayNameList;

	IntervalName intervalName;
	int intervalNumber;
	int geneEntrezId;
	int low;
	int high;

	public String getRefSeqGeneName() {

		return refSeqGeneName;
	}

	public void setRefSeqGeneName( String refSeqGeneName) {

		this.refSeqGeneName = refSeqGeneName;
	}

	public IntervalName getIntervalName() {

		return intervalName;
	}

	public void setIntervalName( IntervalName intervalName) {

		this.intervalName = intervalName;
	}

	public int getIntervalNumber() {

		return intervalNumber;
	}

	public void setIntervalNumber( int intervalNumber) {

		this.intervalNumber = intervalNumber;
	}

	public String getGeneHugoSymbol() {

		return geneHugoSymbol;
	}

	public void setGeneHugoSymbol( String geneHugoSymbol) {

		this.geneHugoSymbol = geneHugoSymbol;
	}

	public int getGeneEntrezId() {

		return geneEntrezId;
	}

	public void setGeneEntrezId( int geneEntrezId) {

		this.geneEntrezId = geneEntrezId;
	}

	public int getLow() {

		return low;
	}

	public void setLow( int low) {

		this.low = low;
	}

	public int getHigh() {

		return high;
	}

	public void setHigh( int high) {

		this.high = high;
	}

	public List<String> getKeggPathwayNameList() {

		return keggPathwayNameList;
	}

	public void setKeggPathwayNameList( List<String> keggPathwayNameList) {

		this.keggPathwayNameList = keggPathwayNameList;
	}

	public UcscRefSeqGeneOverlap( String refSeqGeneName, IntervalName intervalName, int intervalNumber,
			String geneHugoSymbol, int geneEntrezId, int low, int high, List<String> keggPathwayNameList) {

		super();
		this.refSeqGeneName = refSeqGeneName;
		this.intervalName = intervalName;
		this.intervalNumber = intervalNumber;
		this.geneHugoSymbol = geneHugoSymbol;
		this.geneEntrezId = geneEntrezId;
		this.low = low;
		this.high = high;
		this.keggPathwayNameList = keggPathwayNameList;
	}

	/**
	 * 
	 */
	public UcscRefSeqGeneOverlap() {

		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main( String[] args) {

		// TODO Auto-generated method stub

	}

}
