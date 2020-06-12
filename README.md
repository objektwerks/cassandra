Cassandra
---------
>The purpose of this project is to test Cassandra features.

Homebrew
--------
>Install Homebrew on OSX.

Installation
------------
>Install the following packages via Homebrew:

1. brew tap homebrew/services
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
>See output at ./target/test.log

1. sbt clean test