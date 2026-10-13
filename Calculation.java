// Автор: Прасков Дмитрий ИВТ-25
// Задача №11_D
//TODO: Добавить try для модуля

package ZabGU;

public class Calculation{ // модуль, который нахоидит выражения по формулам
	
	
	/// Функция, которая отвечает за автоматическое тестирование функций через assert
	// Параметров нет
	// Ничего не возвращает
	static void check(){
		/// Проверка функции solve_a
		// assert - встроенное ключевое слово для проверки условий, которые всегда должны быть истинными во время работы программы
		
		// 1) проверим x = 0; y = 0
		assert Math.abs(solve_a(0, 0) - 3.4641016151) < 1e-6;
		
		// 2) проверим табличные значения x = pi/6; y = pi/2
		assert Math.abs(solve_a(Math.PI / 6, Math.PI / 2) - 1.3333333333) < 1e-6;
		
		// 3) проверим простую точку x = pi/6; y=0
		assert Math.abs(solve_a(Math.PI / 6, 0) - 4.0) < 1e-6;

		/// Проверка функции solve_b
		
		// 1) проверим z = 0
		assert Math.abs(solve_b(0) - 1.0) < 1e-6;
		
		// 2) проверим z = 1 (конечная дробь)
		assert Math.abs(solve_b(1) - 1.3125) < 1e-6;
		
		// 3) проверим z = 2 (убедиться, что возведение в квадрат происходит)
		assert Math.abs(solve_b(2) - 2.0526315789) < 1e-6;
		
		// 4) проверим z = 500 (поведение функции при больших значениях)
		/// Для больших значений возьмем точность порядка 10^-3
		assert Math.abs(solve_b(500) - 5.9997) < 1e-3;
		
		
	}
	
	/// Функция, которая считает первое выражение
	// Параметры функции: x, y типа данных double
	// Возвращает значение a типа данных double
	static double solve_a(double x, double y){
	
	if (!Double.isFinite(x)){
		throw new IllegalArgumentException("Параметр x должен быть конечным числом " + x);
	}
	if (!Double.isFinite(y)){
		throw new IllegalArgumentException("Параметр y должен быть конечным числом " + y);
	}
	
	// Класс Math содержит набор базовых математических операций, константы (например число Пи)
	double a = 2 * Math.cos(x - Math.PI / 6) / (0.5 + Math.pow(Math.sin(y), 2));	
 
 	if (!Double.isFinite(a)){
		throw new ArithmeticException("Результат a должен быть конечным числом " + a);
	}
 
	return a;
	}
	
	/// Функция, которая считает второе выражение
	// Параметры функции: z типа данных double
	// Возвращает значение b типа данных double
	static double solve_b(double z){
		
	if (!Double.isFinite(z)){
		throw new IllegalArgumentException("Параметр z должен быть конечным числом " + z);
	}
		
	double b = 1 + (Math.pow(z, 2)) / (3 + Math.pow(z, 2) / 5);	
	
 	if (!Double.isFinite(b)){
		throw new ArithmeticException("Результат b должен быть конечным числом " + b);
	}
	
	return b;
	
	}
	
}