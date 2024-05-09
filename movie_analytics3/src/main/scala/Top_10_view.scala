import org.apache.spark.sql.SparkSession

object Top_10_view {
def main(args: Array[String]):Unit={
  val spark=SparkSession.builder().master("local[*]").appName("Top 10 movies").getOrCreate()
  import spark.implicits._
  val vi=spark.read.textFile("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/ratings.dat")
  //vi.take(10).foreach(println)
  val df2=vi.map(l=>l.split("::")(1)).toDF("MovieID")
  //df2.take(10).foreach(println)
  //df2.columns.foreach(println)
  val df3=df2.groupBy("MovieID").count().orderBy($"count".desc)
  val df4=df3.select("MovieID")
  df4.show(10)
  spark.stop()
}
}
