/**
 * 
 */
package datadrivenexperiment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import auxiliary.FileOperations;
import common.Commons;
import enrichment.InputLine;
import enumtypes.ChromosomeName;
import enumtypes.DataDrivenExperimentCellLineType;
import enumtypes.DataDrivenExperimentDnaseOverlapExclusionType;
import enumtypes.DataDrivenExperimentGeneType;
import enumtypes.DataDrivenExperimentTPMType;
import intervaltree.IntervalTree;
import intervaltree.IntervalTreeNode;

/**
 * @author Burcak Otlu
 * @date May 1, 2015
 * @project Glanet 
 * 
 * Data Driven Experiment Step 3
 * 
 * In this class
 * Simulation Data for GLANET Data Driven Experiment is created.
 * 
 * Program arguments are as follows
 * 
 * GLANET folder (which is the parent of Data Folder)
 * cellLineType
 * geneType
 * TPM
 * Number of simulations
 * Number of intervals in each simulation
 *
 */
public class Step3_DDE_DataCreation {

	public static String getIntervalPoolFileName(
			DataDrivenExperimentCellLineType cellLineType,
			DataDrivenExperimentGeneType geneType,
			DataDrivenExperimentTPMType topPercentageType,
			DataDrivenExperimentDnaseOverlapExclusionType dnaseOverlapExclusionType, 
			String dataDrivenExperimentFolder) {

		String intervalPoolFileName = dataDrivenExperimentFolder + Commons.DDE_DNASEOVERLAPSEXCLUDED_INTERVAL_POOL + System.getProperty( "file.separator") + cellLineType.convertEnumtoString() + "_" +  geneType.convertEnumtoString() + "_" + topPercentageType.convertEnumtoString() + "_" + dnaseOverlapExclusionType.convertEnumtoString() + "_IntervalPool.txt";
		return intervalPoolFileName;
	}

