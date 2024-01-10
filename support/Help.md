Set the API key: https://app.localstack.cloud/workspace/auth-token

```shell
export LOCALSTACK_AUTH_TOKEN="whatever_key_value"
```

```shell
localstack extensions install localstack-extension-snowflake
```


Error:
```
Exception in thread "main" net.snowflake.client.jdbc.SnowflakeSQLException: JDBC driver encountered communication error. Message: Exception encountered for HTTP request: No trusted certificate found.
```
Solution:
Disable the OSCP validation in the Snoflake connector. Add `insecureMode` to the options.
```scala
var sfOptions = Map(
    "sfURL" -> "snowflake.localhost.localstack.cloud",
    "sfUser" -> "test",
    "sfPassword" -> "test",
    "sfDatabase" -> "test",
    "sfSchema" -> "test",
    "sfWarehouse" -> "test",
    "insecureMode" -> "true",
    )
```