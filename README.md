Cassandra
---------
>The purpose of this project is to prototype and test Cassandra features.

***

Homebrew
--------
>Install Homebrew on OSX. [How-To] (http://coolestguidesontheplanet.com/installing-homebrew-os-x-yosemite-10-10-package-manager-unix-apps/)

Installation
------------
>Install the following packages via Homebrew:

1. brew tap homebrew/services [Homebrew Services] (https://robots.thoughtbot.com/starting-and-stopping-background-services-with-homebrew)
2. brew install scala
3. brew install sbt
4. brew install cassandra

Service
-------
>Start:

1. brew services start cassandra

>Stop:

1. brew services stop cassandra

Test
----
>See output at ./target/output/test.

1. sbt clean test