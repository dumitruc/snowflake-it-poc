import org.apache.spark.sql.{functions => sparkFunctions}
import net.snowflake.spark.snowflake.Utils.SNOWFLAKE_SOURCE_NAME

object SnowflakeDataProcessingJob extends Spark {

  var sfOptions = Map(
    "sfURL" -> "snowflake.localhost.localstack.cloud",
    "sfUser" -> "test",
    "sfPassword" -> "test",
    "sfDatabase" -> "test",
    "sfSchema" -> "test",
    "sfWarehouse" -> "test",
    "insecureMode" -> "true",
    "sfTimezone"-> "Europe/London"
  )

  def run(): Unit = {
    val sfReader = sparkSession.read
      .format(SNOWFLAKE_SOURCE_NAME)
      .options(sfOptions)
      .option("autopushdown", "off")

    val sfDataFrameReader = sfReader
      .option("dbTable", "table1")
      // .option("query", "select * from table1")
      .load()

    sfDataFrameReader.limit(1).show(false)
//    sfDataFrameReader.limit(1).write.format("csv").save("output.csv")

  }

}
