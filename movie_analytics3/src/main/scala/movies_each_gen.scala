import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import scala.collection.mutable.ArrayBuffer

object movies_each_gen {
def main(args: Array[String]):Unit={
  val spark=SparkSession.builder().appName("as").master("local[*]").getOrCreate()
  import spark.implicits._
  val df1=spark.read.textFile("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/movies.dat")
  val df2=df1.map(l=>l.split("::")(2)).toDF("gener")
  val df3=df2.flatMap(_.getString(0).split("\\|")).toDF("types").groupBy("types").count()
  df3.collect().take(100).foreach(println)
}
}
