cmake_minimum_required(VERSION 3.6)
project(hfmtree)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp BTNode.h BinaryTree.h HfmTree.h prioqueue.h)
add_executable(hfmtree ${SOURCE_FILES})