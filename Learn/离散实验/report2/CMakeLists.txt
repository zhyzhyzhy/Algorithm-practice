cmake_minimum_required(VERSION 3.6)
project(report2)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp relation.cpp relation.h)
add_executable(report2 ${SOURCE_FILES})