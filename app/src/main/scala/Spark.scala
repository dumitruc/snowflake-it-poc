import org.apache.spark.sql.SparkSession


trait Spark extends Serializable{

  lazy val sparkSession: SparkSession = SparkSession
    .builder()
    .appName("snowflake-data-processor")
    .config("spark.master", "local")
    .getOrCreate()
}