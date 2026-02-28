package programaModulos;

import java.util.Scanner;

public class main {
	private static Scanner scanner;

	public static void main(String[] args) {
	    Scanner menuop = new Scanner(System.in);
	    boolean ejecutando = true;

	    while (ejecutando) {  
	        System.out.println("\nMenu principal");
	        System.out.println("Elija una opcion");
	        System.out.println("1. Calculadora basica");
	        System.out.println("2. Validacion de contrasena");
	        System.out.println("3. Numeros primos");
	        System.out.println("4. Suma de numeros pares");
	        System.out.println("5. Conversion de temperatura");
	        System.out.println("6. Contador de vocales");
	        System.out.println("7. Calculo factorial");
	        System.out.println("8. Juego de adivinanza");
	        System.out.println("9. Paso por referencia");
	        System.out.println("10. Tabla de multiplicar");
	        System.out.println("Presione 0 para salir.");

	        int menu = leerNumeroEntero(menuop, "Ingrese una opcion: ");
	        
	        // Switch de menu principal
	        switch (menu) {
	            case 1:  calculadora();      break;
	            case 2:  validarContrasena();     break;
	            case 3:  verificarNumeroPrimo();  break;
	            case 4:  sumaNumeroPares();       break;
	            case 5:  conversionTemperatura(); break;
	            case 6:  contadorVocales();       break;
	            case 7:  factorial();             break;
	            case 8:  juegoAdivinanza();       break;
	            case 9:  pasoReferencia();		  break;
	            case 10: tablaMultiplicar() ;     break;
	            case 0:
	                System.out.println("Cerrando el programa");
	                ejecutando = false; 
	                break;
	            default:
	                System.out.println("Opcion invalida. Elige entre 0 y 10.");
	        }
	    }

	    menuop.close();
	}
	
	// Metodos auxiliares, son metodos aparte que hice para dividir tareas en metodos, como por ejemplo validaciones y operaciones
	
	// Metodo de suma
	
	 public static double sumar(double a, double b) {
	        return a + b;
	    }

	 	//Metodo de resta
	 
	    public static double restar(double a, double b) {
	        return a - b;
	    }
	    
	    // Metodo de multiplicacion
	    
	    public static double multiplicar(double a, double b) {
	        return a * b;
	    }
	    
	    // Metodo de division
	    
	    public static double dividir(double a, double b) {
	        if (b == 0) {
	            System.out.println("Error: No se puede dividir entre cero.");
	            return Double.NaN;
	        }
	        return a / b;
	    }

	    //  Leer numero con validacion double 
	    
	    public static double leerNumero(Scanner scanner, String mensaje) {
	        double numero = 0;
	        boolean valido = false;

	        while (!valido) {
	            System.out.print(mensaje);
	            String entrada = scanner.nextLine();
	            try {
	                numero = Double.parseDouble(entrada);
	                valido = true;
	            } catch (NumberFormatException e) {
	                System.out.println("Valor invalido. Ingresa un numero.");
	            }
	        }
	        return numero;
	    }
	    
	    // Metodo para validar numeros enteros
	    
	    public static int leerNumeroEntero(Scanner scanner, String mensaje) {
	        int numero = 0;
	        boolean valido = false;

	        while (!valido) {
	            System.out.print(mensaje);
	            String entrada = scanner.nextLine();
	            try {
	                numero = Integer.parseInt(entrada);
	                valido = true;
	            } catch (NumberFormatException e) {
	                System.out.println("Valor invalido. Ingresa un nmero entero.");
	            }
	        }
	        return numero;
	    }

	    //  Menu de operaciones 
	    
