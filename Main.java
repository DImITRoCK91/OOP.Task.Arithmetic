// Автор: Прасков Дмитрий ИВТ-25
// Задача №11_D
package ZabGU; // пакеты позволяют организовать классы логически в наборы, позволяет избежать ошибок между имен классами

import java.util.Scanner; // Добавление класса для ввода данных
import java.util.InputMismatchException;


public class Main { // Объявление класса, в Java всё находится внутри классов. public - значит класс доступен извне, "N11_D" - имя класса, должно совпадать с именем файла
	
	public static void main(String[] args){ // Главный метод, String[] args - массив строк, переданных при запуске программы 
	
	//  проверка, был ли введены аргументы для вывода справки
	if (args.length > 0 && (args[0].equals("help") || args[0].equals("--help"))){
		printhelp();
		return;
	}
	
	Calculation.check(); // запускаем проверки
	
	// переменные, которые будут переданы в функции для вычислений
	double x,y,z;
	// переменные для получения значения из функций
	double q=0.0, s=0.0;
	
	if (args.length >= 3){
		try{
			// Принимает текст и преобразует в число double
			x = Double.parseDouble(args[0]);
			y = Double.parseDouble(args[1]);
			z = Double.parseDouble(args[2]);
		} catch (NumberFormatException e){
            System.out.println("Ошибка: аргументы должны быть числами.");
            System.out.println("Используйте 'help' или '--help' для получения справки.");
			return;
		}
		
		
	}
	
	// Если аргументы не переданы, то запрашиваем данные через Scanner
	else if (args.length == 0){
	
	Scanner in = new Scanner(System.in); // Создание объекта для ввода с клавиатуры
	
	// println - выводит значение и переводит курсор на новую строку
	System.out.println("Введите значения x, y, z:");

	
	// Объект in, который мы создали в Scanner in, отвечает за чтение данных
	// .nextDouble() - специальный метод класса Scanner, который заставляет программу остановиться, ждать, пока пользователь не введёт число и не нажмёт Enter
	// затем преобразует ввод в тип double
	try{
	x = in.nextDouble();
	y = in.nextDouble();
	z = in.nextDouble();
	} catch(InputMismatchException e){
		System.out.println("Ошибка: введите числа");
		// освобождаем ресурсы после использования
		in.close();
		return;
		
	}
	in.close();
	
	}
	// если передано 1 или 2 аргумента
	else{
        System.out.println("Ошибка: необходимо передать 3 аргумента (x, y, z) или не передавать их вовсе.");
        System.out.println("Используйте 'help' или '--help' для получения справки.");
        return;
	}
	q = Calculation.solve_a(x, y); // обращаемся к файлу "Calculation", а затем к функциям в этом модуле
	s = Calculation.solve_b(z);
	
	System.out.printf("Ответ под буквой a: %.4f \n", q); // printf - форматированный вывод как в C
	System.out.printf("Ответ под буквой b: %.4f \n", s);
	}
	
	// инкапсуляция - правило, давай объекту ровно столько прав, сколько нужно
	// private, public - модификаторы
	// private - метод нужен только внутри класса
	// public - метод нужен другим классам
	private static void printhelp(){
		System.out.println("  Справка:");
		System.out.println("  java Main                - ввод данных через консоль");
        System.out.println("  java Main <x> <y> <z>    - передача значений через аргументы");
        System.out.println("  java Main help           - вывод этой справки");
        System.out.println("  java Main --help         - вывод этой справки");
	}
}