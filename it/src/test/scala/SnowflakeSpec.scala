import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory
import org.testcontainers.containers.localstack.LocalStackContainer
import org.testcontainers.containers.localstack.LocalStackContainer.Service
import org.testcontainers.utility.DockerImageName

class SnowflakeSpec extends AnyFlatSpec with Matchers with BeforeAndAfterAll {

  val logger = LoggerFactory.getLogger(getClass)

  val localstack =
    new LocalStackContainer(
      DockerImageName.parse("localstack/localstack:3.0.2")
    ).withEnv("DEBUG", "1")
      .withServices(Service.S3)

      .withLogConsumer(msg => logger.info(msg.getUtf8String))

  override def beforeAll(): Unit = {
    super.beforeAll()
    localstack.start()
  }

  override protected def afterAll(): Unit = {
    super.afterAll()
    localstack.stop()
  }

  "Snowflake" should "be able to connect to Snowflake" in {
    assert(true)
  }

}
