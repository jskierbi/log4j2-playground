## Run ELK stack

```
docker-compose up
```

localhost:5601 -> index should be available already.
If in doubt - send a test message to 

## Send test message to GELF


Then from terminal:
```bash
for i in {1..10} ; do echo '{"version": "1.1","host":"david.org","short_message":"A short message that helps you identify what is going on","full_message":"Backtrace here\n\nmore stuff","level":1,"_user_id":9001,"_some_info":"foo","_some_env_var":"bar"}' | nc -w 1 -u localhost 12201  ; done
```

### Check if Logstash is getting messages

```
input {
    gelf {
        type => gelf
        port => 12201
    }
}
output {
    stdout {}
}
```

then `docker logs logstash --follow`
messages are printed on stdout
