# Clojure echo-server

Ping and echo your request.

## Usage

Install dependencies using the command `lein deps`.

Launch the application using the command `lein run`.

Once the application has started, visit the following URLs via
a browser or cURL:

* <localhost:8080/ping>
* <localhost:8080/echo?message=hello>

For example:

```sh
$ curl -i "localhost:8080/ping"
HTTP/1.1 200 OK
Date: Sun, 13 Jan 2019 06:55:23 GMT
Strict-Transport-Security: max-age=31536000; includeSubdomains
X-Frame-Options: DENY
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Content-Type: text/plain
Transfer-Encoding: chunked
Server: Jetty(9.3.8.v20160314)

pong

$ curl -i "localhost:8080/echo?message=hello"
HTTP/1.1 200 OK
Date: Sun, 13 Jan 2019 06:55:33 GMT
Strict-Transport-Security: max-age=31536000; includeSubdomains
X-Frame-Options: DENY
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Content-Type: text/plain
Transfer-Encoding: chunked
Server: Jetty(9.3.8.v20160314)

hello
```

## License
