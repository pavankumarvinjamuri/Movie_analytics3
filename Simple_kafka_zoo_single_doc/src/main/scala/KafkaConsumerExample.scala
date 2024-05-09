import java.util.Properties
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import scala.jdk.CollectionConverters._

object KafkaConsumerExample {
  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092")
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer")

    val consumer = new KafkaConsumer[String, String](props)

    val topic = "test-topic" // Replace with the Kafka topic you want to consume messages from
    consumer.subscribe(java.util.Collections.singletonList(topic))

    while (true) {
      val records = consumer.poll(java.time.Duration.ofMillis(1))
      for (record <- records.asScala) {
        println(record)
        println(s"Received message: ${record.value()}")
      }
    }
  }
}
