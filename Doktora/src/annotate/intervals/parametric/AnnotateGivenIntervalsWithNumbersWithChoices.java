/**
 * @author burcakotlu
 * @date Jun 30, 2014 
 * @time 5:43:38 PM
 */
package annotate.intervals.parametric;

import gnu.trove.iterator.TIntIntIterator;
import gnu.trove.iterator.TIntObjectIterator;
import gnu.trove.iterator.TIntShortIterator;
import gnu.trove.iterator.TLongIntIterator;
import gnu.trove.iterator.TLongObjectIterator;
import gnu.trove.iterator.TShortIntIterator;
import gnu.trove.iterator.TShortIterator;
import gnu.trove.iterator.TShortObjectIterator;
import gnu.trove.iterator.TShortShortIterator;
import gnu.trove.list.TShortList;
import gnu.trove.list.array.TShortArrayList;
import gnu.trove.map.TIntIntMap;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TIntShortMap;
import gnu.trove.map.TLongIntMap;
import gnu.trove.map.TLongObjectMap;
import gnu.trove.map.TObjectShortMap;
import gnu.trove.map.TShortIntMap;
import gnu.trove.map.TShortObjectMap;
import gnu.trove.map.TShortShortMap;
import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TIntShortHashMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import gnu.trove.map.hash.TObjectShortHashMap;
import gnu.trove.map.hash.TShortIntHashMap;
import gnu.trove.map.hash.TShortObjectHashMap;
import gnu.trove.map.hash.TShortShortHashMap;
import intervaltree.DnaseIntervalTreeNode;
import intervaltree.DnaseIntervalTreeNodeWithNumbers;
import intervaltree.Interval;
import intervaltree.IntervalTree;
import intervaltree.IntervalTreeNode;
import intervaltree.TforHistoneIntervalTreeNode;
import intervaltree.TforHistoneIntervalTreeNodeWithNumbers;
import intervaltree.UcscRefSeqGeneIntervalTreeNode;
import intervaltree.UcscRefSeqGeneIntervalTreeNodeWithNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import keggpathway.ncbigenes.KeggPathwayUtility;
import ui.GlanetRunner;
import auxiliary.FileOperations;
import common.Commons;
import create.ChromosomeBasedFilesandOperations;
import empiricalpvalues.AllMaps;
import empiricalpvalues.AllMapsWithNumbers;
import empiricalpvalues.InputLine;
import enumtypes.AnnotationType;
import enumtypes.ChromosomeName;
import enumtypes.EnrichmentType;
import enumtypes.IntervalName;
import enumtypes.KeggPathwayAnalysisType;
import enumtypes.NodeType;

/**
 * 
 */
public class AnnotateGivenIntervalsWithNumbersWithChoices {

