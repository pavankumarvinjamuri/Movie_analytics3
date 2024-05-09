import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

import scala.collection.mutable.ArrayBuffer

object latest_rlz {
def main(args:Array[String]):Unit={
  val spark=SparkSession.builder().appName("as").master("local[*]").getOrCreate()
  val schema=StructType(Seq(
    StructField("Id",IntegerType,nullable=false),
    StructField("Movie",StringType,nullable = true),
    StructField("Gener",StringType,nullable = true),
  ))
  val df = spark.read
    .option("delimiter", "::")
    .csv("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/movies.dat")
    .toDF("Id","Movie", "Gener")
  import spark.implicits._
 /* val rowRDD = df.map(line => {
    val parts = line.split("\\(")
    val title = parts(0).trim
    val year = parts(1).replaceAll("[^0-9]", "").trim
    Row(title, year)
  })

  // Create DataFrame
  val movieDF = spark.createDataFrame(rowRDD, schema)
  movieDF.show(10)*/
  val df1=df.select("Movie")
  /*val df2=df1.map(l=>{
    val pa=l.split("\\(")
    val movie=pa(0).trim()
    val year=pa(1).replaceAll("[^0-9]","").trim()
    Row(movie,year)
  })*/
  //df2.show(10)
  spark.stop()
}
}
