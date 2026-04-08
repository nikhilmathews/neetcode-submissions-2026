class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> billCount = new HashMap();
        for(int bill : bills) {
            int change = bill - 5;
            if(change >= 10) {
                int tenCount = billCount.getOrDefault(10, 0);
                if(tenCount > 0) {
                    change -= 10;
                    billCount.put(10, tenCount - 1);
                }
            }
            if(change >= 5) {
                int fiveCount = billCount.getOrDefault(5, 0);
                int requiredFives = change / 5;
                if(fiveCount < requiredFives) {
                    return false;
                }
                else {
                    billCount.put(5, fiveCount - requiredFives);
                }
            }
            billCount.put(bill, billCount.getOrDefault(bill, 0) + 1);
        }
        return true;
    }
}