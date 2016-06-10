# CrapNet
CrapNet in Java.

#Setup

Create a file named `qnet_server.conf` with the following inside:

````
port=[port that clients will use to access the server]
redisIP=[IP of redis]
redisPort=[port for redis]
exchanges=[comma separated hostnames of people to servers to fetch posts from (leave empty string if none)]
````