	public static void fillIntervalPoolData( String intervalPoolFileName, List<InputLine> intervalPoolData) {

		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;

		ChromosomeName chrName;
		int low;
		int high;

		InputLine inputLine = null;

		try{

			fileReader = FileOperations.createFileReader( intervalPoolFileName);
			bufferedReader = new BufferedReader( fileReader);

			// chr1 68591 69191 "OR4F5"
			// chrX 2669591 2670191

			while( ( strLine = bufferedReader.readLine()) != null){

				indexofFirstTab = strLine.indexOf( '\t');
				indexofSecondTab = ( indexofFirstTab > 0)?strLine.indexOf( '\t', indexofFirstTab + 1):-1;
				indexofThirdTab = ( indexofSecondTab > 0)?strLine.indexOf( '\t', indexofSecondTab + 1):-1;

				chrName = ChromosomeName.convertStringtoEnum( strLine.substring( 0, indexofFirstTab));
				low = Integer.parseInt( strLine.substring( indexofFirstTab + 1, indexofSecondTab));

				if( indexofThirdTab > 0){
					high = Integer.parseInt( strLine.substring( indexofSecondTab + 1, indexofThirdTab));
				}else{
					high = Integer.parseInt( strLine.substring( indexofSecondTab + 1));
				}

				inputLine = new InputLine( chrName, low, high);
				intervalPoolData.add( inputLine);

			}// End of while

			// Close bufferedReader
			bufferedReader.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//28 OCT 2015 starts
	public static void selectSimulationDataOneByOne(
			int numberofIntervalsInEachSimulation,
			List<InputLine> intervalPoolData,
			int numberofIntervalsInTheIntervalPool,
			List<Integer> randomIntervalIndexes){
		
		IntervalTree intervalTree = null;
		IntervalTreeNode intervalTreeNode = null;
		InputLine inputLine = null;
		
		Random rand = new Random();
		int index = 0;
		
		int i= 0;

		while( i < numberofIntervalsInEachSimulation){
			
			//Get a random index
			index = rand.nextInt(numberofIntervalsInTheIntervalPool);
			
			//Get another random index as soon as it is already selected
			while(randomIntervalIndexes.contains(index)){
				index = rand.nextInt(numberofIntervalsInTheIntervalPool);
			}//End of WHILE
			
			//Get the corresponding inputLine
			inputLine = intervalPoolData.get(index);
			
			//Create intervalTreeNode from this inputLine
			intervalTreeNode = new IntervalTreeNode(inputLine.getChrName(),inputLine.getLow(),inputLine.getHigh());
			
			//Insertion for the first time
			if (intervalTree == null){
				
				intervalTree = new IntervalTree();
				intervalTree.intervalTreeInsert(intervalTree, intervalTreeNode);
				randomIntervalIndexes.add(index);
				i++;
				
			}else{
				
				List<IntervalTreeNode>  overlappedNodeList = new ArrayList<IntervalTreeNode>();
				
				IntervalTree.findAllOverlappingIntervalsCheckingChrName(
						overlappedNodeList, 
						intervalTree.getRoot(),
						intervalTreeNode);
				
				
				// There is NO overlap
				// Then add this interval
				if(overlappedNodeList != null && overlappedNodeList.size() == 0){
					// insert this interval
					intervalTree.intervalTreeInsert(intervalTree, intervalTreeNode);
					randomIntervalIndexes.add(index);
					i++;
				}
				
				
			}//End of ELSE
			
		}// End of WHILE 
		
	}
	//28 OCT 2015 ends
	
//	public static void fillRandomIntervalIndexes(
//			int[] randomIntervalIndexes, 
//			int numberofIntervalsInEachSimulation,
//			int numberofIntervalsInIntervalPool) {
//
//		Random rand = new Random();
//
//		for( int i = 0; i < numberofIntervalsInEachSimulation; i++){
//			randomIntervalIndexes[i] = rand.nextInt( numberofIntervalsInIntervalPool);
//		}// End of For
//
//	}

	public static void writeSimulationData(
			List<Integer> randomIntervalIndexes, 
			List<InputLine> intervalPoolData,
			String simulationDataFile) {

		InputLine inputLine = null;

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try{
			fileWriter = FileOperations.createFileWriter( simulationDataFile);
			bufferedWriter = new BufferedWriter( fileWriter);

			for( int i = 0; i < randomIntervalIndexes.size(); i++){
				inputLine = intervalPoolData.get(randomIntervalIndexes.get(i));

				bufferedWriter.write( inputLine.getChrName().convertEnumtoString() + "\t" + inputLine.getLow() + "\t" + inputLine.getHigh() + System.getProperty( "line.separator"));
			}

			// Close bufferedWriter
			bufferedWriter.close();

		}catch( IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void generateRandomSimulationData( 
			String dataDrivenExperimentFolder, 
			DataDrivenExperimentCellLineType cellLineType,
			DataDrivenExperimentGeneType geneType,
			DataDrivenExperimentTPMType tpmType,
			DataDrivenExperimentDnaseOverlapExclusionType dnaseOverlapExclusionType, 
			String intervalPoolFileName, 
			int numberofSimulations,
			int numberofIntervalsInEachSimulation) {

		// There will be one interval pool
		List<InputLine> intervalPoolData = new ArrayList<InputLine>();

		// There will be one for each simulation
		String simulationDataFile = null;
		List<Integer> randomIntervalIndexes = null;

		fillIntervalPoolData(intervalPoolFileName, intervalPoolData);

		String baseFolderName = null;

		// Set baseFolderName
		baseFolderName = dataDrivenExperimentFolder + System.getProperty("file.separator") + Commons.DDE_DATA + System.getProperty( "file.separator") + cellLineType.convertEnumtoString() + "_" +  geneType.convertEnumtoString() + "_" + tpmType.convertEnumtoString() + "_" + dnaseOverlapExclusionType.convertEnumtoString();

		//Pick intervals for each Simulation
		for( int i = 0; i < numberofSimulations; i++){

			// Set simulationDataFile
			simulationDataFile = baseFolderName + "_" +  Commons.DDE_RUN + i + ".txt";

			if (numberofIntervalsInEachSimulation > intervalPoolData.size()){
				System.out.println("There is a situation, numberofIntervalsInEachSimulation" + "\t" + numberofIntervalsInEachSimulation + "\t" + "is greater than" + "\t" + "numberofTotalIntervals in the intervalPool which is" + intervalPoolData.size());
				System.out.println("IntervalPoolFileName is " + intervalPoolFileName);
				System.out.println("cellLineType: " + cellLineType + " geneType: " + geneType + " tpmType: " + tpmType + " dnaseOverlapExclusionType: " + dnaseOverlapExclusionType );
				
				
			}else{
				
				//Please notice that if there are not many intervals, finding non-overlapping intervals will be problematic.
				//It may cause infinite loop.
				
				//Initialize for each simulation
				randomIntervalIndexes = new ArrayList<Integer>();
				
				//Select intervals from interval pool one by one
				//So that there is no overlap between the selected intervals
				selectSimulationDataOneByOne(
						numberofIntervalsInEachSimulation,
						intervalPoolData,
						intervalPoolData.size(),
						randomIntervalIndexes);

				// Write Simulation Data
				writeSimulationData(
						randomIntervalIndexes, 
						intervalPoolData, 
						simulationDataFile);
			}
						

		}// End of for each simulation

	}

	/*
	 * args[0] = GLANET folder (which is the parent of Data folder inside)
	 * args[1] = cellLineType
	 * args[2] = geneType
	 * args[3] = tpm value (0.1, 0.01, 0.001)
	 * args[4] = NumberofSimulations
	 * args[5] = NumberofIntervalsInEachSimulations
	 */
	public static void main( String[] args) {

		String glanetFolder = args[0];
		String dataDrivenExperimentFolder = glanetFolder + Commons.DDE + System.getProperty("file.separator");

		DataDrivenExperimentCellLineType cellLineType = DataDrivenExperimentCellLineType.convertStringtoEnum(args[1]);
		DataDrivenExperimentGeneType geneType = DataDrivenExperimentGeneType.convertStringtoEnum(args[2]);
		
		// Other Parameters for Simulations
		// Number of Simulations
		int numberofSimulations =  Integer.parseInt(args[3]);
		// Number of intervals in each simulation
		int numberofIntervalsInEachSimulation = Integer.parseInt(args[4]);

				
		/*************************************************************************************************/
		/******************************Get the tpmValues starts*******************************************/
		/*************************************************************************************************/
		//For expressingGenes tpmValues are sorted in descending order
		SortedMap<DataDrivenExperimentTPMType,Float> expGenesTPMType2TPMValueSortedMap = new TreeMap<DataDrivenExperimentTPMType,Float>(DataDrivenExperimentTPMType.TPM_TYPE);
		//For nonExpressingGenes tpmValues are sorted in ascending order
		SortedMap<DataDrivenExperimentTPMType,Float> nonExpGenesTPMType2TPMValueSortedMap = new TreeMap<DataDrivenExperimentTPMType,Float>(DataDrivenExperimentTPMType.TPM_TYPE);
		
		Set<DataDrivenExperimentTPMType> tpmTypes = null;
		
		switch(geneType){
		
			case EXPRESSING_PROTEINCODING_GENES:
				DataDrivenExperimentCommon.fillTPMType2TPMValueMap(dataDrivenExperimentFolder,cellLineType,geneType,expGenesTPMType2TPMValueSortedMap);
				//tpmValues = expGenesTPMValue2TPMTypeSortedMap.keySet();
				tpmTypes = expGenesTPMType2TPMValueSortedMap.keySet();
				
				break;
				
			case NONEXPRESSING_PROTEINCODING_GENES:
				DataDrivenExperimentCommon.fillTPMType2TPMValueMap(dataDrivenExperimentFolder,cellLineType,geneType,nonExpGenesTPMType2TPMValueSortedMap);
				//tpmValues = nonExpGenesTPMValue2TPMTypeSortedMap.keySet();
				tpmTypes = nonExpGenesTPMType2TPMValueSortedMap.keySet();
				break;
				
		}//End of SWITCH for geneType
		
		/*************************************************************************************************/
		/******************************Get the tpmValues ends*********************************************/
		/*************************************************************************************************/
		
		
		
		/*************************************************************************************************/
		/******************************For each tpmValue starts*******************************************/
		/*************************************************************************************************/
		DataDrivenExperimentTPMType tpmType = null;
		
		String intervalPoolFileName = null;

		for(Iterator<DataDrivenExperimentTPMType> itr = tpmTypes.iterator();itr.hasNext();){
			
			tpmType = itr.next(); 
			
			intervalPoolFileName = null;

			for(DataDrivenExperimentDnaseOverlapExclusionType dnaseOverlapExclusionType : DataDrivenExperimentDnaseOverlapExclusionType.values() ){
				
				if (	(geneType.isNonExpressingProteinCodingGenes() && !dnaseOverlapExclusionType.isNoDiscard()) ||
						(geneType.isExpressingProteinCodingGenes() && dnaseOverlapExclusionType.isNoDiscard())){
					
					// Depending on tpmString and dnaseOverlapsExcluded
					// Set IntervalPoolFile
					intervalPoolFileName = getIntervalPoolFileName(cellLineType, geneType,tpmType, dnaseOverlapExclusionType, dataDrivenExperimentFolder);

					// Generate Simulations Data
					// Get random numberofIntervalsInEachSimulation intervals from intervalPool for each simulation
					generateRandomSimulationData(
							dataDrivenExperimentFolder, 
							cellLineType,
							geneType,
							tpmType, 
							dnaseOverlapExclusionType, 
							intervalPoolFileName,
							numberofSimulations, 
							numberofIntervalsInEachSimulation);

					
				}//End of IF
			
			}//End of for each dnaseOverlapExclusionType
			
			
		}//End of for each tpmType
		/*************************************************************************************************/
		/******************************For each tpmValue ends*********************************************/
		/*************************************************************************************************/



		
	}

}
