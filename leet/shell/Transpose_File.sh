#!/bin/sh
#还不过关
awk '{print $1}' file.txt | sed -e ':a;N;s/\n/ /g' 
