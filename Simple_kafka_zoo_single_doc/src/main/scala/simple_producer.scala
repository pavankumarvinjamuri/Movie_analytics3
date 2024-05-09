import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object simple_producer {
def main(args:Array[String]): Unit = {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:29092") // Kafka broker(s)
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val topic = "test-topic" // Replace with the Kafka topic you want to send messages to

  for (i <- 1 to 10) {
    val message = s"Message $i" // Create message with unique identifier
    val record = new ProducerRecord[String, String](topic, message)

    producer.send(record)
    println(s"Sent message: $message")

    Thread.sleep(10000) // Sleep for 10 seconds
  }

  producer.close()
  }
}
