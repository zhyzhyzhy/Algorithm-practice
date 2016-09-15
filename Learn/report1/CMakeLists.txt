cmake_minimum_required(VERSION 3.6)
project(report1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp stack.h extra.h)
add_executable(report1 ${SOURCE_FILES})