	    public static int leerOperacion(Scanner scanner) {
	        int opcion = 0;
	        boolean valido = false;

	        while (!valido) {
	            System.out.println("\n¿Que operacion deseas realizar?");
	            System.out.println("  1. Suma");
	            System.out.println("  2. Resta");
	            System.out.println("  3. Multiplicacion");
	            System.out.println("  4. Division");
	            System.out.print("Elige una opcion de 1-4: ");

	            String entrada = scanner.nextLine();
	            try {
	                opcion = Integer.parseInt(entrada);
	                if (opcion >= 1 && opcion <= 4) {
	                    valido = true;
	                } else {
	                    System.out.println("Opcion invalida. Elige entre 1 y 4.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Ingresa un numero del 1 al 4.");
	            }
	        }
	        return opcion;
	    }
	    
	    // Metodo para verificar si el numero es primo
	    
	    public static boolean validarPrimo(int numero) {
	        if (numero <= 1) return false; 
	        if (numero == 2) return true;  
	        if (numero % 2 == 0) return false; 

	        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
	            if (numero % i == 0) {
	                return false; 
	            }
	        }
	        return true;
	    }
	    
	    //Metodo para convertir Celsius a Fahrenheit
	    
	    public static double celsiusAFahrenheit(double celsius) {
	        return (celsius * 9.0 / 5.0) + 32;
	    }
	    
	    //Metodo para convertir Fahrenheit a Celsius
	    
	    public static double fahrenheitACelsius(double fahrenheit) {
	        return (fahrenheit - 32) * 5.0 / 9.0;}
	    
	    //Metodo que detecta y cuenta las vocales
	    
	    public static int contarVocales(String cadena) {
	        int contador = 0;
	        cadena = cadena.toLowerCase(); // 

	        for (int i = 0; i < cadena.length(); i++) {
	            char letra = cadena.charAt(i);
	            if (letra == 'a' || letra == 'e' || letra == 'i' ||
	                letra == 'o' || letra == 'u') {
	                contador++;
	            }
	        }
	        return contador;
	    }
	    
	    //Metodo para calcular un numero factorial, esta es solamente el proceso u operacion
	    
	    public static long calcularFactorial(int numero) {
	        long factorial = 1;

	        for (int i = 2; i <= numero; i++) {
	            factorial *= i; // 
	        }
	        return factorial;
	    }
	    
	  // Metodos que iran en el menu principal, estos son todos los metodos que serán llamados en el switch del menu principal
	    
	  // 1 Metodo del menu de la calculadora
	    
	    public static void calculadora() {
	        Scanner scanner = new Scanner(System.in);
	        boolean funcionando = true;

	        while (funcionando) {
	            System.out.println("\nCALCULADORA");
	            int opcion = leerOperacion(scanner);

	            double num1 = leerNumero(scanner, "\nIngresa el primer numero:  ");
	            double num2 = leerNumero(scanner, "Ingresa el segundo numero: ");

	            double resultado = 0;
	            String operacion = "";

	            switch (opcion) {
	                case 1: resultado = sumar(num1, num2);       operacion = "+"; break;
	                case 2: resultado = restar(num1, num2);      operacion = "-"; break;
	                case 3: resultado = multiplicar(num1, num2); operacion = "×"; break;
	                case 4: resultado = dividir(num1, num2);     operacion = "÷"; break;
	            }

	            if (!Double.isNaN(resultado)) {
	                System.out.printf("  %.2f %s %.2f = %.2f%n", num1, operacion, num2, resultado);
	            }

	            System.out.print("Presione 1 para continuar y 0 para salir: ");
	            String opcionSalir = scanner.nextLine();

	            switch (opcionSalir) {
	                case "1": break;              
	                case "0": funcionando = false; break; 
	                default: System.out.println("Opcion invalida.");
	            }
	        }
	     
	    }
	       
	 //  2 Metodo de validacion de la contraseña
	    
	    public static void validarContrasena() {
	        Scanner scanner = new Scanner(System.in);
	        String contrasena;
	        int intentos = 0;

	        System.out.println("  VALIDACION DE CONTRASEÑA   ");	        

	        do {
	            System.out.print("\nIngresa la contraseña: ");
	            contrasena = scanner.nextLine();
	            intentos++;

	            if (!contrasena.equals("1234")) {
	                System.out.println("Contraseña incorrecta. Intenta de nuevo.");
	            }

	        } while (!contrasena.equals("1234")); 

	        System.out.println("\n¡Acceso concedido!");

	    }
	    
