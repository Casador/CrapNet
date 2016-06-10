# CrapNet
CrapNet in Java.

#Setup for server

1. Install Redis with `sudo apt-get redis-server`
2. Somehow compile the java files - cause honestly this language is fucked.
3. Create a file named `qnet_server.conf` with the following inside:

````
port=[port that clients will use to access the server]
redisIP=[IP of redis]
redisPort=[port for redis]
exchanges=[comma separated hostnames of people to servers to fetch posts from (leave empty string if none)]
````

4. Run the server with (hopefully) `qnetd --start`.
