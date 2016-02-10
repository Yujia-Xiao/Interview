boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> selection = new HashSet<Integer>();
        for (int i = 1; i <=maxChoosableInteger; ++i) {
            selection.add(i);
        }
        return canWin(selection, desiredTotal);
    }

    boolean canWin(Set<Integer> selection, int desiredTotal) {
        for(int i : selection) {
            int newTotal = desiredTotal - i;
            if (newTotal<=0) return true;
            else{
                selection.rempove(i);
                if (!canWin(selection, newTotal)) {
                    return true;
                }
            }
        }
        return false;
    }