	    // 3 Metodo para verificar numero primo
	    public static void verificarNumeroPrimo() {
	        Scanner scanner = new Scanner(System.in);


	        System.out.println("      NUMEROS PRIMOS      ");

	        int numero = leerNumeroEntero(scanner, "\nIngresa un numero: ");

	        if (validarPrimo(numero)) {
	            System.out.println(" El numero " + numero + " ES primo.");
	        } else {
	            System.out.println(" El numero " + numero + " NO es primo.");
	        }

	    }
	    
	    // 4 Metodo de suma de numeros pares
	    public static void sumaNumeroPares() {
	    	Scanner scanner = new Scanner(System.in); 
	        int sumaPares = 0;

	        System.out.println("SUMA DE NUMEROS PARES");
	        System.out.println("Ingresa numeros enteros. (0 para terminar)");

	        int numero = leerNumeroEntero(scanner, "\nIngresa un numero: ");

	        while (numero != 0) {
	            if (numero % 2 == 0) {
	                sumaPares += numero;
	                System.out.println(numero + " es par. Suma acumulada: " + sumaPares);
	            } else {
	                System.out.println(numero + " es impar, se omite.");
	            }
	            numero = leerNumeroEntero(scanner, "Ingresa un numero: ");
	        }

	        System.out.println("\nLa suma de los numeros pares es: " + sumaPares);
	    }
	    
	    // 5 Metodo de menu para conversion de temperatura
	    public static void conversionTemperatura() {
	        Scanner scanner = new Scanner(System.in);
	        boolean funcionando = true;

	        while (funcionando) {
	            System.out.println("\nCONVERSION DE TEMPERATURA");
	            System.out.println("1. Celsius a Fahrenheit");
	            System.out.println("2. Fahrenheit a Celsius");
	            System.out.println("0. Regresar al menu principal");
	            System.out.print("Elige una opcion: ");

	            String entrada = scanner.nextLine();

	            switch (entrada) {
	                case "1":
	                    double celsius = leerNumero(scanner, "Ingresa la temperatura en Celsius: ");
	                    double fahrenheit = celsiusAFahrenheit(celsius);
	                    System.out.printf("  %.2f °C = %.2f °F%n", celsius, fahrenheit);
	                    break;

	                case "2":
	                    double fahrenheit2 = leerNumero(scanner, "Ingresa la temperatura en Fahrenheit: ");
	                    double celsius2 = fahrenheitACelsius(fahrenheit2);
	                    System.out.printf("  %.2f °F = %.2f °C%n", fahrenheit2, celsius2);
	                    break;

	                case "0":
	                    funcionando = false;
	                    System.out.println("Regresando al menu principal");
	                    break;

	                default:
	                    System.out.println("Opcion invalida. Elige 1, 2 o 0.");
	            }
	        }
	    }
	    
	    // 6 Metodo para mostrar las vocales de la cadena ingresada
	    public static void contadorVocales() {
	        Scanner scanner = new Scanner(System.in);
	        boolean funcionando = true;

	        while (funcionando) {
	            System.out.println("\nCONTADOR DE VOCALES");
	            System.out.print("Ingresa una cadena de texto: ");
	            String cadena = scanner.nextLine();

	            if (cadena.isEmpty()) {
	                System.out.println("La cadena no puede estar vacia.");
	            } else {
	                int vocales = contarVocales(cadena);
	                System.out.println("Texto:   \"" + cadena + "\"");
	                System.out.println("Vocales encontradas: " + vocales);
	            }

	            System.out.print("\n¿Deseas contar otra cadena? 1 = Si, 0 = No ");
	            String opcion = scanner.nextLine();

	            if (opcion.equals("0")) {
	                funcionando = false;
	                System.out.println("Regresando al menu principal...");
	            }
	        }
	    }
	    