	//Empirical P value Calculation
	//For Thread Version for 
	public void createChromBaseSeachInputFiles(String outputFolder,String permutationNumber, List<BufferedWriter> bufferedWriterList){
		try {
			FileWriter fileWriter1 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr1_input_file.txt");
			FileWriter fileWriter2 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr2_input_file.txt");
			FileWriter fileWriter3 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr3_input_file.txt");
			FileWriter fileWriter4 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr4_input_file.txt");
			FileWriter fileWriter5		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr5_input_file.txt");
			FileWriter fileWriter6 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr6_input_file.txt");
			FileWriter fileWriter7 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr7_input_file.txt");
			FileWriter fileWriter8 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr8_input_file.txt");
			FileWriter fileWriter9 		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr9_input_file.txt");
			FileWriter fileWriter10 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr10_input_file.txt");
			FileWriter fileWriter11 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr11_input_file.txt");
			FileWriter fileWriter12 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr12_input_file.txt");
			FileWriter fileWriter13 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr13_input_file.txt");
			FileWriter fileWriter14 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr14_input_file.txt");
			FileWriter fileWriter15 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr15_input_file.txt");
			FileWriter fileWriter16 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr16_input_file.txt");
			FileWriter fileWriter17 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr17_input_file.txt");
			FileWriter fileWriter18 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr18_input_file.txt");
			FileWriter fileWriter19 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr19_input_file.txt");
			FileWriter fileWriter20		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr20_input_file.txt");
			FileWriter fileWriter21 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr21_input_file.txt");
			FileWriter fileWriter22 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chr22_input_file.txt");
			FileWriter fileWriter23 	= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chrX_input_file.txt");
			FileWriter fileWriter24		= FileOperations.createFileWriter( outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "_" + permutationNumber + "_" + "search_chrY_input_file.txt");
			
			BufferedWriter bufferedWriter1 	= new BufferedWriter(fileWriter1);
			BufferedWriter bufferedWriter2 	= new BufferedWriter(fileWriter2);
			BufferedWriter bufferedWriter3 	= new BufferedWriter(fileWriter3);
			BufferedWriter bufferedWriter4 	= new BufferedWriter(fileWriter4);
			BufferedWriter bufferedWriter5 	= new BufferedWriter(fileWriter5);
			BufferedWriter bufferedWriter6 	= new BufferedWriter(fileWriter6);
			BufferedWriter bufferedWriter7 	= new BufferedWriter(fileWriter7);
			BufferedWriter bufferedWriter8 	= new BufferedWriter(fileWriter8);
			BufferedWriter bufferedWriter9 	= new BufferedWriter(fileWriter9);
			BufferedWriter bufferedWriter10 = new BufferedWriter(fileWriter10);
			BufferedWriter bufferedWriter11 = new BufferedWriter(fileWriter11);
			BufferedWriter bufferedWriter12 = new BufferedWriter(fileWriter12);
			BufferedWriter bufferedWriter13 = new BufferedWriter(fileWriter13);
			BufferedWriter bufferedWriter14 = new BufferedWriter(fileWriter14);
			BufferedWriter bufferedWriter15 = new BufferedWriter(fileWriter15);
			BufferedWriter bufferedWriter16 = new BufferedWriter(fileWriter16);
			BufferedWriter bufferedWriter17 = new BufferedWriter(fileWriter17);
			BufferedWriter bufferedWriter18 = new BufferedWriter(fileWriter18);
			BufferedWriter bufferedWriter19 = new BufferedWriter(fileWriter19);
			BufferedWriter bufferedWriter20 = new BufferedWriter(fileWriter20);
			BufferedWriter bufferedWriter21 = new BufferedWriter(fileWriter21);
			BufferedWriter bufferedWriter22 = new BufferedWriter(fileWriter22);
			BufferedWriter bufferedWriter23 = new BufferedWriter(fileWriter23);
			BufferedWriter bufferedWriter24 = new BufferedWriter(fileWriter24);
			
			bufferedWriterList.add(bufferedWriter1);
			bufferedWriterList.add(bufferedWriter2);
			bufferedWriterList.add(bufferedWriter3);
			bufferedWriterList.add(bufferedWriter4);
			bufferedWriterList.add(bufferedWriter5);
			bufferedWriterList.add(bufferedWriter6);
			bufferedWriterList.add(bufferedWriter7);
			bufferedWriterList.add(bufferedWriter8);
			bufferedWriterList.add(bufferedWriter9);
			bufferedWriterList.add(bufferedWriter10);
			bufferedWriterList.add(bufferedWriter11);
			bufferedWriterList.add(bufferedWriter12);
			bufferedWriterList.add(bufferedWriter13);
			bufferedWriterList.add(bufferedWriter14);
			bufferedWriterList.add(bufferedWriter15);
			bufferedWriterList.add(bufferedWriter16);
			bufferedWriterList.add(bufferedWriter17);
			bufferedWriterList.add(bufferedWriter18);
			bufferedWriterList.add(bufferedWriter19);
			bufferedWriterList.add(bufferedWriter20);
			bufferedWriterList.add(bufferedWriter21);
			bufferedWriterList.add(bufferedWriter22);
			bufferedWriterList.add(bufferedWriter23);
			bufferedWriterList.add(bufferedWriter24);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void createChromBaseSeachInputFiles(String outputFolder,List<FileWriter> fileWriterList, List<BufferedWriter> bufferedWriterList){
		try {
			FileWriter fileWriter1 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
			FileWriter fileWriter2 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
			FileWriter fileWriter3 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
			FileWriter fileWriter4 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
			FileWriter fileWriter5 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
			FileWriter fileWriter6 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
			FileWriter fileWriter7	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
			FileWriter fileWriter8 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
			FileWriter fileWriter9 	= FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
			FileWriter fileWriter10 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
			FileWriter fileWriter11 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
			FileWriter fileWriter12 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
			FileWriter fileWriter13 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
			FileWriter fileWriter14 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
			FileWriter fileWriter15 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
			FileWriter fileWriter16 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
			FileWriter fileWriter17 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
			FileWriter fileWriter18 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
			FileWriter fileWriter19 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
			FileWriter fileWriter20 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
			FileWriter fileWriter21 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
			FileWriter fileWriter22 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
			FileWriter fileWriter23 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
			FileWriter fileWriter24 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
			
			fileWriterList.add(fileWriter1);
			fileWriterList.add(fileWriter2);
			fileWriterList.add(fileWriter3);
			fileWriterList.add(fileWriter4);
			fileWriterList.add(fileWriter5);
			fileWriterList.add(fileWriter6);
			fileWriterList.add(fileWriter7);
			fileWriterList.add(fileWriter8);
			fileWriterList.add(fileWriter9);
			fileWriterList.add(fileWriter10);
			fileWriterList.add(fileWriter11);
			fileWriterList.add(fileWriter12);
			fileWriterList.add(fileWriter13);
			fileWriterList.add(fileWriter14);
			fileWriterList.add(fileWriter15);
			fileWriterList.add(fileWriter16);
			fileWriterList.add(fileWriter17);
			fileWriterList.add(fileWriter18);
			fileWriterList.add(fileWriter19);
			fileWriterList.add(fileWriter20);
			fileWriterList.add(fileWriter21);
			fileWriterList.add(fileWriter22);
			fileWriterList.add(fileWriter23);
			fileWriterList.add(fileWriter24);			
			
			BufferedWriter bufferedWriter1 	= new BufferedWriter(fileWriter1);
			BufferedWriter bufferedWriter2 	= new BufferedWriter(fileWriter2);
			BufferedWriter bufferedWriter3 	= new BufferedWriter(fileWriter3);
			BufferedWriter bufferedWriter4 	= new BufferedWriter(fileWriter4);
			BufferedWriter bufferedWriter5 	= new BufferedWriter(fileWriter5);
			BufferedWriter bufferedWriter6 	= new BufferedWriter(fileWriter6);
			BufferedWriter bufferedWriter7 	= new BufferedWriter(fileWriter7);
			BufferedWriter bufferedWriter8 	= new BufferedWriter(fileWriter8);
			BufferedWriter bufferedWriter9 	= new BufferedWriter(fileWriter9);
			BufferedWriter bufferedWriter10 = new BufferedWriter(fileWriter10);
			BufferedWriter bufferedWriter11 = new BufferedWriter(fileWriter11);
			BufferedWriter bufferedWriter12 = new BufferedWriter(fileWriter12);
			BufferedWriter bufferedWriter13 = new BufferedWriter(fileWriter13);
			BufferedWriter bufferedWriter14 = new BufferedWriter(fileWriter14);
			BufferedWriter bufferedWriter15 = new BufferedWriter(fileWriter15);
			BufferedWriter bufferedWriter16 = new BufferedWriter(fileWriter16);
			BufferedWriter bufferedWriter17 = new BufferedWriter(fileWriter17);
			BufferedWriter bufferedWriter18 = new BufferedWriter(fileWriter18);
			BufferedWriter bufferedWriter19 = new BufferedWriter(fileWriter19);
			BufferedWriter bufferedWriter20 = new BufferedWriter(fileWriter20);
			BufferedWriter bufferedWriter21 = new BufferedWriter(fileWriter21);
			BufferedWriter bufferedWriter22 = new BufferedWriter(fileWriter22);
			BufferedWriter bufferedWriter23 = new BufferedWriter(fileWriter23);
			BufferedWriter bufferedWriter24 = new BufferedWriter(fileWriter24);
			
			bufferedWriterList.add(bufferedWriter1);
			bufferedWriterList.add(bufferedWriter2);
			bufferedWriterList.add(bufferedWriter3);
			bufferedWriterList.add(bufferedWriter4);
			bufferedWriterList.add(bufferedWriter5);
			bufferedWriterList.add(bufferedWriter6);
			bufferedWriterList.add(bufferedWriter7);
			bufferedWriterList.add(bufferedWriter8);
			bufferedWriterList.add(bufferedWriter9);
			bufferedWriterList.add(bufferedWriter10);
			bufferedWriterList.add(bufferedWriter11);
			bufferedWriterList.add(bufferedWriter12);
			bufferedWriterList.add(bufferedWriter13);
			bufferedWriterList.add(bufferedWriter14);
			bufferedWriterList.add(bufferedWriter15);
			bufferedWriterList.add(bufferedWriter16);
			bufferedWriterList.add(bufferedWriter17);
			bufferedWriterList.add(bufferedWriter18);
			bufferedWriterList.add(bufferedWriter19);
			bufferedWriterList.add(bufferedWriter20);
			bufferedWriterList.add(bufferedWriter21);
			bufferedWriterList.add(bufferedWriter22);
			bufferedWriterList.add(bufferedWriter23);
			bufferedWriterList.add(bufferedWriter24);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeChromBaseSearchInputFile(ChromosomeName chromName, String strLine, List<BufferedWriter> bufList){
		try {
			
			if (chromName.equals(ChromosomeName.CHROMOSOME1)){
				bufList.get(0).write(strLine + System.getProperty("line.separator"));
				bufList.get(0).flush();		
			} else 	if (chromName.equals(ChromosomeName.CHROMOSOME2)){
				bufList.get(1).write(strLine + System.getProperty("line.separator"));
				bufList.get(1).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME3)){
				bufList.get(2).write(strLine + System.getProperty("line.separator"));
				bufList.get(2).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME4)){
				bufList.get(3).write(strLine + System.getProperty("line.separator"));
				bufList.get(3).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME5)){
				bufList.get(4).write(strLine + System.getProperty("line.separator"));
				bufList.get(4).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME6)){
				bufList.get(5).write(strLine + System.getProperty("line.separator"));
				bufList.get(5).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME7)){
				bufList.get(6).write(strLine + System.getProperty("line.separator"));
				bufList.get(6).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME8)){
				bufList.get(7).write(strLine + System.getProperty("line.separator"));
				bufList.get(7).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME9)){
				bufList.get(8).write(strLine + System.getProperty("line.separator"));
				bufList.get(8).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME10)){
				bufList.get(9).write(strLine + System.getProperty("line.separator"));
				bufList.get(9).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME11)){
				bufList.get(10).write(strLine + System.getProperty("line.separator"));
				bufList.get(10).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME12)){
				bufList.get(11).write(strLine + System.getProperty("line.separator"));
				bufList.get(11).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME13)){
				bufList.get(12).write(strLine + System.getProperty("line.separator"));
				bufList.get(12).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME14)){
				bufList.get(13).write(strLine + System.getProperty("line.separator"));
				bufList.get(13).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME15)){
				bufList.get(14).write(strLine + System.getProperty("line.separator"));
				bufList.get(14).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME16)){
				bufList.get(15).write(strLine + System.getProperty("line.separator"));
				bufList.get(15).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME17)){
				bufList.get(16).write(strLine + System.getProperty("line.separator"));
				bufList.get(16).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME18)){
				bufList.get(17).write(strLine + System.getProperty("line.separator"));
				bufList.get(17).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME19)){
				bufList.get(18).write(strLine + System.getProperty("line.separator"));
				bufList.get(18).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME20)){
				bufList.get(19).write(strLine + System.getProperty("line.separator"));
				bufList.get(19).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME21)){
				bufList.get(20).write(strLine + System.getProperty("line.separator"));
				bufList.get(20).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOME22)){
				bufList.get(21).write(strLine + System.getProperty("line.separator"));
				bufList.get(21).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOMEX)){
				bufList.get(22).write(strLine + System.getProperty("line.separator"));
				bufList.get(22).flush();		
			}else 	if (chromName.equals(ChromosomeName.CHROMOSOMEY)){
				bufList.get(23).write(strLine + System.getProperty("line.separator"));
				bufList.get(23).flush();		
			}else{
				GlanetRunner.appendLog("Unknown chromosome");
			}

		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void partitionSearchInputFilePerChromName(String inputFileName, List<BufferedWriter> bufferedWriterList){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine;
		int indexofFirstTab;
		ChromosomeName chromName;
		
		try {
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine=bufferedReader.readLine())!=null){
				
				indexofFirstTab = strLine.indexOf('\t');
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				writeChromBaseSearchInputFile(chromName,strLine,bufferedWriterList);
				
			} // End of While
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}				
	}
	
	
	//Empirical P value Computation
	public void partitionSearchInputFilePerChromName(List<InputLine> inputLines, List<BufferedWriter> bufferedWriterList){
		
		String strLine;
		
		ChromosomeName chrName;
		int low;
		int high;
		
		InputLine inputLine;
			
			for(int i = 0; i<inputLines.size(); i++){
				
				inputLine = inputLines.get(i);
				
				chrName = inputLine.getChrName();
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				strLine = chrName + "\t" + low + "\t" + high;
				
				writeChromBaseSearchInputFile(chrName,strLine,bufferedWriterList);
				
			} // End of While
		
						
	}
	
	//Generate Dnase Interval Tree with Numbers starts
	//For Annotation and Enrichment
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeDnaseIntervalTreeWithNumbers(BufferedReader bufferedReader) {
		IntervalTree dnaseIntervalTree = new IntervalTree();
		String strLine = null;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		ChromosomeName chromName;
		short cellLineNumber;
		short fileNumber;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
//				old example strLine
//				chr1	91852781	91853156	GM12878	idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak
				
//				new example line with numbers
//				chrY	2709520	2709669	1	1

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
					
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				cellLineNumber = Short.parseShort(strLine.substring(indexofThirdTab+1, indexofFourthTab));							
				fileNumber = Short.parseShort(strLine.substring(indexofFourthTab+1));
				
				//important note
				//while constructing the dnaseIntervalTree
				//we don't check for overlaps
				//we insert any given interval without overlap check
				
//				Creating millions of nodes with six attributes causes out of memory error
				DnaseIntervalTreeNodeWithNumbers node = new DnaseIntervalTreeNodeWithNumbers(chromName,startPosition,endPosition,cellLineNumber,fileNumber,NodeType.ORIGINAL);
				dnaseIntervalTree.intervalTreeInsert(dnaseIntervalTree, node);						
					
			} // End of While 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dnaseIntervalTree;
	}		
	//Generate Interval Tree with Numbers ends
	
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeDnaseIntervalTree(BufferedReader bufferedReader) {
		IntervalTree dnaseIntervalTree = new IntervalTree();
		String strLine = null;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String cellLineName;
		String fileName;
		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chr1	91852781	91853156	GM12878	idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				cellLineName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
								
				fileName = strLine.substring(indexofFourthTab+1);
				
				//important note
				//while constructing the dnaseIntervalTree
				//we don't check for overlaps
				//we insert any given interval without overlap check
				
//					Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new DnaseIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,cellLineName,fileName,NodeType.ORIGINAL);
				dnaseIntervalTree.intervalTreeInsert(dnaseIntervalTree, node);						
			
				chromName = null;
				cellLineName = null;
				fileName = null;				
				strLine = null;
				
			} // End of While 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dnaseIntervalTree;
	}

	
	
	
	public IntervalTree generateEncodeDnaseIntervalTree(BufferedReader bufferedReader, List<String> dnaseCellLineNameList) {
		IntervalTree dnaseIntervalTree = new IntervalTree();
		String strLine = null;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String cellLineName;
		String fileName;
		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chr1	91852781	91853156	GM12878	idrPool.GM12878-DS9432-DS10671.z_OV_GM12878-DS10671.z_VS_GM12878-DS9432.z.npk2.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				cellLineName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
								
				fileName = strLine.substring(indexofFourthTab+1);
				
				//important note
				//while constructing the dnaseIntervalTree
				//we don't check for overlaps
				//we insert any given interval without overlap check
				
//				if dnase exists in dnaseList 
				if (dnaseCellLineNameList.contains(cellLineName)){
//				Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new DnaseIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,cellLineName,fileName,NodeType.ORIGINAL);
					dnaseIntervalTree.intervalTreeInsert(dnaseIntervalTree, node);						
				} //End of If	
				
				chromName = null;
				cellLineName = null;
				fileName = null;				
				strLine = null;
				
			} // End of While 
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dnaseIntervalTree;
	}
	
	
	//@todo
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeTfbsIntervalTreeWithNumbers(BufferedReader bufferedReader){
		IntervalTree tfbsIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		ChromosomeName chromName;
		Short tfNumber;
		Short cellLineNumber;
		Short fileNumber;
			  
	    
		try {
			while((strLine = bufferedReader.readLine())!=null){
//				exampple strLine
//				chrY	2804079	2804213	Ctcf	H1hesc	spp.optimal.wgEncodeBroadHistoneH1hescCtcfStdAlnRep0_VS_wgEncodeBroadHistoneH1hescControlStdAlnRep0.narrowPeak
			
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				tfNumber = Short.parseShort(strLine.substring(indexofThirdTab+1, indexofFourthTab));
				
				cellLineNumber = Short.parseShort(strLine.substring(indexofFourthTab+1, indexofFifthTab));
				
				fileNumber = Short.parseShort(strLine.substring(indexofFifthTab+1));

//				Creating millions of nodes with six attributes causes out of memory error
				TforHistoneIntervalTreeNodeWithNumbers node = new TforHistoneIntervalTreeNodeWithNumbers(chromName,startPosition,endPosition,tfNumber,cellLineNumber,fileNumber,NodeType.ORIGINAL);
				tfbsIntervalTree.intervalTreeInsert(tfbsIntervalTree, node);					
				
				chromName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tfbsIntervalTree;
	}
	//@todo
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeTfbsIntervalTree(BufferedReader bufferedReader){
		IntervalTree tfbsIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String tfbsName;
		String cellLineName;
		String fileName;
		
	  
	    
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					exampple strLine
//					chrY	2804079	2804213	Ctcf	H1hesc	spp.optimal.wgEncodeBroadHistoneH1hescCtcfStdAlnRep0_VS_wgEncodeBroadHistoneH1hescControlStdAlnRep0.narrowPeak
			
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				tfbsName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);

//					Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,tfbsName,cellLineName,fileName,NodeType.ORIGINAL);
				tfbsIntervalTree.intervalTreeInsert(tfbsIntervalTree, node);					
				
				chromName = null;
				tfbsName = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tfbsIntervalTree;
	}

	
	public IntervalTree generateEncodeTfbsIntervalTree(BufferedReader bufferedReader, List<String> tfbsNameList){
		IntervalTree tfbsIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		String chromName;
		String tfbsName;
		String cellLineName;
		String fileName;
		
	  
	    
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chrY	2804079	2804213	Ctcf	H1hesc	spp.optimal.wgEncodeBroadHistoneH1hescCtcfStdAlnRep0_VS_wgEncodeBroadHistoneH1hescControlStdAlnRep0.narrowPeak
			
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				tfbsName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);

//					if tfbs exists in tfbsList 
				if (tfbsNameList.contains(tfbsName)){
//						Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,tfbsName,cellLineName,fileName,NodeType.ORIGINAL);
					tfbsIntervalTree.intervalTreeInsert(tfbsIntervalTree, node);					
				}
				
				chromName = null;
				tfbsName = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tfbsIntervalTree;
	}
	
	//@todo
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeHistoneIntervalTreeWithNumbers(BufferedReader bufferedReader) {
		IntervalTree histoneIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
				
		ChromosomeName chromName;
		int startPosition = 0;
		int endPosition = 0;
		
		short histoneNumber;
		short cellLineNumber;
		short fileNumber;
		
	
		try {
			while((strLine = bufferedReader.readLine())!=null){
//			old example strLine
//			chr9	131533188	131535395	H2az	Gm12878	wgEncodeBroadHistoneGm12878H2azStdAln.narrowPeak
//			new example strLine
//			chr22	20747267	20749217	1	17	654

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				
				histoneNumber = Short.parseShort(strLine.substring(indexofThirdTab+1, indexofFourthTab));
				
				cellLineNumber = Short.parseShort(strLine.substring(indexofFourthTab+1, indexofFifthTab));
				
				fileNumber = Short.parseShort(strLine.substring(indexofFifthTab+1));
				
//				Creating millions of nodes with six attributes causes out of memory error
				TforHistoneIntervalTreeNodeWithNumbers node = new TforHistoneIntervalTreeNodeWithNumbers(chromName,startPosition,endPosition,histoneNumber,cellLineNumber,fileNumber,NodeType.ORIGINAL);
				histoneIntervalTree.intervalTreeInsert(histoneIntervalTree, node);				
				
				chromName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return histoneIntervalTree;
	}
	//@todo
	
	
	//Empirical P Value Calculation
	public static IntervalTree generateEncodeHistoneIntervalTree(BufferedReader bufferedReader) {
		IntervalTree histoneIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
				
		String chromName;
		int startPosition = 0;
		int endPosition = 0;
		
		String histoneName;
		String cellLineName;
		String fileName;
		
	
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chr9	131533188	131535395	H2az	Gm12878	wgEncodeBroadHistoneGm12878H2azStdAln.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				
				histoneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);
				
//					Creating millions of nodes with six attributes causes out of memory error
				IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,histoneName,cellLineName,fileName,NodeType.ORIGINAL);
				histoneIntervalTree.intervalTreeInsert(histoneIntervalTree, node);				
				
				chromName = null;
				histoneName  = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return histoneIntervalTree;
	}


	public IntervalTree generateEncodeHistoneIntervalTree(BufferedReader bufferedReader, List<String> histoneNameList) {
		IntervalTree histoneIntervalTree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
				
		String chromName;
		int startPosition = 0;
		int endPosition = 0;
		
		String histoneName;
		String cellLineName;
		String fileName;
		
	
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chr9	131533188	131535395	H2az	Gm12878	wgEncodeBroadHistoneGm12878H2azStdAln.narrowPeak

				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
					
				chromName = strLine.substring(0,indexofFirstTab);
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				
				histoneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				cellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
				
				fileName = strLine.substring(indexofFifthTab+1);
				
				if (histoneNameList.contains(histoneName)){
//						Creating millions of nodes with six attributes causes out of memory error
					IntervalTreeNode node = new TforHistoneIntervalTreeNode(ChromosomeName.convertStringtoEnum(chromName),startPosition,endPosition,histoneName,cellLineName,fileName,NodeType.ORIGINAL);
					histoneIntervalTree.intervalTreeInsert(histoneIntervalTree, node);				
				}
				
				chromName = null;
				histoneName  = null;
				cellLineName = null;
				fileName = null;
				strLine = null;
								
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return histoneIntervalTree;
	}
	
	//@todo
	public static IntervalTree generateUcscRefSeqGenesIntervalTreeWithNumbers(BufferedReader bufferedReader){
		IntervalTree tree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		int indexofThirdTab = 0;
		int indexofFourthTab = 0;
		int indexofFifthTab = 0;
		int indexofSixthTab = 0;
		int indexofSeventhTab = 0;
		int indexofEighthTab = 0;
		
		int startPosition = 0;
		int endPosition = 0;
		
		ChromosomeName chromName;
		IntervalName intervalName;
		Integer intervalNumber;

		Integer geneEntrezId;
		Integer refSeqGeneNameNumber;
		Integer geneHugoSymbolNumber;		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chrY	16733888	16734470	NR_028319	22829	EXON	2	+	NLGN4Y
//					chr22	25170288	25170686	38084		440822	EXON	21	-	22048
//					chr22	25170687	25172686	38084		440822	5P1			-	22048


				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab = strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab = strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab = strLine.indexOf('\t', indexofFourthTab+1);
				indexofSixthTab = strLine.indexOf('\t', indexofFifthTab+1);
				indexofSeventhTab = strLine.indexOf('\t',indexofSixthTab+1);	
				indexofEighthTab = strLine.indexOf('\t',indexofSeventhTab+1);
				
				
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				refSeqGeneNameNumber = Integer.parseInt(strLine.substring(indexofThirdTab+1, indexofFourthTab));
				geneEntrezId = Integer.parseInt(strLine.substring(indexofFourthTab+1, indexofFifthTab));
				
				intervalName = IntervalName.convertStringtoEnum(strLine.substring(indexofFifthTab+1, indexofSixthTab));
				intervalNumber = Integer.parseInt(strLine.substring(indexofSixthTab+1, indexofSeventhTab));
	
				geneHugoSymbolNumber = Integer.parseInt(strLine.substring(indexofEighthTab+1));
								
				
//				Creating millions of nodes with seven attributes causes out of memory error
				UcscRefSeqGeneIntervalTreeNodeWithNumbers node = new UcscRefSeqGeneIntervalTreeNodeWithNumbers(chromName,startPosition,endPosition,geneEntrezId,refSeqGeneNameNumber,geneHugoSymbolNumber,intervalName,intervalNumber,NodeType.ORIGINAL);
				tree.intervalTreeInsert(tree, node);
				
				chromName = null;
				intervalName = null;
				
				geneEntrezId = null;
				refSeqGeneNameNumber = null;
				geneHugoSymbolNumber = null;
				
				strLine = null;
				
			}// end of While
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return tree;
	}

	//@todo

	public static IntervalTree generateUcscRefSeqGenesIntervalTree(BufferedReader bufferedReader){
		IntervalTree tree = new IntervalTree();
		String strLine;
		
		int indexofFirstTab 	= 0;
		int indexofSecondTab 	= 0;
		int indexofThirdTab 	= 0;
		int indexofFourthTab 	= 0;
		int indexofFifthTab 	= 0;
		int indexofSixthTab 	= 0;
		int indexofSeventhTab 	= 0;
		int indexofEighthTab 	= 0;
		
		int startPosition 	= 0;
		int endPosition 	= 0;
		
		ChromosomeName chromName;
		String  refSeqGeneName;
		Integer geneEntrezId;
		IntervalName intervalName;
		int intervalNumber;
		String geneHugoSymbol;		
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
//					example strLine
//					chr17	67074846	67075215	NM_080284	23460	Exon	1	-	ABCA6

				indexofFirstTab 	= strLine.indexOf('\t');
				indexofSecondTab 	= strLine.indexOf('\t', indexofFirstTab+1);
				indexofThirdTab 	= strLine.indexOf('\t', indexofSecondTab+1);
				indexofFourthTab 	= strLine.indexOf('\t', indexofThirdTab+1);
				indexofFifthTab 	= strLine.indexOf('\t', indexofFourthTab+1);
				indexofSixthTab 	= strLine.indexOf('\t', indexofFifthTab+1);
				indexofSeventhTab 	= strLine.indexOf('\t',indexofSixthTab+1);
				indexofEighthTab 	= strLine.indexOf('\t',indexofSeventhTab+1);
				
				chromName = ChromosomeName.convertStringtoEnum(strLine.substring(0,indexofFirstTab));
				
				startPosition = Integer.parseInt(strLine.substring(indexofFirstTab+1,indexofSecondTab));
				endPosition = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
				
				refSeqGeneName = strLine.substring(indexofThirdTab+1, indexofFourthTab);
				
				geneEntrezId = Integer.parseInt(strLine.substring(indexofFourthTab+1, indexofFifthTab));
				
				intervalName = IntervalName.convertStringtoEnum(strLine.substring(indexofFifthTab+1, indexofSixthTab));
				intervalNumber = Integer.parseInt(strLine.substring(indexofSixthTab+1, indexofSeventhTab));
				
				geneHugoSymbol = strLine.substring(indexofEighthTab+1);
				
//					Creating millions of nodes with seven attributes causes out of memory error
				IntervalTreeNode node = new UcscRefSeqGeneIntervalTreeNode(chromName,startPosition,endPosition,refSeqGeneName,geneEntrezId,intervalName,intervalNumber,geneHugoSymbol,NodeType.ORIGINAL);
				tree.intervalTreeInsert(tree, node);
				
				chromName = null;
				refSeqGeneName = null;
				geneEntrezId = null;
				intervalName = null;
				geneHugoSymbol = null;
				strLine = null;
			}// end of While
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return tree;
	}

	//Generate Interval Tree
	//With Number starts
	//For Annotation and Enrichment
	public static IntervalTree createDnaseIntervalTreeWithNumbers(String dataFolder,ChromosomeName chromName){
		IntervalTree  dnaseIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR1_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR2_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR3_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR4_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR5_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR6_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR7_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR8_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR9_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR10_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR11_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR12_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR13_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR14_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR15_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR16_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR17_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR18_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR19_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR20_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR21_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR22_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRX_DNASE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRY_DNASE_FILENAME_WITH_NUMBERS);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			dnaseIntervalTree = generateEncodeDnaseIntervalTreeWithNumbers(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dnaseIntervalTree;
	}	
	//With Number ends
	
	//Empirical P Value Calculation
	public static IntervalTree createDnaseIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  dnaseIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
					fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR1_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR2_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR3_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR4_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR5_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR6_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR7_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR8_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR9_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR10_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR11_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR12_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR13_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR14_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR15_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR16_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR17_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR18_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR19_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR20_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR21_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHR22_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRX_DNASE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY, Commons.UNSORTED_CHRY_DNASE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			dnaseIntervalTree = generateEncodeDnaseIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dnaseIntervalTree;
	}

	
	
	public IntervalTree createDnaseIntervalTree(String outputFolder, ChromosomeName chromName, List<String> dnaseCellLineNameList){
		IntervalTree  dnaseIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (chromName.isCHROMOSOME1()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR1_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME2()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR2_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME3()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR3_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME4()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR4_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME5()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR5_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME6()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR6_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME7()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR7_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME8()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR8_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME9()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR9_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME10()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR10_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME11()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR11_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME12()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR12_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME13()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR13_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME14()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR14_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME15()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR15_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME16()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR16_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME17()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR17_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME18()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR18_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME19()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR19_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME20()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR20_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME21()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR21_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOME22()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHR22_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOMEX()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHRX_DNASE_FILENAME);				
			} else if (chromName.isCHROMOSOMEY()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_DNASE_DIRECTORY,Commons.UNSORTED_CHRY_DNASE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			dnaseIntervalTree = generateEncodeDnaseIntervalTree(bufferedReader,dnaseCellLineNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dnaseIntervalTree;
	}

	
	//@todo
	//Empirical P Value Calculation
	public static IntervalTree createTfbsIntervalTreeWithNumbers(String dataFolder,ChromosomeName chromName){
		IntervalTree  tfbsIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR1_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR2_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR3_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR4_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR5_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR6_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR7_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR8_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR9_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR10_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR11_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR12_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR13_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR14_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR15_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR16_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR17_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR18_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR19_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR20_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR21_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR22_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRX_TFBS_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRY_TFBS_FILENAME_WITH_NUMBERS);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			tfbsIntervalTree = generateEncodeTfbsIntervalTreeWithNumbers(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return tfbsIntervalTree;	
	}
	//@todo
	
	//Empirical P Value Calculation
	public static IntervalTree createTfbsIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  tfbsIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR1_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR2_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR3_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR4_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR5_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR6_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR7_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR8_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR9_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR10_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR11_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR12_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR13_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR14_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR15_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR16_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR17_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR18_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR19_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR20_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR21_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR22_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRX_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRY_TFBS_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			tfbsIntervalTree = generateEncodeTfbsIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return tfbsIntervalTree;	
	}

	
	public IntervalTree createTfbsIntervalTree(String outputFolder,ChromosomeName chromName, List<String> tfbsNameList){
		IntervalTree  tfbsIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR1_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR2_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR3_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR4_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR5_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR6_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR7_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR8_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR9_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR10_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR11_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR12_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR13_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR14_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR15_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR16_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR17_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR18_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR19_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR20_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR21_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHR22_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRX_TFBS_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_TFBS_DIRECTORY,Commons.UNSORTED_CHRY_TFBS_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			tfbsIntervalTree = generateEncodeTfbsIntervalTree(bufferedReader,tfbsNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return tfbsIntervalTree;	
	}
	
	//@todo
	// Empirical P Value Calculation
	public static IntervalTree createHistoneIntervalTreeWithNumbers(String dataFolder,ChromosomeName chromName){
		IntervalTree  histoneIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR1_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR2_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR3_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR4_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR5_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR6_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR7_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR8_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR9_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR10_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR11_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR12_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR13_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR14_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR15_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR16_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR17_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR18_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR19_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR20_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR21_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR22_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRX_HISTONE_FILENAME_WITH_NUMBERS);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRY_HISTONE_FILENAME_WITH_NUMBERS);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			histoneIntervalTree = generateEncodeHistoneIntervalTreeWithNumbers(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return histoneIntervalTree;	
	}
	//@todo
	
	

	// Empirical P Value Calculation
	public static IntervalTree createHistoneIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  histoneIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (ChromosomeName.CHROMOSOME1.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR1_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME2.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR2_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME3.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR3_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME4.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR4_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME5.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR5_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME6.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR6_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME7.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR7_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME8.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR8_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME9.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR9_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME10.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR10_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME11.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR11_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME12.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR12_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME13.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR13_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME14.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR14_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME15.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR15_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME16.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR16_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME17.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR17_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME18.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR18_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME19.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR19_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME20.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR20_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME21.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR21_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOME22.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHR22_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEX.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRX_HISTONE_FILENAME);				
			} else if (ChromosomeName.CHROMOSOMEY.equals(chromName)){
				fileReader = FileOperations.createFileReader(dataFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY, Commons.UNSORTED_CHRY_HISTONE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			histoneIntervalTree = generateEncodeHistoneIntervalTree(bufferedReader);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return histoneIntervalTree;	
	}
	
	public IntervalTree createHistoneIntervalTree(String outputFolder, ChromosomeName chromName,List<String> histoneNameList){
		IntervalTree  histoneIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		try {			
			if (chromName.isCHROMOSOME1()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR1_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME2()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR2_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME3()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR3_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME4()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR4_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME5()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR5_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME6()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR6_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME7()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR7_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME8()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR8_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME9()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR9_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME10()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR10_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME11()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR11_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME12()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR12_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME13()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR13_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME14()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR14_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME15()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR15_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME16()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR16_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME17()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR17_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME18()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR18_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME19()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR19_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME20()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR20_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME21()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR21_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOME22()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHR22_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOMEX()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHRX_HISTONE_FILENAME);				
			} else if (chromName.isCHROMOSOMEY()){
				fileReader = FileOperations.createFileReader(outputFolder + Commons.CREATE_ENCODE_HISTONE_DIRECTORY,Commons.UNSORTED_CHRY_HISTONE_FILENAME);				
			} 
		
			bufferedReader = new BufferedReader(fileReader);
			histoneIntervalTree = generateEncodeHistoneIntervalTree(bufferedReader,histoneNameList);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return histoneIntervalTree;	
	}
	
	
	
	//@todo
	public static IntervalTree createUcscRefSeqGenesIntervalTreeWithNumbers(String dataFolder,ChromosomeName chromName){
		IntervalTree  ucscRefSeqGenesIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		fileReader = ChromosomeBasedFilesandOperations.getUnsortedRefSeqGenesFileReaderWithNumbers(dataFolder,chromName);		
		bufferedReader = new BufferedReader(fileReader);
		
		ucscRefSeqGenesIntervalTree = generateUcscRefSeqGenesIntervalTreeWithNumbers(bufferedReader);
		
		return ucscRefSeqGenesIntervalTree;	
	
	}
	//@todo
	
	public static IntervalTree createUcscRefSeqGenesIntervalTree(String dataFolder,ChromosomeName chromName){
		IntervalTree  ucscRefSeqGenesIntervalTree =null;
		FileReader fileReader =null;
		BufferedReader bufferedReader = null;
		
		fileReader = ChromosomeBasedFilesandOperations.getUnsortedRefSeqGenesFileReader(dataFolder,chromName);
		
		bufferedReader = new BufferedReader(fileReader);
		ucscRefSeqGenesIntervalTree = generateUcscRefSeqGenesIntervalTree(bufferedReader);
		
		return ucscRefSeqGenesIntervalTree;	
	
	}

	//@todo
	//with Numbers starts
	//Empirical P Value Calculation
	//with IO
	public static void searchDnaseWithNumbers(String outputFolder,int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree, TIntObjectMap<BufferedWriter> dnaseBufferedWriterHashMap, TIntIntMap permutationNumberDnaseCellLineNumber2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			TIntIntMap permutationNumberDnaseCellLineNumber2ZeroorOneMap = new TIntIntHashMap();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervalsWithNumbers(outputFolder,permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineNumber2ZeroorOneMap,overlapDefinition);	
			}
			
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(TIntIntIterator it = permutationNumberDnaseCellLineNumber2ZeroorOneMap.iterator(); it.hasNext();){
				it.advance();
				 
				if (!(permutationNumberDnaseCellLineNumber2KMap.containsKey(it.key()))){
					permutationNumberDnaseCellLineNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberDnaseCellLineNumber2KMap.put(it.key(), permutationNumberDnaseCellLineNumber2KMap.get(it.key())+it.value());
				}

			}//End of for
			
			interval = null;
			
		}//End of for
	}
	//with numbers ends
	//@todo
	
	

	//Empirical P Value Calculation
	//with IO
	public static void searchDnase(String outputFolder,int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree, Map<String,BufferedWriter> dnaseBufferedWriterHashMap,Map<String,Integer> permutationNumberDnaseCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberDnaseCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervals(outputFolder,permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2ZeroorOneMap,overlapDefinition);	
			}
			
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberDnaseCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}

			}//End of for
			
			interval = null;
			
		}//End of for
	}


	//with number starts
	//Empirical P Value Calculation
	//without IO
	public static void searchDnasewithoutIOwithNumbers(int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree,TIntIntMap permutationNumberDnaseCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
						
		for(int i= 0; i<inputLines.size(); i++){
			TIntIntMap permutationNumberDnaseCellLineName2ZeroorOneMap = new TIntIntHashMap();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervalsWithNumbers(permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, permutationNumberDnaseCellLineName2ZeroorOneMap,overlapDefinition);				
			}
			
			
				
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(TIntIntIterator it = permutationNumberDnaseCellLineName2ZeroorOneMap.iterator(); it.hasNext(); ){
				 
				it.advance();
				
				if (!(permutationNumberDnaseCellLineName2KMap.containsKey(it.key()))){
					permutationNumberDnaseCellLineName2KMap.put(it.key(), it.value());
				}else{
					permutationNumberDnaseCellLineName2KMap.put(it.key(), permutationNumberDnaseCellLineName2KMap.get(it.key())+ it.value());
				}

			}//End of for
				
			interval = null;
			
		}//End of for
	}		
	//with number ends
	
	
	//Empirical P Value Calculation
	//without IO
	public static void searchDnasewithoutIO(int permutationNumber,ChromosomeName chromName,List<InputLine> inputLines, IntervalTree dnaseIntervalTree,Map<String,Integer> permutationNumberDnaseCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;		
		int low;
		int high;
		
//			//Keeps the overlapping node list for the current query
//			List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the latest non empty overlapping node list for the previous queries
//			List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the left most node 
//			IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//			
//			IntervalTreeNode newSearchStartingNode= dnaseIntervalTree.getRoot();
				
			
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberDnaseCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
			
			inputLine = inputLines.get(i);
			low = inputLine.getLow();
			high = inputLine.getHigh();
													
			Interval interval = new Interval(low,high);
			
//				//Empty the overlapping node list for the new query
//				overlappingNodeList.clear();	
//				
//				if (previousLeftMostNode.isNotSentinel()){
//				
//					//Go up in the interval tree for the new query
//					newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//					
//					//Go down in the interval tree for the new query 
//					newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//				}
//				
//				
//				
//				//If sentinel means that there is no need to search for this new query
//				if(newSearchStartingNode.isNotSentinel()){
//					dnaseIntervalTree.findAllOverlappingDnaseIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName, permutationNumberDnaseCellLineName2ZeroorOneMap,overlappingNodeList);							
//				}			
//				
//				if(!overlappingNodeList.isEmpty()){
//					previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//					previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//				}			

			if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
				dnaseIntervalTree.findAllOverlappingDnaseIntervals(permutationNumber,dnaseIntervalTree.getRoot(),interval,chromName, permutationNumberDnaseCellLineName2ZeroorOneMap,overlapDefinition);				
			}
			
			//accumulate search results of dnaseCellLine2OneorZeroMap in permutationNumberDnaseCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberDnaseCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberDnaseCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberDnaseCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}

			}//End of for
			
			interval = null;
			
		}//End of for
	}
	
	//@todo starts
	public void searchDnaseWithNumbers(String outputFolder,ChromosomeName chromName,BufferedReader bufferedReader, IntervalTree dnaseIntervalTree, TShortObjectMap<BufferedWriter> dnaseCellLineNumber2BufferedWriterHashMap, TShortIntMap dnaseCellLineNumber2KMap,int overlapDefinition,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap){
		
		
		String strLine = null;
		int indexofFirstTab = 0 ;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				TShortShortMap dnaseCellLineNumber2OneorZeroMap = new TShortShortHashMap();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
							
				Interval interval = new Interval(low,high);

				
				if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
					dnaseIntervalTree.findAllOverlappingDnaseIntervalsWithNumbers(outputFolder,dnaseIntervalTree.getRoot(),interval,chromName, dnaseCellLineNumber2BufferedWriterHashMap, dnaseCellLineNumber2OneorZeroMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
				}
				
				//too many opened files error starts
				if(!dnaseCellLineNumber2BufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(dnaseCellLineNumber2BufferedWriterHashMap);
					dnaseCellLineNumber2BufferedWriterHashMap.clear();
				}
				//too many opened files error ends
					
//				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
//				for(Map.Entry<String, Integer> zeroOrOne: dnaseCellLineNumber2OneorZeroMap.entrySet()){
//					 
//					if (dnaseCellLineNumber2KMap.get(zeroOrOne.getKey())==null){
//						dnaseCellLineNumber2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
//					}else{
//						dnaseCellLineNumber2KMap.put(zeroOrOne.getKey(), dnaseCellLineNumber2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
//						
//					}
//	
//				}//End of for
				
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				// accessing keys/values through an iterator:
				for ( TShortShortIterator it = dnaseCellLineNumber2OneorZeroMap.iterator(); it.hasNext(); ) {
				    it.advance();
				    if (!dnaseCellLineNumber2KMap.containsKey(it.key())){
				    	dnaseCellLineNumber2KMap.put(it.key(),it.value());
				    }else{
				    	dnaseCellLineNumber2KMap.put(it.key(), dnaseCellLineNumber2KMap.get(it.key())+it.value());
						
				    }			        
				}/* End of For */
				
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
			
	}
	//@todo ends
	
	
	public void searchDnase(String outputFolder,ChromosomeName chromName,BufferedReader bufferedReader, IntervalTree dnaseIntervalTree, Map<String,BufferedWriter> dnaseBufferedWriterHashMap,List<String> dnaseCellLineNameList,Map<String,Integer> dnaseCellLine2KMap,int overlapDefinition){
		
		
		String strLine = null;
		int indexofFirstTab = 0 ;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				Map<String,Integer> dnaseCellLine2OneorZeroMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
							
				Interval interval = new Interval(low,high);

				
				if(dnaseIntervalTree.getRoot().getNodeName().isNotSentinel()){
					dnaseIntervalTree.findAllOverlappingDnaseIntervals(outputFolder,dnaseIntervalTree.getRoot(),interval,chromName, dnaseBufferedWriterHashMap,dnaseCellLineNameList, dnaseCellLine2OneorZeroMap,overlapDefinition);
				}
				
				//too many opened files error starts
				if(!dnaseBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(dnaseBufferedWriterHashMap);
					dnaseBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
					
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: dnaseCellLine2OneorZeroMap.entrySet()){
					 
					if (dnaseCellLine2KMap.get(zeroOrOne.getKey())==null){
						dnaseCellLine2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						dnaseCellLine2KMap.put(zeroOrOne.getKey(), dnaseCellLine2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
			
	}
	
	//@todo
	//with Numbers
	//Empirical P Value Calculation
	//with IO
	public static void searchTfbsWithNumbers(String outputFolder,int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, TLongObjectMap<BufferedWriter> tfbsBufferedWriterHashMap, TLongIntMap permutationNumberTfNumberCellLineNumber2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			TLongIntMap permutationNumberTfNumberCellLineNumber2ZeroorOneMap = new TLongIntHashMap();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfNumberCellLineNumber2ZeroorOneMap,overlapDefinition);
			}
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(TLongIntIterator it = permutationNumberTfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
				 
				it.advance();
				
				if (!(permutationNumberTfNumberCellLineNumber2KMap.containsKey(it.key()))){
					permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), permutationNumberTfNumberCellLineNumber2KMap.get(it.key())+it.value());
					
				}

			}//End of for
		}//End of for
	}
	//with Numbers
	//@todo

	//Empirical P Value Calculation
	//with IO
	public static void searchTfbs(String outputFolder,int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberTfbsNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlapDefinition);
			}
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfbsNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					
				}

			}//End of for
		}//End of for
	}
	
	
	//@todo
	//Empirical P Value Calculation
	//without IO
	public static void searchTfbswithoutIOwithNumbers(int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, TLongIntMap permutationNumberTfbsNameCellLineName2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
	
		for(int i= 0; i<inputLines.size(); i++){
			TLongIntMap permutationNumberTfbsNameCellLineName2ZeroorOneMap = new TLongIntHashMap();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlapDefinition);
			}
			
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(TLongIntIterator it = permutationNumberTfbsNameCellLineName2ZeroorOneMap.iterator(); it.hasNext(); ){
				it.advance();
				 
				if (!(permutationNumberTfbsNameCellLineName2KMap.containsKey(it.key()))){
					permutationNumberTfbsNameCellLineName2KMap.put(it.key(), it.value());
				}else{
					permutationNumberTfbsNameCellLineName2KMap.put(it.key(), permutationNumberTfbsNameCellLineName2KMap.get(it.key())+it.value());
					
				}

			}//End of for
			
			
			
			
		}//End of for
	}
	//@todo

	//Empirical P Value Calculation
	//without IO
	public static void searchTfbswithoutIO(int permutationNumber,ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfbsIntervalTree, Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
//			//Keeps the overlapping node list for the current query
//			List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the latest non empty overlapping node list for the previous queries
//			List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the left most node 
//			IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//			
//			IntervalTreeNode newSearchStartingNode= tfbsIntervalTree.getRoot();
	
		for(int i= 0; i<inputLines.size(); i++){
			Map<String,Integer> permutationNumberTfbsNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
		
			inputLine = inputLines.get(i);
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
//				//Empty the overlapping node list for the new query
//				overlappingNodeList.clear();	
//				
//				if (previousLeftMostNode.isNotSentinel()){
//				
//					//Go up in the interval tree for the new query
//					newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//					
//					//Go down in the interval tree for the new query 
//					newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//				}
//				
//				
//				
//				//If sentinel means that there is no need to search for this new query
//				if(newSearchStartingNode.isNotSentinel()){
//					tfbsIntervalTree.findAllOverlappingTfbsIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlappingNodeList);
//				}			
//				
//				if(!overlappingNodeList.isEmpty()){
//					previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//					previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//				}

			
			if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfbsIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfbsIntervalTree.getRoot(),interval,chromName,permutationNumberTfbsNameCellLineName2ZeroorOneMap,overlapDefinition);
			}
			
			//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfbsNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfbsNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfbsNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					
				}

			}//End of for
		}//End of for
	}

	public void searchTfbs(ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree tfbsIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, List<String> tfbsNameList, Map<String,Integer> tfbsNameandCellLineName2KMap){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> tfbsNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfbsIntervalTree.findAllOverlappingTfbsIntervals(tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,tfbsNameList,tfbsNameandCellLineName2ZeroorOneMap);	
				}
				
				//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: tfbsNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	
	
	//@todo Gene Annotation with numbers starts
	public void searchGeneWithNumbers(
			String outputFolder,
			ChromosomeName chromName, 
			BufferedReader bufferedReader, 
			IntervalTree ucscRefSeqGenesIntervalTree,
			TIntIntMap geneAlternateNumber2KMap, 
			int overlapDefinition,
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
			String strLine = null;
			int indexofFirstTab = 0;
			int indexofSecondTab = 0;
			
			int low;
			int high;
						
				try {
				while((strLine = bufferedReader.readLine())!=null){
					
					
					TIntShortMap 	geneAlternateNumber2OneorZeroMap		= new TIntShortHashMap();
											
					indexofFirstTab 	= strLine.indexOf('\t');
					indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
					
					low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
					
	//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
					if (indexofSecondTab>0)
						high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
					else 
						high = low;
					
					Interval interval = new Interval(low,high);
					
								
					//UCSCRefSeqGenes Search starts here
					if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllGeneOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,geneAlternateNumber2OneorZeroMap,Commons.NCBI_GENE_ID,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					}
					//UCSCRefSeqGenes Search ends here
					
				
					//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
					for(TIntShortIterator it =  geneAlternateNumber2OneorZeroMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!geneAlternateNumber2KMap.containsKey(it.key())){
							geneAlternateNumber2KMap.put(it.key(), it.value());
						}else{
							geneAlternateNumber2KMap.put(it.key(), geneAlternateNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					
					
				}//End of while
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // End of while 
	}

	//@todo Gene Annotation with numbers ends
	
	
	//@todo Annotation with numbers starts
	//KEGG Pathway
	public void searchKeggPathwayWithNumbers(
			String outputFolder,
			ChromosomeName chromName, 
			BufferedReader bufferedReader, 
			IntervalTree ucscRefSeqGenesIntervalTree,
			TShortObjectMap<BufferedWriter>	exonBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> allBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortIntMap exonBasedKeggPathwayNumber2KMap, 
			TShortIntMap regulationBasedKeggPathwayNumber2KMap, 
			TShortIntMap allBasedKeggPathwayNumber2KMap, 
			int overlapDefinition,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
			String strLine = null;
			int indexofFirstTab = 0;
			int indexofSecondTab = 0;
			
			int low;
			int high;
						
				try {
				while((strLine = bufferedReader.readLine())!=null){
					
					
					//KEGGPathway
					TShortShortMap 	exonBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
					TShortShortMap 	regulationBasedKeggPathway2OneorZeroMap = new TShortShortHashMap();
					TShortShortMap 	allBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
											
					indexofFirstTab 	= strLine.indexOf('\t');
					indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
					
					low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
					
	//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
					if (indexofSecondTab>0)
						high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
					else 
						high = low;
					
					Interval interval = new Interval(low,high);
					
								
					//UCSCRefSeqGenes Search starts here
					if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayNumberBufferedWriterHashMap,regulationBasedKeggPathwayNumberBufferedWriterHashMap,allBasedKeggPathwayNumberBufferedWriterHashMap,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					}
					//UCSCRefSeqGenes Search ends here
					
					
					//too many opened files error starts
					if(!exonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(exonBasedKeggPathwayNumberBufferedWriterHashMap);
						exonBasedKeggPathwayNumberBufferedWriterHashMap.clear();		
					}
					
					if(!regulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(regulationBasedKeggPathwayNumberBufferedWriterHashMap);
						regulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					
					if(!allBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(allBasedKeggPathwayNumberBufferedWriterHashMap);	
						allBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}				
					//too many opened files error ends
					
					//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
					for(TShortShortIterator it =  exonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!exonBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							exonBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							exonBasedKeggPathwayNumber2KMap.put(it.key(), exonBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					
					//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
					for(TShortShortIterator it =   regulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!regulationBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), regulationBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
					for(TShortShortIterator it =  allBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!allBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							allBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							allBasedKeggPathwayNumber2KMap.put(it.key(), allBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
							
						}
		
					}//End of for
					
					
				}//End of while
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // End of while 
	}
	//KEGG Pathway
	//@todo Annotation with numbers ends
	
	//@todo TF KEGGPathway Annotation with Numbers starts
	public void searchTfKEGGPathwayWithNumbers(
			String outputFolder,
			ChromosomeName chromName, 
			BufferedReader bufferedReader, 
			IntervalTree tfbsIntervalTree,
			IntervalTree ucscRefSeqGenesIntervalTree,
			TIntObjectMap<BufferedWriter>  	tfNumberBufferedWriterHashMap, 
			TShortObjectMap<BufferedWriter>	exonBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> allBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntIntMap tfNumberCellLineNumber2KMap, 
			TShortIntMap exonBasedKeggPathwayNumber2KMap, 
			TShortIntMap regulationBasedKeggPathwayNumber2KMap, 
			TShortIntMap allBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberExonBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberRegulationBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberAllBasedKeggPathwayNumber2KMap,
			int overlapDefinition,
			TShortObjectMap<String> tfNumber2TfNameMap, 
			TShortObjectMap<String> cellLineNumber2CellLineNameMap,		
			TShortObjectMap<String> fileNumber2FileNameMap,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
			String strLine = null;
			int indexofFirstTab = 0;
			int indexofSecondTab = 0;
			
			int low;
			int high;
						
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
					
			short tfNumber;
			short cellLineNumber;
			short keggPathwayNumber;
						
			int tfNumberCellLineNumber;
			int tfNumberKeggPathwayNumber;
			int tfNumberCellLineNumberKeggPathwayNumber;
						
			try {
				while((strLine = bufferedReader.readLine())!=null){
					
					//TF CellLine
					TIntShortMap 	tfNumberCellLineNumber2ZeroorOneMap 	= new TIntShortHashMap();
					
					//KEGGPathway
					TShortShortMap 	exonBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
					TShortShortMap 	regulationBasedKeggPathway2OneorZeroMap = new TShortShortHashMap();
					TShortShortMap 	allBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
					
					//TF KEGGPathway
					TIntShortMap tfExonBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
					TIntShortMap tfRegulationBasedKeggPathway2OneorZeroMap 	= new TIntShortHashMap();
					TIntShortMap tfAllBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
					
								
					//Fill these lists during search for tfs and search for ucscRefSeqGenes
					List<TfCellLineOverlapWithNumbers> tfandCellLineOverlapList 					= new ArrayList<TfCellLineOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> exonBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> regulationBasedKeggPathwayOverlapList 	= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> allBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
						
					indexofFirstTab 	= strLine.indexOf('\t');
					indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
					
					low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
					
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
					if (indexofSecondTab>0)
						high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
					else 
						high = low;
					
					Interval interval = new Interval(low,high);
					
					//TF Search starts here					
					if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
						tfbsIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,tfbsIntervalTree.getRoot(),interval,chromName,tfNumberBufferedWriterHashMap,tfNumberCellLineNumber2ZeroorOneMap,tfandCellLineOverlapList,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);	
					}
					
					//too many opened files error starts
					if(!tfNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberBufferedWriterHashMap);
						tfNumberBufferedWriterHashMap.clear();
					
					}
					//too many opened files error ends
					
					
					//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
					for(TIntShortIterator it =tfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!tfNumberCellLineNumber2KMap.containsKey(it.key())){
							tfNumberCellLineNumber2KMap.put(it.key(), it.value());
						}else{
							tfNumberCellLineNumber2KMap.put(it.key(), tfNumberCellLineNumber2KMap.get(it.key())+it.value());						
						}
		
					}//End of for
					//TF Search ends here					
					
					//UCSCRefSeqGenes Search starts here
					if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayNumberBufferedWriterHashMap,regulationBasedKeggPathwayNumberBufferedWriterHashMap,allBasedKeggPathwayNumberBufferedWriterHashMap, geneId2ListofKeggPathwayNumberMap,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,exonBasedKeggPathwayOverlapList,regulationBasedKeggPathwayOverlapList,allBasedKeggPathwayOverlapList,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					}
					//UCSCRefSeqGenes Search ends here
					
					
					//too many opened files error starts
					if(!exonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(exonBasedKeggPathwayNumberBufferedWriterHashMap);
						exonBasedKeggPathwayNumberBufferedWriterHashMap.clear();		
					}
					
					if(!regulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(regulationBasedKeggPathwayNumberBufferedWriterHashMap);
						regulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					
					if(!allBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(allBasedKeggPathwayNumberBufferedWriterHashMap);	
						allBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}				
					//too many opened files error ends
					
					//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
					for(TShortShortIterator it =  exonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!exonBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							exonBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							exonBasedKeggPathwayNumber2KMap.put(it.key(), exonBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					
					//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
					for(TShortShortIterator it =   regulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!regulationBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), regulationBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
					for(TShortShortIterator it =  allBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!allBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							allBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							allBasedKeggPathwayNumber2KMap.put(it.key(), allBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
							
						}
		
					}//End of for
					//code will be added here
					
					
					//New search for given input SNP or interval case, does not matter.
					//starts here
					//for each tf overlap
					//for each ucscRefSeqGene overlap
					//if these overlaps overlaps
					//then write common overlap to output files 
					//question will the overlapDefinition apply here?
					for(TfCellLineOverlapWithNumbers tfOverlap: tfandCellLineOverlapList){
						
						tfNumberCellLineNumber 	= tfOverlap.getTfNumberCellLineNumber();
						tfNumber 		= IntervalTree.getElementNumber(tfNumberCellLineNumber);			
						cellLineNumber 	=IntervalTree.getCellLineNumber(tfNumberCellLineNumber);
					
						//TF and Exon Based KEGGPathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: exonBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(),ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								
											
								for(TShortIterator it =  ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
											
											keggPathwayNumber = it.next();										
											
											tfNumberCellLineNumberKeggPathwayNumber = tfNumberCellLineNumber  + keggPathwayNumber;
											tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
																				
											
											if (!tfExonBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
												tfExonBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
											}
											
											/*************************************************************/
											bufferedWriter = tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
											
											//first open
											if (bufferedWriter==null){																
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber)  + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();
											}

											
											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/*************************************************************/

								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query
						
											
						//TF and Regulation Based Kegg Pathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: regulationBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
											
											keggPathwayNumber = it.next();
											
											tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
											tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
											
											
											if (!tfRegulationBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
												tfRegulationBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
											}
																					
											
											/***********************************************************/
											bufferedWriter = tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
											
											
											if (bufferedWriter==null){						
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();
											}	
											

											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh() + "\t" + refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber())  + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t" + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/***********************************************************/
											
											
								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query
										
						
						//TF and All Based Kegg Pathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: allBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
									
											keggPathwayNumber = it.next();
											
											tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
											tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
											
											
											if (!tfAllBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
												tfAllBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
											}
											
																							
											/*****************************************************************/
											bufferedWriter = tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
											
											
											if (bufferedWriter==null){						
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();
											}

										
											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/*****************************************************************/
									
											
								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query

					}//for each tfOverlap for the given query
					//ends here
					
					//too many opened files error starts
					if(!tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap);
						tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.clear();					
					}				
					//too many opened files error ends
					
					//too many opened files error starts
					if(!tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap);
						tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					//too many opened files error ends
					
					//too many opened files error starts
					if(!tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap);
						tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}					
					//too many opened files error ends
					
						
					//TF EXONBASED_KEGGPATHWAY
					//Fill tfExonBasedKeggPathway2KMap using tfExonBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it = tfExonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						
						tfNumberKeggPathwayNumber = it.key();
						
						//new
						if (!tfNumberExonBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
							tfNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberExonBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
						}
						//new		
					}//End of for inner loop 
					
					//TF REGULATIONBASED_KEGGPATHWAY
					//Fill tfRegulationBasedKeggPathway2KMap using tfRegulationBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it =  tfRegulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						tfNumberKeggPathwayNumber = it.key();
						
						//new
						if (!tfNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
							tfNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberRegulationBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
						}
						//new	
					}//End of for inner loop 
					
					
					//TF ALLBASED_KEGGPATHWAY
					//Fill  tfAllBasedKeggPathway2KMap using tfAllBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it =  tfAllBasedKeggPathway2OneorZeroMap.iterator();it.hasNext();){
						
						it.advance();
						tfNumberKeggPathwayNumber = it.key();
						
						//new
						if (!tfNumberAllBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
							tfNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberAllBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
						}
						//new
						
					}//End of for inner loop 
					
					//added here ends
					
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // End of while 
		}

	//@todo TF KEGGPathway Annotation with Numbers starts
	
	//@todo TF CELLLINE KEGGPATHWAY Annotation with Numbers starts
	public void searchTfCellLineKEGGPathwayWithNumbers(
			String outputFolder,
			ChromosomeName chromName, 
			BufferedReader bufferedReader, 
			IntervalTree tfbsIntervalTree,
			IntervalTree ucscRefSeqGenesIntervalTree,
			TIntObjectMap<BufferedWriter>  	tfNumberBufferedWriterHashMap, 
			TShortObjectMap<BufferedWriter>	exonBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayNumberBufferedWriterHashMap,
			TShortObjectMap<BufferedWriter> allBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap,
			TIntIntMap tfNumberCellLineNumber2KMap, 
			TShortIntMap exonBasedKeggPathwayNumber2KMap, 
			TShortIntMap regulationBasedKeggPathwayNumber2KMap, 
			TShortIntMap allBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,
			int overlapDefinition,
			TShortObjectMap<String> tfNumber2TfNameMap, 
			TShortObjectMap<String> cellLineNumber2CellLineNameMap,		
			TShortObjectMap<String> fileNumber2FileNameMap,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
			String strLine = null;
			int indexofFirstTab = 0;
			int indexofSecondTab = 0;
			
			int low;
			int high;
						
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
					
			short tfNumber;
			short cellLineNumber;
			short keggPathwayNumber;
			
			
			int tfNumberCellLineNumber;
			int tfNumberCellLineNumberKeggPathwayNumber;
			
			
			try {
				while((strLine = bufferedReader.readLine())!=null){
					
					//TF CellLine
					TIntShortMap 	tfNumberCellLineNumber2ZeroorOneMap 	= new TIntShortHashMap();
					
					//KEGGPathway
					TShortShortMap 	exonBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
					TShortShortMap 	regulationBasedKeggPathway2OneorZeroMap = new TShortShortHashMap();
					TShortShortMap 	allBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
					
					//TF CellLine KEGGPathway
					TIntShortMap tfCellLineExonBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
					TIntShortMap tfCellLineRegulationBasedKeggPathway2OneorZeroMap 	= new TIntShortHashMap();
					TIntShortMap tfCellLineAllBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
								
					//Fill these lists during search for tfs and search for ucscRefSeqGenes
					List<TfCellLineOverlapWithNumbers> tfandCellLineOverlapList 					= new ArrayList<TfCellLineOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> exonBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> regulationBasedKeggPathwayOverlapList 	= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
					List<UcscRefSeqGeneOverlapWithNumbers> allBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
						
					indexofFirstTab 	= strLine.indexOf('\t');
					indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
					
					low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
					
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
					if (indexofSecondTab>0)
						high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
					else 
						high = low;
					
					Interval interval = new Interval(low,high);
					
					//TF Search starts here					
					if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
						tfbsIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,tfbsIntervalTree.getRoot(),interval,chromName,tfNumberBufferedWriterHashMap,tfNumberCellLineNumber2ZeroorOneMap,tfandCellLineOverlapList,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);	
					}
					
					//too many opened files error starts
					if(!tfNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberBufferedWriterHashMap);
						tfNumberBufferedWriterHashMap.clear();
					
					}
					//too many opened files error ends
					
					
					//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
					for(TIntShortIterator it =tfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!tfNumberCellLineNumber2KMap.containsKey(it.key())){
							tfNumberCellLineNumber2KMap.put(it.key(), it.value());
						}else{
							tfNumberCellLineNumber2KMap.put(it.key(), tfNumberCellLineNumber2KMap.get(it.key())+it.value());						
						}
		
					}//End of for
					//TF Search ends here					
					
					//UCSCRefSeqGenes Search starts here
					if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayNumberBufferedWriterHashMap,regulationBasedKeggPathwayNumberBufferedWriterHashMap,allBasedKeggPathwayNumberBufferedWriterHashMap, geneId2ListofKeggPathwayNumberMap,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,exonBasedKeggPathwayOverlapList,regulationBasedKeggPathwayOverlapList,allBasedKeggPathwayOverlapList,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					}
					//UCSCRefSeqGenes Search ends here
					
					
					//too many opened files error starts
					if(!exonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(exonBasedKeggPathwayNumberBufferedWriterHashMap);
						exonBasedKeggPathwayNumberBufferedWriterHashMap.clear();		
					}
					
					if(!regulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(regulationBasedKeggPathwayNumberBufferedWriterHashMap);
						regulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					
					if(!allBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(allBasedKeggPathwayNumberBufferedWriterHashMap);	
						allBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}				
					//too many opened files error ends
					
					//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
					for(TShortShortIterator it =  exonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						 it.advance();
						 
						if (!exonBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							exonBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							exonBasedKeggPathwayNumber2KMap.put(it.key(), exonBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					
					//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
					for(TShortShortIterator it =   regulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!regulationBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							regulationBasedKeggPathwayNumber2KMap.put(it.key(), regulationBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						}
		
					}//End of for
					
					//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
					for(TShortShortIterator it =  allBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						 
						if (!allBasedKeggPathwayNumber2KMap.containsKey(it.key())){
							allBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
						}else{
							allBasedKeggPathwayNumber2KMap.put(it.key(), allBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
							
						}
		
					}//End of for
					//code will be added here
					
					
					//New search for given input SNP or interval case, does not matter.
					//starts here
					//for each tf overlap
					//for each ucscRefSeqGene overlap
					//if these overlaps overlaps
					//then write common overlap to output files 
					//question will the overlapDefinition apply here?
					for(TfCellLineOverlapWithNumbers tfOverlap: tfandCellLineOverlapList){
						
						tfNumberCellLineNumber 	= tfOverlap.getTfNumberCellLineNumber();
						tfNumber 		= IntervalTree.getElementNumber(tfNumberCellLineNumber);			
						cellLineNumber 	=IntervalTree.getCellLineNumber(tfNumberCellLineNumber);
					
						//TF CellLine ExonBasedKEGGPathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: exonBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(),ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								
											
								for(TShortIterator it =  ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
											
											keggPathwayNumber = it.next();
																						
											tfNumberCellLineNumberKeggPathwayNumber = tfNumberCellLineNumber  + keggPathwayNumber;
																																
											if (!tfCellLineExonBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
												tfCellLineExonBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short)1);
											}
									
																					
											/*************************************************************/
											bufferedWriter = tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
											
													
											if (bufferedWriter==null){
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber)  + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();

											}
											
											

											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) +"_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/*************************************************************/

	
								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query
						
											
						//TF CellLine RegulationBasedKEGGPathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: regulationBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
											
											keggPathwayNumber = it.next();
											
											tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
											
											if (!tfCellLineRegulationBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
												tfCellLineRegulationBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short)1);
											}
											
											
											/***********************************************************/
											bufferedWriter = tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
											
											//first open	
											if (bufferedWriter==null){
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();
											}
												
											
											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) +"_" + cellLineNumber2CellLineNameMap.get(cellLineNumber)+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/***********************************************************/
											
											
												
											
								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query
										
						
						//TF Cellline AllBasedKEGGPathway
						for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: allBasedKeggPathwayOverlapList){
							if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
								for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
									
											keggPathwayNumber = it.next();
											
											tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
											
											if (!tfCellLineAllBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
												tfCellLineAllBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short) 1);
											}
									
											
											/*****************************************************************/
											bufferedWriter = tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
																
											if (bufferedWriter==null){		
												fileWriter = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
												bufferedWriter = new BufferedWriter(fileWriter);
												tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter);
												bufferedWriter.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
												bufferedWriter.flush();
										
											}
											
											bufferedWriter.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber)+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
											bufferedWriter.flush();
											/*****************************************************************/
											
											
											
											
								} //for each kegg pathways having this gene
							}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
						}//for each ucscRefSeqGeneOverlap for the given query

					}//for each tfOverlap for the given query
					//ends here
					
					//too many opened files error starts				
					if(!tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap);				
						tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.clear();				
					}
					
						
					if(!tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap);		
						tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					
					
					if(!tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
						closeBufferedWritersWithNumbers(tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap);			
						tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.clear();
					}
					//too many opened files error ends
					
					//TF CELLLINE EXONBASED_KEGGPATHWAY
					//Fill tfbsAndCellLineAndExonBasedKeggPathway2KMap using tfandExonBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it = tfCellLineExonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
					
						tfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
							tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					//TF CELLLINE REGULATIONBASED_KEGGPATHWAY
					//Fill tfbsAndCellLineAndRegulationBasedKeggPathway2KMap using tfandRegulationBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it = tfCellLineRegulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						
						tfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
							tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE ALLBASED_KEGGPATHWAY
					//Fill  tfbsAndCellLineAndAllBasedKeggPathway2KMap using tfandAllBasedKeggPathway2OneorZeroMap
					for(TIntShortIterator it =  tfCellLineAllBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
						
						it.advance();
						
						tfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
							tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
						
					
					
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} // End of while 
		}
	//@todo TF CELLLINE KEGGPATHWAY Annotation with Numbers ends
	
	
	//@todo Annotation with Numbers starts
	//TF and KEGGPathway
	//TF and CellLine and KEGGPathway
	public void searchTfandKeggPathwayWithNumbers(
		String outputFolder,
		ChromosomeName chromName, 
		BufferedReader bufferedReader, 
		IntervalTree tfbsIntervalTree,
		IntervalTree ucscRefSeqGenesIntervalTree,
		TIntObjectMap<BufferedWriter>  	tfNumberBufferedWriterHashMap, 
		TShortObjectMap<BufferedWriter>	exonBasedKeggPathwayNumberBufferedWriterHashMap,
		TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayNumberBufferedWriterHashMap,
		TShortObjectMap<BufferedWriter> allBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<BufferedWriter> 	tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap,
		TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
		TIntIntMap tfNumberCellLineNumber2KMap, 
		TShortIntMap exonBasedKeggPathwayNumber2KMap, 
		TShortIntMap regulationBasedKeggPathwayNumber2KMap, 
		TShortIntMap allBasedKeggPathwayNumber2KMap, 
		TIntIntMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap, 
		TIntIntMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap, 
		TIntIntMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,
		TIntIntMap tfNumberExonBasedKeggPathwayNumber2KMap, 
		TIntIntMap tfNumberRegulationBasedKeggPathwayNumber2KMap, 
		TIntIntMap tfNumberAllBasedKeggPathwayNumber2KMap,
		int overlapDefinition,
		TShortObjectMap<String> tfNumber2TfNameMap, 
		TShortObjectMap<String> cellLineNumber2CellLineNameMap,		
		TShortObjectMap<String> fileNumber2FileNameMap,
		TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
		TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
		TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
		
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
					
		FileWriter fileWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter1 = null;
		BufferedWriter bufferedWriter2 = null;
				
		short tfNumber;
		short cellLineNumber;
		short keggPathwayNumber;
		
		
		int tfNumberCellLineNumber;
		int tfNumberKeggPathwayNumber;
		int tfNumberCellLineNumberKeggPathwayNumber;
		
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				//TF CellLine
				TIntShortMap 	tfNumberCellLineNumber2ZeroorOneMap 	= new TIntShortHashMap();
				
				//KEGGPathway
				TShortShortMap 	exonBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
				TShortShortMap 	regulationBasedKeggPathway2OneorZeroMap = new TShortShortHashMap();
				TShortShortMap 	allBasedKeggPathway2OneorZeroMap 		= new TShortShortHashMap();
				
				//TF KEGGPathway
				TIntShortMap tfExonBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
				TIntShortMap tfRegulationBasedKeggPathway2OneorZeroMap 	= new TIntShortHashMap();
				TIntShortMap tfAllBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
				
				//TF CellLine KEGGPathway
				TIntShortMap tfCellLineExonBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
				TIntShortMap tfCellLineRegulationBasedKeggPathway2OneorZeroMap 	= new TIntShortHashMap();
				TIntShortMap tfCellLineAllBasedKeggPathway2OneorZeroMap 		= new TIntShortHashMap();
							
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<TfCellLineOverlapWithNumbers> tfandCellLineOverlapList 					= new ArrayList<TfCellLineOverlapWithNumbers>();
				List<UcscRefSeqGeneOverlapWithNumbers> exonBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
				List<UcscRefSeqGeneOverlapWithNumbers> regulationBasedKeggPathwayOverlapList 	= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
				List<UcscRefSeqGeneOverlapWithNumbers> allBasedKeggPathwayOverlapList 			= new ArrayList<UcscRefSeqGeneOverlapWithNumbers>();
					
				indexofFirstTab 	= strLine.indexOf('\t');
				indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				//TF Search starts here					
				if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfbsIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,tfbsIntervalTree.getRoot(),interval,chromName,tfNumberBufferedWriterHashMap,tfNumberCellLineNumber2ZeroorOneMap,tfandCellLineOverlapList,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);	
				}
				
				//too many opened files error starts
				if(!tfNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberBufferedWriterHashMap);
					tfNumberBufferedWriterHashMap.clear();
				
				}
				//too many opened files error ends
				
				
				//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
				for(TIntShortIterator it =tfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext();){
					 it.advance();
					 
					if (!tfNumberCellLineNumber2KMap.containsKey(it.key())){
						tfNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						tfNumberCellLineNumber2KMap.put(it.key(), tfNumberCellLineNumber2KMap.get(it.key())+it.value());						
					}
	
				}//End of for
				//TF Search ends here					
				
				//UCSCRefSeqGenes Search starts here
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayNumberBufferedWriterHashMap,regulationBasedKeggPathwayNumberBufferedWriterHashMap,allBasedKeggPathwayNumberBufferedWriterHashMap, geneId2ListofKeggPathwayNumberMap,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,exonBasedKeggPathwayOverlapList,regulationBasedKeggPathwayOverlapList,allBasedKeggPathwayOverlapList,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
				}
				//UCSCRefSeqGenes Search ends here
				
				
				//too many opened files error starts
				if(!exonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(exonBasedKeggPathwayNumberBufferedWriterHashMap);
					exonBasedKeggPathwayNumberBufferedWriterHashMap.clear();		
				}
				
				if(!regulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(regulationBasedKeggPathwayNumberBufferedWriterHashMap);
					regulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}
				
				if(!allBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(allBasedKeggPathwayNumberBufferedWriterHashMap);	
					allBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}				
				//too many opened files error ends
				
				//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
				for(TShortShortIterator it =  exonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					 it.advance();
					 
					if (!exonBasedKeggPathwayNumber2KMap.containsKey(it.key())){
						exonBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
					}else{
						exonBasedKeggPathwayNumber2KMap.put(it.key(), exonBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
					}
	
				}//End of for
				
				
				//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
				for(TShortShortIterator it =   regulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					 
					if (!regulationBasedKeggPathwayNumber2KMap.containsKey(it.key())){
						regulationBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
					}else{
						regulationBasedKeggPathwayNumber2KMap.put(it.key(), regulationBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
					}
	
				}//End of for
				
				//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
				for(TShortShortIterator it =  allBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					 
					if (!allBasedKeggPathwayNumber2KMap.containsKey(it.key())){
						allBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
					}else{
						allBasedKeggPathwayNumber2KMap.put(it.key(), allBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
				//code will be added here
				
				
				//New search for given input SNP or interval case, does not matter.
				//starts here
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//then write common overlap to output files 
				//question will the overlapDefinition apply here?
				for(TfCellLineOverlapWithNumbers tfOverlap: tfandCellLineOverlapList){
					
					tfNumberCellLineNumber 	= tfOverlap.getTfNumberCellLineNumber();
					tfNumber 		= IntervalTree.getElementNumber(tfNumberCellLineNumber);			
					cellLineNumber 	=IntervalTree.getCellLineNumber(tfNumberCellLineNumber);
				
					//TF and Exon Based KEGGPathway
					for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: exonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(),ucscRefSeqGeneOverlapWithNumbers.getHigh())){
							
										
							for(TShortIterator it =  ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
										
										keggPathwayNumber = it.next();
										
										
										tfNumberCellLineNumberKeggPathwayNumber = tfNumberCellLineNumber  + keggPathwayNumber;
										tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
										
										
									
										if (!tfCellLineExonBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
											tfCellLineExonBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short)1);
										}
								
										if (!tfExonBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
											tfExonBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
										}
										
										/*************************************************************/
										bufferedWriter1 = tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
										
												
										if (bufferedWriter1==null){
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber)  + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();

										}
										
										

										bufferedWriter1.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) +"_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*************************************************************/

										/*************************************************************/
										bufferedWriter2 = tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
										
										//first open
										if (bufferedWriter2==null){																
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber)  + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}

										
										bufferedWriter2.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*************************************************************/

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
										
					//TF and Regulation Based Kegg Pathway
					for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: regulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
							for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
										
										keggPathwayNumber = it.next();
										
										tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
										tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
										
										if (!tfCellLineRegulationBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
											tfCellLineRegulationBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short)1);
										}
										
										if (!tfRegulationBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
											tfRegulationBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
										}
										
										/***********************************************************/
										bufferedWriter1 = tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
										
										//first open	
										if (bufferedWriter1==null){
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();
										}
											
										
										bufferedWriter1.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) +"_" + cellLineNumber2CellLineNameMap.get(cellLineNumber)+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/***********************************************************/
										
										
										/***********************************************************/
										bufferedWriter2 = tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
										
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}	
										

										bufferedWriter2.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh() + "\t" + refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber())  + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t" + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/***********************************************************/
										
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
									
					
					//TF and All Based Kegg Pathway
					for (UcscRefSeqGeneOverlapWithNumbers ucscRefSeqGeneOverlapWithNumbers: allBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlapWithNumbers.getLow(), ucscRefSeqGeneOverlapWithNumbers.getHigh())){
							for(TShortIterator it = ucscRefSeqGeneOverlapWithNumbers.getKeggPathwayNumberList().iterator(); it.hasNext();){
								
										keggPathwayNumber = it.next();
										
										tfNumberCellLineNumberKeggPathwayNumber = tfOverlap.getTfNumberCellLineNumber() + keggPathwayNumber;
										tfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumber(tfNumberCellLineNumberKeggPathwayNumber);
										
										if (!tfCellLineAllBasedKeggPathway2OneorZeroMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
											tfCellLineAllBasedKeggPathway2OneorZeroMap.put(tfNumberCellLineNumberKeggPathwayNumber, (short) 1);
										}
								
										if (!tfAllBasedKeggPathway2OneorZeroMap.containsKey(tfNumberKeggPathwayNumber)){
											tfAllBasedKeggPathway2OneorZeroMap.put(tfNumberKeggPathwayNumber, (short)1);
										}
										
										/*****************************************************************/
										bufferedWriter1 = tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberCellLineNumberKeggPathwayNumber);
															
										if (bufferedWriter1==null){		
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();
									
										}
										
										bufferedWriter1.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber)+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*****************************************************************/
										
										
										/*****************************************************************/
										bufferedWriter2 = tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.get(tfNumberKeggPathwayNumber);
										
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY +"_" + tfNumber2TfNameMap.get(tfNumber) + "_" +keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.put(tfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}

										

										bufferedWriter2.write(ChromosomeName.convertEnumtoString(chromName) + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfNumber2TfNameMap.get(tfNumber) + "_" + cellLineNumber2CellLineNameMap.get(cellLineNumber) + "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  refSeqGeneNumber2RefSeqGeneNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getRefSeqGeneNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getLow()+ "\t" + ucscRefSeqGeneOverlapWithNumbers.getHigh()  + "\t"  + ucscRefSeqGeneOverlapWithNumbers.getIntervalName() + "\t" + geneHugoSymbolNumber2GeneHugoSymbolNameMap.get(ucscRefSeqGeneOverlapWithNumbers.getGeneHugoSymbolNumber()) + "\t" + ucscRefSeqGeneOverlapWithNumbers.getGeneEntrezId()+ "\t" + keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber) + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*****************************************************************/
								
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query

				}//for each tfOverlap for the given query
				//ends here
				
				//too many opened files error starts
				if(!tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap);
					tfNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.clear();					
				}
				
				if(!tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap);				
					tfNumberCellLineNumberExonBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				
				}
				//too many opened files error ends
				
				//too many opened files error starts
				if(!tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap);
					tfNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}
				
				if(!tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap);		
					tfNumberCellLineNumberRegulationBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
				
				//too many opened files error starts
				if(!tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap);
					tfNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}
				
				
				
				if(!tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap);			
					tfNumberCellLineNumberAllBasedKeggPathwayNumberBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
				
				//TF CELLLINE EXONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndExonBasedKeggPathway2KMap using tfandExonBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it = tfCellLineExonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
				
					tfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
						tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE REGULATIONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndRegulationBasedKeggPathway2KMap using tfandRegulationBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it = tfCellLineRegulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					
					tfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
						tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALLBASED_KEGGPATHWAY
				//Fill  tfbsAndCellLineAndAllBasedKeggPathway2KMap using tfandAllBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it =  tfCellLineAllBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					
					tfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.containsKey(tfNumberCellLineNumberKeggPathwayNumber)){
						tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberCellLineNumberKeggPathwayNumber, tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.get(tfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				//TF EXONBASED_KEGGPATHWAY
				//Fill tfExonBasedKeggPathway2KMap using tfExonBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it = tfExonBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					
					tfNumberKeggPathwayNumber = it.key();
					
					//new
					if (!tfNumberExonBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
						tfNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberExonBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberExonBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
					}
					//new		
				}//End of for inner loop 
				
				//TF REGULATIONBASED_KEGGPATHWAY
				//Fill tfRegulationBasedKeggPathway2KMap using tfRegulationBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it =  tfRegulationBasedKeggPathway2OneorZeroMap.iterator(); it.hasNext();){
					
					it.advance();
					tfNumberKeggPathwayNumber = it.key();
					
					//new
					if (!tfNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
						tfNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberRegulationBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberRegulationBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
					}
					//new	
				}//End of for inner loop 
				
				
				//TF ALLBASED_KEGGPATHWAY
				//Fill  tfAllBasedKeggPathway2KMap using tfAllBasedKeggPathway2OneorZeroMap
				for(TIntShortIterator it =  tfAllBasedKeggPathway2OneorZeroMap.iterator();it.hasNext();){
					
					it.advance();
					tfNumberKeggPathwayNumber = it.key();
					
					//new
					if (!tfNumberAllBasedKeggPathwayNumber2KMap.containsKey(tfNumberKeggPathwayNumber)){
						tfNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, it.value());
					}else{
						tfNumberAllBasedKeggPathwayNumber2KMap.put(tfNumberKeggPathwayNumber, tfNumberAllBasedKeggPathwayNumber2KMap.get(tfNumberKeggPathwayNumber)+it.value());	
					}
					//new
					
				}//End of for inner loop 
				
				//added here ends
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	//@todo Annotation with Numbers ends
	
	//New Functionality
	//TF and Kegg Pathway
	//TF and CellLine and KeggPathway
	public void searchTfandKeggPathway(
			String outputFolder,
			ChromosomeName chromName, 
			BufferedReader bufferedReader, 
			IntervalTree tfbsIntervalTree,
			IntervalTree ucscRefSeqGenesIntervalTree,
			Map<String,BufferedWriter>  tfbsBufferedWriterHashMap, 
			Map<String,BufferedWriter>  exonBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter>  regulationBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter>  allBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,
			Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,
			List<String> tfNameList,
			List<String> keggPathwayNameList,
			Map<String,List<String>> geneId2KeggPathwayMap, 
			Map<String,Integer> tfbsNameandCellLineName2KMap, 
			Map<String,Integer> exonBasedKeggPathway2KMap, 
			Map<String,Integer> regulationBasedKeggPathway2KMap, 
			Map<String,Integer> allBasedKeggPathway2KMap, 
			Map<String,Integer> tfCellLineExonBasedKeggPathway2KMap, 
			Map<String,Integer> tfCellLineRegulationBasedKeggPathway2KMap, 
			Map<String,Integer> tfCellLineAllBasedKeggPathway2KMap,
			Map<String,Integer> tfExonBasedKeggPathway2KMap, 
			Map<String,Integer> tfRegulationBasedKeggPathway2KMap, 
			Map<String,Integer> tfAllBasedKeggPathway2KMap,int overlapDefinition){
			String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
			
		FileWriter fileWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter1 = null;
		BufferedWriter bufferedWriter2 = null;
		
		
		String tfName= null;
		String tfNameCellLineName= null;
		String tfNameCellLineNameKeggPathwayName = null;
		String tfNameKeggPathwayName = null;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> tfbsNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				Map<String,Integer> exonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> regulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> allBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//will be filled here
				Map<String,Integer> tfCellLineExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfCellLineRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfCellLineAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//new
				//will be filled here
				Map<String,Integer> tfExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				Map<String,Integer> tfAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<TfNameandCellLineNameOverlap> tfandCellLineOverlapList = new ArrayList<TfNameandCellLineNameOverlap>();
				List<UcscRefSeqGeneOverlap> exonBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
				List<UcscRefSeqGeneOverlap> regulationBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
				List<UcscRefSeqGeneOverlap> allBasedKeggPathwayOverlapList = new ArrayList<UcscRefSeqGeneOverlap>();
					
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				//TF Search starts here					
				if(tfbsIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfbsIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,tfbsIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,tfNameList,tfbsNameandCellLineName2ZeroorOneMap,tfandCellLineOverlapList,overlapDefinition);	
				}
				
				//too many opened files error starts
				if(!tfbsBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfbsBufferedWriterHashMap);
					tfbsBufferedWriterHashMap.clear();
				
				}
				//too many opened files error ends
				
				
				//accumulate search results of tfbsNameandCellLineName2ZeroorOneMap in tfbsNameandCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: tfbsNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						tfbsNameandCellLineName2KMap.put(zeroOrOne.getKey(), tfbsNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				//TF Search ends here					
				
				//UCSCRefSeqGenes Search starts here
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, keggPathwayNameList,exonBasedKeggPathway2OneorZeroMap,regulationBasedKeggPathway2OneorZeroMap,allBasedKeggPathway2OneorZeroMap,Commons.NCBI_GENE_ID,exonBasedKeggPathwayOverlapList,regulationBasedKeggPathwayOverlapList,allBasedKeggPathwayOverlapList,overlapDefinition);
				}
				//UCSCRefSeqGenes Search ends here
				
				
				//too many opened files error starts
				if(!exonBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
					exonBasedKeggPathwayBufferedWriterHashMap.clear();		
				}
				
				if(!regulationBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
					regulationBasedKeggPathwayBufferedWriterHashMap.clear();
				}
				
				if(!allBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);	
					allBasedKeggPathwayBufferedWriterHashMap.clear();
				}				
				//too many opened files error ends
				
				//accumulate search results of exonBasedKeggPathway2OneorZeroMap in exonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: exonBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (exonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						exonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						exonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), exonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
	
				}//End of for
				
				
				//accumulate search results of regulationBasedKeggPathway2OneorZeroMap in regulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: regulationBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (regulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						regulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						regulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), regulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
	
				}//End of for
				
				//accumulate search results of allBasedKeggPathway2OneorZeroMap in allBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: allBasedKeggPathway2OneorZeroMap.entrySet()){
					 
					if (allBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						allBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						allBasedKeggPathway2KMap.put(zeroOrOne.getKey(), allBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				//code will be added here
				
				
				//New search for given input SNP or interval case, does not matter.
				//starts here
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//then write common overlap to output files 
				//question will the overlapDefinition apply here?
				for(TfNameandCellLineNameOverlap tfOverlap: tfandCellLineOverlapList){
					
					tfNameCellLineName 	= tfOverlap.getTfNameandCellLineName();
					tfName 				= tfNameCellLineName.substring(0,tfNameCellLineName.indexOf('_'));
					
					//TF and Exon Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: exonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										
										tfNameCellLineNameKeggPathwayName = tfNameCellLineName + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										
									
										if (tfCellLineExonBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineExonBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
								
										if (tfExonBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfExonBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/*************************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
										
												
										if (bufferedWriter1==null){
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();

										}
										
										

										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*************************************************************/

										/*************************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										//first open
										if (bufferedWriter2==null){																
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_EXON_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}

										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*************************************************************/

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					
					
					//TF and Regulation Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: regulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){
										
										tfNameCellLineNameKeggPathwayName = tfOverlap.getTfNameandCellLineName() + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										if (tfCellLineRegulationBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineRegulationBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
										
										if (tfRegulationBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfRegulationBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/***********************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
										
										//first open	
										if (bufferedWriter1==null){
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();
										}
											
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/***********************************************************/
										
										
										/***********************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_REGULATION_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}	
										

										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh() + "\t" + ucscRefSeqGeneOverlap.getRefSeqGeneName()  + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t" + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/***********************************************************/
										
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
				
					
					
					//TF and All Based Kegg Pathway
					for (UcscRefSeqGeneOverlap ucscRefSeqGeneOverlap: allBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(tfOverlap.getLow(),tfOverlap.getHigh(),ucscRefSeqGeneOverlap.getLow(), ucscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:ucscRefSeqGeneOverlap.getKeggPathwayNameList()){
										
										tfNameCellLineNameKeggPathwayName = tfOverlap.getTfNameandCellLineName() + "_" + keggPathwayName;
										tfNameKeggPathwayName =  tfName + "_" + keggPathwayName;
										
										if (tfCellLineAllBasedKeggPathway2OneorZeroMap.get(tfNameCellLineNameKeggPathwayName)==null){
											tfCellLineAllBasedKeggPathway2OneorZeroMap.put(tfNameCellLineNameKeggPathwayName, 1);
										}
								
										if (tfAllBasedKeggPathway2OneorZeroMap.get(tfNameKeggPathwayName)==null){
											tfAllBasedKeggPathway2OneorZeroMap.put(tfNameKeggPathwayName, 1);
										}
										
										/*****************************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(tfNameCellLineNameKeggPathwayName);
															
										if (bufferedWriter1==null){		
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY +"_" + tfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(tfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter1.flush();
									
										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/*****************************************************************/
										
										
										/*****************************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(tfNameKeggPathwayName);
										
										
										if (bufferedWriter2==null){						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_INTERVALS_USING_INTERVAL_TREE_OUTPUT_FILE_PATH_FOR_TF_ALL_BASED_KEGG_PATHWAY +"_" + tfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(tfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											bufferedWriter2.flush();
										}

										

										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + tfOverlap.getTfNameandCellLineName()+ "\t"  + tfOverlap.getLow() + "\t" + tfOverlap.getHigh()  + "\t" +  ucscRefSeqGeneOverlap.getRefSeqGeneName() + "\t" + ucscRefSeqGeneOverlap.getLow()+ "\t" + ucscRefSeqGeneOverlap.getHigh()  + "\t"  + ucscRefSeqGeneOverlap.getIntervalName() + "\t" + ucscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + ucscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/*****************************************************************/
								
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query

				}//for each tfOverlap for the given query
				//ends here
				
				//too many opened files error starts
				if(!tfExonBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
					tfExonBasedKeggPathwayBufferedWriterHashMap.clear();					
				}
				
				if(!tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);				
					tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.clear();
				
				}
				//too many opened files error ends
				
				//too many opened files error starts
				if(!tfRegulationBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
					tfRegulationBasedKeggPathwayBufferedWriterHashMap.clear();
				}
				
				if(!tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);		
					tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
				
				//too many opened files error starts
				if(!tfAllBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
					tfAllBasedKeggPathwayBufferedWriterHashMap.clear();
				}
				
				
				
				if(!tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);			
					tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
				
				//TF CELLLINE EXONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndExonBasedKeggPathway2KMap using tfandExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineExonBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineExonBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineExonBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineExonBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE REGULATIONBASED_KEGGPATHWAY
				//Fill tfbsAndCellLineAndRegulationBasedKeggPathway2KMap using tfandRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineRegulationBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineRegulationBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineRegulationBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineRegulationBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALLBASED_KEGGPATHWAY
				//Fill  tfbsAndCellLineAndAllBasedKeggPathway2KMap using tfandAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfCellLineAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (tfCellLineAllBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)==null){
						tfCellLineAllBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfCellLineAllBasedKeggPathway2KMap.put(tfNameCellLineNameKeggPathwayName, tfCellLineAllBasedKeggPathway2KMap.get(tfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF EXONBASED_KEGGPATHWAY
				//Fill tfExonBasedKeggPathway2KMap using tfExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfExonBasedKeggPathway2OneorZeroMap.entrySet()){
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfExonBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfExonBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfExonBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfExonBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new		
				}//End of for inner loop 
				
				//TF REGULATIONBASED_KEGGPATHWAY
				//Fill tfRegulationBasedKeggPathway2KMap using tfRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfRegulationBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfRegulationBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfRegulationBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfRegulationBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new	
				}//End of for inner loop 
				
				
				//TF ALLBASED_KEGGPATHWAY
				//Fill  tfAllBasedKeggPathway2KMap using tfAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: tfAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					tfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					//new
					if (tfAllBasedKeggPathway2KMap.get(tfNameKeggPathwayName)==null){
						tfAllBasedKeggPathway2KMap.put(tfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						tfAllBasedKeggPathway2KMap.put(tfNameKeggPathwayName, tfAllBasedKeggPathway2KMap.get(tfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					//new
					
				}//End of for inner loop 
				
				//added here ends
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	//New Functionality
	
	//@todo
	//with Numbers starts
	//Empirical P Value Calculation
	//with IO
	public static void searchHistoneWithNumbers(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, TLongObjectMap<BufferedWriter> histoneBufferedWriterHashMap, TLongIntMap permutationNumberHistoneNumberCellLineNumber2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		
		
			for(int i=0; i<inputLines.size(); i++){
				
				TLongIntMap permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap = new TLongIntHashMap();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervalsWithNumbers(outputFolder,permutationNumber,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(TLongIntIterator it = permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
					
					it.advance();
					 
					if (!(permutationNumberHistoneNumberCellLineNumber2KMap.containsKey(it.key()))){
						permutationNumberHistoneNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						permutationNumberHistoneNumberCellLineNumber2KMap.put(it.key(), permutationNumberHistoneNumberCellLineNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
				
			}//End of for
		
	}	
	//with Numbers ends
	//@todo
	
	//Empirical P Value Calculation
	//with IO
	public static void searchHistone(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, Map<String,BufferedWriter> histoneBufferedWriterHashMap, Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		
		
			for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberHistoneNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(outputFolder,permutationNumber,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberHistoneNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}//End of for
		
	}

	
	//@todo
	//Empirical P Value Calculation
	//without IO
	public static void searchHistonewithoutIOwithNumbers(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, TLongIntMap permutationNumberHistoneNumberCellLineNumber2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		

			for(int i=0; i<inputLines.size(); i++){
				
				TLongIntMap permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap = new TLongIntHashMap();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervalsWithNumbers(permutationNumber,histoneIntervalTree.getRoot(),interval,chromName,permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(TLongIntIterator it = permutationNumberHistoneNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext();){
					
					it.advance();
					 
					if (!(permutationNumberHistoneNumberCellLineNumber2KMap.containsKey(it.key()))){
						permutationNumberHistoneNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						permutationNumberHistoneNumberCellLineNumber2KMap.put(it.key(), permutationNumberHistoneNumberCellLineNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
				
			}//End of for
		
	}	
	//@todo
	
	//Empirical P Value Calculation
	//without IO
	public static void searchHistonewithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree histoneIntervalTree, Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap,int overlapDefinition){
		InputLine inputLine;	
		int low;
		int high;
		
//			//Keeps the overlapping node list for the current query
//			List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the latest non empty overlapping node list for the previous queries
//			List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the left most node 
//			IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//			
//			IntervalTreeNode newSearchStartingNode= histoneIntervalTree.getRoot();
			

			for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberHistoneNameCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				
				Interval interval = new Interval(low,high);
				
//					//Empty the overlapping node list for the new query
//					overlappingNodeList.clear();	
//					
//					if (previousLeftMostNode.isNotSentinel()){
//					
//						//Go up in the interval tree for the new query
//						newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//						
//						//Go down in the interval tree for the new query 
//						newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//					}
//					
//					
//					//If sentinel means that there is no need to search for this new query
//					if(newSearchStartingNode.isNotSentinel()){
//						histoneIntervalTree.findAllOverlappingHistoneIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlappingNodeList);					
//					}			
//					
//					if(!overlappingNodeList.isEmpty()){
//						previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//						previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//					}
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(permutationNumber,histoneIntervalTree.getRoot(),interval,chromName,permutationNumberHistoneNameCellLineName2ZeroorOneMap,overlapDefinition);					
				}
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberHistoneNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberHistoneNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberHistoneNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}//End of for
		
	}
	
	//@todo searchTranscriptionFactorWithNumbers starts
	public void searchTranscriptionFactorWithNumbers(String outputFolder,ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree tfIntervalTree, TIntObjectMap<BufferedWriter> tfBufferedWriterHashMap, TIntIntMap tfNumberCellLineNumber2KMap,int overlapDefinition,TShortObjectMap<String> tfNumber2TFNameMap,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				TIntShortMap tfNumberCellLineNumber2ZeroorOneMap = new TIntShortHashMap();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,tfIntervalTree.getRoot(),interval,chromName, tfBufferedWriterHashMap,tfNumberCellLineNumber2ZeroorOneMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);						
				}
				
				//too many opened files error starts
				if(!tfBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(tfBufferedWriterHashMap);
					tfBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
								
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(TIntShortIterator it =  tfNumberCellLineNumber2ZeroorOneMap.iterator();it.hasNext();){
					 it.advance();
					 
					if (!tfNumberCellLineNumber2KMap.containsKey(it.key())){
						tfNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						tfNumberCellLineNumber2KMap.put(it.key(), tfNumberCellLineNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	//@todo searchTranscriptionFactorWithNumbers ends
	
	//@todo searchHistoneWithNumbers starts
	public void searchHistoneWithNumbers(String outputFolder,ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree histoneIntervalTree, TIntObjectMap<BufferedWriter> histoneBufferedWriterHashMap, TIntIntMap histoneNumberCellLineNumber2KMap,int overlapDefinition,TShortObjectMap<String> histoneNumber2HistoneNameMap,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				TIntShortMap histoneNumberCellLineNumber2ZeroorOneMap = new TIntShortHashMap();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//				indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervalsWithNumbers(outputFolder,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,histoneNumberCellLineNumber2ZeroorOneMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);						
				}
				
				//too many opened files error starts
				if(!histoneBufferedWriterHashMap.isEmpty()){
					closeBufferedWritersWithNumbers(histoneBufferedWriterHashMap);
					histoneBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
								
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(TIntShortIterator it =  histoneNumberCellLineNumber2ZeroorOneMap.iterator();it.hasNext();){
					 it.advance();
					 
					if (!histoneNumberCellLineNumber2KMap.containsKey(it.key())){
						histoneNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						histoneNumberCellLineNumber2KMap.put(it.key(), histoneNumberCellLineNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	//@todo searchHistoneWithNumbers ends
	
	public void searchHistone(String outputFolder,ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree histoneIntervalTree, Map<String,BufferedWriter> histoneBufferedWriterHashMap, List<String> histoneNameList, Map<String,Integer> histoneNameandCellLineName2KMap,int overlapDefinition){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> histoneNameandCellLineName2ZeroorOneMap = new HashMap<String,Integer>();
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
				
				if(histoneIntervalTree.getRoot().getNodeName().isNotSentinel()){
					histoneIntervalTree.findAllOverlappingHistoneIntervals(outputFolder,histoneIntervalTree.getRoot(),interval,chromName, histoneBufferedWriterHashMap,histoneNameList,histoneNameandCellLineName2ZeroorOneMap,overlapDefinition);						
				}
				
				//too many opened files error starts
				if(!histoneBufferedWriterHashMap.isEmpty()){
					closeBufferedWriters(histoneBufferedWriterHashMap);
					histoneBufferedWriterHashMap.clear();
				}
				//too many opened files error ends
								
				//accumulate search results of dnaseCellLine2OneorZeroMap in dnaseCellLine2KMap
				for(Map.Entry<String, Integer> zeroOrOne: histoneNameandCellLineName2ZeroorOneMap.entrySet()){
					 
					if (histoneNameandCellLineName2KMap.get(zeroOrOne.getKey())==null){
						histoneNameandCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						histoneNameandCellLineName2KMap.put(zeroOrOne.getKey(), histoneNameandCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 
	}
	
	//@todo
	//with Numbers
	//Empirical P Value Calculation
	//Search keggPathway
	//with IO
	public static void searchUcscRefSeqGenesWithNumbers(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, TIntObjectMap<BufferedWriter> bufferedWriterHashMap, TIntObjectMap<TShortList> geneId2KeggPathwayNumberMap, TIntIntMap permutationNumberKeggPathwayNumber2KMap, String type,KeggPathwayAnalysisType keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i=0; i<inputLines.size(); i++){
				
				TIntIntMap permutationNumberKeggPathwayNumber2OneorZeroMap = new TIntIntHashMap();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap, geneId2KeggPathwayNumberMap, permutationNumberKeggPathwayNumber2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);
				}
								
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(TIntIntIterator it = permutationNumberKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext(); ){
					it.advance();
					 
					if (!(permutationNumberKeggPathwayNumber2KMap.containsKey(it.key()))){
						permutationNumberKeggPathwayNumber2KMap.put(it.key(), it.value());
					}else{
						permutationNumberKeggPathwayNumber2KMap.put(it.key(), permutationNumberKeggPathwayNumber2KMap.get(it.key())+it.value());					
					}
	
				}//End of for
		}//End of for
		
	}	
	//with Numbers
	//@todo

	
	//Empirical P Value Calculation
	//Search keggPathway
	//with IO
	public static void searchUcscRefSeqGenes(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberKeggPathway2KMap, String type,KeggPathwayAnalysisType keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberKeggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);
				}
								
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberKeggPathway2OneorZeroMap.entrySet()){
					 
					if (permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());					
					}
	
				}//End of for
		}//End of for
		
	}
	
	//@todo
	//Empirical P Value Calculation
	//Search keggPathway
	//without IO
	//with Numbers
	public static  void searchUcscRefSeqGeneswithoutIOwithNumbers(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, TIntObjectMap<TShortList> geneId2KeggPathwayMap, TIntIntMap permutationNumberKeggPathwayNumber2KMap, String type,KeggPathwayAnalysisType keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
		for(int i=0; i<inputLines.size(); i++){
				
				TIntIntMap permutationNumberKeggPathwayNumber2OneorZeroMap = new TIntIntHashMap();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberKeggPathwayNumber2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);					
				}
				
				
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(TIntIntIterator it =permutationNumberKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					
					  it.advance();
					 
					if (!(permutationNumberKeggPathwayNumber2KMap.containsKey(it.key()))){
						permutationNumberKeggPathwayNumber2KMap.put(it.key(), it.value());
					}else{
						permutationNumberKeggPathwayNumber2KMap.put(it.key(), permutationNumberKeggPathwayNumber2KMap.get(it.key())+it.value());
						
					}
	
				}//End of for
		}//End of for
		
	}
	//@todo
	
	//Empirical P Value Calculation
	//Search keggPathway
	//without IO
	public static  void searchUcscRefSeqGeneswithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberKeggPathway2KMap, String type,KeggPathwayAnalysisType keggPathwayAnalysisType,int overlapDefinition){
		
		InputLine inputLine;
		int low;
		int high;
		
//			//Keeps the overlapping node list for the current query
//			List<IntervalTreeNode> overlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the latest non empty overlapping node list for the previous queries
//			List<IntervalTreeNode> previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>();
//			//Keeps the left most node 
//			IntervalTreeNode previousLeftMostNode = new IntervalTreeNode();
//			
//				
//			IntervalTreeNode newSearchStartingNode= ucscRefSeqGenesIntervalTree.getRoot();

		for(int i=0; i<inputLines.size(); i++){
				
				Map<String,Integer> permutationNumberKeggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				inputLine = inputLines.get(i);
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
//					//Empty the overlapping node list for the new query
//					overlappingNodeList.clear();	
//					
//					if (previousLeftMostNode.isNotSentinel()){
//					
//						//Go up in the interval tree for the new query
//						newSearchStartingNode = IntervalTree.findMostGeneralSearchStaringNodeforNewQuery(interval,previousLeftMostNode);
//						
//						//Go down in the interval tree for the new query 
//						newSearchStartingNode = IntervalTree.findMostSpecificSearchStaringNodeforNewQuery(interval,newSearchStartingNode);	
//					}
//					
//					
//					
//					//If sentinel means that there is no need to search for this new query
//					if(newSearchStartingNode.isNotSentinel()){
//						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,newSearchStartingNode,interval,chromName, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlappingNodeList);					
//					}			
//					
//					if(!overlappingNodeList.isEmpty()){
//						previousNonEmptyOverlappingNodeList = new ArrayList<IntervalTreeNode>(overlappingNodeList);
//						previousLeftMostNode = IntervalTree.findLeftMostNodefromPreviousQuery(previousNonEmptyOverlappingNodeList);			
//					}

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberKeggPathway2OneorZeroMap,type,keggPathwayAnalysisType,overlapDefinition);					
				}
				
				
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberKeggPathway2OneorZeroMap.entrySet()){
					 
					if (permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
		}//End of for
		
	}
	
	//@todo
	//with Numbers
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment starts
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF CellLine Exon Based Kegg Pathway
	//TF CellLine Regulation Based Kegg Pathway
	//TF CellLine All Based Kegg Pathway
	//TF Exon Based Kegg Pathway
	//TF Regulation Based Kegg Pathway
	//TF All Based Kegg Pathway
	//with IO
	public static  void searchTfandKeggPathwayWithNumbers(
			String outputFolder,
			int permutationNumber, 
			ChromosomeName chromName, 
			List<InputLine> inputLines, 
			IntervalTree tfIntervalTree, 
			IntervalTree ucscRefSeqGenesIntervalTree, 
			TLongObjectMap<BufferedWriter> tfBufferedWriterHashMap, 
			TIntObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap, 
			TIntObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap, 
			TIntObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap, 
			TLongObjectMap<BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap,
			TLongObjectMap<BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap,
			TLongObjectMap<BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,
			TLongObjectMap<BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap, 
			TLongObjectMap<BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, 
			TLongObjectMap<BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,
			TIntObjectMap<TShortList> geneId2KeggPathwayNumberMap, 
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap, 
			TIntIntMap permutationNumberExonBasedKeggPathway2KMap, 
			TIntIntMap permutationNumberRegulationBasedKeggPathway2KMap, 
			TIntIntMap permutationNumberAllBasedKeggPathway2KMap, 
			TLongIntMap permutationNumberTfNumberExonBasedKeggPathway2KMap,
			TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathway2KMap,
			TLongIntMap permutationNumberTfNumberAllBasedKeggPathway2KMap,
			TLongIntMap permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap,
			TLongIntMap permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap,
			TLongIntMap permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap, 
			String type,
			EnrichmentType tfandKeggPathwayEnrichmentType,
			int overlapDefinition){
		int low;
		int high;
		
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;
		
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter2 = null;
		
		long permutationNumberTfNumberCellLineNumberKeggPathwayNumber;
		long permutationNumberTfNumberCellLineNumber;
		long permutationNumberTfNumber;
		long permutationNumberTfNumberKeggPathwayNumber;	
		
		short keggPathwayNumber;
		

		try{	
			for(InputLine inputLine: inputLines){
				
				//TF Enrichment
				TLongIntMap permutationNumberTfNumberCellLineNumber2ZeroorOneMap 			= new TLongIntHashMap();	
				
				//KEGGPATHWAY Enrichment
				TIntIntMap permutationNumberExonBasedKeggPathway2ZeroorOneMap 				= new TIntIntHashMap();	
				TIntIntMap permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 		= new TIntIntHashMap();	
				TIntIntMap permutationNumberAllBasedKeggPathway2ZeroorOneMap 				= new TIntIntHashMap();				
				
				//TF KEGGPATHWAY Enrichment and
				TLongIntMap permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap 			= new TLongIntHashMap();	
				TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new TLongIntHashMap();	
				TLongIntMap permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap 			= new TLongIntHashMap();	
				
				//TF CellLine KEGGPATHWAY Enrichment and
				TLongIntMap permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap 			= new TLongIntHashMap();	
				TLongIntMap permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap 		= new TLongIntHashMap();	
				TLongIntMap permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap 			= new TLongIntHashMap();	
					
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<PermutationNumberTfNumberCellLineNumberOverlap> 	permutationNumberTfNumberCellLineNumberOverlapList 		= new ArrayList<PermutationNumberTfNumberCellLineNumberOverlap>();
				List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList 		= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
				List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList 	= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
				List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList 		= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
		
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(outputFolder,permutationNumber,tfIntervalTree.getRoot(),interval,chromName,tfBufferedWriterHashMap,permutationNumberTfNumberCellLineNumber2ZeroorOneMap,permutationNumberTfNumberCellLineNumberOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of permutationNumberTfbsNameCellLineName2ZeroorOneMap in permutationNumberTfbsNameCellLineName2KMap
				for(TLongIntIterator it = permutationNumberTfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
					it.advance();
					 
					if (!(permutationNumberTfNumberCellLineNumber2KMap.containsKey(it.key()))){
						permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), it.value());
					}else{
						permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), permutationNumberTfNumberCellLineNumber2KMap.get(it.key())+it.value());
					}
				}//End of for
				
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayNumberMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
				}
				
				//accumulate search results of permutationNumberExonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
				for(TIntIntIterator it =  permutationNumberExonBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext(); ){
					it.advance();
					 
					if (!(permutationNumberExonBasedKeggPathway2KMap.containsKey(it.key()))){
						permutationNumberExonBasedKeggPathway2KMap.put(it.key(), it.value());
					}else{
						permutationNumberExonBasedKeggPathway2KMap.put(it.key(), permutationNumberExonBasedKeggPathway2KMap.get(it.key())+it.value());
						
					}
				}//End of for
			
				//accumulate search results of permutationNumberRegulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
				for(TIntIntIterator it = permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext(); ){
					 it.advance();
					
					if (!(permutationNumberRegulationBasedKeggPathway2KMap.containsKey(it.key()))){
						permutationNumberRegulationBasedKeggPathway2KMap.put(it.key(), it.value());
					}else{
						permutationNumberRegulationBasedKeggPathway2KMap.put(it.key(), permutationNumberRegulationBasedKeggPathway2KMap.get(it.key())+it.value());
						
					}
				}//End of for
				
				//accumulate search results of permutationNumberAllBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
				for(TIntIntIterator it = permutationNumberAllBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext(); ){
					 it.advance();
					 
					if (!(permutationNumberAllBasedKeggPathway2KMap.containsKey(it.key()))){
						permutationNumberAllBasedKeggPathway2KMap.put(it.key(), it.value());
					}else{
						permutationNumberAllBasedKeggPathway2KMap.put(it.key(), permutationNumberAllBasedKeggPathway2KMap.get(it.key())+it.value());
						
					}
				}//End of for
				
				
				
				//New search for given input SNP or interval case, does not matter.
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//question will overlapDefinition apply here?
				//then write common overlap to output files 
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				
				//permutation number is same for tf and keggPathway  maps
				//for example: permutationNumberTfbsNameCellLineName2ZeroorOneMap
				//for example: permutationNumberExonBasedKeggPathway2ZeroorOneMap
				//input lines are randomly generated data for this permutation number 
				//all the entries in these maps have 1 values.
				//if there is an entry, it means that it is 1.
				
				for(PermutationNumberTfNumberCellLineNumberOverlap permutationNumberTfNumberCellLineNumberOverlap: permutationNumberTfNumberCellLineNumberOverlapList){
					
					permutationNumberTfNumberCellLineNumber = permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber();
					permutationNumberTfNumber = IntervalTree.removeCellLineNumber(permutationNumberTfNumberCellLineNumber);
					
					//TF and Exon Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
							
							
							for(TShortIterator it= permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext(); ){ 
								
								   keggPathwayNumber = it.next();
										
								   if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										/******************************************************/
										permutationNumberTfNumberKeggPathwayNumber =IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
												
										

										if (!(permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/******************************************************/
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t"+ permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t"  + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
								   }else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
									   /******************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
									
										if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
										
								   } else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
									   
									   //TF EXONKEGG
									   /******************************************************/
										permutationNumberTfNumberKeggPathwayNumber =IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
												
										

										if (!(permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/******************************************************/
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t"+ permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t"  + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
										//TF CELLLINE EXONKEGG
										/******************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
									
										if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
									
									   
								   }
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
										
					
					//TF and Regulation Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
							for(TShortIterator it = permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
								
									keggPathwayNumber = it.next();
										
									if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										
										/************************************************/
										permutationNumberTfNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
												
											
										if (!(permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/************************************************/										
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber + System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										
									}else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
										/************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
																				
										if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){											
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo symbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t"+ permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/

									}else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
										
										//TF RegulationKEGG
										/************************************************/
										permutationNumberTfNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
												
											
										if (!(permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/************************************************/										
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber + System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
								
										//TF CellLine RegulationKEGG
										/************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
																				
										if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){											
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo symbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
									
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t"+ permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/

									}
																			

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					
					
					
					//TF and All Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
							for(TShortIterator it =permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext(); ){ 
									
									keggPathwayNumber = it.next();
								
									if (tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										
										/************************************************/
										permutationNumberTfNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
										
										if (!(permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t"  + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/

									}else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
										/************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
										
										if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){	
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo symbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
																		
									}else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
										
										//TF ALLKEGG
										/************************************************/
										permutationNumberTfNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumber, keggPathwayNumber);
										
										if (!(permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
											permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberKeggPathwayNumber);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberKeggPathwayNumber,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo suymbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t"  + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/

										
										//TF CELLLINE ALLKEGG
										/************************************************/
										permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
										
										if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
											permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber);
										
										if (bufferedWriter1==null){	
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION + permutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNumberCellLineNumberKeggPathwayNumber + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name number" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name" + "\t" + "interval number" + "\t" + "hugo symbol number" + "\t" + "entrez id"+ "\t" + "keggPathwayNumber" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber()+ "\t"  + permutationNumberTfNumberCellLineNumberOverlap.getLow() + "\t" + permutationNumberTfNumberCellLineNumberOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getRefSeqGeneNumber()+ "\t" +permutationNumberUcscRefSeqGeneNumberOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getIntervalNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneHugoSymbolNumber() + "\t" + permutationNumberUcscRefSeqGeneNumberOverlap.getGeneEntrezId()+ "\t" + keggPathwayNumber + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/

									}
											
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
	
				}//for each tfOverlap for the given query
				
				
				if (tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
					
					//TF EXON BASED
					//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
					
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberExonBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberExonBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					//TF REGULATION BASED
					//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberRegulationBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberRegulationBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF ALL BASED
					//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberAllBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberAllBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
				} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
					//TF CELLLINE EXON BASED
					//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					//TF CELLLINE REGULATION BASED
					//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE ALL BASED
					//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
				} else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
					
					//TF KEGG
					//TF EXONBASED
					//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberExonBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
					
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberExonBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberExonBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					//TF REGULATIONBASED
					//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberRegulationBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberRegulationBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberRegulationBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF ALLBASED
					//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
					for(TLongIntIterator it =  permutationNumberTfNumberAllBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberAllBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
							permutationNumberTfNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberAllBasedKeggPathway2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE KEGG
					//TF CELLLINE EXONBASED
					//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberExonBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					//TF CELLLINE REGULATIONBASED
					//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE ALLBASED
					//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
					for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2ZeroorOneMap.iterator(); it.hasNext();){
						it.advance();
						
						permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
						
						if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
							permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
						}else{
							permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberAllBasedKeggPathway2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
						}
						
					}//End of for inner loop 

				}
				
				
				
				
				
			}//End of for each input line
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 

		
	}
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment ends
	//with Numbers
	//@todo
	
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment starts
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF CellLine Exon Based Kegg Pathway
	//TF CellLine Regulation Based Kegg Pathway
	//TF CellLine All Based Kegg Pathway
	//TF Exon Based Kegg Pathway
	//TF Regulation Based Kegg Pathway
	//TF All Based Kegg Pathway
	//with IO
	public static  void searchTfandKeggPathway(String outputFolder,int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap, String type,EnrichmentType tfandKeggPathwayEnrichmentType,int overlapDefinition){
		int low;
		int high;
		
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter2 = null;

		
		int repeatNumberReflectedPermutationNumber = permutationNumber;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;	
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		

		try{	
			for(InputLine inputLine: inputLines){
				
				Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();				
				
				//will be used 	for tf and keggPathway enrichment and
				Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				//will be used	for tf and cellLine and keggPathway enrichment
				Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
	
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
		
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of permutationNumberTfbsNameCellLineName2ZeroorOneMap in permutationNumberTfbsNameCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
				}//End of for
				
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
				}
				
				//accumulate search results of permutationNumberExonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
			
				//accumulate search results of permutationNumberRegulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				//accumulate search results of permutationNumberAllBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				
				
				//New search for given input SNP or interval case, does not matter.
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//question will overlapDefinition apply here?
				//then write common overlap to output files 
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				
				//permutation number is same for tf and keggPathway  maps
				//for example: permutationNumberTfbsNameCellLineName2ZeroorOneMap
				//for example: permutationNumberExonBasedKeggPathway2ZeroorOneMap
				//input lines are randomly generated data for this permutation number 
				//all the entries in these maps have 1 values.
				//if there is an entry, it means that it is 1.
				
				for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
					
					permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
					indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
					indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
					permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
					
					//TF and Exon Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
								   if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										/******************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;

										if (permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/******************************************************/
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t"+ permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t"  + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
								   }else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
									   /******************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
										
								   }
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and Regulation Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
									if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/										
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										
									}else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){											
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/

									}
										
										
										

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and All Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
								
									if (tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
										
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/

									}else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
										
										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
											
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Searched for chr" + "\t" +"given interval low"+ "\t" + "given interval high" +"\t" + "tfbs" + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" +"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));
											
										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" +permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
																		
									}
											
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
	
				}//for each tfOverlap for the given query
				
				
				if (tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
					
					//TF EXON BASED
					//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					//TF REGULATION BASED
					//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					
					//TF ALL BASED
					//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
							permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
				} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
					//TF CELLLINE EXON BASED
					//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					//TF CELLLINE REGULATION BASED
					//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
					
					//TF CELLLINE ALL BASED
					//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
					for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
						
						permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
						
						if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
							permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
						}else{
							permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
						}
						
					}//End of for inner loop 
					
				}
				
				
				
				
				
			}//End of for each input line
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 

		
	}
	//TF and KeggPathway Enrichment or
	//TF and CellLine and KeggPathway Enrichment ends
	
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF CellLine Exon Based Kegg Pathway
	//TF CellLine Regulation Based Kegg Pathway
	//TF CellLine All Based Kegg Pathway
	//TF Exon Based Kegg Pathway
	//TF Regulation Based Kegg Pathway
	//TF All Based Kegg Pathway
	//with IO
	public static  void searchTfandKeggPathway(String outputFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> tfbsBufferedWriterHashMap, Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap, Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap,Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap, String type,int overlapDefinition){
		int low;
		int high;
		
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;
		FileWriter fileWriter2 = null;
		BufferedWriter bufferedWriter2 = null;

		
		int repeatNumberReflectedPermutationNumber = ((repeatNumber-1)*NUMBER_OF_PERMUTATIONS) + permutationNumber;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;	
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		

		try{	
			for(InputLine inputLine: inputLines){
				
				Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();				
				
				Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap 		= new HashMap<String,Integer>();	
				
				low = inputLine.getLow();
				high = inputLine.getHigh();
				Interval interval = new Interval(low,high);
				
				//Fill these lists during search for tfs and search for ucscRefSeqGenes
				List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
				List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
		
				if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
					tfIntervalTree.findAllOverlappingTfbsIntervals(outputFolder,permutationNumber,tfIntervalTree.getRoot(),interval,chromName,tfbsBufferedWriterHashMap,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);	
				}
				
				//accumulate search results of permutationNumberTfbsNameCellLineName2ZeroorOneMap in permutationNumberTfbsNameCellLineName2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
					}
				}//End of for
				
				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
						ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(outputFolder,permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
				}
				
				//accumulate search results of permutationNumberExonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
			
				//accumulate search results of permutationNumberRegulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				//accumulate search results of permutationNumberAllBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					 
					if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
				}//End of for
				
				
				
				//New search for SNP or interval case, does not matter.
				//for each tf overlap
				//for each ucscRefSeqGene overlap
				//if these overlaps overlaps
				//then write common overlap to output files 
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				
				//permutation number is same for tf and keggPathway  maps
				//for example: permutationNumberTfbsNameCellLineName2ZeroorOneMap
				//for example: permutationNumberExonBasedKeggPathway2ZeroorOneMap
				//input lines are randomly generated data for this permutation number 
				//all the entries in these maps have 1 values.
				//if there is an entry, it means that it is 1.
				
				for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
					
					permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
					indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
					indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
					permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
					
					//TF and Exon Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/******************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										
										/******************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;

										if (permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/******************************************************/
										
										/******************************************************/
										bufferedWriter1 = tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																					
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
										
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/******************************************************/
										
										/******************************************************/
										bufferedWriter2 = tfExonBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){												
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_EXON_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfExonBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
										
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/******************************************************/
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and Regulation Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/

										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/

										
										/************************************************/
										bufferedWriter1 = tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
										
										/************************************************/
										bufferedWriter2 = tfRegulationBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
																						
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_REGULATION_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfRegulationBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										

							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
					
					
					//TF and All Based Kegg Pathway
					for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
						if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
							for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
										
										/************************************************/
										permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
											permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
										}
										/************************************************/
									
										/************************************************/
										permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
										
										if (permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.get(permutationNumberTfNameKeggPathwayName)==null){
											permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.put(permutationNumberTfNameKeggPathwayName, 1);
										}
										/************************************************/

										/************************************************/
										bufferedWriter1 = tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameCellLineNameKeggPathwayName);
										
										if (bufferedWriter1==null){	
																						
											fileWriter1 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameCellLineNameKeggPathwayName + ".txt",true);
											bufferedWriter1 = new BufferedWriter(fileWriter1);
											tfCellLineAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameCellLineNameKeggPathwayName,bufferedWriter1);
											bufferedWriter1.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
	
										bufferedWriter1.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter1.flush();
										/************************************************/
										
										
										/************************************************/
										bufferedWriter2 = tfAllBasedKeggPathwayBufferedWriterHashMap.get(permutationNumberTfNameKeggPathwayName);
										
										if (bufferedWriter2==null){	
											
											fileWriter2 = FileOperations.createFileWriter(outputFolder + Commons.ANNOTATE_PERMUTATIONS_TF_ALL_BASED_KEGG_PATHWAY_ANALYSIS + Commons.PERMUTATION +repeatNumberReflectedPermutationNumber+ System.getProperty("file.separator") +"_" + permutationNumberTfNameKeggPathwayName + ".txt",true);
											bufferedWriter2 = new BufferedWriter(fileWriter2);
											tfAllBasedKeggPathwayBufferedWriterHashMap.put(permutationNumberTfNameKeggPathwayName,bufferedWriter2);
											bufferedWriter2.write("Search for chr" + "\t" + "given interval low" + "\t" + "given interval high" +"\t" + "tfbs"  + "\t"  + "tfbs low" + "\t" + "tfbs high"  + "\t" + 	"refseq gene name" + "\t"  + "ucscRefSeqGene low" + "\t" + "ucscRefSeqGene high"  + "\t" + "interval name " + "\t" + "hugo suymbol" + "\t" + "entrez id"+ "\t" + "keggPathwayName" + System.getProperty("line.separator"));

										}
	
	
										bufferedWriter2.write(chromName + "\t" + interval.getLow() + "\t" + interval.getHigh() + "\t" + permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName()+ "\t"  + permutationNumberTfNameCellLineNameOverlap.getLow() + "\t" + permutationNumberTfNameCellLineNameOverlap.getHigh()   + "\t" +  permutationNumberUcscRefSeqGeneOverlap.getRefSeqGeneName()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getLow()+ "\t" + permutationNumberUcscRefSeqGeneOverlap.getHigh()  + "\t" + permutationNumberUcscRefSeqGeneOverlap.getIntervalName() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneHugoSymbol() + "\t" + permutationNumberUcscRefSeqGeneOverlap.getGeneEntrezId()+ "\t" + keggPathwayName + System.getProperty("line.separator"));
										bufferedWriter2.flush();
										/************************************************/
										
							} //for each kegg pathways having this gene
						}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
					}//for each ucscRefSeqGeneOverlap for the given query
	
				}//for each tfOverlap for the given query
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF EXON BASED
				//Fill permutationNumberTfNameExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfNameAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2ZeroorOneMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
			}//End of for each input line
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // End of while 

		
	}
	
	
	//@todo
	//with numbers starts
	//There is a parameter called tfandKeggPathwayEnrichmentType	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	//New Functionality START
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF and Exon Based Kegg Pathway
	//TF and Regulation Based Kegg Pathway
	//TF and All Based Kegg Pathway
	//without IO
	public static  void searchTfandKeggPathwaywithoutIOwithNumbers(
			int permutationNumber, 
			ChromosomeName chromName, 
			List<InputLine> inputLines, 
			IntervalTree tfIntervalTree, 
			IntervalTree ucscRefSeqGenesIntervalTree, 
			TIntObjectMap<TShortList> geneId2KeggPathwayNumberMap, 
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap, 
			TIntIntMap permutationNumberExonBasedKeggPathwayNumber2KMap, 
			TIntIntMap permutationNumberRegulationBasedKeggPathwayNumber2KMap, 
			TIntIntMap permutationNumberAllBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap, 
			TLongIntMap permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,
			String type,
			EnrichmentType tfandKeggPathwayEnrichmentType,
			int overlapDefinition){
		
		int low;
		int high;
		
		long permutationNumberTfNumberCellLineNumber;
		long permutationNumberTfNumberKeggPathwayNumber;
		long permutationNumberTfNumberCellLineNumberKeggPathwayNumber;
		
		short keggPathwayNumber;
						
		for(InputLine inputLine: inputLines){
			
			//Will be filled in tfIntervalTree search
			TLongIntMap permutationNumberTfNumberCellLineNumber2ZeroorOneMap 			= new TLongIntHashMap();
			
			//Will be filled in ucscRefSeqGene search
			TIntIntMap permutationNumberExonBasedKeggPathwayNumber2ZeroorOneMap 		= new TIntIntHashMap();	
			TIntIntMap permutationNumberRegulationBasedKeggPathwayNumber2ZeroorOneMap 	= new TIntIntHashMap();	
			TIntIntMap permutationNumberAllBasedKeggPathwayNumber2ZeroorOneMap 			= new TIntIntHashMap();	
			
			//Will be filled in common overlap check
			//Will be used for tf and kegg pathway enrichment 
			TLongIntMap permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap 			= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap 		= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap 			= new TLongIntHashMap();
		
			//Will be filled in common overlap check
			//Will be used for tf and cell line and kegg pathway enrichment 
			TLongIntMap permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap 			= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap 	= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap 			= new TLongIntHashMap();
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			//Fill these lists during search for tfs and search for ucscRefSeqGenes
			List<PermutationNumberTfNumberCellLineNumberOverlap> 	permutationNumberTfNumberCellLineNumberOverlapList 				= new ArrayList<PermutationNumberTfNumberCellLineNumberOverlap>();
			List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberExonBasedKeggPathwayNumberOverlapList 			= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
			List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberRegulationBasedKeggPathwayNumberOverlapList	= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
			List<PermutationNumberUcscRefSeqGeneNumberOverlap> 		permutationNumberAllBasedKeggPathwayNumberOverlapList 			= new ArrayList<PermutationNumberUcscRefSeqGeneNumberOverlap>();
			
			//First TF
			//Fill permutationNumberTfNumberCellLineNumber2ZeroorOneMap
			if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfIntervalTree.findAllOverlappingTfbsIntervalsWithNumbers(permutationNumber,tfIntervalTree.getRoot(),interval,chromName,permutationNumberTfNumberCellLineNumber2ZeroorOneMap,permutationNumberTfNumberCellLineNumberOverlapList,overlapDefinition);
			}
			
			//accumulate search results of permutationNumberTfNumberCellLineNumber2ZeroorOneMap in permutationNumberTfNameaCellLineName2KMap
			for(TLongIntIterator it  = permutationNumberTfNumberCellLineNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
				 it.advance();
				 
				if (!(permutationNumberTfNumberCellLineNumber2KMap.containsKey(it.key()))){
					permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberTfNumberCellLineNumber2KMap.put(it.key(), permutationNumberTfNumberCellLineNumber2KMap.get(it.key())+it.value());	
				}
			}//End of for
			
			//Second UcscRefSeqGenes
			//Fill permutationNumberExonBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberRegulationBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberAllBasedKeggPathway2ZeroorOneMap
			if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervalsWithNumbers(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayNumberMap, permutationNumberExonBasedKeggPathwayNumber2ZeroorOneMap,permutationNumberRegulationBasedKeggPathwayNumber2ZeroorOneMap,permutationNumberAllBasedKeggPathwayNumber2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayNumberOverlapList,permutationNumberRegulationBasedKeggPathwayNumberOverlapList,permutationNumberAllBasedKeggPathwayNumberOverlapList,overlapDefinition);					
			}
			
			//accumulate search results of exonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
			for(TIntIntIterator it = permutationNumberExonBasedKeggPathwayNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
				 it.advance();
				 
				if (!(permutationNumberExonBasedKeggPathwayNumber2KMap.containsKey(it.key()))){
					permutationNumberExonBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberExonBasedKeggPathwayNumber2KMap.put(it.key(), permutationNumberExonBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
				}
			}//End of for
			
			//accumulate search results of regulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
			for(TIntIntIterator it = permutationNumberRegulationBasedKeggPathwayNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
				 it.advance();
				 
				if (!(permutationNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(it.key()))){
					permutationNumberRegulationBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberRegulationBasedKeggPathwayNumber2KMap.put(it.key(), permutationNumberRegulationBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
				}
			}//End of for
			
			//accumulate search results of allBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
			for(TIntIntIterator it = permutationNumberAllBasedKeggPathwayNumber2ZeroorOneMap.iterator(); it.hasNext(); ){
				 it.advance();
				 
				if (!(permutationNumberAllBasedKeggPathwayNumber2KMap.containsKey(it.key()))){
					permutationNumberAllBasedKeggPathwayNumber2KMap.put(it.key(), it.value());
				}else{
					permutationNumberAllBasedKeggPathwayNumber2KMap.put(it.key(), permutationNumberAllBasedKeggPathwayNumber2KMap.get(it.key())+it.value());
				}
			}//End of for
					
			
			//New search for given input SNP or interval case, does not matter.
			//for each tf overlap
			//for each ucscRefSeqGene overlap
			//if these overlaps overlaps
			//then write common overlap to output files 
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			//question will overlapDefition apply to here?
			for(PermutationNumberTfNumberCellLineNumberOverlap permutationNumberTfNumberCellLineNumberOverlap: permutationNumberTfNumberCellLineNumberOverlapList){
				
				permutationNumberTfNumberCellLineNumber = permutationNumberTfNumberCellLineNumberOverlap.getPermutationNumberTfNumberCellLineNumber();
				
				//TF and EXON Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberExonBasedKeggPathwayNumberOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
						for(TShortIterator it=permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
							
							keggPathwayNumber = it.next();
							
							//TF EXONKEGG
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber,keggPathwayNumber);
								
								if (!(permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/						
							}
							//TF CELLLINE EXONKEGG
							else if(tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
								
								if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/								
							}
							//TF EXONKEGG and TF CELLLINE EXONKEGG
							else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
								
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber =  IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber,keggPathwayNumber);
								
								if (!(permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/
								
								
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
								
								if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/					
							}
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and REGULATION Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberRegulationBasedKeggPathwayNumberOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
						
						for(TShortIterator it = permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext(); ){
							
							keggPathwayNumber = it.next();
									
							//TF REGULATIONKEGG
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber = IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
															
								if (!(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/
								
							} 
							//TF CELLLINE REGULATIONKEGG							
							else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
						
								if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/
							
							}
							//TF REGULATIONKEGG AND TF CELLLINE REGULATIONKEGG
							else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
								
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber = IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
															
								if (!(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/
								
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
						
								if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/
							}
																	
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and ALL Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneNumberOverlap permutationNumberUcscRefSeqGeneNumberOverlap: permutationNumberAllBasedKeggPathwayNumberOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNumberCellLineNumberOverlap.getLow(),permutationNumberTfNumberCellLineNumberOverlap.getHigh(),permutationNumberUcscRefSeqGeneNumberOverlap.getLow(), permutationNumberUcscRefSeqGeneNumberOverlap.getHigh())){
						for(TShortIterator it = permutationNumberUcscRefSeqGeneNumberOverlap.getKeggPathwayNumberList().iterator(); it.hasNext();){ 
								
							
							keggPathwayNumber = it.next();
							
							
							//TF ALLKEGG
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber = IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
								
								if (!(permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/
								
							}
							//TF CELLLINE ALLKEGG
							else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
							
								if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/
								
							}
							//TF ALLKEGG AND TF CELLLINE ALLKEGG
							else if (tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
								
								/***********************************/
								permutationNumberTfNumberKeggPathwayNumber = IntervalTree.removeCellLineNumberAddKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
								
								if (!(permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
									permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberKeggPathwayNumber, 1);
								}
								/***********************************/
						
								/***********************************/
								permutationNumberTfNumberCellLineNumberKeggPathwayNumber = IntervalTree.addKeggPathwayNumber(permutationNumberTfNumberCellLineNumber, keggPathwayNumber);
							
								if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
									permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, 1);
								}
								/***********************************/
							}
								
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
			}//for each tfOverlap for the given query
			
			
			if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
				
				//new code starts 
				//TF EXON BASED
				//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
				
				for(TLongIntIterator it =permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.iterator() ; it.hasNext(); ){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
									
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.iterator() ; it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 

				//new code ends
				
			} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
				
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
									
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
			} else if(tfandKeggPathwayEnrichmentType.isBothTfGeneSetAndTfCellLineGeneSetEnrichment()){
				
				//TF EXON BASED
				//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap				
				for(TLongIntIterator it =permutationNumberTfNumberExonBasedKeggPathwayNumber2OneorZeroMap.iterator() ; it.hasNext(); ){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
									
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberAllBasedKeggPathwayNumber2OneorZeroMap.iterator() ; it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberKeggPathwayNumber))){
						permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberKeggPathwayNumber, permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
				
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
									
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it = permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(TLongIntIterator it =  permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2OneorZeroMap.iterator(); it.hasNext();){
					it.advance();
					
					permutationNumberTfNumberCellLineNumberKeggPathwayNumber = it.key();
					
					if (!(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.containsKey(permutationNumberTfNumberCellLineNumberKeggPathwayNumber))){
						permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, it.value());
					}else{
						permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.put(permutationNumberTfNumberCellLineNumberKeggPathwayNumber, permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap.get(permutationNumberTfNumberCellLineNumberKeggPathwayNumber)+it.value());	
					}
					
				}//End of for inner loop 

			}
				
		}//End of for each input line
				
	}
	//New Functionality END
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends
	//with Numbers End
	//@todo
	
	//There is a parameter called tfandKeggPathwayEnrichmentType	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	//New Functionality START
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF and Exon Based Kegg Pathway
	//TF and Regulation Based Kegg Pathway
	//TF and All Based Kegg Pathway
	//without IO
	public static  void searchTfandKeggPathwaywithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap,String type,EnrichmentType tfandKeggPathwayEnrichmentType,int overlapDefinition){
		
		int low;
		int high;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;		
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
				
		for(InputLine inputLine: inputLines){
			
			//Will be filled in tfIntervalTree search
			Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();
			
			//Will be filled in ucscRefSeqGene search
			Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			
			//Will be filled in common overlap check
			//Will be used for tf and kegg pathway enrichment 
			Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
		
			//Will be filled in common overlap check
			//Will be used for tf and cell line and kegg pathway enrichment 
			Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			//Fill these lists during search for tfs and search for ucscRefSeqGenes
			List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			
			//First TF
			//Fill permutationNumberTfNameCellLineName2ZeroorOneMap
			if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfIntervalTree.getRoot(),interval,chromName,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);
			}
			
			//accumulate search results of permutationNumberTfNameCellLineName2ZeroorOneMap in permutationNumberTfNameaCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());	
				}
			}//End of for
			
			//Second UcscRefSeqGenes
			//Fill permutationNumberExonBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberRegulationBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberAllBasedKeggPathway2ZeroorOneMap
			if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
			}
			
			//accumulate search results of exonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of regulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of allBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
					
			
			//New search for given input SNP or interval case, does not matter.
			//for each tf overlap
			//for each ucscRefSeqGene overlap
			//if these overlaps overlaps
			//then write common overlap to output files 
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			//question will overlapDefition apply to here?
			for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
				
				permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
				indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
				indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
				permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
				
				//TF and Exon Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
							
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
							
							}else if(tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
								
							}
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and Regulation Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
								
							} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
						
								if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
							
							}
								
									
									
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and All Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
							if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
								
								if (permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
									permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
								}
								/***********************************/
								
							} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
								/***********************************/
								permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
							
								if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
									permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
								}
								/***********************************/
								
							}
								
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
			}//for each tfOverlap for the given query
			
			
			if(tfandKeggPathwayEnrichmentType.isTfGeneSetEnrichment()){
				
				//new code starts 
				//TF EXON BASED
				//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
									
				}//End of for inner loop 
				
				//TF REGULATION BASED
				//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF ALL BASED
				//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 

				//new code ends
				
			} else if (tfandKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
				
				//TF CELLLINE EXON BASED
				//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
				
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
									
				}//End of for inner loop 
				
				//TF CELLLINE REGULATION BASED
				//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
				
				//TF CELLLINE ALL BASED
				//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
				for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
					
					permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
					
					if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
					}else{
						permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
					}
					
				}//End of for inner loop 
				
			}
				
		}//End of for each input line
				
	}
	//New Functionality END
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends
		
	
	//There is NO parameter called tfandKeggPathwayEnrichmentType	
	//New Functionality START
	//Empirical P Value Calculation
	//Search tf and keggPathway
	//TF and Exon Based Kegg Pathway
	//TF and Regulation Based Kegg Pathway
	//TF and All Based Kegg Pathway
	//without IO
	public static  void searchTfandKeggPathwaywithoutIO(int permutationNumber, ChromosomeName chromName, List<InputLine> inputLines, IntervalTree tfIntervalTree, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> permutationNumberTfNameCellLineName2KMap, Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap,Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap, Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap,String type,int overlapDefinition){
		
		int low;
		int high;
		
		String permutationNumberTfNameCellLineName;
		String permutationNumberTfName;		
		String permutationNumberTfNameCellLineNameKeggPathwayName;
		String permutationNumberTfNameKeggPathwayName;
		
		int indexofFirstUnderscore;
		int indexofSecondUnderscore;
		
		
		for(InputLine inputLine: inputLines){
			
			//Will be filled in tfIntervalTree search
			Map<String,Integer> permutationNumberTfNameCellLineName2ZeroorOneMap 			= new HashMap<String,Integer>();
			
			//Will be filled in ucscRefSeqGene search
			Map<String,Integer> permutationNumberExonBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2ZeroorOneMap 	= new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberAllBasedKeggPathway2ZeroorOneMap 			= new HashMap<String,Integer>();	
			
			//Will be filled in common overlap check
			Map<String,Integer> permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			//Will be filled in common overlap check
			Map<String,Integer> permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap = new HashMap<String,Integer>();
			
			low = inputLine.getLow();
			high = inputLine.getHigh();
			Interval interval = new Interval(low,high);
			
			//Fill these lists during search for tfs and search for ucscRefSeqGenes
			List<PermutationNumberTfNameCellLineNameOverlap> 	permutationNumberTfNameCellLineNameOverlapList = new ArrayList<PermutationNumberTfNameCellLineNameOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberExonBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberRegulationBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			List<PermutationNumberUcscRefSeqGeneOverlap> 		permutationNumberAllBasedKeggPathwayOverlapList = new ArrayList<PermutationNumberUcscRefSeqGeneOverlap>();
			
			//First TF
			//Fill permutationNumberTfNameCellLineName2ZeroorOneMap
			if(tfIntervalTree.getRoot().getNodeName().isNotSentinel()){
				tfIntervalTree.findAllOverlappingTfbsIntervals(permutationNumber,tfIntervalTree.getRoot(),interval,chromName,permutationNumberTfNameCellLineName2ZeroorOneMap,permutationNumberTfNameCellLineNameOverlapList,overlapDefinition);
			}
			
			//accumulate search results of permutationNumberTfNameCellLineName2ZeroorOneMap in permutationNumberTfNameaCellLineName2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberTfNameCellLineName2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineName2KMap.put(zeroOrOne.getKey(), permutationNumberTfNameCellLineName2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());	
				}
			}//End of for
			
			//Second UcscRefSeqGenes
			//Fill permutationNumberExonBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberRegulationBasedKeggPathway2ZeroorOneMap
			//Fill permutationNumberAllBasedKeggPathway2ZeroorOneMap
			if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(permutationNumber,ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2ZeroorOneMap,permutationNumberRegulationBasedKeggPathway2ZeroorOneMap,permutationNumberAllBasedKeggPathway2ZeroorOneMap,type,permutationNumberExonBasedKeggPathwayOverlapList,permutationNumberRegulationBasedKeggPathwayOverlapList,permutationNumberAllBasedKeggPathwayOverlapList,overlapDefinition);					
			}
			
			//accumulate search results of exonBasedKeggPathway2ZeroorOneMap in permutationNumberExonBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberExonBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberExonBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberExonBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of regulationBasedKeggPathway2ZeroorOneMap in permutationNumberRegulationBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberRegulationBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberRegulationBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberRegulationBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
			
			//accumulate search results of allBasedKeggPathway2ZeroorOneMap in permutationNumberAllBasedKeggPathway2KMap
			for(Map.Entry<String, Integer> zeroOrOne: permutationNumberAllBasedKeggPathway2ZeroorOneMap.entrySet()){
				 
				if (permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())==null){
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
				}else{
					permutationNumberAllBasedKeggPathway2KMap.put(zeroOrOne.getKey(), permutationNumberAllBasedKeggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
				}
			}//End of for
					
			
			//New search for SNP or interval case, does not matter.
			//for each tf overlap
			//for each ucscRefSeqGene overlap
			//if these overlaps overlaps
			//then write common overlap to output files 
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
			//Fill permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
			for(PermutationNumberTfNameCellLineNameOverlap permutationNumberTfNameCellLineNameOverlap: permutationNumberTfNameCellLineNameOverlapList){
				
				permutationNumberTfNameCellLineName = permutationNumberTfNameCellLineNameOverlap.getPermutationNumberTfNameCellLineName();
				indexofFirstUnderscore 	= permutationNumberTfNameCellLineName.indexOf('_');
				indexofSecondUnderscore = permutationNumberTfNameCellLineName.indexOf('_', indexofFirstUnderscore+1);
				permutationNumberTfName = permutationNumberTfNameCellLineName.substring(0,indexofSecondUnderscore);
				
				//TF and Exon Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberExonBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
							
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and Regulation Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberRegulationBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
							
									if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query
				
				
				//TF and All Based Kegg Pathway
				for (PermutationNumberUcscRefSeqGeneOverlap permutationNumberUcscRefSeqGeneOverlap: permutationNumberAllBasedKeggPathwayOverlapList){
					if(IntervalTree.overlaps(permutationNumberTfNameCellLineNameOverlap.getLow(),permutationNumberTfNameCellLineNameOverlap.getHigh(),permutationNumberUcscRefSeqGeneOverlap.getLow(), permutationNumberUcscRefSeqGeneOverlap.getHigh())){
						for(String keggPathwayName:permutationNumberUcscRefSeqGeneOverlap.getKeggPathwayNameList()){ 
									
									/***********************************/
									permutationNumberTfNameCellLineNameKeggPathwayName = permutationNumberTfNameCellLineName + "_" + keggPathwayName;
								
									if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
										permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, 1);
									}
									/***********************************/
									
									/***********************************/
									permutationNumberTfNameKeggPathwayName = permutationNumberTfName + "_" + keggPathwayName;
									
									if (permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.get(permutationNumberTfNameKeggPathwayName)==null){
										permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.put(permutationNumberTfNameKeggPathwayName, 1);
									}
									/***********************************/
									
							
						} //for each kegg pathways having this gene
					}//if tfOverlap and ucscRefSeqGeneOverlap overlaps
				}//for each ucscRefSeqGeneOverlap for the given query

			}//for each tfOverlap for the given query
			
			
			//TF CELLLINE EXON BASED
			//Fill permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
			
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameExonBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
								
			}//End of for inner loop 
			
			//TF CELLLINE REGULATION BASED
			//Fill permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			
			//TF CELLLINE ALL BASED
			//Fill  permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap using permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameCellLineNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameCellLineNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)==null){
					permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.put(permutationNumberTfNameCellLineNameKeggPathwayName, permutationNumberTfNameCellLineNameAllBasedKeggPathway2KMap.get(permutationNumberTfNameCellLineNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			//new code starts 
			//TF EXON BASED
			//Fill permutationNumberTfExonBasedKeggPathway2KMap using permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameExonBasedKeggPathway2OneorZeroMap.entrySet()){
			
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfExonBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfExonBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
								
			}//End of for inner loop 
			
			//TF REGULATION BASED
			//Fill permutationNumberTfRegulationBasedKeggPathway2KMap using permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameRegulationBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfRegulationBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfRegulationBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 
			
			
			//TF ALL BASED
			//Fill  permutationNumberTfAllBasedKeggPathway2KMap using permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap
			for(Map.Entry<String, Integer> keggPathwayZeroOrOne: permutationNumberTfNameAllBasedKeggPathway2OneorZeroMap.entrySet()){
				
				permutationNumberTfNameKeggPathwayName = keggPathwayZeroOrOne.getKey();
				
				if (permutationNumberTfAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)==null){
					permutationNumberTfAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, keggPathwayZeroOrOne.getValue());
				}else{
					permutationNumberTfAllBasedKeggPathway2KMap.put(permutationNumberTfNameKeggPathwayName, permutationNumberTfAllBasedKeggPathway2KMap.get(permutationNumberTfNameKeggPathwayName)+keggPathwayZeroOrOne.getValue());	
				}
				
			}//End of for inner loop 

			//new code ends
				
		}//End of for each input line
	}
	//New Functionality END

	
	//Search keggPathway
	public void searchUcscRefSeqGenes(ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,List<String>> geneId2KeggPathwayMap, List<String> keggPathwayNameList, Map<String,Integer> keggPathway2KMap, String type,KeggPathwayAnalysisType keggPathwayAnalysisType){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				
				Map<String,Integer> keggPathway2OneorZeroMap = new HashMap<String,Integer>();				
				
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);

				if(ucscRefSeqGenesIntervalTree.getRoot().getNodeName().isNotSentinel()){
					ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap, geneId2KeggPathwayMap, keggPathwayNameList, keggPathway2OneorZeroMap,type,keggPathwayAnalysisType);
				}
				
				
				//accumulate search results of keggPathway2OneorZeroMap in keggPathway2KMap
				for(Map.Entry<String, Integer> zeroOrOne: keggPathway2OneorZeroMap.entrySet()){
					 
					if (keggPathway2KMap.get(zeroOrOne.getKey())==null){
						keggPathway2KMap.put(zeroOrOne.getKey(), zeroOrOne.getValue());
					}else{
						keggPathway2KMap.put(zeroOrOne.getKey(), keggPathway2KMap.get(zeroOrOne.getKey())+zeroOrOne.getValue());
						
					}
	
				}//End of for
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
	}

	
	
	

	public void searchUcscRefSeqGenes(ChromosomeName chromName, BufferedReader bufferedReader, IntervalTree ucscRefSeqGenesIntervalTree, Map<String,BufferedWriter> bufferedWriterHashMap, Map<String,Integer> nameorIdHashMap, String type){
		String strLine = null;
		int indexofFirstTab = 0;
		int indexofSecondTab = 0;
		
		int low;
		int high;
		
		try {
			while((strLine = bufferedReader.readLine())!=null){
				indexofFirstTab = strLine.indexOf('\t');
				indexofSecondTab = strLine.indexOf('\t',indexofFirstTab+1);
				
				low = Integer.parseInt(strLine.substring(indexofFirstTab+1, indexofSecondTab));
				
//					indexofSecondTab must be greater than zero if it exists since indexofFirstTab must exists and can be at least zero therefore indexofSecondTab can be at least one.
				if (indexofSecondTab>0)
					high = Integer.parseInt(strLine.substring(indexofSecondTab+1));
				else 
					high = low;
				
				Interval interval = new Interval(low,high);
//					todo
//					bufferedWriter.write("Searched for" + "\t" + chromName + "\t" + low + "\t" + high + System.getProperty("line.separator"));
//					bufferedWriter.flush();				
				ucscRefSeqGenesIntervalTree.findAllOverlappingUcscRefSeqGenesIntervals(ucscRefSeqGenesIntervalTree.getRoot(),interval,chromName,bufferedWriterHashMap,nameorIdHashMap,type);
				
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // End of while 
	}
	
	

	

	public BufferedReader createBufferedReader(String outputFolder, String fileName){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(outputFolder + fileName);
			bufferedReader = new BufferedReader(fileReader);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return bufferedReader;
	}
	
	//@todo starts
	public void fillName2NumberMap(TObjectShortMap<String> name2NumberMap,String dataFolder, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int indexofFirstTab;
		short number;
		String name;
		
		try {
			fileReader = new FileReader(dataFolder + inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {
				indexofFirstTab = strLine.indexOf('\t');
				name = strLine.substring(0,indexofFirstTab);
				number = Short.parseShort(strLine.substring(indexofFirstTab+1));
				name2NumberMap.put(name, number);
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	//@todo ends
	
	//@todo starts
	public void fillNumber2NameMap(TIntObjectMap<String> number2NameMap, String dataFolder, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int indexofFirstTab;
		
		int number;
		String name;
		
		try {
			fileReader = new FileReader(dataFolder + inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {
				indexofFirstTab = strLine.indexOf('\t');
				number = Integer.parseInt(strLine.substring(0,indexofFirstTab));
				name = strLine.substring(indexofFirstTab+1);
				number2NameMap.put(number, name);
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}	
	//@todo ends
	
	//@todo starts
	public void fillNumber2NameMap(TShortObjectMap<String> number2NameMap, String dataFolder, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		int indexofFirstTab;
		short number;
		String name;
		
		try {
			fileReader = new FileReader(dataFolder + inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {
				indexofFirstTab = strLine.indexOf('\t');
				number = Short.parseShort(strLine.substring(0,indexofFirstTab));
				name = strLine.substring(indexofFirstTab+1);
				number2NameMap.put(number, name);
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}	
	//@todo ends
	
	
	public void fillList(List<String> list, String dataFolder, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(dataFolder + inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {			
				list.add(strLine);
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	
	public static void fillHashMap(Map<String,Integer> hashMap, String inputFileName){
		String strLine;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(inputFileName);			
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null) {
				hashMap.put(strLine, Commons.ZERO);
				
				strLine = null;
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
	
	//@todo starts
	public void writeResultsWithNumbers(TShortIntMap number2KMap, TShortObjectMap<String> number2NameMap, String outputFolder, String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		String elementName;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line
		   	bufferedWriter.write("Element Name" + "\t" + "Number of Overlaps: k out of n given intervals overlaps with the intervals of element" + System.getProperty("line.separator"));
						
			// accessing keys/values through an iterator:
			for ( TShortIntIterator it = number2KMap.iterator(); it.hasNext(); ) {
			    it.advance();
			    elementName = number2NameMap.get(it.key());
			   	bufferedWriter.write(elementName + "\t" + it.value() + System.getProperty("line.separator"));
			}
									
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	//@todo ends
	
	//yeni starts
	public void writeResultsWithNumbers(TIntIntMap number2KMap, TIntObjectMap<String> number2NameMap, String outputFolder, String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		String elementName;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line
		   	bufferedWriter.write("Element Name" + "\t" + "Number of Overlaps: k out of n given intervals overlaps with the intervals of element" + System.getProperty("line.separator"));
						
			// accessing keys/values through an iterator:
			for ( TIntIntIterator it = number2KMap.iterator(); it.hasNext(); ) {
			    it.advance();
			    elementName = number2NameMap.get(it.key());
			   	bufferedWriter.write(elementName + "\t" + it.value() + System.getProperty("line.separator"));
			}
									
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	//yeni ends
	
	//@todo TF CellLine KEGGPathway starts
	public void writeResultsWithNumbers(TIntIntMap elementNumberCellLineNumberKeggNumber2KMap, TShortObjectMap<String> elementNumber2ElementNameMap, TShortObjectMap<String> cellLineNumber2CellLineNameMap, TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,String outputFolder , String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		
		int elementNumberCellLineNumberKeggPathwayNumber;
		short elementNumber;
		short cellLineNumber;
		short keggPathwayNumber;
		
		String elementName;
		String cellLineName;
		String keggPathwayName;
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line
		   	bufferedWriter.write("ElementName" + "_" + "CellLineName" + "_" + "KeggPathwayName" + "\t"  + "Number of Overlaps: k out of n given intervals overlaps with the intervals of element" + System.getProperty("line.separator"));
						
			// accessing keys/values through an iterator:
			for ( TIntIntIterator it = elementNumberCellLineNumberKeggNumber2KMap.iterator(); it.hasNext(); ) {
			    it.advance();
			    
			    elementNumberCellLineNumberKeggPathwayNumber = it.key();
			    
			    elementNumber = IntervalTree.getElementNumber(elementNumberCellLineNumberKeggPathwayNumber);
			    elementName = elementNumber2ElementNameMap.get(elementNumber);
			    
			    cellLineNumber = IntervalTree.getCellLineNumber(elementNumberCellLineNumberKeggPathwayNumber);
			    cellLineName = cellLineNumber2CellLineNameMap.get(cellLineNumber);
			    
			    keggPathwayNumber = IntervalTree.getKeggPathwayNumber(elementNumberCellLineNumberKeggPathwayNumber);
			    keggPathwayName = keggPathwayNumber2KeggPathwayNameMap.get(keggPathwayNumber);
			    		
			    		
			   	bufferedWriter.write(elementName + "_" + cellLineName + "_" + keggPathwayName + "\t" + it.value() + System.getProperty("line.separator"));
			}
									
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//@todo TF CellLine KEGGPathway ends
	
	//@todo starts
	public void writeTFKEGGPathwayResultsWithNumbers(TIntIntMap elementNumberCellLineNumber2KMap, TShortObjectMap<String> elementNumber2ElementNameMap, TShortObjectMap<String> KEGGPathwayNumber2KEGGPathwayNameMap, String outputFolder , String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		
		int elementNumberCellLineNumber;
		short elementNumber;
		short keggPathwayNumber;
		
		String elementName;
		String keggPathwayName;
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line
		   	bufferedWriter.write("ElementName_KEGGPathwayName" + "\t" + "Number of Overlaps: k out of n given intervals overlaps with the intervals of element" + System.getProperty("line.separator"));
			
			
			// accessing keys/values through an iterator:
			for ( TIntIntIterator it = elementNumberCellLineNumber2KMap.iterator(); it.hasNext(); ) {
			    it.advance();
			    
			    elementNumberCellLineNumber = it.key();
			    
			    elementNumber = IntervalTree.getElementNumber(elementNumberCellLineNumber);
			    elementName = elementNumber2ElementNameMap.get(elementNumber);
			    
			    keggPathwayNumber = IntervalTree.getKeggPathwayNumber(elementNumberCellLineNumber);
			    keggPathwayName = KEGGPathwayNumber2KEGGPathwayNameMap.get(keggPathwayNumber);
			    
			   	bufferedWriter.write(elementName + "_" + keggPathwayName + "\t" + it.value() + System.getProperty("line.separator"));
			}
									
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//@todo ends
	
	//@todo starts
	public void writeResultsWithNumbers(TIntIntMap elementNumberCellLineNumber2KMap, TShortObjectMap<String> elementNumber2ElementNameMap, TShortObjectMap<String> cellLineNumber2CellLineNameMap, String outputFolder , String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		
		int elementNumberCellLineNumber;
		short elementNumber;
		short cellLineNumber;
		
		String elementName;
		String cellLineName;
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			//header line
		   	bufferedWriter.write("ElementName_CellLineName" + "\t" + "Number of Overlaps: k out of n given intervals overlaps with the intervals of element" + System.getProperty("line.separator"));
			
			
			// accessing keys/values through an iterator:
			for ( TIntIntIterator it = elementNumberCellLineNumber2KMap.iterator(); it.hasNext(); ) {
			    it.advance();
			    
			    elementNumberCellLineNumber = it.key();
			    
			    elementNumber = IntervalTree.getElementNumber(elementNumberCellLineNumber);
			    elementName = elementNumber2ElementNameMap.get(elementNumber);
			    
			    cellLineNumber = IntervalTree.getCellLineNumber(elementNumberCellLineNumber);
			    cellLineName = cellLineNumber2CellLineNameMap.get(cellLineNumber);
			    
			   	bufferedWriter.write(elementName + "_" + cellLineName + "\t" + it.value() + System.getProperty("line.separator"));
			}
									
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	//@todo ends
	
	
	
	public void writeResults(Map<String,Integer> hashMap, String outputFolder, String outputFileName){
		FileWriter fileWriter;
		BufferedWriter  bufferedWriter;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + outputFileName);
			bufferedWriter = new BufferedWriter(fileWriter);	
			
			for (Map.Entry<String, Integer> entry: hashMap.entrySet()){
				bufferedWriter.write(entry.getKey() + "\t" + entry.getValue() + System.getProperty("line.separator"));
			}
						
			bufferedWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void closeBufferedWriterList(List<FileWriter> fileWriterList, List<BufferedWriter> bufferedWriterList){
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;			
			
			try {	
				for(int i = 0; i<bufferedWriterList.size(); i++){	
					bufferedWriter = bufferedWriterList.get(i);	
					fileWriter = fileWriterList.get(i);							
					bufferedWriter.close();
					fileWriter.close();										
				}
						
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

	//@todo starts
	public void searchDnaseWithNumbers(String dataFolder,String outputFolder, TShortIntMap dnaseCellLineNumber2KMap, int overlapDefinition,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree dnaseIntervalTree;
			
//		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> dnaseCellLineNumber2BufferedWriterHashMap = new TShortObjectHashMap<BufferedWriter>();
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					searchDnaseWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap, dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());				
					dnaseIntervalTree = null;
			
					break;
				case 2:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME2,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
					
					break;
				case 3:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME3,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 4:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME4,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;		
					
					break;
				case 5:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME5,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

				
					break;
				case 6:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME6,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
			
					
					break;
				case 7:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME7,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 8:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME8,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 9	:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME9,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 10:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME10,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
				
					break;
				case 11:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME11,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					
					break;
				case 12:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME12,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					break;
				case 13:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME13,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 14:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME14,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 15:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME15,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 16:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME16,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 17:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME17,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 18:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME18,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
						
					break;
				case 19:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME19,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 20:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME20,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 21:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME21,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 22:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOME22,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 23:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOMEX,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 24:							
					dnaseIntervalTree = createDnaseIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					searchDnaseWithNumbers(outputFolder, ChromosomeName.CHROMOSOMEY,bufferedReader, dnaseIntervalTree, dnaseCellLineNumber2BufferedWriterHashMap,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
//			closeBufferedWriters(dnaseBufferedWriterHashMap);	
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo ends
	
	
	public void searchDnase(String dataFolder,String outputFolder, List<String> dnaseCellLineNameList, Map<String,Integer> dnaseCellLine2KMap, int overlapDefinition) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree dnaseIntervalTree;
			
		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME1,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchDnase(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList, dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());				
					dnaseIntervalTree = null;
			
					break;
				case 2:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME2,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME2,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
					
					break;
				case 3:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME3,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME3,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 4:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME4,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME4,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;		
					
					break;
				case 5:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME5,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME5,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

				
					break;
				case 6:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME6,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME6,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
			
					
					break;
				case 7:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME7,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME7,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 8:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME8,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME8,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 9	:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME9,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME9,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;

					break;
				case 10:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME10,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME10,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());	
					dnaseIntervalTree = null;
				
					break;
				case 11:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME11,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME11,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					
					break;
				case 12:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME12,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder , Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME12,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
	
					break;
				case 13:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME13,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME13,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 14:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME14,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME14,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 15:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME15,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME15,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 16:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME16,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME16,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 17:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME17,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME17,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 18:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME18,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME18,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
						
					break;
				case 19:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME19,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME19,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 20:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME20,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME20,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 21:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME21,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME21,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					break;
				case 22:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOME22,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOME22,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
				
					
					break;
				case 23:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOMEX,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOMEX,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
				case 24:							
					dnaseIntervalTree = createDnaseIntervalTree(dataFolder, ChromosomeName.CHROMOSOMEY,dnaseCellLineNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchDnase(outputFolder, ChromosomeName.CHROMOSOMEY,bufferedReader, dnaseIntervalTree, dnaseBufferedWriterHashMap,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);
					emptyIntervalTree(dnaseIntervalTree.getRoot());					
					dnaseIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
//			closeBufferedWriters(dnaseBufferedWriterHashMap);	
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//@todo Gene Annotation with numbers starts 
	public void searchGeneWithNumbers(
			String dataFolder,
			String outputFolder,
			TIntIntMap geneAlternateNumber2KMap,
			int overlapDefinition,
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
		BufferedReader bufferedReader =null ;
		
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		
		
		for(int i = 1; i<=24 ; i++ ){
		
			switch(i){
				case 1:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
				
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
						ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					
					searchGeneWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,ucscRefSeqGenesIntervalTree,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo Gene Annotation with numbers ends 
	
	//@todo Annotation with numbers starts
	public void searchKEGGPathwayWithNumbers(
			String dataFolder,
			String outputFolder,
			TShortIntMap exonBasedKeggPathwayNumber2KMap,
			TShortIntMap regulationBasedKeggPathwayNumber2KMap,
			TShortIntMap allBasedKeggPathwayNumber2KMap,
			int overlapDefinition,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap,
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
			
		BufferedReader bufferedReader =null ;
		
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		//In order to write the results of common overlaps of KEGGpathway for the same given query
		TShortObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		
		
		for(int i = 1; i<=24 ; i++ ){
		
			switch(i){
				case 1:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
						
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
						ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					
					searchKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,ucscRefSeqGenesIntervalTree,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//KEGGPathway annotation with Numbers ends
	//@todo Annotation with numbers ends
	  
	//@todo TF KEGGPathway Annotation with Numbers starts
	public void searchTfKEGGPathwayWithNumbers(
			String dataFolder, 
			String outputFolder, 
			TIntIntMap tfNumberCellLineNumber2KMap,
			TShortIntMap exonBasedKeggPathwayNumber2KMap,
			TShortIntMap regulationBasedKeggPathwayNumber2KMap,
			TShortIntMap allBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberExonBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberRegulationBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberAllBasedKeggPathwayNumber2KMap,
			int overlapDefinition,
			TShortObjectMap<String> tfNumber2TfNameMap, 
			TShortObjectMap<String> cellLineNumber2CellLineNameMap,	
			TShortObjectMap<String> fileNumber2FileNameMap,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
		
		
		BufferedReader bufferedReader =null ;
		
		IntervalTree tfbsIntervalTree;
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		//In order to write the results of common overlaps of TF for the same given query
		TIntObjectMap<BufferedWriter>  tfbsBufferedWriterHashMap 						= new TIntObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of KEGGpathway for the same given query
		TShortObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of TF and KEGGpathway for the same given query
		TIntObjectMap<BufferedWriter>  tfExonBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		TIntObjectMap<BufferedWriter>  tfRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
		TIntObjectMap<BufferedWriter>  tfAllBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
	
		for(int i = 1; i<=24 ; i++ ){
		
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
						
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					
					searchTfKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo TF KEGGPathway Annotation with Numbers ends
	
	//@todo TF CellLine KEGGPathway Annotation With Numbers starts
	public void searchTfCellLineKEGGPathwayWithNumbers(
			String dataFolder, 
			String outputFolder, 
			TIntIntMap tfNumberCellLineNumber2KMap,
			TShortIntMap exonBasedKeggPathwayNumber2KMap,
			TShortIntMap regulationBasedKeggPathwayNumber2KMap,
			TShortIntMap allBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap, 
			int overlapDefinition,
			TShortObjectMap<String> tfNumber2TfNameMap, 
			TShortObjectMap<String> cellLineNumber2CellLineNameMap,	
			TShortObjectMap<String> fileNumber2FileNameMap,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
		BufferedReader bufferedReader =null ;
		
		IntervalTree tfbsIntervalTree;
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		//In order to write the results of common overlaps of TF for the same given query
		TIntObjectMap<BufferedWriter>  tfbsBufferedWriterHashMap 						= new TIntObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of KEGGpathway for the same given query
		TShortObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of TF and CellLine and KEGGpathway for the same given query
		TIntObjectMap<BufferedWriter>  tfCellLineExonBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		TIntObjectMap<BufferedWriter>  tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
		TIntObjectMap<BufferedWriter>  tfCellLineAllBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		
		
		for(int i = 1; i<=24 ; i++ ){
		
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
						
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					
					searchTfCellLineKEGGPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo TF CellLine KEGGPathway Annotation With Numbers ends
	
	
	//@todo Annotation with Numbers starts
	//New Functionality START
	//TF CellLine KEGGPathway
	//TF KEGGPathway
	public void searchTfandKeggPathwayWithNumbers(
			String dataFolder, 
			String outputFolder, 
			TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap, 
			TIntIntMap tfNumberCellLineNumber2KMap,
			TShortIntMap exonBasedKeggPathwayNumber2KMap,
			TShortIntMap regulationBasedKeggPathwayNumber2KMap,
			TShortIntMap allBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,
			TIntIntMap tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberExonBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberRegulationBasedKeggPathwayNumber2KMap, 
			TIntIntMap tfNumberAllBasedKeggPathwayNumber2KMap,
			int overlapDefinition,
			TShortObjectMap<String> tfNumber2TfNameMap, 
			TShortObjectMap<String> cellLineNumber2CellLineNameMap,	
			TShortObjectMap<String> fileNumber2FileNameMap,
			TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap,
			TIntObjectMap<String> geneHugoSymbolNumber2GeneHugoSymbolNameMap,
			TIntObjectMap<String> refSeqGeneNumber2RefSeqGeneNameMap){
		BufferedReader bufferedReader =null ;
		
		IntervalTree tfbsIntervalTree;
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		//In order to write the results of common overlaps of TF for the same given query
		TIntObjectMap<BufferedWriter>  tfbsBufferedWriterHashMap 						= new TIntObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of KEGGpathway for the same given query
		TShortObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new TShortObjectHashMap<BufferedWriter>(); 
		TShortObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 		= new TShortObjectHashMap<BufferedWriter>(); 
		
		//In order to write the results of common overlaps of TF and CellLine and KEGGpathway for the same given query
		TIntObjectMap<BufferedWriter>  tfCellLineExonBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		TIntObjectMap<BufferedWriter>  tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
		TIntObjectMap<BufferedWriter>  tfCellLineAllBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		
		//In order to write the results of common overlaps of TF and KEGGpathway for the same given query
		TIntObjectMap<BufferedWriter>  tfExonBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
		TIntObjectMap<BufferedWriter>  tfRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
		TIntObjectMap<BufferedWriter>  tfAllBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>();
	
		for(int i = 1; i<=24 ; i++ ){
		
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
						
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					
					searchTfandKeggPathwayWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathwayNumber2KMap,regulationBasedKeggPathwayNumber2KMap,allBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,tfNumberExonBasedKeggPathwayNumber2KMap,tfNumberRegulationBasedKeggPathwayNumber2KMap,tfNumberAllBasedKeggPathwayNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo Annotation with Numbers ends
	
	
	//New Functionality START
	//Which cell line does not matter.
	public void searchTfandKeggPathway(String dataFolder, String outputFolder, List<String> tfNameList, List<String> keggPathwayNameList, Map<String,List<String>> geneId2KeggPathwayMap, Map<String,Integer> tfbsNameandCellLineName2KMap, Map<String,Integer> exonBasedKeggPathway2KMap, Map<String,Integer> regulationBasedKeggPathway2KMap, Map<String,Integer> allBasedKeggPathway2KMap, Map<String,Integer> tfCellLineExonBasedKeggPathway2KMap,Map<String,Integer> tfCellLineRegulationBasedKeggPathway2KMap,Map<String,Integer> tfCellLineAllBasedKeggPathway2KMap, Map<String,Integer> tfExonBasedKeggPathway2KMap, Map<String,Integer> tfRegulationBasedKeggPathway2KMap, Map<String,Integer> tfAllBasedKeggPathway2KMap,int overlapDefinition){
		BufferedReader bufferedReader =null ;
		
		IntervalTree tfbsIntervalTree;
		IntervalTree ucscRefSeqGenesIntervalTree;
		
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		//In order to write the results of common overlaps of tfCellLine and kegg pathway for the same given query
		Map<String,BufferedWriter>  tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		Map<String,BufferedWriter>  tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter>  tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		
		//In order to write the results of common overlaps of tf and kegg pathway for the same given query
		Map<String,BufferedWriter>  tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
		Map<String,BufferedWriter>  tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		Map<String,BufferedWriter>  tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
	
		
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
						
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;
					
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 3:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
					
				case 4:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 5:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 6:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 7:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 8:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 9:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
				
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 11:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 13:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 16:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 17:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 19:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 22:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY,tfNameList);
					ucscRefSeqGenesIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					
					searchTfandKeggPathway(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader,tfbsIntervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap,exonBasedKeggPathwayBufferedWriterHashMap,regulationBasedKeggPathwayBufferedWriterHashMap,allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap, tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap, tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap, tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,tfNameList,keggPathwayNameList,geneId2KeggPathwayMap,tfbsNameandCellLineName2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap,overlapDefinition);
					
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					emptyIntervalTree(ucscRefSeqGenesIntervalTree.getRoot());
					ucscRefSeqGenesIntervalTree = null;
					break;	
			} // End of Switch
		}//End of FOR all chromosomes
					
		
//			closeBufferedWriters(tfbsBufferedWriterHashMap);
//			
//			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
//			
//			closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
//				
//			closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
//			closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	//New Functionality END
	
	public void searchTfbs(String dataFolder,String outputFolder, List<String> tfbsNameList, Map<String,Integer> tfbsNameandCellLineName2KMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree tfbsIntervalTree;
		
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME1,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 2:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME2,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 3:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME3,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 4:							
			
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME4,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 5:							

					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME5,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
	
					break;
				case 6:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME6,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 7:							

					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME7,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 8:							
														
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME8,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 9	:							
	
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME9,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 10:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME10,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 11:							
						
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME11,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;


					
					break;
				case 12:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME12,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 13:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME13,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 14:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME14,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 15:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME15,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

				
					break;
				case 16:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME16,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;


					break;
				case 17:							
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME17,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					
					break;
				case 18:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME18,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;

					break;
				case 19:							
						
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME19,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 20:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME20,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 21:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME21,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
				case 22:							
				
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOME22,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
				
					break;
				case 23:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOMEX,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
						
					break;
				case 24:							
					
					tfbsIntervalTree = createTfbsIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY,tfbsNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchTfbs(ChromosomeName.CHROMOSOMEY,bufferedReader, tfbsIntervalTree, tfbsBufferedWriterHashMap, tfbsNameList,tfbsNameandCellLineName2KMap);
					emptyIntervalTree(tfbsIntervalTree.getRoot());
					tfbsIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(tfbsBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//@todo searchTFWithNumbers starts
	public void searchTranscriptionFactorWithNumbers(String dataFolder,String outputFolder, TIntIntMap tfNumberCellLineNumber2KMap,int overlapDefinition,TShortObjectMap<String> tfNumber2TFNameMap,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree transcriptionFactorIntervalTree;
		
		TIntObjectMap<BufferedWriter> transcriptionFactorBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 				
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
		
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 2:							
					
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
						break;
				case 3:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;

						break;
				case 4:							
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 5:							
				
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;

					break;
				case 6:							
					
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 7:							
				
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 8:							
				
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 9	:							
		
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;

					break;
				case 10:							
		
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 11:							
		
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;

					
					break;
				case 12:							
	
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;

					break;
				case 13:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 14:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 15:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 16:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					

					break;
				case 17:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 18:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 19:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 20:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 21:							
					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 22:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 23:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
				case 24:							

					transcriptionFactorIntervalTree = createTfbsIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					searchTranscriptionFactorWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader, transcriptionFactorIntervalTree, transcriptionFactorBufferedWriterHashMap, tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TFNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(transcriptionFactorIntervalTree.getRoot());
					transcriptionFactorIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
//			closeBufferedWriters(histoneBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo searchTranscriptionFactorWithNumbers ends
	
	//@todo searchHistoneWithNumbers starts 
	public void searchHistoneWithNumbers(String dataFolder,String outputFolder, TIntIntMap histoneNumberCellLineNumber2KMap,int overlapDefinition,TShortObjectMap<String> histoneNumber2HistoneNameMap,TShortObjectMap<String> cellLineNumber2CellLineNameMap,TShortObjectMap<String> fileNumber2FileNameMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree histoneIntervalTree;
		
		TIntObjectMap<BufferedWriter> histoneBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 				
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
		
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder, ChromosomeName.CHROMOSOME1);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR1);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 2:							
					
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME2);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR2);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
						break;
				case 3:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME3);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR3);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

						break;
				case 4:							
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME4);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR4);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 5:							
				
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME5);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR5);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 6:							
					
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME6);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR6);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 7:							
				
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME7);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR7);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 8:							
				
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME8);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR8);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 9	:							
		
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME9);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR9);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 10:							
		
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME10);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR10);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 11:							
		
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME11);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR11);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					
					break;
				case 12:							
	
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME12);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR12);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 13:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME13);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR13);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 14:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME14);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR14);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 15:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME15);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR15);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 16:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME16);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR16);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					

					break;
				case 17:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME17);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR17);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 18:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME18);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR18);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 19:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME19);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR19);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 20:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME20);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR20);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 21:							
					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME21);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR21);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 22:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOME22);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHR22);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 23:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEX);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRX);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 24:							

					histoneIntervalTree = createHistoneIntervalTreeWithNumbers(dataFolder,ChromosomeName.CHROMOSOMEY);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + Commons.CHROMOSOME_BASED_GIVEN_INPUT_CHRY);
					searchHistoneWithNumbers(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//@todo searchHistoneWithNumbers ends
	
	public void searchHistone(String dataFolder,String outputFolder, List<String> histoneNameList, Map<String,Integer> histoneNameandCellLineName2KMap,int overlapDefinition) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree histoneIntervalTree;
		
		Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 				
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME1,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 2:							
					
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME2,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
						break;
				case 3:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME3,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

						break;
				case 4:							
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME4,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 5:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME5,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 6:							
					
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME6,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 7:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME7,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 8:							
				
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME8,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 9	:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME9,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 10:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME10,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 11:							
		
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME11,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					
					break;
				case 12:							
	
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME12,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;

					break;
				case 13:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME13,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 14:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME14,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 15:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME15,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 16:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME16,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					

					break;
				case 17:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME17,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 18:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME18,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 19:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME19,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 20:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME20,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 21:							
					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME21,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 22:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOME22,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 23:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOMEX,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
				case 24:							

					histoneIntervalTree = createHistoneIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY,histoneNameList);
					bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchHistone(outputFolder,ChromosomeName.CHROMOSOMEY,bufferedReader, histoneIntervalTree, histoneBufferedWriterHashMap, histoneNameList, histoneNameandCellLineName2KMap,overlapDefinition);
					emptyIntervalTree(histoneIntervalTree.getRoot());
					histoneIntervalTree = null;
					
					break;
					
				}//end of Swicth
		}//end of For
		
