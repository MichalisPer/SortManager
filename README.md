# **Sort Manager**

## Project Description:
The objective of this project is to demonstrate **OOP** and **SOLID** 
principles through an implementation of a sort manager. The project
contains the implementation of 5 sorting algorithms (_**binary-sort**_, _**bubble-sort**_,
_**insertion-sort**_, _**mergesort**_ and _**quicksort**_). The user 
can **choose** any of the **sorting algorithms** and the **size** of a **randomly
generated array** where the sorting algorithm will perform upon. The **output**
of the program displays the **randomly generated array** based on the given size
the selected **sorting algorithm**, the **sorted array** and the **time taken** for the algorithm
to sort the array.

The project follows the MVC architecture in the sense that the model,
the view and controllers lie within different `packages` adhering to the
definition of each of these elements.

## Running the project on your local machine:
To run this project, you must download a JDK and set up your environment so that a java program can run on your machine.
This program is developed using JDK 18 and therefore this is what is suggested to run the application.
Afterwards, you can either clone it to a local repository or download and extract the repository on your local machine 
and run the `main` method in the **Main** class.

## Adding additional sorting algorithms:
The project is implemented in such a way so that addition of new sorting algorithms require only the following steps:
1. Create the class of sorting algorithm in `sorters` `package` and implement the `Sorter` interface and `toString()` method
2. In the `DisplayManager` class add the name of your algorithm in the `getAvailableSorters()` at the end of the returned array
3. Add your sorter to the `SortFactory` switch statement accordingly

By adding additional sorting algorithm as described above, it will be automatically included in the testing.

## Future Work:
- User can choose the type of elements in the array (Integer, Double, Float etc)
- Use of generics to implement the `sortArray` method




