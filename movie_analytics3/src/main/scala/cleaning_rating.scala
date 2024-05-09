import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object cleaning_rating {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("cleaning rating")
      .getOrCreate()

    import spark.implicits._ // Import implicits for DataFrame operations

    val ra = spark.read.textFile("/Users/pavansravya/IdeaProjects/movie_analytics3/src/main/Data/ratings.dat")

    val schemaString = "UserID MovieID Rating Timestamp"
    val schema = StructType(schemaString.split(" ").map(fieldName => StructField(fieldName, StringType, true)))

   // val rowRDD = ra.map(_.split("::")).map(x => Row(x(0), x(1), x(2), x(3)))
    //rowRDD.take(10).foreach(print)
    // Create a DataFrame from the RDD of Rows
    //val ratings = spark.createDataset(rowRDD)(Encoders.product[Row]).toDF(schema.fieldNames: _*)
    //ratings.show()

    spark.stop()
  }
}