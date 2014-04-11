/**
 * @author burcakotlu
 * @date Apr 2, 2014 
 * @time 5:01:25 PM
 */
package jaxbxjctool;

import intervaltree.IntervalTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import auxiliary.FileOperations;

import common.Commons;

/**
 * 
 */
public class GenerationofSequencesandMatricesforGivenIntervals {
	
	
	
	
	public static void constructLogoMatricesfromEncodeMotifs(String dataFolder,String encodeMotifsInputFileName,Map<String,String>  tfName2LogoMatrices){
		
		FileReader fileReader ;
		BufferedReader bufferedReader;
		String strLine;
					
		//Attention order is important!
		//Order is ACGT
		String tfName = null;
		
		
		try {
				fileReader = new FileReader(dataFolder +  encodeMotifsInputFileName);
				bufferedReader = new BufferedReader(fileReader);
				
				while((strLine = bufferedReader.readLine())!=null){
					
//					Encode-motif matrix
//					Order is ACGT					
//					>NFKB_disc1 NFKB1_GM19193_encode-Snyder_seq_hsa_IgG-rab_r1:MDscan#1#Intergenic
//					K 0.000000 0.000000 0.737500 0.262500
//					G 0.000000 0.000000 1.000000 0.000000
//					G 0.000000 0.000000 1.000000 0.000000
//					R 0.570833 0.000000 0.429167 0.000000
//					A 0.837500 0.158333 0.004167 0.000000
//					W 0.395833 0.000000 0.000000 0.604167
//					T 0.000000 0.004167 0.000000 0.995833
//					Y 0.000000 0.383333 0.000000 0.616667
//					C 0.000000 1.000000 0.000000 0.000000
//					C 0.000000 1.000000 0.000000 0.000000
					
					
					if (strLine.startsWith(">")){
						
						//start reading from first character, skip '>' character
						tfName = strLine.substring(1);
						
						if (tfName2LogoMatrices.get(tfName)==null){
							tfName2LogoMatrices.put(tfName, strLine+ System.getProperty("line.separator"));
							
						}else{
							tfName2LogoMatrices.put(tfName, tfName2LogoMatrices.get(tfName)+ strLine + System.getProperty("line.separator"));	
						}
							
					}//End of if
						
						
						
					else{
						tfName2LogoMatrices.put(tfName, tfName2LogoMatrices.get(tfName)+ strLine+ System.getProperty("line.separator"));
					}
						
				}//end of while
				

				
				bufferedReader.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void constructPfmMatricesfromEncodeMotifs(String dataFolder,String encodeMotifsInputFileName,Map<String,String> tfName2PfmMatrices){
		FileReader fileReader ;
		BufferedReader bufferedReader;
		String strLine;
		
		int indexofFirstBlank;
		int indexofSecondBlank;
		int indexofThirdBlank;
		int indexofFourthBlank;
		
		float _AFrequency;
		float _CFrequency;
		float _GFrequency;
		float _TFrequency;
		
		
		List<PositionFrequency> positionfrequencyList = new ArrayList<PositionFrequency>();;
		
		//Attention
		//Order is ACGT
		String ALine = "";
		String CLine = "";
		String GLine = "";
		String TLine = "";
		
		
		String tfName = null;
		String formerTfName = null;
		
		Iterator<PositionFrequency> iterator;
		
		try {
				fileReader = new FileReader(dataFolder + encodeMotifsInputFileName);
				bufferedReader = new BufferedReader(fileReader);
				
				while((strLine = bufferedReader.readLine())!=null){
					
//					Encode-motif matrix
//					Order is ACGT					
//					>NFKB_disc1 NFKB1_GM19193_encode-Snyder_seq_hsa_IgG-rab_r1:MDscan#1#Intergenic
//					K 0.000000 0.000000 0.737500 0.262500
//					G 0.000000 0.000000 1.000000 0.000000
//					G 0.000000 0.000000 1.000000 0.000000
//					R 0.570833 0.000000 0.429167 0.000000
//					A 0.837500 0.158333 0.004167 0.000000
//					W 0.395833 0.000000 0.000000 0.604167
//					T 0.000000 0.004167 0.000000 0.995833
//					Y 0.000000 0.383333 0.000000 0.616667
//					C 0.000000 1.000000 0.000000 0.000000
//					C 0.000000 1.000000 0.000000 0.000000
					
					
					if (strLine.startsWith(">")){
						
						
						//start reading from first character, skip '>' character
						tfName = strLine.substring(1);
							
						if(formerTfName!=null){
							//Write former positionfrequencyList to the output file starts
							//if it is full
							ALine ="A |\t";
							CLine ="C |\t";
							GLine ="G |\t";
							TLine ="T |\t";
									
							iterator = positionfrequencyList.iterator();
							
							while(iterator.hasNext()){
								PositionFrequency positionFrequency = (PositionFrequency) iterator.next();
								ALine = ALine + positionFrequency.get_AFrequency() + "\t";
								CLine = CLine + positionFrequency.get_CFrequency() + "\t";
								GLine = GLine + positionFrequency.get_GFrequency() + "\t";
								TLine = TLine + positionFrequency.get_TFrequency() + "\t";
							}
							
							
							//We must have the former tfName
							//We must have inserted the header line
							tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + ALine +System.getProperty("line.separator"));
							tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + CLine +System.getProperty("line.separator"));
							tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + GLine +System.getProperty("line.separator"));
							tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + TLine +System.getProperty("line.separator"));
							tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + "//"  +System.getProperty("line.separator"));
							//Write former full pfList to the output file ends
						}//End of if
						
						
						//if tfName is inserted for the first time
						if (tfName2PfmMatrices.get(tfName)==null){
							tfName2PfmMatrices.put(tfName, "; " + strLine.substring(1) + System.getProperty("line.separator"));
						}
						//else start appending the new coming matrix to the already existing matrices for this tfName
						else{
							tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "; " + strLine.substring(1) + System.getProperty("line.separator"));
						}
						
