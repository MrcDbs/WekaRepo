package iris.execution;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataSetReader {
	public static Leggidataset readDataFile(String filename) {
			Leggidataset inputReader = null;
			try {
				inputReader = new Leggidataset(new FileReader(filename));
			}
			catch (FileNotFoundException ex) {
				System.err.println("File non trovato "+ filename);
			}
			return inputReader;
	}
//	 public static Instances readDataFile(String filename) {
//	        Instances data = null;
//	        try {
//	            // Load the dataset using Weka's DataSource
//	            DataSource dataSource = new DataSource(filename);
//	            data = dataSource.getDataSet();
//	        } catch (Exception ex) {
//	            // Handle errors (e.g., file not found)
//	            System.err.println("Error reading file: " + filename);
//	            ex.printStackTrace();
//	        }
//	        return data;
//	    }

	    public static void main(String[] args) {
	    	Leggidataset datafile = WekaUtilis.readDataFile("/User/nero/Desktop/iris.arff");
	    	Instances data = new Instances(datafile);
	    	data. setClassIndex(data . numAttributes() -1);
	    	data.randomize(new java.util.Random());
	    	
	    	for (int k=0; k < WekaUtils.numberOfFolds; k++){
	    		trainingSet = data.trainCV(WekaUtils.numberOfFolds.k); 
	    		restSet = data.testCV(WekaUtils.numberOfFolds, k);
	    		int labelSize = (int) Math.round(trainingSet.numInstances() * WekaUtils.percentageSplit / 100);
	    		int noLabelSize = trainingSet.numInstances() - labelSize;
	    		Instances trainLabel = new Instances(trainingSet, 0, labelSize);
	    		Instances trainNoLabel = new Instances(trainingSet, 0, nolabelSize);
	    	}
	    	Remove filter = new Remove();
	    	EuclideanDistance df = new EuclideanDistance();
	    	filter.setAttributeIndices("" + (trainNoLabel.classIndex()+1));
	    	filter. setInputFormat(trainNoLabel);
	    	Instances dataClusterer = Filter.useFilter(trainNoLabel, filter);
	    	SimpleKMeans model = new SimpleKMeans();
	    	model. setNumCluster(3);
	    	model. setDistanceFunction(df);
	    	model. buildClusterer(dataClusterer);
	    	Instances centroid = nodel.getClusterCentroids();
	    	for (int k = 0; k < trainLabel2.size(); k++){
	    		Instance labeledInstance = trainLabel.get(j);
	    		Instance instance = trainLabel2.instance(j);
	    		EuclideanDistance e = new EuclideanDistance(centroid); double[] distarray = new double[3];
	    		distarray[0] = e.distance(instance, centroid.get(0));
	    		distarray[1] = e.distance(instance, centroid.get(1));
	    		distarray[2] = e.distance(instance, centroid.get(2));
	    		int centroidIndexMin = WekaUtils.indexofSmallest(distarray);
	    		if (centroidIndexMin == 0) {
	    			if (labeledInstance.classValue() == 0.0){
	    				countCentroide0Label0++;
	    			} else if (labeledInstance.classValue() == 1.0){
	    				countCentroide0Label1++;
	    			} else {
	    				countCentroide0Label2++;
	    		} else if (centroidIndexMin == 1) {
	    				if (labeledInstance.classValue() == 0.0)
	    					countCentroide1 Label0++;
	    				else if (labeledInstance.classValue() == 1.0 ) {
	    					countCentroide1 Label1++;
	    				}else {
		    				countCentroide1 Label2++;
		    				}
	    		} else {
	    				
	    				if (labeledInstance.classValue() == 0.0) {
	    					countCentroide2 Label0++;
	    				}
	    				else if (labeledInstance.classValue() == 1.0 ) {
	    					countCentroide2 Label1++;
	    				}
	    				else {
	    					countCentroide2 Label2++;
	    				}
	    		}
	    		double[] test1 = new double[3];
	    		test1[0] = countCentroide0Label0;
	    		test1[1] = countCentroide0Label1;
	    		test1[2] = countCentroide0Label2;
	    		double[] test2 = new double[3];
	    		test2[0] = countCentroide1Label0;
	    		test2[1] = countCentroide1Label1;
	    		test2[2] = countCentroide1Label2;
	    		double[] test3 = new double[3];
	    		test3[0] = countCentroide2Label0;
	    		test3[1] = countCentroide2Label1;
	    		test3[2] = countCentroide2Label2;
	    		double[] test3 = new double[3];

	    		centroidClasses[0] = (double) (WekaUtils.indexOfGreater(test1));
	    		centroidClasses[1] = (double) (WekaUtils.indexOfGreater(test2));
	    		centroidClasses[2] = (double) (WekaUtils.indexOfGreater(test3));
	    		
	    		for (int i = 0; i < testSet2.size(); i++) {
	    			int count = 1;
	    			Instance instance = testSet2.get(i);
	    			instance labeledInstance = testSet.get(i);
	    			EuclideanDistance e = new EuclideanDistance(centroid);
	    			double[] distarray = new double[3];
	    			distarray[0] = e.distance(instance, centroid.get(0)); distarray[1] = e.distance(instance, centroid.get(1));
	    			distarray[2] = e.distance(instance, centroid.get(2));

	    			int centroidIndexMin = WekaUtils.indexOfSmallest(distarray); double result = centroidClasses[centroidIndexMin];

	    			double classValue = labeledInstance.classValue();
	    			confusionMatrix[(int) result][(int) classValue] = confusionMatrix[(int)result][(int) classValue] + count;
	    		}
	    		double TP0 = WekaUtils.numTruePositives(confusionMatrix, 0);
	    		double TP1 = WekaUtils.numTruePositives(confusionMatrix, 1);
	    		double TP2 = WekaUtils.numTruePositives(confusionMatrix, 2);
	    		double TN0 = WekaUtils.numTrueNegatives(confusionMatrix, 0);
	    		double TN1 = WekaUtils.numTrueNegatives(confusionMatrix, 1);
	    		double TN2 = WekaUtils.numTrueNegatives(confusionMatrix, 2);
	    		double FP0 = WekaUtils.numFalsePositives(confusionMatrix, 0);
	    		double FP1 = WekaUtils.numFalsePositives(confusionMatrix, 1);
	    		double FP2 = WekaUtils.numFalsePositives(confusionMatrix, 2);
	    		double FN0 = WekaUtils.numFalseNegatives(confusionMatrix, 0);
	    		double FN1 = WekaUtils.numFalseNegatives(confusionMatrix, 1);
	    		double FN2 = WekaUtils.numFalseNegatives(confusionMatrix, 2);
	    		
	    		TP = TP0+TP1+TP2;
	    		TN = TN0+TN1+TN2;
	    		FP = FP0+FP1+FP2;
	    		FN = FN0+FN1+FN2;
	    		if (TP+TN+FP+FN>0){
	    			accuracy[k]=(TP+TN) / (TP+TN+FP+FN);
	    		}
	    		truePositiveRateLabel0[k] = WekaUtils.truePositiveRate(TP0,FN0);
	    		truePositiveRateLabel1[k] = WekaUtils.truePositiveRate(TP1,FN1);
	    		truePositiveRateLabel2[k] = WekaUtils.truePositiveRate(TP2,FN2);
	    		falsePositiveRateLabel0[k] = WekaUtils.truePositiveRate(FP0,TN0);
	    		falsePositiveRateLabel0[k] = WekaUtils.truePositiveRate(FP1,TN1);
	    		falsePositiveRateLabel0[k] = WekaUtils.truePositiveRate(FP2,TN2);
	    		
	    		totalAccuracy += accuracy[k];
	    		totalTP0 += truePositiveRateLabel0[k];
	    		totalTP1 += truePositiveRateLabel1[k];
	    		totalTP2 += truePositiveRateLabel2[k];
	    		totalFP0 += falsePositiveRateLabel0[k];
	    		totalFP1 += falsePositiveRateLabel1[k];
	    		totalFP2 += falsePositiveRateLabel2[k];
	    		avgAccuracy = (totalAccuracy / WekaUtils.numberOfFolds) * 100;
	    		avgTotalTP0 = (totalTP0 / WekaUtils.numberOfFolds) * 100;
	    		avgTotalTP1 = (totalTP1 / WekaUtils.numberOfFolds) * 100;
	    		avgTotalTP2 = (totalTP2 / WekaUtils.numberOfFolds) * 100;
	    		avgTotalFP0 = (totalFP0 / WekaUtils.numberOfFolds) * 100;
	    		avgTotalFP1 = (totalFP1 / WekaUtils.numberOfFolds) * 100;
	    		avgTotalFP2 = (totalFP2 / WekaUtils.numberOfFolds) * 100;
	    		System.out.println(
	    		 "TPR 0 - " + String.format("%.2f%%", avgTotalTP0)+"\n"+
	    		 "FPR 0 - " + String.format("%.2f%%", avgTotalFP0)+"\n"+
	    		 "TPR 1 - " + String.format("%.2f%%", avgTotalTP1)+"\n"+
	    		 "FPR 1 - " + String.format("%.2f%%", avgTotalFP1)+"\n"+
	    		 "TPR 2 - " + String.format("%.2f%%", avgTotalTP2)+"\n"+
	    		 "FPR 2 - " + String.format("%.2f%%", avgTotalFP2)+"\n"+
	    		 "Accuracy - " + String.format("%.2f%%", avgAccuracy)+"\n"
	    		 );
//	        // Specify the path to the dataset
//	        String filepath = "/User/nero/Desktop/iris.arff";  // Adjust to your file's path
//
//	        // Read the dataset
//	        Instances data = readDataFile(filepath);
//
//	        // If the dataset is successfully loaded
//	        if (data != null) {
//	            // Set the class index (usually the last column in a classification problem)
//	            data.setClassIndex(data.numAttributes() - 1);
//
//	            // Randomize the dataset (to avoid order bias)
//	            data.randomize(new java.util.Random());
//
//	            // Print some basic details about the dataset
//	            System.out.println("Dataset loaded and randomized successfully!");
//	            System.out.println("Number of instances: " + data.numInstances());
//	            System.out.println("Class attribute: " + data.classAttribute().name());
//	        } else {
//	            System.out.println("Failed to load the dataset.");
//	        }
	        
	    }
}
