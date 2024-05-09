import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object getpartitions {
def main(args:Array[String]):Unit={
  //val spark=SparkSession.builder().master("local[*]").appName("Get data from partitions").getOrCreate()
  val conf = new SparkConf().setAppName("PrintPartitionData").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val data=sc.parallelize(1 to 1000,2)
  val par=1
  val da=data.filter(x => x % data.getNumPartitions == par)
  da.collect().foreach(println)
  sc.stop()
}
}
