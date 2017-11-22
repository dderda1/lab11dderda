# COMP 271 002 F17 Lab 9 (Week 11)

# DARIA IZABELLA DERDA 



1. Are the resulting word frequencies any different?
- No pronouns included in MyHashMap!
1. Is the time performance any different? If so, how would you rank the three implementations (in increasing order of time complexity)?
- There were time differences. Here they are ranked best to worst: TreeMap, HashMap, MyHashmap
2. How are `%` and `Math.floorMod` different? Which works more reliably for computing a hash table index?
- Math.floorMod gives you the lowest number in the expression, while you only get a remainder out of %. Math.FloorMod is also more reliable
3. What is the time complexity of `MyHashMap.size()`, and how could you make it much more efficient?
- O(n), if you can change the size , then it will work way more efficiently. 
4. How does this implementation compare to one where you would directly use your linked `Node` class from the earlier assignment? Answer briefly in terms of ease of implementation, correctness, reliability, and performance.
- Linked nodes are implemented easier! Both are roughly on the same level of correctness & reliability! Performance in MyHashMap is better!
# Grading

- 0.5 correct project structure (based on Gradle)
- 0.5 submission via GitHub (including multiple commits over time)
- 2.5 completion of items marked TODO in `src/main` and correct behavior
- 1.5 written part
    - 1.2 responses to the questions above
    - 0.3 grammar, style, formatting

*5 points TOTAL*
