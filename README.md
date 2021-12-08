# ctf-wutfaces-resources
MatesCTF2018 WutFaces - A CTF challenge made by @tint0 with my own solution
# About
* wutfaces-1.0.1-SNAPSHOT.war - war file for deploying to Tomcat (tested with Tomcat9 on Ubuntu 20.04.3)
* wutfaces-1.0.1-SNAPSHOT - Extracted from war file
* `src/BuildPayload.java` - Program for generating payload, it generates 2 files `payload.bin` and `encodedPayload.txt`
* `payload.bin` - Raw serialized payload
* `encodedPayload.txt` - Complete payload with proper encoding, ready to shoot in HTTP request
