object Main extends App {

  val job = SnowflakeDataProcessingJob

  job.run()

  println(s"$job completed successfully")
}