	    // 7 Metodo que pide y muestra el factorial
	    public static void factorial() {
	        Scanner scanner = new Scanner(System.in);
	        boolean funcionando = true;

	        while (funcionando) {
	            System.out.println("\nCALCULO FACTORIAL");


	            int numero = leerNumeroEntero(scanner, "Ingresa un numero entero positivo: ");

	            // Valida que no sea negativo
	            if (numero < 0) {
	                System.out.println("El numero no puede ser negativo.");
	            } else {
	                long resultado = calcularFactorial(numero);
	                System.out.println(numero + "! = " + resultado);
	            }

	            System.out.print("\n¿Deseas calcular otro factorial? 1 = Si, 0 = No ");
	            String opcion = scanner.nextLine();

	            if (opcion.equals("0")) {
	                funcionando = false;
	                System.out.println("Regresando al menu principal");
	            }
	        }
	    }
	    
	    // 8 Metodo de juego de adivinanza
	    public static void juegoAdivinanza() {
	        Scanner scanner = new Scanner(System.in);
	        int numeroSecreto = (int) (Math.random() * 100) + 1; 
	        int intento;
	        int intentos = 0;

	        System.out.println("\nJUEGO DE ADIVINANZA");

	        System.out.println("Estoy pensando en un numero entre 1 y 100.");
	        System.out.println("¡Intenta adivinarlo!");

	        do {
	            intento = leerNumeroEntero(scanner, "\nIngresa tu intento: ");
	            intentos++;

	            if (intento < 1 || intento > 100) {
	                System.out.println("Ingresa un numero entre 1 y 100.");
	            } else if (intento < numeroSecreto) {
	                System.out.println("El numero secreto es MAYOR que " + intento);
	            } else if (intento > numeroSecreto) {
	                System.out.println("El numero secreto es MENOR que " + intento);
	            }

	        } while (intento != numeroSecreto); 


	        System.out.println("¡Felicidades! Adivinaste el numero " + numeroSecreto + "!");
	        System.out.println("Lo lograste en " + intentos + " intentos.");
	        System.out.println("Regresando al menu principal");
	    }
	    
	    // 9 Metodo para el paso por referencia
	    public static void pasoReferencia() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("\nPASO POR REFERENCIA");

	        int[] numeros = new int[2];

	        numeros[0] = leerNumeroEntero(scanner, "Ingresa el primer numero:  ");
	        numeros[1] = leerNumeroEntero(scanner, "Ingresa el segundo numero: ");

	        System.out.println("\nAntes del intercambio:");
	        System.out.println("  Numero 1 = " + numeros[0]);
	        System.out.println("  Numero 2 = " + numeros[1]);

	        
	        int temp   = numeros[0];
	        numeros[0] = numeros[1];
	        numeros[1] = temp;

	        System.out.println("\nDespues del intercambio:");
	        System.out.println("  Numero 1 = " + numeros[0]);
	        System.out.println("  Numero 2 = " + numeros[1]);
	    }
	    
	    // 10 Metodo para la tabla de multiplicar
	    public static void tablaMultiplicar() {
	        Scanner scanner = new Scanner(System.in);
	        boolean funcionando = true;

	        while (funcionando) {
	            System.out.println("\nTABLA DE MULTIPLICAR");

	            int numero = leerNumeroEntero(scanner, "Ingresa un numero: ");

	            System.out.println("\nTabla del " + numero + ":");


	            for (int i = 1; i <= 10; i++) {
	                System.out.printf("  %d x %d = %d%n", numero, i, numero * i);
	            }

	            System.out.print("\n¿Deseas ver otra tabla? 1 = Si, 0 = No ");
	            String opcion = scanner.nextLine();

	            if (opcion.equals("0")) {
	                funcionando = false;
	                System.out.println("Regresando al menu principal");
	            }
	        }
	    }
	    
	}

