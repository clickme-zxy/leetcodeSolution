/* 解法1：
    搜索独立图的个数 DFS
    空间复杂度O（M*n）
    时间复杂度O（m*n)
    解法2：
    合并集合 并查集（实际上没有方法1简单啦，可以参考一下并查集）
* */
public class Number200 {
    boolean [][] visit;
    int [][] num={{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands1(char[][] grid) {
        //初始化
        visit=new boolean[grid.length][grid[0].length];
        int number=0;
        // DFS遍历
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'&&!visit[i][j]){
                    DFS(i,j,grid);
                    number++;
                }
            }
        }
        return number;
    }
    public void DFS(int x,int y,char [][] grid){
        visit[x][y]=true;
        for (int[] ints : num) {
            int a = x + ints[0], b = y + ints[1];
            if (a >= 0 && b >= 0 && a < grid.length && b < grid[0].length) {
                if (grid[a][b] == '1' && !visit[a][b]) {
                    DFS(a, b, grid);
                }
            }
        }
    }
}
