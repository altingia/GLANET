package create.ucscgenome;

import java.util.Comparator;



public class RefSeqGeneInterval implements Comparable<RefSeqGeneInterval>{
	 String chromName;
	 Integer intervalStart;
	 int intervalEnd;	 
	 String refSeqGeneName;
	 String intervalName;
	 char strand;
	 String alternateGeneName;
	 Integer geneId;
	 
	 
	 
	public Integer getGeneId() {
		return geneId;
	}
	public void setGeneId(Integer geneId) {
		this.geneId = geneId;
	}
	public String getChromName() {
		return chromName;
	}
	public void setChromName(String chromName) {
		this.chromName = chromName;
	}
	public Integer getIntervalStart() {
		return intervalStart;
	}
	public void setIntervalStart(Integer intervalStart) {
		this.intervalStart = intervalStart;
	}
	public int getIntervalEnd() {
		return intervalEnd;
	}
	public void setIntervalEnd(int intervalEnd) {
		this.intervalEnd = intervalEnd;
	}
	public String getRefSeqGeneName() {
		return refSeqGeneName;
	}
	public void setRefSeqGeneName(String refSeqGeneName) {
		this.refSeqGeneName = refSeqGeneName;
	}
	public String getIntervalName() {
		return intervalName;
	}
	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}
	public char getStrand() {
		return strand;
	}
	public void setStrand(char strand) {
		this.strand = strand;
	}
	public String getAlternateGeneName() {
		return alternateGeneName;
	}
	public void setAlternateGeneName(String alternateGeneName) {
		this.alternateGeneName = alternateGeneName;
	}

	static final Comparator<RefSeqGeneInterval> START_POSITION_ORDER = 
        new Comparator<RefSeqGeneInterval>() {
		 	public int compare(RefSeqGeneInterval refSeqGeneInterval1, RefSeqGeneInterval  refSeqGeneInterval2) {
		 		return refSeqGeneInterval1.getIntervalStart().compareTo(refSeqGeneInterval2.getIntervalStart());
		 	}
	 	};



	@Override
	public int compareTo(RefSeqGeneInterval refSeqGeneInterval) {
		if (this.intervalStart.intValue() < refSeqGeneInterval.getIntervalStart().intValue())
			return -1;
		else if (this.intervalStart.intValue() == refSeqGeneInterval.getIntervalStart().intValue())
			return 0;
		else 
			return 1;
	
	
	}
	 
}