//			closeBufferedWriters(histoneBufferedWriterHashMap);
		
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


public void searchNcbiGeneId(String outputFolder, Map<String,Integer> ncbiGeneIdHashMap) {
		
		BufferedReader bufferedReader =null ;
				
		IntervalTree geneIntervalTree;
		
		Map<String,BufferedWriter> ncbiGeneIdBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
		
		for(int i = 1; i<=24 ; i++ ){
			
			switch(i){
				case 1:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);

					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME1,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
										
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr1 NcbiGeneId");
					break;
				case 2:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME2,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr2 NcbiGeneId");

					break;
				case 3:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME3,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr3  NcbiGeneId");

					break;
				case 4:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME4,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr4  NcbiGeneId");

					break;
				case 5:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME5,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr5 NcbiGeneId");

					break;
				case 6:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME6,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr6 NcbiGeneId");

					break;
				case 7:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME7,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr7 NcbiGeneId");

					break;
				case 8:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME8,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr8 NcbiGeneId");

					break;
				case 9	:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME9,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr9 NcbiGeneId");

					break;
				case 10:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME10,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr10 NcbiGeneId");

					break;
				case 11:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME11,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr11 NcbiGeneId");
					
					break;
				case 12:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME12,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr12 NcbiGeneId");

					break;
				case 13:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME13,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr13 NcbiGeneId");

					break;
				case 14:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME14,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr14 NcbiGeneId");

					break;
				case 15:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME15,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr15 NcbiGeneId");

					break;
				case 16:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME16,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr16 NcbiGeneId");

					break;
				case 17:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME17,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);

					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr17 NcbiGeneId");

					break;
				case 18:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME18,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr18 NcbiGeneId");

					break;
				case 19:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME19,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr19 NcbiGeneId");

					break;
				case 20:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME20,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr20 NcbiGeneId");

					break;
				case 21:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME21,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr21 NcbiGeneId");

					break;
				case 22:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME22,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr22 NcbiGeneId");
					
					break;
				case 23:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEX,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);
					
					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr23 NcbiGeneId");

					break;
				case 24:							
					geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
					
					bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
					searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEY,bufferedReader, geneIntervalTree, ncbiGeneIdBufferedWriterHashMap, ncbiGeneIdHashMap, Commons.NCBI_GENE_ID);

					emptyIntervalTree(geneIntervalTree.getRoot());								
					geneIntervalTree = null;
					GlanetRunner.appendLog("Chr24 NcbiGeneId");
			
					break;
					
				}//end of Swicth
		}//end of For
		
		closeBufferedWriters(ncbiGeneIdBufferedWriterHashMap);
	
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




