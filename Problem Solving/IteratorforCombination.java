/*
1286. Iterator for Combination
Medium

Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.

Example 1:
Input: 
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output: 
[null, "ab", true, "ac", true, "bc", false]
Explanation: 
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False

Constraints:
1 <= combinationLength <= characters.length <= 15
All the characters of characters are unique.
At most 104 calls will be made to next and hasNext.
It's guaranteed that all calls of the function next are valid.

*/

class CombinationIterator {
    ArrayList<Integer> comb;
    int ptr;
    String s;
    public CombinationIterator(String characters, int combinationLength) {
        comb = new ArrayList<>();
        ptr = 0;
        s = characters;
        int n = characters.length();
        for(int i = (1 << n) - 1; i > 0; i--){
            if(countBits(i) == combinationLength) comb.add(i);
        }
    }
    public int countBits(int n){
        int count = 0;
        while(n > 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public String next() {
        StringBuilder ans = new StringBuilder();
        int num = comb.get(ptr++);
        int index = s.length() - 1;
        while(num > 0){
            if((num & 1) > 0) ans.insert(0, s.charAt(index));
            num >>= 1;
            index--;
        }
        return ans.toString();
    }
    
    public boolean hasNext() {
        return ptr < comb.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */