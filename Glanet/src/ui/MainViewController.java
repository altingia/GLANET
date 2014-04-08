package ui;

import javax.swing.JPanel;

import jaxbxjctool.*;
import ui.MainView.*;
import wholegenome.nonoverlappingbasepairs.usingintervaltree.*;
import processinputdata.*;
import rsat.*;
import ncbi.*;
import create.encode.*;
import create.ucscgenome.*;
import empiricalpvalues.*;
import annotate.intervals.parametric.*;
import augmentation.results.*;
import adhoc.*;

public class MainViewController extends ViewController implements MainViewDelegate {
	
	private MainView mainView;

	public MainViewController( JPanel contentPanel) {
		super(contentPanel);
		
		loadView();
	}

	@Override
	public void loadView() {
		
		if( mainView != null){
			contentPanel.remove(mainView);
		}
		
		mainView = new MainView();
		mainView.setDelegate( this);
		contentPanel.add(mainView);
	}

	@Override
	public void presentViewController(ViewController viewController) {

		contentPanel.removeAll();
		contentPanel.invalidate();
		viewController.loadView();
		contentPanel.revalidate();
		
	}

	@Override
	public void dismissViewController() {
		contentPanel.removeAll();
		contentPanel.add(mainView);
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
	public void startRunActionsWithOptions(String inputFileName, 
										   String outputFolder,
										   String inputFileFormat,
										   String numberOfPermutations,
										   String falseDiscoveryRate,
										   String generateRandomDataMode,
										   String writeGeneratedRandomDataMode,
										   String writePermutationBasedandParametricBasedAnnotationResultMode,
										   String writePermutationBasedAnnotationResultMode,
										   String dnaseEnrichment,
										   String histoneEnrichment,
										   String tfAndKeggPathwayEnrichment,
										   String cellLineBasedTfAndKeggPathwayEnrichment,
										   String jobName) {
		
		String[] args =   { inputFileName,
							outputFolder,
							inputFileFormat,
							numberOfPermutations,
							falseDiscoveryRate,
							generateRandomDataMode,
							writeGeneratedRandomDataMode,
							writePermutationBasedandParametricBasedAnnotationResultMode,
							writePermutationBasedAnnotationResultMode,
							dnaseEnrichment,
							histoneEnrichment,
							tfAndKeggPathwayEnrichment,
							cellLineBasedTfAndKeggPathwayEnrichment,
							jobName};
		
		InputDataProcess.main(args);
		RemoveOverlaps.main(args);
		HumanRefSeq2Gene.main(args);
		CreateChromosomeBasedDnaseTfbsHistoneFilesUsingEncodeUsingIntervalTreeSorting.main(args);
		CreateIntervalFileUsingUCSCGenomeUsingIntervalTreeSorting.main(args);
		WriteAllPossibleNames.main(args);
		CalculateNumberofNonOverlappingBasePairsinWholeGenomeUsingIntervalTree.main(args);
		AnnotateGivenIntervalsWithGivenParameters.main(args);
		AnnotatePermutationsUsingForkJoin_withEnrichmentChoices.main(args);
		CollectionofPermutationsResults.main(args);
		AugmentationofEnrichedElementswithIntervals.main(args);
		GenerationofSequencesandMatricesforGivenIntervals.main(args);
		RSATMatrixScanClient.main(args);
	}
}