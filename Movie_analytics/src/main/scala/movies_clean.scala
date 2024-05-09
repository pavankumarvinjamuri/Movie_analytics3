
object movies_clean {
def main(): Unit={
  
val mov=spark.read.textfile("/Users/pavansravya/IdeaProjects/Movie_analytics/src/Data/movies.dat")
  print("mov")
  print(mov)
}
}
