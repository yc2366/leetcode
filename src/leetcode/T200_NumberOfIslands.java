package leetcode;

public class T200_NumberOfIslands {
	public int numIslands(char[][] grid) {
       int r = grid.length;
       if(r < 1) return 0;
       int c = grid[0].length;
       int count = 0;
    
       for(int i = 0; i < r; i++){
           for(int j = 0; j < c; j++){
               if(grid[i][j] == '1' ){
                   DFS(grid, i, j);
                   count++;
               } 
           }
       }
       return count;
    } 
    private void DFS(char[][] grid, int r, int c){
        if(r<0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') 
            return;
        grid[r][c] = '0';
        DFS(grid, r-1, c);//above
        DFS(grid, r+1, c);//below
        DFS(grid, r, c-1);//left
        DFS(grid, r, c+1);//right
    }
}
