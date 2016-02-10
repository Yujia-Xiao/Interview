public void printShortestDis(String w1, String w2, String w3, String[] doc) {
    
    int pos1 = -1;
    int pos2 = -1;
    int pos3 = -1;
    
    int minLen = Integer.MAX_VALUE;
    int minStart = -1;
    int minEnd = -1;
    
    for (int i = 0; i < doc.length; i++) {
        if (doc[i].equals(w1)) {
            pos1 = i;
            if (pos2 != -1 && pos3 != -1) {
                int tmpLen = pos1 - Math.min(pos2, pos3);
                if (tmpLen < minLen) {
                    minLen = tmpLen;
                    minStart = Math.min(pos2, pos3);
                    minEnd = pos1;
                }
            }
        }
        else if (doc[i].equals(w2)) {
            pos2 = i;
            if (pos1 != -1 && pos3 != -1) {
                int tmpLen = pos2 - Math.min(pos1, pos3);
                if (tmpLen < minLen) {
                    minLen = tmpLen;
                    minStart = Math.min(pos1, pos3);
                    minEnd = pos2;
                }
            }
        }
        else if (doc[i].equals(w3)) {
            pos3 = i;
            if (pos1 != -1 && pos2 != -1) {
                int tmpLen = pos3 - Math.min(pos1, pos2);
                if (tmpLen < minLen) {
                    minLen = tmpLen;
                    minStart = Math.min(pos1, pos2);
                    minEnd = pos2;
                }
            }
        }
    }
    
    if (minStart != -1 && minEnd != -1)
        for (int i = minStart; i <= minEnd; i++)
            System.out.print(doc[i] + " ");
}