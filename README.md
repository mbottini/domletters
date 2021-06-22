# domletters — count dominant letters
<Your Name> and Bart Massey 2021

This repository contains a program that counts dominant
letters in alphabetic words of an ASCII text read from
standard input, printing the total count on standard output.

An "alphabetic word" is any sequence of one or more
ASCII letters (`a`-`z` and/or `A`-`Z`) surrounded by
whitespace. For example

    This isn't an "incomplete sentence". Really
    not.

contains just three words: `This`, `an` and `Really`.

The "dominant letter count" of a word is the maximum number of
times that a given letter appears in the word, treating
upper and lowercase letters as equivalent. Examples:

* The dominant letter count of `any` is 1, since the most any
  letter appears is once.

* The dominant letter count of `bookkeeper` is 3, since `e`
  appears three times.

* The dominant letter count of `Arable` is 2, since `a`
  appears twice (once uppercase, once lowercase).

## Build and Run

(*These instructions are for a compiled language like
C++. For an interpreted language like Python, delete these
instructions and use those below.*)

To build the program, type `make`. This will use the file
named `Makefile` to compile the program.

To run the program once it is built, say

    ./domletters <input.txt

where `input.txt` is the input file to be processed.

## Build and Run

(*These instructions are for an interpreted language like
Python. For a compiled language like C++, delete these
instructions and use those above. Note that your script
should be marked executable and set up to run on a Linux box
using a standard interpreter: for example, in Python the
first line should be something like `#!/usr/bin/python3`.*)

To run the program, say

    ./domletters <input.txt

where `input.txt` is the input file to be processed.

## Example

When run using the file `sentence.txt` in this distribution,
the program will produce a dominant letter count of 20. When
run on `swift.txt` it will produce 71.

## Acknowledgements

Thanks to [Project Gutenberg](http://gutenberg.org) for the
text of
[Tom Swift and His Airship](https://www.gutenberg.org/cache/epub/3005/pg3005.txt),
from which the file `swift.txt` in this distribution was
taken.

## License

```
MIT License

Copyright (c) 2021 Michael Bottini

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