public void searchNcbiRNANucleotideAccessionVersion(String outputFolder,Map<String,Integer> ncbiRnaNucleotideAccessionVersionHashMap) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY  + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME1,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr1 NcbiRNA");
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);

				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME2,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr2 NcbiRNA");

				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME3,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr3 NcbiRNA");

				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME4,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr4 NcbiRNA");

				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME5,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr5 NcbiRNA");

				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME6,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr6 NcbiRNA");

				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME7,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr7 NcbiRNA");

				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME8,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr8 NcbiRNA");

				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME9,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr9 NcbiRNA");

				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME10,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr10 NcbiRNA");

				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME11,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr11 NcbiRNA");
				
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME12,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr12 NcbiRNA");

				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME13,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr13 NcbiRNA");

				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME14,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr14 NcbiRNA");

				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME15,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr15 NcbiRNA");

				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME16,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr16 NcbiRNA");

				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME17,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr17 NcbiRNA");

				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME18,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr18 NcbiRNA");

				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME19,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr19 NcbiRNA");

				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME20,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr20 NcbiRNA");

				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME21,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr21 NcbiRNA");

				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME22,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr22 NcbiRNA");
				
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEX,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr23 NcbiRNA");

				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEY,bufferedReader, geneIntervalTree, ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap, ncbiRnaNucleotideAccessionVersionHashMap, Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr24 NcbiRNA");
		
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(ncbiRnaNucleotideAccessionVersionBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


public void searchUcscGeneAlternateName(String outputFolder, Map<String,Integer>  ucscGeneAlternateNameHashMap) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> ucscGeneAlternateNameBufferedWriterHashMap = new HashMap<String,BufferedWriter>();		
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME1);

				bufferedReader = createBufferedReader(outputFolder,Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME1,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr1 UcscGeneAlternateName");
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME2);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME2,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr2 UcscGeneAlternateName");

				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME3,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr3 UcscGeneAlternateName");

				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME4,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr4 UcscGeneAlternateName");

				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME5,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr5 UcscGeneAlternateName");

				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME6,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr6 UcscGeneAlternateName");

				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME7,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr7 UcscGeneAlternateName");

				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME8,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr8 UcscGeneAlternateName");

				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME9,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr9 UcscGeneAlternateName");

				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME10,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr10 UcscGeneAlternateName");

				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME11,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr11 UcscGeneAlternateName");
				
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME12,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr12 UcscGeneAlternateName");

				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME13,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr13 UcscGeneAlternateName");

				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME14,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr14 UcscGeneAlternateName");

				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME15);
				
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME15,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr15 UcscGeneAlternateName");

				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME16,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr16 UcscGeneAlternateName");

				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME17,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr17 UcscGeneAlternateName");

				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME18,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr18 UcscGeneAlternateName");

				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME19,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr19 UcscGeneAlternateName");

				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME20,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr20 UcscGeneAlternateName");

				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME21,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
									
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr21 UcscGeneAlternateName");

				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME22,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr22 UcscGeneAlternateName");
				
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEX,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr23 UcscGeneAlternateName");

				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(outputFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEY,bufferedReader, geneIntervalTree, ucscGeneAlternateNameBufferedWriterHashMap, ucscGeneAlternateNameHashMap,Commons.UCSC_GENE_ALTERNATE_NAME);

				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				GlanetRunner.appendLog("Chr24 UcscGeneAlternateName");
		
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(ucscGeneAlternateNameBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}



