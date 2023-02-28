
public class StandardDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {14.5,19.2,23.3,12.9,23.7,14.2,22.7,16.1,22.5,28.1,21.6,16.5,11.3};
		System.out.println(StandardDev.getSampStandardDev(a));
	}
	public static double getMean(double[] dataset) {
		double mean,total;
		total = 0;
		for(int i=0;i<dataset.length;i++) {
			total+= dataset[i];
		}
		mean = total/dataset.length;
		return mean;
	}
	public static double getVariance(double[] dataset) {
		double avg = StandardDev.getMean(dataset);
		double variance = 0;
		for(int i=0;i<dataset.length;i++) {
			variance += Math.pow((dataset[i]-avg),2);
		}
		variance = variance/(dataset.length-1);
		return variance;
	}
	public static double getSampStandardDev(double[] dataset) {
		
		double standardDeviation;
		standardDeviation = Math.sqrt(getVariance(dataset)/(dataset.length-1));
		return standardDeviation;
	}
	public static double getZScore(double[] dataset,double value) {
		
		double standardDev = StandardDev.getSampStandardDev(dataset);
		double mean = StandardDev.getMean(dataset);
		double zScore = (value-mean)/standardDev;
		
		return zScore;
	}
	
}
