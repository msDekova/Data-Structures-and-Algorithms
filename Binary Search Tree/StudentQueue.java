/*
В рамките на тази задача ще трябва да реализирате "Студентска опашка" – структура, която максимално наподобява случващото се
пред студентски стол. Когато нов студент се нарежда на опашката, вместо да застане накрая й, той първо претърсва за свои "познати"
в нея и ако открие такива се включва точно зад тях. Ако не намери, студентът е нямал късмет и застава накрая на опашката.

Изключването става по стандартния начин – само от началото на опашката.

Считаме, че времето отнемащо за обслужване на един студент е 2мин, а пък нов студент се нарежда на опашката на всяка минута.
 За определеност, в съвпадащите моменти първо се нарежда новият студент и чак след това първият напуска опашката.

Всеки студент има име - уникален низ от главни и малки латински букви(без интервали) и уникален номер на група - цяло положително
 число. Студентите с еднакъв номер на група определяме като "познати".

Input Format

На първия ред са зададено две числа – N и M - броят на студентите и броят на групите.

Следват N реда с информация за всеки един от студентите. Всеки ред съдържа името и групата на текущия студент. Считаме, че те
идват при опашката точно в реда, в който са въведени.

Constraints

1 ≤ N ≤ 100000

1 ≤ M ≤ 100000

Имената на студентите са с дължина между 1 и 30 символа.

Output Format

Програмата ви трябва да изведе на екрана точния ред, в който студентите ще излязат от опашката. За всеки студент изведете
по един ред, съдържащ неговото име, времето, в което се е наредил на опашката и времето, в което е излязъл.

Sample Input 0

8 666
Ivan 10
Nikolay 10
Vasil 3
Daniel 4
Yoanna 3
Maria 3
Pesho 666
Gosho 10
Sample Output 0

Ivan 0 2
Nikolay 1 4
Vasil 2 6
Yoanna 4 8
Maria 5 10
Daniel 3 12
Pesho 6 14
Gosho 7 16
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StudentQueue {
    static class Student{
        String name;
        int group;
        int startTime;

        Student(String name, int group, int startTime){
            this.name=name;
            this.group=group;
            this.startTime=startTime;
        }
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader bufferedReader=new BufferedReader(read);

        String firstInput=bufferedReader.readLine();
        int numOfStudents=Integer.parseInt(firstInput.split(" ")[0]);
        int numOfGroups=Integer.parseInt(firstInput.split(" ")[1]);

        HashMap<Integer, Queue<Student>> allStudents=new LinkedHashMap<>();

        String input;
        String studentName;
        int studentGroup;
        int finishTime=0;

        for(int i=0;i<numOfStudents;i++){
            finishTime=i;
            input=bufferedReader.readLine();
            studentName=input.split(" ")[0];
            studentGroup=Integer.parseInt(input.split(" ")[1]);

            if(allStudents.containsKey(studentGroup)){
                allStudents.get(studentGroup).add(new Student(studentName,studentGroup,i));
            } else {
                Queue<Student> students=new LinkedList<>();
                students.add(new Student(studentName,studentGroup,i));
                allStudents.put(studentGroup,students);
            }

            if(i!=0 && i%2==0){
                Map.Entry<Integer,Queue<Student>> next=allStudents.entrySet().iterator().next();
                Student currStudent=next.getValue().remove();

                System.out.printf("%s %d %d\n", currStudent.name,currStudent.startTime,finishTime);

                if(next.getValue().size()==0){
                    allStudents.remove(next.getKey());
                }
            }
        }


        Iterator it=allStudents.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Queue<Student>> currStudent=(Map.Entry) it.next();
            Queue<Student> students=currStudent.getValue();

            while (!students.isEmpty()){
                finishTime+=2;
                Student curr=students.peek();
                students.remove();
                System.out.printf("%s %d %d\n",curr.name,curr.startTime,finishTime);

            }
        }

    }
}
