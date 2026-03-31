class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList();
        int i=0;
        while (i < str.length()) {
            int j=i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            decoded.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
            j = i + 1;
        }
        return decoded;
    }
}
