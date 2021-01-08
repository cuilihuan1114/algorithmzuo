import java.util.*;

/**
 * Created by CUI on 2021/1/5
 */
public class Problem_0127_单词接龙 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        wordList.add(beginWord);
        HashMap<String, List<String>> hashMap = getNext(wordList);
        HashSet<String> exists = new HashSet<>();

        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Integer> distance = new HashMap<>();
        queue.add(beginWord);
        exists.add(beginWord);
        distance.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> curNexts = hashMap.get(cur);
            Integer curDistance = distance.get(cur);
            if (curNexts == null)
                continue;
            for (int i = 0; i < curNexts.size(); i++) {
                String s = curNexts.get(i);
                if (s.equals(endWord))
                    return curDistance + 1;
                if (exists.contains(s))
                    continue;
                exists.add(s);
                queue.add(s);
                distance.put(s, curDistance + 1);
            }
        }
        return 0;
    }

    //超出时间限制
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        wordList.add(beginWord);
        HashMap<String, List<String>> hashMap = getNext(wordList);
        HashSet<String> exists = new HashSet<>();
        List<String> curLevelString = new ArrayList<>();

        curLevelString.add(beginWord);
        exists.add(beginWord);
        int level = 1;
        while (curLevelString.size() != 0) {
            List<String> nextLevelString = new ArrayList<>();
            level++;
            for (int i = 0; i < curLevelString.size(); i++) {
                String s = curLevelString.get(i);
                exists.add(s);
                List<String> curEnds = hashMap.get(s);
                if (curEnds == null)
                    continue;
                for (int j = 0; j < curEnds.size(); j++) {
                    if (curEnds.get(j).equals(endWord))
                        return level;
                    if (exists.contains(curEnds.get(j)))
                        continue;
                    nextLevelString.add(curEnds.get(j));
                }

            }
            curLevelString = nextLevelString;
        }
        return 0;
    }

    //在这里因为之前没有将一个列表转化成set集合判断 时间会明显的提升 也可以通过测试用例
    private HashMap<String, List<String>> getNext(List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    if (chars[j] != k) {
                        char temp = chars[j];
                        chars[j] = k;
                        String toS = String.valueOf(chars);
                        if (set.contains(toS)) {
                            if (map.containsKey(s)) {
                                map.get(s).add(toS);
                            } else {
                                map.put(s, new ArrayList<>());
                                map.get(s).add(toS);
                            }
                        }
                        chars[j] = temp;
                    }
                }
            }
        }
        return map;
    }

    //这个判断一个字符串在列表当中是否存在 如果列表过长会导致时间很大
    //所以会因为这个而超时
    private HashMap<String, List<String>> getNext1(List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                for (char k = 'a'; k <= 'z'; k++) {
                    if (chars[j] != k) {
                        char temp = chars[j];
                        chars[j] = k;
                        String toS = String.valueOf(chars);
                        if (wordList.contains(toS)) {
                            if (map.containsKey(s)) {
                                map.get(s).add(toS);
                            }else{
                                map.put(s, new ArrayList<>());
                                map.get(s).add(toS);
                            }
                        }
                        chars[j] = temp;
                    }
                }
            }
        }
        return map;
    }
}
