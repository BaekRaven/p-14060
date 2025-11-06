package com.back;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //깃허브에 올리기 테스트
        Scanner sc = new Scanner(System.in);
        int totalnum = 0;
        String cmd;
        Map<Integer, WiseSaying> wiseSayingMap = new HashMap<>();
        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.print("명령) ");
            cmd = sc.nextLine().trim();
            if(cmd.equals("등록")){
                WiseSaying wise = new WiseSaying();
                System.out.print("명언 : ");
                wise.say = sc.nextLine();
                System.out.print("작가 : ");
                wise.author = sc.nextLine();
                totalnum++;
                wise.num = totalnum;

                wiseSayingMap.put(totalnum,wise);
                System.out.print(totalnum +"번 명언이 등록되었습니다.\n");
            }
            else if(cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i = totalnum; i> 0; i--){
                    if(wiseSayingMap.containsKey(i)) { //있으면 출력
                        WiseSaying wise = wiseSayingMap.get(i);
                        System.out.println(wise.num+" / "+wise.author+" / "+wise.say);
                    }                    
                }
            }
            else if(cmd.substring(0,2).equals("삭제")){ //앞부분 2개가 삭제면
                String arr[] = cmd.split("=");
                int id = Integer.parseInt(arr[1]);

                if(wiseSayingMap.containsKey(id)) {
                    wiseSayingMap.remove(id);
                    System.out.println(id+"번 명언이 삭제되었습니다.");
                }
                else {
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
                }
            }
            else if(cmd.substring(0,2).equals("수정")){ //앞부분 2개가 수정이면
                String arr[] = cmd.split("=");
                int id = Integer.parseInt(arr[1]);

                if(wiseSayingMap.containsKey(id)) {
                    WiseSaying wise = wiseSayingMap.get(id);
                    System.out.println("명언(기존) : "+wise.say);
                    System.out.print("명언 : ");
                    wise.say = sc.nextLine();
                    System.out.println("작가(기존) : "+wise.author);
                    System.out.print("작가 : ");
                    wise.author = sc.nextLine();
                    wiseSayingMap.replace(id,wise); //수정
                }
                else {
                    System.out.println(id+"번 명언은 존재하지 않습니다.");
                }
            }
            else if(cmd.equals("종료")){
                break;
            }
        }
        sc.close();
    }
}
class WiseSaying {
    int num;
    String say;
    String author;
}
