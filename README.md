# Largest_compounded_word
This program essentially searches for the longest and the second longest compounded word  by examining all possible combinations, using a trie and queue data structure to efficiently search for the required output.
# Steps involved here:
1.Buliding the Trie Node 2.Identifying candidate compound words by analyzing their suffixes.It adds these candidate pairs(word,remaining suffix) to a queue for further processing.
3.Buliding pair.java for storing pair of words.
4.Processing a queue,checking if the remaining suffix is a valid prefix in the trie.
5.Determining the longest and the second longest compounded word ,displaying the result.
# How to execute the code:
1.Open assignment folder with any of the editors like VS code.
2.Then, go to  LongestCompoundWord file,execute the code.
2.As there are two input files ,change name accordingly.
# Output generated:
1.Longest Compound Word: ethylenediaminetetraacetates
  Second Longest Compound Word: electroencephalographically
2.Longest Compound Word: ratcatdogcat
  Second Longest Compound Word: catsdogcats 
