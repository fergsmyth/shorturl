## Problem : Create a url shortening service

* System should be able to store “enough” urls
* System should handle 10K request per second
* 90 percent of all request should respond in less than 10ms for the read request
* Save money when not receiving enough load

### Approach

POST method takes a url string to shorten.  
URL is Base64 encoded and stored to the database.
Cache and return existing URLs.
 