package es.uniovi.asw.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import kafka.consumer.KafkaStream;

public class KafkaConsumer {
	private static org.apache.kafka.clients.consumer.KafkaConsumer<String, String> kfc;
	public KafkaConsumer() {
		if(kfc == null) {
			Properties prop = new Properties();
			prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
			kfc = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(prop);
		}
	}
	
	public void Subscribe(String topic) {
		kfc.subscribe(Arrays.asList(topic));
	}
	
	public void Read() {
		while(true) {
			ConsumerRecords<String, String> cr = kfc.poll(200);
			for (ConsumerRecord<String, String> record : cr)
				System.out.println(record.key() + " : " + record.value());
		}
	}
}
