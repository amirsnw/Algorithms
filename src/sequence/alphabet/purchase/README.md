# Gift Letters for the Best Student

A teacher has many classes. For each class, they want to pre-buy a multiset of letters so that **whoever becomes the top student**, the teacher can assemble that student’s favorite word using only those letters. The teacher wants to spend as little as possible, so for every class you must determine the **minimum total number of letters** they need to buy.

**Key idea:** For each letter `a..z`, the teacher must have at least as many copies as the **maximum** number of times that letter appears in **any** favorite word in that class. The answer for a class is the sum of these maxima over all letters.

---

## Input

* The first line contains an integer `t` (`1 ≤ t ≤ 100`) — the number of classes.
* For each class:

    * The first line contains an integer `n` (`1 ≤ n ≤ 30`) — the number of students in that class.
    * The next `n` lines each contain a string `S_i` (`|S_i| ≤ 30`), consisting of lowercase English letters — the favorite word of the `i`-th student.

## Output

For each class, output a single integer — the **minimum** number of letters the teacher must buy for that class.

## Explanation of the Rule

Let `cnt_i(c)` be how many times letter `c` appears in `S_i`.
For each letter `c` in `a..z`, compute `need(c) = max(cnt_1(c), cnt_2(c), …, cnt_n(c))`.
The required total is:

```
answer = sum over c in 'a'..'z' of need(c)
```

This guarantees you can form **any** favorite word in the class.

---

## Sample Input

```
3
2
aba
bab
2
shaparak
pardis
3
zzz
zz
z
```

## Sample Output

```
4
10
3
```

## Sample Explanations

* **Class 1**

    * Words: `aba`, `bab`
    * Max counts per letter: `a:2`, `b:2` (others: `0`)
    * Minimum letters to buy: `2 + 2 = 4`

* **Class 2**

    * Words: `shaparak`, `pardis`
    * Max counts: `a:3`, and one copy each of `s, h, p, r, k, d, i`
    * Total: `3 + 7 = 10`

* **Class 3**

    * Words: `zzz`, `zz`, `z`
    * Max counts: `z:3`
    * Total: `3`

---

## Notes

* Letters are bought as a **multiset** (e.g., two `a`s means two physical copies).
* Order doesn’t matter; letters can be rearranged to form different words.
* Only lowercase English letters appear in inputs.
