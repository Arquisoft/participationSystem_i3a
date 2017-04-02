package es.uniovi.asw.kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducer {
	private static org.apache.kafka.clients.producer.KafkaProducer<String, String> kfp;
 
	public KafkaProducer() {
		if (kfp == null) {
			Properties prop = new Properties();
			prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        prop.put(ProducerConfig.RETRIES_CONFIG, 0);
	        prop.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
	        prop.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	        prop.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
	        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        prop.setProperty(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, "10000");
			kfp = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(prop);
		}

	}

	public void SendMessage(String topic, String message) {
		kfp.send(new ProducerRecord<String, String>(topic, message));
		kfp.close();
	}
}
