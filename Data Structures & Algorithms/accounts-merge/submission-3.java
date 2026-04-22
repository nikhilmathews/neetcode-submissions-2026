class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, Set<String>> leaderToEmails = new HashMap();

        Map<String, String> parentMap = new HashMap();
        for(int i=0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            String firstEmail = account.get(1);

            for(int j=1; j < account.size(); j++) {
                String email = account.get(j);
                emailToName.put(email, name);
                union(parentMap, find(parentMap, email), find(parentMap, firstEmail));
            }
        }

        for (String email : emailToName.keySet()) {
            String leader = find(parentMap, email);
            if(!leaderToEmails.containsKey(leader)) {
                leaderToEmails.put(leader, new HashSet());
            }
            leaderToEmails.get(leader).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList();
        for(String leaderEmail : leaderToEmails.keySet()) {
            List<String> mergedAcc = new ArrayList();
            mergedAcc.add(emailToName.get(leaderEmail));
            List<String> emailsToAdd = new ArrayList(leaderToEmails.get(leaderEmail));
            Collections.sort(emailsToAdd);
            mergedAcc.addAll(emailsToAdd);
            mergedAccounts.add(mergedAcc);
        }
        return mergedAccounts;
    }

    private String find(Map<String, String> parentMap, String email) {
        if(!parentMap.containsKey(email)) {
            parentMap.put(email, email);
        }
        if(parentMap.get(email).equals(email)) {
            return email;
        } 
        parentMap.put(email, find(parentMap, parentMap.get(email)));
        return parentMap.get(email);
    }

    private void union(Map<String, String> parentMap, String email1, String email2) {
        parentMap.put(email1, email2);
    }
}