## Problem : Create a url shortening service

* System should be able to store “enough” urls
* System should handle 10K request per second
* 90 percent of all request should respond in less than 10ms for the read request
* Save money when not receiving enough load

### Approach

POST method takes a url string to shorten.  
URL is Base64 encoded and stored to the database.
Cache and return existing URLs.
 
##### URL Length
The total number of valid characters for a URL path segment is 64.  
* A-Z(26)
* a-z(26)
* 0–9(10)
* _, -(2)

A length of 6 characters gives a total of 68 billion combos (64^6)

Should urls be encodede: Using %20% etc.
Counter overflow for sequence? Sequences can have 1000 septillion entries...
   
Database indexes - keystore vs mysql

####Metadata
Metadata about key url map? Number of hits e.g.

######Protect against spam request? 
* CAPTCHA
* Banning specific target url 
* Banning originator ip
* Rate limiting
* API limiting for concurrent users
* ML statistics techniques.

Updates to metadata on same row as URL table for high traffic entries.

Tracking information about the short name usage and where its used.

Shortening a shortened url, should it be allowed?

Scaling up service. Distributing key space among nodes. 

hash % n to select node, n changes?

What happens if a sequence number is used for a key and there are multiple nodes creating keys?

Cached looks instead of db calls.  

Keep entries or purge? how to track when to purge?






 
