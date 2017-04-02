package es.uniovi.asw.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducer {
	private static org.apache.kafka.clients.producer.KafkaProducer<String, String> kfp;
	
	public KafkaProducer() {
		if(kfp == null) {
			Properties prop = new Properties();
		    prop.put("bootstrap.servers", "localhost:9092");
			kfp = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(prop);
		}
		
	}
	
	public void SendMessage(String topic, String message) {
		kfp.send(new ProducerRecord<String, String>(topic, message));
	}
}
