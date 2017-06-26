cmake_minimum_required(VERSION 3.7)
project(report2)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp LCS.cpp LCS.h)
add_executable(report2 ${SOURCE_FILES})