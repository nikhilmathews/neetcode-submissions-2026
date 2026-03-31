class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> cardCount = new HashMap();
        for(int card : hand) {
             cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }
        Arrays.sort(hand);
        for(int card : hand) {
            if(cardCount.containsKey(card)) {
                for(int i=0; i < groupSize; i++) {
                    if(!cardCount.containsKey(card + i)) {
                        return false;
                    }
                    else {
                        cardCount.put(card + i, cardCount.get(card + i) - 1);
                        if(cardCount.get(card + i) == 0) {
                            cardCount.remove(card + i);
                        }
                    }
                }
            }
        }
        return true;
    }
}
