#!/bin/sh
sed -e 's/[^a-zA-Z]/\n/g' words.txt | grep -v ^$ | sort | uniq -c | sort -r | awk '{print $2" " $1}'
