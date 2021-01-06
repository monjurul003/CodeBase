package mik.amazon;

import java.util.*;

public class TopKElement {
    int numberOfElementInResultList = 2;
    String[] keywords = new String[] {"anacell", "cetracular", "betacellular"};
    String[] reviews = new String[]{"Anacell provides the best services in the city", "betacellular has awesome services", "Best services provided by anacell, everyone should use anacell"};
    public List<String> topK(){
        List<String> result = new ArrayList<>();
        Set<String> keywordSet = new HashSet<>(Arrays.asList(keywords));
        Map<String,Integer> reviewMap = new HashMap<>();
        for(String review : reviews) {
            Set<String> added = new HashSet<>();
            String[] words = review.split("\\W");
            for(String word : words) {
                if(keywordSet.contains(word) && !added.contains(word)) {
                    reviewMap.put(word, reviewMap.getOrDefault(word, 0)+1);
                    added.add(word);
                }
            }
        }
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ? (a.getKey().compareTo(b.getKey())) : a.getValue()-b.getValue());
        pq.addAll(reviewMap.entrySet());
        while(!pq.isEmpty() && numberOfElementInResultList-- > 0){
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