						//Initialize positionfrequencyList
						positionfrequencyList = new ArrayList<PositionFrequency>();
						
					}else{
						
						indexofFirstBlank 	= strLine.indexOf(' ');
						indexofSecondBlank 	= strLine.indexOf(' ',indexofFirstBlank+1);
						indexofThirdBlank 	= strLine.indexOf(' ',indexofSecondBlank+1);
						indexofFourthBlank 	= strLine.indexOf(' ',indexofThirdBlank+1);
						
						_AFrequency = Float.parseFloat(strLine.substring(indexofFirstBlank+1, indexofSecondBlank));
						_CFrequency = Float.parseFloat(strLine.substring(indexofSecondBlank+1, indexofThirdBlank));
						_GFrequency = Float.parseFloat(strLine.substring(indexofThirdBlank+1, indexofFourthBlank));
						_TFrequency	= Float.parseFloat(strLine.substring(indexofFourthBlank+1));
						
						PositionFrequency positionFrequency = new PositionFrequency(_AFrequency,_CFrequency,_GFrequency,_TFrequency);
						positionfrequencyList.add(positionFrequency);
						formerTfName = tfName;
					}
						
				}//end of while
				
				//Write the last positionFrequencyList starts
				//Order is ACGT
				ALine ="A |\t";
				CLine ="C |\t";
				GLine ="G |\t";
				TLine ="T |\t";
			
				iterator = positionfrequencyList.iterator();
				
				while(iterator.hasNext()){
					PositionFrequency positionFrequency = (PositionFrequency) iterator.next();
					ALine = ALine + positionFrequency.get_AFrequency() + "\t";
					CLine = CLine + positionFrequency.get_CFrequency() + "\t";
					GLine = GLine + positionFrequency.get_GFrequency() + "\t";
					TLine = TLine + positionFrequency.get_TFrequency() + "\t";
				}
				
				
				//We must use former tfName
				//We must have inserted the header line
				tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + ALine +System.getProperty("line.separator"));
				tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + CLine +System.getProperty("line.separator"));
				tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + GLine +System.getProperty("line.separator"));
				tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + TLine +System.getProperty("line.separator"));
				tfName2PfmMatrices.put(formerTfName, tfName2PfmMatrices.get(formerTfName)  + "//"  +System.getProperty("line.separator"));
				//Write the last positionFrequencyList ends
				
				bufferedReader.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void fillFrequencyListUsingCountList(List<Float> frequencyList, List<Integer> countList,Integer totalCount){
		
		Iterator<Integer> iterator = countList.iterator();
		
		Integer count;
		Float frequency;
		
		
		while(iterator.hasNext()){
			
			count = iterator.next();
			frequency = (count*1.0f)/totalCount;
			
			frequencyList.add(frequency);
			
			
		}
		
		
	}
	
	
	//Fill CountList using CountLine
		public static void fillCountList(String countLine,List<Integer> countList){
			//example Count line
			//4	19	0	0	0	0		
			int indexofFormerTab =0;
			int indexofLatterTab =0;
			
			int count =0;
			
			indexofFormerTab = 0;
			indexofLatterTab = countLine.indexOf('\t');
			
			
			//Insert the first count
			if (indexofLatterTab>=0){
				count = Integer.parseInt(countLine.substring(indexofFormerTab, indexofLatterTab));
				countList.add(count);			
			}
			
			
			indexofFormerTab = indexofLatterTab;
			indexofLatterTab = countLine.indexOf('\t',indexofFormerTab+1);

			
			//Insert the rest of the counts
			while(indexofLatterTab>=0){
				
				count = Integer.parseInt(countLine.substring(indexofFormerTab+1, indexofLatterTab));
				
				countList.add(count);
				
				indexofFormerTab = indexofLatterTab;
				indexofLatterTab = countLine.indexOf('\t',indexofFormerTab+1);
				
			}
			
			//Insert the last count
			if(indexofFormerTab>=0){
				count = Integer.parseInt(countLine.substring(indexofFormerTab+1));
				countList.add(count);
				
			}
		
		}
		
		public static int getTotalCount(List<Integer> ACountList,List<Integer> CCountList,List<Integer> GCountList,List<Integer>TCountList){
			
			Iterator<Integer> iteratorA = ACountList.iterator();
			Integer countA;
			
			
			Iterator<Integer> iteratorC = CCountList.iterator();
			Integer countC;
			
			Iterator<Integer> iteratorG = GCountList.iterator();
			Integer countG;
			
			Iterator<Integer> iteratorT = TCountList.iterator();
			Integer countT;
		
			int totalCount = 0;;
			
			while(iteratorA.hasNext() && iteratorC.hasNext() && iteratorG.hasNext() && iteratorT.hasNext()  ){
				
				countA = iteratorA.next();
				countC = iteratorC.next();
				countG = iteratorG.next();
				countT = iteratorT.next();
				
				totalCount = countA + countC + countG + countT;
				return totalCount;
				
			
				
			}
			
			return totalCount;
			
			
		}
	
		public static void putPFM(String tfName,List<Float> AFrequencyList,List<Float> CFrequencyList,List<Float> GFrequencyList,List<Float> TFrequencyList,Map<String,String> tfName2PfmMatrices){
			
			//example matrix in tab format
			//		; NFKB_known3	NFKB_1	NF-kappaB_transfac_M00054														
			//		A |	0	0	0.025	0.675	0.525	0.2	0.025	0.05	0.075	0						
			//		C |	0	0	0	0	0.325	0.025	0.05	0.45	0.9	0.95						
			//		G |	1	1	0.975	0.325	0.025	0.075	0.05	0	0	0						
			//		T |	0	0	0	0	0.125	0.7	0.875	0.5	0.025	0.05						
			//		//			
			
			Iterator<Float> iteratorA = AFrequencyList.iterator();
			Iterator<Float> iteratorC = CFrequencyList.iterator();
			Iterator<Float> iteratorG = GFrequencyList.iterator();
			Iterator<Float> iteratorT = TFrequencyList.iterator();
			
			Float frequencyA;
			Float frequencyC;
			Float frequencyG;
			Float frequencyT;
			
			String strLineA = "";
			String strLineC = "";
			String strLineG = "";
			String strLineT = "";
			
			while(iteratorA.hasNext() && iteratorC.hasNext() && iteratorG.hasNext() && iteratorT.hasNext()){
				
				frequencyA = iteratorA.next();
				frequencyC = iteratorC.next();
				frequencyG = iteratorG.next();
				frequencyT = iteratorT.next();
				
				strLineA = strLineA  + "\t"  + frequencyA;
				strLineC = strLineC  + "\t"  + frequencyC;
				strLineG = strLineG  + "\t"  + frequencyG;
				strLineT = strLineT  + "\t"  + frequencyT;
				
			}//end of while

			
			//this tfName has no previous position frequency matrix inserted
			if(tfName2PfmMatrices.get(tfName)==null){
				tfName2PfmMatrices.put(tfName, "; " + tfName + System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "A|"+ strLineA+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "C|"+ strLineC+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "G|"+ strLineG+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "T|"+ strLineT+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "//"+  System.getProperty("line.separator"));
				
			}
			//this tfName already has position frequency matrices
			//append the new position frequency matrix
			else{
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "; " + tfName + System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "A|"+ strLineA+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "C|"+ strLineC+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "G|"+ strLineG+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "T|"+ strLineT+  System.getProperty("line.separator"));
				tfName2PfmMatrices.put(tfName, tfName2PfmMatrices.get(tfName) + "//"+  System.getProperty("line.separator"));
					
			}

			
			
			
		}
		
		public static void putLogoMatrix(String tfName,List<Float> AFrequencyList,List<Float> CFrequencyList,List<Float> GFrequencyList,List<Float> TFrequencyList,Map<String,String> tfName2LogoMatrices){
			
//			Example logo matrix
//			G 0.008511 0.004255 0.987234 0.000000		
//			A 0.902127 0.012766 0.038298 0.046809		
//			R 0.455319 0.072340 0.344681 0.127660		
//			W 0.251064 0.085106 0.085106 0.578724		
//			T 0.000000 0.046809 0.012766 0.940425		
//			G 0.000000 0.000000 1.000000 0.000000		
//			T 0.038298 0.021277 0.029787 0.910638		
//			A 0.944681 0.004255 0.051064 0.000000		
//			G 0.000000 0.000000 1.000000 0.000000		
//			T 0.000000 0.000000 0.012766 0.987234		

			Iterator<Float> iteratorA = AFrequencyList.iterator();
			Iterator<Float> iteratorC = CFrequencyList.iterator();
			Iterator<Float> iteratorG = GFrequencyList.iterator();
			Iterator<Float> iteratorT = TFrequencyList.iterator();
			
			Float frequencyA;
			Float frequencyC;
			Float frequencyG;
			Float frequencyT;
		
			String strLine = null;
			
			if (tfName2LogoMatrices.get(tfName) == null){
				tfName2LogoMatrices.put(tfName, tfName + System.getProperty("line.separator"));		
			}
			
			else{
				tfName2LogoMatrices.put(tfName,tfName2LogoMatrices.get(tfName)+ tfName + System.getProperty("line.separator"));			
			}
				
				
				
			while(iteratorA.hasNext() && iteratorC.hasNext() && iteratorG.hasNext() && iteratorT.hasNext()){
				
				frequencyA = iteratorA.next();
				frequencyC = iteratorC.next();
				frequencyG = iteratorG.next();
				frequencyT = iteratorT.next();
				
				strLine = "X" + "\t" + frequencyA + "\t" + frequencyC + "\t" + frequencyG + "\t" + frequencyT +System.getProperty("line.separator");
				tfName2LogoMatrices.put(tfName, tfName2LogoMatrices.get(tfName) + strLine);
				
				
			}//end of while

		
		}


	public static void constructPfmMatricesandLogoMatricesfromJasparCore(String dataFolder,String jasparCoreInputFileName,Map<String,String> tfName2PfmMatrices,Map<String,String>  tfName2LogoMatrices){
		//Attention
		//Order is ACGT
				
		FileReader fileReader ;
		BufferedReader bufferedReader;
		String strLine;
		
		
		String tfName = null;
		
		int whichLine = 0;
		
		final int headerLine= 0;
		final int ALine = 1;
		final int CLine = 2;
		final int GLine = 3;
		final int TLine = 4;
		
		List<Integer> ACountList = null;
		List<Float>	AFrequencyList = null;
		
		List<Integer> CCountList = null;
		List<Float>	CFrequencyList = null;
		
		List<Integer> GCountList = null;
		List<Float>	GFrequencyList = null;
	
		List<Integer> TCountList = null;
		List<Float>	TFrequencyList = null;
		
		int totalCount;
	
		try {
			fileReader = new FileReader(dataFolder + jasparCoreInputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			
//			Example matrix from jaspar core pfm_all.txt
//			>MA0004.1 Arnt																													
//			4	19	0	0	0	0																								
//			16	0	20	0	0	0																								
//			0	1	0	20	0	20																								
//			0	0	0	0	20	0																								

			
			while((strLine = bufferedReader.readLine())!=null){
				if (strLine.startsWith(">")){
					tfName = strLine.substring(1);
					
					//Initialize array lists
					//for the new coming position count matrix and position frequency matrix
					ACountList = new ArrayList<Integer>();
					AFrequencyList = new ArrayList<Float>();
					
					CCountList = new ArrayList<Integer>();
					CFrequencyList = new ArrayList<Float>();
					
					GCountList = new ArrayList<Integer>();
					GFrequencyList = new ArrayList<Float>();
				
					TCountList = new ArrayList<Integer>();
					TFrequencyList = new ArrayList<Float>();
					
					whichLine = ALine;
					continue;
				}
				
				switch(whichLine){			
					case ALine:	{	
									fillCountList(strLine,ACountList);
									whichLine = CLine;
									break;
								}
											
					case CLine:	{
									fillCountList(strLine,CCountList);							
									whichLine = GLine;
									break;
								}
										
					case GLine: {		
									fillCountList(strLine,GCountList);					
									whichLine = TLine;
									break;
								}
						
					case TLine:{
									fillCountList(strLine,TCountList);		
									whichLine = headerLine;
									
									//Since count lists are available
									//Then compute frequency lists
									totalCount = getTotalCount(ACountList,CCountList,GCountList,TCountList);
									fillFrequencyListUsingCountList(AFrequencyList,ACountList,totalCount);
									fillFrequencyListUsingCountList(CFrequencyList,CCountList,totalCount);
									fillFrequencyListUsingCountList(GFrequencyList,GCountList,totalCount);
									fillFrequencyListUsingCountList(TFrequencyList,TCountList,totalCount);
									
									//Now put the new matrix to the hashmap in tab format
									putPFM(tfName,AFrequencyList,CFrequencyList,GFrequencyList,TFrequencyList,tfName2PfmMatrices);
									
									//Put the transpose of the matrix for logo generation
									putLogoMatrix(tfName,AFrequencyList,CFrequencyList,GFrequencyList,TFrequencyList,tfName2LogoMatrices);
//									writeLogoMatrix(tfName,AFrequencyList,CFrequencyList,GFrequencyList,TFrequencyList,bufferedWriter);
	
									break;
									
								}
										
				}//End of switch
							
			}//End of while
			
			bufferedReader.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static String getTfNamewithoutNumber(String tfName){
		
		int n = tfName.length();
		char c;
		int i;
		
		for (i = 0; i < n; i++) {
		    c = tfName.charAt(i);
		    if (Character.isDigit(c)){
		    	break;
		    }
		}
		
		return tfName.substring(0, i);
	}
	
	
	public static void createTfIntervalsFile(String outputFolder,String directoryBase,String snpDirectory,String fileName, List<String> snpBasedTfIntervalKeyList, Map<String,TfKeggPathwayTfInterval> tfKeggPathwayBasedTfIntervalMap){
		
		TfKeggPathwayTfInterval tfInterval;
		int tfIntervalStartZeroBased;
		int tfIntervalEndZeroBased;
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
	
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + directoryBase + snpDirectory + System.getProperty("file.separator") + fileName + ".txt");	
			bufferedWriter = new BufferedWriter(fileWriter);
						
			for(String tfIntervalKey : snpBasedTfIntervalKeyList ){
	
				//get tfInterval
				tfInterval = tfKeggPathwayBasedTfIntervalMap.get(tfIntervalKey);
				
				tfIntervalStartZeroBased = tfInterval.getStartZeroBased();
				tfIntervalEndZeroBased = tfInterval.getEndZeroBased();
								
				bufferedWriter.write(tfInterval.getTfNameCellLineName() +  "\t" + "chr" + tfInterval.getChrNamewithoutPreceedingChr() + " \t" + tfIntervalStartZeroBased + "\t" +tfIntervalEndZeroBased + System.getProperty("line.separator"));				
						
			}//End of file for each tf interval overlapping with this snp
		
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static void createSequenceFile(String outputFolder,String directoryBase, String sequenceFileDirectory, String fileName,String sequence){
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		int indexofLineSeparator;
		String firstLineofFastaFile;
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + directoryBase + sequenceFileDirectory + System.getProperty("file.separator") + fileName + ".txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			indexofLineSeparator = sequence.indexOf(System.getProperty("line.separator"));
			
			//fastaFile is sent
			if(indexofLineSeparator!=-1){
				firstLineofFastaFile = sequence.substring(0, indexofLineSeparator);
				
				bufferedWriter.write(firstLineofFastaFile + "\t" +fileName + System.getProperty("line.separator"));
				bufferedWriter.write(sequence.substring(indexofLineSeparator+1).trim());
			
			}
			//only sequence is sent
			else{
				bufferedWriter.write(fileName + System.getProperty("line.separator"));
				bufferedWriter.write(sequence);
	
			}
			
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getAlteredSequence(String precedingSNP,String allele,String followingSNP){
		
		if(!allele.equals(Commons.STRING_HYPHEN)){
			return precedingSNP + allele + followingSNP;
		}
		
		return null;
		
	}
	
public static String takeComplementforeachAllele(String allele){
		
		String complementedAllele = "";
		
		for(char nucleotide: allele.toCharArray()){
			switch(nucleotide) {
				case 'A':
				case 'a': 	complementedAllele = complementedAllele + "T";
							break;
							
				case 'C':
				case 'c': 	complementedAllele = complementedAllele + "G";
							break;
							
				case 'G':
				case 'g': 	complementedAllele = complementedAllele + "C";
							break;
							
				case 'T':
				case 't': 	complementedAllele = complementedAllele + "A";
							break;
							
				default : return null;			
							
			}//End of switch
		}//End of for
		
		return complementedAllele;
	}

	public static String takeComplement(String alleles){
		int indexofFormerTab;
		int indexofLatterTab;
		
		String allele;
		String complementedAllele = null;
		String complementedAlleles =  "";
		
		indexofFormerTab = alleles.indexOf('\t');
		
		//get the first allele
		allele = alleles.substring(0,indexofFormerTab);
		
		//take the complement of this allele
		complementedAllele = takeComplementforeachAllele(allele);
		
		if(complementedAllele!=null){
			complementedAlleles = complementedAlleles + complementedAllele + "\t";
		}
		
		indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);

		while(indexofFormerTab!=-1 && indexofLatterTab!=-1){
			allele = alleles.substring(indexofFormerTab+1, indexofLatterTab);
			
			//take the complement of this allele
			complementedAllele = takeComplementforeachAllele(allele);
			
			if(complementedAllele!=null){
				complementedAlleles = complementedAlleles + complementedAllele + "\t";
			}
			
			
			indexofFormerTab = indexofLatterTab;
			indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);
		}
		
		//get the last allele
		allele = alleles.substring(indexofFormerTab+1);
		//take the complement of this allele
		complementedAllele = takeComplementforeachAllele(allele);
		
		if(complementedAllele!=null){
			complementedAlleles = complementedAlleles + complementedAllele + "\t";
		}
	
				
		
		
				
		return complementedAlleles;
		
	}
	
	public static List<String> findOtherObservedAllelesandGetAltereSequences(char snp, String alleles,String precedingSNP,String followingSNP){
		
		List<String> alteredSnpSequences;
		
		String complementedAlleles;
		
			
		//We must decide whether we can use alleles 
		//or we must use the complement of the alleles
		//if snp is equal to the one of these alleles then use alleles
		//else use the complement of alleles
		if (useAlleles(snp,alleles)){
			alteredSnpSequences = getAlteredSnpSequences(snp,alleles,precedingSNP,followingSNP);
		}else {
			complementedAlleles = takeComplement(alleles);
			alteredSnpSequences = getAlteredSnpSequences(snp,complementedAlleles,precedingSNP,followingSNP);	
		}
			
		
		return alteredSnpSequences;
	}
	

	
	public static List<String> getAlteredSNPSequences(String referenceSequence, List<String> observedAlleles,int oneBasedSnpPosition){
		
		String precedingSNP;
		String followingSNP;
		char snp;
		
		
		List<String> alteredSnpSequences;
		List<String> allAlteredSnpSequences = new ArrayList<String>();
				
		//snpPosition is at Commons.SNP_POSITION; (one-based)
				
		//precedingSNP is 14 characters long
		precedingSNP = referenceSequence.substring(0, oneBasedSnpPosition-1);
		
		//followingSNP is 14 characters long
		followingSNP = referenceSequence.substring(oneBasedSnpPosition);
		
		//snp
		snp = referenceSequence.charAt(oneBasedSnpPosition-1);
				
		//take each possible observed alleles
		//C\tT\t
		
		for(String alleles: observedAlleles){
			
			//Find the other alleles other than normal nucleotide
			alteredSnpSequences = findOtherObservedAllelesandGetAltereSequences(snp,alleles,precedingSNP,followingSNP);
			
			allAlteredSnpSequences.addAll(alteredSnpSequences);
			
		}
	
		return allAlteredSnpSequences;
	}
	
	
	public static List<String>  getAlteredSnpSequences(char snp, String alleles,String precedingSNP,String followingSNP){
		
		int indexofFormerTab;
		int indexofLatterTab;
		
		String allele;
		String alteredSnpSequence;
		List<String> alteredSnpSequences = new ArrayList<String>();
		
		indexofFormerTab = alleles.indexOf('\t');
				
		//get the first allele
		allele = alleles.substring(0,indexofFormerTab);
		
		//check for this first allele
		if (!sameAllele(snp,allele)){
			alteredSnpSequence = getAlteredSequence(precedingSNP,allele,followingSNP);
			
			if (alteredSnpSequence!=null){
				alteredSnpSequences.add(alteredSnpSequence);
			}
		}
		
		indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);

		while(indexofFormerTab!=-1 && indexofLatterTab!=-1){
			allele = alleles.substring(indexofFormerTab+1, indexofLatterTab);
			
			//check for this allele
			if (!sameAllele(snp,allele)){
				alteredSnpSequence = getAlteredSequence(precedingSNP,allele,followingSNP);
				
				if (alteredSnpSequence!=null){
					alteredSnpSequences.add(alteredSnpSequence);
				}
			}
			
			indexofFormerTab = indexofLatterTab;
			indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);
		}
		
		//get the last allele
		allele = alleles.substring(indexofFormerTab+1);
		
		//check for this last allele
		if (!sameAllele(snp,allele)){
			alteredSnpSequence = getAlteredSequence(precedingSNP,allele,followingSNP);
			
			if (alteredSnpSequence!=null){
				alteredSnpSequences.add(alteredSnpSequence);
			}
		}
		
		return alteredSnpSequences;
	}

	public static boolean sameAllele(char snp,String allele){
		if(allele.isEmpty()){
			return false;
		}else if (allele.length()>1){
			return false;
		}else if (allele.equals(Commons.STRING_HYPHEN)){
			return false;
		}else if(allele.charAt(0)==snp){
			return true;
		}
		
		return false;
		
	}
	
	//if snp exists in any of tab delimited alleles useAlleles return true
	//else useAlleles return false
	public static boolean useAlleles(char snp,String alleles){
		//alleles is composed by allele each is seperated by tab
		//A\tC\tG\t
		
		int indexofFormerTab;
		int indexofLatterTab;
		
		String allele;
		
		indexofFormerTab = alleles.indexOf('\t');
		
		//get the first allele
		allele = alleles.substring(0,indexofFormerTab);
				
		//check for this first allele
		if (sameAllele(snp,allele)){
			return true;
		}
		
		indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);

		while(indexofFormerTab!=-1 && indexofLatterTab!=-1){
			allele = alleles.substring(indexofFormerTab+1, indexofLatterTab);
			
			//check for this allele
			if (sameAllele(snp,allele)){
				return true;
			}
			
			indexofFormerTab = indexofLatterTab;
			indexofLatterTab = alleles.indexOf('\t',indexofFormerTab+1);
		}
		
		//get the last allele
		allele = alleles.substring(indexofFormerTab+1);
		
		//check for this last allele
		if (sameAllele(snp,allele)){
			return true;
		}
		
				
		return false;
		
	}
	
	public static void createObservedAllelesFile(String outputFolder,String directoryBase, String observedAllelesFileDirectory, String fileName,List<String> observedAlleles){
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + directoryBase + observedAllelesFileDirectory + System.getProperty("file.separator") + fileName + ".txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			
			for(String observedAllele: observedAlleles){
				bufferedWriter.write(observedAllele + System.getProperty("line.separator"));	
			}
			
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createPeakSequencesFile(String outputFolder, String directoryBase,String sequenceFileDirectory, String fileName, String peakName, String peakSequence){

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		int indexofFirstLineSeparator;
		String firstLineofFastaFile;
		
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + directoryBase + sequenceFileDirectory + System.getProperty("file.separator") + fileName + ".txt",true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			indexofFirstLineSeparator = peakSequence.indexOf(System.getProperty("line.separator"));
			firstLineofFastaFile = peakSequence.substring(0,indexofFirstLineSeparator);
					
			bufferedWriter.write(firstLineofFastaFile + "\t" +peakName + System.getProperty("line.separator"));
			bufferedWriter.write(peakSequence.substring(indexofFirstLineSeparator+1).trim());
	
			
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void createMatrixFile(String outputFolder,String directoryBase, String tfNameKeggPathwayName, String matrixName,String matrix){
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = FileOperations.createFileWriter(outputFolder + directoryBase + tfNameKeggPathwayName + System.getProperty("file.separator") +matrixName + ".txt",true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(matrix);
			
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	//Requires chrName without preceeding "chr" string 
	//Requires oneBased coordinates
	public static String  getDNASequence(String chrNamewithoutPreceedingChr,int startOneBased, int endOneBased,Map<String,String> chrName2RefSeqIdforGrch37Map){
		
		String sourceHTML = null;
		String refSeqId;
		
		refSeqId = chrName2RefSeqIdforGrch37Map.get(chrNamewithoutPreceedingChr);
				
	  
	  //System.out.println("EFETCH RESULT:");
	  // Read from the URL
	  try
	  { 
		  	String eFetchString="http://www.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=nucleotide&id="+ refSeqId + "&seq_start="+ startOneBased + "&seq_stop=" + endOneBased + "&rettype=fasta&retmode=text";
		  	URL url= new URL(eFetchString);
		
	   	 	BufferedReader in= new BufferedReader(new InputStreamReader(url.openStream()));
	        String inputLine;       // one line of the result, as it is read line by line
	        sourceHTML= "";  // will eventually contain the whole result
	        // Continue to read lines while there are still some left to read
	        
	        //Pay attention
	        //Each line including last line has new line character at the end.
	        while ((inputLine= in.readLine()) != null)  // read one line of the input stream
	            { sourceHTML+= inputLine + System.getProperty("line.separator");            // add this line to end of the whole shebang
	//	              ++lineCount;                              // count the number of lines read
	            }
	        
	        // Close the connection
	        in.close();
	  }catch (Exception e){ 
		  System.out.println("Error reading from the URL:");
		  System.out.println(e);
	  }
	  
	
	  return sourceHTML;
	}

	
	
	//
	public static String convertSlashSeparatedAllelestoTabSeparatedAlleles(String observedAllelesSeparatedwithSlash){
		
		int indexofFormerSlash = 0;
		int indexofLatterSlash = observedAllelesSeparatedwithSlash.indexOf('/');
		
		String allele;
		String observedAllelesSeparatedwithTabs = "";
		
		//for the first allele
		allele = observedAllelesSeparatedwithSlash.substring(indexofFormerSlash,indexofLatterSlash);
		
		//update
		observedAllelesSeparatedwithTabs = observedAllelesSeparatedwithTabs + allele + "\t";
		
		indexofFormerSlash = indexofLatterSlash ;		
		indexofLatterSlash = observedAllelesSeparatedwithSlash.indexOf('/',indexofFormerSlash+1);
	
				
		
		if (indexofFormerSlash>=0 && indexofLatterSlash >=0){
			
			allele = observedAllelesSeparatedwithSlash.substring(indexofFormerSlash+1, indexofLatterSlash);	
			observedAllelesSeparatedwithTabs = observedAllelesSeparatedwithTabs + allele + "\t";			
		
			indexofFormerSlash = indexofLatterSlash ;			
			indexofLatterSlash = observedAllelesSeparatedwithSlash.indexOf('/',indexofFormerSlash+1);
			
		}
		
		//for the last allele
		allele = observedAllelesSeparatedwithSlash.substring(indexofFormerSlash+1);	
		observedAllelesSeparatedwithTabs = observedAllelesSeparatedwithTabs + allele;
		
		return observedAllelesSeparatedwithTabs;
			
	}
	
	
	public static boolean alreadyExists(String observedAllelesSeparatedbyTabs,List<String> observedAlleles){
		
		Boolean exists = false;
		
		
		for(String allele:observedAlleles){
			if (observedAllelesSeparatedbyTabs.equals(allele)){
				exists = true;
				break;
			}
		}
		
		return exists;
		
	}
		
	
	public static void add(String chrNamewithoutChr,int zeroBasedCoordinate, String observedAllelesSeparatedbyTabs,Map<String, List<String>> chrNamewithoutChrandZeroBasedCoordinate2ObservedAlleles){
		String key = chrNamewithoutChr + "_"  + zeroBasedCoordinate;
		
		List<String> observedAlleles = chrNamewithoutChrandZeroBasedCoordinate2ObservedAlleles.get(key);
		
		if (observedAlleles==null){
			observedAlleles = new ArrayList<String>();			
			observedAlleles.add(observedAllelesSeparatedbyTabs);
			chrNamewithoutChrandZeroBasedCoordinate2ObservedAlleles.put(key, observedAlleles);
		} else {
			
			if (!observedAlleles.contains(observedAllelesSeparatedbyTabs)){
				observedAlleles.add(observedAllelesSeparatedbyTabs);			
			}
//			if (!alreadyExists(observedAllelesSeparatedbyTabs,observedAlleles)){
//				observedAlleles.add(observedAllelesSeparatedbyTabs);
//			}
		}
		
	}
	
	
	public static String getDirectoryBase(String enrichmentType){
		
		String directoryBase = null;
		
			switch(enrichmentType){
			
				case Commons.TF_EXON_BASED_KEGG_PATHWAY:{			
					directoryBase = Commons.TF_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;	
					break;
				}
				
				case Commons.TF_REGULATION_BASED_KEGG_PATHWAY:{				
					directoryBase = Commons.TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;			
					break;
				}
					
				case Commons.TF_ALL_BASED_KEGG_PATHWAY:{			
					directoryBase = Commons.TF_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;			
					break;
				}	
				
				case Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY:{
					directoryBase = Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;		
					break;
				}
				
				case Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY:{
					directoryBase = Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;					
					break;
				}
				
				case Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY:{
					directoryBase = Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;					
					break;
				}
			
			} // End of switch

		return directoryBase;
	}
	
	public static String getDNASequenceFromFastaFile(String fastaFile){
		String referenceSequence;
		int indexofFirstLineSeparator;
		
		indexofFirstLineSeparator = fastaFile.indexOf(System.getProperty("line.separator"));
		referenceSequence = fastaFile.substring(indexofFirstLineSeparator+1).trim();
		
		return referenceSequence;
		
		
		
	}
	
	
	public static void getSNPBasedPeakSequence(List<String> snpBasedTfIntervalKeyList,Map<String,TfKeggPathwayTfInterval> tfKeggPathwayBasedTfIntervalMap,String chrNamewithoutPreceedingChr,Map<String,String> chrName2RefSeqIdforGrch37Map,String outputFolder, String directoryBase,String tfNameKeggPathwayNameBased_SnpDirectory,String snpKeyString){
		
		//initialize  min and max tf intervals
		int minTfIntervalStartZeroBased = Integer.MAX_VALUE;
		int maxTfIntervalEndZeroBased = Integer.MIN_VALUE;
		
		int tfIntervalStartZeroBased;
		int tfIntervalEndZeroBased;
		
		String tfExtendedPeakSequence;
		TfKeggPathwayTfInterval tfInterval;
					
		for(String tfIntervalKey : snpBasedTfIntervalKeyList ){

			//get tfInterval
			tfInterval = tfKeggPathwayBasedTfIntervalMap.get(tfIntervalKey);
			
			tfIntervalStartZeroBased = tfInterval.getStartZeroBased();
			tfIntervalEndZeroBased = tfInterval.getEndZeroBased();
			
			if (tfIntervalStartZeroBased < minTfIntervalStartZeroBased){
				minTfIntervalStartZeroBased = tfIntervalStartZeroBased;
			}
			
			if (tfIntervalEndZeroBased > maxTfIntervalEndZeroBased){
				maxTfIntervalEndZeroBased = tfIntervalEndZeroBased;
			}		
					
		}//End of file for each tf interval overlapping with this snp
		
		
		tfExtendedPeakSequence = getDNASequence(chrNamewithoutPreceedingChr,minTfIntervalStartZeroBased+1, maxTfIntervalEndZeroBased+1,chrName2RefSeqIdforGrch37Map);
		
		//write snp based extended peak sequence file
		createPeakSequencesFile(outputFolder,directoryBase,tfNameKeggPathwayNameBased_SnpDirectory,"extendedPeakSequence","extendedPeak",tfExtendedPeakSequence);

	}
	
	
	public static List<String> findTfIntervalsOverlappingWithThisSNP(List<String> tfIntervalKeyList, Map<String,TfKeggPathwayTfInterval> tfIntervalMap,int snpZeroBasedCoordinate){
		
		List<String> snpBasedTfIntervalKeyList = new ArrayList<String>();
		TfKeggPathwayTfInterval tfInterval;
		
		for(String tfIntervalKey: tfIntervalKeyList ){
			tfInterval = tfIntervalMap.get(tfIntervalKey);
						
			if (IntervalTree.overlaps(tfInterval.getStartZeroBased(), tfInterval.getEndZeroBased(), snpZeroBasedCoordinate, snpZeroBasedCoordinate)){
				snpBasedTfIntervalKeyList.add(tfIntervalKey);
			}
		}
		
		return snpBasedTfIntervalKeyList;
		
	}
		
	
	public static void readAugmentedDataWriteSequencesandMatrices(AugmentationofGivenIntervalwithRsIds augofGivenInterval, AugmentationofGivenRsIdwithInformation augofGivenRsId,Map<String,String> chrName2RefSeqIdforGrch37Map, String outputFolder,String augmentedInputFileName, Map<String,String> tfName2PfmMatrices, Map<String,String> tfName2LogoMatrices,String enrichmentType){
		
		FileReader augmentedFileReader;
		BufferedReader augmentedBufferedReader;
				
		String strLine;
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
			
		int indexofUnderscore;
			
		String chrNamewithPreceedingChr = null;
		String chrNamewithoutPreceedingChr = null;
				
		int givenIntervalStartZeroBased;
		int givenIntervalEndZeroBased;
		
		int givenIntervalStartOneBased;
		int givenIntervalEndOneBased;

		int tfStart_ZeroBased;
		int tfEnd_ZeroBased;
						
		String tfNameCellLineName;
		
		String tfName;
		String tfNamewithoutNumber;
		
		//These variables will be used jointly 
		//for Tf CellLine KeggPathway and
		//for Tf KeggPathway 
		String tfNameKeggPathwayName;
						
		//used for this pfm matrix file is already created and written.
		//No need for twice
		Map<String,Boolean> pfmMatrices2FalseorTrueMap 	= new HashMap<String,Boolean>();
		
		String fastaFile;
		String referenceSequence;
		String directoryBase = null;
					
		Boolean isThereAnExactTfNamePfmMatrix = false;
		
		//4 April 2014
		List<String> rsIdList;
		RsInformation rsInformation;
		String observedAllelesSeparatedwithSlash ;
				
		//7 April 2014 starts		
		//key must contain tf  KeggPathway chr startZeroBased endZeroBased
		Map<String,TfKeggPathwayGivenInterval> tfKeggPathwayBasedGivenIntervalMap = new HashMap<String,TfKeggPathwayGivenInterval>();
		
		//key must contain tf KeggPathway  tf CellLine chr startZeroBased endZeroBased		
		Map<String,TfKeggPathwayTfInterval> tfKeggPathwayBasedTfIntervalMap = new HashMap<String,TfKeggPathwayTfInterval>();
		
		//key must be chrNamewithPreceedingChr + givenIntervalStartZeroBased + givenIntervalEndZeroBased
		//this map contains the list of snp keys in a given interval
		Map<String,List<String>> givenIntervalBasedSnpMap = new HashMap<String,List<String>>();
		
		//key must contain chr startZeroBased endZeroBased
		Map<String,SNP> snpMap =  new HashMap<String,SNP>();
		
		TfKeggPathwayGivenInterval tfKeggPathwayGivenInterval = null;
		
		String tfKeggPathwayGivenIntervalKey;
		String tfKeggPathwayTfIntervalKey;
		String snpKey;	
		String givenIntervalKey;
		
		String givenIntervalName;
		
		List<String> snpKeyList;
		//7 April 2014  ends
					
				
		//10 March 2014
		//Each observedAlleles String contains observed alleles which are separated by tabs, pay attention, there can be more than two observed alleles such as A\tG\tT\t-\tACG
		//Pay attention, for the same chrName and ChrPosition there can be more than one observedAlleles String. It is rare but possible.
		List<String> alteredSequences;
		String observedAllelesSeparatedwithTabs;
					
//		**************	hsa00380 Tryptophan metabolism - Homo sapiens (human)	**************											
//		NFKB_hsa00380	Search for chr	given interval low	given interval high	tfbs	tfbs low	tfbs high	refseq gene name	ucscRefSeqGene low	ucscRefSeqGene high	interval name 	hugo suymbol	entrez id	keggPathwayName
//		NFKB_hsa00380	chr1	89546803	89546803	NFKB_GM12878	89546683	89546992	NM_001008661	89468644	89558643	5D	CCBL2	56267	hsa00380

		try {
			augmentedFileReader = new FileReader(outputFolder + augmentedInputFileName);
			augmentedBufferedReader = new BufferedReader(augmentedFileReader);
			
			directoryBase = getDirectoryBase(enrichmentType);
													
			while((strLine = augmentedBufferedReader.readLine())!=null){
							
				//skip strLine starts with * or contains "Search for" which means it is a header line
				if (!(strLine.startsWith("*")) && !(strLine.contains("Search for"))){
					
					indexofFirstTab 	= strLine.indexOf('\t');
					indexofSecondTab 	= strLine.indexOf('\t',indexofFirstTab+1);
					indexofThirdTab 	= strLine.indexOf('\t',indexofSecondTab+1);
					indexofFourthTab 	= strLine.indexOf('\t',indexofThirdTab+1);
					indexofFifthTab 	= strLine.indexOf('\t',indexofFourthTab+1);
					indexofSixthTab 	= strLine.indexOf('\t',indexofFifthTab+1);
					indexofSeventhTab 	= strLine.indexOf('\t',indexofSixthTab+1);
					
					tfNameKeggPathwayName = strLine.substring(0, indexofFirstTab);
					chrNamewithPreceedingChr =  strLine.substring(indexofFirstTab+1, indexofSecondTab);
					chrNamewithoutPreceedingChr = chrNamewithPreceedingChr.substring(3);
					
					givenIntervalStartZeroBased = Integer.parseInt(strLine.substring(indexofSecondTab+1, indexofThirdTab));
					givenIntervalEndZeroBased =  Integer.parseInt(strLine.substring(indexofThirdTab+1, indexofFourthTab));
					
					//Used in finding list of rsIds in this given interval
					givenIntervalStartOneBased = givenIntervalStartZeroBased + 1 ;
					givenIntervalEndOneBased =  givenIntervalEndZeroBased + 1;
						
					tfNameCellLineName = strLine.substring(indexofFourthTab+1, indexofFifthTab);
					tfStart_ZeroBased = Integer.parseInt(strLine.substring(indexofFifthTab+1, indexofSixthTab));
					tfEnd_ZeroBased =  Integer.parseInt(strLine.substring(indexofSixthTab+1, indexofSeventhTab));
					
					//Get tfName and keggPathwayName
					indexofUnderscore = tfNameKeggPathwayName.indexOf('_');
					tfName = tfNameKeggPathwayName.substring(0, indexofUnderscore);
					
					tfNamewithoutNumber = getTfNamewithoutNumber(tfName);
					
																				
					//7 April 2014 starts
									
					//create pfmMatrices and logo Matrices for this tfNameKeggPathwayName
					//create pfm matrices and logo matrices files under tfNameKeggPathwayName starts
					if(pfmMatrices2FalseorTrueMap.get(tfNameKeggPathwayName) == null){
												
						isThereAnExactTfNamePfmMatrix = false;
						
						//find pfm entry							
						for(Map.Entry<String, String> pfmEntry:tfName2PfmMatrices.entrySet()){
							if (pfmEntry.getKey().contains(tfName)){
								isThereAnExactTfNamePfmMatrix = true;
								createMatrixFile(outputFolder,directoryBase, tfNameKeggPathwayName,  "pfmMatrices_" + tfName,pfmEntry.getValue());
									
							}
						}//End of for
						
						
						//find logo entry
						for(Map.Entry<String, String> logoEntry:tfName2LogoMatrices.entrySet()){
							if(logoEntry.getKey().contains(tfName)){
								createMatrixFile(outputFolder,directoryBase, tfNameKeggPathwayName, "logoMatrices_" +tfName,logoEntry.getValue());

							}
						}

						
						if (!isThereAnExactTfNamePfmMatrix){

							//find pfm entry							
							for(Map.Entry<String, String> pfmEntry:tfName2PfmMatrices.entrySet()){
								if (pfmEntry.getKey().contains(tfNamewithoutNumber)){
									createMatrixFile(outputFolder,directoryBase, tfNameKeggPathwayName, "pfmMatrices_" + tfName,pfmEntry.getValue());									
								}
							}//End of for
							
							//find logo entry
							for(Map.Entry<String, String> logoEntry:tfName2LogoMatrices.entrySet()){
								if(logoEntry.getKey().contains(tfNamewithoutNumber)){
									createMatrixFile(outputFolder,directoryBase, tfNameKeggPathwayName, "logoMatrices_" +tfName,logoEntry.getValue());

								}
							}
							
						}
						
						pfmMatrices2FalseorTrueMap.put(tfNameKeggPathwayName, true);
					} //End of if
					//create pfm matrices and logo matrices files ends

					//Create given Interval key
					givenIntervalKey = "givenInterval" + "_" +chrNamewithPreceedingChr + "_" + givenIntervalStartZeroBased +  "_" + givenIntervalEndZeroBased;
					//set given interval name
					givenIntervalName ="givenInterval" + "_" +chrNamewithPreceedingChr + "_" + givenIntervalStartZeroBased +  "_" + givenIntervalEndZeroBased;
					
					//Create tfNameKeggPathwayName based given interval key					
					tfKeggPathwayGivenIntervalKey = tfNameKeggPathwayName + "_" + "givenInterval" + "_" +chrNamewithPreceedingChr + "_" + givenIntervalStartZeroBased +  "_" + givenIntervalEndZeroBased;
							 					
					//Create tf interval key
					tfKeggPathwayTfIntervalKey = tfNameKeggPathwayName + "_" + givenIntervalKey + "_" + tfNameCellLineName +  "_"  + "tfInterval" + "_" + chrNamewithPreceedingChr + "_" + tfStart_ZeroBased + "_" + tfEnd_ZeroBased;
						
					//get the given interval
					tfKeggPathwayGivenInterval = tfKeggPathwayBasedGivenIntervalMap.get(tfKeggPathwayGivenIntervalKey);
					
					if (tfKeggPathwayGivenInterval==null){
						
						tfKeggPathwayGivenInterval = new TfKeggPathwayGivenInterval();
						
						tfKeggPathwayBasedGivenIntervalMap.put(tfKeggPathwayGivenIntervalKey, tfKeggPathwayGivenInterval);
						
						tfKeggPathwayGivenInterval.setChromNamewithoutPreceedingChr(chrNamewithoutPreceedingChr);
						tfKeggPathwayGivenInterval.setStartZeroBased(givenIntervalStartZeroBased);
						tfKeggPathwayGivenInterval.setEndZeroBased(givenIntervalEndZeroBased);
						
						tfKeggPathwayGivenInterval.setSnpKeyList(new ArrayList<String>());
						tfKeggPathwayGivenInterval.setTfKeggPathwayBasedTfIntervalKeyList(new ArrayList<String>());
						
						tfKeggPathwayGivenInterval.setGivenIntervalName(givenIntervalKey);
						tfKeggPathwayGivenInterval.setTfNameKeggPathwayName(tfNameKeggPathwayName);
																								
						
						//part1
						//snpKeyList						
						//check whether for this given interval snps are already found
						snpKeyList = givenIntervalBasedSnpMap.get(givenIntervalKey);
						
						if (snpKeyList==null){
							
							snpKeyList = new ArrayList<String>();
							givenIntervalBasedSnpMap.put(givenIntervalKey,snpKeyList);
							
							//get all the rsIds in this given interval				
							//we have to provide one based coordinates for method arguments
							rsIdList = augofGivenInterval.getRsIdsInAGivenInterval(chrNamewithoutPreceedingChr, givenIntervalStartOneBased,givenIntervalEndOneBased);
													
							for(String rsId: rsIdList){
								
								//For each rsId get rs Information
								rsInformation = augofGivenRsId.getInformationforGivenRsId(rsId);
								
								//rsInformation has slash separated observed alleles
								observedAllelesSeparatedwithSlash = rsInformation.getObservedAlleles();								
								observedAllelesSeparatedwithTabs = convertSlashSeparatedAllelestoTabSeparatedAlleles(observedAllelesSeparatedwithSlash);									
								
								snpKey = "snp" + "_" + "chr" + rsInformation.getChrNamewithoutChr() + "_" + rsInformation.getStartZeroBased();
								
								SNP snp = snpMap.get(snpKey);
								
								if(snp==null){
									
									snp = new SNP();
									snp.setChrNamewithoutPreceedingChr(rsInformation.getChrNamewithoutChr());
									
									snp.setSnpZeroBasedCoordinate(rsInformation.getStartZeroBased());									
									snp.setSnpOneBasedCoordinate(rsInformation.getStartZeroBased()+1);
									
									//get fasta file and reference sequence for this snp
									fastaFile = getDNASequence(snp.getChrNamewithoutPreceedingChr(),snp.getSnpOneBasedCoordinate()- Commons.NUMBER_OF_BASES_BEFORE_SNP_POSITION,snp.getSnpOneBasedCoordinate() + Commons.NUMBER_OF_BASES_AFTER_SNP_POSITION,chrName2RefSeqIdforGrch37Map);
									referenceSequence = getDNASequenceFromFastaFile(fastaFile);
									
									snp.setReferenceSequence(referenceSequence);
									snp.setFastaFile(fastaFile);
									
									List<String> observedAlleles = new ArrayList<String>();
									snp.setObservedAlleles(observedAlleles);
									snp.getObservedAlleles().add(observedAllelesSeparatedwithTabs);
										
									snpMap.put(snpKey, snp);
									tfKeggPathwayGivenInterval.getSnpKeyList().add(snpKey);
									snpKeyList.add(snpKey);
									
								}else{
									if (!snp.getObservedAlleles().contains(observedAllelesSeparatedwithTabs)){
										snp.getObservedAlleles().add(observedAllelesSeparatedwithTabs);			
									}
									
									//Note that snpKey is already added to
									//tfKeggPathwayGivenInterval.getSnpKeyList() and
									//snpKeyList
									
								}//end of else snp is not null					
								
							}//End of for each rsId
							
							
						}else{
							tfKeggPathwayGivenInterval.setSnpKeyList(snpKeyList);
						}
						
							
														
						//part2
						//tfNameandKeggPathway based tfIntervalKeyList
						
						if(tfKeggPathwayBasedTfIntervalMap.get(tfKeggPathwayTfIntervalKey)==null){
							TfKeggPathwayTfInterval tfKeggPathwayTfInterval = new TfKeggPathwayTfInterval();
							
							
							//set attributes of tfKeggPathwayTfInterval
							tfKeggPathwayTfInterval.setStartZeroBased(tfStart_ZeroBased);
							tfKeggPathwayTfInterval.setEndZeroBased(tfEnd_ZeroBased);
							tfKeggPathwayTfInterval.setChrNamewithoutPreceedingChr(chrNamewithoutPreceedingChr);						
							tfKeggPathwayTfInterval.setTfNameCellLineName(tfNameCellLineName);
							tfKeggPathwayTfInterval.setTfNameKeggPathwayName(tfNameKeggPathwayName);
							
							tfKeggPathwayBasedTfIntervalMap.put(tfKeggPathwayTfIntervalKey,tfKeggPathwayTfInterval);
							tfKeggPathwayGivenInterval.getTfKeggPathwayBasedTfIntervalKeyList().add(tfKeggPathwayTfIntervalKey);
						}else{
							//do nothing
							//this tfInterval is already added to the map and list
						}
												
							
					}//For this tfKeggPathway, this given interval is read for the first time.
					
					else{
						
						if(tfKeggPathwayBasedTfIntervalMap.get(tfKeggPathwayTfIntervalKey)==null){
							TfKeggPathwayTfInterval tfKeggPathwayTfInterval = new TfKeggPathwayTfInterval();
							
							
							//set attributes of tfKeggPathwayTfInterval
							tfKeggPathwayTfInterval.setStartZeroBased(tfStart_ZeroBased);
							tfKeggPathwayTfInterval.setEndZeroBased(tfEnd_ZeroBased);
							tfKeggPathwayTfInterval.setChrNamewithoutPreceedingChr(chrNamewithoutPreceedingChr);						
							tfKeggPathwayTfInterval.setTfNameCellLineName(tfNameCellLineName);
							tfKeggPathwayTfInterval.setTfNameKeggPathwayName(tfNameKeggPathwayName);
							
							tfKeggPathwayBasedTfIntervalMap.put(tfKeggPathwayTfIntervalKey,tfKeggPathwayTfInterval);
							tfKeggPathwayGivenInterval.getTfKeggPathwayBasedTfIntervalKeyList().add(tfKeggPathwayTfIntervalKey);
						}else{
							//do nothing
							//this tfInterval is already in the list
						}
					
						
					}// this given interval is read before
					//we already know the snps in this given interval
					//however new tf Intervals might  be added.
						
						
					//7 April 2014 ends

											
				}//End of if: strLine does not start with "*"	and contains "Search for"	
				
				
			}//End of while 
			
			//Write snp refernce sequence
			//write snp observed alleles 
			//write snp altered sequences
			//write tf intervals overlapping with this snp
			//write extended peak sequence 
			List<String>  tfIntervalKeyList;
			
			List<String> snpBasedTfIntervalKeyList ;
						
			TfKeggPathwayGivenInterval givenInterval;
			String snpDirectory;
			
			
			//Augmented file has been read
			//Now for each given interval
			//get the reference sequence, observed alleles and altered sequences of snps in this given interval and write them to files
			//get the tf intervals in this given interval
			//for each snp in this given interval
			//get the list of tf intervals overlapping with this snp
			//write these snp based tf intervals to a file
			//get the minStartZeroBased and maxEndZeroBased coordinates from these list of overlapping tf intervals
			//get the extended peak sequence starting at minStartZeroBased and ending at maxEndZeroBased for this snp Based tf intervals 
			for(Map.Entry<String, TfKeggPathwayGivenInterval> entry: tfKeggPathwayBasedGivenIntervalMap.entrySet()){
				givenIntervalKey = entry.getKey();
				givenInterval = entry.getValue();
				
				givenIntervalName = givenInterval.getGivenIntervalName();
				tfNameKeggPathwayName = givenInterval.getTfNameKeggPathwayName();
				
				snpKeyList = givenInterval.getSnpKeyList();
				tfIntervalKeyList = givenInterval.getTfKeggPathwayBasedTfIntervalKeyList();
				
				chrNamewithoutPreceedingChr = givenInterval.getChromNamewithoutPreceedingChr();
											
				for(String snpKeyString : snpKeyList ){
					SNP snp = snpMap.get(snpKeyString);
				
					snpDirectory = tfNameKeggPathwayName+  System.getProperty("file.separator") + givenIntervalName + System.getProperty("file.separator") + snpKeyString;
										
					//write reference sequence
					createSequenceFile(outputFolder ,directoryBase,snpDirectory, "reference" + "_" + snpKeyString,snp.getFastaFile());
					
					//write observedAlleles
					createObservedAllelesFile(outputFolder,directoryBase, snpDirectory, "observedAlleles" + "_" + snpKeyString ,snp.getObservedAlleles());
				
					alteredSequences = getAlteredSNPSequences(snp.getReferenceSequence(),snp.getObservedAlleles(),Commons.ONE_BASED_SNP_POSITION);
								
					//create Altered Sequences
					int alteredSNPSequenceCount = 0;
					for(String alteredSequence : alteredSequences){
						alteredSNPSequenceCount++;
						createSequenceFile(outputFolder,directoryBase, snpDirectory, "altered" + alteredSNPSequenceCount + "_" + snpKeyString,alteredSequence);	
					}
									
					//find overlapping tfIntervalkeys with this snp
					snpBasedTfIntervalKeyList = findTfIntervalsOverlappingWithThisSNP(tfIntervalKeyList, tfKeggPathwayBasedTfIntervalMap,  snp.getSnpZeroBasedCoordinate());
					
					//get snp based extended peak sequence
					getSNPBasedPeakSequence(snpBasedTfIntervalKeyList,tfKeggPathwayBasedTfIntervalMap,chrNamewithoutPreceedingChr,chrName2RefSeqIdforGrch37Map,outputFolder,directoryBase,snpDirectory,snpKeyString);

					//write snp based tf Intervals file
					createTfIntervalsFile(outputFolder,directoryBase,snpDirectory, "tfIntervals" + "_" + snpKeyString, snpBasedTfIntervalKeyList,tfKeggPathwayBasedTfIntervalMap);
								
				}//End of for each snp in this given interval
							
				System.out.println(entry.getKey());
				
			}//End of each given interval
			
						
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	//TF KEGGPATHWAY ends

	
	
	//Pay Attention
	//Contains X for chrX
	//Contains 1 for chr1
	
	//# Sequence-Name	Sequence-Role	Assigned-Molecule	Assigned-Molecule-Location/Type	GenBank-Accn	Relationship	RefSeq-Accn	Assembly-Unit
	//1	assembled-molecule	1	Chromosome	CM000663.1	=	NC_000001.10	Primary Assembly
	//X	assembled-molecule	X	Chromosome	CM000685.1	=	NC_000023.10	Primary Assembly
	public static void fillMap(String dataFolder, String refSeqIdsforGRCh37InputFile,Map<String,String> chrName2RefSeqIdforGrch37Map){
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine = null;
		int numberofChromosomesinHomoSapiens = 24;
		int count = 0;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		
		String chrName;
		String refSeqId;
		
		try {
			fileReader = new FileReader(dataFolder + refSeqIdsforGRCh37InputFile);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null){
				if(strLine.startsWith("#")){
					continue;
				}else{
					if (count<numberofChromosomesinHomoSapiens){
						count++;
						
						indexofFirstTab 	= strLine.indexOf('\t');
						indexofSecondTab 	= strLine.indexOf('\t', indexofFirstTab+1);
						indexofThirdTab 	= strLine.indexOf('\t', indexofSecondTab+1);
						indexofFourthTab 	= strLine.indexOf('\t', indexofThirdTab+1);
						indexofFifthTab 	= strLine.indexOf('\t', indexofFourthTab+1);
						indexofSixthTab 	= strLine.indexOf('\t', indexofFifthTab+1);
						indexofSeventhTab 	= strLine.indexOf('\t', indexofSixthTab+1);
						
						chrName = strLine.substring(0, indexofFirstTab);
						refSeqId = strLine.substring(indexofSixthTab+1, indexofSeventhTab);
						
						chrName2RefSeqIdforGrch37Map.put(chrName, refSeqId);
						continue;
						
					}
				}
					
				break;				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Pay Attention
	//Contains X for chrX
	//Contains 1 for chr1	
	//# Sequence-Name	Sequence-Role	Assigned-Molecule	Assigned-Molecule-Location/Type	GenBank-Accn	Relationship	RefSeq-Accn	Assembly-Unit
	//1	assembled-molecule	1	Chromosome	CM000663.1	=	NC_000001.10	Primary Assembly
	//X	assembled-molecule	X	Chromosome	CM000685.1	=	NC_000023.10	Primary Assembly
	public Map<String,String> fillMap(String refSeqIdsforGRCh37InputFile){
		
		Map<String,String> chrName2RefSeqIdforGrch37Map = new HashMap<String,String>();
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine = null;
		int numberofChromosomesinHomoSapiens = 24;
		int count = 0;
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		
		String chrName;
		String refSeqId;
		
		try {
			fileReader = new FileReader(refSeqIdsforGRCh37InputFile);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null){
				if(strLine.startsWith("#")){
					continue;
				}else{
					if (count<numberofChromosomesinHomoSapiens){
						count++;
						
						indexofFirstTab 	= strLine.indexOf('\t');
						indexofSecondTab 	= strLine.indexOf('\t', indexofFirstTab+1);
						indexofThirdTab 	= strLine.indexOf('\t', indexofSecondTab+1);
						indexofFourthTab 	= strLine.indexOf('\t', indexofThirdTab+1);
						indexofFifthTab 	= strLine.indexOf('\t', indexofFourthTab+1);
						indexofSixthTab 	= strLine.indexOf('\t', indexofFifthTab+1);
						indexofSeventhTab 	= strLine.indexOf('\t', indexofSixthTab+1);
						
						chrName = strLine.substring(0, indexofFirstTab);
						refSeqId = strLine.substring(indexofSixthTab+1, indexofSeventhTab);
						
						chrName2RefSeqIdforGrch37Map.put(chrName, refSeqId);
						continue;
						
					}
				}
					
				break;
				
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chrName2RefSeqIdforGrch37Map;
	}
	
		
	//args[0] must have input file name with folder
	//args[1] must have GLANET installation folder with "\\" at the end. This folder will be used for outputFolder and dataFolder.
	//args[2] must have Input File Format		
	//args[3] must have Number of Permutations	
	//args[4] must have False Discovery Rate (ex: 0.05)
	//args[5] must have Generate Random Data Mode (with GC and Mapability/without GC and Mapability)
	//args[6] must have writeGeneratedRandomDataMode checkBox
	//args[7] must have writePermutationBasedandParametricBasedAnnotationResultMode checkBox
	//args[8] must have writePermutationBasedAnnotationResultMode checkBox
	//args[9] must have Dnase Enrichment example: DO_DNASE_ENRICHMENT or DO_NOT_DNASE_ENRICHMENT
	//args[10] must have Histone Enrichment example : DO_HISTONE_ENRICHMENT or DO_NOT_HISTONE_ENRICHMENT
	//args[11] must have Tf and KeggPathway Enrichment example: DO_TF_KEGGPATHWAY_ENRICHMENT or DO_NOT_TF_KEGGPATHWAY_ENRICHMENT
	//args[12] must have Tf and CellLine and KeggPathway Enrichment example: DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT or DO_NOT_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT
	//args[13] must have a job name exampe: any_string 
	public static void main(String[] args) {
		
		String glanetFolder = args[1];
		String dataFolder 	= glanetFolder + System.getProperty("file.separator") + Commons.DATA + System.getProperty("file.separator") ;
		String outputFolder = glanetFolder + System.getProperty("file.separator") + Commons.OUTPUT + System.getProperty("file.separator") ;
		
			
		//TfKeggPathway Enrichment, DO or DO_NOT
		String tfKeggPathwayEnrichment = args[11];
		
		//TfCellLineKeggPathway Enrichment, DO or DO_NOT
		String tfCellLineKeggPathwayEnrichment = args[12];


		//pfm matrices
		String encodeMotifsInputFileName 	= Commons.ENCODE_MOTIFS ;		
		String jasparCoreInputFileName 		= Commons.JASPAR_CORE;
	
		//TF and KeggPathway
		String augmentedTfExonBasedKeggPathwayInputFileName 		= Commons.AUGMENTED_TF_EXON_BASED_KEGG_PATHWAY_RESULTS ;
		String augmentedTfRegulationBasedKeggPathwayInputFileName 	= Commons.AUGMENTED_TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS ;
		String augmentedTfAllBasedKeggPathwayInputFileName 			= Commons.AUGMENTED_TF_ALL_BASED_KEGG_PATHWAY_RESULTS ;
		
				
		//TF and CellLine and KeggPathway
		String augmentedTfCellLineExonBasedKeggPathwayInputFileName 		= Commons.AUGMENTED_TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS ;
		String augmentedTfCellLineRegulationBasedKeggPathwayInputFileName 	= Commons.AUGMENTED_TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS ;
		String augmentedTfCellLineAllBasedKeggPathwayInputFileName 			= Commons.AUGMENTED_TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS ;
		
		//Example Data
		//7 NC_000007.13
		Map<String,String> chrName2RefSeqIdforGrch37Map = new HashMap<String,String>();
		
				
		//Construct map for refSeq Ids of homo sapiens chromosomes for GRCh37
		String refSeqIdsforGRCh37InputFile = Commons.REFSEQ_IDS_FOR_GRCH37_INPUT_FILE;
		fillMap(dataFolder,refSeqIdsforGRCh37InputFile,chrName2RefSeqIdforGrch37Map);
							
					
//		//Before each run
//		//delete directories and files under base directories
		FileOperations.deleteDirectoriesandFilesUnderThisDirectory(outputFolder,Commons.GENERATION_OF_REFERENCE_AND_ALTERED_SEQUENCES_OUTPUT_FOLDER);
				
		//Construct pfm matrices from encode-motif.txt file
		//A tf can have more than one pfm matrices
		//Take the transpose of given matrices in encode-motif.txt
		//Write the matrices in tab format for RSAT tool
		Map<String,String> tfName2PfmMatrices = new HashMap<String,String>();
		
		Map<String,String> tfName2LogoMatrices = new HashMap<String,String>();
		
			
		//Construct position frequency matrices from Encode Motifs
		constructPfmMatricesfromEncodeMotifs(dataFolder,encodeMotifsInputFileName,tfName2PfmMatrices);
		
		//Construct logo matrices from Encode Motifs
		constructLogoMatricesfromEncodeMotifs(dataFolder,encodeMotifsInputFileName,tfName2LogoMatrices);
		
		//Construct position frequency matrices from Jaspar Core 
		//Construct logo matrices from Jaspar Core
		constructPfmMatricesandLogoMatricesfromJasparCore(dataFolder,jasparCoreInputFileName,tfName2PfmMatrices,tfName2LogoMatrices);
		
		
		AugmentationofGivenIntervalwithRsIds augofGivenInterval;
		AugmentationofGivenRsIdwithInformation augofGivenRsId ;
		
		try {
			augofGivenInterval = new AugmentationofGivenIntervalwithRsIds();
			augofGivenRsId = new AugmentationofGivenRsIdwithInformation();
			
								
			if (tfKeggPathwayEnrichment.equals(Commons.DO_TF_KEGGPATHWAY_ENRICHMENT)){
				//Using tfName2PfmMatrices
				//Using snps for Enriched TfandKeggPathway
				//Output dnaSequences for TfandKeggPathway
				//Output pfmMatrices for TfandKeggPathway
				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfExonBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_EXON_BASED_KEGG_PATHWAY);
//				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfRegulationBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_REGULATION_BASED_KEGG_PATHWAY);
//				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfAllBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_ALL_BASED_KEGG_PATHWAY);	
			}
			
			if(tfCellLineKeggPathwayEnrichment.equals(Commons.DO_TF_CELLLINE_KEGGPATHWAY_ENRICHMENT)){
				//Using tfName2PfmMatrices
				//Using snps for Enriched Tf CellLine KeggPathway
				//Output dnaSequences for Tf CellLine KeggPathway
				//Output pfmMatrices for Tf CellLine KeggPathway
//				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfCellLineExonBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY);
//				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfCellLineRegulationBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY);
//				readAugmentedDataWriteSequencesandMatrices(augofGivenInterval,augofGivenRsId,chrName2RefSeqIdforGrch37Map,outputFolder,augmentedTfCellLineAllBasedKeggPathwayInputFileName,tfName2PfmMatrices,tfName2LogoMatrices,Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY);
	
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	
	}

}