public void searchKeggPathway(String dataFolder,String outputFolder,Map<String,List<String>> geneId2KeggPathwayMap,List<String> keggPathwayNameList, Map<String,Integer> keggPathway2KMap, KeggPathwayAnalysisType keggPathwayAnalysisType) {
	
	BufferedReader bufferedReader =null ;
			
	IntervalTree geneIntervalTree;
	
	Map<String,BufferedWriter> keggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>();
	
	
	for(int i = 1; i<=24 ; i++ ){
		
		switch(i){
			case 1:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME1);

				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr1_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME1,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 2:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME2);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr2_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME2,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
					
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 3:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME3);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr3_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME3,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());
				geneIntervalTree = null;
				break;
			case 4:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME4);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr4_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME4,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 5:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME5);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr5_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME5,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 6:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME6);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr6_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME6,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 7:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME7);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr7_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME7,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 8:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME8);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr8_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME8,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 9	:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME9);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr9_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME9,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 10:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME10);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr10_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME10,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 11:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME11);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr11_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME11,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 12:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME12);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr12_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME12,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 13:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME13);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr13_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME13,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 14:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME14);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr14_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME14,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 15:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME15);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr15_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME15,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 16:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME16);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr16_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME16,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 17:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME17);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr17_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME17,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 18:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME18);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr18_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME18,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 19:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME19);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr19_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME19,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 20:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME20);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr20_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME20,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 21:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME21);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr21_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME21,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 22:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOME22);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chr22_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOME22,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 23:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEX);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrX_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEX,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
					
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
			case 24:							
				geneIntervalTree = createUcscRefSeqGenesIntervalTree(dataFolder,ChromosomeName.CHROMOSOMEY);
				
				bufferedReader = createBufferedReader(outputFolder, Commons.ANNOTATE_CHROMOSOME_BASED_INPUT_FILE_DIRECTORY + "search_chrY_input_file.txt");
				searchUcscRefSeqGenes(ChromosomeName.CHROMOSOMEY,bufferedReader, geneIntervalTree, keggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,keggPathwayNameList, keggPathway2KMap, Commons.NCBI_GENE_ID,keggPathwayAnalysisType);
				
				emptyIntervalTree(geneIntervalTree.getRoot());								
				geneIntervalTree = null;
				break;
				
			}//end of Swicth
	}//end of For
	
	closeBufferedWriters(keggPathwayBufferedWriterHashMap);
	
	try {
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}


	public void emptyIntervalTree(IntervalTreeNode node){
		if(node!=null){
			emptyIntervalTree(node.getRight());
			emptyIntervalTree(node.getLeft());
			
//				if(node.getCellLineName()!=null){
//					node.setCellLineName(null);
//				}
//				
//				if(node.getFileName()!=null){
//					node.setFileName(null);
//				}
//				
//				if(node.getTfbsorHistoneName()!=null){
//					node.setTfbsorHistoneName(null);
//				}
//				
//				if(node.getGeneHugoSymbol()!=null){
//					node.setGeneHugoSymbol(null);
//				}
//				
//				if(node.getIntervalName()!=null){
//					node.setIntervalName(null);
//				}
//				
//				if(node.getGeneEntrezId()!=null){
//					node.setGeneEntrezId(null);
//				}
//				
//				if(node.getRefSeqGeneName()!=null){
//					node.setRefSeqGeneName(null);
//				}
			
			if(node.getChromName()!=null){
				node.setChromName(null);
			}
			
			if (node.getLeft()!=null) {
				node.setLeft(null);
			}

			if (node.getRight()!=null) {
				node.setRight(null);
			}

			if (node.getParent()!=null) {
				node.setParent(null);
			}

			node = null;
		}		
	}
	
