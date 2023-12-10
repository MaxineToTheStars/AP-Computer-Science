# Week #2 - Calculator App
---

## Pre-Requites
- [MaxTime JRE](https://github.com/MaxineToTheStars/MaxTime-JRE)
---

## To Run
- Download this repository
- Navigate to Week #2 folder
- Run ``gradle build``
- Execute the jar located in ``/app/build/libs/*.jar`` with the [MaxTime JRE](https://github.com/MaxineToTheStars/MaxTime-JRE)

## How it works
So most programming languages have a method called ``eval`` which evaluate a given input(string) as actual code.
Now using this is strictly prohibited in production level applications due to massive security flaws and vulnerabilities
however, for this use case it's alright. Now Java doesn't actually have an eval method but, it does have a JavaScript VM (*???? why*). So to make our(my) life easier I simply initiate the Javascript VM add pass the user equation string to the JSVM (Javascript VM). This is very safe code trust <3
