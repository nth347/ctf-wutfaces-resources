# ctf-wutfaces-resources
MatesCTF2018 WutFaces - A CTF challenge made by @tint0 with my own solution
# About
* wutfaces-1.0.1-SNAPSHOT.war - war file for deploying to Tomcat (tested with Tomcat9 on Ubuntu 20.04.3)
* wutfaces-1.0.1-SNAPSHOT - Extracted from war file
* `src/BuildPayload.java` - Program for generating payload, it generates 2 files `payload.bin` and `encodedPayload.txt`
* `payload.bin` - Raw serialized payload
* `encodedPayload.txt` - Complete payload with proper encoding, ready to shoot in HTTP request
# Reference
* tin0's post - [https://blog.tint0.com/2019/03/matesctf-2018-wutfaces-cve-2013-2165.html](https://blog.tint0.com/2019/03/matesctf-2018-wutfaces-cve-2013-2165.html)
* Code White's disclosure - [https://codewhitesec.blogspot.com/2018/05/poor-richfaces.html](https://codewhitesec.blogspot.com/2018/05/poor-richfaces.html)
