# Binary Search Tree and Generic Map Implementation

This repository contains implementations of a Binary Search Tree (BST) and a Generic Map in Java. 

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Binary Search Tree Methods](#binary-search-tree-methods)
- [Map Methods](#map-methods)

## Introduction

The Binary Search Tree (BST) is a data structure that allows for fast lookup, addition, and removal of items. It maintains its elements in a sorted order. The Map (or dictionary) is a data structure that stores pairs of keys and values, allowing for efficient retrieval of a value given its key. In this repository, the Map is built on top of the BST, ensuring that it inherits the BST's efficiency and ordering properties.

## Features

### Binary Search Tree
- Supports generic types that implement the `Comparable` interface.
- Basic operations: insertion, search, and size calculation.
- In-order iterator to traverse the tree from smallest to largest.

### Map
- Uses the BST as its internal structure.
- Supports storing key-value pairs.
- Ensures that keys are unique.
- Provides efficient methods for adding, retrieving, and checking the existence of keys.

## Installation

To use the Binary Search Tree and Map implementations, clone the repository and include the `BinarySearchTree.java` and `Map.java` files in your project.

```bash
git clone https://github.com/Yarin-Shohat/Generic-Binary-Search-Tree-and-Map.git
```

Ensure your project is set up to compile and run Java code.

## Usage

Below is an example of how to use the Binary Search Tree and Map in your Java project:

### Binary Search Tree

```java
import your.package.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        bst.add(5);
        bst.add(3);
        bst.add(7);
        
        System.out.println("Size: " + bst.size()); // Outputs: Size: 3
        System.out.println("Contains 3: " + bst.contains(3)); // Outputs: Contains 3: true
        System.out.println("Contains 10: " + bst.contains(10)); // Outputs: Contains 10: false
        
        for (Integer value : bst) {
            System.out.print(value + " "); // Outputs: 3 5 7
        }
    }
}
```

### Map

```java
import your.package.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        
        map.add("one", 1);
        map.add("two", 2);
        
        System.out.println("Size: " + map.size()); // Outputs: Size: 2
        System.out.println("Contains 'one': " + map.contains("one")); // Outputs: Contains 'one': true
        System.out.println("Value for 'one': " + map.get("one")); // Outputs: Value for 'one': 1
        System.out.println("Contains 'three': " + map.contains("three")); // Outputs: Contains 'three': false
    }
}
```

## Binary Search Tree Methods

- `int size()`: Returns the number of nodes in the tree.
- `boolean contains(E value)`: Checks if a value exists in the tree.
- `E get(E key)`: Retrieves the value associated with the given key, or returns `null` if not found.
- `boolean add(E value)`: Adds a value to the tree. Returns `true` if the value was added, `false` if it was a duplicate.

## Map Methods

- `boolean add(T key, E value)`: Adds a key-value pair to the map. Returns `true` if the pair was added successfully, `false` if the key already exists or if either key or value is null.
- `E get(T key)`: Retrieves the value associated with the given key, or returns `null` if the key is not found.
- `int size()`: Returns the number of key-value pairs in the map.
- `boolean contains(T key)`: Checks if a key exists in the map.
