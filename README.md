# Task S4A Airlines

**Input**\
In the first line there are two integers *n* *q* (1 <= n <= 10<sup>7</sup>, 1 <= q <= 10<sup>7</sup>) denoting the number of routes and the number of queries respectively. In the day t = 0 (0 <= t <= 10<sup>11</sup>) each plane is assigned to a route.\
In the second line there are *n* integers (0 <= pi <= 1000) denoting the maximum number of passengers carried by the i-th plane.
In the next *q* lines there are queries sorted chronologically of the following types:
- P i p t - change maximum number of passengers carried by the *i* plane to *p* on the *t* day.
- C i t - remove *i* plane from a route on the *t* day.
- A i p t - assign *i* plane to a route with maximum number of passengers *p* on the *t* day.
- Q i j t - for planes active on day *t* find sum of planes' passenger capacity for each route from *i* to *j* up to day *t*. If previously on a route was operating another plane then the data for it is no longer taken into account.

**Output**\
Print all answers to queries of type Q separated by newline. It is guaranteed that at least one such query will appear.

---
- [Description](#description)
  - [Features](#features)
- [Installing](#installing)
  - [Precompiled](#precompiled)
  - [Build from source](#build-from-source)
- [How to use](#how-to-use)
- [Examples](#examples)
  - [Example 1](#example-1)
  - [Example 2](#example-2)
---

## Description

### Features
- [x] - Implemented Persistent Segment Tree for fast query execution and memory efficiency
- [x] - Wrote JavaDoc for code documentation
- [x] - Used Log4j 2 for logging actions into files
- [x] - Wrote unit tests with JUnit 5
- [x] - Used Maven for building jar and uploaded it in GitHub Releases

## Installing

### Precompiled
You can download compiled binaries in Releases page.\
[Latest Release](https://github.com/Stinger-22/s4a-task/releases/latest)

### Build from source
```
git clone https://github.com/Stinger-22/s4a-task.git
cd s4a-task
mvn package
```
Compiled jar file is located in `/target/smart4aviation-task.jar`.

## How to use
Launch from command line in the directory with jar file:
```
java -jar ./smart4aviation-task.jar
```

Also you can use input and output redirection for more convenient usage instead of manually typing values or using Ctrl+C / Ctrl+V.


Linux: 
```
java -jar ./smart4aviation-task.jar < input.txt > output.txt
```

During app execution in the same folder will be created two files: status.log and latest.log.
- status.log: internal Log4j 2 logs
- latest.log: application logs

Log files are overwritten on each app execution.

## Examples

### Example 1
**Input:**\
5 7\
1 2 3 2 4\
Q 1 5 2\
Q 2 3 2\
C 2 3\
P 3 5 3\
Q 2 4 4\
A 2 5 6\
Q 1 5 8\
**Output:**\
24\
10\
22\
100

### Example 2
**Input:**\
1 7\
2\
Q 1 1 1\
C 1 1\
A 1 6 2\
Q 1 1 3\
Q 1 1 4\
Q 1 1 7\
Q 1 1 8\
**Output:**\
2\
6\
12\
30\
36