//		//Empirical P Value Calculation
//		//args[0] must have input file name with folder
//		//args[1] must have GLANET output folder
//		//args[2] must have GLANET data folder (necessary data for annotation and augmentation)
//		//args[3] must have Input File Format		
//		public AllName2KMaps annotateOriginalData(String[] args){
//			
//			String outputFolder = args[1];
//			String dataFolder = args[2];
//			int overlapDefinition = Integer.parseInt(args[3]);
//			
//			String inputFileName = outputFolder + Commons.REMOVED_OVERLAPS_INPUT_FILE;
//			
//			AllName2KMaps allName2KMaps = new AllName2KMaps();
//			
//			//Prepare chromosome based partitioned input interval files to be searched for
//			List<BufferedWriter> bufferedWriterList = new ArrayList<BufferedWriter>();	
//			//Create Buffered Writers for writing chromosome based input files
//			createChromBaseSeachInputFiles(outputFolder,bufferedWriterList);
//
//			//Partition the input file into 24 chromosome based input files
//			partitionSearchInputFilePerChromName(inputFileName,bufferedWriterList);
//				
//			//Close Buffered Writers
//			closeBufferedWriterList(bufferedWriterList);	
//			
//			//DNASE
//			//Search input interval files for dnase 
//			List<String> dnaseCellLineNameList = new ArrayList<String>();	
//			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
//			Map<String,Integer> dnaseCellLine2KMap = new HashMap<String,Integer>();		
//			
//			fillList(dnaseCellLineNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_CELL_LINE_NAMES_OUTPUT_FILENAME);		
//			searchDnase(dataFolder,outputFolder,dnaseCellLineNameList,dnaseCellLine2KMap,overlapDefinition);	
//			writeResults(dnaseCellLine2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_DNASE_RESULTS_GIVEN_SEARCH_INPUT);
//			allName2KMaps.setDnaseCellLineName2NumberofOverlapsMap(dnaseCellLine2KMap);
//			
//			//TFBS
//			//Search input interval files for tfbs 		
//			List<String> tfbsNameList = new ArrayList<String>();
//			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
//			Map<String,Integer> tfbsNameandCellLineName2KMap = new HashMap<String,Integer>();	
//			
//			fillList(tfbsNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_TF_NAMES_OUTPUT_FILENAME);		
//			searchTfbs(dataFolder,outputFolder,tfbsNameList,tfbsNameandCellLineName2KMap);		
//			writeResults(tfbsNameandCellLineName2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
//			allName2KMaps.setTfbsNameandCellLineName2NumberofOverlapsMap(tfbsNameandCellLineName2KMap);
//
//			//HISTONE
//			//Search input interval files for histone 		
//			List<String> histoneNameList = new ArrayList<String>();		
//			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
//			Map<String,Integer> histoneNameandCellLineName2KMap = new HashMap<String,Integer>();	
//				
//			fillList(histoneNameList,dataFolder ,Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_HISTONE_NAMES_OUTPUT_FILENAME);
//			searchHistone(dataFolder,outputFolder,histoneNameList,histoneNameandCellLineName2KMap,overlapDefinition);
//			writeResults(histoneNameandCellLineName2KMap, outputFolder, Commons.ANNOTATE_INTERVALS_HISTONE_RESULTS_GIVEN_SEARCH_INPUT);
//			allName2KMaps.setHistoneNameandCellLineName2NumberofOverlapsMap(histoneNameandCellLineName2KMap);
//			
//			
//			//KEGG PATHWAY
//			//Search input interval files for kegg Pathway
//			List<String> keggPathwayNameList = new ArrayList<String>();
//					
//			//Fill keggPathwayNameList
//			fillList(keggPathwayNameList,dataFolder , Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILENAME);
//			
//			Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
//			KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder, Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
//			
//			//Exon Based Kegg Pathway Analysis
//			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//			Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();
//					
//			searchKeggPathway(dataFolder,outputFolder,geneId2KeggPathwayMap,keggPathwayNameList, exonBasedKeggPathway2KMap, Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(exonBasedKeggPathway2KMap, outputFolder,Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//			allName2KMaps.setExonBasedKeggPathway2NumberofOverlapsMap(exonBasedKeggPathway2KMap);
//			
//			
//			//Regulation Based Kegg Pathway Analysis
//			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//			Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
//					
//			searchKeggPathway(dataFolder,outputFolder,geneId2KeggPathwayMap,keggPathwayNameList, regulationBasedKeggPathway2KMap, Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(regulationBasedKeggPathway2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//			allName2KMaps.setRegulationBasedKeggPathway2NumberofOverlapsMap(regulationBasedKeggPathway2KMap);
//			
//			//All results Kegg Pathway Analysis
//			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//			Map<String,Integer> allResultsKeggPathway2KMap = new HashMap<String,Integer>();
//							
//			searchKeggPathway(dataFolder,outputFolder, geneId2KeggPathwayMap,keggPathwayNameList, allResultsKeggPathway2KMap, Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(allResultsKeggPathway2KMap, outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//			
//			return allName2KMaps;
//		}
		

	
	//args[0]	--->	Input File Name with folder
	//args[1]	--->	GLANET installation folder with "\\" at the end. This folder will be used for outputFolder and dataFolder.
	//args[2]	--->	Input File Format	
	//			--->	default	Commons.INPUT_FILE_FORMAT_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_DBSNP_IDS_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_BED_0_BASED_COORDINATES_START_INCLUSIVE_END_EXCLUSIVE
	//			--->			Commons.INPUT_FILE_FORMAT_GFF3_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE	
	//args[3]	--->	Annotation, overlap definition, number of bases, default 1
	//args[4]	--->	Enrichment parameter
	//			--->	default	Commons.DO_ENRICH
	//			--->			Commons.DO_NOT_ENRICH	
	//args[5]	--->	Generate Random Data Mode
	//			--->	default	Commons.GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT
	//			--->			Commons.GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT	
	//args[6]	--->	multiple testing parameter, enriched elements will be decided and sorted with respest to this parameter
	//			--->	default Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE
	//			--->			Commons.BONFERRONI_CORRECTED_P_VALUE
	//args[7]	--->	Bonferroni Correction Significance Level, default 0.05
	//args[8]	--->	Benjamini Hochberg FDR, default 0.05
	//args[9]	--->	Number of permutations, default 5000
	//args[10]	--->	Dnase Enrichment
	//			--->	default Commons.DO_NOT_DNASE_ENRICHMENT
	//			--->	Commons.DO_DNASE_ENRICHMENT
	//args[11]	--->	Histone Enrichment
	//			--->	default	Commons.DO_NOT_HISTONE_ENRICHMENT
	//			--->			Commons.DO_HISTONE_ENRICHMENT
	//args[12]	--->	Transcription Factor(TF) Enrichment 
	//			--->	default	Commons.DO_NOT_TF_ENRICHMENT
	//			--->			Commons.DO_TF_ENRICHMENT
	//args[13]	--->	KEGG Pathway Enrichment
	//			--->	default	Commons.DO_NOT_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_KEGGPATHWAY_ENRICHMENT
	//args[14]	--->	TF and KEGG Pathway Enrichment
	//			--->	default	Commons.DO_NOT_TF_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_TF_KEGGPATHWAY_ENRICHMENT
	//args[15]	--->	TF and CellLine and KeggPathway Enrichment
	//			--->	default	Commons.DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT 
	//			--->			Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	//args[16]	--->	RSAT parameter
	//			--->	default Commons.DO_NOT_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	//			--->			Commons.DO_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
	//args[17]	--->	job name example: ocd_gwas_snps 
	//args[18]	--->	writeGeneratedRandomDataMode checkBox
	//			--->	default Commons.DO_NOT_WRITE_GENERATED_RANDOM_DATA
	//			--->			Commons.WRITE_GENERATED_RANDOM_DATA
	//args[19]	--->	writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	//			--->	default Commons.DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	//			--->			Commons.WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
	//args[20]	--->	writePermutationBasedAnnotationResultMode checkBox
	//			---> 	default	Commons.DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT
	//			--->			Commons.WRITE_PERMUTATION_BASED_ANNOTATION_RESULT			
	public void annotate(String[] args){
		
		String glanetFolder = args[1];
		
		//jobName starts
		String jobName = args[17].trim();
		if (jobName.isEmpty()){
			jobName = "noname";
		}
		//jobName ends
		
		
		String dataFolder 	= glanetFolder + System.getProperty("file.separator") + Commons.DATA + System.getProperty("file.separator") ;
		String outputFolder = glanetFolder + System.getProperty("file.separator") + Commons.OUTPUT + System.getProperty("file.separator") + jobName + System.getProperty("file.separator");
		
		int overlapDefinition = Integer.parseInt( args[3]);
		
		String inputFileName;
		
		//ENRICHMENT choice will be used as ANNOTATION choice
		//Dnase Enrichment, DO or DO_NOT
		EnrichmentType dnaseEnrichmentType = EnrichmentType.convertStringtoEnum(args[10]);
		
		//Histone Enrichment, DO or DO_NOT
		EnrichmentType histoneEnrichmentType = EnrichmentType.convertStringtoEnum(args[11]);
		
		
		//Transcription Factor Enrichment, DO or DO_NOT
		EnrichmentType tfEnrichmentType = EnrichmentType.convertStringtoEnum(args[12]);
			
		//KEGG Pathway Enrichment, DO or DO_NOT
		EnrichmentType keggPathwayEnrichmentType = EnrichmentType.convertStringtoEnum(args[13]);
							
		//TfKeggPathway Enrichment, DO or DO_NOT
		EnrichmentType tfKeggPathwayEnrichmentType = EnrichmentType.convertStringtoEnum(args[14]);
		
		//TfCellLineKeggPathway Enrichment, DO or DO_NOT
		EnrichmentType tfCellLineKeggPathwayEnrichmentType = EnrichmentType.convertStringtoEnum(args[15]);
		
		if (args[4].equals(Commons.DO_ENRICH)) {
			inputFileName = outputFolder + Commons.REMOVED_OVERLAPS_INPUT_FILE;
		}else {
			inputFileName = outputFolder + Commons.PROCESSED_INPUT_FILE;
		}
		
		/********************************************************************/
		/***********delete old files starts**********************************/
		String annotateOutputBaseDirectoryName = outputFolder + Commons.ANNOTATION;
		
		FileOperations.deleteOldFiles(annotateOutputBaseDirectoryName);
		/***********delete old files ends***********************************/
		/******************************************************************/
		
		
		List<FileWriter> fileWriterList = new ArrayList<FileWriter>();	
		
		//Prepare chromosome based partitioned input interval files to be searched for
		List<BufferedWriter> bufferedWriterList = new ArrayList<BufferedWriter>();	
		//Create Buffered Writers for writing chromosome based input files
		createChromBaseSeachInputFiles(outputFolder,fileWriterList,bufferedWriterList);

		//Partition the input file into 24 chromosome based input files
		partitionSearchInputFilePerChromName(inputFileName,bufferedWriterList);
			
		//Close Buffered Writers
		closeBufferedWriterList(fileWriterList,bufferedWriterList);	
		/*********************************************/
		
		/******************************************************/
		/***************FILL NUMBER 2 NAME MAPS*****starts*****/
		/******************************************************/
		TShortObjectMap<String> cellLineNumber2CellLineNameMap 				= new TShortObjectHashMap<String>();
		TShortObjectMap<String> fileNumber2FileNameMap 						= new TShortObjectHashMap<String>();
		TShortObjectMap<String> histoneNumber2HistoneNameMap 				= new TShortObjectHashMap<String>();	
		TShortObjectMap<String> tfNumber2TfNameMap 							= new TShortObjectHashMap<String>();	
		TShortObjectMap<String> keggPathwayNumber2KeggPathwayNameMap		= new TShortObjectHashMap<String>();		
		TIntObjectMap<String> 	geneHugoSymbolNumber2GeneHugoSymbolNameMap 	= new TIntObjectHashMap<String>();
		TIntObjectMap<String> 	refSeqGeneNumber2RefSeqGeneNameMap 			= new TIntObjectHashMap<String>();
		
		
		fillNumber2NameMap(cellLineNumber2CellLineNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_CELLLINENUMBER_2_CELLLINENAME_OUTPUT_FILENAME);
		fillNumber2NameMap(fileNumber2FileNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_FILENUMBER_2_FILENAME_OUTPUT_FILENAME);
		fillNumber2NameMap(histoneNumber2HistoneNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_HISTONENUMBER_2_HISTONENAME_OUTPUT_FILENAME);		
		fillNumber2NameMap(tfNumber2TfNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_ENCODE_TFNUMBER_2_TFNAME_OUTPUT_FILENAME);		
		fillNumber2NameMap(keggPathwayNumber2KeggPathwayNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_KEGGPATHWAYNUMBER_2_KEGGPATHWAYNAME_OUTPUT_FILENAME);	
		fillNumber2NameMap(geneHugoSymbolNumber2GeneHugoSymbolNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_UCSC_GENE_HUGO_SYMBOL_NUMBER_2_GENE_HUGO_SYMBOL_OUTPUT_FILENAME);
		fillNumber2NameMap(refSeqGeneNumber2RefSeqGeneNameMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_UCSC_REFSEQ_GENE_NAME_NUMBER_2_REFSEQ_GENE_NAME_OUTPUT_FILENAME);
		/******************************************************/
		/***************FILL NUMBER 2 NAME MAPS*****ends*******/
		/******************************************************/
		
		/******************************************************/
		/***************FILL NAME 2 NUMBER MAPS******starts****/
		/******************************************************/
		TObjectShortMap<String> keggPathwayName2KeggPathwayNumberMap 	= new TObjectShortHashMap<String>();
		
		fillName2NumberMap(keggPathwayName2KeggPathwayNumberMap,dataFolder, Commons.WRITE_ALL_POSSIBLE_NAMES_OUTPUT_DIRECTORYNAME + Commons.WRITE_ALL_POSSIBLE_KEGGPATHWAYNAME_2_KEGGPATHWAYNUMBER_OUTPUT_FILENAME);
		/******************************************************/
		/***************FILL NAME 2 NUMBER MAPS*****ends*******/
		/******************************************************/
		
		
		//This dnaseCellLineNumber2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n	
		//DNASE
		TShortIntMap dnaseCellLineNumber2KMap = new TShortIntHashMap();
	
		//Histone
		TIntIntMap histoneNumberCellLineNumber2KMap = new TIntIntHashMap();	

		//TF
		TIntIntMap tfNumberCellLineNumber2KMap = new TIntIntHashMap();	
		
		//Hg19 RefSeq Genes
		TIntIntMap geneAlternateNumber2KMap = new TIntIntHashMap();	
			
		//KEGGPathway
		TIntObjectMap<TShortArrayList> geneId2ListofKeggPathwayNumberMap = new TIntObjectHashMap<TShortArrayList>();
		KeggPathwayUtility.createNcbiGeneId2ListofKeggPathwayNumberMap(dataFolder, Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, keggPathwayName2KeggPathwayNumberMap,geneId2ListofKeggPathwayNumberMap);
		
		TShortIntMap exonBasedKeggPathway2KMap 			= new TShortIntHashMap();
		TShortIntMap regulationBasedKeggPathway2KMap 	= new TShortIntHashMap();
		TShortIntMap allBasedKeggPathway2KMap 			= new TShortIntHashMap();
				
		//TF KEGGPathway
		TIntIntMap tfExonBasedKeggPathway2KMap 			= new TIntIntHashMap();
		TIntIntMap tfRegulationBasedKeggPathway2KMap 	= new TIntIntHashMap();
		TIntIntMap tfAllBasedKeggPathway2KMap 			= new TIntIntHashMap();

		//TF CellLine KEGGPathway
		TIntIntMap tfCellLineExonBasedKeggPathway2KMap 			= new TIntIntHashMap();
		TIntIntMap tfCellLineRegulationBasedKeggPathway2KMap 	= new TIntIntHashMap();
		TIntIntMap tfCellLineAllBasedKeggPathway2KMap 			= new TIntIntHashMap();
		
		
		//if you want to see the current year and day etc. change the line of code below with:
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		long dateBefore;
		long dateAfter;
		//Not needed
		//Instant dnaseStart,histoneStart,transcriptionFactorStart,KEGGPathwayStart,tfKEGGPathwayStart,tfCellLineKEGGPathwayStart,tfCellLineKEGGPathway_and_TFKEGGPathwayStart;
		//Instant dnaseEnd,histoneEnd,transcriptionFactorEnd,KEGGPathwayEnd,tfKEGGPathwayEnd,tfCellLineKEGGPathwayEnd,tfCellLineKEGGPathway_and_TFKEGGPathwayEnd;
		
		/*****************************************************************************/
		/************DNASE**ANNOTATION****starts**************************************/
		/*****************************************************************************/	
		if (dnaseEnrichmentType.isDnaseEnrichment()){
			
		    
			GlanetRunner.appendLog("CellLine Based DNASE annotation starts: " + new Date());
		    dateBefore = System.currentTimeMillis();
		    
			searchDnaseWithNumbers(dataFolder,outputFolder,dnaseCellLineNumber2KMap,overlapDefinition,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
			writeResultsWithNumbers(dnaseCellLineNumber2KMap, cellLineNumber2CellLineNameMap, outputFolder , Commons.ANNOTATE_INTERVALS_DNASE_RESULTS_GIVEN_SEARCH_INPUT);
			
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("CellLine Based DNASE annotation ends: " + new Date());
			
			GlanetRunner.appendLog("CellLine Based Dnase annotation took: " + (float)((dateAfter - dateBefore)/1000) + " seconds");
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();
			
		}
		/*****************************************************************************/
		/************DNASE***ANNOTATION********ends***********************************/
		/*****************************************************************************/	
		
		
		/*******************************************************************************/
		/************HISTONE****ANNOTATION***starts*************************************/
		/*******************************************************************************/
		if (histoneEnrichmentType.isHistoneEnrichment()){
			
			GlanetRunner.appendLog("CellLine Based Histone annotation starts: " + new Date());
		    
		    dateBefore = System.currentTimeMillis();
		   	searchHistoneWithNumbers(dataFolder,outputFolder,histoneNumberCellLineNumber2KMap,overlapDefinition,histoneNumber2HistoneNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
			writeResultsWithNumbers(histoneNumberCellLineNumber2KMap, histoneNumber2HistoneNameMap, cellLineNumber2CellLineNameMap, outputFolder , Commons.ANNOTATE_INTERVALS_HISTONE_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("CellLine Based Histone annotation ends: " + new Date());
		    
			GlanetRunner.appendLog("CellLine Based Histone annotation took: " + (float)((dateAfter - dateBefore)/1000) +" seconds");				
			GlanetRunner.appendLog("**********************************************************");
			
		    System.gc();
			System.runFinalization();
		
		}
		/*******************************************************************************/
		/************HISTONE*****ANNOTATION***ends**************************************/
		/*******************************************************************************/	
		
	    
	    
	    /*******************************************************************************/
		/************TF******ANNOTATION******starts*************************************/
		/*******************************************************************************/	
		if (tfEnrichmentType.isTfEnrichment() && !(tfKeggPathwayEnrichmentType.isTfGeneSetEnrichment()) && !(tfCellLineKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment())){
			
			GlanetRunner.appendLog("CellLine Based TF annotation starts: " + new Date());
		    
		    dateBefore = System.currentTimeMillis();
			searchTranscriptionFactorWithNumbers(dataFolder,outputFolder,tfNumberCellLineNumber2KMap,overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap);
			writeResultsWithNumbers(tfNumberCellLineNumber2KMap, tfNumber2TfNameMap, cellLineNumber2CellLineNameMap, outputFolder , Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("CellLine Based TF annotation ends: " + new Date());
		    
			GlanetRunner.appendLog("CellLine Based TF annotation took: " + (float)((dateAfter - dateBefore)/1000) +" seconds");				
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();
		}
		/*******************************************************************************/
		/************TF*******ANNOTATION*****ends***************************************/
		/*******************************************************************************/
		
	
		/*******************************************************************************/
		/************HG19 Refseq GENE*****ANNOTATION***starts***************************/
		/*******************************************************************************/	
		GlanetRunner.appendLog("Hg19 RefSeq Gene annotation starts: " + new Date());
		dateBefore = System.currentTimeMillis();
		
		searchGeneWithNumbers(dataFolder,outputFolder,geneAlternateNumber2KMap,overlapDefinition,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
		writeResultsWithNumbers(geneAlternateNumber2KMap, geneHugoSymbolNumber2GeneHugoSymbolNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_GENE_ALTERNATE_NAME_RESULTS_GIVEN_SEARCH_INPUT);
		dateAfter = System.currentTimeMillis();
			
		GlanetRunner.appendLog("Hg19 RefSeq Gene annotation ends: " + new Date());
		    
		GlanetRunner.appendLog("Hg19 RefSeq Gene annotation took: " + (float)((dateAfter - dateBefore)/1000) + " seconds");
		GlanetRunner.appendLog("**********************************************************");
			
		System.gc();
		System.runFinalization();	
		/*******************************************************************************/
		/************HG19 RefSeq GENE*****ANNOTATION***ends*****************************/
		/*******************************************************************************/	
	 
	    
	    /*******************************************************************************/
		/************KEGG PATHWAY*****ANNOTATION***starts*******************************/
		/*******************************************************************************/	
		if (keggPathwayEnrichmentType.isGeneSetEnrichment()&& !(tfKeggPathwayEnrichmentType.isTfGeneSetEnrichment()) && !(tfCellLineKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment())){
		    
			GlanetRunner.appendLog("KEGG Pathway annotation starts: " + new Date());
		
		    dateBefore = System.currentTimeMillis();
		   	searchKEGGPathwayWithNumbers(dataFolder,outputFolder,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,overlapDefinition,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
		   	writeResultsWithNumbers(exonBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(regulationBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(allBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("KEGG Pathway annotation ends: " + new Date());
		    
			GlanetRunner.appendLog("KEGG Pathway annotation took: " + (float)((dateAfter - dateBefore)/1000) + " seconds");
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();

		}
	    /*******************************************************************************/
		/************KEGG PATHWAY****ANNOTATION*ends************************************/
		/*******************************************************************************/	
		
		
	    /*******************************************************************************/
		/************TF KEGGPATHWAY***ANNOTATION*****starts*****************************/
		/*******************************************************************************/
		if (tfKeggPathwayEnrichmentType.isTfGeneSetEnrichment() && !(tfCellLineKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment())){
		    
			GlanetRunner.appendLog("TF KEGGPathway annotation starts: " + new Date());
		    
		    dateBefore = System.currentTimeMillis();
			searchTfKEGGPathwayWithNumbers(dataFolder,outputFolder,tfNumberCellLineNumber2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap, overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
			
			//TF
			writeResultsWithNumbers(tfNumberCellLineNumber2KMap, tfNumber2TfNameMap, cellLineNumber2CellLineNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
			
			//KEGGPathway
			writeResultsWithNumbers(exonBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(regulationBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(allBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);		
			
			//TF KEGGPathway
			writeTFKEGGPathwayResultsWithNumbers(tfExonBasedKeggPathway2KMap, tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeTFKEGGPathwayResultsWithNumbers(tfRegulationBasedKeggPathway2KMap, tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeTFKEGGPathwayResultsWithNumbers(tfAllBasedKeggPathway2KMap,tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder,Commons.ANNOTATE_INTERVALS_TF_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("TF KEGGPathway annotation ends: " + new Date());
			GlanetRunner.appendLog("TF KEGGPathway annotation took: " + (float)((dateAfter - dateBefore)/1000) +" seconds");		
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();

		}
	    /*******************************************************************************/
		/************TF KEGGPATHWAY*****ANNOTATION***ends*******************************/
		/*******************************************************************************/	
	    
	    
	    /*******************************************************************************/
		/************TF CELLLINE KEGGPATHWAY***ANNOTATION*****starts********************/
		/*******************************************************************************/
		if (tfCellLineKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment() && !(tfKeggPathwayEnrichmentType.isTfGeneSetEnrichment())){
			
			GlanetRunner.appendLog("CellLine Based TF KEGGPATHWAY annotation starts: " + new Date());
		    
		    dateBefore = System.currentTimeMillis();
		    searchTfCellLineKEGGPathwayWithNumbers(dataFolder,outputFolder,tfNumberCellLineNumber2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap, overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneId2ListofKeggPathwayNumberMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
			
			//TF
			writeResultsWithNumbers(tfNumberCellLineNumber2KMap, tfNumber2TfNameMap, cellLineNumber2CellLineNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
			
			//KEGGPathway
			writeResultsWithNumbers(exonBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(regulationBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(allBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);		
			
			//TF CellLine KEGGPathway
			writeResultsWithNumbers(tfCellLineExonBasedKeggPathway2KMap,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(tfCellLineRegulationBasedKeggPathway2KMap, tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(tfCellLineAllBasedKeggPathway2KMap,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("CellLine Based TF KEGGPATHWAY annotation ends: " + new Date());
			GlanetRunner.appendLog("CellLine Based TF KEGGPATHWAY annotation took: " + (float)((dateAfter - dateBefore)/1000) + " seconds");	    
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();

		}
	    /*******************************************************************************/
		/************TF CELLLINE KEGGPATHWAY*****ANNOTATION***ends**********************/
		/*******************************************************************************/	
	   
//			//search input interval files for ncbiGeneId		
//			Map<String,Integer> ncbiGeneIdHashMap = new HashMap<String,Integer>();		
//			annotateIntervals.fillHashMap(ncbiGeneIdHashMap,Commons.ANNOTATE_INTERVALS_WITH_NCBI_GENE_ID_USING_INTERVAL_TREE_INPUT_FILE);		
//			annotateIntervals.searchNcbiGeneId(ncbiGeneIdHashMap);
//			annotateIntervals.writeResults(Commons.NCBI_GENE_ID, ncbiGeneIdHashMap, Commons.ANNOTATE_INTERVALS_NCBI_GENE_ID_RESULTS_OUTPUT_FILE);
//			//Free space
//			ncbiGeneIdHashMap.clear();
//			ncbiGeneIdHashMap = null;
//			
//			//ncbiRna		
//			Map<String,Integer> ncbiRnaNucleotideAccessionVersionHashMap = new HashMap<String,Integer>();
//			annotateIntervals.fillHashMap(ncbiRnaNucleotideAccessionVersionHashMap,Commons.ANNOTATE_INTERVALS_WITH_NCBI_RNA_USING_INTERVAL_TREE_INPUT_FILE);
//			annotateIntervals.searchNcbiRNANucleotideAccessionVersion(ncbiRnaNucleotideAccessionVersionHashMap);
//			annotateIntervals.writeResults(Commons.NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION, ncbiRnaNucleotideAccessionVersionHashMap, Commons.ANNOTATE_INTERVALS_NCBI_RNA_NUCLEOTIDE_ACCESSION_VERSION_RESULTS_OUTPUT_FILE);
//			//Free space
//			ncbiRnaNucleotideAccessionVersionHashMap.clear();
//			ncbiRnaNucleotideAccessionVersionHashMap = null;
//			
//			//ucscGeneAlternateName
//			Map<String,Integer> ucscGeneAlternateNameHashMap = new HashMap<String,Integer>();
//			annotateIntervals.fillHashMap(ucscGeneAlternateNameHashMap,Commons.ANNOTATE_INTERVALS_WITH_UCSC_ALTERNATE_GENE_NAME_USING_INTERVAL_TREE_INPUT_FILE);			
//			annotateIntervals.searchUcscGeneAlternateName(ucscGeneAlternateNameHashMap);
//			annotateIntervals.writeResults(Commons.UCSC_GENE_ALTERNATE_NAME, ucscGeneAlternateNameHashMap, Commons.ANNOTATE_INTERVALS_UCSC_GENE_ALTERNATE_NAME_RESULTS_OUTPUT_FILE);
//			//Free space
//			ucscGeneAlternateNameHashMap.clear();
//			ucscGeneAlternateNameHashMap= null;
//			
		
//			Accomplished in NEW FUNCTIONALITY ---TF and Kegg Pathway	
//			//KEGG PATHWAY
//			//Search input interval files for kegg Pathway
//			List<String> keggPathwayNameList = new ArrayList<String>();
//					
//			//Fill keggPathwayNameList
//			fillList(keggPathwayNameList, Commons.WRITE_ALL_POSSIBLE_KEGG_PATHWAY_NAMES_OUTPUT_FILE);
//			
//			Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
//					
//			KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE,geneId2KeggPathwayMap);
//			
//			//Exon Based Kegg Pathway Analysis
//			//Only Exons
//			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//			Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();
//					
//			searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, exonBasedKeggPathway2KMap, Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(exonBasedKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//			
//			
//			//Regulation Based Kegg Pathway Analysis
//			//Introns, 5p1 5p2 3p1 3p2 included
//			//5d and 3d excluded 
//			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
//			Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
//					
//			searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, regulationBasedKeggPathway2KMap, Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(regulationBasedKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
//			
//			//All Based Kegg Pathway Analysis
//			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n
//			//exons, introns, 5p1, 5p2, 5d, 3p1, 3p2, 3d all included
//			Map<String,Integer> allResultsKeggPathway2KMap = new HashMap<String,Integer>();
//							
//			searchKeggPathway(geneId2KeggPathwayMap,keggPathwayNameList, allResultsKeggPathway2KMap, Commons.ALL_BASED_KEGG_PATHWAY_ANALYSIS);
//			writeResults(allResultsKeggPathway2KMap, Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
		
		/*******************************************************************************/
		/************Search input interval files for TF*********************************/
		/************Search input interval files for KEGG PATHWAY***********************/
		/************Search input interval files for TF AND KEGG PATHWAY****************/
		/************Search input interval files for TF AND CELLLINE AND KEGG PATHWAY***/
		/*******************************************************************************/	
		if (tfKeggPathwayEnrichmentType.isTfGeneSetEnrichment() && tfCellLineKeggPathwayEnrichmentType.isTfCellLineGeneSetEnrichment()){
		    
			GlanetRunner.appendLog("Both TFKEGGPathway and TFCellLineKEGGPathway annotation starts: " + new Date());
		    			
		    dateBefore = System.currentTimeMillis();
			searchTfandKeggPathwayWithNumbers(dataFolder,outputFolder,geneId2ListofKeggPathwayNumberMap,tfNumberCellLineNumber2KMap,exonBasedKeggPathway2KMap,regulationBasedKeggPathway2KMap,allBasedKeggPathway2KMap,tfCellLineExonBasedKeggPathway2KMap,tfCellLineRegulationBasedKeggPathway2KMap,tfCellLineAllBasedKeggPathway2KMap,tfExonBasedKeggPathway2KMap,tfRegulationBasedKeggPathway2KMap,tfAllBasedKeggPathway2KMap, overlapDefinition,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,fileNumber2FileNameMap,keggPathwayNumber2KeggPathwayNameMap,geneHugoSymbolNumber2GeneHugoSymbolNameMap,refSeqGeneNumber2RefSeqGeneNameMap);
			
			//TF
			writeResultsWithNumbers(tfNumberCellLineNumber2KMap, tfNumber2TfNameMap, cellLineNumber2CellLineNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_TF_RESULTS_GIVEN_SEARCH_INPUT);
			
			//KEGGPathway
			writeResultsWithNumbers(exonBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(regulationBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(allBasedKeggPathway2KMap, keggPathwayNumber2KeggPathwayNameMap,outputFolder , Commons.ANNOTATE_INTERVALS_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);		
			
			//TF CellLine KEGGPathway
			writeResultsWithNumbers(tfCellLineExonBasedKeggPathway2KMap,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(tfCellLineRegulationBasedKeggPathway2KMap, tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeResultsWithNumbers(tfCellLineAllBasedKeggPathway2KMap,tfNumber2TfNameMap,cellLineNumber2CellLineNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder, Commons.ANNOTATE_INTERVALS_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			
			//TF KEGGPathway
			writeTFKEGGPathwayResultsWithNumbers(tfExonBasedKeggPathway2KMap, tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_EXON_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeTFKEGGPathwayResultsWithNumbers(tfRegulationBasedKeggPathway2KMap, tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap,outputFolder, Commons.ANNOTATE_INTERVALS_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			writeTFKEGGPathwayResultsWithNumbers(tfAllBasedKeggPathway2KMap,tfNumber2TfNameMap,keggPathwayNumber2KeggPathwayNameMap, outputFolder,Commons.ANNOTATE_INTERVALS_TF_ALL_BASED_KEGG_PATHWAY_RESULTS_GIVEN_SEARCH_INPUT);
			dateAfter = System.currentTimeMillis();
			
			GlanetRunner.appendLog("TFCellLineKEGGPathway and  TFKEGGPathway annotation ends: " + new Date());
			GlanetRunner.appendLog("TFCellLineKEGGPathway and  TFKEGGPathway annotation took: " + (float)((dateAfter - dateBefore)/1000) + " seconds");		
			GlanetRunner.appendLog("**********************************************************");
			
			System.gc();
			System.runFinalization();

		}
		/*******************************************************************************/
		/************Search input interval files for TF*********************************/
		/************Search input interval files for KEGG PATHWAY***********************/
		/************Search input interval files for TF AND KEGG PATHWAY****************/
		/************Search input interval files for TF AND CELLLINE AND KEGG PATHWAY***/
		/*******************************************************************************/	

	}
	
	//Empirical P Value Calculation
	//ExecutorService
	public AllMaps annotatPermutation(String dataFolder,Integer permutationNumber, String chrName, List<InputLine> inputLines,IntervalTree dnaseIntervalTree,IntervalTree tfbsIntervalTree,IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGeneIntervalTree){
		AllMaps allMaps = new AllMaps();
		
		//DNASE
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> dnaseCellLine2KMap = new HashMap<String,Integer>();		
//			Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//			searchDnase(permutationNumber,chrName,inputLines, dnaseIntervalTree, dnaseBufferedWriterHashMap, dnaseCellLine2KMap);
		allMaps.setPermutationNumberDnaseCellLineName2KMap(dnaseCellLine2KMap);
		
		//TFBS
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		Map<String,Integer> tfbsNameandCellLineName2KMap = new HashMap<String,Integer>();	
//			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//			searchTfbs(permutationNumber,chrName,inputLines,tfbsIntervalTree,tfbsBufferedWriterHashMap,tfbsNameandCellLineName2KMap);
		allMaps.setPermutationNumberTfNameCellLineName2KMap(tfbsNameandCellLineName2KMap);

		//HISTONE
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> histoneNameandCellLineName2KMap = new HashMap<String,Integer>();	
//			Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//			searchHistone(permutationNumber,chrName,inputLines,histoneIntervalTree,histoneBufferedWriterHashMap,histoneNameandCellLineName2KMap);
		allMaps.setPermutationNumberHistoneNameCellLineName2KMap(histoneNameandCellLineName2KMap);
		
		
		//KEGG PATHWAY
		//Search input interval files for kegg Pathway
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		
		//Exon Based Kegg Pathway Analysis
		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> exonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
//			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//			searchUcscRefSeqGenes(permutationNumber, chrName, inputLines, ucscRefSeqGeneIntervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, exonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.EXON_BASED_KEGG_PATHWAY_ANALYSIS);
		allMaps.setPermutationNumberExonBasedKeggPathway2KMap(exonBasedKeggPathway2KMap);
		
		
		//Regulation Based Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> regulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
//			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
//			searchUcscRefSeqGenes(permutationNumber, chrName, inputLines, ucscRefSeqGeneIntervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, regulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,Commons.REGULATION_BASED_KEGG_PATHWAY_ANALYSIS);
		allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(regulationBasedKeggPathway2KMap);

		return allMaps;
		
	}

	
	public static void closeBufferedWriters(Map<String,BufferedWriter> BufferedWriterHashMap){
		BufferedWriter bufferedWriter  = null;
		for(Map.Entry<String, BufferedWriter> entry: BufferedWriterHashMap.entrySet()){
			try {
				bufferedWriter = entry.getValue();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//TShortObjectMap<BufferedWriter> version
	public static void closeBufferedWritersWithNumbers(TShortObjectMap<BufferedWriter> bufferedWriterHashMap){
		BufferedWriter bufferedWriter  = null;
		for(TShortObjectIterator<BufferedWriter> it = bufferedWriterHashMap.iterator(); it.hasNext(); ){		
			it.advance();			
			try {
				bufferedWriter = it.value();				
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//TIntObjectMap<BufferedWriter> version
	public static void closeBufferedWritersWithNumbers(TIntObjectMap<BufferedWriter> bufferedWriterHashMap){
		BufferedWriter bufferedWriter  = null;
		for(TIntObjectIterator<BufferedWriter> it = bufferedWriterHashMap.iterator(); it.hasNext(); ){
			
			it.advance();
			
			try {
				bufferedWriter = it.value();
				
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//TLongObjectMap<BufferedWriter> version
	public static void closeBufferedWritersWithNumbers(TLongObjectMap<BufferedWriter> bufferedWriterHashMap){
		BufferedWriter bufferedWriter  = null;
		for(TLongObjectIterator<BufferedWriter> it = bufferedWriterHashMap.iterator(); it.hasNext(); ){
			
			it.advance();
			
			try {
				bufferedWriter = it.value();
				
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	//Using fork join framework
	//Empirical P Value Calculation
	//With IO
	public static AllMaps annotatePermutationwithIO(String outputFolder,String dataFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree dnaseIntervalTree, IntervalTree tfbsIntervalTree, IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGenesIntervalTree,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		//DNASE
		//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
		Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
		Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, dnaseIntervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(dnaseBufferedWriterHashMap);
		allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
		
		//TFBS
		//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
		Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,tfbsIntervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(tfbsBufferedWriterHashMap);
		allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		//HISTONE
		//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
		Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,histoneIntervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
		closeBufferedWriters(histoneBufferedWriterHashMap);
		allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		
		//KEGG PATHWAY
		//Search input interval files for kegg Pathway
		Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
		KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
		
		//Exon Based Kegg Pathway Analysis
		//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
		Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
		closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
		allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
		
		
		//Regulation Based Kegg Pathway Analysis
		//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
		Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
		Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
		closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
		allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

		return allMaps;
		
	}
	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	public static AllMaps annotatePermutationwithIO(String outputFolder,int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree,  IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType, EnrichmentType tfandKeggPathwayEnrichmentType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		if (annotationType.isDnaseAnnotation()){
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, intervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(dnaseBufferedWriterHashMap);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
		}else if (annotationType.isTfAnnotation()){
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		}else if (annotationType.isHistoneAnnotation()){
			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(histoneBufferedWriterHashMap);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		}else if (annotationType.isGeneSetAnnotation()){
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			
			//All Based Kegg Pathway Analysis
			//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

		}else if(annotationType.isTfGeneSetAnnotation()){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
			//Will be used	for tf and keggPathway enrichment
			Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
			
			//Will be used 	for tf and keggPathway enrichment
			Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
						
			searchTfandKeggPathway(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,null,null,null,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			
			
			allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
	
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}else if(annotationType.isTfCellLineGeneSetAnnotation()){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
			
			//Will be used	for tf and cellline and keggPathway enrichment
			Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
		
			
			//Will be used 	for tf and cellline and keggPathway enrichment
			Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			
			searchTfandKeggPathway(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,null,null,null,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,null,null,null,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
					
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			
			
			allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
	
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}
			
		return allMaps;
		
	}
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends


	//@todo
	//with Numbers starts
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment starts
	public static AllMapsWithNumbers annotatePermutationwithIOwithNumbers(String outputFolder,int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree,  IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType, EnrichmentType tfandKeggPathwayEnrichmentType, TIntObjectMap<TShortList> geneId2KeggPathwayNumberMap,int overlapDefinition){
		AllMapsWithNumbers allMapsWithNumbers = new AllMapsWithNumbers();
		
		if (annotationType.isDnaseAnnotation()){
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			TIntIntMap permutationNumberDnaseCellLineNumber2KMap = new TIntIntHashMap();		
			TIntObjectMap<BufferedWriter>  dnaseBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 
			searchDnaseWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData, intervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineNumber2KMap,overlapDefinition);
			closeBufferedWritersWithNumbers(dnaseBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberDnaseCellLineNumber2KMap(permutationNumberDnaseCellLineNumber2KMap);
			
		}else if (annotationType.isTfAnnotation()){
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap = new TLongIntHashMap();	
			TLongObjectMap<BufferedWriter> tfBufferedWriterHashMap = new TLongObjectHashMap<BufferedWriter>(); 
			searchTfbsWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,tfBufferedWriterHashMap,permutationNumberTfNumberCellLineNumber2KMap,overlapDefinition);
			closeBufferedWritersWithNumbers(tfBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);

		}else if (annotationType.isHistoneAnnotation()){
			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			TLongIntMap permutationNumberHistoneNumberCellLineNumber2KMap = new TLongIntHashMap();	
			TLongObjectMap<BufferedWriter> histoneBufferedWriterHashMap = new TLongObjectHashMap<BufferedWriter>(); 
			searchHistoneWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNumberCellLineNumber2KMap,overlapDefinition);
			closeBufferedWritersWithNumbers(histoneBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberHistoneNumberCellLineNumber2KMap(permutationNumberHistoneNumberCellLineNumber2KMap);
		
		}else if (annotationType.isGeneSetAnnotation()){
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			TIntIntMap permutationNumberExonBasedKeggPathway2KMap = new TIntIntHashMap();	
			TIntObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 
			searchUcscRefSeqGenesWithNumbers(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayNumberMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWritersWithNumbers(exonBasedKeggPathwayBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			TIntIntMap permutationNumberRegulationBasedKeggPathway2KMap = new TIntIntHashMap();
			TIntObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 
			searchUcscRefSeqGenesWithNumbers(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayNumberMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWritersWithNumbers(regulationBasedKeggPathwayBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			
			//All Based Kegg Pathway Analysis
			//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			TIntIntMap permutationNumberAllBasedKeggPathway2KMap = new TIntIntHashMap();
			TIntObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new TIntObjectHashMap<BufferedWriter>(); 
			searchUcscRefSeqGenesWithNumbers(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayNumberMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWritersWithNumbers(allBasedKeggPathwayBufferedWriterHashMap);
			allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

		}else if(annotationType.isTfGeneSetAnnotation()){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap = new TLongIntHashMap();	
			
			TIntIntMap permutationNumberExonBasedKeggPathway2KMap 		= new TIntIntHashMap();	
			TIntIntMap permutationNumberRegulationBasedKeggPathway2KMap = new TIntIntHashMap();
			TIntIntMap permutationNumberAllBasedKeggPathway2KMap 		= new TIntIntHashMap();
			
			//Will be used	for tf and keggPathway enrichment
			TLongIntMap permutationNumberTfNumberExonBasedKeggPathway2KMap 		= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathway2KMap 	= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberAllBasedKeggPathway2KMap 		= new TLongIntHashMap();
			
			TLongObjectMap<BufferedWriter> tfBufferedWriterHashMap 							= new TLongObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>(); 
					
			//Will be used 	for tf and keggPathway enrichment
			TLongObjectMap<BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
						
			searchTfandKeggPathwayWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,null,null,null,geneId2KeggPathwayNumberMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfNumberExonBasedKeggPathway2KMap,permutationNumberTfNumberRegulationBasedKeggPathway2KMap,permutationNumberTfNumberAllBasedKeggPathway2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWritersWithNumbers(tfBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWritersWithNumbers(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
			allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);
			allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
						
			allMapsWithNumbers.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfNumberExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfNumberRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfNumberAllBasedKeggPathway2KMap);
				
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}else if(annotationType.isTfCellLineGeneSetAnnotation()){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality

			//TF Enrichment
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap 		= new TLongIntHashMap();	
			
			//KEGG PATHWAY Enrichment
			TIntIntMap permutationNumberExonBasedKeggPathway2KMap 		= new TIntIntHashMap();	
			TIntIntMap permutationNumberRegulationBasedKeggPathway2KMap = new TIntIntHashMap();
			TIntIntMap permutationNumberAllBasedKeggPathway2KMap 		= new TIntIntHashMap();
			
			
			//TF and CELLLINE and KEGG Pathway enrichment
			TLongIntMap permutationNumberTfCellLineExonBasedKeggPathway2KMap 			= new TLongIntHashMap();
			TLongIntMap permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new TLongIntHashMap();
			TLongIntMap permutationNumberTfCellLineAllBasedKeggPathway2KMap 			= new TLongIntHashMap();
			
			
			//TF BufferedWriters
			TLongObjectMap<BufferedWriter> tfBufferedWriterHashMap 							= new TLongObjectHashMap<BufferedWriter>();
			
			//KEGG Pathway BufferedWriters
			TIntObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>(); 
		
			
			//TF CELLINE KEGG Pathway BufferedWriters
			TLongObjectMap<BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			
			searchTfandKeggPathwayWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,null,null,null,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayNumberMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,null,null,null,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			closeBufferedWritersWithNumbers(tfBufferedWriterHashMap);
			
			closeBufferedWritersWithNumbers(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(allBasedKeggPathwayBufferedWriterHashMap);
			
			closeBufferedWritersWithNumbers(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
					
			
			allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);
			
			allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
						
			allMapsWithNumbers.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);		
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}else if (annotationType.isBothTfGeneSetAndTfCellLineGeneSetAnnotation()){
			
			//TF Enrichment
			TLongIntMap permutationNumberTfNumberCellLineNumber2KMap 		= new TLongIntHashMap();	
			
			//KEGGPathway Enrichment
			TIntIntMap permutationNumberExonBasedKeggPathway2KMap 		= new TIntIntHashMap();	
			TIntIntMap permutationNumberRegulationBasedKeggPathway2KMap = new TIntIntHashMap();
			TIntIntMap permutationNumberAllBasedKeggPathway2KMap 		= new TIntIntHashMap();
			
			//TF KEGGPathway Enrichment
			TLongIntMap permutationNumberTfNumberExonBasedKeggPathway2KMap 			= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathway2KMap 	= new TLongIntHashMap();
			TLongIntMap permutationNumberTfNumberAllBasedKeggPathway2KMap 			= new TLongIntHashMap();
			
			//TF CELLLINE KEGGPathway Enrichment
			TLongIntMap permutationNumberTfCellLineExonBasedKeggPathway2KMap 			= new TLongIntHashMap();
			TLongIntMap permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new TLongIntHashMap();
			TLongIntMap permutationNumberTfCellLineAllBasedKeggPathway2KMap 			= new TLongIntHashMap();
			
			
			//TF BufferedWriters
			TLongObjectMap<BufferedWriter> tfBufferedWriterHashMap 							= new TLongObjectHashMap<BufferedWriter>();
			
			//KEGGPathway BufferedWriters
			TIntObjectMap<BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap 		= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap 	= new TIntObjectHashMap<BufferedWriter>(); 
			TIntObjectMap<BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap 			= new TIntObjectHashMap<BufferedWriter>(); 
		
			//TF KEGGPathway BufferedWriters
			TLongObjectMap<BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
		
			
			//TF CELLINE KEGGPathway BufferedWriters
			TLongObjectMap<BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap 	= new TLongObjectHashMap<BufferedWriter>(); 
			TLongObjectMap<BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap 			= new TLongObjectHashMap<BufferedWriter>(); 
			
			searchTfandKeggPathwayWithNumbers(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayNumberMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfNumberExonBasedKeggPathway2KMap,permutationNumberTfNumberRegulationBasedKeggPathway2KMap,permutationNumberTfNumberAllBasedKeggPathway2KMap,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);
			
			//TF
			closeBufferedWritersWithNumbers(tfBufferedWriterHashMap);
			
			//KEGG
			closeBufferedWritersWithNumbers(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(allBasedKeggPathwayBufferedWriterHashMap);
			
			//TF KEGG
			closeBufferedWritersWithNumbers(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfAllBasedKeggPathwayBufferedWriterHashMap);
		
			
			//TF CELLLINE KEGG
			closeBufferedWritersWithNumbers(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWritersWithNumbers(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
					
			//TF
			allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);
			
			//KEGG
			allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			
			//TF KEGG
			allMapsWithNumbers.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfNumberExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfNumberRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfNumberAllBasedKeggPathway2KMap);
			
			//TF CELLLINE KEGG
			allMapsWithNumbers.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMapsWithNumbers.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
	
		}
			
		return allMapsWithNumbers;
		
	}
	
	
	//Tf and KeggPathway Enrichment or
	//Tf and CellLine and KeggPathway Enrichment ends
	//with number ends
	
		
	//Start adding NEW FUNCITIONALITY
	//Each time one interval tree
	//Using fork join framework
	//Empirical P Value Calculation
	//With IO
	public static AllMaps annotatePermutationwithIO(String outputFolder,int repeatNumber,int permutationNumber,int NUMBER_OF_PERMUTATIONS, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree,  IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
		AllMaps allMaps = new AllMaps();
		
		if (annotationType.isDnaseAnnotation()){
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			Map<String,BufferedWriter> dnaseBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchDnase(outputFolder,permutationNumber,chrName,randomlyGeneratedData, intervalTree, dnaseBufferedWriterHashMap, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(dnaseBufferedWriterHashMap);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
		}else if (annotationType.isTfAnnotation()){
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchTfbs(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,tfbsBufferedWriterHashMap,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

		}else if (annotationType.isHistoneAnnotation()){
			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> histoneBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchHistone(outputFolder,permutationNumber,chrName,randomlyGeneratedData,intervalTree,histoneBufferedWriterHashMap,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			closeBufferedWriters(histoneBufferedWriterHashMap);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
		
		}else if (annotationType.isGeneSetAnnotation()){
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, exonBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, regulationBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			
			//All Based Kegg Pathway Analysis
			//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			searchUcscRefSeqGenes(outputFolder,permutationNumber, chrName, randomlyGeneratedData, intervalTree, allBasedKeggPathwayBufferedWriterHashMap, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

		}else if(annotationType.isTfCellLineGeneSetAnnotation() || annotationType.isTfGeneSetAnnotation()){
			
			//start adding new functionality	
			/***************************************************************************/
			/***************************************************************************/
			//New Functionality
			//TF and Kegg Pathway
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 			= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
			Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
			
			Map<String,BufferedWriter> tfbsBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> exonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> regulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> allBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfCellLineAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfExonBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfRegulationBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			Map<String,BufferedWriter> tfAllBasedKeggPathwayBufferedWriterHashMap = new HashMap<String,BufferedWriter>(); 
			
			
			searchTfandKeggPathway(outputFolder,repeatNumber,permutationNumber,NUMBER_OF_PERMUTATIONS,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,tfbsBufferedWriterHashMap, exonBasedKeggPathwayBufferedWriterHashMap, regulationBasedKeggPathwayBufferedWriterHashMap, allBasedKeggPathwayBufferedWriterHashMap,tfCellLineExonBasedKeggPathwayBufferedWriterHashMap,tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap,tfCellLineAllBasedKeggPathwayBufferedWriterHashMap, tfExonBasedKeggPathwayBufferedWriterHashMap,tfRegulationBasedKeggPathwayBufferedWriterHashMap,tfAllBasedKeggPathwayBufferedWriterHashMap,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,overlapDefinition);
			
			closeBufferedWriters(tfbsBufferedWriterHashMap);
			closeBufferedWriters(exonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(regulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(allBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfCellLineAllBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfExonBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfRegulationBasedKeggPathwayBufferedWriterHashMap);
			closeBufferedWriters(tfAllBasedKeggPathwayBufferedWriterHashMap);
			
			
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
			allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
			
			
			/***************************************************************************/
			/***************************************************************************/
			//start adding new functionality
		}
			
		return allMaps;
		
	}

	
		//All 4 types of interval trees are sent full
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(String dataFolder,int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree dnaseIntervalTree, IntervalTree tfbsIntervalTree, IntervalTree histoneIntervalTree,IntervalTree ucscRefSeqGenesIntervalTree,int overlapDefinition){
			AllMaps allMaps = new AllMaps();
			
			//DNASE
			//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
			Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
			searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, dnaseIntervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
			
			//TFBS
			//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
			searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,tfbsIntervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

			//HISTONE
			//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
			Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
			searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,histoneIntervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
			allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
			
			
			//KEGG PATHWAY
			//Search input interval files for kegg Pathway
			Map<String,List<String>> geneId2KeggPathwayMap = new HashMap<String, List<String>>();
			KeggPathwayUtility.createNcbiGeneId2KeggPathwayMap(dataFolder,Commons.KEGG_PATHWAY_2_NCBI_GENE_IDS_INPUT_FILE, geneId2KeggPathwayMap);
			
			//Exon Based Kegg Pathway Analysis
			//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
			searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
			
			//Regulation Based Kegg Pathway Analysis
			//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
			Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
			searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, ucscRefSeqGenesIntervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
			allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

			return allMaps;
			
		}

		
		//new starts there is a parameter called tfandKeggPathwayEnrichmentType
		//TF_AND_KEGGPATHWAY_ENRICHMENT OR
		//TF_AND_CELLLINE_AND_KEGGPATHWAY_ENRICHMENT
		//Not both enrichment at the same time
		//each time one interval tree EXCEPT NEW FUNCTIONALITY
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree, IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType,EnrichmentType tfandKeggPathwayEnrichmentType, Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
				AllMaps allMaps = new AllMaps();
					
				if (annotationType.isDnaseAnnotation()){
					//DNASE
					//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
					Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
					searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, intervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
					
				}else if (annotationType.isTfAnnotation()){
					//TFBS
					//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

				}else if (annotationType.isHistoneAnnotation()){
					//HISTONE
					//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
					Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
					searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
					allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
					
				}else if (annotationType.isGeneSetAnnotation()){
					//KEGG PATHWAY
					//Search input interval files for kegg Pathway
						
					//Exon Based Kegg Pathway Analysis
					//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					
					//Regulation Based Kegg Pathway Analysis
					//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

					//All Based Kegg Pathway Analysis
					//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

					
				}else if (annotationType.isTfGeneSetAnnotation()){
					
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF and Kegg Pathway
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					
					
					//Will be used 	for tf and keggPathway enrichment
					Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
						
					searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);	
					
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
					
					allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
								
					
					
					/***************************************************************************/
					/***************************************************************************/
					
				}else if (annotationType.isTfCellLineGeneSetAnnotation()){
					
					
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF and Kegg Pathway
					Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
					
					Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
					Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
					
					
					//Will be used	for tf and cellLine and keggPathway enrichment					
					Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
					Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
						
					searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,null,null,null,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);	
					
					allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
					
					allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
					allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
								
					
					
					/***************************************************************************/
					/***************************************************************************/
					
				}
							
				return allMaps;
				
		}
		//new ends
		
		
		//with numbers starts
		//new starts there is a parameter called tfandKeggPathwayEnrichmentType
		//TF_AND_KEGGPATHWAY_ENRICHMENT OR
		//TF_AND_CELLLINE_AND_KEGGPATHWAY_ENRICHMENT
		//Not both enrichment at the same time
		//each time one interval tree EXCEPT NEW FUNCTIONALITY
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		//with Numbers
		public static AllMapsWithNumbers annotatePermutationwithoutIOwithNumbers(int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree, IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType,EnrichmentType tfandKeggPathwayEnrichmentType, TIntObjectMap<TShortList> geneId2KeggPathwayMap,int overlapDefinition){
				AllMapsWithNumbers allMapsWithNumbers = new AllMapsWithNumbers();
					
				if (annotationType.isDnaseAnnotation()){
					//DNASE
					//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
					TIntIntMap permutationNumberDnaseCellLineNumber2KMap = new TIntIntHashMap();		
					searchDnasewithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData, intervalTree, permutationNumberDnaseCellLineNumber2KMap,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberDnaseCellLineNumber2KMap(permutationNumberDnaseCellLineNumber2KMap);
					
				}else if (annotationType.isTfAnnotation()){
					//TFBS
					//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
					TLongIntMap permutationNumberTfNumberCellLineNumber2KMap = new TLongIntHashMap();	
					searchTfbswithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberTfNumberCellLineNumber2KMap,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);

				}else if (annotationType.isHistoneAnnotation()){
					//HISTONE
					//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
					TLongIntMap permutationNumberHistoneNumberCellLineNumber2KMap = new TLongIntHashMap();	
					searchHistonewithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberHistoneNumberCellLineNumber2KMap,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberHistoneNumberCellLineNumber2KMap(permutationNumberHistoneNumberCellLineNumber2KMap);
					
				}else if (annotationType.isGeneSetAnnotation()){
					//KEGG PATHWAY
					//Search input interval files for kegg Pathway
						
					//Exon Based Kegg Pathway Analysis
					//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					TIntIntMap permutationNumberExonBasedKeggPathwayNumber2KMap = new TIntIntHashMap();	
					searchUcscRefSeqGeneswithoutIOwithNumbers(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathwayNumber2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathwayNumber2KMap);
					
					//Regulation Based Kegg Pathway Analysis
					//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					TIntIntMap permutationNumberRegulationBasedKeggPathwayNumber2KMap = new TIntIntHashMap();
					searchUcscRefSeqGeneswithoutIOwithNumbers(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathwayNumber2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathwayNumber2KMap);

					//All Based Kegg Pathway Analysis
					//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
					TIntIntMap permutationNumberAllBasedKeggPathwayNumber2KMap = new TIntIntHashMap();
					searchUcscRefSeqGeneswithoutIOwithNumbers(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathwayNumber2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
					allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathwayNumber2KMap);

					
				}else if (annotationType.isTfGeneSetAnnotation()){
					
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF
					TLongIntMap permutationNumberTfNumberCellLineNumber2KMap 			= new TLongIntHashMap();	
					
					//KEGG
					TIntIntMap permutationNumberExonBasedKeggPathwayNumber2KMap 		= new TIntIntHashMap();	
					TIntIntMap permutationNumberRegulationBasedKeggPathwayNumber2KMap 	= new TIntIntHashMap();
					TIntIntMap permutationNumberAllBasedKeggPathwayNumber2KMap 			= new TIntIntHashMap();
										
					//TF KEGG
					TLongIntMap permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap 			= new TLongIntHashMap();
					TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
					TLongIntMap permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap 			= new TLongIntHashMap();
						
					searchTfandKeggPathwaywithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathwayNumber2KMap,permutationNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberAllBasedKeggPathwayNumber2KMap,permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap,permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap,null,null,null,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					//TF
					allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);	
					
					//KEGG
					allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathwayNumber2KMap);
					
					//TF KEGG
					allMapsWithNumbers.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap);					
					/***************************************************************************/
					/***************************************************************************/
					
				}else if (annotationType.isTfCellLineGeneSetAnnotation()){
										
					/***************************************************************************/
					/***************************************************************************/
					//New Functionality
					//TF
					TLongIntMap  permutationNumberTfNumberCellLineNumber2KMap = new TLongIntHashMap();	
					
					//KEGG
					TIntIntMap permutationNumberExonBasedKeggPathwayNumber2KMap 		= new TIntIntHashMap();	
					TIntIntMap  permutationNumberRegulationBasedKeggPathwayNumber2KMap 	= new TIntIntHashMap();
					TIntIntMap  permutationNumberAllBasedKeggPathwayNumber2KMap 		= new TIntIntHashMap();
											
					//TF CELLINE KEGG					
					TLongIntMap  permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
					TLongIntMap  permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap 	= new TLongIntHashMap();
					TLongIntMap  permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
						
					searchTfandKeggPathwaywithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathwayNumber2KMap,permutationNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberAllBasedKeggPathwayNumber2KMap,null,null,null,permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				
					
					//TF
					allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);	
					
					//KEGG
					allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathwayNumber2KMap);
					
					//TF CELLLINE KEGG
					allMapsWithNumbers.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap);													
					/***************************************************************************/
					/***************************************************************************/
					
				}else if(annotationType.isBothTfGeneSetAndTfCellLineGeneSetAnnotation()){
					
					//TF
					TLongIntMap  permutationNumberTfNumberCellLineNumber2KMap = new TLongIntHashMap();	
					
					//KEGG
					TIntIntMap  permutationNumberExonBasedKeggPathwayNumber2KMap 		= new TIntIntHashMap();	
					TIntIntMap  permutationNumberRegulationBasedKeggPathwayNumber2KMap 	= new TIntIntHashMap();
					TIntIntMap  permutationNumberAllBasedKeggPathwayNumber2KMap 		= new TIntIntHashMap();
				
					//TF KEGG
					TLongIntMap permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap 			= new TLongIntHashMap();
					TLongIntMap permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
					TLongIntMap permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap 			= new TLongIntHashMap();
							
					//TF CELLLINE KEGG
					TLongIntMap  permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
					TLongIntMap  permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap 	= new TLongIntHashMap();
					TLongIntMap  permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap 		= new TLongIntHashMap();
						
					searchTfandKeggPathwaywithoutIOwithNumbers(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfNumberCellLineNumber2KMap,permutationNumberExonBasedKeggPathwayNumber2KMap,permutationNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberAllBasedKeggPathwayNumber2KMap,permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap,permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap,permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap,permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap,permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap,Commons.NCBI_GENE_ID,tfandKeggPathwayEnrichmentType,overlapDefinition);				

					//TF
					allMapsWithNumbers.setPermutationNumberTfNumberCellLineNumber2KMap(permutationNumberTfNumberCellLineNumber2KMap);	
					
					//KEGG
					allMapsWithNumbers.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathwayNumber2KMap);
					
					//TF KEGG
					allMapsWithNumbers.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfNumberAllBasedKeggPathwayNumber2KMap);
					
					//TF CELLINE KEGG
					allMapsWithNumbers.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberExonBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberRegulationBasedKeggPathwayNumber2KMap);
					allMapsWithNumbers.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfNumberCellLineNumberAllBasedKeggPathwayNumber2KMap);
					
				}
							
				return allMapsWithNumbers;
				
		}	
		//with numbers ends
		
		//there is NO parameter called tfandKeggPathwayEnrichmentType
		//each time one interval tree EXCEPT NEW FUNCTIONALITY
		//Using fork join framework
		//Empirical P Value Calculation
		//Without IO
		public static AllMaps annotatePermutationwithoutIO(int permutationNumber, ChromosomeName chrName, List<InputLine> randomlyGeneratedData,IntervalTree intervalTree, IntervalTree ucscRefSeqGenesIntervalTree, AnnotationType annotationType,Map<String,List<String>> geneId2KeggPathwayMap,int overlapDefinition){
			AllMaps allMaps = new AllMaps();
				
			if (annotationType.isDnaseAnnotation()){
				//DNASE
				//This dnaseCellLine2KMap hash map will contain the dnase cell line name to number of dnase cell line:k for the given search input size:n
				Map<String,Integer> permutationNumberDnaseCellLineName2KMap = new HashMap<String,Integer>();		
				searchDnasewithoutIO(permutationNumber,chrName,randomlyGeneratedData, intervalTree, permutationNumberDnaseCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberDnaseCellLineName2KMap(permutationNumberDnaseCellLineName2KMap);
				
			}else if (annotationType.isTfAnnotation()){
				//TFBS
				//This tfbsNameandCellLineName2KMap hash map will contain the tfbsNameandCellLineName to number of tfbsNameandCellLineName: k for the given search input size: n
				Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
				searchTfbswithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberTfbsNameCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);

			}else if (annotationType.isHistoneAnnotation()){
				//HISTONE
				//This histoneNameandCellLineName2KMap hash map will contain the histoneNameandCellLineName to number of histoneNameandCellLineName: k for the given search input size: n
				Map<String,Integer> permutationNumberHistoneNameCellLineName2KMap = new HashMap<String,Integer>();	
				searchHistonewithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,permutationNumberHistoneNameCellLineName2KMap,overlapDefinition);
				allMaps.setPermutationNumberHistoneNameCellLineName2KMap(permutationNumberHistoneNameCellLineName2KMap);
				
			}else if (annotationType.isGeneSetAnnotation()){
				//KEGG PATHWAY
				//Search input interval files for kegg Pathway
					
				//Exon Based Kegg Pathway Analysis
				//This exonBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberExonBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.EXONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
				
				//Regulation Based Kegg Pathway Analysis
				//This regulationBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberRegulationBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.REGULATIONBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);

				//All Based Kegg Pathway Analysis
				//This allBasedKeggPathway2KMap hash map will contain the kegg pathway name to number of kegg pathway:k for the given search input size:n		
				Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
				searchUcscRefSeqGeneswithoutIO(permutationNumber, chrName, randomlyGeneratedData, intervalTree, geneId2KeggPathwayMap, permutationNumberAllBasedKeggPathway2KMap, Commons.NCBI_GENE_ID,KeggPathwayAnalysisType.ALLBASEDKEGGPATHWAYANALYSIS,overlapDefinition);
				allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);

				
			} else if (annotationType.isTfCellLineGeneSetAnnotation() || annotationType.isTfGeneSetAnnotation()){
				
				
				/***************************************************************************/
				/***************************************************************************/
				//New Functionality
				//TF and Kegg Pathway
				Map<String,Integer> permutationNumberTfbsNameCellLineName2KMap = new HashMap<String,Integer>();	
				
				Map<String,Integer> permutationNumberExonBasedKeggPathway2KMap = new HashMap<String,Integer>();	
				Map<String,Integer> permutationNumberRegulationBasedKeggPathway2KMap = new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberAllBasedKeggPathway2KMap = new HashMap<String,Integer>();
			
				Map<String,Integer> permutationNumberTfCellLineExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfCellLineRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfCellLineAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				
				Map<String,Integer> permutationNumberTfExonBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfRegulationBasedKeggPathway2KMap 	= new HashMap<String,Integer>();
				Map<String,Integer> permutationNumberTfAllBasedKeggPathway2KMap 		= new HashMap<String,Integer>();
				
				searchTfandKeggPathwaywithoutIO(permutationNumber,chrName,randomlyGeneratedData,intervalTree,ucscRefSeqGenesIntervalTree,geneId2KeggPathwayMap,permutationNumberTfbsNameCellLineName2KMap,permutationNumberExonBasedKeggPathway2KMap,permutationNumberRegulationBasedKeggPathway2KMap,permutationNumberAllBasedKeggPathway2KMap,permutationNumberTfCellLineExonBasedKeggPathway2KMap,permutationNumberTfCellLineRegulationBasedKeggPathway2KMap,permutationNumberTfCellLineAllBasedKeggPathway2KMap,permutationNumberTfExonBasedKeggPathway2KMap,permutationNumberTfRegulationBasedKeggPathway2KMap,permutationNumberTfAllBasedKeggPathway2KMap,Commons.NCBI_GENE_ID,overlapDefinition);
				
				allMaps.setPermutationNumberTfNameCellLineName2KMap(permutationNumberTfbsNameCellLineName2KMap);
				
				allMaps.setPermutationNumberExonBasedKeggPathway2KMap(permutationNumberExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberRegulationBasedKeggPathway2KMap(permutationNumberRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberAllBasedKeggPathway2KMap(permutationNumberAllBasedKeggPathway2KMap);
				
				allMaps.setPermutationNumberTfCellLineExonBasedKeggPathway2KMap(permutationNumberTfCellLineExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfCellLineRegulationBasedKeggPathway2KMap(permutationNumberTfCellLineRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfCellLineAllBasedKeggPathway2KMap(permutationNumberTfCellLineAllBasedKeggPathway2KMap);
				
				allMaps.setPermutationNumberTfExonBasedKeggPathway2KMap(permutationNumberTfExonBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfRegulationBasedKeggPathway2KMap(permutationNumberTfRegulationBasedKeggPathway2KMap);
				allMaps.setPermutationNumberTfAllBasedKeggPathway2KMap(permutationNumberTfAllBasedKeggPathway2KMap);
				/***************************************************************************/
				/***************************************************************************/
				
			}
						
			return allMaps;
			
	}
		
		
		//args[0]	--->	Input File Name with folder
		//args[1]	--->	GLANET installation folder with "\\" at the end. This folder will be used for outputFolder and dataFolder.
		//args[2]	--->	Input File Format	
		//			--->	default	Commons.INPUT_FILE_FORMAT_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
		//			--->			Commons.INPUT_FILE_FORMAT_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
		//			--->			Commons.INPUT_FILE_FORMAT_DBSNP_IDS_0_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE
		//			--->			Commons.INPUT_FILE_FORMAT_BED_0_BASED_COORDINATES_START_INCLUSIVE_END_EXCLUSIVE
		//			--->			Commons.INPUT_FILE_FORMAT_GFF3_1_BASED_COORDINATES_START_INCLUSIVE_END_INCLUSIVE	
		//args[3]	--->	Annotation, overlap definition, number of bases, default 1
		//args[4]	--->	Enrichment parameter
		//			--->	default	Commons.DO_ENRICH
		//			--->			Commons.DO_NOT_ENRICH	
		//args[5]	--->	Generate Random Data Mode
		//			--->	default	Commons.GENERATE_RANDOM_DATA_WITH_MAPPABILITY_AND_GC_CONTENT
		//			--->			Commons.GENERATE_RANDOM_DATA_WITHOUT_MAPPABILITY_AND_GC_CONTENT	
		//args[6]	--->	multiple testing parameter, enriched elements will be decided and sorted with respest to this parameter
		//			--->	default Commons.BENJAMINI_HOCHBERG_FDR_ADJUSTED_P_VALUE
		//			--->			Commons.BONFERRONI_CORRECTED_P_VALUE
		//args[7]	--->	Bonferroni Correction Significance Level, default 0.05
		//args[8]	--->	Benjamini Hochberg FDR, default 0.05
		//args[9]	--->	Number of permutations, default 5000
		//args[10]	--->	Dnase Enrichment
		//			--->	default Commons.DO_NOT_DNASE_ENRICHMENT
		//			--->	Commons.DO_DNASE_ENRICHMENT
		//args[11]	--->	Histone Enrichment
		//			--->	default	Commons.DO_NOT_HISTONE_ENRICHMENT
		//			--->			Commons.DO_HISTONE_ENRICHMENT
		//args[12]	--->	Transcription Factor(TF) Enrichment 
		//			--->	default	Commons.DO_NOT_TF_ENRICHMENT
		//			--->			Commons.DO_TF_ENRICHMENT
		//args[13]	--->	KEGG Pathway Enrichment
		//			--->	default	Commons.DO_NOT_KEGGPATHWAY_ENRICHMENT 
		//			--->			Commons.DO_KEGGPATHWAY_ENRICHMENT
		//args[14]	--->	TF and KEGG Pathway Enrichment
		//			--->	default	Commons.DO_NOT_TF_KEGGPATHWAY_ENRICHMENT 
		//			--->			Commons.DO_TF_KEGGPATHWAY_ENRICHMENT
		//args[15]	--->	TF and CellLine and KeggPathway Enrichment
		//			--->	default	Commons.DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT 
		//			--->			Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
		//args[16]	--->	RSAT parameter
		//			--->	default Commons.DO_NOT_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
		//			--->			Commons.DO_REGULATORY_SEQUENCE_ANALYSIS_USING_RSAT
		//args[17]	--->	job name example: ocd_gwas_snps 
		//args[18]	--->	writeGeneratedRandomDataMode checkBox
		//			--->	default Commons.DO_NOT_WRITE_GENERATED_RANDOM_DATA
		//			--->			Commons.WRITE_GENERATED_RANDOM_DATA
		//args[19]	--->	writePermutationBasedandParametricBasedAnnotationResultMode checkBox
		//			--->	default Commons.DO_NOT_WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
		//			--->			Commons.WRITE_PERMUTATION_BASED_AND_PARAMETRIC_BASED_ANNOTATION_RESULT
		//args[20]	--->	writePermutationBasedAnnotationResultMode checkBox
		//			---> 	default	Commons.DO_NOT_WRITE_PERMUTATION_BASED_ANNOTATION_RESULT
		//			--->			Commons.WRITE_PERMUTATION_BASED_ANNOTATION_RESULT			
		//args[21]	--->	number of permutations in each run
		public static void main(String[] args) {
		
			AnnotateGivenIntervalsWithNumbersWithChoices annotateIntervals = new AnnotateGivenIntervalsWithNumbersWithChoices();
			annotateIntervals.annotate(args);
		}


}