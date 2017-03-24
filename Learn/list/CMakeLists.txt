cmake_minimum_required(VERSION 3.6)
project(list)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp homework.h seqlist.h linearlist.h singlelist.h term.h poly.h)
add_executable(sqlist ${SOURCE_FILES})