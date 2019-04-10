package study.acmicpc.samsung; //큐빙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Num5373 {
    private static int testCaseCount;
    private static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
    private static final int PLUS = 0, MINUS = 1;
    private static List<Rotation>[] rotationListArr; //testCaseCount 크기
    private static Cube[][][] rubix;
    private static final int[][] DIRECTION = {{3,5,2,4}, {5,3,4,2}, {0,5,1,4}, {5,0,4,1}, {0,2,1,3}, {2,0,3,1}};

    public static void main(String[] args) throws IOException {
        Initializer.init();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < testCaseCount; i++){
            Initializer.rubixInit();
            //rotation을 보면서 큐브 돌리기 수행
            List<Rotation> rotationList = rotationListArr[i];
            for(Rotation rotation : rotationList){
                rotationing(rotation.side, rotation.direction);
            }
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    sb.append(rubix[0][j][k].colors[U]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }

    private static void rotationing(int side, int direction){
        // side와 direction을 받는다.
                // 방향값 변경
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Cube cube = null;
                switch (side){
                    case U:
                        cube = rubix[0][i][j];
                        break;
                    case D:
                        cube = rubix[2][i][j];
                        break;
                    case F:
                        cube = rubix[i][2][j];
                        break;
                    case B:
                        cube = rubix[i][0][j];
                        break;
                    case L:
                        cube = rubix[i][j][0];
                        break;
                    case R:
                        cube = rubix[i][j][2];
                        break;
                }
//                        cube.switchingSide(DIRECTION[side][k], DIRECTION[side][((k + 1) % 4)]);
                if(direction == PLUS) {
                    String tempColor = cube.colors[DIRECTION[side][3]];
                    for (int k = 3; k > 0; k--) {
                        cube.colors[DIRECTION[side][k]] = cube.colors[DIRECTION[side][k-1]];
                    }
                    cube.colors[DIRECTION[side][0]] = tempColor;
                }
                else {
                    String tempColor = cube.colors[DIRECTION[side][0]];
                    for (int k = 0; k <= 2; k++) {
                        cube.colors[DIRECTION[side][k]] = cube.colors[DIRECTION[side][k+1]];
                    }
                    cube.colors[DIRECTION[side][3]] = tempColor;
                }
            }
        }
        Cubes.switchingPosition(rubix, direction, side);
    }


    static class Color{
        int side;
        String name;
        Color(String name, int side){
            this.name = name;
            this.side = side;
        }
    }
    static class Cube{
        String[] colors;

        Cube(Color... colors){
            this.colors = new String[6];
            for(Color color : colors){
                this.colors[color.side] = color.name;
            }
        }

        void switchingSide(int beforeSide, int afterSide){
            String tempColor = colors[beforeSide];
            colors[beforeSide] = colors[afterSide];
            colors[afterSide] = tempColor;
        }
    }

    static class Cubes{
        static void switchingPosition(Cube[][][] rubix, int direction, int side){
            //
            Cube[][] tempSideRubix = new Cube[3][];
            for(int i = 0; i < 3; i++){
                tempSideRubix[i] = new Cube[3];
                for(int j = 0; j < 3; j++){
                    tempSideRubix[i][j] = new Cube();
                }
            }
            if(direction == MINUS){ //plus 방향이 아니면
                switch (side){
                    case U:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[0][i][j];
                            }
                        }
                        break;
                    case D:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[2][i][j];
                            }
                        }
                        break;
                    case F:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[i][2][j];
                            }
                        }
                        break;
                    case B:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[i][0][j];
                            }
                        }
                        break;
                    case L:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[i][j][0];
                            }
                        }
                        break;
                    case R:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[i][j][2];
                            }
                        }
                        break;
                }
            }else if(direction == PLUS){
                switch (side){
                    case U:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[0][i][j];
                            }
                        }
                        break;
                    case D:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[2][i][j];
                            }
                        }
                        break;
                    case F:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[i][2][j];
                            }
                        }
                        break;
                    case B:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[i][0][j];
                            }
                        }
                        break;
                    case L:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[j][-1*i+2] = rubix[i][j][0];
                            }
                        }
                        break;
                    case R:
                        for(int i = 0; i < 3; i++){
                            for(int j = 0; j < 3; j++){
                                tempSideRubix[-1*j+2][i] = rubix[i][j][2];
                            }
                        }
                        break;
                }
            }
            //넣어주기
            switch (side){
                case U:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[0][i][j] = tempSideRubix[i][j];
                        }
                    }
                    break;
                case D:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[2][i][j] = tempSideRubix[i][j];
                        }
                    }
                    break;
                case F:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[i][2][j] = tempSideRubix[i][j];
                        }
                    }
                    break;
                case B:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[i][0][j] = tempSideRubix[i][j];
                        }
                    }
                    break;
                case L:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[i][j][0] = tempSideRubix[i][j];
                        }
                    }
                    break;
                case R:
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            rubix[i][j][2] = tempSideRubix[i][j];
                        }
                    }
                    break;
            }

        }
    }

    static class Rotation{
        int side;
        int direction;
        Rotation(int side, int direction){
            this.side = side;
            this.direction = direction;
        }
    }
    static class Initializer{
        private static void init() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            testCaseCount = Integer.parseInt(br.readLine());

            rotationListArr = new ArrayList[testCaseCount];

            Map<String, Integer> tempMap = new HashMap<>();
            tempMap.put("U", 0);
            tempMap.put("D", 1);
            tempMap.put("F", 2);
            tempMap.put("B", 3);
            tempMap.put("L", 4);
            tempMap.put("R", 5);
            tempMap.put("+", 0);
            tempMap.put("-", 1);

            for(int i = 0; i < testCaseCount; i++){
                int count = Integer.parseInt(br.readLine());
                String[] split = br.readLine().split(" ");
                rotationListArr[i] = new ArrayList<>();
                for(int j = 0; j < count; j++){
                    String[] split2 = split[j].split("");
                    String side = split2[0];
                    String direction = split2[1];
                    Rotation rotation = new Rotation(tempMap.get(side), tempMap.get(direction));
                    rotationListArr[i].add(rotation);
                }
            }

            rubix = new Cube[3][][];
            for(int i = 0; i < 3; i++){
                rubix[i] = new Cube[3][];
                for(int j = 0; j < 3; j++){
                    rubix[i][j] = new Cube[3];
                    for(int k = 0; k < 3; k++){
                        rubix[i][j][k] = new Cube();
                    }
                }
            }

            //초기화
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    rubix[0][i][j].colors[U] = "w";
                    rubix[2][i][j].colors[D] = "y";
                    rubix[i][2][j].colors[F] = "r";
                    rubix[i][0][j].colors[B] = "o";
                    rubix[i][j][0].colors[L] = "g";
                    rubix[i][j][2].colors[R] = "b";
                }
            }

//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j < 3; j++){
//                for(int k = 0; k < 3; k++){
//                    sb.append(rubix[0][j][k].colors[U]);
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb.toString());

        }
        private static void rubixInit(){
            rubix = new Cube[3][][];
            for(int i = 0; i < 3; i++){
                rubix[i] = new Cube[3][];
                for(int j = 0; j < 3; j++){
                    rubix[i][j] = new Cube[3];
                    for(int k = 0; k < 3; k++){
                        rubix[i][j][k] = new Cube();
                    }
                }
            }
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    rubix[0][i][j].colors[U] = "w";
                    rubix[2][i][j].colors[D] = "y";
                    rubix[i][2][j].colors[F] = "r";
                    rubix[i][0][j].colors[B] = "o";
                    rubix[i][j][0].colors[L] = "g";
                    rubix[i][j][2].colors[R] = "b";
                }
            }
        }
    }

}
