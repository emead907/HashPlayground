# Project 3: Hash Playgrounds

* Author: Emily Mead
* Class: CS321 Section #1
* Semester: Fall 2021

## Overview

In this project we worked with linear probing and double hashing.
We created generic hash tables using differnt data types. We put 
this all togther and built a test classwith differnt debug levels
to use when applying our hashing classes.

## Reflection

For this project I had a hard time getting started. hashing and hash tables
were something that did not click in my head right away and took a while for 
to start understanding. Once I figured thoes out things got a lot easer.
  I think the thing that would have benifited me the most was to get started 
 earler on this project. when I did finally get started I felt I was to 
 rushed and focused on just getting it done instread of spending time really
 understanding what I was doing. 

## Compiling and Using
 ### Compiling 
 ``javac HashtableTest.java``
 ### Using
 ``java HashtableTest <input type> <load factor> [<debug level>]``

## Results 

### Input source 1 - random numbers 

| alpha | linear | double |
|-------|--------|--------|
|  0.5  | 1.504  |  1.386 |
|  0.6  | 1.748  |  1.526 |
|  0.7  | 2.184  |  1.726 |
|  0.8  | 2.991  |  2.017 |
|  0.9  | 5.353  | 2.558  |
| 0.95  | 11.001  |  3.158 |
| 0.98  | 28.588  |  3.978 |
| 0.99  |  38.613 |  4.627 |

### Input source 2 - Current time

| alpha | linear | double |
|-------|--------|--------|
|  0.5  | 1.0 |  1.0 |
|  0.6  | 1.0 |  1.0 |
|  0.7  | 1.0 |  1.0 |
|  0.8  | 1.0 |  1.0 |
|  0.9  | 1.0 |  1.0 |
| 0.95  | 1.0 |  1.0 |
| 0.98  | 1.0 |  1.0 |
| 0.99  | 1.0 |  1.0 |

### Input source 3 - Random numbers
| alpha | linear | double |
|-------|--------|--------|
|0.5|1.495|1.386|
|0.6|1.757|1.523|
|0.7|2.154|1.714|
|0.8|2.958|2.009|
|0.9|5.385|2.564|
|0.95|10.693|3.141|
|0.98|23.591|4.038|
|0.99|70.608|4.613|

## Sources used

I did not use many other sources other then refering to some java docs as well has googling some syntax questions

----------

