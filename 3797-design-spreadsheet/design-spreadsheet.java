class Spreadsheet {
    
  // int[][] spreadSheet;
    HashMap<String,Integer> spreadSheet;
    public Spreadsheet(int rows) {
        // spreadSheet =new int[rows][26];
        spreadSheet =new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        // int col = (int)(cell.charAt(0)-'A');
        // int row = Integer.parseInt(cell.substring(1))-1;
        // spreadSheet[row][col] = value;
        spreadSheet.put(cell,value);
    }
    
    public void resetCell(String cell) {
        //   int col = (int)(cell.charAt(0)-'A');
        // int row = Integer.parseInt(cell.substring(1))-1;
        // spreadSheet[row][col] = 0;
        spreadSheet.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        //System.out.println(parts[0]+" "+parts[1]);

        int val1 = !Character.isDigit(parts[0].charAt(0)) ?(spreadSheet.containsKey(parts[0]) ? spreadSheet.get(parts[0]) : 0): Integer.parseInt(parts[0]);
        int val2 = !Character.isDigit(parts[1].charAt(0)) ? (spreadSheet.containsKey(parts[1]) ? spreadSheet.get(parts[1]) : 0) : Integer.parseInt(parts[1]);
        return val1 + val2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */