## Run ELK stack

```
cd docker-elk
docker-compose up
```

Kibana: `localhost:5601`

Logstash configuration: [docker-elk/pipeline/logstash.conf](docker-elk/pipeline/logstash.conf)
* listens on port 12201 for GELF messages
* Prints all incomming messages to console
* Forwards all incomming messages to Elasticsearch

## Send test message to GELF

Then from terminal:
```bash
for i in {1..10} ; do echo '{"version": "1.1","host":"david.org","short_message":"A short message that helps you identify what is going on","full_message":"Backtrace here\n\nmore stuff","level":1,"_user_id":9001,"_some_info":"foo","_some_env_var":"bar"}' | nc -w 1 -u localhost 12201  ; done
```

## Log4j GELF appender configuration

File: [src/main/java/resources/log4j2.properties](src/main/java/resources/log4j2.properties)

```properties
appender.gelf.type = Gelf
appender.gelf.name = GELF
appender.gelf.host = udp:localhost
appender.gelf.port = 12201
appender.gelf.extractStackTrace = true
appender.gelf.filterStackTrace = true
```

