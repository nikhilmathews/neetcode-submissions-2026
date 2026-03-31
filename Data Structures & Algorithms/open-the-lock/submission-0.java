class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet();
        for(String deadend : deadends) {
            deadendSet.add(deadend);
        }

        Set<String> seenCombo = new HashSet();
        Queue<String> bfsQ = new ArrayDeque();
        bfsQ.offer("0000");

        int moveCount = 0;
        while(!bfsQ.isEmpty()) {
            int levelCount = bfsQ.size();
            for(int i=0; i < levelCount; i++) {
                String currLock = bfsQ.poll();
                if(currLock.equals(target)) {
                    return moveCount;
                }
                if(!seenCombo.contains(currLock) && !deadendSet.contains(currLock)) {
                    // get variations of this lock, add it to the queue
                    List<String> possibleMoves = getPossibleMoves(currLock);
                    possibleMoves.stream().forEach(p -> bfsQ.offer(p));
                }
                seenCombo.add(currLock);
            }
            moveCount++;
        }
        return -1;
    }

    private List<String> getPossibleMoves(String currLock) {
        List<String> possibleMoves = new ArrayList();
        for(int i=0; i < currLock.length(); i++) {
            possibleMoves.add(getNextCombo(currLock, i));
            possibleMoves.add(getPrevCombo(currLock, i));
        }
        return possibleMoves;
    }
    private String getNextCombo(String currLock, int index) {
        StringBuilder sb = new StringBuilder(currLock);
        if(sb.charAt(index) == '9') {
            sb.setCharAt(index, '0');
        }
        else {
            sb.setCharAt(index, (char) (sb.charAt(index) + 1));
        }
        return sb.toString();
    }

    private String getPrevCombo(String currLock, int index) {
        StringBuilder sb = new StringBuilder(currLock);
        if(sb.charAt(index) == '0') {
            sb.setCharAt(index, '9');
        }
        else {
            sb.setCharAt(index, (char) (sb.charAt(index) - 1));
        }
        return sb.toString();
    }
}