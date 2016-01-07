package com.emc.network.sparkanalysis;

import java.io.IOException;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import com.emc.network.sparkanalysis.logic.ProcessVideoStreamData;

public class VideoLogStreamAnalytics {
	
	
	public static void main(String[] args) throws IOException {
		SparkConf conf = new SparkConf().setAppName("faebookStream");
	    JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(15));
        JavaDStream<String> stream = jssc.textFileStream("/Users/sboynenpalli/Desktop/shashankOfficeMackbook/sparkinputfolder");
        stream.print(10);
         ProcessVideoStreamData processData = new ProcessVideoStreamData();
         processData.processData(stream);
        jssc.start();
		jssc.awaitTermination();
	
	
    
}

}
