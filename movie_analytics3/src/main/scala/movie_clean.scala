import org.apache.spark
import org.apache.spark.sql.SparkSession

object movie_clean {
def main(args: Array[String]):Unit={
  val spark=SparkSession.builder().appName("Movie Anal").master("local[*]").getOrCreate()
  import spark.implicits._
  val mov=spark.read.textFile("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/movies.dat")
  //print(mov.printSchema())
  //mov.take(10).foreach(println)
  val m_id=mov.map(lines=>lines.split("::")(0)).toDF("MovieID")
  val title=mov.map(l=>l.split("\\(")(0)).toDF("Movie Title")
  val mov_ye=mov.map(lines=>lines.substring(lines.lastIndexOf("(")+1,lines.lastIndexOf(")"))).toDF("Year")
  val m_ge=mov.map(lines=>lines.split("::")(2)).toDF("Genres")
  title.take(10).foreach(println)
  mov_ye.take(10).foreach(println)
  m_ge.take(10).foreach(println)
  //print(m_id.take(5).mkString("Array(", ", ", ")"))
}
}
