
Test multiple loggers using slf4j-api

Run `mvn clean install`

Check logs at `logs/`

```
logs
├── app.log4j12.json
├── app.log4j12_wrong.json
├── app.log4j2.json
├── app.log4j2.log
├── app.logback.json
└── app.logback.log
```


# log4j-2 
Uses JSONLayout

See [log4j2.xml](test-log4j2/src/main/resources/log4j2.xml)

```
{
  "instant": {
    "epochSecond": 1600707573,
    "nanoOfSecond": 211000000
  },
  "thread": "main",
  "level": "INFO",
  "loggerName": "test.core.MyApplication",
  "message": "Hello World!",
  "endOfBatch": false,
  "loggerFqcn": "org.apache.logging.slf4j.Log4jLogger",
  "contextMap": {},
  "threadId": 1,
  "threadPriority": 5
}
{
  "instant": {
    "epochSecond": 1600707573,
    "nanoOfSecond": 280000000
  },
  "thread": "my-thread",
  "level": "ERROR",
  "loggerName": "test.core.MyApplication",
  "message": "This is an exception",
  "thrown": {
    "commonElementCount": 0,
    "localizedMessage": "DummyException",
    "message": "DummyException",
    "name": "java.lang.Exception",
    "cause": {
      "commonElementCount": 5,
      "localizedMessage": "Nested exception",
      "message": "Nested exception",
      "name": "java.lang.IllegalArgumentException",
      "extendedStackTrace": "java.lang.IllegalArgumentException: Nested exception\n\tat test.core.MyApplication.otherFunction1(MyApplication.java:53) ~[test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.otherFunction2(MyApplication.java:49) ~[test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction(MyApplication.java:42) ~[test-core-1.0-SNAPSHOT.jar:?]\n"
    },
    "extendedStackTrace": "java.lang.Exception: DummyException\n\tat test.core.MyApplication.myFunction(MyApplication.java:44) [test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction1(MyApplication.java:37) [test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction2(MyApplication.java:34) [test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction3(MyApplication.java:31) [test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction4(MyApplication.java:28) [test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication$1.run(MyApplication.java:18) [test-core-1.0-SNAPSHOT.jar:?]\nCaused by: java.lang.IllegalArgumentException: Nested exception\n\tat test.core.MyApplication.otherFunction1(MyApplication.java:53) ~[test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.otherFunction2(MyApplication.java:49) ~[test-core-1.0-SNAPSHOT.jar:?]\n\tat test.core.MyApplication.myFunction(MyApplication.java:42) ~[test-core-1.0-SNAPSHOT.jar:?]\n\t... 5 more\n"
  },
  "endOfBatch": false,
  "loggerFqcn": "org.apache.logging.slf4j.Log4jLogger",
  "contextMap": {},
  "threadId": 12,
  "threadPriority": 5
}
```

# log4j-1.2 
Uses net.logstash.log4j:jsonevent-layout
```
{
  "@timestamp": "2020-09-21T16:59:34.271Z",
  "source_host": "gelboy",
  "file": "MyApplication.java",
  "method": "run",
  "level": "INFO",
  "line_number": "14",
  "thread_name": "main",
  "@version": 1,
  "logger_name": "test.core.MyApplication",
  "message": "Hello World!",
  "class": "test.core.MyApplication",
  "mdc": {}
}
{
  "exception": {
    "stacktrace": "java.lang.Exception: DummyException\n\tat test.core.MyApplication.myFunction(MyApplication.java:44)\n\tat test.core.MyApplication.myFunction1(MyApplication.java:37)\n\tat test.core.MyApplication.myFunction2(MyApplication.java:34)\n\tat test.core.MyApplication.myFunction3(MyApplication.java:31)\n\tat test.core.MyApplication.myFunction4(MyApplication.java:28)\n\tat test.core.MyApplication$1.run(MyApplication.java:18)\nCaused by: java.lang.IllegalArgumentException: Nested exception\n\tat test.core.MyApplication.otherFunction1(MyApplication.java:53)\n\tat test.core.MyApplication.otherFunction2(MyApplication.java:49)\n\tat test.core.MyApplication.myFunction(MyApplication.java:42)\n\t... 5 more",
    "exception_class": "java.lang.Exception",
    "exception_message": "DummyException"
  },
  "source_host": "gelboy",
  "method": "myFunction",
  "level": "ERROR",
  "message": "This is an exception",
  "mdc": {},
  "@timestamp": "2020-09-21T16:59:34.281Z",
  "file": "MyApplication.java",
  "line_number": "44",
  "thread_name": "my-thread",
  "@version": 1,
  "logger_name": "test.core.MyApplication",
  "class": "test.core.MyApplication"
}
```

# loggback
Uses net.logstash.logback:logstash-logback-encoder

```
{
  "@timestamp": "2020-09-21T17:59:33.902+01:00",
  "@version": 1,
  "message": "Hello World!",
  "logger_name": "test.core.MyApplication",
  "thread_name": "main",
  "level": "INFO",
  "level_value": 20000,
  "HOSTNAME": "gelboy",
  "env": "prod"
}
{
  "@timestamp": "2020-09-21T17:59:33.921+01:00",
  "@version": 1,
  "message": "This is an exception",
  "logger_name": "test.core.MyApplication",
  "thread_name": "my-thread",
  "level": "ERROR",
  "level_value": 40000,
  "stack_trace": "java.lang.Exception: DummyException\n\tat test.core.MyApplication.myFunction(MyApplication.java:44) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.myFunction1(MyApplication.java:37) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.myFunction2(MyApplication.java:34) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.myFunction3(MyApplication.java:31) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.myFunction4(MyApplication.java:28) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication$1.run(MyApplication.java:18) [test-core-1.0-SNAPSHOT.jar:na]\nCaused by: java.lang.IllegalArgumentException: Nested exception\n\tat test.core.MyApplication.otherFunction1(MyApplication.java:53) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.otherFunction2(MyApplication.java:49) [test-core-1.0-SNAPSHOT.jar:na]\n\tat test.core.MyApplication.myFunction(MyApplication.java:42) [test-core-1.0-SNAPSHOT.jar:na]\n\t... 5 common frames omitted\n",
  "HOSTNAME": "gelboy",
  "env": "prod"
}
```