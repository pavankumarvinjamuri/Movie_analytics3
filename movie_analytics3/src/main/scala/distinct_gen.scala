import org.apache.spark.sql.SparkSession
import org.apache.spark.rdd.RDD
import scala.collection.mutable.ArrayBuffer

object distinct_gen{
   def main(args:Array[String]):Unit={
     val spark=SparkSession.builder().master("local[*]").appName("ds").getOrCreate()
     import spark.implicits._
     val mov=spark.read.textFile("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/movies.dat")
     val gen=mov.map(l=>l.split("::")(2)).toDF("Gener")
     //gen.take(10).foreach(println)
     val df1=gen.flatMap(_.getString(0).split("\\|")).toDF("gener").distinct()
     df1.select("gener").show
   }
 }
