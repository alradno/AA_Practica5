public class Main {

    public static void main(String[] args) {
        int x = 15;
        int y = 10;

        int n = f(x, y);
        System.out.println("Original profe: "+n);

        n = f2(x, y);
        System.out.println("Nuestro: "+n);

        n = f2Tab(x, y);
        System.out.println("NuestroTab: "+n);

        int [][] tabla = f2Tab2(x, y);
        System.out.println();
        System.out.println();
        for(int i=0; i<tabla.length; i++){
            for(int j=0; j<tabla[i].length; j++){
                System.out.print(tabla[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int f(int x, int y) {
        if (y == 0)
            return x;
        else
            return f(x, y - 1) + f(x + 1, y - 1);
    }
    // x >y => y+1*y+1
    public static int f2(int x, int y) {
        int[][] tabla = new int[y + 1][y + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= y; j++) {
                tabla[i][j] = -1;
            }
        }
        int x2 = x;
        f2Mem(x, y, tabla, x2);
        return tabla[x-x2][y];
    }

    public static void f2Mem(int x, int y, int[][] tabla, int x2) {
        if ((tabla[x-x2][y] == -1)) {
            if(y==0){
                tabla[x-x2][y] = x;
            }
            else {
                f2Mem(x, y - 1, tabla, x2);
                f2Mem(x + 1, y - 1, tabla, x2);
                tabla[x-x2][y] = tabla[x-x2][y - 1] + tabla[x-x2+1][y - 1];
            }
        }
    }
    //1*1 -> 0 huecos
    //2*2 -> 1 hueco
    //3*3 -> 3 huecos
    //4*4 -> 6 huecos
    //5*5 -> 10 huecos
    //6*6 -> 15 huecos ----- 5
    //7*7 -> 21 huecos
    //8*8 -> 28 huecos
    //9*9 -> 36 huecos
    //10*10 -> 45 huecos
//Formula que describe lo anterior: (y*(y-1))/2   ((y+1)*y)/2    ((y+1)*(y+1)) - (y+1)-y-((y+1)*y)/2

    //Formula repetidos:
    //3*3 -> 1 repetidos
    //4*4 -> 3 repetidos
    //5*5 -> 6 repetidos
    //6*6 -> 10 repetidos
    //7*7 -> 15 repetidos
    //8*8 -> 21 repetidos
    //9*9 -> 28 repetidos


    public static int f2Tab(int x, int y) {
        int [][] tabla = new int[y+1][y+1];
        int x2 = x;
        int suma = 1;
        for(int i=0; i<=y; i++){
            tabla[i][0] = x2;
            x2++;
        }
        int y2 = y;
        for(int i=0; i<=y; i++){
            for(int j=1; j<=y2; j++){
                tabla[i][j] = tabla[i][j-1]*2+suma;
                suma=suma*2;
            }
            y2--;
            suma = 1;
        }
        return tabla[0][y];
    }

    public static int[][] f2Tab2(int x, int y) {
        int [][] tabla = new int[y+1][y+1];
        int x2 = x;
        int suma = 1;
        for(int i=0; i<=y; i++){
            tabla[i][0] = x2;
            x2++;
        }
        int y2 = y;
        for(int i=0; i<=y; i++){
            for(int j=1; j<=y2; j++){
                tabla[i][j] = tabla[i][j-1]*2+suma;
                suma=suma*2;
            }
            y2--;
            suma = 1;
        }
        return tabla;
    }

    //15 31 64
    //15 31 64 132
    //15 31 64 132 272
    //15 31 64 132 272 560
    //15 31 64 132 272 560 1152
    //15 31 64 132 272 560 1152 2368
    //15 31 64 132 272 560 1152 2368 4864
    //15 31 64 132 272 560 1152 2368 4864 9984
    //15 31 64 132 272 560 1152 2368 4864 9984 20480

    //tabla[0][0] = 15
    //tabla[0][1] = 31
    //tabla[0][2] = 64
    //tabla[0][3] = 132
    //tabla[0][4] = 272
    //tabla[0][5] = 560
    //tabla[0][6] = 1152
    //tabla[0][7] = 2368
    //tabla[0][8] = 4864
    //tabla[0][9] = 9984
    //tabla[0][10] = 20480

    //tabla [1][0] = 16
    //tabla [1][1] = 33
    //tabla [1][2] = 68
    //tabla [1][3] = 140

}