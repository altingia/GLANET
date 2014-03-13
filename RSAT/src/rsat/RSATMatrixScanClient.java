/**
 * @author Burcak Otlu
 * Jan 30, 2014
 * 12:05:22 PM
 * 2014
 *
 * 
 */
package rsat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import RSATWS.MatrixScanRequest;
import RSATWS.MatrixScanResponse;
import RSATWS.RSATWSPortType;
import RSATWS.RSATWebServicesLocator;
import auxiliary.FileOperations;

import common.Commons;



public class RSATMatrixScanClient {

	/**
	 * 
	 */
	public RSATMatrixScanClient() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readAllfromFile(String inputFileName){
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		String strLine = null;
		String all = "";
		
		
		try {
			fileReader = new FileReader(inputFileName);
			bufferedReader = new BufferedReader(fileReader);
			
			while((strLine = bufferedReader.readLine())!=null){
				all = all + strLine +"\n";
				
			}
			
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return all;
		
	}
	
	
	
	
	//direction does not matter
	//start is less than end
	public static boolean constainsSNP(int start,int end,int snpPosition){
			if (snpPosition <= end && snpPosition>=start){
				return true;
			}
			
		
		return false;
	}
	
	public static int getPeakStart(String bestPeakResultLine){
//		peak_BCLAF1M33_GM12878_170862295_170862544_BCLAF1M33_hsa05016 	site 	matrix-scan_2014-03-03.2 	R 	108 	117 	GCCGGAAGTG 	7.7 	1.7e-06 	-13.269 	5.762 	1 	1
		int indexofFirstTab = bestPeakResultLine.indexOf('\t');
		
		String peak = bestPeakResultLine.substring(0, indexofFirstTab);
		
		int indexofFirstUnderscore 	= peak.indexOf('_');
		int indexofSecondUnderscore = peak.indexOf('_',indexofFirstUnderscore+1);
		int indexofThirdUnderscore 	= peak.indexOf('_',indexofSecondUnderscore+1);
		int indexFourthUnderscore 	= peak.indexOf('_',indexofThirdUnderscore+1);
		
		return Integer.parseInt(peak.substring(indexofThirdUnderscore+1, indexFourthUnderscore));
	
	}
	
	
	public static int getSNPStart(String bestSNPResultLine){
//		example snp result line
//		snp_chr6_170862335_BCLAF1M33_hsa05016 	site 	matrix-scan_2014-03-03.5 	D 	15 	28 	GGCTGCGCCTGCGG 	4.8 	4.2e-06 	-12.391 	5.381 	1 	1
		
		int indexofFirstTab = bestSNPResultLine.indexOf('\t');
		
		String snp = bestSNPResultLine.substring(0, indexofFirstTab);
		
		int indexofFirstUnderscore = snp.indexOf('_');
		int indexofSecondUnderscore = snp.indexOf('_',indexofFirstUnderscore+1);
		int indexofThirdUnderscore = snp.indexOf('_',indexofSecondUnderscore+1);
		
		return Integer.parseInt(snp.substring(indexofSecondUnderscore+1, indexofThirdUnderscore));
		

	}
	
	//peak_BCLAF1M33_K562_47600418_47600641_BCLAF1M33_hsa05016	site	matrix-scan-matrix_2014-03-03.2	R	104	113	GCCGGAAGCG	6.9	6.8e-06	-11.897	5.167	1	1
	public static void getPeakSequenceStartandEnd(PeakSequence peakSequence,String peakResultLine){
		
		int indexofFirstTab 	= peakResultLine.indexOf('\t');
		int indexofSecondTab 	= peakResultLine.indexOf('\t',indexofFirstTab+1);
		int indexofThirdTab 	= peakResultLine.indexOf('\t',indexofSecondTab+1);
		int indexofFourthTab	= peakResultLine.indexOf('\t',indexofThirdTab+1);
		int indexofFifthTab 	= peakResultLine.indexOf('\t',indexofFourthTab+1);
		int indexofSixthTab 	= peakResultLine.indexOf('\t',indexofFifthTab+1);
		
		peakSequence.setStart(Integer.parseInt(peakResultLine.substring(indexofFourthTab+1, indexofFifthTab)));
		peakSequence.setEnd(Integer.parseInt(peakResultLine.substring(indexofFifthTab+1, indexofSixthTab)));
		
	}

	
	public static boolean peakResultLineContainsSNPPosition(String snpResultLine,String peakResultLine){
		int snpStart = 0;
		int peakStart = 0;
		int snpPosition = 0;
		
		PeakSequence peakSequence= new PeakSequence();
		
		
		snpStart = getSNPStart(snpResultLine);
		peakStart = getPeakStart(peakResultLine);
		
		snpPosition = snpStart - peakStart +1;
		
		getPeakSequenceStartandEnd(peakSequence,peakResultLine);
		
		return constainsSNP(peakSequence.getStart(), peakSequence.getEnd(), snpPosition);
		
	}
	
	public static Result getBestSnpResultLine(String description, String snpResult,BufferedWriter bufferedWriter) throws IOException{
		
		String snpResultLine = null;
		String bestSNPResultLine =null;
		
		int indexofSharpinSNPResult;
		int indexofNewLineinSNPResult;
		int indexofNextNewLineinSNPResult;
		
		
		int indexofFirstTab;
		int indexofSecondTab;
		int indexofThirdTab;
		int indexofFourthTab;
		int indexofFifthTab;
		int indexofSixthTab;
		int indexofSeventhTab;
		int indexofEigthTab;
		int indexofNinethTab;
		
		char direction = ' ';
		int start = 0;
		int end = 0;
		double pValue = 0;
		String sequence = null;
		
		int countforSNPResultLine = 0;
		
		Result result = new Result();
	
		indexofSharpinSNPResult = snpResult.indexOf('#');
		indexofNewLineinSNPResult = snpResult.indexOf('\n',indexofSharpinSNPResult+1);
		indexofNextNewLineinSNPResult = snpResult.indexOf('\n',indexofNewLineinSNPResult+1);
		
		
		do{
			
			snpResultLine = snpResult.substring(indexofNewLineinSNPResult+1,indexofNextNewLineinSNPResult);
			
			if(snpResultLine.startsWith(";")){
				//Not a valid snp result line 
				break;
			}
			
			//check whether there is no snp result or there is no snp result containing snp position
			//if there is a break countforSNPResultLine will remain zero means that there is no snp result
			//else countforSNPResultLine will be nonzero means there is at least one snp result 
			countforSNPResultLine++;
			
			indexofFirstTab 	= snpResultLine.indexOf('\t');
			indexofSecondTab 	= snpResultLine.indexOf('\t',indexofFirstTab+1);
			indexofThirdTab 	= snpResultLine.indexOf('\t',indexofSecondTab+1);
			indexofFourthTab 	= snpResultLine.indexOf('\t',indexofThirdTab+1);
			indexofFifthTab 	= snpResultLine.indexOf('\t',indexofFourthTab+1);
			indexofSixthTab 	= snpResultLine.indexOf('\t',indexofFifthTab+1);
			indexofSeventhTab	= snpResultLine.indexOf('\t',indexofSixthTab+1);
			indexofEigthTab 	= snpResultLine.indexOf('\t',indexofSeventhTab+1);
			indexofNinethTab 	= snpResultLine.indexOf('\t',indexofEigthTab+1);
			
			direction = snpResultLine.substring(indexofThirdTab+1, indexofFourthTab).charAt(0);
			start = Integer.parseInt(snpResultLine.substring(indexofFourthTab+1, indexofFifthTab));
			end = Integer.parseInt(snpResultLine.substring(indexofFifthTab+1, indexofSixthTab));
			sequence = snpResultLine.substring(indexofSixthTab+1,indexofSeventhTab);
			pValue = Double.parseDouble(snpResultLine.substring(indexofEigthTab+1, indexofNinethTab));
			
			
			//in case of next snpResult fetch
			indexofNewLineinSNPResult = indexofNextNewLineinSNPResult;
			indexofNextNewLineinSNPResult = snpResult.indexOf('\n', indexofNewLineinSNPResult+1);
			
		} while(!constainsSNP(start,end,Commons.ONE_BASED_SNP_POSITION));

		
		if(snpResultLine.startsWith(";") && countforSNPResultLine==0){
			bufferedWriter.write("There is no snp result line\n");	
		}else if (snpResultLine.startsWith(";") && countforSNPResultLine!=0){
			bufferedWriter.write("There is NO snp result line containing snp position\n");
		}else {
			bestSNPResultLine = snpResultLine;
			//no need to write this.
			//bufferedWriter.write(direction + "\t" + start + "\t" + end + "\t" + sequence + "\t" + pValue +"\n");
		}
		
		if(bestSNPResultLine!=null){
			bufferedWriter.write(description + bestSNPResultLine + "\n");
		}
		
		result.setpValue(pValue);
		result.setResultLine(bestSNPResultLine);
		
		return result;

	}
	
	
	public static void getBestPeakResultLine(String bestSNPResultLine,String peakResult, BufferedWriter bufferedWriter) throws IOException{
		
		int countforPeakResultLine = 1;
		
		boolean isThereAPeakResultLineContainingSNPPosition = false;

		int indexofSharpinPeakResult = peakResult.indexOf('#');
		int indexofNewLineinPeakResult = peakResult.indexOf('\n',indexofSharpinPeakResult+1);
		int indexofNextNewLineinPeakResult = peakResult.indexOf('\n',indexofNewLineinPeakResult+1);
		
		
		String peakResultLine = peakResult.substring(indexofNewLineinPeakResult+1,indexofNextNewLineinPeakResult);
		String  bestPeakResultLine = null;
		
		if(peakResultLine.startsWith(";")){
			bufferedWriter.write("There is no peak result line\n");	
		}else{
			bestPeakResultLine = peakResultLine;
			bufferedWriter.write("Best peak sequence: " + bestPeakResultLine +"\n");
		}
		
		//if best snp result line and best peak result line are not null
		if(bestSNPResultLine!=null && bestPeakResultLine!=null){
			
			while(!(isThereAPeakResultLineContainingSNPPosition = peakResultLineContainsSNPPosition(bestSNPResultLine,bestPeakResultLine))){
				
				//in case of next peakResult fetch
				indexofNewLineinPeakResult = indexofNextNewLineinPeakResult;
				indexofNextNewLineinPeakResult = peakResult.indexOf('\n',indexofNewLineinPeakResult+1);
				countforPeakResultLine++;
				
				bestPeakResultLine = peakResult.substring(indexofNewLineinPeakResult+1,indexofNextNewLineinPeakResult);
				
				//Not a valid peak result line
				if(bestPeakResultLine.startsWith(";")){
					break;
				}
				
			}//End of while 
			
			//There is a peak result line containing snp position
			if(isThereAPeakResultLineContainingSNPPosition){
				bufferedWriter.write("Peak result line containing snp position at " + countforPeakResultLine + ". peak result line : "   + bestPeakResultLine + "\n");
			}
			//There is no peak result line containing snp position
			else{
				bufferedWriter.write("There is no peak result line containing snp position\n");
				
			}
		}
	}
	
	public static void calculateLogRatioofPValues(double pValueofReferenceSequence, double pValueofVariationSequence, BufferedWriter bufferedWriter) throws IOException{
		
		double logRatio;
		DecimalFormat df = new DecimalFormat("0.######E0");
		
		
		logRatio = Math.log10(pValueofReferenceSequence/pValueofVariationSequence);
		bufferedWriter.write("log ratio of reference snp sequence to the variation snp sequence is : " + df.format(logRatio) + "\n");
		
	}

	
	//search for the best snp result line containing snp position among peak result lines
	public static void compareResults(String snpResult, List<String> alteredSNPResults,String peakResult, BufferedWriter bufferedWriter) throws IOException{
				
		Result bestSNPLineResult = null;
		Result bestAlteredSNPLineResult = null;
		
		String description = "Best snp sequence containing snp position: ";
		//Get best snp result line containing snp position if it exists
		bestSNPLineResult = getBestSnpResultLine(description,snpResult,bufferedWriter);
			
		
		//Get best peak result line containing snp position 
		getBestPeakResultLine(bestSNPLineResult.getResultLine(),peakResult,bufferedWriter);
		
		description = "Best altered snp sequence containing snp position: ";
		
		//get the best alteredSNPResultLine containing snp position
		for(String alteredSNPResult: alteredSNPResults){
			bestAlteredSNPLineResult =getBestSnpResultLine(description,alteredSNPResult,bufferedWriter);
			
			calculateLogRatioofPValues(bestSNPLineResult.getpValue(),bestAlteredSNPLineResult.getpValue(),bufferedWriter);
		}
				
	}

	
	public static void matrixScan(String snpInputFile,List<String> alteredSNPInputFiles,String peakInputFile,String pfmMatricesInputFile,RSATWSPortType proxy,MatrixScanRequest matrixScanRequest,BufferedWriter bufferedWriter){
		try{
		
			
			bufferedWriter.write("********************************************\n");
			bufferedWriter.write("This script illustrates a request to RSATMatrixScan ...\n");
			bufferedWriter.write("pfmMatricesFile: "  + pfmMatricesInputFile +"\n");

			
//			RSATWebServicesLocator service = new RSATWebServicesLocator();		
//			RSATWSPortType proxy = service.getRSATWSPortType();			
//			MatrixScanRequest matrixScanRequest = new MatrixScanRequest();
				
			String snpSequence = readAllfromFile(snpInputFile);
			String peakSequences = readAllfromFile(peakInputFile);
						
			String sequence_format = "fasta";
			matrixScanRequest.setSequence_format(sequence_format);
			
			String mask = "non-dna";
			//How to set this parameter?
						
			String pfmMatrices = readAllfromFile(pfmMatricesInputFile);
		
			matrixScanRequest.setMatrix(pfmMatrices);
						
			String matrixFormat = "tab";
			matrixScanRequest.setMatrix_format(matrixFormat);
			
			Integer markov     = new Integer (0);
			matrixScanRequest.setMarkov(markov);
				
			String organism = Commons.RSAT_ORGANISM_Homo_sapiens_ensembl_74_GRCh37;
			matrixScanRequest.setOrganism(organism);
			
			String background 	= Commons.RSAT_BACKGROUND_upstream_noorf;
			matrixScanRequest.setBackground(background);
			
			float pseudo_frequencies = 0.01f;
			matrixScanRequest.setBackground_pseudo(new Float(pseudo_frequencies));
			
//			String tmp_background_infile = Commons.RSAT_tmp_background_infile;
//			matrixScanRequest.setTmp_background_infile(tmp_background_infile);
		
			Integer search_strands = new Integer(2);
			matrixScanRequest.setStr(search_strands);
			
			//Although it is set to start
			//It is not set in the called matrixScan
			String origin 		= "start";
			matrixScanRequest.setOrigin(origin);
			
			String offset = "0";
			//how to set this parameter?
			
			Integer verbosity 	= new Integer (1);
			matrixScanRequest.setVerbosity(verbosity);
		
			Integer pseudo_counts 		= new Integer (1);
			matrixScanRequest.setPseudo(pseudo_counts);
						
			Integer score_decimals 	= new Integer (1);
			matrixScanRequest.setDecimals(score_decimals);
			
			String n_treatment	 = "score";
			matrixScanRequest.setN_treatment(n_treatment);
			
			//If you do not set these parameters 
			//they are set to NONE
		
			String[] uth = {"pval 0.1"};
			matrixScanRequest.setUth(uth);
			
						
			matrixScanRequest.setReturn_fields("sites,pval,rank");
			
						
			matrixScanRequest.setSequence(snpSequence);
		
			/*Call the service*/
			bufferedWriter.write("Matrix-scan: sending request to the server for snp sequence...\n");
			bufferedWriter.write("snpFile: "+  snpInputFile + "\n");
			
			MatrixScanResponse snpResponse = proxy.matrix_scan(matrixScanRequest);
				
			/* Process results*/
			//Report the remote command
	//		System.out.println("Command used on the server:"+ response.getCommand());
//			String commandUsedontheServerforSNP = snpResponse.getCommand();
				
			//Report the server file location
	//		System.out.println("Result file on the server::\n"+ response.getServer());
//			String resultFileontheServerforSNP = snpResponse.getServer();
			
				
			//Results
			String snpResult = snpResponse.getClient();
			
			matrixScanRequest.setSequence(peakSequences);
			
			/*Call the service*/
			bufferedWriter.write("Matrix-scan: sending request to the server for peak sequences...\n");
			bufferedWriter.write("peakFile: "+  peakInputFile + "\n");
			
			MatrixScanResponse peakResponse = proxy.matrix_scan(matrixScanRequest);
				
			//Results
			String peakResult = peakResponse.getClient();
			
			List<String> alteredSNPResults = new ArrayList<String>();
			
			//**************************************
			for(String alteredSNPInputFile:alteredSNPInputFiles ){
				String alteredSNPSequence = readAllfromFile(alteredSNPInputFile);
				
				//Set the altered SNP Sequence
				matrixScanRequest.setSequence(alteredSNPSequence);
				
				/*Call the service*/
				bufferedWriter.write("Matrix-scan: sending request to the server for altered SNP sequences...\n");
				bufferedWriter.write("alteredSNPFile: "+  alteredSNPInputFile + "\n");
				
				MatrixScanResponse alteredSNPResponse = proxy.matrix_scan(matrixScanRequest);
			
				String alteredSNPResult = alteredSNPResponse.getClient();
				
				alteredSNPResults.add(alteredSNPResult);
			}//for each altered snp sequence file
						
			//**************************************
		
			
			compareResults(snpResult,alteredSNPResults,peakResult,bufferedWriter);
			
		
		} catch(Exception e) {
			System.out.println(e.toString());
			
		}

	}

	public static void matrixScan(String baseDirectory,BufferedWriter bufferedWriter){
		
	
			File baseFolder = new File(baseDirectory);
			File[] files = baseFolder.listFiles();
			
			String snpInputFile = null;
			String alteredSnpInputFile = null;
			List<String> alteredSNPInputFiles = null;
			String peakInputFile = null;
			String pfmMatricesInputFile = null;
			
			String fileName=null;
			String fileAbsolutePath = null;
			
			RSATWebServicesLocator service = new RSATWebServicesLocator();
			RSATWSPortType proxy  = null;
			
			try {
				proxy = service.getRSATWSPortType();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MatrixScanRequest matrixScanRequest = new MatrixScanRequest();
						
			 
		    for(File enrichedTfandKeggPathways: files){
		        if(enrichedTfandKeggPathways.isDirectory()) {
		         	for(File snps:enrichedTfandKeggPathways.listFiles()){
		         		if(snps.isDirectory()){
		         			
		         			//Initialise input files
		         			snpInputFile = null;
		         			alteredSnpInputFile = null;
		         			alteredSNPInputFiles = new ArrayList<String>();
		        			peakInputFile = null;
		        			pfmMatricesInputFile = null;
		        				         			
		         			File[] filesforSNPs = snps.listFiles();
		         			
		         			for(File snporPeakorPFMorLogo: filesforSNPs){
		         				
		         				fileName = snporPeakorPFMorLogo.getName();
		         				fileAbsolutePath = snporPeakorPFMorLogo.getAbsolutePath();
		         				
		         				//for debug start
		         				//debug snp_chr11_47600437_ELK4_hsa05016.txt buraya eklenecek
		         				if (fileName.equals("snp_chr11_47600437_ELK4_hsa05016.txt")){
		         					System.out.println("stop here");
		         				}
		         				//for debug end
		         				
		         				if (fileName.startsWith("snp")){
		         					snpInputFile = fileAbsolutePath;
		         				}else if (fileName.startsWith("altered")){
		         					alteredSnpInputFile = fileAbsolutePath;
		         					alteredSNPInputFiles.add(alteredSnpInputFile);
		         				}else if (fileName.startsWith("peak")){
		         					peakInputFile = fileAbsolutePath;
		         				}else if(fileName.startsWith("pfm")){
		         					pfmMatricesInputFile = fileAbsolutePath;
		         				}
		         				 
		         			}//for each necessary file under snp directory
		         			
		         			//If all necessary files are not null
		         			if(snpInputFile!= null && peakInputFile!=null && pfmMatricesInputFile!=null ){
		            			//Matrix Scan Call
			         			matrixScan(snpInputFile,alteredSNPInputFiles,peakInputFile,pfmMatricesInputFile,proxy,matrixScanRequest,bufferedWriter);
			   
		         			}
		         				
		         		}//if it is a directory
		         	}//End of each snp directory
		        }  // if it is a directory
		    }//End of for each enriched tf and kegg pathway directory
		    
			
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String tfExonBasedKeggPathwayBaseDirectory = Commons.TF_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfRegulationBasedKeggPathwayBaseDirectory = Commons.TF_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfAllBasedKeggPathwayBaseDirectory = Commons.TF_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		
		
		String tfCellLineExonBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_EXON_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfCellLineRegulationBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_REGULATION_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		String tfCellLineAllBasedKeggPathwayBaseDirectory = Commons.TF_CELLLINE_ALL_BASED_KEGG_PATHWAY_RESULTS_DIRECTORY_BASE;
		
		
		//Delete the results of the former RSAT matrix scan call
		FileOperations.deleteFile(Commons.RSAT_OUTPUT_FILENAME);
		
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try {
			fileWriter = new FileWriter(Commons.RSAT_OUTPUT_FILENAME,true);
			bufferedWriter = new BufferedWriter(fileWriter);
			
			matrixScan(tfExonBasedKeggPathwayBaseDirectory,bufferedWriter);
			matrixScan(tfRegulationBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(tfAllBasedKeggPathwayBaseDirectory,bufferedWriter);

//			matrixScan(tfCellLineExonBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(tfCellLineRegulationBasedKeggPathwayBaseDirectory,bufferedWriter);
//			matrixScan(tfCellLineAllBasedKeggPathwayBaseDirectory,bufferedWriter);
			
			//Close bufferedWriter
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}
				

}