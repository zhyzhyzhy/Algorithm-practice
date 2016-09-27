cmake_minimum_required(VERSION 3.6)
project(SeqTriple)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp matrix.h )
add_executable(SeqTriple ${SOURCE_FILES})