# Java
### Table of contents
- [Table of Contents](#table-of-contents)

- [Features of Java](#features-of-java)

- [JDK, JVM, JRE](#jdk-jre-jvm)

- [JVM](#jvm)

- [OOPS](#object-oriented-programming-system)

- [Method, Constructor](#method)

- [this, static keywords](#this-keyword)

- [Inheritance(IS-A), Aggregation(HAS-A)](#inheritance-in-java)

- [Polymorphism](#polymorphism)

### Features of Java

<details>
  <summary>Simple</summary>
 
 - Syntax is easy.
 - Automatic Garbage Collection
 - No explicit Pointers. Which makes it even more secure  
</details>

<details>
  <summary>Object Oriented</summary>
  
  - Supports Concepts of OOP.
  </details>
 
<details>
  <summary>Platform Independent</summary>
  
 - Same byte code can be ran on any machine.
</details>
 
<details>
  <summary>Secure</summary>
  
 - No Explicit pointers
 - Runs inside a Virtual Machine
</details>

<details>
  <summary>Architechture Neutral</summary>
  
- Memory limit of variables in C depends on architechture, i.e. size of int in a **32-bit** system differs from that in a **64-bit** system. Where as in Java size of variables are consistent.
</details>

<details>
  <summary>Portable</summary>
  
- We can carry the same java bytecode to any platform.
</details>


<details>
  <summary>High Performance</summary>
  
- It is faster than other traditional interpreted languages, as java bytecode is closer to native code. It is still slower than C, C++
</details>

<details>
  <summary>Multi Threaded</summary>
  
  - Self Explanatory
</details>

<details>
  <summary>Dynamic</summary>
  
- Classes are loaded on demand.
- Also supports feature from native languages like C, C++ (JNI Libraries)
- Supports dyanmic compilation and automatic memory management (garbage collection)
</details>

### JDK, JRE, JVM

**JVM** 
- JVM is the virtual machine that provides a runtime environment in which java bytecode is executed.
- Compiled bytecode of **other languages can also be executed** in JVM.
- It is **platform dependent**.
- Loads, Verifies, Executes code.


**JRE** 
- It is implementation of JVM.
- Provide tools used for developing java apps.
- It contains a set of libraries, JVM.

**JDK**
- JRE + Development Tools.
- Standard Edition, Enterprise Edition, Micro Edition.


## JVM

Provides
- Memory Area.
- Stores, loads Classes.
- Garbage collection.
- Fatal Error reporting.

JVM Architecture

![jvm-architecture](./readme-files/jvm-architecture.png)


<details>
  <summary>Class Loader</summary>

  Used to load classes.
</details>

<details>
  <summary>Class(Method) Area</summary>

  It stores class structure, fields, methods and code for methods.
</details>


<details>
  <summary>Heap</summary>

  Stores runtime data objects.
</details>

<details>
  <summary>Stack</summary>

  - Java Stack stores frames, local variables, partial results. (what are frames?)
  - It also helps in method invocation.
  - Each thread has its own stack. (how are variables shared?)
  - A Frame is created every time a method is invoked.

</details>

<details>
  <summary>PC Register</summary>

  Contains address of JVM instructions currently being ran.
</details>

<details>
  <summary>Native Method Stack</summary>

  Contains all native methods used in app (JNI).
</details>
<details>
  <summary>Execution Engine</summary>

  - A virtual processor
  - Interpreter - reads bytecode and creates, execute instructions.
  - JIT Compiler -- Converts similar instructions at same time to CPU instructions (machine specific code).
  **converts instructions to machine instructions**

</details>
<details>
  <summary>Java Native Interface</summary>

  Provides interface 

</details>

### Object Oriented Programming 

Advantages
- It makes development easier
- More Secure (Encapsulation)

Object 
- Real world object that has state and behaviour.
- It is an instance of a class.

Class 
- Collection of objects is called class.
- Blueprint from which you can create an individual object.

Inheritance
- When a child class acquires the properties of parent class.

Polymorphism
- To do one task in different ways.
- Achieved using method overriding and overloading.

Abstraction
- Hiding internal implementation and only functions is known as abstraction.
- In java we have abstract classes and interfaces.

Encapsulation
- Data Hiding - Process of hiding unwanted information.
- Data Binding - Process of binding methods, attributes together.

Association
- Represents the relationship between objects (1-1, 1-many)



### Method
- Block of Code to perform some task.
- Reusability, Readability.

### Constructor
- Special method used to instanciate the object.
- No return type is defined (Although it returns the object).
- Called using new keyword.
- Default, Parameterized

### Static Keyword

- Used for memory management. (it saves by not being created for every instance)
- can be applied to
  - Variable (class variable)
  - Method (class method)
  - Block
  - Nested class
- static block of code
  - It is run while JVM loads class.

### This Keyword
- Used to refer current class instance variable.
- Can be used to access variables, methods, constructor.

### Inheritance in Java

- We use extends or implements keyword.
- Is-A relationship
- 5 type, Single, Multiple, Multi-level, heirarchical (two child extend to same parent), Hybrid.

- Java Doesn't support multiple or hybrid.

### Aggregation in java

```
class Employee{
  Addess address;
}
```
- Has-A relationship
- Employee Has-A address.

### Polymorphism

To do one task in different ways.

<details>
<summary>Method OverLoading</summary>

- Multiple methods with same name but dirrent parameters. (Compile Tile Polymorphism)

</details>

<details>
<summary>Method Overriding</summary>

- Child class has same method as in parent. (Runtime Polymorphism)
(static methods cannot be overridden)

</details>