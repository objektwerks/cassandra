Cassandra
---------
>The purpose of this project is to test Cassandra features using Scala 3.

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
2. cqlsh    ( Verify Cassandra started, and cqlsh can connect. See Warning below. )

>Stop:

1. brew services stop cassandra

Warning
-------
>Cassandra ( as of 2020.6 ) may not **actually** start via homebrew. Run cqlsh to verify cassandra started.
>If cqlsh prints a **connection refused** error, folow these steps:
1. brew services stop cassandra
2. brew unlink cassandra && brew link cassandra
3. brew services start cassandra
4. cqlsh
>You might also run 1) cassandra -f or 2) cassandra -r to run cassandra and then cqlsh.

Test
----
>See output at ./target/test.log

1. sbt clean test