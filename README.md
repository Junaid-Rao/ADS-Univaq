# Advanced Data Structures — University of L'Aquila

<p align="center">
  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java"/>
  <img src="https://img.shields.io/badge/Course-Advanced%20Data%20Structures-blue?style=for-the-badge" alt="Course"/>
  <img src="https://img.shields.io/badge/University-University%20of%20L'Aquila-green?style=for-the-badge" alt="University"/>
  <img src="https://img.shields.io/badge/Semester-2nd%20(Masters)-purple?style=for-the-badge" alt="Semester"/>
</p>

---

## 📋 About This Repository

This repository contains all the **code implementations** written during the **2nd Semester** of the **Advanced Data Structures (ADS)** course, part of the **Master's Program in Computing Systems Engineering** at the **University of L'Aquila (UnivAQ), Italy**.

Each implementation focuses on hands-on understanding of classic data structures and algorithms, with an emphasis on **performance analysis** — including comparison counts and step-by-step execution tracing, making it easy to study the inner workings of each algorithm.

---

## 🎓 Academic Details

| Detail | Info |
|---|---|
| **University** | University of L'Aquila (UnivAQ), Italy |
| **Program** | Computing Systems Engineering (Master's) |
| **Course** | Advanced Data Structures (ADS) |
| **Semester** | 2nd Semester |
| **Language** | Java |

---

## 📁 Repository Structure

```
ADS-Univaq/
├── bubbleSort.java       # Optimized Bubble Sort implementation
├── insertionSort.java    # Insertion Sort implementation
├── selectionSort.java    # Selection Sort implementation
└── README.md             # Project documentation (this file)
```

> **Note:** More algorithms and data structures will be added as the course progresses.

---

## 📚 Topics Covered

### 🔢 Sorting Algorithms

Sorting is one of the most fundamental operations in computer science. All implementations below are **in-place** (O(1) space complexity) and include **comparison/swap counters** to help analyze and compare their performance empirically.

---

#### 1. 🫧 Bubble Sort — `bubbleSort.java`

Bubble Sort is a simple comparison-based algorithm that repeatedly steps through the list and swaps adjacent elements that are out of order. Each pass "bubbles" the largest unsorted element to its correct position at the end.

**Implementation Highlights:**
- Uses an **early-exit optimization**: if no swaps occur during a full pass, the array is already sorted and the algorithm terminates immediately.
- Tracks `outerComparisons` (number of passes) and `innerComparisons/Swaps` for performance analysis.

**Complexity Analysis:**

| Case | Time Complexity | Explanation |
|------|----------------|-------------|
| Best | O(n) | Array already sorted — exits after one pass (with optimization) |
| Average | O(n²) | Random order — full nested loops |
| Worst | O(n²) | Reverse sorted — maximum swaps needed |
| Space | O(1) | In-place sorting |

**Sample Input & Output:**
```
Input:  {45, 5, 42, 34, 32, 31, 27, 26}

Outer Comparisions Made: 7
Inner Comparisions/Swappings Made: 20
Output: 5, 26, 27, 31, 32, 34, 42, 45,
```

---

#### 2. 📌 Insertion Sort — `insertionSort.java`

Insertion Sort builds the sorted array one element at a time by picking each element and inserting it into its correct position among the already-sorted elements to its left. It mimics the way you sort playing cards in your hand.

**Implementation Highlights:**
- Iterates from the second element, comparing backwards using a `while` loop.
- Tracks `outerComparisons` (elements processed) and `innerComparisons/Swaps` for analysis.

**Complexity Analysis:**

| Case | Time Complexity | Explanation |
|------|----------------|-------------|
| Best | O(n) | Already sorted — inner loop never executes |
| Average | O(n²) | Random order — partial backward traversal |
| Worst | O(n²) | Reverse sorted — maximum backward traversal |
| Space | O(1) | In-place sorting |

**Sample Input & Output:**
```
Input:  {43, 5, 12, 54, 12, 1, 65, 76}

Outer Comparisions Made: 7
Inner Comparisions/Swappings Made: 11
Output: 1, 5, 12, 12, 43, 54, 65, 76,
```

---

#### 3. 🎯 Selection Sort — `selectionSort.java`

Selection Sort divides the array into a sorted and an unsorted region. In each pass, it **selects the minimum element** from the unsorted region and places it at the end of the sorted region. It always performs exactly O(n²) comparisons, regardless of the input.

**Implementation Highlights:**
- Prints the **intermediate state of the array after each pass**, making it easy to visualize sorting progress step by step.
- Tracks `outerComparisons` (passes completed) and `innerComparisons` (total element comparisons).

**Complexity Analysis:**

| Case | Time Complexity | Explanation |
|------|----------------|-------------|
| Best | O(n²) | No early-exit — always scans entire unsorted region |
| Average | O(n²) | No early-exit |
| Worst | O(n²) | No early-exit |
| Space | O(1) | In-place sorting |

**Sample Input & Output:**
```
Input:  {43, 5, 12, 54, 12, 1, 65, 76}

After pass 1:  1, 5, 12, 54, 12, 43, 65, 76,
After pass 2:  1, 5, 12, 54, 12, 43, 65, 76,
After pass 3:  1, 5, 12, 54, 12, 43, 65, 76,
After pass 4:  1, 5, 12, 12, 54, 43, 65, 76,
After pass 5:  1, 5, 12, 12, 43, 54, 65, 76,
After pass 6:  1, 5, 12, 12, 43, 54, 65, 76,
After pass 7:  1, 5, 12, 12, 43, 54, 65, 76,
Outer passes: 7
Inner comparisons: 28
Output: 1, 5, 12, 12, 43, 54, 65, 76,
```

---

### 📊 Algorithm Comparison Summary

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable? |
|-----------|-----------|--------------|------------|-------|---------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | ✅ Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | ❌ No |

> **Stable Sort:** A sorting algorithm is stable if equal elements retain their original relative order after sorting.

---

## 🚀 How to Run

### Prerequisites
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) — version 8 or higher
- A terminal / command prompt

### Compile and Run

Each file is self-contained with a `main` method. Use the commands below to compile and run any individual file:

```bash
# Bubble Sort
javac bubbleSort.java && java Main

# Insertion Sort
javac insertionSort.java && java Main

# Selection Sort
javac selectionSort.java && java Main
```

> **Note:** All three files define a class named `Main`. Compile and run them one at a time from within the same directory to avoid class name conflicts.

---

## 🔮 Upcoming Topics

As the course progresses, implementations for the following topics will be added to this repository:

- [ ] Merge Sort
- [ ] Quick Sort
- [ ] Heap Sort
- [ ] Binary Search Trees (BST)
- [ ] AVL Trees (Self-Balancing BST)
- [ ] Red-Black Trees
- [ ] Hash Tables
- [ ] Graphs (BFS, DFS)
- [ ] Minimum Spanning Trees (Kruskal's, Prim's)
- [ ] Dynamic Programming
- [ ] Divide and Conquer Algorithms

---

## 👨‍💻 Author

**Junaid Rao**  
Master's Student — Computing Systems Engineering  
University of L'Aquila (UnivAQ), Italy

---

## 📄 License

This repository is intended for **academic and educational purposes**. Feel free to reference or learn from the code.
