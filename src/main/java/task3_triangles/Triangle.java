package task3_triangles;

/** Сортировка треугольников
    Разработать консольную программу, выполняющую вывод треугольников
    в порядке убывания их площади.
    После добавления каждого нового треугольника программа спрашивает,
    хочет ли пользователь добавить ещё один.
    Если пользователь ответит “y” или “yes” (без учёта регистра),
    программа попросит ввести данные для ещё одного треугольника,
    в противном случае – выводит результат в консоль.

    •Расчёт площади треугольника должны производится по формуле Герона.
    •Каждый треугольник определяется именем и длинами его сторон.
    Формат ввода (разделитель - запятая):
    <имя>, <длина стороны>, <длина стороны>, <длина стороны>
    •Приложение должно обрабатывать ввод чисел с плавающей точкой.
    •Ввод должен быть нечувствителен к регистру, пробелам, табам.
    •Вывод данных должен быть следующем примере:
    ============= Triangles list: ===============
    1. [Triangle first]: 17.23 сm
    2. [Triangle 22]: 13 cm
    3. [Triangle 1]: 1.5 cm
*/

public class Triangle implements Comparable<Triangle>{
    private String name;
    private double square;
    private double sideA, sideB, sideC;

    Triangle (String name, double side){
        this(name, side, side, side);
    }

    Triangle (String name, double sideBase, double sideLeg){
        this(name, sideBase, sideLeg, sideLeg);
    }

    Triangle(String name, double sideA, double sideB, double sideC){
        if ((sideA <= 0) || (sideB <= 0) || (sideC<=0)) {
            throw new IllegalArgumentException("Triangle's sizes must be greater then 0.");
        }
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name couldn't be empty");
        }
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        square = getSquare();
        if (square<=0){
            throw new IllegalArgumentException("You should input correct sizes for triangle's sides.");
        }
    }

    public double getSquare() {
        double halfPerimeter = (sideA + sideB + sideC) / 2.;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    @Override
    public int compareTo(Triangle triangle) {
        if (square<triangle.square){
            return -1;
        }
        else if (square>triangle.square){
            return 1;
        }
        return 0;
    }

    // [Triangle first]: 17.23 сm //a b c
    @Override
    public String toString() {
        return "["+name+"]: "+(int)(square*100)/100.+" cm"+"\t\t\t//"+ sideA +" "+ sideB +" "+ sideC;
    }

    public double getSideA(){
        return sideA;
    }

    public double getSideB(){
        return sideB;
    }

    public double getSideC(){
        return sideC;
    }
}
