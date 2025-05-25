# Insert in Sorted Circular Linked List

Given a sorted circular linked list, the task is to insert a new node in this circular linked list so that it remains a sorted circular linked list.

---

## Examples

### Example 1

![alt text](image.png)

**Input:**  
head = 1->2->4, data = 2

**Output:**  
1->2->2->4

**Explanation:**  
We can add 2 after the second node.

---

### Example 2

![alt text](image-1.png)

**Input:**  
head = 1->4->7->9, data = 5

**Output:**  
1->4->5->7->9

**Explanation:**  
We can add 5 after the second node.

---

## Constraints

- 2 <= number of nodes <= 10^6
- 0 <= node->data <= 10^6
- 0 <= data <= 10^6
