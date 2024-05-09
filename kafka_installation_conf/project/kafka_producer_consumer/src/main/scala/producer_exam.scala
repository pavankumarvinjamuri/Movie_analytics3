import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer,ProducerRecord}

object producer_exam{
  def main(args: Array[String]):Unit={
    val prop=new Properties()
    prop.put("bootstrap.servers","localhost:9092")
    prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer=new KafkaProducer()
  }
}